package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions;

import com.hypixel.hytale.builtin.hytalegenerator.ReusableList;
import com.hypixel.hytale.builtin.hytalegenerator.VectorUtil;
import com.hypixel.hytale.builtin.hytalegenerator.pipe.Control;
import com.hypixel.hytale.builtin.hytalegenerator.positionproviders.PositionProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import it.unimi.dsi.fastutil.doubles.Double2DoubleFunction;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.List;

public class PositionsTwist2DBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProvider input;
    @Nonnull
    private final PositionProvider positions;
    @Nonnull
    private final Double2DoubleFunction twistCurve;
    private final double maxDistance;
    private final boolean distanceNormalized;
    private final boolean rounding;
    private final Vector3d twistAxis = new Vector3d(0, 1, 0);

    private final PositionProvider.Context rPositionsContext = new PositionProvider.Context();
    private final Context rContext = new Context();
    private final Vector3d rBoundsMin = new Vector3d();
    private final Vector3d rBoundsMax = new Vector3d();
    private final Vector3d rQueryPosition = new Vector3d();
    private final Vector3d rSamplePoint = new Vector3d();
    private final Vector3d rWarpVector = new Vector3d();
    private final ReusableList<Vector3d> rWarpVectors = new ReusableList<>();
    private final ReusableList<Double> rWarpDistances = new ReusableList<>();
    private final ReusableList<Double> rWeights = new ReusableList<>();

    public PositionsTwist2DBiomeProvider(@Nonnull BiomeProvider input, @Nonnull PositionProvider positions, @Nonnull Double2DoubleFunction twistCurve, double maxDistance, boolean distanceNormalized, boolean rounding) {
        this.input = input;
        this.positions = positions;
        this.twistCurve = twistCurve;
        this.maxDistance = maxDistance;
        this.distanceNormalized = distanceNormalized;
        this.rounding = rounding;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        rBoundsMin.set(context.position.x - maxDistance, -1, context.position.z - maxDistance);
        rBoundsMax.set(context.position.x + maxDistance, 1, context.position.z + maxDistance);
        rSamplePoint.set(context.position);
        rQueryPosition.set(context.position.x, 0, context.position.z);

        rWarpVectors.clear();
        rWarpDistances.clear();
        rPositionsContext.bounds.min.set(rBoundsMin);
        rPositionsContext.bounds.max.set(rBoundsMax);
        rPositionsContext.pipe = this::processPosition;
        positions.generate(rPositionsContext);
        if (rWarpVectors.getSoftSize() == 0) return input.process(context);
        if (rWarpVectors.getSoftSize() == 1) {
            rSamplePoint.add(rWarpVectors.get(0));
            if (rounding) rSamplePoint.floor();

            rContext.assign(context);
            rContext.position = rSamplePoint;
            return input.process(rContext);
        }

        int possiblePointsSize = rWarpVectors.getSoftSize();
        rWeights.clear();
        double totalWeight = 0.0;

        for (int i = 0; i < possiblePointsSize; i++) {
            double distance = rWarpDistances.get(i);
            double weight = 1.0 - distance;
            rWeights.expandAndSet(weight);
            totalWeight += weight;
        }

        for (int i = 0; i < possiblePointsSize; i++) {
            double weight = rWeights.get(i) / totalWeight;
            Vector3d warpVector = rWarpVectors.get(i);
            warpVector.mul(weight);
            rSamplePoint.add(warpVector);
        }

        if (rounding) rSamplePoint.floor();

        rContext.assign(context);
        rContext.position = rSamplePoint;
        return input.process(rContext);
    }

    private void processPosition(Vector3d providedPoint, Control control) {
        double distance = providedPoint.distance(rQueryPosition);
        if (distance > maxDistance) return;
        double distance1 = distance / maxDistance;
        double normalizedDistance = distanceNormalized ? distance1 : distance;
        double twistAngle = twistCurve.applyAsDouble(normalizedDistance) / 180.0 * Math.PI;
        rWarpVector.set(rSamplePoint);
        rWarpVector.sub(providedPoint);
        VectorUtil.rotateAroundAxis(rWarpVector, twistAxis, twistAngle);
        rWarpVector.add(providedPoint);
        rWarpVector.sub(rSamplePoint);

        if (rWarpVectors.isAtHardCapacity()) {
            rWarpVectors.expandAndSet(new Vector3d(rWarpVector));
        } else {
            rWarpVectors.expandAndGet().set(rWarpVector);
        }

        rWarpDistances.expandAndSet(distance1);
    }

    @Override
    public List<Integer> allPossibleValues() {
        return input.allPossibleValues();
    }
}
