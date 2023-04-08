package de.pilz.sammelsorium;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static Boolean disableAllRecipes = false;
    public static Boolean enablePrismarine = true;
    public static Boolean enableGlowFlower = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        disableAllRecipes = configuration.getBoolean(
                "disableAllRecipes",
                Configuration.CATEGORY_GENERAL,
                disableAllRecipes,
                "Disables all recipes if true. Useful for making custom recipes.");
        enablePrismarine = configuration.getBoolean(
                "enablePrismarine",
                Configuration.CATEGORY_GENERAL,
                enablePrismarine,
                "Enables the Prismarine Shards, Raw Crystals and Crystals.");
        enableGlowFlower = configuration.getBoolean(
                "enableGlowFlower",
                Configuration.CATEGORY_GENERAL,
                enableGlowFlower,
                "Enables the Glow Flower and Seeds.");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
