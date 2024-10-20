package de.pilz.sammelsorium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.spongepowered.asm.mixin.MixinEnvironment;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import de.pilz.sammelsorium.configuration.GeneralConfigs;

@IFMLLoadingPlugin.Name("EarlyMixinPlugin")
@IFMLLoadingPlugin.MCVersion("1.7.10")
public class EarlyMixinPlugin implements IFMLLoadingPlugin, IEarlyMixinLoader {

    public static final MixinEnvironment.Side side = MixinEnvironment.getCurrentEnvironment()
        .getSide();

    @Override
    public String getMixinConfig() {
        return "mixins.pilzmcsammelsorium.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> list = new ArrayList<String>();

        // Interpolated Textures
        if (side == MixinEnvironment.Side.CLIENT && !loadedMods.contains("notfine")) {
            list.add("MixinTextureMap");
        }

        return list;
    }

    @Override
    public String[] getASMTransformerClass() {
        return null;
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {}

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
