package de.pilz.sammelsorium;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesManagement {

    public static void RegisterAllRecipes() {
        var torch = Blocks.torch; // Oder auch so: GameRegistry.findItem("minecraft", "torch");
        GameRegistry.addShapedRecipe(
                new ItemStack(RegisterManagement.blockSeaLantern),
                new Object[] { "F F", " F ", "F F", 'F', torch });
        GameRegistry.addShapedRecipe(
                new ItemStack(RegisterManagement.blockSeaLantern, 1, 1),
                new Object[] { "FFF", "   ", "FFF", 'F', torch });
    }
}
