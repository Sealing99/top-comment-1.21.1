package net.sealing99.topcomment.block.custom.triangularcake.renderer;

import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.block.custom.triangularcake.entity.TriangularCakeBlockEntity;
import software.bernie.geckolib.model.GeoModel;

public class TriangularCakeBlockModel extends GeoModel<TriangularCakeBlockEntity> {
    private static final Identifier MODEL = Identifier.of(TopCommentMod.MOD_ID, "geo/block/triangular_cake.geo.json");
    private static final Identifier TEXTURE = Identifier.of(TopCommentMod.MOD_ID, "textures/block/triangular_cake.png");
    private static final Identifier ANIMATION = Identifier.of(TopCommentMod.MOD_ID, "animations/triangular_cake.animation.json");

    @Override
    public Identifier getModelResource(TriangularCakeBlockEntity animatable) {
        return MODEL;
    }

    @Override
    public Identifier getTextureResource(TriangularCakeBlockEntity animatable) {
        return TEXTURE;
    }

    @Override
    public Identifier getAnimationResource(TriangularCakeBlockEntity animatable) {
        return ANIMATION;
    }
}

