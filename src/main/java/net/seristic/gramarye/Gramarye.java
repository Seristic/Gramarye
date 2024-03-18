package net.seristic.gramarye;

// Import statements
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.seristic.gramarye.block.ModBlocks;
import net.seristic.gramarye.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Gramarye.MOD_ID)
public class Gramarye {

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "gramarye";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // Constructor
    public Gramarye() {
        // Get the mod event bus
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register mod items and blocks
        CreativeModTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    // Method for common setup
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Common setup logic can be added here if needed
    }

    // Method to add items to the creative tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Logic to add items to the creative tab can be added here
    }

    // Method to handle server starting event
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Logic to handle server starting event can be added here
    }

    // Inner class for client-side mod events
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        // Method to handle client setup event
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Logic to handle client setup event can be added here
        }
    }
}