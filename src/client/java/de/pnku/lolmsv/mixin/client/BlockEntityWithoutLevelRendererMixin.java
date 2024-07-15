package de.pnku.lolmsv.mixin.client;

import java.util.List;
import java.util.Objects;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import de.pnku.lolmsv.MoreShieldVariants;
import de.pnku.lolmsv.config.MoreShieldVariantsConfig;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import de.pnku.lolmsv.item.MoreShieldVariantItem;


@Mixin(BlockEntityWithoutLevelRenderer.class)
@Environment(value = EnvType.CLIENT)
public abstract class BlockEntityWithoutLevelRendererMixin implements ResourceManagerReloadListener {
    @Shadow private ShieldModel shieldModel;
    private List<String> textureConfigCheck = MoreShieldVariantsConfig.textureConfigList;



    @Inject(method = "renderByItem", at = @At("TAIL"))
    private void injectedRenderByItem(ItemStack stack, ItemDisplayContext context, PoseStack poseStack, MultiBufferSource vertexConsumers, int light, int overlay, CallbackInfo cbi) {
        if (stack.getItem() instanceof MoreShieldVariantItem) {
            BannerPatternLayers bannerPatternsComponent = (BannerPatternLayers)stack.getOrDefault(DataComponents.BANNER_PATTERNS, (Object)BannerPatternLayers.EMPTY);
            DyeColor dyeColor2 = stack.get(DataComponents.BASE_COLOR);
            boolean bl = !bannerPatternsComponent.layers().isEmpty() || dyeColor2 != null;
            poseStack.pushPose();
            poseStack.scale(1.0f, -1.0f, -1.0f);
            boolean usesVanillaTexture = (textureConfigCheck.contains(((MoreShieldVariantItem) stack.getItem()).msvWoodType));
            String vanillaTextureModifier = usesVanillaTexture ? "_vanilla" : "" ;
            String path = "entity/shield/" + BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath() + vanillaTextureModifier + "_base";
            Material shieldBaseIdentifier = new Material(Sheets.SHIELD_SHEET, ResourceLocation.tryBuild(MoreShieldVariants.MOD_ID, path));
            Material noPatternShieldBaseIdentifier = new Material(Sheets.SHIELD_SHEET, ResourceLocation.tryBuild(MoreShieldVariants.MOD_ID, path + "_nopattern"));
            Material spriteIdentifier = bl ? shieldBaseIdentifier : noPatternShieldBaseIdentifier;
            VertexConsumer vertexConsumer = spriteIdentifier.sprite().wrap(ItemRenderer.getFoilBufferDirect(vertexConsumers, this.shieldModel.renderType(spriteIdentifier.atlasLocation()), true, stack.hasFoil()));
            this.shieldModel.handle().render(poseStack, vertexConsumer, light, overlay);
            if (bl) {
                BannerRenderer.renderPatterns(poseStack, vertexConsumers, light, overlay, this.shieldModel.plate(), spriteIdentifier, false, Objects.requireNonNullElse(dyeColor2, DyeColor.WHITE), bannerPatternsComponent, stack.hasFoil());
            }
            else {
                this.shieldModel.plate().render(poseStack, vertexConsumer, light, overlay);
            }
            poseStack.popPose();
        }
    }


}
