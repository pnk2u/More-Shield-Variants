package de.pnku.lolmsv.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import de.pnku.lolmsv.MoreShieldVariants;
import de.pnku.lolmsv.config.MoreShieldVariantsConfig;
import de.pnku.lolmsv.item.MoreShieldVariantItem;
import de.pnku.lolmsv.tag.MoreShieldVariantItemTags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

import static de.pnku.lolmsv.MoreShieldVariants.isExtraShieldsLoaded;

@Mixin(BlockEntityWithoutLevelRenderer.class)
@Environment(value = EnvType.CLIENT)
public abstract class BlockEntityWithoutLevelRendererMixin implements ResourceManagerReloadListener {
    @Unique private List<String> textureConfigCheck = MoreShieldVariantsConfig.textureConfigList;

    @WrapOperation(method = "renderByItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private boolean wrappedRenderByItemAtStackIs(ItemStack stack, Item item, Operation<Boolean> original) {
        if (item.equals(Items.SHIELD)) {
            return stack.getItem() instanceof ShieldItem;
        } else return original.call(stack, item);
    }

    @ModifyVariable(method = "renderByItem", at = @At("STORE"))
    private Material modifiedVariableRenderByItemAtShieldMaterial(Material material, ItemStack stack, @Local boolean bl) {
        if ((stack.is(MoreShieldVariantItemTags.SHIELDS) && !isExtraShieldsLoaded)) {
            boolean isVanillaShield = stack.getItem().equals(Items.SHIELD);
            String textureKey = isVanillaShield ? "spruce" : ((MoreShieldVariantItem) stack.getItem()).msvWoodType;
            String shieldPath = isVanillaShield ? "spruce_shield" : BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath();
            String vanillaTextureModifier = textureConfigCheck.contains(textureKey) ? "" : "_vanilla";
            String path = "entity/shield/" + shieldPath + vanillaTextureModifier + "_base" + (bl ? "" : "_nopattern");
            return new Material(Sheets.SHIELD_SHEET, ResourceLocation.tryBuild(MoreShieldVariants.MOD_ID, path));
        } else return material;
    }

}
