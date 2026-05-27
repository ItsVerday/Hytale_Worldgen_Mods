package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.List;

public class AnchorBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProvider input;
    private final boolean isReversed;

    private final Vector3d rPosition = new Vector3d();
    private final Context rContext = new Context();

    public AnchorBiomeProvider(@Nonnull BiomeProvider input, boolean isReversed) {
        this.input = input;
        this.isReversed = isReversed;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        if (context.anchor == null) return input.process(context);

        if (isReversed) {
            rPosition.set(context.position.x + context.anchor.x, context.position.y + context.anchor.y, context.position.z + context.anchor.z);
        } else {
            rPosition.set(context.position.x - context.anchor.x, context.position.y - context.anchor.y, context.position.z - context.anchor.z);
        }

        rContext.assign(context);
        rContext.position = rPosition;

        return input.process(rContext);
    }

    @Override
    public List<Integer> allPossibleValues() {
        return input.allPossibleValues();
    }
}
