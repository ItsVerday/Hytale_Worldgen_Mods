package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;

public class Distance2DBiomeProviderCondition extends AbstractDistance2DBiomeProviderCondition {
    private final double maxDistance;

    public Distance2DBiomeProviderCondition(@Nonnull BiomeProviderCondition input, double maxDistance) {
        super(input, maxDistance);
        this.maxDistance = maxDistance;
    }

    @Override
    public double getTargetDistance(@NonNullDecl BiomeProvider.Context context) {
        return maxDistance;
    }
}
