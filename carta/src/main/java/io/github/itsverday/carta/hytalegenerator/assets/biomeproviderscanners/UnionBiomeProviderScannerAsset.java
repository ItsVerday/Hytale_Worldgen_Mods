package io.github.itsverday.carta.hytalegenerator.assets.biomeproviderscanners;

import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.array.ArrayCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.BiomeProviderScanner;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.OriginBiomeProviderScanner;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.UnionBiomeProviderScanner;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.util.ArrayList;

public class UnionBiomeProviderScannerAsset extends BiomeProviderScannerAsset {
    public static final BuilderCodec<UnionBiomeProviderScannerAsset> CODEC = BuilderCodec.builder(
            UnionBiomeProviderScannerAsset.class,
            UnionBiomeProviderScannerAsset::new,
            BiomeProviderScannerAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Inputs", new ArrayCodec<>(BiomeProviderScannerAsset.CODEC, BiomeProviderScannerAsset[]::new), true),
                    (asset, field) -> asset.inputAssets = field,
                    asset -> asset.inputAssets
            )
            .add()
            .build();

    private BiomeProviderScannerAsset[] inputAssets = new BiomeProviderScannerAsset[0];

    @Override
    public BiomeProviderScanner build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (isSkipped()) return new OriginBiomeProviderScanner();
        if (inputAssets.length == 0) return new OriginBiomeProviderScanner();

        ArrayList<BiomeProviderScanner> inputs = new ArrayList<>();
        for (BiomeProviderScannerAsset inputAsset: inputAssets) {
            inputs.add(inputAsset.build(argument));
        }

        return new UnionBiomeProviderScanner(inputs);
    }

    @Override
    public void cleanUp() {
        for (BiomeProviderScannerAsset inputAsset: inputAssets) {
            inputAsset.cleanUp();
        }
    }
}
