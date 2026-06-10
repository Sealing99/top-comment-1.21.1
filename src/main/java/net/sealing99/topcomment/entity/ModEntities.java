package net.sealing99.topcomment.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.entity.custom.TenThousandTntEntity;

public class ModEntities {
    public static final EntityType<TenThousandTntEntity> TEN_THOUSAND_TNT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TopCommentMod.MOD_ID, "ten_thousand_tnt"),
            EntityType.Builder.create(new EntityType.EntityFactory<TenThousandTntEntity>() {@Override public TenThousandTntEntity create(EntityType<TenThousandTntEntity> type, World world) { return new TenThousandTntEntity(type, world); } },
                    SpawnGroup.MISC)
                            .dimensions(0.98f, 0.98f).build());

    public static void registerModEntities() {
        TopCommentMod.LOGGER.info("Registering Mod Entities for " + TopCommentMod.MOD_ID);
    }
}
