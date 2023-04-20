package de.pilz.sammelsorium;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

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
}
