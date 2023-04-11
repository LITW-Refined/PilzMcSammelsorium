package de.pilz.sammelsorium.items.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.pilz.sammelsorium.enums.EnumTranslationKey;

public class ItemBlockDeco extends ItemBlock {

    public ItemBlockDeco(Block block) {
        super(block);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack itemStack, EntityPlayer entity, List list, boolean p_77624_4_) {
        super.addInformation(itemStack, entity, list, p_77624_4_);
        list.add(StatCollector.translateToLocal(EnumTranslationKey.notation_DecoElement.getTranslation()));
    }
}
