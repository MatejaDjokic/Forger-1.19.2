package net.p4lm4.forger;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.p4lm4.forger.block.ModBlocks;
import net.p4lm4.forger.fluid.ModFluidTypes;
import net.p4lm4.forger.fluid.ModFluids;
import net.p4lm4.forger.item.ModItems;
import net.p4lm4.forger.villager.ModVillagers;
import net.p4lm4.forger.world.feature.ModConfiguredFeatures;
import net.p4lm4.forger.world.feature.ModPlacedFeatures;
import org.slf4j.Logger;

@net.minecraftforge.fml.common.Mod(Forger.MOD_ID)
public class Forger {
    public static final String MOD_ID = "forger";
    public static final int SECONDS = 20;
    public static final float SECONDSf = 20f;
    private static final Logger LOGGER = LogUtils.getLogger();

    public Forger() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });

    }

    @net.minecraftforge.fml.common.Mod.EventBusSubscriber(modid = MOD_ID, bus = net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MALVAN_JUICE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MALVAN_JUICE.get(), RenderType.translucent());
        }
    }

}
