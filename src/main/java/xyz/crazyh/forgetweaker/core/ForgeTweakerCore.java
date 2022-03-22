package xyz.crazyh.forgetweaker.core;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.SortingIndex(-10000)
@IFMLLoadingPlugin.TransformerExclusions("xyz.crazyh.forgetweaker.core.ForgeTweakerCore")
public class ForgeTweakerCore implements IFMLLoadingPlugin{

    private static boolean init = false;
    private static boolean loadCore = true;

    public ForgeTweakerCore() {
        initialize();

        MixinBootstrap.init();

        if (loadCore) {
            Mixins.addConfiguration("mixins.forgetweaker.json");
        }
    }

    public static void initialize() {
        if (init) {
            return;
        }

        init = true;
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
