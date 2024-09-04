package de.pnku.lolmsv.mixin.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Inject(method = "getEquipmentSlotForItem", at = @At("TAIL"), cancellable = true)
    private void injectedGetEquipmentSlotForItem(ItemStack stack, CallbackInfoReturnable<EquipmentSlot> cbireturn) {
        if (stack.getItem() instanceof ShieldItem) {
            cbireturn.setReturnValue(EquipmentSlot.OFFHAND);
        }
    }
}
