package net.sealing99.topcomment.block;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.block.custom.triangularcake.entity.TriangularCakeBlockEntity;

public class ModBlockEntities {
    public static final BlockEntityType<TriangularCakeBlockEntity> TRIANGULAR_CAKE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,
                    Identifier.of(TopCommentMod.MOD_ID, "triangular_cake_entity"),
                    BlockEntityType.Builder.create(TriangularCakeBlockEntity::new, ModBlocks.TRIANGULAR_CAKE)
                            .build(null));

    public static void registerBlockEntities() {
        TopCommentMod.LOGGER.info("Registering Block Entities for " + TopCommentMod.MOD_ID);
    }
}

