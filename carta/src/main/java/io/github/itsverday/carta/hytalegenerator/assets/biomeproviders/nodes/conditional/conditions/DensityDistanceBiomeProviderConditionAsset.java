package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.conditions;

import com.hypixel.hytale.builtin.hytalegenerator.assets.density.DensityAsset;
import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.validation.Validators;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.BiomeProviderConditionAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.ConstantBiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.DensityDistance2DBiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class DensityDistanceBiomeProviderConditionAsset extends BiomeProviderConditionAsset {
    public static final BuilderCodec<DensityDistanceBiomeProviderConditionAsset> CODEC = BuilderCodec.builder(
            DensityDistanceBiomeProviderConditionAsset.class,
            DensityDistanceBiomeProviderConditionAsset::new,
            BiomeProviderConditionAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderConditionAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Density", DensityAsset.CODEC, false),
                    (asset, field) -> asset.densityAsset = field,
                    asset -> asset.densityAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("MinDistance", Codec.DOUBLE, true),
                    (asset, field) -> asset.minDistance = field,
                    asset -> asset.minDistance
            )
            .addValidator(Validators.greaterThanOrEqual(0.0))
            .add()
            .append(
                    new KeyedCodec<>("MaxDistance", Codec.DOUBLE, true),
                    (asset, field) -> asset.maxDistance = field,
                    asset -> asset.maxDistance
            )
            .addValidator(Validators.greaterThanOrEqual(0.0))
            .add()
            .build();

    private BiomeProviderConditionAsset inputAsset = null;
    private DensityAsset densityAsset = null;
    private double minDistance;
    private double maxDistance;

    @Override
    public BiomeProviderCondition build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (inputAsset == null) return new ConstantBiomeProviderCondition(false);
        if (densityAsset == null) return new ConstantBiomeProviderCondition(false);

        Density density = densityAsset.build(new DensityAsset.Argument(argument.parentSeed, argument.referenceBundle, argument.workerId));
        return new DensityDistance2DBiomeProviderCondition(inputAsset.build(argument), density, minDistance, maxDistance);
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) cleanUp();
        if (densityAsset != null) cleanUp();
    }
}
