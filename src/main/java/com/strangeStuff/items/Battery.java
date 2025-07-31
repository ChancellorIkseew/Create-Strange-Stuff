package com.strangeStuff.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Battery extends Item {
    public Battery(Properties properties, int durability) {
        super(properties.defaultDurability(durability));
    }

    @Override
    public final boolean isEnchantable(ItemStack stack) { return false; }
    @Override
    public final int getBarColor(ItemStack stack) { return 0x0064FF; }
}
