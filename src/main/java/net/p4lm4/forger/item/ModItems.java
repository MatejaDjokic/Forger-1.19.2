package net.p4lm4.forger.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.p4lm4.forger.Forger;
import net.p4lm4.forger.block.ModBlocks;
import net.p4lm4.forger.fluid.ModFluids;
import net.p4lm4.forger.item.custom.MalvaniteCrystal;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Forger.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // ITEMS
    public static final RegistryObject<Item> MALVANITE_CRYSTAL = ITEMS.register("malvanite_crystal",
            () -> new MalvaniteCrystal(new Item.Properties().tab(ModCreativeModeTab.FORGER_TAB)));
    public static final RegistryObject<Item> RAW_MALVANITE = ITEMS.register("raw_malvanite",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGER_TAB)));
    public static final RegistryObject<Item> MALVANITE_INGOT = ITEMS.register("malvanite_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGER_TAB)));
    public static final RegistryObject<Item> MALVANITE_NUGGET = ITEMS.register("malvanite_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGER_TAB)));
    public static final RegistryObject<Item> MALVAN_SEEDS = ITEMS.register("malvan_seeds",
            () -> new ItemNameBlockItem(ModBlocks.MALVAN_CROP.get(), new Item.Properties().tab(ModCreativeModeTab.FORGER_TAB)));
    public static final RegistryObject<Item> MALVAN = ITEMS.register("malvan",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGER_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationMod(4f).build())));
    public static final RegistryObject<Item> MALVAN_JUICE_BUCKET = ITEMS.register("malvan_juice_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MALVAN_JUICE,
                    new Item.Properties().tab(ModCreativeModeTab.FORGER_TAB)
                            .craftRemainder(Items.BUCKET)
                            .stacksTo(1)));
    public static final RegistryObject<Item> TUFF_COMPOUND = ITEMS.register("tuff_compound",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGER_TAB)));

    public static final RegistryObject<Item> CALCITE_COMPOUND = ITEMS.register("calcite_compound",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGER_TAB)));

    public static final RegistryObject<Item> DRIPSTONE_COMPOUND = ITEMS.register("dripstone_compound",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FORGER_TAB)));
}
