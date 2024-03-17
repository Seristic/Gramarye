package net.seristic.gramarye;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.seristic.gramarye.block.ModBlocks;
import net.seristic.gramarye.item.ModItems;

public class CreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Gramarye.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GRAMARYE_TAB = CREATIVE_MODE_TAB.register("gramarye_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MAGICAL_PAPER.get()))
                    .title(Component.translatable("creativetab.gramarye_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MAGICAL_PAPER.get());
                        pOutput.accept(ModBlocks.MAGICAL_PLANK.get());
                        pOutput.accept(ModBlocks.INFERNAL_STONE.get());
                    }).
                    build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
