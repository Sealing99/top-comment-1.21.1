package net.sealing99.topcomment;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.sealing99.topcomment.block.custom.TriangularCakeBlock;
import net.sealing99.topcomment.block.entity.ModBlockEntities;
import net.sealing99.topcomment.block.entity.TriangularCakeBlockEntity;
import net.sealing99.topcomment.block.renderer.TriangularCakeBlockModel;
import net.sealing99.topcomment.block.renderer.TriangularCakeBlockRenderer;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TopCommentModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlockEntityRenderers();
    }

    private static void registerBlockEntityRenderers() {
        //BlockEntityRendererRegistry.register(ModBlockEntities.TRIANGULAR_CAKE_BLOCK_ENTITY, ctx -> new TriangularCakeBlockRenderer());
        BlockEntityRendererRegistry.register(
                ModBlockEntities.TRIANGULAR_CAKE_BLOCK_ENTITY,
                context -> new GeoBlockRenderer<TriangularCakeBlockEntity>(new TriangularCakeBlockModel())
        );
    }
}
