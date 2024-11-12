package de.pnku.lolmsv.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoreShieldVariantsConfig {

    private boolean acaciaUseCustom;
    private boolean bambooUseCustom;
    private boolean birchUseCustom;
    private boolean cherryUseCustom;
    private boolean crimsonUseCustom;
    private boolean darkOakUseCustom;
    private boolean paleOakUseCustom;
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
        paleOakUseCustom = true;
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
        if (isAcaciaUseCustom() && !textureConfigList.contains("acacia")) textureConfigList.add("acacia");
        else if (!isAcaciaUseCustom()) textureConfigList.removeIf("acacia"::equalsIgnoreCase);
    }

    public boolean isAcaciaUseCustom() { return acaciaUseCustom; }

    public void setBambooUseCustom(boolean bambooUseCustom) {
        this.bambooUseCustom = bambooUseCustom;
        if (isBambooUseCustom() && !textureConfigList.contains("bamboo")) textureConfigList.add("bamboo");
        else if (!isBambooUseCustom()) textureConfigList.removeIf("bamboo"::equalsIgnoreCase);
    }

    public boolean isBambooUseCustom() { return bambooUseCustom; }

    public void setBirchUseCustom(boolean birchUseCustom) {
        this.birchUseCustom = birchUseCustom;
        if (isBirchUseCustom() && !textureConfigList.contains("birch")) textureConfigList.add("birch");
        else if (!isBirchUseCustom()) textureConfigList.removeIf("birch"::equalsIgnoreCase);
    }

    public boolean isBirchUseCustom() { return birchUseCustom; }

    public void setCherryUseCustom(boolean cherryUseCustom) {
        this.cherryUseCustom = cherryUseCustom;
        if (isCherryUseCustom() && !textureConfigList.contains("cherry")) textureConfigList.add("cherry");
        else if (!isCherryUseCustom()) textureConfigList.removeIf("cherry"::equalsIgnoreCase);
    }

    public boolean isCherryUseCustom() { return cherryUseCustom; }

    public void setCrimsonUseCustom(boolean crimsonUseCustom) {
        this.crimsonUseCustom = crimsonUseCustom;
        if (isCrimsonUseCustom() && !textureConfigList.contains("crimson")) textureConfigList.add("crimson");
        else if (!isCrimsonUseCustom()) textureConfigList.removeIf("crimson"::equalsIgnoreCase);
    }

    public boolean isCrimsonUseCustom() { return crimsonUseCustom; }

    public void setDarkOakUseCustom(boolean darkOakUseCustom) {
        this.darkOakUseCustom = darkOakUseCustom;
        if (isDarkOakUseCustom() && !textureConfigList.contains("dark_oak")) textureConfigList.add("dark_oak");
        else if (!isDarkOakUseCustom()) textureConfigList.removeIf("dark_oak"::equalsIgnoreCase);
    }

    public boolean isDarkOakUseCustom() { return darkOakUseCustom; }

    public void setPaleOakUseCustom(boolean paleOakUseCustom) {
        this.paleOakUseCustom = paleOakUseCustom;
        if (isPaleOakUseCustom() && !textureConfigList.contains("pale_oak")) textureConfigList.add("pale_oak");
        else if (!isPaleOakUseCustom()) textureConfigList.removeIf("pale_oak"::equalsIgnoreCase);
    }

    public boolean isPaleOakUseCustom() { return paleOakUseCustom; }

    public void setJungleUseCustom(boolean jungleUseCustom) {
        this.jungleUseCustom = jungleUseCustom;
        if (isJungleUseCustom() && !textureConfigList.contains("jungle")) textureConfigList.add("jungle");
        else if (!isJungleUseCustom()) textureConfigList.removeIf("jungle"::equalsIgnoreCase);
    }

    public boolean isJungleUseCustom() { return jungleUseCustom; }

    public void setMangroveUseCustom(boolean mangroveUseCustom) {
        this.mangroveUseCustom = mangroveUseCustom;
        if (isMangroveUseCustom() && !textureConfigList.contains("mangrove")) textureConfigList.add("mangrove");
        else if (!isMangroveUseCustom()) textureConfigList.removeIf("mangrove"::equalsIgnoreCase);
    }

    public boolean isMangroveUseCustom() { return mangroveUseCustom; }

    public void setOakUseCustom(boolean oakUseCustom) {
        this.oakUseCustom = oakUseCustom;
        if (isOakUseCustom() && !textureConfigList.contains("oak")) textureConfigList.add("oak");
        else if (!isOakUseCustom()) textureConfigList.removeIf("oak"::equalsIgnoreCase);
    }

    public boolean isOakUseCustom() { return oakUseCustom; }

    public void setSpruceUseCustom(boolean spruceUseCustom) {
        this.spruceUseCustom = spruceUseCustom;
        if (isSpruceUseCustom() && !textureConfigList.contains("spruce")) textureConfigList.add("spruce");
        else if (!isSpruceUseCustom()) textureConfigList.removeIf("spruce"::equalsIgnoreCase);
    }

    public boolean isSpruceUseCustom() { return spruceUseCustom; }

    public void setWarpedUseCustom(boolean warpedUseCustom) {
        this.warpedUseCustom = warpedUseCustom;
        if (isWarpedUseCustom() && !textureConfigList.contains("warped")) textureConfigList.add("warped");
        else if (!isWarpedUseCustom()) textureConfigList.removeIf("warped"::equalsIgnoreCase);
    }

    public boolean isWarpedUseCustom() { return warpedUseCustom; }

    public void updateConfigs(MoreShieldVariantsConfig config) {
        acaciaUseCustom = config.isAcaciaUseCustom();
        bambooUseCustom = config.isBambooUseCustom();
        birchUseCustom = config.isBirchUseCustom();
        cherryUseCustom = config.isCherryUseCustom();
        crimsonUseCustom = config.isCrimsonUseCustom();
        darkOakUseCustom = config.isDarkOakUseCustom();
        paleOakUseCustom = config.isPaleOakUseCustom();
        jungleUseCustom = config.isJungleUseCustom();
        mangroveUseCustom = config.isMangroveUseCustom();
        oakUseCustom = config.isOakUseCustom();
        spruceUseCustom = config.isSpruceUseCustom();
        warpedUseCustom = config.isWarpedUseCustom();
    }
    
    public static void initialReadConfig() {
        if (getInstance().isAcaciaUseCustom() && !textureConfigList.contains("acacia")) textureConfigList.add("acacia");
        else if (!getInstance().isAcaciaUseCustom()) textureConfigList.removeIf("acacia"::equalsIgnoreCase);
        if (getInstance().isBambooUseCustom() && !textureConfigList.contains("bamboo")) textureConfigList.add("bamboo");
        else if (!getInstance().isBambooUseCustom()) textureConfigList.removeIf("bamboo"::equalsIgnoreCase);
        if (getInstance().isBirchUseCustom() && !textureConfigList.contains("birch")) textureConfigList.add("birch");
        else if (!getInstance().isBirchUseCustom()) textureConfigList.removeIf("birch"::equalsIgnoreCase);
        if (getInstance().isCherryUseCustom() && !textureConfigList.contains("cherry")) textureConfigList.add("cherry");
        else if (!getInstance().isCherryUseCustom()) textureConfigList.removeIf("cherry"::equalsIgnoreCase);
        if (getInstance().isCrimsonUseCustom() && !textureConfigList.contains("crimson")) textureConfigList.add("crimson");
        else if (!getInstance().isCrimsonUseCustom()) textureConfigList.removeIf("crimson"::equalsIgnoreCase);
        if (getInstance().isDarkOakUseCustom() && !textureConfigList.contains("dark_oak")) textureConfigList.add("dark_oak");
        else if (!getInstance().isDarkOakUseCustom()) textureConfigList.removeIf("dark_oak"::equalsIgnoreCase);
        if (getInstance().isPaleOakUseCustom() && !textureConfigList.contains("pale_oak")) textureConfigList.add("pale_oak");
        else if (!getInstance().isPaleOakUseCustom()) textureConfigList.removeIf("pale_oak"::equalsIgnoreCase);
        if (getInstance().isJungleUseCustom() && !textureConfigList.contains("jungle")) textureConfigList.add("jungle");
        else if (!getInstance().isJungleUseCustom()) textureConfigList.removeIf("jungle"::equalsIgnoreCase);
        if (getInstance().isMangroveUseCustom() && !textureConfigList.contains("mangrove")) textureConfigList.add("mangrove");
        else if (!getInstance().isMangroveUseCustom()) textureConfigList.removeIf("mangrove"::equalsIgnoreCase);
        if (getInstance().isOakUseCustom() && !textureConfigList.contains("oak")) textureConfigList.add("oak");
        else if (!getInstance().isOakUseCustom()) textureConfigList.removeIf("oak"::equalsIgnoreCase);
        if (getInstance().isSpruceUseCustom() && !textureConfigList.contains("spruce")) textureConfigList.add("spruce");
        else if (!getInstance().isSpruceUseCustom()) textureConfigList.removeIf("spruce"::equalsIgnoreCase);
        if (getInstance().isWarpedUseCustom() && !textureConfigList.contains("warped")) textureConfigList.add("warped");
        else if (!getInstance().isWarpedUseCustom()) textureConfigList.removeIf("warped"::equalsIgnoreCase);
    }
}