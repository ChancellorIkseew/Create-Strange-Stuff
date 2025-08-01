package com.strangeStuff.items;

import com.strangeStuff.items.util.EnergyWaster;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class PowerSword extends SwordItem {
    private static final int DAMAGE = 10 - 5;
    private static final float POWER_DAMAGE = 50.0F;
    private static final float ATTACK_SPEED = 1.6F - 4.0F;
    private static final int ENERGY_PER_USE = 4;

    public PowerSword(Properties properties) {
        super(Tiers.NETHERITE, DAMAGE, ATTACK_SPEED, properties.stacksTo(1)
                .defaultDurability(4096)
                .fireResistant());
    }

    @Override
    public final boolean hurtEnemy(ItemStack sword, LivingEntity target, LivingEntity attacker) {
        super.hurtEnemy(sword, target, attacker);
        if (!(attacker instanceof Player player))
            return true;
        ItemStack battery = EnergyWaster.findBattery(player);
        if (battery.isEmpty())
            return true;
        EnergyWaster.useBattery(player, battery, ENERGY_PER_USE);
        target.hurt(DamageSource.WITHER, POWER_DAMAGE);
        return true;
    }
}
