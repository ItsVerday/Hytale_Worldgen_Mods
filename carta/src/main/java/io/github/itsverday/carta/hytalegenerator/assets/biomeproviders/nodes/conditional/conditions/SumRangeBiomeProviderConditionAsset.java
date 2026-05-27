package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.conditions;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.array.ArrayCodec;
import com.hypixel.hytale.codec.validation.Validators;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.BiomeProviderConditionAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.ConstantBiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.SumRangeBiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.util.ArrayList;

public class SumRangeBiomeProviderConditionAsset extends BiomeProviderConditionAsset {
    public static final BuilderCodec<SumRangeBiomeProviderConditionAsset> CODEC = BuilderCodec.builder(
            SumRangeBiomeProviderConditionAsset.class,
            SumRangeBiomeProviderConditionAsset::new,
            BiomeProviderConditionAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Inputs", new ArrayCodec<>(BiomeProviderConditionAsset.CODEC, BiomeProviderConditionAsset[]::new), true),
                    (asset, field) -> asset.inputAssets = field,
                    asset -> asset.inputAssets
            )
            .add()
            .append(
                    new KeyedCodec<>("Minimum", Codec.INTEGER, true),
                    (asset, field) -> asset.minimum = field,
                    asset -> asset.minimum
            )
            .addValidator(Validators.greaterThanOrEqual(0))
            .add()
            .append(
                    new KeyedCodec<>("Maximum", Codec.INTEGER, true),
                    (asset, field) -> asset.maximum = field,
                    asset -> asset.maximum
            )
            .addValidator(Validators.greaterThanOrEqual(0))
            .add()
            .build();

    private BiomeProviderConditionAsset[] inputAssets = new BiomeProviderConditionAsset[0];
    private int minimum;
    private int maximum;

    @Override
    public BiomeProviderCondition build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (inputAssets.length == 0) return new ConstantBiomeProviderCondition(minimum <= 0 && maximum >= 0);

        ArrayList<BiomeProviderCondition> inputs = new ArrayList<>();
        for (BiomeProviderConditionAsset inputAsset: inputAssets) {
            inputs.add(inputAsset.build(argument));
        }

        return new SumRangeBiomeProviderCondition(inputs, minimum, maximum);
    }
}
