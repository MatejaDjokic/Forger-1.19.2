package net.p4lm4.forger.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static CreativeModeTab FORGER_TAB = new CreativeModeTab("forger_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MALVANITE_CRYSTAL.get());
        }
    };

}
