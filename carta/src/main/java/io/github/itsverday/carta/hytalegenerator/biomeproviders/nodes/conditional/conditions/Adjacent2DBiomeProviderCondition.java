package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class Adjacent2DBiomeProviderCondition extends AbstractOffsetBiomeProviderCondition {
    public static final ArrayList<Vector3d> OFFSETS = new ArrayList<>(List.of(
            new Vector3d(-1, 0, 0),
            new Vector3d(1, 0, 0),
            new Vector3d(0, 0, -1),
            new Vector3d(0, 0, 1)
    ));

    public Adjacent2DBiomeProviderCondition(@Nonnull BiomeProviderCondition input) {
        super(input);
    }

    @Override
    public boolean process(@NonNullDecl BiomeProvider.Context context) {
        for (Vector3d offset: OFFSETS) {
            if (processInputWithOffset(context, offset)) return true;
        }

        return false;
    }
}
