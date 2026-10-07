package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.scanners.nodes;

import com.hypixel.hytale.builtin.hytalegenerator.assets.density.DensityAsset;
import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.validation.Validators;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.scanners.BiomeProviderScannerAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.BiomeProviderScanner;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.nodes.DensityRound2DBiomeProviderScanner;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.nodes.OriginBiomeProviderScanner;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class DensityRound2DBiomeProviderScannerAsset extends BiomeProviderScannerAsset {
    public static final BuilderCodec<DensityRound2DBiomeProviderScannerAsset> CODEC = BuilderCodec.builder(
            DensityRound2DBiomeProviderScannerAsset.class,
            DensityRound2DBiomeProviderScannerAsset::new,
            BiomeProviderScannerAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Density", DensityAsset.CODEC, false),
                    (asset, field) -> asset.densityAsset = field,
                    asset -> asset.densityAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("MinRadius", Codec.DOUBLE, true),
                    (asset, field) -> asset.minRadius = field,
                    asset -> asset.minRadius
            )
            .addValidator(Validators.greaterThanOrEqual(0.0))
            .add()
            .append(
                    new KeyedCodec<>("MaxRadius", Codec.DOUBLE, true),
                    (asset, field) -> asset.maxRadius = field,
                    asset -> asset.maxRadius
            )
            .addValidator(Validators.greaterThanOrEqual(0.0))
            .add()
            .build();

    private DensityAsset densityAsset = null;
    private double minRadius;
    private double maxRadius;

    @Override
    public BiomeProviderScanner build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (isSkipped()) return new OriginBiomeProviderScanner();
        if (densityAsset == null) return new OriginBiomeProviderScanner();

        Density density = densityAsset.build(new DensityAsset.Argument(argument.parentSeed, argument.referenceBundle, argument.workerId, argument.threadBridge));
        return new DensityRound2DBiomeProviderScanner(density, minRadius, maxRadius);
    }

    @Override
    public void cleanUp() {
        if (densityAsset != null) densityAsset.cleanUp();
    }
}
