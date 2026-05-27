package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;
import java.util.List;

public class OrBiomeProviderCondition extends BiomeProviderCondition {
    @Nonnull
    private final List<BiomeProviderCondition> inputs;

    public OrBiomeProviderCondition(@Nonnull List<BiomeProviderCondition> inputs) {
        this.inputs = inputs;
    }

    @Override
    public boolean process(@NonNullDecl BiomeProvider.Context context) {
        for (BiomeProviderCondition input: inputs) {
            if (input.process(context)) return true;
        }

        return false;
    }
}
