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
        shieldTexture.addEntry(configBuilder.entryBuilder()
                .startBooleanToggle(Component.translatable("config.shieldTexture_option.moreshieldvariants.bambooUseCustom"), MoreShieldVariantsConfig.getInstance().isBambooUseCustom())
                .setDefaultValue(true)
                .setSaveConsumer(bambooUseCustomBoolean -> {
                    MoreShieldVariantsConfig.getInstance().setBambooUseCustom(bambooUseCustomBoolean);})
                .setTooltip(Component.translatable("config.shieldTexture_option.moreshieldvariants.bambooUseCustom.tooltip"))
                .build());
        shieldTexture.addEntry(configBuilder.entryBuilder()
                .startBooleanToggle(Component.translatable("config.shieldTexture_option.moreshieldvariants.birchUseCustom"), MoreShieldVariantsConfig.getInstance().isBirchUseCustom())
                .setDefaultValue(true)
                .setSaveConsumer(birchUseCustomBoolean -> {
                    MoreShieldVariantsConfig.getInstance().setBirchUseCustom(birchUseCustomBoolean);})
                .setTooltip(Component.translatable("config.shieldTexture_option.moreshieldvariants.birchUseCustom.tooltip"))
                .build());
        shieldTexture.addEntry(configBuilder.entryBuilder()
                .startBooleanToggle(Component.translatable("config.shieldTexture_option.moreshieldvariants.cherryUseCustom"), MoreShieldVariantsConfig.getInstance().isCherryUseCustom())
                .setDefaultValue(true)
                .setSaveConsumer(cherryUseCustomBoolean -> {
                    MoreShieldVariantsConfig.getInstance().setCherryUseCustom(cherryUseCustomBoolean);})
                .setTooltip(Component.translatable("config.shieldTexture_option.moreshieldvariants.cherryUseCustom.tooltip"))
                .build());
        shieldTexture.addEntry(configBuilder.entryBuilder()
                .startBooleanToggle(Component.translatable("config.shieldTexture_option.moreshieldvariants.crimsonUseCustom"), MoreShieldVariantsConfig.getInstance().isCrimsonUseCustom())
                .setDefaultValue(true)
                .setSaveConsumer(crimsonUseCustomBoolean -> {
                    MoreShieldVariantsConfig.getInstance().setCrimsonUseCustom(crimsonUseCustomBoolean);})
                .setTooltip(Component.translatable("config.shieldTexture_option.moreshieldvariants.crimsonUseCustom.tooltip"))
                .build());
        shieldTexture.addEntry(configBuilder.entryBuilder()
                .startBooleanToggle(Component.translatable("config.shieldTexture_option.moreshieldvariants.darkOakUseCustom"), MoreShieldVariantsConfig.getInstance().isDarkOakUseCustom())
                .setDefaultValue(true)
                .setSaveConsumer(darkOakUseCustomBoolean -> {
                    MoreShieldVariantsConfig.getInstance().setDarkOakUseCustom(darkOakUseCustomBoolean);})
                .setTooltip(Component.translatable("config.shieldTexture_option.moreshieldvariants.darkOakUseCustom.tooltip"))
                .build());
        shieldTexture.addEntry(configBuilder.entryBuilder()
                .startBooleanToggle(Component.translatable("config.shieldTexture_option.moreshieldvariants.jungleUseCustom"), MoreShieldVariantsConfig.getInstance().isJungleUseCustom())
                .setDefaultValue(true)
                .setSaveConsumer(jungleUseCustomBoolean -> {
                    MoreShieldVariantsConfig.getInstance().setJungleUseCustom(jungleUseCustomBoolean);})
                .setTooltip(Component.translatable("config.shieldTexture_option.moreshieldvariants.jungleUseCustom.tooltip"))
                .build());
        shieldTexture.addEntry(configBuilder.entryBuilder()
                .startBooleanToggle(Component.translatable("config.shieldTexture_option.moreshieldvariants.mangroveUseCustom"), MoreShieldVariantsConfig.getInstance().isMangroveUseCustom())
                .setDefaultValue(true)
                .setSaveConsumer(mangroveUseCustomBoolean -> {
                    MoreShieldVariantsConfig.getInstance().setMangroveUseCustom(mangroveUseCustomBoolean);})
                .setTooltip(Component.translatable("config.shieldTexture_option.moreshieldvariants.mangroveUseCustom.tooltip"))
                .build());
        shieldTexture.addEntry(configBuilder.entryBuilder()
                .startBooleanToggle(Component.translatable("config.shieldTexture_option.moreshieldvariants.oakUseCustom"), MoreShieldVariantsConfig.getInstance().isOakUseCustom())
                .setDefaultValue(true)
                .setSaveConsumer(oakUseCustomBoolean -> {
                    MoreShieldVariantsConfig.getInstance().setOakUseCustom(oakUseCustomBoolean);})
                .setTooltip(Component.translatable("config.shieldTexture_option.moreshieldvariants.oakUseCustom.tooltip"))
                .build());
        shieldTexture.addEntry(configBuilder.entryBuilder()
                .startBooleanToggle(Component.translatable("config.shieldTexture_option.moreshieldvariants.spruceUseCustom"), MoreShieldVariantsConfig.getInstance().isSpruceUseCustom())
                .setDefaultValue(true)
                .setSaveConsumer(spruceUseCustomBoolean -> {
                    MoreShieldVariantsConfig.getInstance().setSpruceUseCustom(spruceUseCustomBoolean);})
                .setTooltip(Component.translatable("config.shieldTexture_option.moreshieldvariants.spruceUseCustom.tooltip"))
                .build());
        shieldTexture.addEntry(configBuilder.entryBuilder()
                .startBooleanToggle(Component.translatable("config.shieldTexture_option.moreshieldvariants.warpedUseCustom"), MoreShieldVariantsConfig.getInstance().isWarpedUseCustom())
                .setDefaultValue(true)
                .setSaveConsumer(warpedUseCustomBoolean -> {
                    MoreShieldVariantsConfig.getInstance().setWarpedUseCustom(warpedUseCustomBoolean);})
                .setTooltip(Component.translatable("config.shieldTexture_option.moreshieldvariants.warpedUseCustom.tooltip"))
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