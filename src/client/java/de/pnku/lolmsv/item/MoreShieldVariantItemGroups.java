package de.pnku.lolmsv.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.*;

@Environment(value = EnvType.CLIENT)
public class MoreShieldVariantItemGroups {

    public static void registerMoreShieldVariantItemGroups() {

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries -> entries.insertAfter(Items.SHIELD, MoreShieldVariantItems.ACACIA_SHIELD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries -> entries.insertAfter(MoreShieldVariantItems.ACACIA_SHIELD, MoreShieldVariantItems.BAMBOO_SHIELD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries -> entries.insertAfter(MoreShieldVariantItems.BAMBOO_SHIELD, MoreShieldVariantItems.CHERRY_SHIELD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries -> entries.insertAfter(MoreShieldVariantItems.CHERRY_SHIELD, MoreShieldVariantItems.BIRCH_SHIELD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries -> entries.insertAfter(MoreShieldVariantItems.BIRCH_SHIELD, MoreShieldVariantItems.CRIMSON_SHIELD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries -> entries.insertAfter(MoreShieldVariantItems.CRIMSON_SHIELD, MoreShieldVariantItems.DARK_OAK_SHIELD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries -> entries.insertAfter(MoreShieldVariantItems.DARK_OAK_SHIELD, MoreShieldVariantItems.PALE_OAK_SHIELD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries -> entries.insertAfter(MoreShieldVariantItems.PALE_OAK_SHIELD, MoreShieldVariantItems.JUNGLE_SHIELD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries -> entries.insertAfter(MoreShieldVariantItems.JUNGLE_SHIELD, MoreShieldVariantItems.MANGROVE_SHIELD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries -> entries.insertAfter(MoreShieldVariantItems.MANGROVE_SHIELD, MoreShieldVariantItems.OAK_SHIELD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries -> entries.insertAfter(MoreShieldVariantItems.OAK_SHIELD, MoreShieldVariantItems.WARPED_SHIELD));

    }

}
