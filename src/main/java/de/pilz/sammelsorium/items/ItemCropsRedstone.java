package de.pilz.sammelsorium.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import de.pilz.sammelsorium.RegisterManagement;
import de.pilz.sammelsorium.strings.ItemNames;
import de.pilz.sammelsorium.strings.OtherStrings;

public class ItemCropsRedstone extends Item implements IPlantable {

    public ItemCropsRedstone() {
        super();
        setTextureName(OtherStrings.MOD_PREFIX + ItemNames.CROPS_REDSTONE);
        setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return OtherStrings.ITEM_PREFIX + ItemNames.CROPS_REDSTONE;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z) {
        return RegisterManagement.blockCropsRedstone;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
        return 0;
    }

    @Override
    public boolean onItemUse(ItemStack parItemStack, EntityPlayer parPlayer, World parWorld, int parX, int parY,
            int parZ, int par7, float par8, float par9, float par10) {
        // not sure what this parameter does, copied it from potato
        if (par7 != 1) {
            return false;
        }
        // check if player has capability to edit
        else if (parPlayer.canPlayerEdit(parX, parY + 1, parZ, par7, parItemStack)) {
            // check that the soil block can sustain the plant
            // and that block above is air so there is room for plant to grow
            if (parWorld.getBlock(parX, parY, parZ).canSustainPlant(parWorld, parX, parY, parZ, ForgeDirection.UP, this)
                    && parWorld.isAirBlock(parX, parY + 1, parZ)) {
                // place the plant block
                parWorld.setBlock(parX, parY + 1, parZ, RegisterManagement.blockCropsRedstone);
                // decrement the stack of seed items
                --parItemStack.stackSize;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
