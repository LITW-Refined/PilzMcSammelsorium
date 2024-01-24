package de.pilz.sammelsorium.mixins;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import de.pilz.sammelsorium.Utils;

@Mixin(EntitySlime.class)
public class EntitySlimeMixin extends EntityLiving {

    public EntitySlimeMixin(World p_i1738_1_) {
        super(p_i1738_1_);
    }

    @Inject(method = "getCanSpawnHere()Z", at = @At("TAIL"), cancellable = true)
    protected void pilzmcsammelsorium$getCanSpawnHere(CallbackInfoReturnable<Boolean> clb) {
        if (Utils.shouldBlockSpawnByLightLevel(this, clb.getReturnValue())) {
            clb.setReturnValue(false);
        }
    }
}
