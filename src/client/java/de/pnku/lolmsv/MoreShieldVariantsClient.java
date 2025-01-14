package de.pnku.lolmsv;

import de.pnku.lolmsv.config.MoreShieldVariantsConfig;
import de.pnku.lolmsv.config.MoreShieldVariantsConfigJsonHelper;
import de.pnku.lolmsv.item.MoreShieldVariantItemGroups;
import de.pnku.lolmsv.item.MoreShieldVariantModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import static de.pnku.lolmsv.MoreShieldVariants.isExtraShieldsLoaded;


@Environment(value = EnvType.CLIENT)
public class MoreShieldVariantsClient implements ClientModInitializer {

    
    @Override
    public void onInitializeClient() {
        MoreShieldVariantsConfigJsonHelper.init();
        MoreShieldVariantsConfig.initialReadConfig();
        if (!isExtraShieldsLoaded) {
            MoreShieldVariantModelPredicateProvider.registerMoreShieldVariantItemModelPredicates();
            MoreShieldVariantItemGroups.registerMoreShieldVariantItemGroups();
        }
    }
    
}
