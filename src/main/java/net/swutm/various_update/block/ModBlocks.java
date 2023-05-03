package net.swutm.various_update.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
//import net.swutm.various_update.block.custom.ModFlammableRotatedPillarBlock;
//import net.swutm.various_update.block.custom.ModStandingSignBlock;
//import net.swutm.various_update.block.custom.ModWallSignBlock;
import net.swutm.various_update.block.custom.ModStandingSignBlock;
import net.swutm.various_update.block.custom.ModWallSignBlock;
import net.swutm.various_update.block.custom.StrippedBambooBlock;
import net.swutm.various_update.block.custom.ModFlammableRotatedPillarBlock;
import net.swutm.various_update.block.entity.ModWoodTypes;
import net.swutm.various_update.item.ModItems;
import net.swutm.various_update.various_update;
import net.swutm.various_update.world.feature.tree.CherryTreeGrower;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, various_update.MOD_ID);

//    Blocks

    public static final RegistryObject<Block> STRIPPED_BAMBOO_BLOCK = registerBlock("stripped_bamboo_block",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.BAMBOO)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> BAMBOO_BLOCK = registerBlock("bamboo_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.BAMBOO)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 15;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 3;
                }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHERRY_WOOD = registerBlock("cherry_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHERRY_LOG = registerBlock("cherry_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHISELED_STRIPPED_BAMBOO_BLOCK = registerBlock("chiseled_stripped_bamboo_block",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHERRY_PLANKS = registerBlock("cherry_planks",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHERRY_LEAVES = registerBlock("cherry_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .requiresCorrectToolForDrops()), CreativeModeTab.TAB_DECORATIONS);

    //Sapling

    public static final RegistryObject<Block> CHERRY_SAPLING = registerBlock("cherry_sapling",
            () -> new SaplingBlock(new CherryTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), CreativeModeTab.TAB_DECORATIONS);


//    Buttons

    public static final RegistryObject<Block> STRIPPED_BAMBOO_BUTTON = registerBlock("stripped_bamboo_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().noCollission().sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> BAMBOO_BUTTON = registerBlock("bamboo_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().noCollission().sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> CHISELED_STRIPPED_BAMBOO_BUTTON = registerBlock("chiseled_stripped_bamboo_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().noCollission().sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> CHERRY_BUTTON = registerBlock("cherry_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().noCollission().sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);

//    Pressure Plate

    public static final RegistryObject<Block> STRIPPED_BAMBOO_PRESSURE_PLATE = registerBlock("stripped_bamboo_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> BAMBOO_PRESSURE_PLATE = registerBlock("bamboo_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> CHISELED_STRIPPED_BAMBOO_PRESSURE_PLATE = registerBlock("chiseled_stripped_bamboo_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> CHERRY_PRESSURE_PLATE = registerBlock("cherry_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_REDSTONE);

//    Stairs

    public static final RegistryObject<Block> STRIPPED_BAMBOO_STAIRS = registerBlock("stripped_bamboo_stairs",
            () -> new StairBlock(() -> ModBlocks.STRIPPED_BAMBOO_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD).strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD))
            , CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> BAMBOO_STAIRS = registerBlock("bamboo_stairs",
            () -> new StairBlock(() -> ModBlocks.BAMBOO_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD).strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD))
            , CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHISELED_STRIPPED_STRIPPED_BAMBOO_STAIRS = registerBlock("chiseled_stripped_bamboo_stairs",
            () -> new StairBlock(() -> ModBlocks.CHISELED_STRIPPED_BAMBOO_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD).strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD))
            , CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHERRY_STAIRS = registerBlock("cherry_stairs",
            () -> new StairBlock(() -> ModBlocks.BAMBOO_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD).strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD))
            , CreativeModeTab.TAB_DECORATIONS);

//    Slabs

    public static final RegistryObject<Block> STRIPPED_BAMBOO_SLAB = registerBlock("stripped_bamboo_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> BAMBOO_SLAB = registerBlock("bamboo_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHISELED_STRIPPED_BAMBOO_SLAB = registerBlock("chiseled_stripped_bamboo_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHERRY_SLAB = registerBlock("cherry_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);

//    Fences

    public static final RegistryObject<Block> STRIPPED_BAMBOO_FENCE = registerBlock("stripped_bamboo_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> BAMBOO_FENCE = registerBlock("bamboo_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHISELED_STRIPPED_BAMBOO_FENCE = registerBlock("chiseled_stripped_bamboo_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHERRY_FENCE = registerBlock("cherry_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);

//    Fence Gate

    public static final RegistryObject<Block> STRIPPED_BAMBOO_FENCE_GATE = registerBlock("stripped_bamboo_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> BAMBOO_FENCE_GATE = registerBlock("bamboo_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHISELED_STRIPPED_BAMBOO_FENCE_GATE = registerBlock("chiseled_stripped_bamboo_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> CHERRY_FENCE_GATE = registerBlock("cherry_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), CreativeModeTab.TAB_DECORATIONS);

//    Doors

    public static final RegistryObject<Block> STRIPPED_BAMBOO_DOOR = registerBlock("stripped_bamboo_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> BAMBOO_DOOR = registerBlock("bamboo_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> CHISELED_STRIPPED_BAMBOO_DOOR = registerBlock("chiseled_stripped_bamboo_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> CHERRY_DOOR = registerBlock("cherry_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_REDSTONE);

//    Trapdoors

    public static final RegistryObject<Block> STRIPPED_BAMBOO_TRAPDOOR = registerBlock("stripped_bamboo_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> BAMBOO_TRAPDOOR = registerBlock("bamboo_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> CHISELED_STRIPPED_BAMBOO_TRAPDOOR = registerBlock("chiseled_stripped_bamboo_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> CHERRY_TRAPDOOR = registerBlock("cherry_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.5f).requiresCorrectToolForDrops().noOcclusion()), CreativeModeTab.TAB_REDSTONE);

    //Signs

    public static final RegistryObject<Block> BAMBOO_WALL_SIGN = registerBlockWithoutBlockItem("bamboo_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.BAMBOO));

    public static final RegistryObject<Block> BAMBOO_SIGN = registerBlockWithoutBlockItem("bamboo_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.BAMBOO));

    public static final RegistryObject<Block> STRIPPED_BAMBOO_WALL_SIGN = registerBlockWithoutBlockItem("stripped_bamboo_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.STRIPPED_BAMBOO));

    public static final RegistryObject<Block> STRIPPED_BAMBOO_SIGN = registerBlockWithoutBlockItem("stripped_bamboo_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.STRIPPED_BAMBOO));

    public static final RegistryObject<Block> CHISELED_STRIPPED_BAMBOO_WALL_SIGN = registerBlockWithoutBlockItem("chiseled_stripped_bamboo_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CHISELED_STRIPPED_BAMBOO));

    public static final RegistryObject<Block> CHISELED_STRIPPED_BAMBOO_SIGN = registerBlockWithoutBlockItem("chiseled_stripped_bamboo_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.CHISELED_STRIPPED_BAMBOO));

        public static final RegistryObject<Block> CHERRY_WALL_SIGN = registerBlockWithoutBlockItem("cherry_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.COOLED_CHERRY));

    public static final RegistryObject<Block> CHERRY_SIGN = registerBlockWithoutBlockItem("cherry_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.COOLED_CHERRY));





    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)) {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add((Component) new TranslatableContents(tooltipKey));
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}