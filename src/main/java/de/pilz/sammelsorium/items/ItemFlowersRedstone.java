package de.pilz.sammelsorium.items;

import de.pilz.sammelsorium.strings.ItemNames;
import de.pilz.sammelsorium.strings.OtherStrings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFlowersRedstone extends Item {
    
    public ItemFlowersRedstone() {
        super();
        this.setMaxDamage(0);
        setTextureName(OtherStrings.MOD_PREFIX + ItemNames.FLOWERS_REDSTONE);
        setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return OtherStrings.ITEM_PREFIX + ItemNames.FLOWERS_REDSTONE;
    }
}
