package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions;

import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;

public class FieldFunctionBiomeProviderCondition extends BiomeProviderCondition {
    @Nonnull
    private final Density density;
    private final double minimum;
    private final double maximum;

    private final Density.Context rContext = new Density.Context();

    public FieldFunctionBiomeProviderCondition(@Nonnull Density density, double minimum, double maximum) {
        this.density = density;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public boolean process(@NonNullDecl BiomeProvider.Context context) {
        rContext.position = context.position;
        if (context.anchor != null) rContext.densityAnchor = context.anchor;
        double value = density.process(rContext);
        return value >= minimum && value < maximum;
    }
}
