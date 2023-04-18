package net.p4lm4.forger.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.p4lm4.forger.Forger;
import net.p4lm4.forger.util.KeyBinding;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = Forger.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgerEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
        }
    }

    @Mod.EventBusSubscriber(modid = Forger.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.DRINKING_KEY);
        }
    }
}
