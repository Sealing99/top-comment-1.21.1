package net.sealing99.topcomment.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.entity.custom.IronNuggetProjectileEntity;

public class DiamondShardProjectileEntityRenderer extends ProjectileEntityRenderer<IronNuggetProjectileEntity> {
    public DiamondShardProjectileEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(IronNuggetProjectileEntity entity) {
        return Identifier.of(TopCommentMod.MOD_ID, "textures/item/diamond_shard.png");
    }
}
