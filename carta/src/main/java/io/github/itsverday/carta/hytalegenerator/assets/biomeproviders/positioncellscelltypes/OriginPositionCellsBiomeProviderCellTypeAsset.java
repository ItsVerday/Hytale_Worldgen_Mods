package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.positioncellscelltypes;

import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.positioncellscelltypes.PositionCellsBiomeProviderCellType;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.positioncellscelltypes.OriginPositionCellsBiomeProviderCellType;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class OriginPositionCellsBiomeProviderCellTypeAsset extends PositionCellsBiomeProviderCellTypeAsset {
    public static final BuilderCodec<OriginPositionCellsBiomeProviderCellTypeAsset> CODEC = BuilderCodec.builder(
            OriginPositionCellsBiomeProviderCellTypeAsset.class,
            OriginPositionCellsBiomeProviderCellTypeAsset::new,
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
    public PositionCellsBiomeProviderCellType build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        return new OriginPositionCellsBiomeProviderCellType(BiomeProviderAsset.buildStatic(inputAsset, argument, true), getWeight());
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
    }
}
