package de.pnku.lolmsv.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.core.Registry;
import de.pnku.lolmsv.MoreShieldVariants;


public class MoreShieldVariantItems {

    // Shields
    public static final Item ACACIA_SHIELD = new MoreShieldVariantItem("acacia", new Item.Properties().durability(336));
    
    public static final Item BAMBOO_SHIELD = new MoreShieldVariantItem("bamboo", new Item.Properties().durability(336));

    public static final Item BIRCH_SHIELD = new MoreShieldVariantItem("birch", new Item.Properties().durability(336));
    
    public static final Item CHERRY_SHIELD = new MoreShieldVariantItem("cherry", new Item.Properties().durability(336));

    public static final Item CRIMSON_SHIELD = new MoreShieldVariantItem("crimson", new Item.Properties().durability(337).fireResistant());

    public static final Item DARK_OAK_SHIELD = new MoreShieldVariantItem("dark_oak", new Item.Properties().durability(336));

    public static final Item PALE_OAK_SHIELD = new MoreShieldVariantItem("pale_oak", new Item.Properties().durability(336));

    public static final Item JUNGLE_SHIELD = new MoreShieldVariantItem("jungle", new Item.Properties().durability(336));
    
    public static final Item MANGROVE_SHIELD = new MoreShieldVariantItem("mangrove", new Item.Properties().durability(336));
    
    public static final Item OAK_SHIELD = new MoreShieldVariantItem("oak", new Item.Properties().durability(336));
    
    public static final Item WARPED_SHIELD = new MoreShieldVariantItem("warped", new Item.Properties().durability(337).fireResistant());

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

    private static void registerShieldItem(Item shieldItem) {
        String shieldName = ((MoreShieldVariantItem) shieldItem).msvWoodType + "_shield";
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(MoreShieldVariants.MOD_ID, shieldName), shieldItem);
        MoreShieldVariants.LOGGER.info("Registered: " + shieldName);
    }
    
}
