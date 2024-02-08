package de.pilz.sammelsorium.proxies;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import de.pilz.sammelsorium.CreativeTabsManagement;

public class ClientProxy extends CommonProxy {

    // Override CommonProxy methods here, if you want a different behaviour on the client (e.g. registering renders).
    // Don't forget to call the super methods aswell.

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        CreativeTabsManagement.RegisterNames();
    }
}
