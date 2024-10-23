package de.pilz.sammelsorium.mixins.late;

import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import de.pilz.sammelsorium.configuration.ModIntegrationConfigs;
import ganymedes01.etfuturum.blocks.BlockLantern;

@Mixin(BlockLantern.class)
public abstract class MixinBlockLantern {

    @Inject(method = "canPlaceBlockAt(Lnet/minecraft/world/World;III)Z", at = @At("HEAD"), cancellable = true)
    public void pilzmcsammelsorium$canPlaceBlockAt(World world, int x, int y, int z,
        CallbackInfoReturnable<Boolean> callback) {
        if (ModIntegrationConfigs.etfuturumPlaceBlockLanternAnywhere) {
            callback.setReturnValue(true);
            callback.cancel();
        }
    }
}
