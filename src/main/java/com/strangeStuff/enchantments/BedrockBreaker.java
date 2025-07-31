package com.strangeStuff.enchantments;

import com.strangeStuff.items.ElectricDrill;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class BedrockBreaker extends Enchantment {
    private static final EnchantmentCategory DRILL_CATEGORY = EnchantmentCategory.create("drill",
            item -> item instanceof ElectricDrill);

    public BedrockBreaker(Rarity rarity) {
        super(rarity, DRILL_CATEGORY, new EquipmentSlot[0]);
    }
}