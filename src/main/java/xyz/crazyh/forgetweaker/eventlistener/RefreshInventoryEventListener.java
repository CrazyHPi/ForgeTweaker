package xyz.crazyh.forgetweaker.eventlistener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import xyz.crazyh.forgetweaker.ForgeTweaker;
import xyz.crazyh.forgetweaker.config.Configs;
import xyz.crazyh.forgetweaker.util.RefreshInventory;

public class RefreshInventoryEventListener {
    private int tickCounter;

    //manual trigger
    @SubscribeEvent
    public void onInputKeyInput(final InputEvent.KeyInputEvent event) {
        EntityPlayerSP playerSP = Minecraft.getMinecraft().player;

        if (ForgeTweaker.refreshInventoryKB.isPressed()) {
            RefreshInventory.refreshInv(playerSP);
            tickCounter = 0;
            playerSP.sendMessage(new TextComponentString("refreshing inventory"));
        }

    }

    //auto trigger
    @SubscribeEvent
    public void onTickClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (Configs.autoClearStuff.autoRefreshInventoryFlag) {
                EntityPlayerSP playerSP = Minecraft.getMinecraft().player;
                tickCounter++;

                if (tickCounter > Configs.autoClearStuff.autoRefreshInventoryInterval) {
                    RefreshInventory.refreshInv(playerSP);
                    tickCounter = 0;
                }
            }
        }
    }
}
