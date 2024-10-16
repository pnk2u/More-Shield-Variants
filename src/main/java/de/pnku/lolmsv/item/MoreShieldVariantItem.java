package de.pnku.lolmsv.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import static de.pnku.lolmsv.MoreShieldVariants.MOD_ID;


public class MoreShieldVariantItem extends ShieldItem {
    public final String msvWoodType;


    public MoreShieldVariantItem(String msvWoodType, Item.Properties properties) {
        super(properties.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID,msvWoodType + "_shield"))));
        this.msvWoodType = msvWoodType;
    }

    @Override
    public void onDestroyed(ItemEntity entity) {
            super.onDestroyed(entity);
    }


}
