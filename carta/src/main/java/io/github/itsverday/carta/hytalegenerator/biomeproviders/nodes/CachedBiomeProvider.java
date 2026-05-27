package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.util.cache.SpatialIntCache2D;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;
import java.util.List;

public class CachedBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProvider input;
    private final SpatialIntCache2D cache = new SpatialIntCache2D(6);

    public CachedBiomeProvider(@Nonnull BiomeProvider input) {
        this.input = input;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        return cache.getOrCompute(context.position.x, context.position.z, () -> input.process(context));
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
