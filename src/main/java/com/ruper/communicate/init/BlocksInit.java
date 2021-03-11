package com.ruper.communicate.init;

import com.ruper.communicate.common.Blocks.DeviceAntennaBlock;
import com.ruper.communicate.common.Blocks.DeviceMainBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlocksInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "communicate");

    public static final RegistryObject<DeviceMainBlock> DEVICEMAINBLOCK = BLOCKS.register("device_main_block", () -> new DeviceMainBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(5, 6).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.METAL)));
    public static final RegistryObject<DeviceAntennaBlock> DEVICEANTENNABLOCK = BLOCKS.register("device_antenna_block", () -> new DeviceAntennaBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(5, 6).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.METAL)));
}
