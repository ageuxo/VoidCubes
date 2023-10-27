package io.github.ageuxo.void_cube;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.TheEndPortalBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class VoidCubeBlockEntity extends TheEndPortalBlockEntity {
    public VoidCubeBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(VoidCubeMod.VOID_CUBE_BE, blockPos, blockState);
    }

    protected VoidCubeBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    public boolean shouldRenderFace(Direction direction) {
        return Block.shouldRenderFace(this.getBlockState(), this.level, this.getBlockPos(), direction, this.getBlockPos().relative(direction));
    }

    public RenderType getRenderType(){
        return RenderType.endPortal();
    }

    public boolean shouldRenderOverlay(){
        return ((VoidCubeBlock) this.getBlockState().getBlock()).shouldRenderOverlay();
    }

}
