package com.ruper.communicate.common.Blocks;

import com.ruper.communicate.antennamanagement.AntennaManagementMain;
import com.ruper.communicate.common.TileEntities.AntennaTileEntity;
import com.ruper.communicate.init.TileEntitiesInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;


public class DeviceAntennaBlock extends AntennaManagementMain {

    public DeviceAntennaBlock(AbstractBlock.Properties properties) {
        super(properties);
        runCalculation(Block.makeCuboidShape(4, 0, 4, 12, 14, 12));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntitiesInit.ANTENNA_TILE_ENTITY_TYPE.get().create();
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES.get(state.get(HORIZONTAL_FACING));
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (!worldIn.getBlockState(pos.down()).getBlock().getRegistryName().toString().equals("communicate:device_main_block")) {
            worldIn.destroyBlock(pos, true);
        }
        addconnection(pos);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        deleteconnection(pos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        System.out.println(pos.toString());
        System.out.println(fromPos.toString());
        if (pos.down().equals(fromPos))
        {
            worldIn.destroyBlock(pos, true);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        try {
            return this.getDefaultState().with(HORIZONTAL_FACING, context.getWorld().getBlockState(context.getPos().down()).get(HORIZONTAL_FACING).getOpposite());
        }
        catch (Exception e) {
            return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing());
        }
    }
}
