package de.pnku.lolmsv.mixin.client;

import java.util.List;

import com.llamalad7.mixinextras.sugar.Local;
import de.pnku.lolmsv.MoreShieldVariants;
import de.pnku.lolmsv.config.MoreShieldVariantsConfig;
import net.minecraft.client.model.object.equipment.ShieldModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.special.ShieldSpecialRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import static de.pnku.lolmsv.MoreShieldVariants.isExtraShieldsLoaded;

@Mixin(ShieldSpecialRenderer.class)
@Environment(value = EnvType.CLIENT)
public abstract class ShieldSpecialRendererMixin implements SpecialModelRenderer<DataComponentMap> {
    @Final @Shadow private ShieldModel model;
    @Shadow @Final private SpriteGetter sprites;
    @Unique private List<String> textureConfigCheck = MoreShieldVariantsConfig.textureConfigList;

    @ModifyVariable(method = "submit*", at = @At("STORE"), name = "base")
    private SpriteId modifiedVariableRenderByItemAtShieldMaterial(SpriteId spriteId, DataComponentMap dataComponentMap, @Local(name = "hasPatterns") boolean bl) {
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
                    return new SpriteId(Sheets.SHIELD_SHEET, Identifier.tryBuild(MoreShieldVariants.MOD_ID, path));
                }
            }
            return spriteId;
    }
}
