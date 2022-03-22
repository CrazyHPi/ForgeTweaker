package xyz.crazyh.forgetweaker.eventlistener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.GuiContainerEvent;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import xyz.crazyh.forgetweaker.ForgeTweaker;
import xyz.crazyh.forgetweaker.config.Configs;
import xyz.crazyh.forgetweaker.util.AutoDropContainer;

public class AutoDropContainerEventListenter {

    @SubscribeEvent
    public void onInputKeyInput(InputEvent.KeyInputEvent event) {
        EntityPlayerSP playerSP = Minecraft.getMinecraft().player;

        if (ForgeTweaker.autoDropContainerToggleKB.isPressed()) {
            Configs.autoProcessContainer.autoDropContainerToggle = !Configs.autoProcessContainer.autoDropContainerToggle;
            ConfigManager.sync(ForgeTweaker.MOD_ID, Config.Type.INSTANCE);
            playerSP.sendStatusMessage(new TextComponentString("Toggled Auto Drop Container " + Configs.autoProcessContainer.autoDropContainerToggle), true);
        }
    }

    @SubscribeEvent
    public void onGuiContainer(GuiContainerEvent event) {
        if (Configs.autoProcessContainer.autoDropContainerToggle) {

            if (Configs.autoProcessContainer.autodroptype == Configs.AutoProcessContainer.AUTODROPTYPE.ShulkerBox) {
                AutoDropContainer.dropShulkerBox(event);
            }

            //TODO: drop all kinds of container
            //now it just drop shulker box
            if (Configs.autoProcessContainer.autodroptype == Configs.AutoProcessContainer.AUTODROPTYPE.All) {
                AutoDropContainer.dropAllContainer(event);
            }

        }
    }

}
