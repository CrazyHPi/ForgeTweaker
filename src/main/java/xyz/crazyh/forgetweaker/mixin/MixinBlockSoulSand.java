package xyz.crazyh.forgetweaker.mixin;

import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.crazyh.forgetweaker.config.Configs;

@Mixin(BlockSoulSand.class)
public class MixinBlockSoulSand {
    @Inject(
            method = "onEntityCollision",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onPlayerWalk(World worldIn, BlockPos pos, IBlockState state, Entity entityIn, CallbackInfo ci) {
        if (entityIn instanceof EntityPlayerSP && Configs.diaablePlayerSlowDown) {
            ci.cancel();
        }
    }
}
