package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.util.List;

public class ConstantBiomeProvider extends BiomeProvider {
    private final int biome;

    public ConstantBiomeProvider(int biome) {
        this.biome = biome;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        return biome;
    }

    @Override
    public List<Integer> allPossibleValues() {
        return List.of(biome);
    }

    @Override
    public boolean shouldCache() {
        return false;
    }
}
