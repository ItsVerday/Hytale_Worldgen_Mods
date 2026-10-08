package io.github.itsverday.carta.hytalegenerator.biomeproviderconditions;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;

public class ValuesBiomeProviderCondition extends BiomeProviderCondition {
    @Nonnull
    private final BiomeProvider input;
    private final int[] values;

    public ValuesBiomeProviderCondition(@Nonnull BiomeProvider input, int[] values) {
        this.input = input;
        this.values = values;
    }

    @Override
    public boolean process(@NonNullDecl BiomeProvider.Context context) {
        int value = input.process(context);
        for (int otherValue: values) {
            if (value == otherValue) return true;
        }

        return false;
    }
}
