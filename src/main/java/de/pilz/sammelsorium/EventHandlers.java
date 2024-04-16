package de.pilz.sammelsorium;

import net.minecraft.entity.monster.IMob;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandlers {

    @SubscribeEvent
    public void onCheckSpawn(LivingSpawnEvent.CheckSpawn event) {
        if ((event.entityLiving instanceof IMob) && event.getResult() != Result.DENY) {
            if (Utils.shouldBlockSpawnByLightLevel(event.entityLiving)) {
                event.setResult(Result.DENY);
            }
        }
    }
}
