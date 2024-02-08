package de.pilz.sammelsorium.proxies;

import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import de.pilz.sammelsorium.EventHandlers;
import de.pilz.sammelsorium.ModManagement;
import de.pilz.sammelsorium.OreDictionaryManagement;
import de.pilz.sammelsorium.PilzMcSammelsorium;
import de.pilz.sammelsorium.RecipesManagement;
import de.pilz.sammelsorium.RegisterManagement;
import de.pilz.sammelsorium.Tags;
import de.pilz.sammelsorium.configuration.ConfigManager;
import de.pilz.sammelsorium.configuration.GeneralConfigs;
import de.pilz.sammelsorium.configuration.ModIntegrationConfigs;

public class CommonProxy {

    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        ConfigManager.registerConfigs();

        PilzMcSammelsorium.LOG.info("I am " + PilzMcSammelsorium.MODNAME + " at version " + Tags.VERSION);

        PilzMcSammelsorium.LOG.info("Registering items ...");
        RegisterManagement.RegisterAllItems();

        PilzMcSammelsorium.LOG.info("Registering blocks ...");
        RegisterManagement.RegisterAllBlocks();

        PilzMcSammelsorium.LOG.info("Registering ores ...");
        OreDictionaryManagement.RegisterOres();
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        PilzMcSammelsorium.LOG.info("Searching blocks and items from other Mods ...");
        ModManagement.findModItems();

        if (ModIntegrationConfigs.registerModOres) {
            // Not sure if this is too late, but NewHorzizonCoreMod does it similar.
            PilzMcSammelsorium.LOG.info("Registering Mod items and blocks to Ore Dictionary ...");
            OreDictionaryManagement.RegisterModOres();
        }

        if (!GeneralConfigs.disableAllRecipes) {
            PilzMcSammelsorium.LOG.info("Registering recipes...");
            RecipesManagement.RegisterAllRecipes();
        }

        EventHandlers handlers = new EventHandlers();
        MinecraftForge.EVENT_BUS.register(handlers);
        FMLCommonHandler.instance()
            .bus()
            .register(handlers);
    }

    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {}

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
