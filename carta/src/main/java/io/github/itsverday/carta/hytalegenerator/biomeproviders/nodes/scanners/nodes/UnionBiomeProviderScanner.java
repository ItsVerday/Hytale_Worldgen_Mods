package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.nodes;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.BiomeProviderScanner;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class UnionBiomeProviderScanner extends BiomeProviderScanner {
    @Nonnull
    private final List<BiomeProviderScanner> inputs;

    public UnionBiomeProviderScanner(@Nonnull List<BiomeProviderScanner> inputs) {
        this.inputs = new ArrayList<>();
        this.inputs.addAll(inputs);
    }

    @Override
    public void generate(@NonNullDecl Context context) {
        for (BiomeProviderScanner input: inputs) {
            input.generate(context);
        }
    }
}
