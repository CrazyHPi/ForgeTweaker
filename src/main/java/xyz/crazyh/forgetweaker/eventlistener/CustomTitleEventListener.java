package xyz.crazyh.forgetweaker.eventlistener;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.Display;
import xyz.crazyh.forgetweaker.config.Configs;

public class CustomTitleEventListener {
    @SubscribeEvent
    public void onConfigChangedPostConfigChanged(ConfigChangedEvent.PostConfigChangedEvent event) {
        Display.setTitle(Configs.customTitle);
    }
}
