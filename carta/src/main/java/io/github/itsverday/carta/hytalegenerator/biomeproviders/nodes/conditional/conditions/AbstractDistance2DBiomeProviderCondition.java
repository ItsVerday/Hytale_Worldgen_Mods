package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.util.cache.SpatialBooleanCache2D;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;
import org.joml.Vector3i;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractDistance2DBiomeProviderCondition extends AbstractOffsetBiomeProviderCondition {
    private final byte[] sortedPositions;
    private final int positionsCount;

    private final SpatialBooleanCache2D distanceCache = new SpatialBooleanCache2D(6);

    private final Vector3d rOffset = new Vector3d();
    private final boolean[] rDistanceCacheValue = new boolean[1];

    public AbstractDistance2DBiomeProviderCondition(@Nonnull BiomeProviderCondition input, double maxDistance) {
        super(input);

        int maxDistanceInt = (int) Math.ceil(maxDistance);
        List<Vector3i> sortedPositionVectors = new ArrayList<>();
        for (Vector3i position = new Vector3i(-maxDistanceInt, 0, -maxDistanceInt); position.x <= maxDistanceInt; position.x++) {
            for (position.z = -maxDistanceInt; position.z <= maxDistanceInt; position.z++) {
                if (position.length() > maxDistance) continue;
                sortedPositionVectors.add(new Vector3i(position));
            }
        }

        sortedPositionVectors.sort(Comparator.comparingDouble(Vector3i::length));
        positionsCount = sortedPositionVectors.size();
        sortedPositions = new byte[positionsCount * 3];

        for (int i = 0; i < positionsCount; i++) {
            Vector3i position = sortedPositionVectors.get(i);
            sortedPositions[indexX(i)] = (byte) position.x;
            sortedPositions[indexY(i)] = (byte) position.y;
            sortedPositions[indexZ(i)] = (byte) position.z;
        }
    }

    public abstract double getTargetDistance(@Nonnull BiomeProvider.Context context);

    private boolean withinDistance(@Nonnull BiomeProvider.Context context, double targetDistance) {
        double x = context.position.x;
        double z = context.position.z;
        boolean hasDistance = distanceCache.getAndConsume(x, z, value -> rDistanceCacheValue[0] = value);
        if (hasDistance) return rDistanceCacheValue[0];

        for (int i = 0; i < positionsCount; i++) {
            int checkX = sortedPositions[indexX(i)];
            int checkY = sortedPositions[indexY(i)];
            int checkZ = sortedPositions[indexZ(i)];
            if (checkX * checkX + checkY * checkY + checkZ * checkZ > targetDistance * targetDistance) break;
            rOffset.set(checkX, checkY, checkZ);
            if (processInputWithOffset(context, rOffset)) {
                distanceCache.put(x, z, true);
                return true;
            }
        }

        distanceCache.put(x, z, false);
        return false;
    }

    @Override
    public boolean process(@NonNullDecl BiomeProvider.Context context) {
        return withinDistance(context, getTargetDistance(context));
    }

    private static int indexX(int i) {
        return i * 3;
    }

    private static int indexY(int i) {
        return i * 3 + 1;
    }

    private static int indexZ(int i) {
        return i * 3 + 2;
    }
}
