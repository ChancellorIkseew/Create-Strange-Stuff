package com.strangeStuff;

import com.strangeStuff.enchantments.BedrockBreaker;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, StrangeStuff.MODID);

    public static final RegistryObject<Enchantment> BEDROCK_BREAKER = ENCHANTMENTS.register(
            "bedrock_breaker", () -> new BedrockBreaker(Enchantment.Rarity.VERY_RARE));
}
