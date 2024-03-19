package net.seristic.gramarye.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seristic.gramarye.Gramarye;
import net.seristic.gramarye.item.custom.CursedItem;

public class ModItems extends Item {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Gramarye.MOD_ID);

    public static final RegistryObject<Item> MAGICAL_PAPER = ITEMS.register("magical_paper",
            () -> new Item(new Item.Properties().stacksTo(1)
            ));
    public static final RegistryObject<Item> FORBIDDEN_FRAGMENT = ITEMS.register("forbidden_fragment",
            () -> new CursedItem(new Item.Properties().stacksTo(1)
                    .rarity(Rarity.EPIC)
            ));

    public ModItems(Properties pProperties) {
        super(pProperties);
    }
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
