package de.pnku.lolmsv.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;


public class MoreShieldVariantItem extends ShieldItem implements Equipable {
    public final String msvWoodType;


    public MoreShieldVariantItem(String msvWoodType, Item.Properties properties) {
        super(properties);
        this.msvWoodType = msvWoodType;
    }

    @Override
    public String getDescriptionId(ItemStack stack) {
        DyeColor dyeColor = stack.get(DataComponents.BASE_COLOR);
        if (dyeColor != null) {
            return this.getDescriptionId() + "." + dyeColor.getName();
        }
        return super.getDescriptionId(stack);
    }

    @Override
    public void onDestroyed(ItemEntity entity) {
            super.onDestroyed(entity);
    }


}
