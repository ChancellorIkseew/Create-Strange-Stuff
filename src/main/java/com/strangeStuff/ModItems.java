package com.strangeStuff;

import com.strangeStuff.items.ArrowRailgun;
import com.strangeStuff.items.Battery;
import com.strangeStuff.items.PowerSword;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StrangeStuff.MODID);

    public static final RegistryObject<Item> BATTERY_ITEM = ITEMS.register("battery", () -> new Battery(
            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> item = ITEMS.register("arrow_railgun", () -> new ArrowRailgun(
            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> POWER_SWORD_ITEM = ITEMS.register("power_sword", () -> new PowerSword(
            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
}
