package xyz.crazyh.forgetweaker.config;

import net.minecraftforge.common.config.Config;
import xyz.crazyh.forgetweaker.ForgeTweaker;

@Config(modid = ForgeTweaker.MOD_ID)
public class ForgeTweakerConfig {
    @Config.Name("auto Clear Ghost Block Switch")
    @Config.Comment("on/off toggle for auto clear ghost block")
    public static boolean autoClearGhostBlockFlag = false;

    @Config.Name("auto Clear Ghost Block Interval")
    @Config.Comment("interval between auto clearing ghost block, count in gameticks, default is 5 sec (5*20gt)")
    @Config.RangeInt(min = 1, max = 6000)
    public static int autoClearGhostBlockInterval = 100;

    @Config.Name("auto Refesh Inventory Switch")
    @Config.Comment("on/off toggle for auto refresh inventory")
    public static boolean autoRefreshInventoryFlag = false;

    @Config.Name("auto Refresh Inventory Interval")
    @Config.Comment("interval between auto refreshing inventory, count in gameticks, default is 5 sec (5*20gt)")
    @Config.RangeInt(min = 1, max = 6000)
    public static int autoRefreshInventoryInterval = 100;

    @Config.Name("auto Drop Container Toggle")
    @Config.Comment("on/off toggle for auto drop all container items when try tp open a container")
    public static boolean autoDropContainerToggle = false;
}
