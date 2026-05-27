package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class PreviousBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<PreviousBiomeProviderAsset> CODEC = BuilderCodec.builder(
            PreviousBiomeProviderAsset.class,
            PreviousBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("PreviousLabel", Codec.STRING, true),
                    (asset, field) -> asset.previousLabel = field,
                    asset -> asset.previousLabel
            )
            .add()
            .build();

    private String previousLabel = "";

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        return new PreviousBiomeProvider(argument.getPreviousId(previousLabel));
    }
}
