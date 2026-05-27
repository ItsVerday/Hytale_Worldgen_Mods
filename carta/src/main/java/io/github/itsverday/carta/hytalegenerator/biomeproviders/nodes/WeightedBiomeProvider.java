package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import com.hypixel.hytale.builtin.hytalegenerator.rng.RngField;
import com.hypixel.hytale.math.util.FastRandom;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class WeightedBiomeProvider extends BiomeProvider {
    @Nonnull
    private final List<WeightedEntry> entries;
    @Nonnull
    private final RngField rng;
    private final double rounding;
    private double maxWeight;

    private final FastRandom rRandom = new FastRandom();

    public WeightedBiomeProvider(@Nonnull List<WeightedEntry> entries, int seed, double rounding) {
        this.entries = entries;
        this.rng = new RngField(seed);
        this.rounding = rounding;

        maxWeight = 0;
        for (WeightedEntry entry: entries) {
            maxWeight += entry.weight;
        }
    }

    private double applyRounding(double value) {
        if (rounding == 0) return value;
        return Math.floor(value / rounding) * rounding;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        WeightedEntry entryHere = null;
        rRandom.setSeed(rng.get(applyRounding(context.position.x), applyRounding(context.position.y), applyRounding(context.position.z)));
        double rngValue = rRandom.nextDouble() * maxWeight;
        for (WeightedEntry entry: entries) {
            rngValue -= entry.weight;
            if (rngValue < 0) {
                entryHere = entry;
                break;
            }
        }

        return entryHere.value.process(context);
    }

    @Override
    public List<Integer> allPossibleValues() {
        ArrayList<Integer> values = new ArrayList<>();

        for (WeightedEntry entry: entries) {
            for (Integer value: entry.value.allPossibleValues()) {
                if (!values.contains(value)) {
                    values.add(value);
                }
            }
        }

        return values;
    }

    public static class WeightedEntry {
        @Nonnull
        public BiomeProvider value;
        public double weight;

        public WeightedEntry(@Nonnull BiomeProvider value, double weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
