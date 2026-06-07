package net.sealing99.topcomment.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.sealing99.topcomment.TopCommentMod;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> MOVEMENT = registerStatusEffect(
        "movement",
        new StatusEffect(StatusEffectCategory.BENEFICIAL, 0x98D982) {}
                .addAttributeModifier(
                        EntityAttributes.GENERIC_MOVEMENT_SPEED,
                        Identifier.of(TopCommentMod.MOD_ID, "movement"),
                        0.08f,
                        EntityAttributeModifier.Operation.ADD_VALUE
                )
                .addAttributeModifier(
                        EntityAttributes.GENERIC_JUMP_STRENGTH,
                        Identifier.of(TopCommentMod.MOD_ID, "movement"),
                        0.18f,
                        EntityAttributeModifier.Operation.ADD_VALUE
                ));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(TopCommentMod.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        TopCommentMod.LOGGER.info("Registering Mod Effects for " + TopCommentMod.MOD_ID);
    }
}
