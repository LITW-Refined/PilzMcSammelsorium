package de.pilz.sammelsorium.enums;

import net.minecraft.util.StatCollector;

public enum EnumTranslationKey {

    notation_DecoElement("notation_decoElement");

    private final String unlocalizedName;

    private EnumTranslationKey(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    public String getTranslation() {
        return getTranslation(this);
    }

    public static String getTranslation(EnumTranslationKey key) {
        return getTranslation(key.getUnlocalizedName());
    }

    public static String getTranslation(String unlocalizedName) {
        if (StatCollector.canTranslate(unlocalizedName)) {
            return StatCollector.translateToLocal(unlocalizedName);
        }
        return StatCollector.translateToFallback(unlocalizedName);
    }
}
