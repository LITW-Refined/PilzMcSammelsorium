package de.pilz.sammelsorium;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModManagement {

    public static final String MOD_GARDENCORE = "GardenCore";
    public static final String MOD_AE2 = "appliedenergistics2";

    public static final String BLOCK_GARDENCORE_GARDENFARMLAND = "garden_farmland";
    public static final String BLOCK_GARDENCORE_GARDENSOIL = "garden_soil";

    public static final String ITEM_AE2_MULTIMATERIAL = "item.ItemMultiMaterial";

    public static Block block_GardenCore_GardenFarmland = null;
    public static Block block_GardenCore_GardenSoil = null;
    public static Item item_AE2_MultiMaterial = null;

    public static boolean isModInstalled(String modName) {
        return Loader.isModLoaded(modName);
    }

    public static void findModItems() {
        block_GardenCore_GardenFarmland = GameRegistry.findBlock(MOD_GARDENCORE, BLOCK_GARDENCORE_GARDENFARMLAND);
        block_GardenCore_GardenSoil = GameRegistry.findBlock(MOD_GARDENCORE, BLOCK_GARDENCORE_GARDENSOIL);
        item_AE2_MultiMaterial = GameRegistry.findItem(MOD_AE2, ITEM_AE2_MULTIMATERIAL);
    }
}
