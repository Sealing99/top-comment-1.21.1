package net.sealing99.topcomment.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;
import net.sealing99.topcomment.effect.ModEffects;

public class ModPotions {
    public static final RegistryEntry<Potion> MOVEMENT_POTION = registerPotion("movement_potion", new Potion(new StatusEffectInstance(ModEffects.MOVEMENT, 3600, 0)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(TopCommentMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        TopCommentMod.LOGGER.info("Registering Mod Potions for " + TopCommentMod.MOD_ID);
    }
}
