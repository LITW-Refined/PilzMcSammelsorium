package de.pilz.sammelsorium;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabsManagement {

    private static final String TAB_NAME_GENERAL = "General";

    public static CreativeTabs generalTab = new CreativeTabs(TAB_NAME_GENERAL) {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return RegisterManagement.itemFlowerRedstone;
        }
    };

    @SuppressWarnings("deprecation")
    public static void RegisterNames() {
        LanguageRegistry.instance()
            .addStringLocalization("itemGroup." + TAB_NAME_GENERAL, "en_US", PilzMcSammelsorium.MODNAME);
    }
}
