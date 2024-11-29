package de.pnku.lolmsv.mixin.client;

import java.util.List;
import java.util.Objects;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import de.pnku.lolmsv.MoreShieldVariants;
import de.pnku.lolmsv.config.MoreShieldVariantsConfig;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.special.ShieldSpecialRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import de.pnku.lolmsv.item.MoreShieldVariantItem;


@Mixin(ShieldSpecialRenderer.class)
@Environment(value = EnvType.CLIENT)
public abstract class ShieldSpecialRendererMixin implements ResourceManagerReloadListener {
    @Final @Shadow private ShieldModel model;
    @Unique private List<String> textureConfigCheck = MoreShieldVariantsConfig.textureConfigList;



    @Inject(method = "render(Lnet/minecraft/core/component/DataComponentMap;Lnet/minecraft/world/item/ItemDisplayContext;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IIZ)V", at = @At("TAIL"))
    private void injectedRender(DataComponentMap dataComponentMap, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource source, int light, int overlay, boolean hasFoil, CallbackInfo ci) {
        String itemNameComponent = String.valueOf(dataComponentMap.get(DataComponents.ITEM_NAME));
        String materialName;
        if (itemNameComponent.contains("minecraft.shield")) {materialName = "spruce";}
        else {materialName = String.valueOf(dataComponentMap.get(DataComponents.ITEM_NAME)).replaceAll("[\\s\\S]*lolmsv\\.([A-z_]*)_shield[\\s\\S]*","$1");}
            BannerPatternLayers bannerPatternsComponent = dataComponentMap != null ? (BannerPatternLayers)dataComponentMap.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY) : BannerPatternLayers.EMPTY;
            DyeColor shieldBannerDyeColor = dataComponentMap != null ? (DyeColor)dataComponentMap.get(DataComponents.BASE_COLOR) : null;
            boolean hasBanner = !bannerPatternsComponent.layers().isEmpty() || shieldBannerDyeColor != null;
            poseStack.pushPose();
            poseStack.scale(1.0f, -1.0f, -1.0f);
            boolean usesVanillaTexture = textureConfigCheck.contains(materialName);
            String vanillaTextureModifier = usesVanillaTexture ? "" : "_vanilla" ;
            String path = "entity/shield/" + materialName + "_shield" + vanillaTextureModifier + "_base";
            Material shieldBaseTextureLocation = new Material(Sheets.SHIELD_SHEET, ResourceLocation.tryBuild(MoreShieldVariants.MOD_ID, path));
            Material noPatternShieldBaseTextureLocation = new Material(Sheets.SHIELD_SHEET, ResourceLocation.tryBuild(MoreShieldVariants.MOD_ID, path + "_nopattern"));
            Material spriteIdentifier = hasBanner ? shieldBaseTextureLocation : noPatternShieldBaseTextureLocation;
            VertexConsumer vertexConsumer = spriteIdentifier.sprite().wrap(ItemRenderer.getFoilBuffer(source, this.model.renderType(spriteIdentifier.atlasLocation()), displayContext == ItemDisplayContext.GUI, hasFoil));
            this.model.handle().render(poseStack, vertexConsumer, light, overlay);
            if (hasBanner) {
                BannerRenderer.renderPatterns(poseStack, source, light, overlay, this.model.plate(), spriteIdentifier, false, Objects.requireNonNullElse(shieldBannerDyeColor, DyeColor.WHITE), bannerPatternsComponent, hasFoil, false);
            }
            else {
                this.model.plate().render(poseStack, vertexConsumer, light, overlay);
            }
            poseStack.popPose();
    }
}
