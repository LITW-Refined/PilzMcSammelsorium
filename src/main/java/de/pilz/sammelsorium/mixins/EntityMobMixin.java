package de.pilz.sammelsorium.mixins;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import de.pilz.sammelsorium.Utils;

@Mixin(EntityMob.class)
public abstract class EntityMobMixin extends EntityCreature {

    public EntityMobMixin(World p_i1738_1_) {
        super(p_i1738_1_);
    }

    // @Shadow // Not possible for member from a super class!
    // public double posX;

    // @Shadow // Not possible for member from a super class!
    // public double posZ;

    // @Final
    // @Shadow // Not possible for member from a super class!
    // public AxisAlignedBB boundingBox;

    // @Shadow // Not possible for member from a super class!
    // public World worldObj;

    @Inject(method = "isValidLightLevel()Z", at = @At("TAIL"), cancellable = true)
    protected void pilzmcsammelsorium$isValidLightLevel(CallbackInfoReturnable<Boolean> clb) {
        if (Utils.shouldBlockSpawnByLightLevel(this, clb.getReturnValue())) {
            clb.setReturnValue(false);
        }
    }
}