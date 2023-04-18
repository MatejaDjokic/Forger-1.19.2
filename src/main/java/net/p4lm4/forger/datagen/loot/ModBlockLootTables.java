package net.p4lm4.forger.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.p4lm4.forger.block.ModBlocks;
import net.p4lm4.forger.block.custom.MalvanCropBlock;
import net.p4lm4.forger.item.ModItems;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.MALVANITE_BLOCK.get());
        this.dropSelf(ModBlocks.MALVANITE_CRYSTAL_BLOCK.get());
        this.dropSelf(ModBlocks.MALVANITE_LAMP.get());
        this.dropSelf(ModBlocks.RAW_MALVANITE_BLOCK.get());

        this.dropSelf(ModBlocks.TUFF_BRICKS.get());
        this.dropSelf(ModBlocks.CRACKED_TUFF_BRICKS.get());
        this.dropSelf(ModBlocks.TUFF_TILES.get());
        this.dropSelf(ModBlocks.CRACKED_TUFF_TILES.get());
        this.dropSelf(ModBlocks.POLISHED_TUFF.get());
        this.dropSelf(ModBlocks.COMPOUND_TUFF.get());

        this.dropSelf(ModBlocks.CALCITE_BRICKS.get());
        this.dropSelf(ModBlocks.CRACKED_CALCITE_BRICKS.get());
        this.dropSelf(ModBlocks.CALCITE_TILES.get());
        this.dropSelf(ModBlocks.CRACKED_CALCITE_TILES.get());
        this.dropSelf(ModBlocks.POLISHED_CALCITE.get());
        this.dropSelf(ModBlocks.COMPOUND_CALCITE.get());

        this.dropSelf(ModBlocks.DRIPSTONE_BRICKS.get());
        this.dropSelf(ModBlocks.CRACKED_DRIPSTONE_BRICKS.get());
        this.dropSelf(ModBlocks.DRIPSTONE_TILES.get());
        this.dropSelf(ModBlocks.CRACKED_DRIPSTONE_TILES.get());
        this.dropSelf(ModBlocks.POLISHED_DRIPSTONE.get());
        this.dropSelf(ModBlocks.COMPOUND_DRIPSTONE.get());

        this.dropSelf(ModBlocks.MALVAN_JUICE_BLOCK.get());

        this.add(ModBlocks.MALVANITE_ORE.get(),
                block -> createOreDrop(ModBlocks.MALVANITE_ORE.get(), ModItems.RAW_MALVANITE.get()));

        this.add(ModBlocks.DEEPSLATE_MALVANITE_ORE.get(),
                block -> createOreDrop(ModBlocks.MALVANITE_ORE.get(), ModItems.RAW_MALVANITE.get()));

        this.add(ModBlocks.MALVANITE_CRYSTAL_ORE.get(),
                block -> createOreDrop(ModBlocks.MALVANITE_CRYSTAL_ORE.get(), ModItems.MALVANITE_CRYSTAL.get()));
        this.add(ModBlocks.DEEPSLATE_MALVANITE_CRYSTAL_ORE.get(),
                block -> createOreDrop(ModBlocks.MALVANITE_CRYSTAL_ORE.get(), ModItems.MALVANITE_CRYSTAL.get()));

        LootItemCondition.Builder builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.MALVAN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MalvanCropBlock.AGE, 5));

        this.add(ModBlocks.MALVAN_CROP.get(), createCropDrops(ModBlocks.MALVAN_CROP.get(), ModItems.MALVAN.get(),
                ModItems.MALVAN_SEEDS.get(), builder));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
