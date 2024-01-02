package de.pilz.sammelsorium;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    private static final String CATEGORY_EXPERIMENTAL = "experimental";
    private static final String CATEGORY_MOD_INTEGRATION = "mod_integration";
    private static final String CATEGORY_MIXINS_SPAWNLIGHTLEVEL = "mixins_spawnlightlevel";

    public static Boolean disableAllRecipes = false;
    public static Boolean enablePrismarine = true;
    public static Boolean enableRedstoneFlower = true;
    public static Boolean enableDecoBlocksAndItems = false;

    // Experimental
    public static Boolean disableChunkLoadingOnRequest = false;
    public static Boolean autoLoadChunksOnTicketCreation = true;

    // Mod integration
    public static Boolean searchForModBlocksAndItems = true;
    public static Boolean registerModOres = true;

    // Spawn light level
    public static Boolean spawnLightLevelModificationEnable = false;
    public static int spawnLightLevelModificationValue = 0;
    public static int[] spawnLightLevelModificationDimensionBlackList = { -1, 1 };

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
        registerModOres = configuration.getBoolean(
                "registerModOres",
                CATEGORY_MOD_INTEGRATION,
                registerModOres,
                "If enabled, a few known mod items and blocks get reigsted at the Ore Dictionary.\"searchForModBlocksAndItems\" needs to be true.");
        spawnLightLevelModificationEnable = configuration.getBoolean(
                "spawnLightLevelModificationEnable",
                CATEGORY_MIXINS_SPAWNLIGHTLEVEL,
                spawnLightLevelModificationEnable,
                "If enabled, the required light level where hostile mobs do spawn will be adjusted to \"spawnLightLevelModificationValue\". This config were initially intended to reduce the required light level to 0, like in Minecraft 1.18+.");
        spawnLightLevelModificationValue = configuration.getInt(
                "spawnLightLevelModificationValue",
                CATEGORY_MIXINS_SPAWNLIGHTLEVEL,
                spawnLightLevelModificationValue,
                0,
                15,
                "Defines the required light level where hostile mobs should spawn. Requires \"spawnLightLevelModificationEnable\" to be true to take effect. This probably don't work if you want to increase the light level (yet).");
        spawnLightLevelModificationDimensionBlackList = configuration.get(
                CATEGORY_MIXINS_SPAWNLIGHTLEVEL,
                "spawnLightLevelModificationDimensionBlackList",
                spawnLightLevelModificationDimensionBlackList,
                "Defines a list of dimension IDs where the config \"spawnLightLevelModificationEnable\" should NOT take effect. By default, this is the Nether and The End. Extnd with your own dimensions if needed.")
                .getIntList();

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
