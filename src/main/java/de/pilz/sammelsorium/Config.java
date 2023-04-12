package de.pilz.sammelsorium;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    private static final String CATEGORY_EXPERIMENTAL = "experimental";

    public static Boolean disableAllRecipes = false;
    public static Boolean enablePrismarine = true;
    public static Boolean enableRedstoneFlower = true;
    public static Boolean enableDecoBlocksAndItems = false;
    public static Boolean disableChunkLoadingOnRequest = false;

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
        enableRedstoneFlower = configuration.getBoolean(
                "enableRedstoneFlower",
                Configuration.CATEGORY_GENERAL,
                enableRedstoneFlower,
                "Enables the Redstone Flower and Seeds.");
        enableDecoBlocksAndItems = configuration.getBoolean(
                "enableDecoBlocksAndItems",
                Configuration.CATEGORY_GENERAL,
                enableDecoBlocksAndItems,
                "Enables all decoration variants of supported blocks and items. Useful for creating quests and custom NPCs.");
        disableChunkLoadingOnRequest = configuration.getBoolean(
                "disableChunkLoadingOnRequest",
                CATEGORY_EXPERIMENTAL,
                disableChunkLoadingOnRequest,
                "Disables the option \"loadChunkOnProvideRequest \" on server to not load chunks whenever they are maybe requested. This is very experimental.");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
