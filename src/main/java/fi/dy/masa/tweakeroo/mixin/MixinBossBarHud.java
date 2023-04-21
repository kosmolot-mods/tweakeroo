package fi.dy.masa.tweakeroo.mixin;

import net.minecraft.client.gui.DrawableHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.gui.hud.BossBarHud;
import fi.dy.masa.tweakeroo.config.Configs;

@Mixin(BossBarHud.class)
public abstract class MixinBossBarHud
{
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void tweakeroo_disableBossBarRendering(DrawableHelper drawableHelper, CallbackInfo ci)
    {
        if (Configs.Disable.DISABLE_BOSS_BAR.getBooleanValue())
        {
            ci.cancel();
        }
    }
}
