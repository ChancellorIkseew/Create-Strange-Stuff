package com.strangeStuff.items;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class PowerSword extends SwordItem {
    private static final int DAMAGE = 5;
    private static final float RELOAD_TIME = 1.0F;

    public PowerSword(Properties properties) {
        super(Tiers.NETHERITE, DAMAGE, RELOAD_TIME, properties.stacksTo(1)
                .defaultDurability(4096)
                .fireResistant());
    }

    @Override
    public final float getDamage() {
        return 100F;
    }
/*
    @Override
    public final boolean hurtEnemy(ItemStack item, LivingEntity attacker, LivingEntity target) {
        //if (!super.hurtEnemy(item, attacker, target))
            //return false;
        target.hurt(DamageSource.WITHER,100.0F);
        return true;
    }
*/
}
