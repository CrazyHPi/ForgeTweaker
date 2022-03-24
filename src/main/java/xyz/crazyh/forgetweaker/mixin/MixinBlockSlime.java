package xyz.crazyh.forgetweaker.mixin;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockSlime;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.crazyh.forgetweaker.config.Configs;

@Mixin(BlockSlime.class)
public abstract class MixinBlockSlime extends BlockBreakable {

    protected MixinBlockSlime(Material materialIn, boolean ignoreSimilarityIn) {
        super(materialIn, ignoreSimilarityIn);
    }

    @Inject(
            method = "onEntityWalk",
            at = @At("HEAD"),
            cancellable = true
    )
    private void playerNoSlowDown(World worldIn, BlockPos pos, Entity entityIn, CallbackInfo ci) {
        if (entityIn instanceof EntityPlayerSP && Configs.disablePlayerSlowDown) {
            super.onEntityWalk(worldIn, pos, entityIn);
            ci.cancel();
        }
    }

}
