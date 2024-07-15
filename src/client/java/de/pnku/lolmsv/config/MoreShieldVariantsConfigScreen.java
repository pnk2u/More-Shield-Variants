package de.pnku.lolmsv.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import net.minecraft.network.chat.Component;

public class MoreShieldVariantsConfigScreen implements ModMenuApi {

    public static ConfigBuilder builder() {
        ConfigBuilder configBuilder = ConfigBuilder.create()
                .setTitle(Component.translatable("title.moreshieldvariants.config"))
                .setEditable(true)
                .setSavingRunnable(() -> MoreShieldVariantsConfigJsonHelper.writeToConfig());

        ConfigCategory shieldTexture = configBuilder.getOrCreateCategory(Component.translatable("config.category.moreshieldvariants.shieldTexture"));

        shieldTexture.addEntry(configBuilder.entryBuilder()
                .startBooleanToggle(Component.translatable("config.shieldTexture_option.moreshieldvariants.acaciaUseCustom"), MoreShieldVariantsConfig.getInstance().isAcaciaUseCustom())
                .setDefaultValue(true)
                .setSaveConsumer(acaciaUseCustomBoolean -> {
                    MoreShieldVariantsConfig.getInstance().setAcaciaUseCustom(acaciaUseCustomBoolean);})
                .setTooltip(Component.translatable("config.shieldTexture_option.moreshieldvariants.acaciaUseCustom.tooltip"))
                .build());
        return configBuilder;

    }

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
           return builder().setParentScreen(parent).build();
        };
    }
}