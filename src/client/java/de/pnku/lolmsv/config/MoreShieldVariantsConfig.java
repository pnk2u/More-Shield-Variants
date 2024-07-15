package de.pnku.lolmsv.config;

import java.util.ArrayList;
import java.util.List;

public class MoreShieldVariantsConfig {

    private boolean acaciaUseCustom;
    private boolean bambooUseCustom;
    private boolean birchUseCustom;
    private boolean cherryUseCustom;
    private boolean crimsonUseCustom;
    private boolean darkOakUseCustom;
    private boolean jungleUseCustom;
    private boolean mangroveUseCustom;
    private boolean oakUseCustom;
    private boolean spruceUseCustom;
    private boolean warpedUseCustom;
    private static MoreShieldVariantsConfig INSTANCE;
    public static List<String> textureConfigList = new ArrayList<>();

    public MoreShieldVariantsConfig() {
        acaciaUseCustom = true;
        bambooUseCustom = true;
        birchUseCustom = true;
        cherryUseCustom = true;
        crimsonUseCustom = true;
        darkOakUseCustom = true;
        jungleUseCustom = true;
        mangroveUseCustom = true;
        oakUseCustom = true;
        spruceUseCustom = true;
        warpedUseCustom = true;
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

    public void setBambooUseCustom(boolean bambooUseCustom) {
        this.bambooUseCustom = bambooUseCustom;
        if (isBambooUseCustom()) textureConfigList.add("bamboo");
        else textureConfigList.remove("bamboo");
    }

    public boolean isBambooUseCustom() { return bambooUseCustom; }

    public void setBirchUseCustom(boolean birchUseCustom) {
        this.birchUseCustom = birchUseCustom;
        if (isBirchUseCustom()) textureConfigList.add("birch");
        else textureConfigList.remove("birch");
    }

    public boolean isBirchUseCustom() { return birchUseCustom; }

    public void setCherryUseCustom(boolean cherryUseCustom) {
        this.cherryUseCustom = cherryUseCustom;
        if (isCherryUseCustom()) textureConfigList.add("cherry");
        else textureConfigList.remove("cherry");
    }

    public boolean isCherryUseCustom() { return cherryUseCustom; }

    public void setCrimsonUseCustom(boolean crimsonUseCustom) {
        this.crimsonUseCustom = crimsonUseCustom;
        if (isCrimsonUseCustom()) textureConfigList.add("crimson");
        else textureConfigList.remove("crimson");
    }

    public boolean isCrimsonUseCustom() { return crimsonUseCustom; }

    public void setDarkOakUseCustom(boolean darkOakUseCustom) {
        this.darkOakUseCustom = darkOakUseCustom;
        if (isDarkOakUseCustom()) textureConfigList.add("dark_oak");
        else textureConfigList.remove("dark_oak");
    }

    public boolean isDarkOakUseCustom() { return darkOakUseCustom; }

    public void setJungleUseCustom(boolean jungleUseCustom) {
        this.jungleUseCustom = jungleUseCustom;
        if (isJungleUseCustom()) textureConfigList.add("jungle");
        else textureConfigList.remove("jungle");
    }

    public boolean isJungleUseCustom() { return jungleUseCustom; }

    public void setMangroveUseCustom(boolean mangroveUseCustom) {
        this.mangroveUseCustom = mangroveUseCustom;
        if (isMangroveUseCustom()) textureConfigList.add("mangrove");
        else textureConfigList.remove("mangrove");
    }

    public boolean isMangroveUseCustom() { return mangroveUseCustom; }

    public void setOakUseCustom(boolean oakUseCustom) {
        this.oakUseCustom = oakUseCustom;
        if (isOakUseCustom()) textureConfigList.add("oak");
        else textureConfigList.remove("oak");
    }

    public boolean isOakUseCustom() { return oakUseCustom; }

    public void setSpruceUseCustom(boolean spruceUseCustom) {
        this.spruceUseCustom = spruceUseCustom;
        if (isSpruceUseCustom()) textureConfigList.add("spruce");
        else textureConfigList.remove("spruce");
    }

    public boolean isSpruceUseCustom() { return spruceUseCustom; }

    public void setWarpedUseCustom(boolean warpedUseCustom) {
        this.warpedUseCustom = warpedUseCustom;
        if (isWarpedUseCustom()) textureConfigList.add("warped");
        else textureConfigList.remove("warped");
    }

    public boolean isWarpedUseCustom() { return warpedUseCustom; }



    public void updateConfigs(MoreShieldVariantsConfig config) {
        acaciaUseCustom = config.isAcaciaUseCustom();
        bambooUseCustom = config.isBambooUseCustom();
        birchUseCustom = config.isBirchUseCustom();
        cherryUseCustom = config.isCherryUseCustom();
        crimsonUseCustom = config.isCrimsonUseCustom();
        darkOakUseCustom = config.isDarkOakUseCustom();
        jungleUseCustom = config.isJungleUseCustom();
        mangroveUseCustom = config.isMangroveUseCustom();
        oakUseCustom = config.isOakUseCustom();
        spruceUseCustom = config.isSpruceUseCustom();
        warpedUseCustom = config.isWarpedUseCustom();
    }
}