package net.p4lm4.forger.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.p4lm4.forger.Forger;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Forger.MOD_ID);

    public static final RegistryObject<PlacedFeature> MALVANITE_ORE_PLACED = PLACED_FEATURES.register("malvanite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MALVANITE_ORE.getHolder().get(),
                    commonOrePlacement(5,
                            HeightRangePlacement.triangle(
                                    VerticalAnchor.absolute(-24),
                                    VerticalAnchor.absolute(56)))));
    public static final RegistryObject<PlacedFeature> MALVANITE_CRYSTAL_ORE_PLACED = PLACED_FEATURES.register("malvanite_crystal_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MALVANITE_CRYSTAL_ORE.getHolder().get(),
                    commonOrePlacement(5, // VEINS PER CHUNK,
                            HeightRangePlacement.triangle(
                                    VerticalAnchor.absolute(-24),
                                    VerticalAnchor.absolute(56)))));

    private static List<PlacementModifier> orePlacement(PlacementModifier modifier, PlacementModifier modifier1) {
        return List.of(modifier, InSquarePlacement.spread(), modifier1, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier modifier) {
        return orePlacement(CountPlacement.of(veinsPerChunk), modifier);
    }

    private static List<PlacementModifier> rareOrePlacement(int veinsPerChunk, PlacementModifier modifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(veinsPerChunk), modifier);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
