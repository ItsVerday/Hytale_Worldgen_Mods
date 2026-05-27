package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.conditions;

import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.BiomeProviderConditionAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.Adjacent2DBiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.ConstantBiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class AdjacentBiomeProviderConditionAsset extends BiomeProviderConditionAsset {
    public static final BuilderCodec<AdjacentBiomeProviderConditionAsset> CODEC = BuilderCodec.builder(
            AdjacentBiomeProviderConditionAsset.class,
            AdjacentBiomeProviderConditionAsset::new,
            BiomeProviderConditionAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderConditionAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .build();

    private BiomeProviderConditionAsset inputAsset = null;

    @Override
    public BiomeProviderCondition build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (inputAsset == null) return new ConstantBiomeProviderCondition(false);

        return new Adjacent2DBiomeProviderCondition(inputAsset.build(argument));
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
    }
}
