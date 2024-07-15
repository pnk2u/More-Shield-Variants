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

//    public SoundEvent getHitSoundEvent() {
//        if (this.isFramed || this.repairIngredient == ToolMaterials.WOOD.getRepairIngredient()) {
//            return SoundEvents.ITEM_SHIELD_BLOCK;
//        }
//        else {
//            if (this.repairIngredient == ModToolMaterials.MANGROVE.getRepairIngredient()) {
//                return ModSoundEvents.MANGROVE_SHIELD_BLOCK;
//            }
//            else if (this.repairIngredient == ToolMaterials.GOLD.getRepairIngredient()) {
//                return ModSoundEvents.OAK_SHIELD_BLOCK;
//            }
//            else if (this.repairIngredient == ToolMaterials.IRON.getRepairIngredient()) {
//                return ModSoundEvents.SPRUCE_SHIELD_BLOCK;
//            }
//            else if (this.repairIngredient == ToolMaterials.WARPED.getRepairIngredient()) {
//                return ModSoundEvents.WARPED_SHIELD_BLOCK;
//            }
//            return ModSoundEvents.NETHERITE_SHIELD_BLOCK;
//        }
//    }

    @Override
    public void onDestroyed(ItemEntity entity) {
            super.onDestroyed(entity);
    }


}
