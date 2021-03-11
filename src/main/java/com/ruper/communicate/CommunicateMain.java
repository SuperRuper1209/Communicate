package com.ruper.communicate;

import com.ruper.communicate.antennamanagement.AntennaManagementMain;
import com.ruper.communicate.common.TileEntities.AntennaTileEntity;
import com.ruper.communicate.init.BlocksInit;
import com.ruper.communicate.init.ItemsInit;
import com.ruper.communicate.init.TileEntitiesInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.rmi.registry.Registry;

@Mod("communicate")
public class CommunicateMain
{
    private static final Logger LOGGER = LogManager.getLogger();
    public CommunicateMain() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        BlocksInit.BLOCKS.register(bus);
        ItemsInit.ITEMS.register(bus);
        TileEntitiesInit.TILE_ENTITY_TYPES.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void setup(final FMLCommonSetupEvent event)
    {

    }
    @SubscribeEvent
    public void onChat(ServerChatEvent event) {
        ITextComponent msg = new StringTextComponent("<"+event.getUsername()+"> "+event.getMessage());
        boolean playernearantenna = false;
        event.getPlayer().sendMessage(msg, event.getPlayer().getUniqueID());
        for (Object i : AntennaManagementMain.conns.keySet()) {
            BlockPos antenna = ((BlockPos) AntennaManagementMain.conns.get(i));
            if (AntennaManagementMain.getPositionDiference(antenna, event.getPlayer().getPosition()) < 50) {
                playernearantenna = true;
            }
        }
        for (PlayerEntity plr : event.getPlayer().world.getPlayers()) {
            if (plr != event.getPlayer()) {
                int getposdifference = AntennaManagementMain.getPositionDiference(plr.getPosition(), event.getPlayer().getPosition());
                if (playernearantenna) {
                    for (Object key : AntennaManagementMain.conns.keySet()) {
                        if (AntennaManagementMain.getPositionDiference(plr.getPosition(), ((BlockPos) AntennaManagementMain.conns.get(key))) < 50)
                        {
                            if (getposdifference > 50) {
                                plr.sendMessage(msg, event.getPlayer().getUniqueID());
                            }
                        }
                    }
                }
                if (getposdifference < 50 && plr.world == event.getPlayer().world) {
                    plr.sendMessage(msg, event.getPlayer().getUniqueID());
                }
            }
        }
        event.setCanceled(true);
    }
}
