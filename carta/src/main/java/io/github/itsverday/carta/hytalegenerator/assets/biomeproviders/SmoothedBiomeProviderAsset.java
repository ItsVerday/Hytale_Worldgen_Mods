package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.validation.Validators;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviderscanners.BiomeProviderScannerAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.SmoothedBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.BiomeProviderScanner;
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
                    new KeyedCodec<>("Scanner", BiomeProviderScannerAsset.CODEC, false),
                    (asset, field) -> asset.scannerAsset = field,
                    asset -> asset.scannerAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Threshold", Codec.DOUBLE, true),
                    (asset, field) -> asset.threshold = field,
                    asset -> asset.threshold
            )
            .addValidator(Validators.range(0.0, 1.0))
            .add()
            .build();

    private BiomeProviderAsset inputAsset = null;
    private BiomeProviderAsset fallbackAsset = null;
    private BiomeProviderScannerAsset scannerAsset = null;
    private double threshold;

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;

        BiomeProvider input = BiomeProviderAsset.buildStatic(inputAsset, argument, true);
        if (scannerAsset == null) return input;

        BiomeProviderScanner scanner = scannerAsset.build(argument);
        BiomeProvider fallback = BiomeProviderAsset.buildStatic(fallbackAsset, argument, true);
        return new SmoothedBiomeProvider(input.makeCached(), fallback, scanner, threshold);
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
        if (fallbackAsset != null) fallbackAsset.cleanUp();
    }
}
