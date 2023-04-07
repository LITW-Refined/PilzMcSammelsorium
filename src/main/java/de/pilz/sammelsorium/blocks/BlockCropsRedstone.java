package de.pilz.sammelsorium.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.pilz.sammelsorium.RegisterManagement;
import de.pilz.sammelsorium.strings.BlockNames;
import de.pilz.sammelsorium.strings.OtherStrings;

public class BlockCropsRedstone extends BlockCrops {

    @SideOnly(Side.CLIENT)
    private IIcon[] myIcons;

    public BlockCropsRedstone() {
        setBlockName(BlockNames.CROPS_REDSTONE);
    }

    /**
     * is the block grass, dirt or farmland
     */
    @Override
    protected boolean canPlaceBlockOn(Block block) {
        return block == Blocks.farmland;
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        if (metadata != 7) {
            return RegisterManagement.itemCropsRedstone;
        }
        return RegisterManagement.itemFlowerRedstone;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(int metadata, int fortune, Random random) {
        if (metadata != 7) {
            return 1;
        }
        return 4;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int growthStage) {
        return myIcons[growthStage];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        myIcons = new IIcon[8];

        for (int i = 0; i < myIcons.length; i++) {
            int stage = (int) (i / 2);
            myIcons[i] = iconRegister.registerIcon(
                    OtherStrings.MOD_PREFIX + BlockNames.CROPS_REDSTONE + OtherStrings.STAGE_POSTFIX + stage);
        }
    }

    @Override
    protected Item func_149866_i()
    {
        return RegisterManagement.itemFlowerRedstone;
    }

    @Override
    protected Item func_149865_P()
    {
        return RegisterManagement.itemFlowerRedstone;
    }
}
