package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.conditions;

import com.hypixel.hytale.builtin.hytalegenerator.assets.density.DensityAsset;
import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.BiomeProviderConditionAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.ConstantBiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.FieldFunctionBiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class FieldFunctionBiomeProviderConditionAsset extends BiomeProviderConditionAsset {
    public static final BuilderCodec<FieldFunctionBiomeProviderConditionAsset> CODEC = BuilderCodec.builder(
            FieldFunctionBiomeProviderConditionAsset.class,
            FieldFunctionBiomeProviderConditionAsset::new,
            BiomeProviderConditionAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Density", DensityAsset.CODEC, false),
                    (asset, field) -> asset.densityAsset = field,
                    asset -> asset.densityAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Minimum", Codec.DOUBLE, true),
                    (asset, field) -> asset.minimum = field,
                    asset -> asset.minimum
            )
            .add()
            .append(
                    new KeyedCodec<>("Maximum", Codec.DOUBLE, true),
                    (asset, field) -> asset.maximum = field,
                    asset -> asset.maximum
            )
            .add()
            .build();

    private DensityAsset densityAsset = null;
    private double minimum = 0.0;
    private double maximum = 0.0;

    @Override
    public BiomeProviderCondition build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (densityAsset == null) return new ConstantBiomeProviderCondition(false);

        Density density = densityAsset.build(new DensityAsset.Argument(argument.parentSeed, argument.referenceBundle, argument.workerId));
        return new FieldFunctionBiomeProviderCondition(density, minimum, maximum);
    }

    @Override
    public void cleanUp() {
        if (densityAsset != null) densityAsset.cleanUp();
    }
}
