package io.github.itsverday.carta.hytalegenerator.assets.biomeproviderscanners;

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
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.BiomeProviderScanner;

import javax.annotation.Nonnull;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BiomeProviderScannerAsset implements Cleanable, JsonAssetWithMap<String, DefaultAssetMap<String, BiomeProviderScannerAsset>> {
    public static final ConcurrentHashMap<String, BiomeProviderScannerAsset.Exported> exportedNodes = new ConcurrentHashMap<>();

    public static final AssetCodecMapCodec<String, BiomeProviderScannerAsset> CODEC = new AssetCodecMapCodec<>(
            Codec.STRING,
            (asset, field) -> asset.id = field,
            asset -> asset.id,
            (asset, field) -> asset.data = field,
            asset -> asset.data
    );

    public static final BuilderCodec<BiomeProviderScannerAsset> ABSTRACT_CODEC = BuilderCodec.abstractBuilder(
            BiomeProviderScannerAsset.class
    )
            .append(
                    new KeyedCodec<>("Skip", Codec.BOOLEAN, false),
                    (asset, field) -> asset.skip = field,
                    asset -> asset.skip
            )
            .add()
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

                    BiomeProviderScannerAsset.Exported exported = new BiomeProviderScannerAsset.Exported(asset);
                    exportedNodes.put(asset.exportName, exported);
                    CartaPlugin.LOGGER.atFine().log("Registered imported node asset with name '%s' with asset id %s", asset.exportName, asset.id);
                }
            })
            .build();

    private String id;
    private AssetExtraInfo.Data data;
    private boolean skip = false;
    private String exportName = "";

    public abstract BiomeProviderScanner build(@Nonnull BiomeProviderAsset.Argument argument);

    @Override
    public String getId() {
        return id;
    }

    public boolean isSkipped() {
        return skip;
    }

    public static BiomeProviderScannerAsset.Exported getExportedAsset(@Nonnull String name) {
        return exportedNodes.get(name);
    }

    @Override
    public void cleanUp() {}

    public static class Exported {
        @Nonnull
        public BiomeProviderScannerAsset asset;

        public Exported(@Nonnull BiomeProviderScannerAsset asset) {
            this.asset = asset;
        }
    }
}
