package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ConditionalBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProviderCondition condition;
    @Nonnull
    private final BiomeProvider ifTrue;
    @Nonnull
    private final BiomeProvider ifFalse;

    public ConditionalBiomeProvider(@Nonnull BiomeProviderCondition condition, @Nonnull BiomeProvider ifTrue, @Nonnull BiomeProvider ifFalse) {
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        if (condition.process(context)) {
            return ifTrue.process(context);
        } else {
            return ifFalse.process(context);
        }
    }

    @Override
    public List<Integer> allPossibleValues() {
        ArrayList<Integer> values = new ArrayList<>();

        for (Integer value: ifTrue.allPossibleValues()) {
            if (!values.contains(value)) {
                values.add(value);
            }
        }

        for (Integer value: ifFalse.allPossibleValues()) {
            if (!values.contains(value)) {
                values.add(value);
            }
        }

        return values;
    }
}
