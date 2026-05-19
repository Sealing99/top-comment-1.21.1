package net.sealing99.topcomment;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.sealing99.topcomment.block.ModBlockEntities;
import net.sealing99.topcomment.block.ModBlocks;
import net.sealing99.topcomment.block.custom.triangularcake.entity.TriangularCakeBlockEntity;
import net.sealing99.topcomment.block.custom.triangularcake.renderer.TriangularCakeBlockModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TopCommentModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlockEntityRenderers();

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_CROP, RenderLayer.getCutout());
    }

    private static void registerBlockEntityRenderers() {
        BlockEntityRendererRegistry.register(
                ModBlockEntities.TRIANGULAR_CAKE_BLOCK_ENTITY,
                context -> new GeoBlockRenderer<TriangularCakeBlockEntity>(new TriangularCakeBlockModel())
        );
    }
}
