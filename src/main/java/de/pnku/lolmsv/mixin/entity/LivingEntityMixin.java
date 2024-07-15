package de.pnku.lolmsv.mixin.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;




import de.pnku.lolmsv.item.MoreShieldVariantItem;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Shadow protected ItemStack useItem;


    public LivingEntityMixin(EntityType<?> type, Level level) {
        super(type, level);
    }


    @Redirect(method = "handleEntityEvent", at = @At(value = "FIELD", target = "Lnet/minecraft/sounds/SoundEvents;SHIELD_BLOCK:Lnet/minecraft/sounds/SoundEvent;", opcode = Opcodes.GETSTATIC))
    private SoundEvent redirectedShieldBlockSound() {
        if (this.useItem.getItem() instanceof MoreShieldVariantItem) {
            return SoundEvents.SHIELD_BLOCK;
        }
        else {
            return SoundEvents.SHIELD_BLOCK;
        }
    }

    @Inject(method = "getEquipmentSlotForItem", at = @At("TAIL"), cancellable = true)
    private void injectedGetPreferredEquipmentSlot(ItemStack stack, CallbackInfoReturnable<EquipmentSlot> cbireturn) {
        if (stack.getItem() instanceof ShieldItem) {
            cbireturn.setReturnValue(EquipmentSlot.OFFHAND);
        }
    }
}
