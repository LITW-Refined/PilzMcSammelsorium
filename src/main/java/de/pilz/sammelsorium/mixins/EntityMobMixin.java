package de.pilz.sammelsorium.mixins;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import de.pilz.sammelsorium.Config;

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

    @Inject(method = "isValidLightLevel()Z", at = @At("RETURN"), cancellable = true)
    protected void pilzmcsammelsorium$isValidLightLevel(CallbackInfoReturnable<Boolean> clb) {
        if (!Config.spawnLightLevelModificationEnable || !clb.getReturnValue()) return;

        if (allowInThisDimension(worldObj.provider.dimensionId)) {
            int x = MathHelper.floor_double(this.posX);
            int y = MathHelper.floor_double(this.boundingBox.minY);
            int z = MathHelper.floor_double(this.posZ);

            if (this.worldObj.getBlockLightValue(x, y, z) > Config.spawnLightLevelModificationValue) {
                clb.setReturnValue(false);
            }
        }
    }

    private static Boolean allowInThisDimension(int dimensionID) {
        for (final int dID : Config.spawnLightLevelModificationDimensionBlackList) {
            if (dID == dimensionID) return false;
        }
        return true;
    }
}
