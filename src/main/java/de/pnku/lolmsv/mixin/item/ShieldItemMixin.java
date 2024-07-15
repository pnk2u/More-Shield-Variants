package de.pnku.lolmsv.mixin.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import org.spongepowered.asm.mixin.Mixin;




@Mixin(ShieldItem.class)
public abstract class ShieldItemMixin extends Item {

    
    public ShieldItemMixin(Item.Properties properties) {
        super(properties);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return !stack.isEnchanted();
    }

}
