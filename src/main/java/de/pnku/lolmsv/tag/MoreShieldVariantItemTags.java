package de.pnku.lolmsv.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import de.pnku.lolmsv.MoreShieldVariants;


public class MoreShieldVariantItemTags {
    public static final TagKey<Item> SHIELDS = TagKey.create(Registries.ITEM, ResourceLocation.tryBuild(MoreShieldVariants.MOD_ID, "shields"));
}
