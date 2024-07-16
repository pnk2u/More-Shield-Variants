package de.pnku.lolmsv.mixin.entity;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "disableShield", at = @At("HEAD"))
    public void disableShield(CallbackInfo ci) {
        Player player = (Player) (Object) this;
        player.getCooldowns().addCooldown(player.getUseItem().getItem(), 100);
        player.stopUsingItem();
        player.level().broadcastEntityEvent(player, EntityEvent.SHIELD_DISABLED);
    }




    @Inject(method = "hurtCurrentlyUsedShield", at = @At("HEAD"))
    public void hurtCurrentlyUsedShield(float amount, CallbackInfo ci) {
        Player player = (Player) (Object) this;

        if (!(player.getUseItem().getItem() instanceof ShieldItem)) {
            return;
        }
        if (!player.level().isClientSide) {
            player.awardStat(Stats.ITEM_USED.get(player.getUseItem().getItem()));
        }
        if (amount >= 3.0f) {
            int i = 1 + Mth.floor(amount);
            InteractionHand hand = player.getUsedItemHand();
            player.getUseItem().hurtAndBreak(i, player, ((ShieldItem) player.getUseItem().getItem()).getEquipmentSlot());
            if (player.getUseItem().isEmpty()) {
                if (hand == InteractionHand.MAIN_HAND) {
                    player.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                } else {
                    player.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                }
                player.stopUsingItem();
                player.playSound(SoundEvents.SHIELD_BREAK, 0.8f, 0.8f + player.level().random.nextFloat() * 0.4f);
            }
        }
    }


}
