package de.pilz.sammelsorium.configuration.gui;

import net.minecraft.client.gui.GuiScreen;

import com.gtnewhorizon.gtnhlib.config.SimpleGuiFactory;

public class PilzMcSammelsoriumGuiConfigFactory implements SimpleGuiFactory {

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return PilzMcSammelsoriumGuiConfig.class;
    }
}
