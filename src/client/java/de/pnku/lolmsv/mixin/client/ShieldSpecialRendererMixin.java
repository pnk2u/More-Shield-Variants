package de.pnku.lolmsv.mixin.client;

import java.util.List;

import com.llamalad7.mixinextras.sugar.Local;
import de.pnku.lolmsv.MoreShieldVariants;
import de.pnku.lolmsv.config.MoreShieldVariantsConfig;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.special.ShieldSpecialRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import static de.pnku.lolmsv.MoreShieldVariants.isExtraShieldsLoaded;

@Mixin(ShieldSpecialRenderer.class)
@Environment(value = EnvType.CLIENT)
public abstract class ShieldSpecialRendererMixin implements ResourceManagerReloadListener {
    @Final @Shadow private ShieldModel model;
    @Unique private List<String> textureConfigCheck = MoreShieldVariantsConfig.textureConfigList;

    @ModifyVariable(method = "render(Lnet/minecraft/core/component/DataComponentMap;Lnet/minecraft/world/item/ItemDisplayContext;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IIZ)V", at = @At("STORE"))
    private Material modifiedVariableRenderByItemAtShieldMaterial(Material material, DataComponentMap dataComponentMap, @Local(ordinal = 1) boolean bl) {
            ComponentContents contents = ((Component) dataComponentMap.getOrDefault(DataComponents.ITEM_NAME, "")).getContents();
            if (contents instanceof TranslatableContents translatableContents) {
                String itemKey = translatableContents.getKey();
                String msvPrefix = "item." + MoreShieldVariants.MOD_ID + ".";
                boolean isVanillaShield = itemKey.equals("item.minecraft.shield");
                boolean isMoreShield = itemKey.startsWith(msvPrefix);
                if ((isVanillaShield || isMoreShield) && !isExtraShieldsLoaded) {
                    String textureKey = isVanillaShield ? "spruce" : itemKey.replace(msvPrefix, "").replace("_shield", "");
                    String shieldPath = isVanillaShield ? "spruce_shield" : itemKey.replace(msvPrefix, "");
                    String vanillaTextureModifier = textureConfigCheck.contains(textureKey) ? "" : "_vanilla";
                    String path = "entity/shield/" + shieldPath + vanillaTextureModifier + "_base" + (bl ? "" : "_nopattern");
                    return new Material(Sheets.SHIELD_SHEET, ResourceLocation.tryBuild(MoreShieldVariants.MOD_ID, path));
                }
            }
            return material;
    }
}
