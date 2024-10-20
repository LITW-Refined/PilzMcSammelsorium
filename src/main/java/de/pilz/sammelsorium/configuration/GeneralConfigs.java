package de.pilz.sammelsorium.configuration;

import com.gtnewhorizon.gtnhlib.config.Config;

import de.pilz.sammelsorium.PilzMcSammelsorium;

@Config(modid = PilzMcSammelsorium.MODID)
public class GeneralConfigs {

    @Config.Comment("Disables all recipes if true. Useful for making custom recipes.")
    @Config.DefaultBoolean(false)
    @Config.RequiresMcRestart()
    public static boolean disableAllRecipes;

    @Config.Comment("Enables support for interpolated textures. Code copied from NotFine and not available if NotFine is installed.")
    @Config.DefaultBoolean(true)
    @Config.RequiresMcRestart()
    public static boolean enableInterpolatedTextures;
}
