package com.ruper.communicate.common.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;


public class DeviceMainBlock extends BaseHorizontalBlock {
    public DeviceMainBlock(Properties properties) {
        super(properties);
        runCalculation(Block.makeCuboidShape(0, 0, 1, 16, 16, 16));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES.get(state.get(HORIZONTAL_FACING));
    }
}
