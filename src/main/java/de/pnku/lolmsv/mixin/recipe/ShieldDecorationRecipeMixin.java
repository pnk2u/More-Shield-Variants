package de.pnku.lolmsv.mixin.recipe;

import de.pnku.lolmsv.tag.MoreShieldVariantItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.ShieldDecorationRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ShieldDecorationRecipe.class)
public abstract class ShieldDecorationRecipeMixin extends CustomRecipe {


    public ShieldDecorationRecipeMixin(CraftingBookCategory category) {
        super(category);
    }

    @Inject(method = "matches*", at = @At("HEAD"), cancellable = true)
    private void injectedMatches(CraftingContainer craftingContainer, Level level, CallbackInfoReturnable<Boolean> cbireturn) {
        ItemStack itemStack = ItemStack.EMPTY;
        ItemStack itemStack2 = ItemStack.EMPTY;
        for (int i = 0; i < craftingContainer.getContainerSize(); ++i) {
            ItemStack itemStack3 = craftingContainer.getItem(i);
            if (itemStack3.isEmpty()) continue;
            if (itemStack3.getItem() instanceof BannerItem) {
                if (!itemStack2.isEmpty()) {
                    cbireturn.setReturnValue(false);
                }
                itemStack2 = itemStack3;
                continue;
            }
            if (itemStack3.is(MoreShieldVariantItemTags.SHIELDS)) {
                if (!itemStack.isEmpty()) {
                    cbireturn.setReturnValue(false);
                }
                BannerPatternLayers bannerPatternsComponent = itemStack3.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY);
                if (!bannerPatternsComponent.layers().isEmpty()) {
                    cbireturn.setReturnValue(false);
                }
                itemStack = itemStack3;
                continue;
            }
            cbireturn.setReturnValue(false);
        }
        cbireturn.setReturnValue(!itemStack.isEmpty() && !itemStack2.isEmpty());
    }

    @Inject(method = "assemble*", at = @At("HEAD"), cancellable = true)
    private void injectedAssemble(CraftingContainer craftingContainer, HolderLookup.Provider provider, CallbackInfoReturnable<ItemStack> cbireturn) {
        ItemStack itemStack = ItemStack.EMPTY;
        ItemStack itemStack2 = ItemStack.EMPTY;
        for (int i = 0; i < craftingContainer.getContainerSize(); ++i) {
            ItemStack itemStack3 = craftingContainer.getItem(i);
            if (itemStack3.isEmpty()) continue;
            if (itemStack3.getItem() instanceof BannerItem) {
                itemStack = itemStack3;
                continue;
            }
            if (!(itemStack3.is(MoreShieldVariantItemTags.SHIELDS))) continue;
            itemStack2 = itemStack3.copy();
        }
        if (itemStack2.isEmpty()) {
            cbireturn.setReturnValue(itemStack2);
        }
        itemStack2.set(DataComponents.BANNER_PATTERNS, itemStack.get(DataComponents.BANNER_PATTERNS));
        itemStack2.set(DataComponents.BASE_COLOR, ((BannerItem)itemStack.getItem()).getColor());
        cbireturn.setReturnValue(itemStack2);
    }
    
}
