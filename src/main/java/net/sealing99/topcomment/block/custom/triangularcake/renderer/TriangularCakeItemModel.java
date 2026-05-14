package net.sealing99.topcomment.block.custom.triangularcake.renderer;

import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.block.custom.triangularcake.item.TriangularCakeBlockItem;
import software.bernie.geckolib.model.GeoModel;

public class TriangularCakeItemModel extends GeoModel<TriangularCakeBlockItem> {
    @Override
    public Identifier getModelResource(TriangularCakeBlockItem animatable) {
        return Identifier.of(TopCommentMod.MOD_ID, "geo/block/triangular_cake.geo.json");
    }

    @Override
    public Identifier getTextureResource(TriangularCakeBlockItem animatable) {
        return Identifier.of(TopCommentMod.MOD_ID, "textures/block/triangular_cake.png");
    }

    @Override
    public Identifier getAnimationResource(TriangularCakeBlockItem animatable) {
        return null;
    }
}
