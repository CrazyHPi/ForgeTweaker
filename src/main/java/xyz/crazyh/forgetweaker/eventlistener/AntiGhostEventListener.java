package xyz.crazyh.forgetweaker.eventlistener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import xyz.crazyh.forgetweaker.ForgeTweaker;
import xyz.crazyh.forgetweaker.config.ForgeTweakerConfig;
import xyz.crazyh.forgetweaker.util.AntiGhostBlock;
import xyz.crazyh.forgetweaker.util.RefreshInventory;

public class AntiGhostEventListener {
    private int tickCounter;

    //manual trigger
    @SubscribeEvent
    public void onInputKeyInput(final InputEvent.KeyInputEvent event) {
        EntityPlayerSP playerSP = Minecraft.getMinecraft().player;

        if (ForgeTweaker.clearGhostBlockKB.isPressed()) {
            AntiGhostBlock.clearGhostBlock(playerSP);
            playerSP.sendMessage(new TextComponentString("clearing ghost blocks around you"));
        }
    }

    //auto trigger at certain interval
    @SubscribeEvent
    public void onTickClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (ForgeTweakerConfig.autoClearGhostBlockFlag) {
                EntityPlayerSP playerSP = Minecraft.getMinecraft().player;
                tickCounter++;

                if (tickCounter > ForgeTweakerConfig.autoClearGhostBlockInterval) {
                    AntiGhostBlock.clearGhostBlock(playerSP);
                    tickCounter = 0;
                }
            }
        }
    }
}
