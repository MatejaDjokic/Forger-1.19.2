package net.p4lm4.forger.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.p4lm4.forger.Forger;
import net.p4lm4.forger.block.ModBlocks;
import net.p4lm4.forger.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Forger.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.MALVANITE_INGOT);
        simpleItem(ModItems.MALVANITE_CRYSTAL);
        simpleItem(ModItems.MALVANITE_NUGGET);
        simpleItem(ModItems.RAW_MALVANITE);
        simpleItem(ModItems.MALVAN_SEEDS);
        simpleItem(ModItems.MALVAN);
        simpleItem(ModItems.MALVAN_JUICE_BUCKET);
        simpleItem(ModItems.TUFF_COMPOUND);
        simpleItem(ModItems.CALCITE_COMPOUND);
        simpleItem(ModItems.DRIPSTONE_COMPOUND);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Forger.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Forger.MOD_ID, "item/" + item.getId().getPath()));
    }
}
