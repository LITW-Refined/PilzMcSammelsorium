package de.pilz.sammelsorium;

import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraftforge.common.ForgeChunkManager.ForceChunkEvent;
import net.minecraftforge.event.world.WorldEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandlers {

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        if (Config.disableChunkLoadingOnRequest && !event.world.isRemote) {
            IChunkProvider chunkProvider = event.world.getChunkProvider();
            if (chunkProvider instanceof ChunkProviderServer) {
                ((ChunkProviderServer) chunkProvider).loadChunkOnProvideRequest = false;
            }
        }
    }

    @SubscribeEvent
    public void onChunkForce(ForceChunkEvent event) {
        if (Config.disableChunkLoadingOnRequest && Config.autoLoadChunksOnTicketCreation
                && !event.ticket.world.isRemote) {
            if (event.ticket.world instanceof WorldServer) {
                ((WorldServer) event.ticket.world).getChunkProvider()
                        .loadChunk(event.location.chunkXPos, event.location.chunkZPos);
            }
        }
    }
}
