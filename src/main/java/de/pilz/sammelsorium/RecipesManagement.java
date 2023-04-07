package de.pilz.sammelsorium;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesManagement {

    public static void RegisterAllRecipes() {
        // var torch = Blocks.torch; // Oder auch so: GameRegistry.findItem("minecraft", "torch");

        // GameRegistry.addShapedRecipe(
        // new ItemStack(RegisterManagement.blockSeaLantern),
        // new Object[] { "F F", " F ", "F F", 'F', torch });
        // GameRegistry.addShapedRecipe(
        // new ItemStack(RegisterManagement.blockSeaLantern, 1, 1),
        // new Object[] { "FFF", " ", "FFF", 'F', torch });

        GameRegistry.addShapelessRecipe(
                new ItemStack(RegisterManagement.itemCropsRedstone, 2, 0),
                new Object[] { RegisterManagement.itemFlowerRedstone, RegisterManagement.itemFlowerRedstone });
        GameRegistry.addShapelessRecipe(
                new ItemStack(Items.redstone, 4, 0),
                new Object[] { RegisterManagement.itemFlowerRedstone, RegisterManagement.itemFlowerRedstone,
                        RegisterManagement.itemFlowerRedstone });
    }
}
