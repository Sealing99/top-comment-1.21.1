package net.sealing99.topcomment;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.sealing99.topcomment.block.ModBlockEntities;
import net.sealing99.topcomment.block.ModBlocks;
import net.sealing99.topcomment.block.custom.triangularcake.entity.TriangularCakeBlockEntity;
import net.sealing99.topcomment.block.custom.triangularcake.renderer.TriangularCakeBlockModel;
import net.sealing99.topcomment.entity.ModEntities;
import net.sealing99.topcomment.entity.client.IronNuggetProjectileEntityRenderer;
import net.sealing99.topcomment.entity.client.TenThousandTntEntityRenderer;
import net.sealing99.topcomment.entity.custom.IronNuggetProjectileEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TopCommentModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlockEntityRenderers();
        registerEntityRenderers();

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_CROP, RenderLayer.getCutout());
    }

    private static void registerBlockEntityRenderers() {
        BlockEntityRendererRegistry.register(
                ModBlockEntities.TRIANGULAR_CAKE_BLOCK_ENTITY,
                context -> new GeoBlockRenderer<TriangularCakeBlockEntity>(new TriangularCakeBlockModel())
        );
    }

    private static void registerEntityRenderers() {
        EntityRendererRegistry.register(ModEntities.TEN_THOUSAND_TNT, TenThousandTntEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.IRON_NUGGET_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.GOLD_NUGGET_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.DIAMOND_SHARD_PROJECTILE, FlyingItemEntityRenderer::new);
    }
}
