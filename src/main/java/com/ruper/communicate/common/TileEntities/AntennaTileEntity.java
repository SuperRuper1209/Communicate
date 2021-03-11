package com.ruper.communicate.common.TileEntities;

import com.ruper.communicate.antennamanagement.AntennaManagementMain;
import com.ruper.communicate.init.TileEntitiesInit;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class AntennaTileEntity extends TileEntity implements ITickableTileEntity {
    public boolean loaded = false;

    public AntennaTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public AntennaTileEntity() {
        this(TileEntitiesInit.ANTENNA_TILE_ENTITY_TYPE.get());
    }
    @Override
    public void tick() {
        if (!loaded) {
            loaded = true;
            AntennaManagementMain.addconnection(pos);
        }
    }
}
