package xyz.crazyh.forgetweaker.config;

import net.minecraftforge.common.config.Config;
import xyz.crazyh.forgetweaker.ForgeTweaker;

@Config(modid = ForgeTweaker.MOD_ID)
public class Configs {

    @Config.Name("disable Player Slow Down")
    @Config.Comment("player won't be slowed down by soulsand, web, etc.")
    public static boolean disablePlayerSlowDown = false;

    @Config.Name("custom Minecraft Title")
    @Config.Comment("you can set your own title rather than Minecraft 1.12.2")
    public static String customTitle = "Minecraft 1.12.2";

    @Config.Name("place Ignore Entity")
    @Config.Comment("remove entity collision check when placing a block")
    public static boolean placeIgnoreEntity = false;

    @Config.Name("auto Respawn")
    @Config.Comment("auto respawn when you die")
    public static boolean autoRespawn = false;

    //sub cats
    public static AutoClear autoClearStuff = new AutoClear();
    public static AutoProcessContainer autoProcessContainer = new AutoProcessContainer();

    public static class AutoClear {
        @Config.Name("auto Clear Ghost Block Switch")
        @Config.Comment("on/off toggle for auto clear ghost block")
        public boolean autoClearGhostBlockFlag = false;

        @Config.Name("auto Clear Ghost Block Interval")
        @Config.Comment("interval between auto clearing ghost block, count in gameticks, default is 5 sec (5*20gt)")
        @Config.RangeInt(min = 1, max = 6000)
        public int autoClearGhostBlockInterval = 100;

        @Config.Name("auto Refesh Inventory Switch")
        @Config.Comment("on/off toggle for auto refresh inventory")
        public boolean autoRefreshInventoryFlag = false;

        @Config.Name("auto Refresh Inventory Interval")
        @Config.Comment("interval between auto refreshing inventory, count in gameticks, default is 5 sec (5*20gt)")
        @Config.RangeInt(min = 1, max = 6000)
        public int autoRefreshInventoryInterval = 100;
    }

    public static class AutoProcessContainer {
        @Config.Name("auto Drop Container Toggle")
        @Config.Comment("on/off toggle for auto drop all container items when try tp open a container")
        public boolean autoDropContainerToggle = false;

        @Config.Name("auto Drop Container Type")
        @Config.Comment("choose what type of container you want to auto drop")
        public AUTODROPTYPE autodroptype = AUTODROPTYPE.ShulkerBox;
        public enum AUTODROPTYPE {
            ShulkerBox,
            All
        }
    }

}
