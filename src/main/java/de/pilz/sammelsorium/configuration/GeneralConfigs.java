package de.pilz.sammelsorium.configuration;

import com.gtnewhorizon.gtnhlib.config.Config;

import de.pilz.sammelsorium.PilzMcSammelsorium;

@Config(modid = PilzMcSammelsorium.MODID)
public class GeneralConfigs {

    @Config.Comment("Disables all recipes if true. Useful for making custom recipes.")
    @Config.DefaultBoolean(false)
    @Config.RequiresMcRestart()
    public static boolean disableAllRecipes;
}
