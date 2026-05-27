package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.List;

public class ScalerBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProvider input;
    private final double scalingFactor;
    private final boolean rounding;

    private final Vector3d rPosition = new Vector3d();
    private final Context rContext = new Context();

    public ScalerBiomeProvider(@Nonnull BiomeProvider input, double scalingFactor, boolean rounding) {
        this.input = input;
        this.scalingFactor = scalingFactor;
        this.rounding = rounding;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        rPosition.set(context.position);
        rPosition.mul(scalingFactor);
        if (rounding) rPosition.floor();

        rContext.assign(context);
        rContext.position = rPosition;
        return input.process(rContext);
    }

    @Override
    public List<Integer> allPossibleValues() {
        return input.allPossibleValues();
    }

    @Override
    public boolean shouldCache() {
        return false;
    }
}
