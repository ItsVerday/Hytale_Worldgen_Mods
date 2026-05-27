package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class Smoothed2DBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProvider input;
    @Nonnull
    private final BiomeProvider fallback;
    private final double radiusSquared;
    private final int radiusInt;
    private final double threshold;
    private double totalThreshold = Double.MAX_VALUE;

    private final Int2IntOpenHashMap rCounts = new Int2IntOpenHashMap();
    private final Vector3d rPosition = new Vector3d();
    private final Context rContext = new Context();

    public Smoothed2DBiomeProvider(@Nonnull BiomeProvider input, @Nonnull BiomeProvider fallback, double radius, double threshold) {
        this.input = input;
        this.fallback = fallback;
        this.radiusSquared = radius * radius;
        this.radiusInt = (int) Math.ceil(radius);
        this.threshold = threshold;

        rCounts.defaultReturnValue(0);
    }

    @Override
    public int process(@NonNullDecl Context context) {
        int totalCount = 0;
        int highestCount = 0;

        rContext.assign(context);
        rContext.position = rPosition;

        rCounts.clear();
        for (int dx = -radiusInt; dx <= radiusInt; dx++) {
            for (int dz = -radiusInt; dz <= radiusInt; dz++) {
                if (dx * dx + dz * dz > radiusSquared) continue;

                rPosition.set(context.position.x + dx, context.position.y, context.position.z + dz);
                int value = input.process(rContext);
                int currentCount = rCounts.get(value) + 1;
                if (threshold >= 0.5 && currentCount > totalThreshold) return value;

                rCounts.put(value, currentCount);
                highestCount = Math.max(highestCount, currentCount);
                totalCount++;
            }
        }

        if (totalThreshold == Double.MAX_VALUE) totalThreshold = totalCount * threshold;

        for (int value: rCounts.keySet()) {
            int count = rCounts.get(value);
            if (count == highestCount) {
                if (count >= totalThreshold) return value;
                break;
            }
        }

        return fallback.process(context);
    }

    @Override
    public List<Integer> allPossibleValues() {
        ArrayList<Integer> values = new ArrayList<>();

        for (Integer value: input.allPossibleValues()) {
            if (!values.contains(value)) {
                values.add(value);
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
