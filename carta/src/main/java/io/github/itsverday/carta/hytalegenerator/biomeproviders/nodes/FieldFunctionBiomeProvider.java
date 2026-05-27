package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class FieldFunctionBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProvider fallback;
    @Nonnull
    private final Density density;
    @Nonnull
    private final List<FieldDelimiter> delimiters;

    private final Density.Context rContext = new Density.Context();

    public FieldFunctionBiomeProvider(@Nonnull BiomeProvider fallback, @Nonnull Density density, @Nonnull List<FieldDelimiter> delimiters) {
        this.fallback = fallback;
        this.density = density;
        this.delimiters = delimiters;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        rContext.position = context.position;
        if (context.anchor != null) rContext.densityAnchor = context.anchor;
        double fieldValue = density.process(rContext);

        for (FieldDelimiter delimiter: delimiters) {
            if (delimiter.isInside(fieldValue)) {
                return delimiter.value.process(context);
            }
        }

        return fallback.process(context);
    }

    @Override
    public List<Integer> allPossibleValues() {
        ArrayList<Integer> values = new ArrayList<>();

        for (FieldDelimiter delimiter: delimiters) {
            for (Integer value: delimiter.value.allPossibleValues()) {
                if (!values.contains(value)) {
                    values.add(value);
                }
            }
        }

        for (Integer value: fallback.allPossibleValues()) {
            if (!values.contains(value)) {
                values.add(value);
            }
        }

        return values;
    }

    public static class FieldDelimiter {
        @Nonnull
        public BiomeProvider value;
        public double minimum;
        public double maximum;

        public FieldDelimiter(@Nonnull BiomeProvider value, double minimum, double maximum) {
            this.value = value;
            this.minimum = minimum;
            this.maximum = maximum;
        }

        public boolean isInside(double fieldValue) {
            return fieldValue < maximum && fieldValue >= minimum;
        }
    }
}
