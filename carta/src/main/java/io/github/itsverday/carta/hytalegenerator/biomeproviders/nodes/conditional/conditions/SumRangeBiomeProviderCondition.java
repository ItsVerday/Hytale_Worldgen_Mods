package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;
import java.util.List;

public class SumRangeBiomeProviderCondition extends BiomeProviderCondition {
    @Nonnull
    private final List<BiomeProviderCondition> inputs;
    private final int inputCount;
    private final int minimum;
    private final int maximum;

    public SumRangeBiomeProviderCondition(@Nonnull List<BiomeProviderCondition> inputs, int minimum, int maximum) {
        this.inputs = inputs;
        this.inputCount = inputs.size();
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public boolean process(@NonNullDecl BiomeProvider.Context context) {
        int trueInputs = 0;
        int falseInputs = 0;

        for (BiomeProviderCondition input: inputs) {
            if (input.process(context)) {
                trueInputs++;
            } else {
                falseInputs++;
            }

            if (trueInputs > maximum) return false;
            if (inputCount - falseInputs < minimum) return false;
        }

        return trueInputs >= minimum && trueInputs <= maximum;
    }
}
