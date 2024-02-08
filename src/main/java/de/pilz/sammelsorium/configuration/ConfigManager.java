package de.pilz.sammelsorium.configuration;

import com.gtnewhorizon.gtnhlib.config.ConfigException;
import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;

public final class ConfigManager {

    public static void registerConfigs() {
        try {
            ConfigurationManager.registerConfig(BlocksAndItemsConfigs.class);
            ConfigurationManager.registerConfig(ExperimentalConfigs.class);
            ConfigurationManager.registerConfig(GeneralConfigs.class);
            ConfigurationManager.registerConfig(ModIntegrationConfigs.class);
            ConfigurationManager.registerConfig(SpawnLightLevelConfigs.class);
        } catch (ConfigException e) {
            throw new RuntimeException(e);
        }
    }
}
