package net.sealing99.topcomment.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.entity.custom.IronNuggetProjectileEntity;

public class IronNuggetProjectileEntityRenderer extends ProjectileEntityRenderer<IronNuggetProjectileEntity> {
    public IronNuggetProjectileEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(IronNuggetProjectileEntity entity) {
        return Identifier.of(TopCommentMod.MOD_ID, "textures/item/iron_nugget.png");
    }
}
