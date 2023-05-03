package net.swutm.various_update.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.swutm.various_update.block.ModBlocks;
import net.swutm.various_update.various_update;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, various_update.MOD_ID);

    public static final RegistryObject<PlacedFeature> CHERRY_CHECKED = PLACED_FEATURES.register("cherry_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.CHERRY.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.CHERRY_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> CHERRY_PLACED = PLACED_FEATURES.register("cherry_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHERRY_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(5, 0.5f, 4))));

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
