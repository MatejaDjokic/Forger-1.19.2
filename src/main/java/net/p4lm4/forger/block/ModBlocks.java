package net.p4lm4.forger.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.p4lm4.forger.Forger;
import net.p4lm4.forger.block.custom.MalvanCropBlock;
import net.p4lm4.forger.block.custom.MalvaniteCrystalBlock;
import net.p4lm4.forger.block.custom.MalvaniteLampBlock;
import net.p4lm4.forger.fluid.ModFluids;
import net.p4lm4.forger.item.ModCreativeModeTab;
import net.p4lm4.forger.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Forger.MOD_ID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    // BLOCKS
    public static final RegistryObject<Block> MALVANITE_BLOCK = registerBlock("malvanite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> RAW_MALVANITE_BLOCK = registerBlock("raw_malvanite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> MALVANITE_CRYSTAL_BLOCK = registerBlock("malvanite_crystal_block",
            () -> new MalvaniteCrystalBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(6F)
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> MALVANITE_ORE = registerBlock("malvanite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> DEEPSLATE_MALVANITE_ORE = registerBlock("deepslate_malvanite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.DEEPSLATE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> MALVANITE_CRYSTAL_ORE = registerBlock("malvanite_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> DEEPSLATE_MALVANITE_CRYSTAL_ORE = registerBlock("deepslate_malvanite_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .sound(SoundType.DEEPSLATE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> MALVANITE_LAMP = registerBlock("malvanite_lamp",
            () -> new RedstoneLampBlock(BlockBehaviour.Properties.of(Material.BUILDABLE_GLASS)
                    .lightLevel(state -> state.getValue(MalvaniteLampBlock.LIT) ? 15 : 0)
                    .strength(0.3F)
                    .sound(SoundType.GLASS)), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> MALVAN_CROP = BLOCKS.register("malvan_crop",
            () -> new MalvanCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    public static final RegistryObject<LiquidBlock> MALVAN_JUICE_BLOCK = BLOCKS.register("malvan_juice_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MALVAN_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<Block> TUFF_BRICKS = registerBlock("tuff_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.TUFF)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> CRACKED_TUFF_BRICKS = registerBlock("cracked_tuff_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.TUFF)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> TUFF_TILES = registerBlock("tuff_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.TUFF)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> CRACKED_TUFF_TILES = registerBlock("cracked_tuff_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.TUFF)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> POLISHED_TUFF = registerBlock("polished_tuff",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.TUFF)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> COMPOUND_TUFF = registerBlock("compound_tuff",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.TUFF)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);

    public static final RegistryObject<Block> CALCITE_BRICKS = registerBlock("calcite_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.CALCITE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> CRACKED_CALCITE_BRICKS = registerBlock("cracked_calcite_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.CALCITE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> CALCITE_TILES = registerBlock("calcite_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.CALCITE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> CRACKED_CALCITE_TILES = registerBlock("cracked_calcite_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.CALCITE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> POLISHED_CALCITE = registerBlock("polished_calcite",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.CALCITE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> COMPOUND_CALCITE = registerBlock("compound_calcite",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.CALCITE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);

    public static final RegistryObject<Block> DRIPSTONE_BRICKS = registerBlock("dripstone_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> CRACKED_DRIPSTONE_BRICKS = registerBlock("cracked_dripstone_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> DRIPSTONE_TILES = registerBlock("dripstone_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> CRACKED_DRIPSTONE_TILES = registerBlock("cracked_dripstone_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> POLISHED_DRIPSTONE = registerBlock("polished_dripstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);
    public static final RegistryObject<Block> COMPOUND_DRIPSTONE = registerBlock("compound_dripstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.FORGER_TAB);

}
