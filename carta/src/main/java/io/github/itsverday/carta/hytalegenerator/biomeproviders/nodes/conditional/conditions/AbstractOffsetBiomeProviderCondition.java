package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions;

import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.util.cache.SpatialBooleanCache2D;
import org.joml.Vector3d;

import javax.annotation.Nonnull;

public abstract class AbstractOffsetBiomeProviderCondition extends BiomeProviderCondition {
    @Nonnull
    private final BiomeProviderCondition input;

    private final SpatialBooleanCache2D inputCache = new SpatialBooleanCache2D(6);

    private final Vector3d rPosition = new Vector3d();
    private final BiomeProvider.Context rContext = new BiomeProvider.Context();

    public AbstractOffsetBiomeProviderCondition(@Nonnull BiomeProviderCondition input) {
        this.input = input;
    }

    protected boolean processInputWithOffset(@Nonnull BiomeProvider.Context context, @Nonnull Vector3d offset) {
        rPosition.set(context.position.x + offset.x, context.position.y + offset.y, context.position.z + offset.z);
        return inputCache.getOrCompute(rPosition.x, rPosition.z, () -> {
            rContext.assign(context);
            rContext.position = rPosition;
            return input.process(rContext);
        });
    }
}
