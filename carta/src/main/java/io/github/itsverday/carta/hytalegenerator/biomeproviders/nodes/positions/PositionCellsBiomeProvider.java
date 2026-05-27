package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions;

import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import com.hypixel.hytale.builtin.hytalegenerator.math.Normalizer;
import com.hypixel.hytale.builtin.hytalegenerator.pipe.Control;
import com.hypixel.hytale.builtin.hytalegenerator.positionproviders.PositionProvider;
import com.hypixel.hytale.builtin.hytalegenerator.rng.RngField;
import com.hypixel.hytale.math.util.FastRandom;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class PositionCellsBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProvider fallback;
    @Nonnull
    private final PositionProvider positions;
    @Nonnull
    private final List<PositionCellsBiomeProviderCellType> cellTypes;
    @Nonnull
    private final RngField rng;
    @Nullable
    private final Density distanceWarpField;
    private final double distanceWarpMin;
    private final double distanceWarpMax;

    private final double maxDistance;

    private double maxWeight;

    private final Vector3d rBoundsMin = new Vector3d();
    private final Vector3d rBoundsMax = new Vector3d();
    private final Vector3d rSamplePoint = new Vector3d();
    private final Vector3d rLocalPoint = new Vector3d();
    private final Vector3d rClosestPoint = new Vector3d();
    private final double[] rMinDistance = new double[1];
    private final boolean[] rHasClosestPoint = new boolean[1];
    private final PositionProvider.Context rPositionsContext = new PositionProvider.Context();
    private final Density.Context rDensityContext = new Density.Context();
    private final FastRandom rRandom = new FastRandom();

    public PositionCellsBiomeProvider(@Nonnull BiomeProvider fallback, @Nonnull PositionProvider positions, @Nonnull List<PositionCellsBiomeProviderCellType> cellTypes, int seed, double maxDistance, @Nullable Density distanceWarpField, double distanceWarpMin, double distanceWarpMax) {
        this.fallback = fallback;
        this.positions = positions;
        this.cellTypes = cellTypes;
        this.rng = new RngField(seed);
        this.maxDistance = maxDistance;

        this.distanceWarpField = distanceWarpField;
        this.distanceWarpMin = distanceWarpMin;
        this.distanceWarpMax = distanceWarpMax;

        maxWeight = 0;
        for (PositionCellsBiomeProviderCellType cellType: cellTypes) {
            maxWeight += cellType.getWeight();
        }
    }

    @Override
    public int process(@NonNullDecl Context context) {
        double maxDistance = this.maxDistance - distanceWarpMin;
        rBoundsMin.set(context.position.x - maxDistance, context.position.y - maxDistance, context.position.z - maxDistance);
        rBoundsMax.set(context.position.x + maxDistance, context.position.y + maxDistance, context.position.z + maxDistance);

        rSamplePoint.set(context.position);
        rMinDistance[0] = Double.MAX_VALUE;
        rHasClosestPoint[0] = false;

        rPositionsContext.bounds.min.set(rBoundsMin);
        rPositionsContext.bounds.max.set(rBoundsMax);
        rPositionsContext.pipe = this::processPosition;

        positions.generate(rPositionsContext);
        if (!rHasClosestPoint[0]) return fallback.process(context);

        PositionCellsBiomeProviderCellType cellTypeHere = cellTypes.getFirst();
        if (cellTypes.size() > 1) {
            rRandom.setSeed(rng.get(rClosestPoint.x, rClosestPoint.y, rClosestPoint.z));
            double rngValue = rRandom.nextDouble() * maxWeight;
            for (PositionCellsBiomeProviderCellType cellType: cellTypes) {
                rngValue -= cellType.getWeight();
                if (rngValue < 0) {
                    cellTypeHere = cellType;
                    break;
                }
            }
        }

        return cellTypeHere.process(context, rClosestPoint, Math.max(rMinDistance[0], 0));
    }

    private void processPosition(Vector3d providedPoint, Control control) {
        rLocalPoint.set(providedPoint);
        rLocalPoint.sub(rSamplePoint);
        double newDistanceSquared = rLocalPoint.lengthSquared();
        double newDistance = Math.sqrt(newDistanceSquared);

        if (distanceWarpField != null) {
            rDensityContext.position.set(providedPoint);
            rDensityContext.position.add(rSamplePoint);
            rDensityContext.densityAnchor = providedPoint;
            newDistance += Normalizer.normalize(-1, 1, distanceWarpMin, distanceWarpMax, distanceWarpField.process(rDensityContext));
        }

        if (newDistance < maxDistance && newDistance < rMinDistance[0]) {
            rMinDistance[0] = newDistance;
            rClosestPoint.set(providedPoint);
            rHasClosestPoint[0] = true;
        }
    }

    @Override
    public List<Integer> allPossibleValues() {
        ArrayList<Integer> values = new ArrayList<>();

        for (PositionCellsBiomeProviderCellType cellType: cellTypes) {
            for (Integer value: cellType.allPossibleValues()) {
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
}
