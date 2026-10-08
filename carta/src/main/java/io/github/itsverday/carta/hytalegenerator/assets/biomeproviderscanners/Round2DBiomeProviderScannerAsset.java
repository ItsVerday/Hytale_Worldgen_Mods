package io.github.itsverday.carta.hytalegenerator.assets.biomeproviderscanners;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.validation.Validators;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.BiomeProviderScanner;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.OriginBiomeProviderScanner;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.Round2DBiomeProviderScanner;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class Round2DBiomeProviderScannerAsset extends BiomeProviderScannerAsset {
    public static final BuilderCodec<Round2DBiomeProviderScannerAsset> CODEC = BuilderCodec.builder(
            Round2DBiomeProviderScannerAsset.class,
            Round2DBiomeProviderScannerAsset::new,
            BiomeProviderScannerAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Radius", Codec.DOUBLE, true),
                    (asset, field) -> asset.radius = field,
                    asset -> asset.radius
            )
            .addValidator(Validators.greaterThanOrEqual(0.0))
            .add()
            .build();

    private double radius;

    @Override
    public BiomeProviderScanner build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (isSkipped()) return new OriginBiomeProviderScanner();

        return new Round2DBiomeProviderScanner(radius);
    }

    @Override
    public void cleanUp() {
        super.cleanUp();
    }
}
