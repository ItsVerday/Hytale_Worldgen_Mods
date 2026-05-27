package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;

public class ValueBiomeProviderCondition extends BiomeProviderCondition {
    @Nonnull
    private final BiomeProvider input;
    private final int value;

    public ValueBiomeProviderCondition(@Nonnull BiomeProvider input, int value) {
        this.input = input;
        this.value = value;
    }

    @Override
    public boolean process(@NonNullDecl BiomeProvider.Context context) {
        return input.process(context) == value;
    }
}
