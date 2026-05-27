package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.List;

public class GradientWarp2DBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProvider input;
    @Nonnull
    private final Density warpField;
    private final double sampleDistance;
    private final double warpFactor;
    private final boolean rounding;

    private final Vector3d rPosition = new Vector3d();
    private final Density.Context rDensityContext = new Density.Context();
    private final BiomeProvider.Context rContext = new Context();

    public GradientWarp2DBiomeProvider(@Nonnull BiomeProvider input, @Nonnull Density warpField, double sampleDistance, double warpFactor, boolean rounding) {
        this.input = input;
        this.warpField = warpField;
        this.sampleDistance = sampleDistance;
        this.warpFactor = warpFactor;
        this.rounding = rounding;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        rPosition.set(context.position);
        rDensityContext.position = rPosition;

        double originValue = warpField.process(rDensityContext);

        rPosition.set(context.position.x + sampleDistance, context.position.y, context.position.z);
        double deltaX = warpField.process(rDensityContext) - originValue;

        rPosition.set(context.position.x, context.position.y, context.position.z + sampleDistance);
        double deltaZ = warpField.process(rDensityContext) - originValue;

        double offsetX = deltaX / sampleDistance * warpFactor;
        double offsetZ = deltaZ / sampleDistance * warpFactor;
        rPosition.set(context.position);
        rPosition.add(offsetX, 0, offsetZ);
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
