package net.swutm.various_update.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.swutm.various_update.block.ModBlocks;
import net.swutm.various_update.various_update;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, various_update.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY =
            CONFIGURED_FEATURES.register("cherry", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.CHERRY_LOG.get()),
                            new StraightTrunkPlacer(3, 2, 2),
                            BlockStateProvider.simple(ModBlocks.CHERRY_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(4), ConstantInt.of(3), 5),
                            new TwoLayersFeatureSize(1, 1, 3)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_SPAWN =
            CONFIGURED_FEATURES.register("cherry_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.CHERRY_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.CHERRY_CHECKED.getHolder().get())));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
