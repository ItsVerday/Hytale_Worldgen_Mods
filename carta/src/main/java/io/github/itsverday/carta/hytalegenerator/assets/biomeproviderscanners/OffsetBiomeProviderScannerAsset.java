package io.github.itsverday.carta.hytalegenerator.assets.biomeproviderscanners;

import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.math.vector.Vector3dUtil;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.BiomeProviderScanner;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.OffsetBiomeProviderScanner;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.OriginBiomeProviderScanner;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

public class OffsetBiomeProviderScannerAsset extends BiomeProviderScannerAsset {
    public static final BuilderCodec<OffsetBiomeProviderScannerAsset> CODEC = BuilderCodec.builder(
            OffsetBiomeProviderScannerAsset.class,
            OffsetBiomeProviderScannerAsset::new,
            BiomeProviderScannerAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderScannerAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Offset", Vector3dUtil.CODEC, false),
                    (asset, field) -> asset.offset = field,
                    asset -> asset.offset
            )
            .add()
            .build();

    private BiomeProviderScannerAsset inputAsset = null;
    private Vector3d offset;

    @Override
    public BiomeProviderScanner build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (isSkipped()) return new OriginBiomeProviderScanner();
        if (inputAsset == null) return new OriginBiomeProviderScanner();
        if (offset == null) return new OriginBiomeProviderScanner();

        return new OffsetBiomeProviderScanner(offset, inputAsset.build(argument));
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
    }
}
