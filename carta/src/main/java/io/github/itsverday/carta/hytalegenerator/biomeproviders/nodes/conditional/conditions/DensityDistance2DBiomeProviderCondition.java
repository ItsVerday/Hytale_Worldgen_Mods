package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions;

import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import com.hypixel.hytale.builtin.hytalegenerator.math.Normalizer;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;

public class DensityDistance2DBiomeProviderCondition extends AbstractDistance2DBiomeProviderCondition {
    @Nonnull
    private final Density density;
    private final double minDistance;
    private final double maxDistance;

    private final Density.Context rContext = new Density.Context();

    public DensityDistance2DBiomeProviderCondition(@Nonnull BiomeProviderCondition input, @Nonnull Density density, double minDistance, double maxDistance) {
        super(input, maxDistance);
        this.density = density;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
    }

    @Override
    public double getTargetDistance(@NonNullDecl BiomeProvider.Context context) {
        rContext.position = context.position;
        return Normalizer.normalize(-1, 1, minDistance, maxDistance, density.process(rContext));
    }
}
