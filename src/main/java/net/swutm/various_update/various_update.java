package net.swutm.various_update;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.swutm.various_update.block.ModBlocks;
//import net.swutm.various_update.block.entity.ModBlockEntities;
//import net.swutm.various_update.block.entity.ModBlockEntities;
import net.swutm.various_update.block.entity.ModBlockEntities;
import net.swutm.various_update.block.entity.ModWoodTypes;
import net.swutm.various_update.item.ModItems;
import net.swutm.various_update.world.feature.ModConfiguredFeatures;
import net.swutm.various_update.world.feature.ModPlacedFeatures;
import org.slf4j.Logger;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;

@Mod(various_update.MOD_ID)
public class various_update
{
    public static final String MOD_ID = "various_update";
    private static final Logger LOGGER = LogUtils.getLogger();

    public various_update()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);


        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::setup);


    }
    private void clientSetup(final FMLClientSetupEvent event) {
        WoodType.register(ModWoodTypes.BAMBOO);
        WoodType.register(ModWoodTypes.STRIPPED_BAMBOO);
        WoodType.register(ModWoodTypes.CHISELED_STRIPPED_BAMBOO);
        WoodType.register(ModWoodTypes.COOLED_CHERRY);
        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);


    }




    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(ModWoodTypes.BAMBOO);
            Sheets.addWoodType(ModWoodTypes.STRIPPED_BAMBOO);
            Sheets.addWoodType(ModWoodTypes.CHISELED_STRIPPED_BAMBOO);
            Sheets.addWoodType(ModWoodTypes.COOLED_CHERRY);

        });
    }
}
