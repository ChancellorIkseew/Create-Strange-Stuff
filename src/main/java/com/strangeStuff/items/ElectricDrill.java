package com.strangeStuff.items;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
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
    public final boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity player) {
        return true;
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
