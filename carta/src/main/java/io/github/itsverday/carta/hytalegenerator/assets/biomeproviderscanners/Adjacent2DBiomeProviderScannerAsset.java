package io.github.itsverday.carta.hytalegenerator.assets.biomeproviderscanners;

import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.BiomeProviderScanner;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.Adjacent2DBiomeProviderScanner;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.OriginBiomeProviderScanner;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class Adjacent2DBiomeProviderScannerAsset extends BiomeProviderScannerAsset {
    public static final BuilderCodec<Adjacent2DBiomeProviderScannerAsset> CODEC = BuilderCodec.builder(
            Adjacent2DBiomeProviderScannerAsset.class,
            Adjacent2DBiomeProviderScannerAsset::new,
            BiomeProviderScannerAsset.ABSTRACT_CODEC
    )
            .build();

    @Override
    public BiomeProviderScanner build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (isSkipped()) return new OriginBiomeProviderScanner();

        return new Adjacent2DBiomeProviderScanner();
    }

    @Override
    public void cleanUp() {
        super.cleanUp();
    }
}
