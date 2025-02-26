package de.pnku.lolmsv;

import de.pnku.lolmsv.item.MoreShieldVariantItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MoreShieldVariants implements ModInitializer {

	public static final String MOD_ID = "lolmsv";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static boolean isExtraShieldsLoaded = false;

	
	@Override
	public void onInitialize() {
		if (FabricLoader.getInstance().isModLoaded("shields")){
			isExtraShieldsLoaded = true;
		}
		if (!isExtraShieldsLoaded) {
		MoreShieldVariantItems.registerShieldItems();
		}
	}

}
