package net.sealing99.topcomment.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.entity.custom.IronNuggetProjectileEntity;

public class GoldNuggetProjectileEntityRenderer extends ProjectileEntityRenderer<IronNuggetProjectileEntity> {
    public GoldNuggetProjectileEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(IronNuggetProjectileEntity entity) {
        return Identifier.of(TopCommentMod.MOD_ID, "textures/item/gold_nugget.png");
    }
}
