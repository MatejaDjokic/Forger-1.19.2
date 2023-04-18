package net.p4lm4.forger.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.p4lm4.forger.Forger;
import net.p4lm4.forger.block.ModBlocks;
import net.p4lm4.forger.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Forger.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_MALVAN_JUICE = FLUIDS.register("malvan_juice",
            () -> new ForgeFlowingFluid.Source(ModFluids.MALVAN_JUICE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MALVAN_JUICE = FLUIDS.register("flowing_malvan_juice",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MALVAN_JUICE_FLUID_PROPERTIES));
    public static final ForgeFlowingFluid.Properties MALVAN_JUICE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MALVAN_JUICE_FLUID_TYPE, SOURCE_MALVAN_JUICE, FLOWING_MALVAN_JUICE)
            .slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.MALVAN_JUICE_BLOCK)
            .bucket(ModItems.MALVAN_JUICE_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
