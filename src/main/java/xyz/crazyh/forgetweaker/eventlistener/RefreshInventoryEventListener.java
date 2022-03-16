package xyz.crazyh.forgetweaker.eventlistener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import xyz.crazyh.forgetweaker.ForgeTweaker;
import xyz.crazyh.forgetweaker.config.ForgeTweakerConfig;
import xyz.crazyh.forgetweaker.util.RefreshInventory;

public class RefreshInventoryEventListener {
    private int tickCounter;

    //manual trigger
    @SubscribeEvent
    public void onInputKeyInput(InputEvent.KeyInputEvent event) {
        EntityPlayerSP playerSP = Minecraft.getMinecraft().player;

        if (ForgeTweaker.refreshInventoryKB.isPressed()) {
            RefreshInventory.refreshInv(playerSP);
            playerSP.sendMessage(new TextComponentString("refreshing inventory"));
        }
    }

    //auto trigger
    @SubscribeEvent
    public void onTickClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (ForgeTweakerConfig.autoRefreshInventoryFlag) {
                EntityPlayerSP playerSP = Minecraft.getMinecraft().player;
                tickCounter++;

                if (tickCounter > ForgeTweakerConfig.autoRefreshInventoryInterval) {
                    RefreshInventory.refreshInv(playerSP);
                }
            }
        }
    }
}
