package io.github.itsverday.carta.hytalegenerator.biomeproviderconditions;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class ConstantBiomeProviderCondition extends BiomeProviderCondition {
    private final boolean value;

    public ConstantBiomeProviderCondition(boolean value) {
        this.value = value;
    }

    @Override
    public boolean process(@NonNullDecl BiomeProvider.Context context) {
        return value;
    }
}
