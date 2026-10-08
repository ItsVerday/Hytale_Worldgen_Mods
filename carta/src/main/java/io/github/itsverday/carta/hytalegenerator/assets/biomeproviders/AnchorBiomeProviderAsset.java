package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.AnchorBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class AnchorBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<AnchorBiomeProviderAsset> CODEC = BuilderCodec.builder(
            AnchorBiomeProviderAsset.class,
            AnchorBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Reversed", Codec.BOOLEAN, true),
                    (asset, field) -> asset.isReversed = field,
                    asset -> asset.isReversed
            )
            .add()
            .build();

    private BiomeProviderAsset inputAsset = null;
    private boolean isReversed;

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;

        BiomeProvider input = BiomeProviderAsset.buildStatic(inputAsset, argument, false);
        return new AnchorBiomeProvider(input, isReversed);
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
    }
}
