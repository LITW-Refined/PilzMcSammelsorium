package de.pilz.sammelsorium.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import de.pilz.sammelsorium.CreativeTabsManagement;
import de.pilz.sammelsorium.enums.EnumPrismarineItem;
import de.pilz.sammelsorium.strings.OtherStrings;

public class ItemPrismarine extends Item {

    private IIcon[] myIcons;

    public ItemPrismarine() {
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabsManagement.generalTab);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        var variation = EnumPrismarineItem.values()[stack.getItemDamage()];
        return OtherStrings.ITEM_PREFIX + variation.getName();
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (EnumPrismarineItem pt : EnumPrismarineItem.values()) {
            list.add(new ItemStack(item, 1, pt.getMeta()));
        }
    }

    @Override
    public void registerIcons(IIconRegister reg) {
        myIcons = new IIcon[EnumPrismarineItem.count()];

        for (EnumPrismarineItem variation : EnumPrismarineItem.values()) {
            myIcons[variation.getMeta()] = reg.registerIcon(OtherStrings.MOD_PREFIX + variation.getName());
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        if (meta >= 0 && meta < EnumPrismarineItem.count()) {
            return myIcons[meta];
        }
        return null;
    }
}
