package io.github.itsverday.carta.hytalegenerator.assets.biomeproviderconditions;

import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviderconditions.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviderconditions.ConstantBiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviderconditions.NotBiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class NotBiomeProviderConditionAsset extends BiomeProviderConditionAsset {
    public static final BuilderCodec<NotBiomeProviderConditionAsset> CODEC = BuilderCodec.builder(
            NotBiomeProviderConditionAsset.class,
            NotBiomeProviderConditionAsset::new,
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

        return new NotBiomeProviderCondition(inputAsset.build(argument));
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
    }
}
