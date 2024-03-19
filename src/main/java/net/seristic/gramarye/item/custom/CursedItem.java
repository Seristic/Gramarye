package net.seristic.gramarye.item.custom;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.level.NoteBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.seristic.gramarye.item.ModItems;


public class CursedItem extends Item {
    public static final float BASE_DAMAGE_AMOUNT = 1.0f;
    public static final int COOLDOWN_TICKS = 100;
    private long lastHitTime;
    private int fragmentCount; // Track the number of fragments held by the player

    public CursedItem(Properties pProperties) {
        super(pProperties);
        this.fragmentCount = 0; // Initialize fragment count
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

        // Ensure the entity is a player and that the cooldown has elapsed
        if (pEntity instanceof Player && hasCooldownElapsed(pLevel)) {
            Player player = (Player) pEntity;

            // Apply damage if the player holds the forbidden fragment
            if (pStack.getItem() == ModItems.FORBIDDEN_FRAGMENT.get()) {
                DamageSource damageSource = pLevel.damageSources().generic();

                // Calculate damage based on the number of fragments held
                float damageAmount = calculateDamageAmount();
                player.hurt(damageSource, damageAmount);

                // Update the last hit time
                lastHitTime = pLevel.getGameTime();
            }
        }
    }
    private boolean hasCooldownElapsed(Level level) {
        long currentTime = level.getGameTime();
        return currentTime - lastHitTime >= COOLDOWN_TICKS;
    }
    private float calculateDamageAmount() {
        fragmentCount++;

        return BASE_DAMAGE_AMOUNT * (1.0f + fragmentCount * 0.5f);
    }
    @SubscribeEvent
    private static void onItemToss(ItemTossEvent event) {
        //  Return to this at a later stage to fix the issue with the calculation not resetting to the amount of fragments.
    }
}