package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class PositionCellsBiomeProviderCellType {
    private final double weight;

    public abstract int process(@Nonnull BiomeProvider.Context context, @Nonnull Vector3d closestPoint, double distance);
    public abstract List<Integer> allPossibleValues();

    public PositionCellsBiomeProviderCellType(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
