package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions;

import com.hypixel.hytale.assetstore.AssetExtraInfo;
import com.hypixel.hytale.assetstore.codec.AssetCodecMapCodec;
import com.hypixel.hytale.assetstore.map.DefaultAssetMap;
import com.hypixel.hytale.assetstore.map.JsonAssetWithMap;
import com.hypixel.hytale.builtin.hytalegenerator.assets.Cleanable;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.PositionCellsBiomeProviderCellType;

import javax.annotation.Nonnull;

public abstract class PositionCellsBiomeProviderCellTypeAsset implements Cleanable, JsonAssetWithMap<String, DefaultAssetMap<String, PositionCellsBiomeProviderCellTypeAsset>> {
    public static final AssetCodecMapCodec<String, PositionCellsBiomeProviderCellTypeAsset> CODEC = new AssetCodecMapCodec<>(
            Codec.STRING,
            (asset, field) -> asset.id = field,
            asset -> asset.id,
            (asset, field) -> asset.data = field,
            asset -> asset.data
    );
    public static final BuilderCodec<PositionCellsBiomeProviderCellTypeAsset> ABSTRACT_CODEC = BuilderCodec.abstractBuilder(
            PositionCellsBiomeProviderCellTypeAsset.class
    )
            .append(
                    new KeyedCodec<>("Weight", Codec.DOUBLE, false),
                    (asset, field) -> asset.weight = field,
                    asset -> asset.weight
            )
            .add()
            .build();

    private String id;
    private AssetExtraInfo.Data data;

    private double weight;

    @Nonnull
    public abstract PositionCellsBiomeProviderCellType build(@Nonnull BiomeProviderAsset.Argument argument, BiomeProvider fallback);

    @Override
    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }
}
