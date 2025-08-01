package com.strangeStuff.items;

import com.strangeStuff.items.util.EnergyWaster;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ArrowRailgun extends Item {
    private static final float ARROW_SPEED = 6.0F;
    private static final float GUN_SPREAD = 0.5F;
    private static final int RELOAD_TIME = 4;
    private static final int ENERGY_PER_USE = 2;

    public ArrowRailgun(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public final @NotNull InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack battery = EnergyWaster.findBattery(player);
        ItemStack arrowsStack = findArrows(player);
        if (battery.isEmpty() || arrowsStack.isEmpty()) {
            if (world.isClientSide())
                player.playSound(SoundEvents.DISPENSER_FAIL, 0.7F, 1.0F);
            return InteractionResultHolder.fail(player.getItemInHand(hand));
        }

        ArrowItem arrowItem = (ArrowItem) arrowsStack.getItem();
        EnergyWaster.useBattery(player, battery, ENERGY_PER_USE);
        arrowsStack.shrink(1); //waste arrow
        if (world.isClientSide())
            player.playSound(SoundEvents.FIREWORK_ROCKET_LAUNCH, 1.0F, 0.5F);
        else {
            player.getCooldowns().addCooldown(this, RELOAD_TIME);
            AbstractArrow arrow = arrowItem.createArrow(world, arrowsStack, player);
            arrow.setCritArrow(true);
            arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, ARROW_SPEED, GUN_SPREAD);
            world.addFreshEntity(arrow);
        }

        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

    private static ItemStack findArrows(@NotNull Player player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() instanceof ArrowItem)
                return stack;
        }
        return ItemStack.EMPTY;
    }
}
