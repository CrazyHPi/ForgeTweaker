package xyz.crazyh.forgetweaker.eventlistener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.crazyh.forgetweaker.config.Configs;

public class AutoRespawnEventListener {
    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (Configs.autoRespawn && event.getGui() instanceof GuiGameOver){
            System.out.println(event);
            Minecraft mc = Minecraft.getMinecraft();
            mc.player.respawnPlayer();
            event.setCanceled(true);
            mc.player.sendStatusMessage(new TextComponentString("auto respawn after death"), true);
        }
    }
}
