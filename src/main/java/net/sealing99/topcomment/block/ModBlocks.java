package net.sealing99.topcomment.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.block.custom.TriangularCakeBlock;
import net.sealing99.topcomment.block.entity.ModBlockEntities;

public class ModBlocks {
    public static final Block TRIANGULAR_CAKE = registerBlock("triangular_cake",
            new TriangularCakeBlock(AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .nonOpaque()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.WOOL)
                    .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TopCommentMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(
                Registries.ITEM, Identifier.of(TopCommentMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings())
        );
    }

    public static void registerModBlocks() {
        TopCommentMod.LOGGER.info("Registering Mod Blocks for " + TopCommentMod.MOD_ID);
        ModBlockEntities.registerBlockEntities();
    }
}
