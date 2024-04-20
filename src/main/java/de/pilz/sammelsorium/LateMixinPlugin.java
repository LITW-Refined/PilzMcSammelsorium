package de.pilz.sammelsorium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class LateMixinPlugin implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.pilzmcsammelsorium.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> list = new ArrayList<String>();

        // Forestry
        if (loadedMods.contains("Forestry")) {
            // Offline UUID Fix
            list.add("MixinForestryPlayerUtils");
            list.add("MixinForestryPostRegistry");
        }

        if (loadedMods.contains("etfuturum")) {
            list.add("MixinBlockLantern");
        }

        return list;
    }
}
