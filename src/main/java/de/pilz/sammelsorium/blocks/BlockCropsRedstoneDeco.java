package de.pilz.sammelsorium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.pilz.sammelsorium.CreativeTabsManagement;
import de.pilz.sammelsorium.strings.BlockNames;
import de.pilz.sammelsorium.strings.OtherStrings;

public class BlockCropsRedstoneDeco extends BlockCrops {

    @SideOnly(Side.CLIENT)
    private IIcon[] myIcons;

    public BlockCropsRedstoneDeco() {
        super();
        setBlockName(BlockNames.CROPS_REDSTONE_DECO);
        this.setLightLevel(0.067F * 5);
        this.setLightOpacity(10);

        if (this.getClass() == BlockCropsRedstoneDeco.class) {
            this.setCreativeTab(CreativeTabsManagement.generalTab);
        }
    }

    // @Override
    // public int getLightValue() {
    // return 5;
    // }

    /**
     * is the block grass, dirt or farmland
     */
    @Override
    protected boolean canPlaceBlockOn(Block block) {
        return block == Blocks.farmland;
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
}
