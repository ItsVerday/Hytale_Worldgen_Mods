package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;

public class NotBiomeProviderCondition extends BiomeProviderCondition {
    @Nonnull
    private final BiomeProviderCondition input;

    public NotBiomeProviderCondition(@Nonnull BiomeProviderCondition input) {
        this.input = input;
    }

    @Override
    public boolean process(@NonNullDecl BiomeProvider.Context context) {
        return !input.process(context);
    }
}
