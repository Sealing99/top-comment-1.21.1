package net.sealing99.topcomment.block.renderer;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.sealing99.topcomment.block.entity.TriangularCakeBlockEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TriangularCakeBlockRenderer extends GeoBlockRenderer<TriangularCakeBlockEntity> {
    public TriangularCakeBlockRenderer() {
        super(new TriangularCakeBlockModel());
    }

    @Override
    public void preRender(MatrixStack poseStack, TriangularCakeBlockEntity animatable, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        poseStack.push();

        // Adjust rotation based on facing direction
        switch (animatable.getCachedState().get(net.sealing99.topcomment.block.custom.TriangularCakeBlock.FACING)) {
            case NORTH:
                break;
            case SOUTH:
                poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                break;
            case EAST:
                poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270));
                break;
            case WEST:
                poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
                break;
            default:
                break;
        }

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }

    @Override
    public void postRender(MatrixStack poseStack, TriangularCakeBlockEntity animatable, BakedGeoModel model, VertexConsumerProvider bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        super.postRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        poseStack.pop();
    }
}


