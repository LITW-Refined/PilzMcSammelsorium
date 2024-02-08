package de.pilz.sammelsorium.configuration.gui;

import net.minecraft.client.gui.GuiScreen;

import com.gtnewhorizon.gtnhlib.config.ConfigException;
import com.gtnewhorizon.gtnhlib.config.SimpleGuiConfig;

import de.pilz.sammelsorium.PilzMcSammelsorium;
import de.pilz.sammelsorium.configuration.BlocksAndItemsConfigs;
import de.pilz.sammelsorium.configuration.ExperimentalConfigs;
import de.pilz.sammelsorium.configuration.GeneralConfigs;
import de.pilz.sammelsorium.configuration.ModIntegrationConfigs;
import de.pilz.sammelsorium.configuration.SpawnLightLevelConfigs;

public class PilzMcSammelsoriumGuiConfig extends SimpleGuiConfig {

    public PilzMcSammelsoriumGuiConfig(GuiScreen parent) throws ConfigException {
        super(
            parent,
            PilzMcSammelsorium.MODID,
            PilzMcSammelsorium.MODNAME,
            BlocksAndItemsConfigs.class,
            ExperimentalConfigs.class,
            GeneralConfigs.class,
            ModIntegrationConfigs.class,
            SpawnLightLevelConfigs.class);
    }
}
