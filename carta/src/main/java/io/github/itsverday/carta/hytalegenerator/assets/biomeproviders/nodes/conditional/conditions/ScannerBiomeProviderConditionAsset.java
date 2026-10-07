package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.conditions;

import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.BiomeProviderConditionAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.scanners.BiomeProviderScannerAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.ConstantBiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.ScannerBiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class ScannerBiomeProviderConditionAsset extends BiomeProviderConditionAsset {
    public static final BuilderCodec<ScannerBiomeProviderConditionAsset> CODEC = BuilderCodec.builder(
            ScannerBiomeProviderConditionAsset.class,
            ScannerBiomeProviderConditionAsset::new,
            BiomeProviderConditionAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderConditionAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Scanner", BiomeProviderScannerAsset.CODEC, false),
                    (asset, field) -> asset.scannerAsset = field,
                    asset -> asset.scannerAsset
            )
            .add()
            .build();

    private BiomeProviderConditionAsset inputAsset = null;
    private BiomeProviderScannerAsset scannerAsset = null;

    @Override
    public BiomeProviderCondition build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (inputAsset == null) return new ConstantBiomeProviderCondition(false);
        if (scannerAsset == null) return new ConstantBiomeProviderCondition(false);

        return new ScannerBiomeProviderCondition(inputAsset.build(argument), scannerAsset.build(argument));
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
        if (scannerAsset != null) scannerAsset.cleanUp();
    }
}
