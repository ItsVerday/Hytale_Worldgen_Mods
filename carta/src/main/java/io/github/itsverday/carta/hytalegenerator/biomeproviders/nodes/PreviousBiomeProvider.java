package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.util.List;

public class PreviousBiomeProvider extends BiomeProvider {
    private final int previousLabel;

    private final Context rContext = new Context();

    public PreviousBiomeProvider() {
        this(-1);
    }

    public PreviousBiomeProvider(int previousLabel) {
        this.previousLabel = previousLabel;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        rContext.assign(context);
        if (previousLabel != -1) {
            while (rContext.previous.getPreviousLabel() != previousLabel && rContext.fallback != null) {
                rContext.assign(rContext.fallback);
            }

            rContext.position = context.position;
            rContext.anchor = context.anchor;
        }

        rContext.previousIndex--;
        return rContext.previous.process(rContext);
    }

    @Override
    public List<Integer> allPossibleValues() {
        return List.of();
    }
}
