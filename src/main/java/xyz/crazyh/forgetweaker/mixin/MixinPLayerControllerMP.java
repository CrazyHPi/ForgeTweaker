package xyz.crazyh.forgetweaker.mixin;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.crazyh.forgetweaker.config.Configs;

@Mixin(PlayerControllerMP.class)
public abstract class MixinPLayerControllerMP {
    @Shadow private int blockHitDelay;

    @Inject(
            method = "onPlayerDamageBlock",
            at = @At("HEAD")
    )
    public void removeBlockHitDelay(BlockPos iblockstate, EnumFacing block, CallbackInfoReturnable<Boolean> cir) {
        if (Configs.blockBreaking.disableBlockBreakingCoolDown && this.blockHitDelay > 0) {
            this.blockHitDelay = 0;
        }
    }

    @Inject(
            method = "onPlayerDamageBlock",
            at = @At(
                    value = "RETURN",
                    ordinal = 4
            )
    )
    public void addBlockHitDelay(BlockPos iblockstate, EnumFacing block, CallbackInfoReturnable<Boolean> cir) {
        if (Configs.blockBreaking.blockBreakingCoolDownToggle && this.blockHitDelay == 0) {
            this.blockHitDelay = Configs.blockBreaking.blockBreakingCoolDownInterval;
        }
    }
}
