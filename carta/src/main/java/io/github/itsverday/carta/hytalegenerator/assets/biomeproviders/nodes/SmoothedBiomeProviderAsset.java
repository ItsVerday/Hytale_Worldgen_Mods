package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.validation.Validators;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.Smoothed2DBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class SmoothedBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<SmoothedBiomeProviderAsset> CODEC = BuilderCodec.builder(
            SmoothedBiomeProviderAsset.class,
            SmoothedBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Fallback", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.fallbackAsset = field,
                    asset -> asset.fallbackAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Radius", Codec.DOUBLE, true),
                    (asset, field) -> asset.radius = field,
                    asset -> asset.radius
            )
            .addValidator(Validators.greaterThanOrEqual(0.0))
            .add()
            .append(
                    new KeyedCodec<>("Threshold", Codec.DOUBLE, true),
                    (asset, field) -> asset.threshold = field,
                    asset -> asset.threshold
            )
            .addValidator(Validators.range(0.0, 1.0))
            .add()
            .build();

    private double radius;
    private double threshold;
    private BiomeProviderAsset inputAsset = null;
    private BiomeProviderAsset fallbackAsset = null;

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;

        BiomeProvider input = BiomeProviderAsset.buildStatic(inputAsset, argument, PreviousBiomeProvider::new, true);
        if (radius == 0.0) return input;

        BiomeProvider fallback = BiomeProviderAsset.buildStatic(fallbackAsset, argument, () -> input, true);
        return new Smoothed2DBiomeProvider(input.makeCached(), fallback, radius, threshold);
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
        if (fallbackAsset != null) fallbackAsset.cleanUp();
    }
}
