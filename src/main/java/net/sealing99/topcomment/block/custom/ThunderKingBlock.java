package net.sealing99.topcomment.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.sealing99.topcomment.util.DelayedEventManager;
import org.jetbrains.annotations.Nullable;

public class ThunderKingBlock extends HorizontalFacingBlock {
    public static final MapCodec<ThunderKingBlock> CODEC = createCodec(ThunderKingBlock::new);
    private static final VoxelShape HITBOX_SHAPE = Block.createCuboidShape(7.0, 0.0, 7.0, 9.0, 12.0, 9.0);

    public ThunderKingBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState stateBelow = world.getBlockState(blockPos);

        if (stateBelow.isAir() || stateBelow.isReplaceable()) {
            return false;
        }

        return world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, Direction.UP);
    }

    private void primeFirework(World world, BlockPos pos, PlayerEntity player) {
        world.playSound(null, pos, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
        RegistryKey<World> worldKey = world.getRegistryKey();

        DelayedEventManager.schedule(0, (server) -> {
            ServerWorld serverWorld = server.getWorld(worldKey);

            if (serverWorld != null) {
                for (int i = 0; i < 30; i++) {
                    final double heightOffset = i * 0.4;

                    serverWorld.spawnParticles(
                            ParticleTypes.FLAME,
                            pos.getX() + 0.5, pos.getY() + 1.0 + heightOffset, pos.getZ() + 0.5,
                            2, 0.05, 0.05, 0.05, 0.01
                    );
                }
            }
        });
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!stack.isOf(Items.FLINT_AND_STEEL) && !stack.isOf(Items.FIRE_CHARGE)) {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        } else {
            if (!world.isClient()) {
                primeFirework(world, pos, player);
            }
            Item item = stack.getItem();
            if (stack.isOf(Items.FLINT_AND_STEEL)) {
                stack.damage(1, player, LivingEntity.getSlotForHand(hand));
            } else {
                stack.decrementUnlessCreative(1, player);
            }

            player.incrementStat(Stats.USED.getOrCreateStat(item));
            return ItemActionResult.success(world.isClient);
        }
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        for (int i = 0; i < 30; i++) {
            final double heightOffset = i * 0.4;

            world.getServer().execute(() -> {
                world.spawnParticles(
                        ParticleTypes.FLAME,
                        pos.getX() + 0.5, pos.getY() + 1.0 + heightOffset, pos.getZ() + 0.5,
                        2, 0.05, 0.05, 0.05, 0.01
                );
            });
        }

        world.scheduleBlockTick(pos, this, 30);

        BlockPos apexPos = pos.up(12);

        world.playSound(null, apexPos, SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, SoundCategory.BLOCKS, 3.0F, 1.0F);
        world.playSound(null, apexPos, SoundEvents.ENTITY_FIREWORK_ROCKET_TWINKLE, SoundCategory.BLOCKS, 2.0F, 1.2F);

        world.spawnParticles(
                ParticleTypes.FLAME,
                apexPos.getX() + 0.5, apexPos.getY(), apexPos.getZ() + 0.5,
                150,
                2.0, 2.0, 2.0,
                0.2
        );

        world.spawnParticles(
                ParticleTypes.FLASH,
                apexPos.getX() + 0.5, apexPos.getY(), apexPos.getZ() + 0.5,
                3, 0.1, 0.1, 0.1, 0.0
        );
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return HITBOX_SHAPE;
    }
}
