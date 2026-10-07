package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.scanners.nodes;

import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.scanners.BiomeProviderScannerAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.BiomeProviderScanner;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.nodes.OriginBiomeProviderScanner;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class OriginBiomeProviderScannerAsset extends BiomeProviderScannerAsset {
    public static final BuilderCodec<OriginBiomeProviderScannerAsset> CODEC = BuilderCodec.builder(
            OriginBiomeProviderScannerAsset.class,
            OriginBiomeProviderScannerAsset::new,
            BiomeProviderScannerAsset.ABSTRACT_CODEC
    )
            .build();

    @Override
    public BiomeProviderScanner build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        return new OriginBiomeProviderScanner();
    }

    @Override
    public void cleanUp() {
        super.cleanUp();
    }
}
