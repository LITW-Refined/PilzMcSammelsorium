package de.pilz.sammelsorium;

import net.minecraft.block.Block;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModManagement {

    public static final String MOD_GARDENCORE = "GardenCore";
    public static final String BLOCK_GARDENCORE_GARDENFARMLAND = "garden_farmland";
    public static final String BLOCK_GARDENCORE_GARDENSOIL = "garden_soil";

    public static Block block_GardenCore_GardenFarmland = null;
    public static Block block_GardenCore_GardenSoil = null;

    public static boolean isModInstalled(String modName) {
        return FMLCommonHandler.instance().getModName().contains(modName);
    }

    public static void findModItems() {
        block_GardenCore_GardenFarmland = GameRegistry.findBlock(MOD_GARDENCORE, BLOCK_GARDENCORE_GARDENFARMLAND);
        block_GardenCore_GardenSoil = GameRegistry.findBlock(MOD_GARDENCORE, BLOCK_GARDENCORE_GARDENSOIL);
    }
}
