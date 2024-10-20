package de.pilz.sammelsorium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.Side;
import de.pilz.sammelsorium.configuration.GeneralConfigs;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;

@IFMLLoadingPlugin.Name("EarlyMixinPlugin")
@IFMLLoadingPlugin.MCVersion("1.7.10")
public class EarlyMixinPlugin implements IFMLLoadingPlugin, IEarlyMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.pilzmcsammelsorium.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> list = new ArrayList<String>();

        // Interpolated Textures
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT && GeneralConfigs.enableInterpolatedTextures && !loadedMods.contains("notfine")) {
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
    public void injectData(Map<String, Object> data) {
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
