package xyz.crazyh.forgetweaker.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketClickWindow;

public class RefreshInventory {
    /* back port from Fallen_Breath's Tweakermore
    check: https://github.com/Fallen-Breath/tweakermore/blob/1.15.2/src/main/java/me/fallenbreath/tweakermore/impl/refreshInventory/InventoryRefresher.java
    */
    public static void refreshInv(EntityPlayerSP playerSP) {
        Minecraft minecraft = Minecraft.getMinecraft();
        NetHandlerPlayClient client = minecraft.getConnection();

        if (client != null && playerSP != null) {
            ItemStack itemStack = new ItemStack(Blocks.BARRIER);
            itemStack.getOrCreateSubCompound("resync").setDouble("resync", Double.NaN);
            client.sendPacket(new CPacketClickWindow(
                    playerSP.inventoryContainer.windowId,
                    -999,
                    2,
                    ClickType.QUICK_MOVE,
                    itemStack,
                    playerSP.inventoryContainer.getNextTransactionID(playerSP.inventory)
            ));
        }
    }
}
