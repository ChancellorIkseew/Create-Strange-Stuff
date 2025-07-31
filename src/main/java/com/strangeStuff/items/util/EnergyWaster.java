package com.strangeStuff.items.util;

import com.strangeStuff.items.Battery;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class EnergyWaster {
    public static ItemStack findBattery(@NotNull Player player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() instanceof Battery)
                return stack;
        }
        return ItemStack.EMPTY;
    }

    public static void useBattery(@NotNull Player player, @NotNull ItemStack battery, int amount) {
        battery.setDamageValue(battery.getDamageValue() + amount);
        if (battery.getDamageValue() < battery.getMaxDamage())
            return;
        battery.shrink(1);
        player.playSound(SoundEvents.ITEM_BREAK, 1.0F, 0.5F);
    }
}
