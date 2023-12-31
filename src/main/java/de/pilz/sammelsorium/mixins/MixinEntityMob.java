package de.pilz.sammelsorium.mixins;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import de.pilz.sammelsorium.MyMod;

@Mixin(EntityMob.class)
public abstract class MixinEntityMob {

    @Shadow
    public double posX;

    @Shadow
    public double posZ;

    @Final
    @Shadow
    public AxisAlignedBB boundingBox;

    @Shadow
    public World worldObj;

    @Inject(method = "isValidLightLevel", at = @At("RETURN"), cancellable = true)
    protected void pilzmcsammelsorium_isValidLightLevel(CallbackInfoReturnable<Boolean> clb) {
        MyMod.LOG.info("MIXINSUCCESS!!!");

        if (!clb.getReturnValue()) return;

        int x = MathHelper.floor_double(this.posX);
        int y = MathHelper.floor_double(this.boundingBox.minY);
        int z = MathHelper.floor_double(this.posZ);

        if (this.worldObj.getBlockLightValue(x, y, z) > 0) {
            clb.setReturnValue(false);
        }
    }
}
