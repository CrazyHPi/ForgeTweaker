package xyz.crazyh.forgetweaker.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.crazyh.forgetweaker.config.Configs;

@Mixin(World.class)
public abstract class MixinWorld implements IBlockAccess, net.minecraftforge.common.capabilities.ICapabilityProvider{

    @Inject(
            method = "mayPlace",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onMayPlace(Block blockIn, BlockPos pos, boolean skipCollisionCheck, EnumFacing sidePlacedOn, Entity placer, CallbackInfoReturnable<Boolean> cir) {
        //totally vanilla copy except entity collision check removed
        if (Configs.placeIgnoreEntity && placer instanceof EntityPlayer && ((EntityPlayer) placer).isCreative()) {
            //forge event stuff copy
            if (!((placer instanceof EntityPlayer) || !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(placer, new net.minecraftforge.common.util.BlockSnapshot(placer.world, pos, blockIn.getDefaultState()), sidePlacedOn).isCanceled())) {
                cir.setReturnValue(false);
            }
            //vanilla stuff copy
            IBlockState iblockstate1 = this.getBlockState(pos);
            if (iblockstate1.getMaterial() == Material.CIRCUITS && blockIn == Blocks.ANVIL) {
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(iblockstate1.getBlock().isReplaceable(this, pos) && blockIn.canPlaceBlockOnSide(placer.world, pos, sidePlacedOn));
            }
        }
    }

}
