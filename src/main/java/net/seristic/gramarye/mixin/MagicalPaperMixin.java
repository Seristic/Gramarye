package net.seristic.gramarye.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.seristic.gramarye.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class) // Mixin target should be the class that your items extend
public class MagicalPaperMixin {

    @Inject(method = "isFoil", at = @At("HEAD"), cancellable = true)
    public void addGlint(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        // Check if the item is your Magical Paper
        if (stack.getItem() == ModItems.MAGICAL_PAPER.get()) {
            // Add the glint effect
            cir.setReturnValue(true);
        }
    }
}