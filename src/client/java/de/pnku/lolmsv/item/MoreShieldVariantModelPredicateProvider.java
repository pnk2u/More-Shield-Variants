package de.pnku.lolmsv.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;


@Environment(value = EnvType.CLIENT)
public class MoreShieldVariantModelPredicateProvider {
    
    
    public static void registerMoreShieldVariantItemModelPredicates() {

        MoreShieldVariantModelPredicateProvider.registerShield(MoreShieldVariantItems.ACACIA_SHIELD);
        MoreShieldVariantModelPredicateProvider.registerShield(MoreShieldVariantItems.BAMBOO_SHIELD);
        MoreShieldVariantModelPredicateProvider.registerShield(MoreShieldVariantItems.BIRCH_SHIELD);
        MoreShieldVariantModelPredicateProvider.registerShield(MoreShieldVariantItems.CHERRY_SHIELD);
        MoreShieldVariantModelPredicateProvider.registerShield(MoreShieldVariantItems.CRIMSON_SHIELD);
        MoreShieldVariantModelPredicateProvider.registerShield(MoreShieldVariantItems.DARK_OAK_SHIELD);
        MoreShieldVariantModelPredicateProvider.registerShield(MoreShieldVariantItems.JUNGLE_SHIELD);
        MoreShieldVariantModelPredicateProvider.registerShield(MoreShieldVariantItems.MANGROVE_SHIELD);
        MoreShieldVariantModelPredicateProvider.registerShield(MoreShieldVariantItems.OAK_SHIELD);
        MoreShieldVariantModelPredicateProvider.registerShield(MoreShieldVariantItems.SPRUCE_SHIELD);
        MoreShieldVariantModelPredicateProvider.registerShield(MoreShieldVariantItems.WARPED_SHIELD);
        
    }

    private static void registerShield(Item shield) {
        ItemProperties.register(shield, ResourceLocation.parse("blocking"),
            (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0f : 0.0f);
    }

}
