package xyz.crazyh.forgetweaker;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import xyz.crazyh.forgetweaker.config.Configs;
import xyz.crazyh.forgetweaker.eventlistener.*;

@Mod(
        modid = ForgeTweaker.MOD_ID,
        name = ForgeTweaker.MOD_NAME,
        version = ForgeTweaker.VERSION,
        guiFactory = ForgeTweaker.GUI_FACTORY,
        useMetadata = true
)
public class ForgeTweaker {
    public static final String MOD_ID = "forgetweaker";
    public static final String MOD_NAME = "ForgeTweaker";
    public static final String VERSION = "3.1.4";
    public static final String GUI_FACTORY = "xyz.crazyh.forgetweaker.config.ForgeTweakerConfigGuiFactory";

    //TODO:
    // autoFillContainer
    // make autoDropContainer work with all container(chest, dropper/dispenser, hopper)
    // maybe better anti ghost block
    // auto reconnect
    // some hacks to jump up to fence(1.5 high block) and step up 1 high block without jumping
    // remove slime block bouncing up players, aka slime == normal block


    //===== Key Binds =====//
    public static final KeyBinding clearGhostBlockKB = new KeyBinding("Clear Ghost Blocks",
            //KeyConflictContext.IN_GAME, KeyModifier.NONE,
            Keyboard.KEY_G, MOD_NAME);

    public static final KeyBinding refreshInventoryKB = new KeyBinding("Refresh Inventory",
            //KeyConflictContext.IN_GAME, KeyModifier.NONE,
            Keyboard.KEY_H, MOD_NAME);

    public static final KeyBinding autoDropContainerToggleKB = new KeyBinding("Auto Drop Container Toggle",
            KeyConflictContext.IN_GAME, KeyModifier.SHIFT, Keyboard.KEY_SEMICOLON, MOD_NAME);

    public static final KeyBinding openConfigGui = new KeyBinding("Open Config GUI",
            Keyboard.KEY_END, MOD_NAME);
    //===== Key Binds End =====//

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static ForgeTweaker INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //reg event listeners
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new AutoDropContainerEventListenter());
        MinecraftForge.EVENT_BUS.register(new AntiGhostEventListener());
        MinecraftForge.EVENT_BUS.register(new RefreshInventoryEventListener());
        MinecraftForge.EVENT_BUS.register(new CustomTitleEventListener());
        MinecraftForge.EVENT_BUS.register(new OpenConfigGuiEventListenter());
        MinecraftForge.EVENT_BUS.register(new AutoRespawnEventListener());

        //reg key binds
        ClientRegistry.registerKeyBinding(autoDropContainerToggleKB);
        ClientRegistry.registerKeyBinding(clearGhostBlockKB);
        ClientRegistry.registerKeyBinding(refreshInventoryKB);
        ClientRegistry.registerKeyBinding(openConfigGui);

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        Display.setTitle(Configs.customTitle);
    }

}
