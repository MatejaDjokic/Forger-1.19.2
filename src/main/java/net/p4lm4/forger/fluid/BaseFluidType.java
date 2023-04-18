package net.p4lm4.forger.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Vector3f;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class BaseFluidType extends FluidType {
    private final ResourceLocation stillTextures;
    private final ResourceLocation flowingTextures;
    private final ResourceLocation overlayTextures;
    private final int tintColor;
    private final Vector3f fogColor;

    public BaseFluidType(Properties properties, ResourceLocation stillTextures, ResourceLocation flowingTextures,
                         ResourceLocation overlayTextures, int tintColor, Vector3f fogColor) {
        super(properties);
        this.stillTextures = stillTextures;
        this.flowingTextures = flowingTextures;
        this.overlayTextures = overlayTextures;
        this.tintColor = tintColor;
        this.fogColor = fogColor;
    }

    public ResourceLocation getStillTextures() {
        return stillTextures;
    }

    public ResourceLocation getFlowingTextures() {
        return flowingTextures;
    }

    public int getTintColor() {
        return tintColor;
    }

    public ResourceLocation getOverlayTextures() {
        return overlayTextures;
    }

    public Vector3f getFogColor() {
        return fogColor;
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return stillTextures;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return flowingTextures;
            }

            @Override
            public @Nullable ResourceLocation getOverlayTexture() {
                return overlayTextures;
            }

            @Override
            public int getTintColor() {
                return tintColor;
            }

            @Override
            public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level,
                                                    int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return fogColor;
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick,
                                        float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart(1f);
                RenderSystem.setShaderFogEnd(6f);
            }
        });
    }
}
