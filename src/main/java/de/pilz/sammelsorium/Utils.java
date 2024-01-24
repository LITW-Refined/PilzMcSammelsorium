package de.pilz.sammelsorium;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;

public class Utils {

    public static boolean canPlantOn(Block block) {
        /*
         * if (ModManagement.isModInstalled(ModManagement.MOD_GARDENCORE) && (block ==
         * ModManagement.block_GardenCore_GardenFarmland || block == ModManagement.block_GardenCore_GardenSoil)) {
         * return true; } else
         */ if (block == Blocks.farmland) {
            return true;
        }
        return false;
    }

    public static boolean shouldBlockSpawnByLightLevel(EntityLivingBase creature, boolean currentValue) {
        if (Config.spawnLightLevelModificationEnable && currentValue
                && allowLightLevelSpawnInThisDimension(creature.worldObj.provider.dimensionId)) {
            int x = MathHelper.floor_double(creature.posX);
            int y = MathHelper.floor_double(creature.boundingBox.minY);
            int z = MathHelper.floor_double(creature.posZ);

            if (creature.worldObj.getBlockLightValue(x, y, z) > Config.spawnLightLevelModificationValue) {
                return true;
            }
        }

        return false;
    }

    private static Boolean allowLightLevelSpawnInThisDimension(int dimensionID) {
        for (final int dID : Config.spawnLightLevelModificationDimensionBlackList) {
            if (dID == dimensionID) return false;
        }
        return true;
    }
}
