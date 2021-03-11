package com.ruper.communicate.init;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "communicate");

    public static final RegistryObject<Item> DEVICEMAINBLOCK = ITEMS.register("device_main_block", () -> new BlockItem(BlocksInit.DEVICEMAINBLOCK.get(), new Item.Properties().group(ItemGroup.REDSTONE)));
    public static final RegistryObject<Item> DEVICEANTENNABLOCK = ITEMS.register("device_antenna_block", () -> new BlockItem(BlocksInit.DEVICEANTENNABLOCK.get(), new Item.Properties().group(ItemGroup.REDSTONE)));
}
