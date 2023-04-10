package de.pilz.sammelsorium.blocks;

import java.util.Random;

import net.minecraft.item.Item;

import de.pilz.sammelsorium.RegisterManagement;
import de.pilz.sammelsorium.strings.BlockNames;

public class BlockCropsRedstone extends BlockCropsRedstoneDeco {

    public BlockCropsRedstone() {
        super();
        setBlockName(BlockNames.CROPS_REDSTONE);
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

    @Override
    protected Item func_149866_i() {
        return RegisterManagement.itemFlowerRedstone;
    }

    @Override
    protected Item func_149865_P() {
        return RegisterManagement.itemFlowerRedstone;
    }
}
