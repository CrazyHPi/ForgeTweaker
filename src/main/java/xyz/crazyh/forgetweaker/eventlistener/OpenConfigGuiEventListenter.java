package xyz.crazyh.forgetweaker.eventlistener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import xyz.crazyh.forgetweaker.ForgeTweaker;
import xyz.crazyh.forgetweaker.config.Configs;

public class OpenConfigGuiEventListenter {
    @SubscribeEvent
    public void onInputKeyInput(InputEvent.KeyInputEvent event) {
        if (ForgeTweaker.openConfigGui.isPressed()) {
            EntityPlayerSP playerSP = Minecraft.getMinecraft().player;
            Minecraft mc = Minecraft.getMinecraft();

            mc.displayGuiScreen(new GuiConfig(null,
                    ConfigElement.from(Configs.class).getChildElements(),
                    ForgeTweaker.MOD_ID,
                    false,
                    false,
                    ForgeTweaker.MOD_NAME
                    )
            );
        }
    }
}
