package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;

import javax.annotation.Nonnull;

public abstract class BiomeProviderCondition {
    public abstract boolean process(@Nonnull BiomeProvider.Context context);
}
