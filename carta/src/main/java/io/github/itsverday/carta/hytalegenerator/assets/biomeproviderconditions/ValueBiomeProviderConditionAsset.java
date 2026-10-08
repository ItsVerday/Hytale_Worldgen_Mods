package io.github.itsverday.carta.hytalegenerator.assets.biomeproviderconditions;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviderconditions.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviderconditions.ConstantBiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviderconditions.ValueBiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class ValueBiomeProviderConditionAsset extends BiomeProviderConditionAsset {
    public static final BuilderCodec<ValueBiomeProviderConditionAsset> CODEC = BuilderCodec.builder(
            ValueBiomeProviderConditionAsset.class,
            ValueBiomeProviderConditionAsset::new,
            BiomeProviderConditionAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Biome", Codec.STRING, true),
                    (asset, field) -> asset.biome = field,
                    asset -> asset.biome
            )
            .add()
            .build();


    private BiomeProviderAsset inputAsset = null;
    private String biome = "";

    @Override
    public BiomeProviderCondition build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (biome.isEmpty()) return new ConstantBiomeProviderCondition(false);

        BiomeProvider input = BiomeProviderAsset.buildStatic(inputAsset, argument, false);
        return new ValueBiomeProviderCondition(input, argument.getBiomeId(biome, null));
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
    }
}
