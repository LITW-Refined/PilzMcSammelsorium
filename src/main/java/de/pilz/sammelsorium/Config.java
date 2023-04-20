package de.pilz.sammelsorium;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    private static final String CATEGORY_EXPERIMENTAL = "experimental";
    private static final String CATEGORY_MOD_INTEGRATION = "mod_integration";

    public static Boolean disableAllRecipes = false;
    public static Boolean enablePrismarine = true;
    public static Boolean enableRedstoneFlower = true;
    public static Boolean enableDecoBlocksAndItems = false;
    public static Boolean disableChunkLoadingOnRequest = false;
    public static Boolean autoLoadChunksOnTicketCreation = true;
    public static Boolean searchForModBlocksAndItems = true;

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
                "Disables the option \"loadChunkOnProvideRequest\" on server to not load chunks whenever they are maybe requested. This is very experimental.");
        autoLoadChunksOnTicketCreation = configuration.getBoolean(
                "autoLoadChunksOnTicketCreation",
                CATEGORY_EXPERIMENTAL,
                autoLoadChunksOnTicketCreation,
                "When \"disableChunkLoadingOnRequest\" is true then this option helps that chunk load tickets continue to load the target chunk automatically. Otherwise such tickets are useless and chunkloaders too. You may want to disable this if your Chunkloader mod can that too (probably not).");
        searchForModBlocksAndItems = configuration.getBoolean(
                "searchForModBlocksAndItems",
                CATEGORY_MOD_INTEGRATION,
                searchForModBlocksAndItems,
                "If disabled, the most mod integrations will not work. Only disable, if you announce an error while that get fixed when off.");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
