package uk.protonull.civianmod.mixins;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import uk.protonull.civianmod.features.CivianItemStack;

@Mixin(GuiGraphics.class)
public abstract class GuiGraphicsMixin {
    @ModifyVariable(
        method = "renderItemCount",
        at = @At("HEAD"),
        argsOnly = true
    )
    protected @Nullable String civianmod$alwaysShowItemAmountIfCompacted(
        final String value,
        final @Local(argsOnly = true) ItemStack item
    ) {
        if (value != null) {
            return value;
        }
        if (((CivianItemStack) (Object) item).civianmod$alwaysShowAmountDecoration()) {
            return String.valueOf(item.getCount());
        }
        return null;
    }

    @ModifyConstant(
        method = "renderItemCount",
        constant = @Constant(intValue = CivianItemStack.DEFAULT_AMOUNT_DECORATION_COLOUR)
    )
    protected int civianmod$renderItemDecorations$colourItemDecorationIfCompacted(
        final int decorationColour,
        final @Local(argsOnly = true) ItemStack item
    ) {
        return ((CivianItemStack) (Object) item).civianmod$amountDecorationColour();
    }
}
