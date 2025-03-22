package de.pnku.lolmsv.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.core.Registry;
import de.pnku.lolmsv.MoreShieldVariants;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

import static net.minecraft.world.item.Items.*;

import java.util.ArrayList;
import java.util.List;


public class MoreShieldVariantItems {

    // Shields
    public static final Item ACACIA_SHIELD = new MoreShieldVariantItem("acacia", setProperties(ACACIA_PLANKS));

    public static final Item BAMBOO_SHIELD = new MoreShieldVariantItem("bamboo", setProperties(BAMBOO_PLANKS));

    public static final Item BIRCH_SHIELD = new MoreShieldVariantItem("birch", setProperties(BIRCH_PLANKS));

    public static final Item CHERRY_SHIELD = new MoreShieldVariantItem("cherry", setProperties(CHERRY_PLANKS));

    public static final Item CRIMSON_SHIELD = new MoreShieldVariantItem("crimson", setProperties(CRIMSON_PLANKS, true));

    public static final Item DARK_OAK_SHIELD = new MoreShieldVariantItem("dark_oak", setProperties(DARK_OAK_PLANKS));

    public static final Item PALE_OAK_SHIELD = new MoreShieldVariantItem("pale_oak", setProperties(PALE_OAK_PLANKS));

    public static final Item JUNGLE_SHIELD = new MoreShieldVariantItem("jungle", setProperties(JUNGLE_PLANKS));

    public static final Item MANGROVE_SHIELD = new MoreShieldVariantItem("mangrove", setProperties(MANGROVE_PLANKS));

    public static final Item OAK_SHIELD = new MoreShieldVariantItem("oak", setProperties(OAK_PLANKS));

    public static final Item WARPED_SHIELD = new MoreShieldVariantItem("warped", setProperties(WARPED_PLANKS, true));

    public static final List<Item> more_shields = new ArrayList<>();

    public static void registerShieldItems() {
        registerShieldItem(ACACIA_SHIELD);
        registerShieldItem(BAMBOO_SHIELD);
        registerShieldItem(BIRCH_SHIELD);
        registerShieldItem(CHERRY_SHIELD);
        registerShieldItem(CRIMSON_SHIELD);
        registerShieldItem(DARK_OAK_SHIELD);
        registerShieldItem(PALE_OAK_SHIELD);
        registerShieldItem(JUNGLE_SHIELD);
        registerShieldItem(MANGROVE_SHIELD);
        registerShieldItem(OAK_SHIELD);
        registerShieldItem(WARPED_SHIELD);
    }


    private static Item.Properties setProperties(Item repairItem) {
        return setProperties(repairItem, false);
    }

    private static Item.Properties setProperties(Item repairItem, Boolean isNether) {
        Item.Properties properties = new Item.Properties().durability(336).component(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY).repairable(repairItem).equippableUnswappable(EquipmentSlot.OFFHAND);
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
