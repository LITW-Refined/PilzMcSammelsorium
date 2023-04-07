package de.pilz.sammelsorium.enums;

import de.pilz.sammelsorium.strings.ItemNames;

public enum EnumPrismarineItem {

    prismarineShard(0, ItemNames.PRISMARINE_SHARD),
    prismarineCrystal(1, ItemNames.PRISMARINE_CRYSTAL),
    prismarineCrystalRaw(2, ItemNames.PRISMARINE_CRYSTAL_RAW);

    private final int meta;
    private final String name;

    private EnumPrismarineItem(int meta, String name) {
        this.meta = meta;
        this.name = name;
    }

    public int getMeta() {
        return meta;
    }

    public String getName() {
        return name;
    }

    public static int count() {
        return values().length;
    }
}
