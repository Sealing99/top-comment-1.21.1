package net.sealing99.topcomment.block.custom.triangularcake.item;

import net.minecraft.block.Block;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.item.BlockItem;
import net.sealing99.topcomment.block.custom.triangularcake.renderer.TriangularCakeItemRenderer;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class TriangularCakeBlockItem extends BlockItem implements GeoItem {
    private final AnimatableInstanceCache CACHE = GeckoLibUtil.createInstanceCache(this);

    public TriangularCakeBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.CACHE;
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private TriangularCakeItemRenderer renderer;

            @Override
            public BuiltinModelItemRenderer getGeoItemRenderer() {
                if (this.renderer == null) {
                    this.renderer = new TriangularCakeItemRenderer();
                }
                return this.renderer;
            }
        });
    }
}
