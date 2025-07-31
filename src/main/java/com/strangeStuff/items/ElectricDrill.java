package com.strangeStuff.items;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import static com.strangeStuff.items.util.ActionsJoiner.DRILL_ACTIONS;

public class ElectricDrill extends DiggerItem {
    private static final float DAMAGE = 14.0F - 5.0F;
    private static final float ATTACK_SPEED = 0.6F - 4.0F;

    public ElectricDrill(Properties properties) {
        super(DAMAGE, ATTACK_SPEED, Tiers.NETHERITE, BlockTags.MINEABLE_WITH_PICKAXE,
                properties.stacksTo(1)
                        .defaultDurability(0)
                        .fireResistant());
    }

    @Override
    public final boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!(miner instanceof Player))
            return false;
        Player player = (Player) miner;
        ItemStack battery = findBattery(player);
        useBattery(player, battery);
        return true;
    }

    @Override
    public boolean canAttackBlock(BlockState p_41441_, Level p_41442_, BlockPos p_41443_, Player player) {
        return !findBattery(player).isEmpty();
    }

    private static ItemStack findBattery(@NotNull Player player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() instanceof Battery)
                return stack;
        }
        return ItemStack.EMPTY;
    }

    private static void useBattery(Player player, ItemStack battery) {
        battery.setDamageValue(battery.getDamageValue() + 1);
        if (battery.getDamageValue() < battery.getMaxDamage())
            return;
        battery.shrink(1);
        player.playSound(SoundEvents.ITEM_BREAK, 1.0F, 0.5F);
    }

    @Override
    public final boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return DRILL_ACTIONS.contains(toolAction);
    }

    @Override
    public final boolean isCorrectToolForDrops(ItemStack stack, BlockState state) { return true; }
    @Override
    public final float getDestroySpeed(ItemStack stack, BlockState state) { return 116.0F; }
    @Override
    public final boolean isDamageable(ItemStack stack) { return false; }
    @Override
    public final boolean isEnchantable(ItemStack p_41456_) { return true; }
}
