package net.seristic.gramarye;

// Import statements
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.seristic.gramarye.block.ModBlocks;
import net.seristic.gramarye.item.ModItems;

// Class for defining a custom creative mode tab
public class CreativeModTab {
    // DeferredRegister for creative mode tabs
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Gramarye.MOD_ID);

    // RegistryObject for the custom creative mode tab
    public static final RegistryObject<CreativeModeTab> GRAMARYE_TAB = CREATIVE_MODE_TAB.register("gramarye_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MAGICAL_PAPER.get())) // Icon for the tab
                    .title(Component.translatable("creativetab.gramarye_tab")) // Title of the tab
                    .displayItems((pParameters, pOutput) -> { // Display items in the tab
                        // Add items to be displayed in the creative mode tab
                        pOutput.accept(ModItems.MAGICAL_PAPER.get());
                        pOutput.accept(ModBlocks.MAGICAL_PLANK.get());
                        pOutput.accept(ModBlocks.INFERNAL_STONE.get());
                        pOutput.accept(ModBlocks.ARCANE_RUNESTONE.get());
                    })
                    .build());

    // Method to register the creative mode tab with the event bus
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}