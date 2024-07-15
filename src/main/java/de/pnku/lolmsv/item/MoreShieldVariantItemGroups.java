package de.pnku.lolmsv.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.*;

public class MoreShieldVariantItemGroups {

    public static void registerMoreShieldVariantItemGroups() {

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(Items.SHIELD, MoreShieldVariantItems.ACACIA_SHIELD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(MoreShieldVariantItems.ACACIA_SHIELD, MoreShieldVariantItems.BAMBOO_SHIELD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(MoreShieldVariantItems.BAMBOO_SHIELD, MoreShieldVariantItems.CHERRY_SHIELD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(MoreShieldVariantItems.CHERRY_SHIELD, MoreShieldVariantItems.BIRCH_SHIELD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(MoreShieldVariantItems.BIRCH_SHIELD, MoreShieldVariantItems.CRIMSON_SHIELD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(MoreShieldVariantItems.CRIMSON_SHIELD, MoreShieldVariantItems.DARK_OAK_SHIELD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(MoreShieldVariantItems.DARK_OAK_SHIELD, MoreShieldVariantItems.JUNGLE_SHIELD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(MoreShieldVariantItems.JUNGLE_SHIELD, MoreShieldVariantItems.MANGROVE_SHIELD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(MoreShieldVariantItems.MANGROVE_SHIELD, MoreShieldVariantItems.SPRUCE_SHIELD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(MoreShieldVariantItems.SPRUCE_SHIELD, MoreShieldVariantItems.OAK_SHIELD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> entries.addAfter(MoreShieldVariantItems.OAK_SHIELD, MoreShieldVariantItems.WARPED_SHIELD));

    }

}
