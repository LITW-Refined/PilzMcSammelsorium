package de.pilz.sammelsorium;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import de.pilz.sammelsorium.blocks.*;
import de.pilz.sammelsorium.items.ItemCropsRedstone;
import de.pilz.sammelsorium.items.ItemFlowersRedstone;
import de.pilz.sammelsorium.items.blocks.*;
import de.pilz.sammelsorium.strings.BlockNames;
import de.pilz.sammelsorium.strings.ItemNames;

public class RegisterManagement {

    public static Block blockSeaLantern = new BlockSeaLantern();
    public static Block blockCropsRedstone = new BlockCropsRedstone();

    public static Item itemCropsRedstone = new ItemCropsRedstone();
    public static Item itemFlowerRedstone = new ItemFlowersRedstone();

    public static void RegisterAllItems() {
        GameRegistry.registerItem(itemCropsRedstone, ItemNames.CROPS_REDSTONE);
        GameRegistry.registerItem(itemFlowerRedstone, ItemNames.FLOWERS_REDSTONE);
    }

    public static void RegisterAllBlocks() {
        GameRegistry.registerBlock(blockSeaLantern, ItemBlockSeaLantern.class, BlockNames.SEA_LANTERN);
        GameRegistry.registerBlock(blockCropsRedstone, ItemBlockSeaLantern.class, BlockNames.CROPS_REDSTONE);
    }
}
