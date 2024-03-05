package de.pilz.sammelsorium.mixins;

import java.util.Locale;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import de.pilz.sammelsorium.configuration.ModIntegrationConfigs;
import forestry.api.mail.EnumAddressee;
import forestry.api.mail.IMailAddress;
import forestry.mail.MailAddress;

@Mixin(MailAddress.class)
public abstract class MixinForestryPostRegistry implements IMailAddress {

    @Inject(method = "toString()Ljava/lang/String;", at = @At("HEAD"), cancellable = true, remap = false)
    public void pilzmcsammelsorium$fixOfflineUUID(CallbackInfoReturnable<String> callback) {
        if (ModIntegrationConfigs.forestryMailFixOfflineUUDID && isPlayer()) {
            MailAddress $this = (MailAddress) (Object) this;
            String name = $this.getName()
                .toLowerCase(Locale.ENGLISH);
            callback.setReturnValue(EnumAddressee.PLAYER.toString() + "-" + name);
            callback.cancel();
        }
    }
}
