package net.seristic.gramarye.block;

// Import statements
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seristic.gramarye.Gramarye;
import net.seristic.gramarye.item.ModItems;

import java.util.function.Supplier;

// Main class for adding blocks to the game
public class ModBlocks {
    // DeferredRegister for blocks
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Gramarye.MOD_ID);

    // RegistryObjects for each block
    public static final RegistryObject<Block> INFERNAL_STONE = registerBlock("infernal_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
            ));

    public static final RegistryObject<Block> MAGICAL_PLANK = registerBlock("magical_plank",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
            ));

    public static final RegistryObject<Block> ARCANE_RUNESTONE = registerBlock("arcane_runestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .requiresCorrectToolForDrops().strength(3.5f, 5.0f)
            ));

//  This is the block handler that allows me to register the block.
//  Method to register a block and its corresponding item
private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn); // Register block item
    return toReturn;
}

    // Method to register a block's item
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Method to register blocks with the event bus
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}