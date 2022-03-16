package xyz.crazyh.forgetweaker.util;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.ContainerShulkerBox;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;

public class AutoDropContainer {
    public static void dropShulkerBox (PlayerContainerEvent.Open event) {
        if (event.getContainer().getClass().equals(ContainerShulkerBox.class)) {
            Minecraft minecraft = Minecraft.getMinecraft();

            for (int i = 0; i < 27; i++) {
                minecraft.playerController.windowClick(event.getContainer().windowId, i, 1, ClickType.THROW, event.getEntityPlayer());
            }
        }
    }

}
