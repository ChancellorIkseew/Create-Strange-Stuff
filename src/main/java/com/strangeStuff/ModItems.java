package com.strangeStuff;

import com.strangeStuff.items.ArrowRailgun;
import com.strangeStuff.items.Battery;
import com.strangeStuff.items.ElectricDrill;
import com.strangeStuff.items.PowerSword;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StrangeStuff.MODID);

    public static final RegistryObject<Item> BATTERY = ITEMS.register("battery", () -> new Battery(
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS), 256));
    public static final RegistryObject<Item> DOUBLE_BATTERY = ITEMS.register("double_battery", () -> new Battery(
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS), 512));
    public static final RegistryObject<Item> ARROW_RAILGUN = ITEMS.register("arrow_railgun", () -> new ArrowRailgun(
            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> POWER_SWORD = ITEMS.register("power_sword", () -> new PowerSword(
            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> ELECTRIC_DRILL = ITEMS.register("electric_drill", () -> new ElectricDrill(
            new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    //non-interactive
    public static final RegistryObject<Item> ELECTRIC_DRILL_HEAD = ITEMS.register("electric_drill_head", () -> new Item(
            new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).fireResistant()));
}
