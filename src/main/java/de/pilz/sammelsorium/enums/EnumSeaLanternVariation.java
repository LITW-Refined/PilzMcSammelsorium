package de.pilz.sammelsorium.enums;

import de.pilz.sammelsorium.strings.BlockNames;

public enum EnumSeaLanternVariation {
	seaLantern(0, BlockNames.SEA_LANTERN),
	seaLanternRed(1, BlockNames.SEA_LANTERN_RED);
	
	private final int meta;
	private final String name;
	
	private EnumSeaLanternVariation(int meta, String name) {
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
