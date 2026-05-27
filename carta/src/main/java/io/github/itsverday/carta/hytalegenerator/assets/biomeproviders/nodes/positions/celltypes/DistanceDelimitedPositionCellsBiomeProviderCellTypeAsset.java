package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions.celltypes;

import com.hypixel.hytale.assetstore.AssetExtraInfo;
import com.hypixel.hytale.assetstore.codec.AssetBuilderCodec;
import com.hypixel.hytale.assetstore.map.DefaultAssetMap;
import com.hypixel.hytale.assetstore.map.JsonAssetWithMap;
import com.hypixel.hytale.builtin.hytalegenerator.assets.Cleanable;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.array.ArrayCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions.PositionCellsBiomeProviderCellTypeAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.PositionCellsBiomeProviderCellType;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.celltypes.DistanceDelimitedPositionCellsBiomeProviderCellType;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.celltypes.FillPositionCellsBiomeProviderCellType;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.util.ArrayList;
import java.util.List;

public class DistanceDelimitedPositionCellsBiomeProviderCellTypeAsset extends PositionCellsBiomeProviderCellTypeAsset {
    public static final BuilderCodec<DistanceDelimitedPositionCellsBiomeProviderCellTypeAsset> CODEC = BuilderCodec.builder(
            DistanceDelimitedPositionCellsBiomeProviderCellTypeAsset.class,
            DistanceDelimitedPositionCellsBiomeProviderCellTypeAsset::new,
            PositionCellsBiomeProviderCellTypeAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Delimiters", new ArrayCodec<>(DistanceDelimiterAsset.CODEC, DistanceDelimiterAsset[]::new), true),
                    (asset, field) -> asset.delimiterAssets = field,
                    asset -> asset.delimiterAssets
            )
            .add()
            .build();

    private DistanceDelimiterAsset[] delimiterAssets = new DistanceDelimiterAsset[0];

    @NonNullDecl
    @Override
    public PositionCellsBiomeProviderCellType build(@NonNullDecl BiomeProviderAsset.Argument argument, BiomeProvider fallback) {
        List<DistanceDelimitedPositionCellsBiomeProviderCellType.DistanceDelimiter> delimiters = new ArrayList<>();
        for (DistanceDelimiterAsset delimiterAsset: delimiterAssets) {
            if (delimiterAsset.input == null) continue;
            DistanceDelimitedPositionCellsBiomeProviderCellType.DistanceDelimiter delimiter = new DistanceDelimitedPositionCellsBiomeProviderCellType.DistanceDelimiter(delimiterAsset.input.build(argument, fallback), delimiterAsset.minimum, delimiterAsset.maximum);
            delimiters.add(delimiter);
        }

        FillPositionCellsBiomeProviderCellType fallbackCellType = new FillPositionCellsBiomeProviderCellType(fallback, 0.0);
        return new DistanceDelimitedPositionCellsBiomeProviderCellType(fallbackCellType, delimiters, getWeight());
    }

    @Override
    public void cleanUp() {
        if (delimiterAssets != null) {
            for (DistanceDelimiterAsset delimiterAsset: delimiterAssets) {
                delimiterAsset.cleanUp();
            }
        }
    }

    public static class DistanceDelimiterAsset implements Cleanable, JsonAssetWithMap<String, DefaultAssetMap<String, DistanceDelimiterAsset>> {
        public static final AssetBuilderCodec<String, DistanceDelimiterAsset> CODEC = AssetBuilderCodec.builder(
                DistanceDelimiterAsset.class,
                DistanceDelimiterAsset::new,
                Codec.STRING,
                (asset, field) -> asset.id = field,
                asset -> asset.id,
                (asset, field) -> asset.data = field,
                asset -> asset.data
        )
                .append(
                        new KeyedCodec<>("Minimum", Codec.DOUBLE, true),
                        (asset, field) -> asset.minimum = field,
                        asset -> asset.minimum
                )
                .add()
                .append(
                        new KeyedCodec<>("Maximum", Codec.DOUBLE, true),
                        (asset, field) -> asset.maximum = field,
                        asset -> asset.maximum
                )
                .add()
                .append(
                        new KeyedCodec<>("CellType", FillPositionCellsBiomeProviderCellTypeAsset.CODEC, false),
                        (asset, field) -> asset.input = field,
                        asset -> asset.input
                )
                .add()
                .build();

        private String id;
        private AssetExtraInfo.Data data;
        private double minimum = 0.0;
        private double maximum = 0.0;
        private FillPositionCellsBiomeProviderCellTypeAsset input;

        @Override
        public String getId() {
            return id;
        }

        @Override
        public void cleanUp() {
            if (input != null) input.cleanUp();
        }
    }
}
