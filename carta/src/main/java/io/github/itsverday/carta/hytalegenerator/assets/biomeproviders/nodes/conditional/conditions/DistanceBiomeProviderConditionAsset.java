package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.conditions;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.validation.Validators;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.BiomeProviderConditionAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.ConstantBiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.Distance2DBiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class DistanceBiomeProviderConditionAsset extends BiomeProviderConditionAsset {
    public static final BuilderCodec<DistanceBiomeProviderConditionAsset> CODEC = BuilderCodec.builder(
            DistanceBiomeProviderConditionAsset.class,
            DistanceBiomeProviderConditionAsset::new,
            BiomeProviderConditionAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderConditionAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Distance", Codec.DOUBLE, true),
                    (asset, field) -> asset.maxDistance = field,
                    asset -> asset.maxDistance
            )
            .addValidator(Validators.greaterThanOrEqual(0.0))
            .add()
            .build();

    private BiomeProviderConditionAsset inputAsset = null;
    private double maxDistance;

    @Override
    public BiomeProviderCondition build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (inputAsset == null) return new ConstantBiomeProviderCondition(false);

        return new Distance2DBiomeProviderCondition(inputAsset.build(argument), maxDistance);
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
    }
}
