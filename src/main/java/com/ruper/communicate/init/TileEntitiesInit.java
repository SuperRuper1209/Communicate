package com.ruper.communicate.init;

import com.ruper.communicate.common.Blocks.DeviceAntennaBlock;
import com.ruper.communicate.common.TileEntities.AntennaTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntitiesInit {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, "communicate");

    public static final RegistryObject<TileEntityType<AntennaTileEntity>> ANTENNA_TILE_ENTITY_TYPE = TILE_ENTITY_TYPES
            .register("device_antenna_block", () -> TileEntityType.Builder.create(AntennaTileEntity::new, BlocksInit.DEVICEANTENNABLOCK.get()).build(null));
}
