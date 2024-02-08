package de.pilz.sammelsorium.configuration;

import com.gtnewhorizon.gtnhlib.config.Config;

import de.pilz.sammelsorium.PilzMcSammelsorium;

@Config(modid = PilzMcSammelsorium.MODID, category = "spawnlightlevel")
public class SpawnLightLevelConfigs {

    @Config.Comment("If enabled, the required light level where hostile mobs do spawn will be adjusted to \"spawnLightLevelModificationValue\". This config were initially intended to reduce the required light level to 0, like in Minecraft 1.18+.")
    @Config.DefaultBoolean(false)
    public static boolean spawnLightLevelModificationEnable;

    @Config.Comment("Defines the required light level where hostile mobs should spawn. Requires \"spawnLightLevelModificationEnable\" to be true to take effect. This probably don't work if you want to increase the light level (yet).")
    @Config.DefaultInt(0)
    public static int spawnLightLevelModificationValue;

    @Config.Comment("Defines a list of dimension IDs where the config \"spawnLightLevelModificationEnable\" should NOT take effect. By default, this is the Nether and The End. Extend with your own dimensions if needed.")
    @Config.DefaultStringList({ "-1", "1" })
    public static String[] spawnLightLevelModificationDimensionBlackList;
}
