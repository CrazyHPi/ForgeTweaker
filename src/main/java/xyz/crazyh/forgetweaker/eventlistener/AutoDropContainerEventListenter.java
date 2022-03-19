package xyz.crazyh.forgetweaker.eventlistener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.GuiContainerEvent;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import xyz.crazyh.forgetweaker.ForgeTweaker;
import xyz.crazyh.forgetweaker.config.ForgeTweakerConfig;
import xyz.crazyh.forgetweaker.util.AutoDropContainer;

public class AutoDropContainerEventListenter {

    @SubscribeEvent
    public void onInputKeyInput(InputEvent.KeyInputEvent event) {
        EntityPlayerSP playerSP = Minecraft.getMinecraft().player;

        if (ForgeTweaker.autoDropContainerToggleKB.isPressed()) {
            ForgeTweakerConfig.autoDropContainerToggle = !ForgeTweakerConfig.autoDropContainerToggle;
            ConfigManager.sync(ForgeTweaker.MOD_ID, Config.Type.INSTANCE);
            playerSP.sendStatusMessage(new TextComponentString("Toggled Auto Drop Container " + ForgeTweakerConfig.autoDropContainerToggle), true);
        }
    }

    @SubscribeEvent
    public void onPlayerContainerOpen(PlayerContainerEvent.Open event) {
        /*if (ForgeTweakerConfig.autoDropContainerToggle) {
            AutoDropContainer.dropShulkerBox(event);
            event.getEntityPlayer().closeScreen();
        }*/
    }

    @SubscribeEvent
    public void onGuiContainer(GuiContainerEvent event) {
        if (ForgeTweakerConfig.autoDropContainerToggle) {
            AutoDropContainer.dropShulkerBox(event);
        }
    }

}
