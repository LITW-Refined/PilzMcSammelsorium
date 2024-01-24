package de.pilz.sammelsorium.mixins;

import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import de.pilz.sammelsorium.Utils;

@Mixin(EntityBlaze.class)
public abstract class EntityBlazeMixin extends EntityMob {

    public EntityBlazeMixin(World p_i1738_1_) {
        super(p_i1738_1_);
    }

    @Inject(method = "isValidLightLevel()Z", at = @At("TAIL"), cancellable = true)
    protected void pilzmcsammelsorium$isValidLightLevel(CallbackInfoReturnable<Boolean> clb) {
        if (Utils.shouldBlockSpawnByLightLevel(this, clb.getReturnValue())) {
            clb.setReturnValue(false);
        }
    }
}
