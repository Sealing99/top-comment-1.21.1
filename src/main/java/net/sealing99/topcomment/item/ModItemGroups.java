package net.sealing99.topcomment.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup TOP_COMMENT_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(TopCommentMod.MOD_ID, "top_comment_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.topcomment.top_comment_group"))
                    .icon(() -> new net.minecraft.item.ItemStack(ModItems.BAGUETTE))
                    .entries((DisplayContext, entries) -> {
                            entries.add(ModItems.BAGUETTE);
                            entries.add(ModBlocks.TRIANGULAR_CAKE);
                    })

                    .build()
    );

    public static void registerItemGroups() {
        TopCommentMod.LOGGER.info("Registering Mod Item Groups for " + TopCommentMod.MOD_ID);
    }
}
