package io.github.ageuxo.void_cube.client;

import io.github.ageuxo.void_cube.VoidCubeMod;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class VoidCubeClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(VoidCubeMod.VOID_CUBE_BE, VoidCubeBERenderer::new);
        BlockEntityRenderers.register(VoidCubeMod.VOID_CUBE_ALT_BE, VoidCubeBERenderer::new);
    }
}
