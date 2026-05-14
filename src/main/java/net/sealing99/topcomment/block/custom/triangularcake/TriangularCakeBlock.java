package net.sealing99.topcomment.block.custom.triangularcake;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.sealing99.topcomment.block.custom.triangularcake.entity.TriangularCakeBlockEntity;
import org.jetbrains.annotations.Nullable;

public class TriangularCakeBlock extends BlockWithEntity {
    public static final DirectionProperty FACING;
    public static final MapCodec<TriangularCakeBlock> CODEC = createCodec(TriangularCakeBlock::new);
    private static final VoxelShape SHAPE = Block.createCuboidShape(2, 0, 2, 14, 6, 14);

    public TriangularCakeBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(FACING, net.minecraft.util.math.Direction.NORTH));
    }

    @Override
    protected MapCodec<TriangularCakeBlock> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TriangularCakeBlockEntity(pos, state);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }
}
