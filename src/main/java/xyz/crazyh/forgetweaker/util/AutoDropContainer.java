package xyz.crazyh.forgetweaker.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiShulkerBox;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.GuiContainerEvent;

public class AutoDropContainer {
    public static void dropShulkerBox (GuiContainerEvent event) {
        if (event.getGuiContainer() instanceof GuiShulkerBox) {
            Minecraft minecraft = Minecraft.getMinecraft();
            EntityPlayerSP playerSP = Minecraft.getMinecraft().player;

            for (int i = 0; i < 27; i++) {
                ItemStack itemstack = event.getGuiContainer().inventorySlots.getInventory().get(i);
                int winId = event.getGuiContainer().inventorySlots.windowId;

                if (!itemstack.isEmpty()){
                    minecraft.playerController.windowClick(winId, i, 1, ClickType.THROW, playerSP);
                }
            }
            playerSP.closeScreen();
        }
    }

    public static void dropAllContainer(GuiContainerEvent event) {
        //TODO dropAllContainer
        if (event.getGuiContainer() instanceof GuiShulkerBox) {
            Minecraft minecraft = Minecraft.getMinecraft();
            EntityPlayerSP playerSP = Minecraft.getMinecraft().player;

            for (int i = 0; i < 27; i++) {
                ItemStack itemstack = event.getGuiContainer().inventorySlots.getInventory().get(i);
                int winId = event.getGuiContainer().inventorySlots.windowId;

                if (!itemstack.isEmpty()){
                    minecraft.playerController.windowClick(winId, i, 1, ClickType.THROW, playerSP);
                }
            }
            playerSP.closeScreen();
        }
    }
}
