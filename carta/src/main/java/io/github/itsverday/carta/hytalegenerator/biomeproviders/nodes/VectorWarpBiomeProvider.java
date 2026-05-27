package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.List;

public class VectorWarpBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProvider input;
    @Nonnull
    private final Density warpField;
    @Nonnull
    private final Vector3d warpVector;
    private final boolean rounding;

    private final Vector3d rPosition = new Vector3d();
    private final Density.Context rDensityContext = new Density.Context();
    private final BiomeProvider.Context rContext = new Context();

    public VectorWarpBiomeProvider(@Nonnull BiomeProvider input, @Nonnull Density warpField, @Nonnull Vector3d warpVector, boolean rounding) {
        this.input = input;
        this.warpField = warpField;
        this.warpVector = warpVector;
        this.rounding = rounding;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        rPosition.set(context.position);
        rDensityContext.position = rPosition;
        double warp = warpField.process(rDensityContext);

        rPosition.set(warpVector);
        rPosition.mul(warp);
        rPosition.add(context.position);
        if (rounding) rPosition.floor();

        rContext.assign(context);
        rContext.position = rPosition;
        return input.process(rContext);
    }

    @Override
    public List<Integer> allPossibleValues() {
        return input.allPossibleValues();
    }
}
