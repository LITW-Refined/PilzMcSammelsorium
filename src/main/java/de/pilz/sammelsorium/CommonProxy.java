package de.pilz.sammelsorium;

import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {

    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());

        MyMod.LOG.info("I am " + MyMod.MODNAME + " at version " + Tags.VERSION);

        MyMod.LOG.info("Registering items ...");
        RegisterManagement.RegisterAllItems();

        MyMod.LOG.info("Registering blocks ...");
        RegisterManagement.RegisterAllBlocks();

        MyMod.LOG.info("Registering ores ...");
        OreDictionaryManagement.RegisterOres();
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        MyMod.LOG.info("Searching blocks and items from other Mods ...");
        ModManagement.findModItems();

        if (Config.registerModOres) {
            // Not sure if this is too late, but NewHorzizonCoreMod does it similar.
            MyMod.LOG.info("Registering Mod items and blocks to Ore Dictionary ...");
            OreDictionaryManagement.RegisterModOres();
        }

        if (!Config.disableAllRecipes) {
            MyMod.LOG.info("Registering recipes...");
            RecipesManagement.RegisterAllRecipes();
        }

        EventHandlers handlers = new EventHandlers();
        MinecraftForge.EVENT_BUS.register(handlers);
        FMLCommonHandler.instance().bus().register(handlers);
    }

    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {}

    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {}
}
