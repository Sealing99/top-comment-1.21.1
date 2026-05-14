package net.sealing99.topcomment;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.sealing99.topcomment.block.ModBlockEntities;
import net.sealing99.topcomment.block.custom.triangularcake.entity.TriangularCakeBlockEntity;
import net.sealing99.topcomment.block.custom.triangularcake.renderer.TriangularCakeBlockModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TopCommentModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlockEntityRenderers();
    }

    private static void registerBlockEntityRenderers() {
        BlockEntityRendererRegistry.register(
                ModBlockEntities.TRIANGULAR_CAKE_BLOCK_ENTITY,
                context -> new GeoBlockRenderer<TriangularCakeBlockEntity>(new TriangularCakeBlockModel())
        );
    }
}
