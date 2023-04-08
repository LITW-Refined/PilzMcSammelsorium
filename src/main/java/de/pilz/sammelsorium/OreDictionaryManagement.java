package de.pilz.sammelsorium;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryManagement {

    public static final String ORE_DYE_RED = "dyeRed";
    public static final String ORE_DUST_GLOWSTONE = "dustGlowstone";

    public static final String ORE_SHARD_PRISMARINE = "shardPrismarine";
    public static final String ORE_CRYSTAL_PRISMARINE_RAW = "crystalPrismarineRaw";
    public static final String ORE_CRYSTAL_PRISMARINE = "crystalPrismarine";

    public static void RegisterOres() {
        OreDictionary.registerOre(ORE_SHARD_PRISMARINE, RegisterManagement.itemStackPrismarineShard);
        OreDictionary.registerOre(ORE_CRYSTAL_PRISMARINE_RAW, RegisterManagement.itemStackPrismarineCrystalRaw);
        OreDictionary.registerOre(ORE_CRYSTAL_PRISMARINE, RegisterManagement.itemStackPrismarineCrystal);
    }
}
