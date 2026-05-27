package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional;

import com.hypixel.hytale.assetstore.AssetExtraInfo;
import com.hypixel.hytale.assetstore.codec.AssetCodecMapCodec;
import com.hypixel.hytale.assetstore.map.DefaultAssetMap;
import com.hypixel.hytale.assetstore.map.JsonAssetWithMap;
import com.hypixel.hytale.builtin.hytalegenerator.assets.Cleanable;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.CartaPlugin;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;

import javax.annotation.Nonnull;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BiomeProviderConditionAsset implements Cleanable, JsonAssetWithMap<String, DefaultAssetMap<String, BiomeProviderConditionAsset>> {
    public static final ConcurrentHashMap<String, Exported> exportedNodes = new ConcurrentHashMap<>();

    public static final AssetCodecMapCodec<String, BiomeProviderConditionAsset> CODEC = new AssetCodecMapCodec<>(
            Codec.STRING,
            (asset, field) -> asset.id = field,
            asset -> asset.id,
            (asset, field) -> asset.data = field,
            asset -> asset.data
    );
    public static final BuilderCodec<BiomeProviderConditionAsset> ABSTRACT_CODEC = BuilderCodec.abstractBuilder(
            BiomeProviderConditionAsset.class
    )
            .append(
                    new KeyedCodec<>("ExportAs", Codec.STRING, false),
                    (asset, field) -> asset.exportName = field,
                    asset -> asset.exportName
            )
            .add()
            .afterDecode(asset -> {
                if (asset.exportName != null && !asset.exportName.isEmpty()) {
                    if (exportedNodes.containsKey(asset.exportName)) {
                        CartaPlugin.LOGGER.atWarning().log("Duplicate export name for asset: %s", asset.exportName);
                    }

                    Exported exported = new Exported(asset);
                    exportedNodes.put(asset.exportName, exported);
                    CartaPlugin.LOGGER.atFine().log("Registered imported node asset with name '%s' with asset id %s", asset.exportName, asset.id);
                }
            })
            .build();

    private String id;
    private AssetExtraInfo.Data data;
    private String exportName = "";

    public abstract BiomeProviderCondition build(@Nonnull BiomeProviderAsset.Argument argument);

    @Override
    public String getId() {
        return id;
    }

    public static Exported getExportedAsset(@Nonnull String name) {
        return exportedNodes.get(name);
    }

    @Override
    public void cleanUp() {}

    public static class Exported {
        @Nonnull
        public BiomeProviderConditionAsset asset;

        public Exported(@Nonnull BiomeProviderConditionAsset asset) {
            this.asset = asset;
        }
    }
}
