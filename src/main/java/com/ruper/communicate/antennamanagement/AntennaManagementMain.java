package com.ruper.communicate.antennamanagement;

import com.ruper.communicate.common.Blocks.BaseHorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;
import java.util.Map;

public class AntennaManagementMain extends BaseHorizontalBlock {
    public static Map conns = new HashMap<>();

    public AntennaManagementMain(Properties properties) {
        super(properties);
    }

    public static void addconnection(BlockPos state) {
        conns.put(state, state);
        System.out.println(conns);
    }

    public static void deleteconnection(BlockPos state) {
        conns.remove(state);
    }

    public static int getPositionDiference(BlockPos pos1, BlockPos pos2) {
        BlockPos pos3 = pos1.add(-pos2.getX(), -pos2.getY(), -pos2.getZ());
        BlockPos pos4 = new BlockPos(Math.abs(pos3.getX()), Math.abs(pos3.getY()), Math.abs(pos3.getZ()));
        double magnitude = Math.sqrt((pos4.getX()*pos4.getX())+(pos4.getY()*pos4.getY())+(pos4.getZ()*pos4.getZ()));
        int magnitudeint = (int) magnitude;
        return magnitudeint;
    }
}
