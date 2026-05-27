package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class StagedBiomeProvider extends BiomeProvider {
    @Nonnull
    private final List<BiomeProvider> inputs;
    private final int previousLabel;
    private final int inputCount;

    private final Context rBaseContext = new Context();
    private final Context rFallbackContext = new Context();

    public StagedBiomeProvider(@Nonnull List<BiomeProvider> inputs, int previousLabel) {
        this.inputs = inputs;
        this.previousLabel = previousLabel;
        this.inputCount = inputs.size();
    }

    @Override
    public int process(@NonNullDecl Context context) {
        if (context.previous != this) {
            rBaseContext.assign(context);
            rBaseContext.previous = this;
            rBaseContext.previousIndex = inputCount - 1;
            rBaseContext.fallback = context;

            return inputs.get(rBaseContext.previousIndex).process(rBaseContext);
        }

        if (context.previousIndex > -1) return inputs.get(context.previousIndex).process(context);

        rFallbackContext.assign(context);
        rFallbackContext.previous = context.fallback.previous;
        rFallbackContext.previousIndex = context.fallback.previousIndex - 1;
        rFallbackContext.fallback = context.fallback.fallback;

        return rFallbackContext.previous.process(rFallbackContext);
    }

    @Override
    public List<Integer> allPossibleValues() {
        ArrayList<Integer> values = new ArrayList<>();

        for (BiomeProvider input: inputs) {
            for (Integer value: input.allPossibleValues()) {
                if (!values.contains(value)) {
                    values.add(value);
                }
            }
        }

        return values;
    }

    @Override
    public int getPreviousLabel() {
        return previousLabel;
    }
}
