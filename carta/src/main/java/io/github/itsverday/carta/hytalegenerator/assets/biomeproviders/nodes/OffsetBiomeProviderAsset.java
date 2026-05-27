package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.OffsetBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.joml.Vector3d;

public class OffsetBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<OffsetBiomeProviderAsset> CODEC = BuilderCodec.builder(
            OffsetBiomeProviderAsset.class,
            OffsetBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("OffsetX", Codec.DOUBLE, true),
                    (asset, field) -> asset.offsetX = field,
                    asset -> asset.offsetX
            )
            .add()
            .append(
                    new KeyedCodec<>("OffsetZ", Codec.DOUBLE, true),
                    (asset, field) -> asset.offsetZ = field,
                    asset -> asset.offsetZ
            )
            .add()
            .build();

    private BiomeProviderAsset inputAsset = null;
    private double offsetX = 0;
    private double offsetZ = 0;

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;

        BiomeProvider input = BiomeProviderAsset.buildStatic(inputAsset, argument, PreviousBiomeProvider::new, false);
        return new OffsetBiomeProvider(input, new Vector3d(offsetX, 0, offsetZ));
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
    }
}
