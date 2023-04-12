package de.pilz.sammelsorium;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraftforge.event.world.WorldEvent;

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
}
