package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.celltypes;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.PositionCellsBiomeProviderCellType;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.List;

public class FillPositionCellsBiomeProviderCellType extends PositionCellsBiomeProviderCellType {
    @Nonnull
    private final BiomeProvider input;

    private final BiomeProvider.Context rContext = new BiomeProvider.Context();

    public FillPositionCellsBiomeProviderCellType(@Nonnull BiomeProvider input, double weight) {
        super(weight);
        this.input = input;
    }

    @Override
    public int process(@NonNullDecl BiomeProvider.Context context, @NonNullDecl Vector3d closestPoint, double distance) {
        rContext.assign(context);
        rContext.anchor = closestPoint;
        return input.process(rContext);
    }

    @Override
    public List<Integer> allPossibleValues() {
        return input.allPossibleValues();
    }
}
