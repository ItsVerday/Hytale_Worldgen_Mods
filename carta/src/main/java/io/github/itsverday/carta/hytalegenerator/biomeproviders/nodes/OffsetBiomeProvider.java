package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.List;

public class OffsetBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProvider input;
    @Nonnull
    private final Vector3d offset;

    private final Vector3d rPosition = new Vector3d();
    private final BiomeProvider.Context rContext = new BiomeProvider.Context();

    public OffsetBiomeProvider(@Nonnull BiomeProvider input, @Nonnull Vector3d offset) {
        this.input = input;
        this.offset = offset;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        rPosition.set(context.position);
        rPosition.add(offset);
        rContext.assign(context);
        rContext.position = rPosition;
        return input.process(rContext);
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
