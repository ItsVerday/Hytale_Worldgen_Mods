package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.conditions;

import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.array.ArrayCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.BiomeProviderConditionAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.ConstantBiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.OrBiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.util.ArrayList;

public class OrBiomeProviderConditionAsset extends BiomeProviderConditionAsset {
    public static final BuilderCodec<OrBiomeProviderConditionAsset> CODEC = BuilderCodec.builder(
            OrBiomeProviderConditionAsset.class,
            OrBiomeProviderConditionAsset::new,
            BiomeProviderConditionAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Inputs", new ArrayCodec<>(BiomeProviderConditionAsset.CODEC, BiomeProviderConditionAsset[]::new), true),
                    (asset, field) -> asset.inputAssets = field,
                    asset -> asset.inputAssets
            )
            .add()
            .build();

    private BiomeProviderConditionAsset[] inputAssets = new BiomeProviderConditionAsset[0];

    @Override
    public BiomeProviderCondition build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (inputAssets.length == 0) return new ConstantBiomeProviderCondition(false);

        ArrayList<BiomeProviderCondition> inputs = new ArrayList<>();
        for (BiomeProviderConditionAsset inputAsset: inputAssets) {
            inputs.add(inputAsset.build(argument));
        }

        return new OrBiomeProviderCondition(inputs);
    }

    @Override
    public void cleanUp() {
        for (BiomeProviderConditionAsset inputAsset: inputAssets) {
            inputAsset.cleanUp();
        }
    }
}
