package net.sealing99.topcomment.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.block.custom.CornCropBlock;
import net.sealing99.topcomment.block.custom.ThunderKingBlock;
import net.sealing99.topcomment.block.custom.triangularcake.TriangularCakeBlock;
import net.sealing99.topcomment.block.custom.triangularcake.item.TriangularCakeBlockItem;

public class ModBlocks {
    public static final Block TRIANGULAR_CAKE = registerTriangularCakeBlock("triangular_cake",
            new TriangularCakeBlock(AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .nonOpaque()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.WOOL)
                    .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    public static final Block THUNDER_KING = registerBlock("thunder_king",
            new ThunderKingBlock(AbstractBlock.Settings.create()
                    .strength(1.f)
                    .nonOpaque()
                    .sounds(BlockSoundGroup.SCAFFOLDING)
                    .pistonBehavior(PistonBehavior.DESTROY)

            )
    );

    public static final Block CORN_CROP = registerBlockWithoutBlockItem("corn_crop",
            new CornCropBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.DARK_GREEN)
            )
    );

    public static final Block TEN_THOUSAND_TNT = registerBlock("ten_thousand_tnt",
            new net.sealing99.topcomment.block.custom.TenThousantTntBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.BRIGHT_RED)
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .burnable()
                    .solidBlock(Blocks::never)
            )
    );

    public static final Block EMERITE_BLOCK = registerBlock("emerite_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    private static Block registerTriangularCakeBlock(String name, Block block) {
        Registry.register(
                Registries.ITEM, Identifier.of(TopCommentMod.MOD_ID, name),
                new TriangularCakeBlockItem(block, new Item.Settings())
        );
        return Registry.register(Registries.BLOCK, Identifier.of(TopCommentMod.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(TopCommentMod.MOD_ID, name), block);
    }

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
