package de.pilz.sammelsorium.mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mojang.authlib.GameProfile;

import de.pilz.sammelsorium.configuration.ModIntegrationConfigs;
import forestry.core.utils.PlayerUtil;

@Mixin(PlayerUtil.class)
public abstract class MixinForestryPlayerUtils {

    // @Inject(
    // method = "getRecipient(Ljava/lang/String;Lforestry/api/mail/EnumAddressee;)Lforestry/api/mail/IMailAddress;",
    // at = @At("HEAD"),
    // cancellable = true,
    // remap = false)
    // private static void pilzmcsammelsorium$fixOfflineUUID(String recipientName, EnumAddressee type,
    // CallbackInfoReturnable<IMailAddress> callback) {
    // if (ModIntegrationConfigs.forestryMailFixOfflineUUDID && type == EnumAddressee.PLAYER) {
    // UUID uuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + recipientName).getBytes(Charsets.UTF_8));
    // GameProfile gameProfile = new GameProfile(uuid, recipientName);
    // IMailAddress address = PostManager.postRegistry.getMailAddress(gameProfile);
    // callback.setReturnValue(address);
    // callback.cancel();
    // }
    // }

    @Inject(
        method = "isSameGameProfile(Lcom/mojang/authlib/GameProfile;Lcom/mojang/authlib/GameProfile;)Z",
        at = @At("RETURN"),
        cancellable = true,
        remap = false)
    private static void pilzmcsammelsorium$fixOfflineUUID(GameProfile player1, GameProfile player2,
        CallbackInfoReturnable<Boolean> callback) {
        if (ModIntegrationConfigs.forestryMailFixOfflineUUDID && !callback.getReturnValueZ()
            && player1 != null
            && player2 != null) {
            String name1 = player1.getName();
            String name2 = player2.getName();
            if (name1 != null && name2 != null && !name1.equals("") && !name2.equals("") && name1.equals(name2)) {
                callback.setReturnValue(true);
            }
        }
    }
}
