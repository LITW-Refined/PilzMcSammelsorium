package de.pilz.sammelsorium;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryManagement {

    private static final String ORE_NAME_SHARD_PRISMARINE = "shardPrismarine";

    public static void RegisterOres() {
        OreDictionary.registerOre(ORE_NAME_SHARD_PRISMARINE, RegisterManagement.itemStackPrismarineShard);
    }
}
