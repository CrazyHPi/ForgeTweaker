package xyz.crazyh.forgetweaker.mixin;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.crazyh.forgetweaker.config.Configs;

@Mixin(World.class)
public abstract class MixinWorld {
    @Inject(
            method = "mayPlace",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onMayPlace(Block blockIn, BlockPos pos, boolean skipCollisionCheck, EnumFacing sidePlacedOn, Entity placer, CallbackInfoReturnable<Boolean> cir) {
        if (Configs.placeIgnoreEntity && placer instanceof EntityPlayer) {
            if (((EntityPlayer) placer).isCreative()) {
                cir.setReturnValue(true);
            }
        }
    }

}
