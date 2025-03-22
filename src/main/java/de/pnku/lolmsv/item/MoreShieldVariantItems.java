package de.pnku.lolmsv.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.core.Registry;
import de.pnku.lolmsv.MoreShieldVariants;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

import java.util.ArrayList;
import java.util.List;


public class MoreShieldVariantItems {

    // Shields
    public static final Item ACACIA_SHIELD = new MoreShieldVariantItem("acacia", setProperties());
    
    public static final Item BAMBOO_SHIELD = new MoreShieldVariantItem("bamboo", setProperties());

    public static final Item BIRCH_SHIELD = new MoreShieldVariantItem("birch", setProperties());
    
    public static final Item CHERRY_SHIELD = new MoreShieldVariantItem("cherry", setProperties());

    public static final Item CRIMSON_SHIELD = new MoreShieldVariantItem("crimson", setProperties(true));

    public static final Item DARK_OAK_SHIELD = new MoreShieldVariantItem("dark_oak", setProperties());

    public static final Item JUNGLE_SHIELD = new MoreShieldVariantItem("jungle", setProperties());
    
    public static final Item MANGROVE_SHIELD = new MoreShieldVariantItem("mangrove", setProperties());
    
    public static final Item OAK_SHIELD = new MoreShieldVariantItem("oak", setProperties());
    
    public static final Item WARPED_SHIELD = new MoreShieldVariantItem("warped", setProperties(true));

    public static final List<Item> more_shields = new ArrayList<>();

    public static void registerShieldItems() {
        registerShieldItem(ACACIA_SHIELD);
        registerShieldItem(BAMBOO_SHIELD);
        registerShieldItem(BIRCH_SHIELD);
        registerShieldItem(CHERRY_SHIELD);
        registerShieldItem(CRIMSON_SHIELD);
        registerShieldItem(DARK_OAK_SHIELD);
        registerShieldItem(JUNGLE_SHIELD);
        registerShieldItem(MANGROVE_SHIELD);
        registerShieldItem(OAK_SHIELD);
        registerShieldItem(WARPED_SHIELD);
    }


    private static Item.Properties setProperties() {
        return setProperties(false);
    }

    private static Item.Properties setProperties(Boolean isNether) {
        Item.Properties properties = new Item.Properties().durability(336).component(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY);
        if (isNether) properties.fireResistant();
        return properties;
    }

    private static void registerShieldItem(Item shieldItem) {
        String shieldName = ((MoreShieldVariantItem) shieldItem).msvWoodType + "_shield";
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(MoreShieldVariants.MOD_ID, shieldName), shieldItem);
        MoreShieldVariants.LOGGER.info("Registered: " + shieldName);
        more_shields.add(shieldItem);
    }
    
}
