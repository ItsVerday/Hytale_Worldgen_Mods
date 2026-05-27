package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;

public class OffsetBiomeProviderCondition extends BiomeProviderCondition {
    @Nonnull
    private final BiomeProviderCondition input;
    @Nonnull
    private final Vector3d offset;

    private final Vector3d rPosition = new Vector3d();
    private final BiomeProvider.Context rContext = new BiomeProvider.Context();

    public OffsetBiomeProviderCondition(@Nonnull BiomeProviderCondition input, @Nonnull Vector3d offset) {
        this.input = input;
        this.offset = offset;
    }

    @Override
    public boolean process(@NonNullDecl BiomeProvider.Context context) {
        rPosition.set(context.position);
        rPosition.add(offset);
        rContext.assign(context);
        rContext.position = rPosition;
        return input.process(rContext);
    }
}
