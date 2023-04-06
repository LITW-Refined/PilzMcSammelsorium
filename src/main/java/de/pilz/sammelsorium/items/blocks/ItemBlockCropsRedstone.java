package de.pilz.sammelsorium.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import de.pilz.sammelsorium.strings.BlockNames;
import de.pilz.sammelsorium.strings.OtherStrings;

public class ItemBlockCropsRedstone extends ItemBlock {

    public ItemBlockCropsRedstone(Block block) {
        super(block);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return OtherStrings.TILE_PREFIX + BlockNames.CROPS_REDSTONE;
    }
}
