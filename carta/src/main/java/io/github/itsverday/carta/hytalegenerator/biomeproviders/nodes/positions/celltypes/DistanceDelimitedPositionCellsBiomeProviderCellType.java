package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.celltypes;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.PositionCellsBiomeProviderCellType;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class DistanceDelimitedPositionCellsBiomeProviderCellType extends PositionCellsBiomeProviderCellType {
    @Nonnull
    private final PositionCellsBiomeProviderCellType fallback;
    @Nonnull
    private final List<DistanceDelimiter> delimiters;

    public DistanceDelimitedPositionCellsBiomeProviderCellType(@Nonnull PositionCellsBiomeProviderCellType fallback, @Nonnull List<DistanceDelimiter> delimiters, double weight) {
        super(weight);
        this.fallback = fallback;
        this.delimiters = delimiters;
    }

    @Override
    public int process(@NonNullDecl BiomeProvider.Context context, @NonNullDecl Vector3d closestPoint, double distance) {
        for (DistanceDelimiter delimiter: delimiters) {
            if (delimiter.isInside(distance)) {
                return delimiter.value.process(context, closestPoint, distance);
            }
        }

        return fallback.process(context, closestPoint, distance);
    }

    @Override
    public List<Integer> allPossibleValues() {
        ArrayList<Integer> values = new ArrayList<>();

        for (DistanceDelimiter delimiter: delimiters) {
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

    public static class DistanceDelimiter {
        @Nonnull
        public PositionCellsBiomeProviderCellType value;
        public double minimum;
        public double maximum;

        public DistanceDelimiter(@Nonnull PositionCellsBiomeProviderCellType value, double minimum, double maximum) {
            this.value = value;
            this.minimum = minimum;
            this.maximum = maximum;
        }

        public boolean isInside(double fieldValue) {
            return fieldValue < maximum && fieldValue >= minimum;
        }
    }
}
