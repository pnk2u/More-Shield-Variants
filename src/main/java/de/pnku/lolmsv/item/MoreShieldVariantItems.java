package de.pnku.lolmsv.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.core.Registry;
import de.pnku.lolmsv.MoreShieldVariants;


public class MoreShieldVariantItems {

    // Shields
    public static final Item ACACIA_SHIELD = MoreShieldVariantItems.registerItem(
            "acacia_shield",
        new MoreShieldVariantItem(
                "acacia", new Item.Properties()
                .durability(336)));
    
    public static final Item BAMBOO_SHIELD = MoreShieldVariantItems.registerItem(
            "bamboo_shield",
        new MoreShieldVariantItem(
                "bamboo", new Item.Properties()
                .durability(336)));

    public static final Item BIRCH_SHIELD = MoreShieldVariantItems.registerItem(
            "birch_shield",
        new MoreShieldVariantItem(
                "birch", new Item.Properties()
                .durability(336)));
    
    public static final Item CHERRY_SHIELD = MoreShieldVariantItems.registerItem(
            "cherry_shield",
        new MoreShieldVariantItem(
                "cherry", new Item.Properties()
                .durability(336)));

    public static final Item CRIMSON_SHIELD = MoreShieldVariantItems.registerItem(
            "crimson_shield",
        new MoreShieldVariantItem(
                "crimson", new Item.Properties()
                .durability(336).fireResistant()));

    public static final Item DARK_OAK_SHIELD = MoreShieldVariantItems.registerItem(
            "dark_oak_shield",
        new MoreShieldVariantItem(
                "dark_oak", new Item.Properties()
                .durability(336)));

    public static final Item JUNGLE_SHIELD = MoreShieldVariantItems.registerItem(
            "jungle_shield",
        new MoreShieldVariantItem(
                "jungle", new Item.Properties()
                .durability(336)));
    
    public static final Item MANGROVE_SHIELD = MoreShieldVariantItems.registerItem(
            "mangrove_shield",
        new MoreShieldVariantItem(
                "mangrove", new Item.Properties()
                .durability(336)));
    
    public static final Item OAK_SHIELD = MoreShieldVariantItems.registerItem(
            "oak_shield",
        new MoreShieldVariantItem(
                "oak", new Item.Properties()
                .durability(336)));
    
    public static final Item SPRUCE_SHIELD = MoreShieldVariantItems.registerItem(
            "spruce_shield",
        new MoreShieldVariantItem(
                "spruce", new Item.Properties()
                .durability(336)));
    
    public static final Item WARPED_SHIELD = MoreShieldVariantItems.registerItem(
            "warped_shield",
        new MoreShieldVariantItem(
                "warped", new Item.Properties()
                .durability(336).fireResistant()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(MoreShieldVariants.MOD_ID, name), item);
    }
    
}
