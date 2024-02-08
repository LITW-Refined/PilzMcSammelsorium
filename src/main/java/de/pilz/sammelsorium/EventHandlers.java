package de.pilz.sammelsorium;

import java.util.HashMap;

import net.minecraft.entity.monster.IMob;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraftforge.common.ForgeChunkManager.ForceChunkEvent;
import net.minecraftforge.common.ForgeChunkManager.UnforceChunkEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.WorldEvent;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;
import cpw.mods.fml.relauncher.Side;
import de.pilz.sammelsorium.configuration.ExperimentalConfigs;

public class EventHandlers {

    private HashMap<WorldServer, HashMap<ChunkCoordIntPair, Integer>> pendingForcedChunks = new HashMap<>();

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        if (ExperimentalConfigs.disableChunkLoadingOnRequest && !event.world.isRemote) {
            IChunkProvider chunkProvider = event.world.getChunkProvider();
            if (chunkProvider instanceof ChunkProviderServer) {
                ((ChunkProviderServer) chunkProvider).loadChunkOnProvideRequest = false;
            }
        }
    }

    @SubscribeEvent
    public void onChunkForce(ForceChunkEvent event) {
        if (ExperimentalConfigs.disableChunkLoadingOnRequest && ExperimentalConfigs.autoLoadChunksOnTicketCreation
            && !event.ticket.world.isRemote) {
            if (event.ticket.world instanceof WorldServer) {
                // Do not load the chunk instantly to prevent colidation with sync chunk loading and chunkloaders that
                // creates a ticket while loading the chunk.
                var coordMap = getPendingForcedChunksForWorld((WorldServer) event.ticket.world);
                if (!coordMap.containsKey(event.location)) {
                    coordMap.put(event.location, 0);
                }
            }
        }
    }

    @SubscribeEvent
    public void onChunkUnforce(UnforceChunkEvent event) {
        var coordMap = getPendingForcedChunksForWorld((WorldServer) event.ticket.world);
        if (coordMap.containsKey(event.location)) {
            coordMap.remove(event.location);
        }
    }

    @SubscribeEvent
    public void onWorldTick(WorldTickEvent event) {
        if (ExperimentalConfigs.disableChunkLoadingOnRequest && ExperimentalConfigs.autoLoadChunksOnTicketCreation
            && event.side == Side.SERVER
            && event.world instanceof WorldServer) {
            var coordMap = getPendingForcedChunksForWorld((WorldServer) event.world);
            var toRemove = new HashMap<ChunkCoordIntPair, Object>();

            for (ChunkCoordIntPair coords : coordMap.keySet()) {
                Integer ticksWaited = coordMap.get(coords);

                // Wait at least one second (= 20 ticks) before loading forced chunks.
                if (ticksWaited >= 20) {
                    IChunkProvider provider = ((WorldServer) event.world).getChunkProvider();
                    if (!provider.chunkExists(coords.chunkXPos, coords.chunkZPos)) {
                        provider.loadChunk(coords.chunkXPos, coords.chunkZPos);
                    }
                    toRemove.put(coords, null);
                } else {
                    coordMap.put(coords, ticksWaited + 1);
                }
            }

            for (ChunkCoordIntPair coords : toRemove.keySet()) {
                coordMap.remove(coords);
            }
        }
    }

    private HashMap<ChunkCoordIntPair, Integer> getPendingForcedChunksForWorld(WorldServer world) {
        if (!pendingForcedChunks.containsKey(world)) {
            pendingForcedChunks.put(world, new HashMap<>());
        }
        return pendingForcedChunks.get(world);
    }

    @SubscribeEvent
    public void onCheckSpawn(LivingSpawnEvent.CheckSpawn event) {
        if ((event.entityLiving instanceof IMob) && event.getResult() != Result.DENY) {
            if (Utils.shouldBlockSpawnByLightLevel(event.entityLiving)) {
                event.setResult(Result.DENY);
            }
        }
    }
}
