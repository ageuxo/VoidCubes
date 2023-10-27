package io.github.ageuxo.void_cube.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import io.github.ageuxo.void_cube.VoidCubeBlockEntity;
import io.github.ageuxo.void_cube.VoidCubeMod;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.TheEndPortalBlockEntity;

public class VoidCubeBERenderer implements BlockEntityRenderer<VoidCubeBlockEntity> {
    protected final BlockRenderDispatcher blockRenderDispatcher;

    public VoidCubeBERenderer(BlockEntityRendererProvider.Context context) {
        this.blockRenderDispatcher = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(VoidCubeBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        Matrix4f matrix4f = poseStack.last().pose();
        this.renderCube(blockEntity, matrix4f, multiBufferSource.getBuffer(blockEntity.getRenderType()));
        if (blockEntity.shouldRenderOverlay()){
            poseStack.scale(1.002f, 1.002f, 1.002f);
            poseStack.translate(-0.001, -0.001, -0.001);
            this.renderOverlay(poseStack, multiBufferSource, packedLight, packedOverlay);
        }
        poseStack.popPose();
    }

    protected void renderOverlay(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay){
        ModelBlockRenderer modelRenderer = this.blockRenderDispatcher.getModelRenderer();
        BakedModel blockModel = this.blockRenderDispatcher.getBlockModelShaper().getBlockModel(VoidCubeMod.VOID_CUBE.defaultBlockState());
        modelRenderer.renderModel(poseStack.last(), multiBufferSource.getBuffer(RenderType.translucent()), VoidCubeMod.VOID_CUBE.defaultBlockState(),
                blockModel, 0, 255, 0, packedLight, packedOverlay);
    }

    protected void renderCube(VoidCubeBlockEntity blockEntity, Matrix4f matrix4f, VertexConsumer vertexConsumer) {
        float offsetDown = 0.0F;
        float offsetUp = 1.0F;
        this.renderFace(blockEntity, matrix4f, vertexConsumer, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, Direction.SOUTH);
        this.renderFace(blockEntity, matrix4f, vertexConsumer, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, Direction.NORTH);
        this.renderFace(blockEntity, matrix4f, vertexConsumer, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, Direction.EAST);
        this.renderFace(blockEntity, matrix4f, vertexConsumer, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, Direction.WEST);
        this.renderFace(blockEntity, matrix4f, vertexConsumer, 0.0F, 1.0F, offsetDown, offsetDown, 0.0F, 0.0F, 1.0F, 1.0F, Direction.DOWN);
        this.renderFace(blockEntity, matrix4f, vertexConsumer, 0.0F, 1.0F, offsetUp, offsetUp, 1.0F, 1.0F, 0.0F, 0.0F, Direction.UP);
    }

    private void renderFace(VoidCubeBlockEntity blockEntity, Matrix4f matrix4f, VertexConsumer vertexConsumer, float f, float g, float h, float i, float j, float k, float l, float m, Direction direction) {
        if (blockEntity.shouldRenderFace(direction)){
            vertexConsumer.vertex(matrix4f, f, h, j).endVertex();
            vertexConsumer.vertex(matrix4f, g, h, k).endVertex();
            vertexConsumer.vertex(matrix4f, g, i, l).endVertex();
            vertexConsumer.vertex(matrix4f, f, i, m).endVertex();
        }
    }

    @Override
    public int getViewDistance() {
        return 256;
    }

}
