package de.pilz.sammelsorium;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryManagement {

    public static final String ORE_ITEM_CLAY = "itemClay";
    public static final String ORE_DYE_RED = "dyeRed";
    public static final String ORE_DUST_GLOWSTONE = "dustGlowstone";
    public static final String ORE_LIST_ALLSEED = "listAllseed";

    public static final String ORE_SHARD_PRISMARINE = "shardPrismarine";
    public static final String ORE_CRYSTAL_PRISMARINE_RAW = "crystalPrismarineRaw";
    public static final String ORE_CRYSTAL_PRISMARINE = "crystalPrismarine";

    public static void RegisterOres() {
        if (Config.enablePrismarine) {
            OreDictionary.registerOre(ORE_SHARD_PRISMARINE, RegisterManagement.itemStackPrismarineShard);
            OreDictionary.registerOre(ORE_CRYSTAL_PRISMARINE_RAW, RegisterManagement.itemStackPrismarineCrystalRaw);
            OreDictionary.registerOre(ORE_CRYSTAL_PRISMARINE, RegisterManagement.itemStackPrismarineCrystal);
        }
        if (Config.enableRedstoneFlower) {
            OreDictionary.registerOre(ORE_LIST_ALLSEED, RegisterManagement.itemCropsRedstone);
        }
    }

    public static void RegisterModOres() {
        if (ModManagement.isModInstalled(ModManagement.MOD_AE2)) {
            if (ModManagement.item_AE2_MultiMaterial != null) {
                ItemStack itemStackCleanNetherQuartzCrystal = new ItemStack(
                        ModManagement.item_AE2_MultiMaterial,
                        1,
                        11);
                OreDictionary.registerOre("gemQuartz", itemStackCleanNetherQuartzCrystal);
                OreDictionary.registerOre("crystalNetherQuartz", itemStackCleanNetherQuartzCrystal);
            }
        }
    }
}
