package de.pnku.lolmsv.config;

import java.util.ArrayList;
import java.util.List;

public class MoreShieldVariantsConfig {

    private boolean acaciaUseCustom;
    private static MoreShieldVariantsConfig INSTANCE;
    public static List<String> textureConfigList = new ArrayList<>();

    public MoreShieldVariantsConfig() {
        acaciaUseCustom = true;
    }

    public static MoreShieldVariantsConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MoreShieldVariantsConfig();
        }

        return INSTANCE;
    }

    public void setAcaciaUseCustom(boolean acaciaUseCustom) {
        this.acaciaUseCustom = acaciaUseCustom;
        if (isAcaciaUseCustom()) textureConfigList.add("acacia");
        else textureConfigList.remove("acacia");
    }

    public boolean isAcaciaUseCustom() { return acaciaUseCustom; }

    public void updateConfigs(MoreShieldVariantsConfig config) {
        acaciaUseCustom = config.isAcaciaUseCustom();
    }
}