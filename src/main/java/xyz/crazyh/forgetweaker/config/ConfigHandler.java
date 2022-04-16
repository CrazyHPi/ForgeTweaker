package xyz.crazyh.forgetweaker.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.crazyh.forgetweaker.ForgeTweaker;

@Mod.EventBusSubscriber(modid = ForgeTweaker.MOD_ID)
public final class ConfigHandler {
    @SubscribeEvent
    public static void onConfigChangedOnConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equalsIgnoreCase(ForgeTweaker.MOD_ID)) {
            ConfigManager.sync(ForgeTweaker.MOD_ID, Config.Type.INSTANCE);
        }
    }

}
