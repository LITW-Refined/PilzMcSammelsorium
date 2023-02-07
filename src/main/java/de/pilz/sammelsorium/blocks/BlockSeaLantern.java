package de.pilz.sammelsorium.blocks;

import java.util.List;

import de.pilz.sammelsorium.enums.EnumSeaLanternVariation;
import de.pilz.sammelsorium.strings.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockSeaLantern extends Block {

	private IIcon[] myIcons;
	
	public BlockSeaLantern() {
		super(Material.glass);
		this.setBlockName(BlockNames.SEA_LANTERN);
		this.setStepSound(soundTypeGlass);
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (EnumSeaLanternVariation pt : EnumSeaLanternVariation.values()) {
			list.add(new ItemStack(item, 1, pt.getMeta()));
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
		myIcons = new IIcon[EnumSeaLanternVariation.count()];
		
		for (EnumSeaLanternVariation variation : EnumSeaLanternVariation.values()) {
			myIcons[variation.getMeta()] = reg.registerIcon("pilzmcsammelsorium:" + variation.getName());
		}
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		if (meta >= 0 && meta < EnumSeaLanternVariation.count()) {
			return myIcons[meta];
		}
		return null;
	}
}
