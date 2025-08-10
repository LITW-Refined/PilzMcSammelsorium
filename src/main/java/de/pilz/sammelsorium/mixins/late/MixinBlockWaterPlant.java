package de.pilz.sammelsorium.mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import extrabiomes.blocks.BlockWaterPlant;

@Mixin(BlockWaterPlant.class)
public class MixinBlockWaterPlant {

    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 16), remap = false)
    private static int enlargeArray(int value) {
        // Return something larger then 16, because in combination with many blocks and NEID the meta id can be larger
        // for some reasons. Usually this should be done by checking the meta against the array lengh on each access,
        // but this is easier. The other way can be done in the EXL.
        return 256;
    }
}
