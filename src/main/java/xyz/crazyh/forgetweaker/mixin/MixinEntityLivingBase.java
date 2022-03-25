package xyz.crazyh.forgetweaker.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlime;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.crazyh.forgetweaker.config.Configs;

@Mixin(EntityLivingBase.class)
public class MixinEntityLivingBase {
    @Redirect(
            method = "travel",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getSlipperiness(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/IBlockAccess;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;)F"
            )
    )
    private float slimeNotSlip(Block instance, IBlockState state, IBlockAccess world, BlockPos pos, Entity entity){
        if (Configs.disablePlayerSlowDown && instance instanceof BlockSlime && entity instanceof EntityPlayer) {
            return 0.6F;
        }
        return instance.getSlipperiness(state, world, pos, entity);
    }
}
