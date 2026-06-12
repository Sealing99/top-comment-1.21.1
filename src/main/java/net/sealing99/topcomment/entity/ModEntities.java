package net.sealing99.topcomment.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.entity.custom.DiamondShardProjectileEntity;
import net.sealing99.topcomment.entity.custom.GoldNuggetProjectileEntity;
import net.sealing99.topcomment.entity.custom.IronNuggetProjectileEntity;
import net.sealing99.topcomment.entity.custom.TenThousandTntEntity;

public class ModEntities {
    public static final EntityType<TenThousandTntEntity> TEN_THOUSAND_TNT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TopCommentMod.MOD_ID, "ten_thousand_tnt"),
            EntityType.Builder.<TenThousandTntEntity>create(TenThousandTntEntity::new, SpawnGroup.MISC)
                    .dimensions(0.98f, 0.98f).build());

    public static final EntityType<IronNuggetProjectileEntity> IRON_NUGGET_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TopCommentMod.MOD_ID, "iron_nugget_projectile"),
            EntityType.Builder.<IronNuggetProjectileEntity>create(IronNuggetProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.2f, 0.2f).build());

    public static final EntityType<GoldNuggetProjectileEntity> GOLD_NUGGET_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TopCommentMod.MOD_ID, "gold_nugget_projectile"),
            EntityType.Builder.<GoldNuggetProjectileEntity>create(GoldNuggetProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.2f, 0.2f).build());

    public static final EntityType<DiamondShardProjectileEntity> DIAMOND_SHARD_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TopCommentMod.MOD_ID, "diamond_shard_projectile"),
            EntityType.Builder.<DiamondShardProjectileEntity>create(DiamondShardProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.2f, 0.2f).build());

    public static void registerModEntities() {
        TopCommentMod.LOGGER.info("Registering Mod Entities for " + TopCommentMod.MOD_ID);
    }
}
