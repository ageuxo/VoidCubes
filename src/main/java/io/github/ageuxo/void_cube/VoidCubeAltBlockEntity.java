package io.github.ageuxo.void_cube;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class VoidCubeAltBlockEntity extends VoidCubeBlockEntity{
    public VoidCubeAltBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(VoidCubeMod.VOID_CUBE_ALT_BE, blockPos, blockState);
    }

    @Override
    public RenderType getRenderType() {
        return RenderType.endGateway();
    }

}
