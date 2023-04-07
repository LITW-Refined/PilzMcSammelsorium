package de.pilz.sammelsorium.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import de.pilz.sammelsorium.CreativeTabsManagement;
import de.pilz.sammelsorium.strings.ItemNames;
import de.pilz.sammelsorium.strings.OtherStrings;

public class ItemFlowersRedstone extends Item {

    public ItemFlowersRedstone() {
        super();
        this.setMaxDamage(0);
        setTextureName(OtherStrings.MOD_PREFIX + ItemNames.FLOWERS_REDSTONE);
        setCreativeTab(CreativeTabsManagement.generalTab);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return OtherStrings.ITEM_PREFIX + ItemNames.FLOWERS_REDSTONE;
    }
}
