package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.scanners.nodes;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.CartaPlugin;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.scanners.BiomeProviderScannerAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.BiomeProviderScanner;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.nodes.OriginBiomeProviderScanner;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class ImportedBiomeProviderScannerAsset extends BiomeProviderScannerAsset {
    public static final BuilderCodec<ImportedBiomeProviderScannerAsset> CODEC = BuilderCodec.builder(
            ImportedBiomeProviderScannerAsset.class,
            ImportedBiomeProviderScannerAsset::new,
            BiomeProviderScannerAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Name", Codec.STRING, true),
                    (asset, field) -> asset.importName = field,
                    asset -> asset.importName
            )
            .add()
            .build();

    private String importName = "";

    @Override
    public BiomeProviderScanner build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        BiomeProviderScannerAsset.Exported exported = getExportedAsset(importName);

        if (exported == null) {
            CartaPlugin.LOGGER.atWarning().log("Couldn't find BiomeScanner asset exported with name: '%s'.", importName);
            return new OriginBiomeProviderScanner();
        }

        return exported.asset.build(argument);
    }
}
