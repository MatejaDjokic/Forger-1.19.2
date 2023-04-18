package net.p4lm4.forger.datagen;


import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.p4lm4.forger.Forger;
import net.p4lm4.forger.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper existingFileHelper) {
        super(gen, Forger.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.DEEPSLATE_MALVANITE_CRYSTAL_ORE);
        simpleBlockWithItem(ModBlocks.DEEPSLATE_MALVANITE_ORE);
        simpleBlockWithItem(ModBlocks.MALVANITE_BLOCK);
        simpleBlockWithItem(ModBlocks.MALVANITE_CRYSTAL_BLOCK);
        simpleBlockWithItem(ModBlocks.MALVANITE_CRYSTAL_ORE);
        simpleBlockWithItem(ModBlocks.MALVANITE_ORE);
        simpleBlockWithItem(ModBlocks.RAW_MALVANITE_BLOCK);

        simpleBlockWithItem(ModBlocks.TUFF_BRICKS);
        simpleBlockWithItem(ModBlocks.CRACKED_TUFF_BRICKS);
        simpleBlockWithItem(ModBlocks.TUFF_TILES);
        simpleBlockWithItem(ModBlocks.CRACKED_TUFF_TILES);
        simpleBlockWithItem(ModBlocks.POLISHED_TUFF);
        simpleBlockWithItem(ModBlocks.COMPOUND_TUFF);

        simpleBlockWithItem(ModBlocks.CALCITE_BRICKS);
        simpleBlockWithItem(ModBlocks.CRACKED_CALCITE_BRICKS);
        simpleBlockWithItem(ModBlocks.CALCITE_TILES);
        simpleBlockWithItem(ModBlocks.CRACKED_CALCITE_TILES);
        simpleBlockWithItem(ModBlocks.POLISHED_CALCITE);
        simpleBlockWithItem(ModBlocks.COMPOUND_CALCITE);

        simpleBlockWithItem(ModBlocks.DRIPSTONE_BRICKS);
        simpleBlockWithItem(ModBlocks.CRACKED_DRIPSTONE_BRICKS);
        simpleBlockWithItem(ModBlocks.DRIPSTONE_TILES);
        simpleBlockWithItem(ModBlocks.CRACKED_DRIPSTONE_TILES);
        simpleBlockWithItem(ModBlocks.POLISHED_DRIPSTONE);
        simpleBlockWithItem(ModBlocks.COMPOUND_DRIPSTONE);

    }

    private void simpleBlockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get());
        simpleBlockItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
