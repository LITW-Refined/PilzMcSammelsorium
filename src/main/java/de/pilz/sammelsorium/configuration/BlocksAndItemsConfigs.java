package de.pilz.sammelsorium.configuration;

import com.gtnewhorizon.gtnhlib.config.Config;

import de.pilz.sammelsorium.PilzMcSammelsorium;

@Config(modid = PilzMcSammelsorium.MODID, category = "blocks_and_items")
public class BlocksAndItemsConfigs {

    @Config.Comment("Enables the Prismarine Shards, Raw Crystals and Crystals.")
    @Config.DefaultBoolean(true)
    @Config.RequiresMcRestart()
    public static boolean enablePrismarine;

    @Config.Comment("Enables the Redstone Flower and Seeds.")
    @Config.DefaultBoolean(true)
    @Config.RequiresMcRestart()
    public static boolean enableRedstoneFlower;

    @Config.Comment("Enables all decoration variants of supported blocks and items. Useful for creating quests and custom NPCs.")
    @Config.DefaultBoolean(false)
    @Config.RequiresMcRestart()
    public static boolean enableDecoBlocksAndItems;
}
