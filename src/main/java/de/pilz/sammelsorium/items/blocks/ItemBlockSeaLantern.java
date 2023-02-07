package de.pilz.sammelsorium.items.blocks;

import de.pilz.sammelsorium.enums.EnumSeaLanternVariation;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSeaLantern extends ItemBlock {

	public ItemBlockSeaLantern(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		var variation = EnumSeaLanternVariation.values()[stack.getItemDamage()];
		return "tile." + variation.getName();
	}
}
