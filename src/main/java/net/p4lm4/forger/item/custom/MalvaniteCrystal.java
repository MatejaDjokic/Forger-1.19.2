package net.p4lm4.forger.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MalvaniteCrystal extends Item {
    public MalvaniteCrystal(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        //if (Screen.hasShiftDown()) {
        //    components.add(Component.literal("Right click you might get lucky").withStyle(ChatFormatting.DARK_PURPLE));
        //} else {
        //    components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.DARK_PURPLE));
        //}
        super.appendHoverText(stack, level, components, flag);
    }
}
