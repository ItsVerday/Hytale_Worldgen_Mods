package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions.celltypes;

import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions.PositionCellsBiomeProviderCellTypeAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.PositionCellsBiomeProviderCellType;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.celltypes.FillPositionCellsBiomeProviderCellType;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class FillPositionCellsBiomeProviderCellTypeAsset extends PositionCellsBiomeProviderCellTypeAsset {
    public static final BuilderCodec<FillPositionCellsBiomeProviderCellTypeAsset> CODEC = BuilderCodec.builder(
            FillPositionCellsBiomeProviderCellTypeAsset.class,
            FillPositionCellsBiomeProviderCellTypeAsset::new,
            PositionCellsBiomeProviderCellTypeAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .build();

    private BiomeProviderAsset inputAsset = null;

    @NonNullDecl
    @Override
    public PositionCellsBiomeProviderCellType build(@NonNullDecl BiomeProviderAsset.Argument argument, BiomeProvider fallback) {
        return new FillPositionCellsBiomeProviderCellType(BiomeProviderAsset.buildStatic(inputAsset, argument, () -> fallback, false), getWeight());
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
    }
}
