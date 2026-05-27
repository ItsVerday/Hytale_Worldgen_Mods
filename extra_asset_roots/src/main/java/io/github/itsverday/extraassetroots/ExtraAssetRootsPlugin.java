package io.github.itsverday.extraassetroots;

import com.hypixel.hytale.assetstore.AssetMap;
import com.hypixel.hytale.assetstore.AssetRegistry;
import com.hypixel.hytale.assetstore.JsonAsset;
import com.hypixel.hytale.assetstore.codec.AssetCodec;
import com.hypixel.hytale.assetstore.event.LoadedAssetsEvent;
import com.hypixel.hytale.assetstore.map.DefaultAssetMap;
import com.hypixel.hytale.assetstore.map.JsonAssetWithMap;
import com.hypixel.hytale.builtin.hytalegenerator.assets.AssetManager;
import com.hypixel.hytale.builtin.hytalegenerator.assets.curves.CurveAsset;
import com.hypixel.hytale.builtin.hytalegenerator.assets.materialproviders.MaterialProviderAsset;
import com.hypixel.hytale.builtin.hytalegenerator.assets.patterns.PatternAsset;
import com.hypixel.hytale.builtin.hytalegenerator.assets.scanners.ScannerAsset;
import com.hypixel.hytale.builtin.hytalegenerator.assets.vectorproviders.VectorProviderAsset;
import com.hypixel.hytale.builtin.hytalegenerator.plugin.HytaleGenerator;
import com.hypixel.hytale.common.plugin.PluginIdentifier;
import com.hypixel.hytale.common.semver.SemverRange;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.asset.HytaleAssetStore;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.plugin.PluginManager;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.Function;

public class ExtraAssetRootsPlugin extends JavaPlugin {
    public static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    private HytaleGenerator hytaleGeneratorPlugin;
    private AssetManager hytaleGeneratorAssetManager;
    private Method hytaleGeneratorAssetManagerTriggerReloadListeners;

    public ExtraAssetRootsPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        hytaleGeneratorPlugin = (HytaleGenerator) PluginManager.get().getPlugin(PluginIdentifier.fromString("Hytale:HytaleGenerator"));
        try {
            Field hytaleGeneratorAssetManagerField = HytaleGenerator.class.getDeclaredField("assetManager");
            hytaleGeneratorAssetManagerField.setAccessible(true);
            hytaleGeneratorAssetManager = (AssetManager) hytaleGeneratorAssetManagerField.get(hytaleGeneratorPlugin);
            hytaleGeneratorAssetManagerTriggerReloadListeners = AssetManager.class.getDeclaredMethod("triggerReloadListeners");
            hytaleGeneratorAssetManagerTriggerReloadListeners.setAccessible(true);
        } catch (Exception e) {
            LOGGER.atWarning().withCause(e).log("Unable to setup hot reloading!");
        }

        registerAssetStore(ScannerAsset.class, "HytaleGenerator/Scanners", ScannerAsset::getId, ScannerAsset.CODEC);
        registerAssetStore(PatternAsset.class, "HytaleGenerator/Patterns", PatternAsset::getId, PatternAsset.CODEC);
        registerAssetStore(CurveAsset.class, "HytaleGenerator/Curves", CurveAsset::getId, CurveAsset.CODEC);
        registerAssetStore(MaterialProviderAsset.class, "HytaleGenerator/MaterialProviders", MaterialProviderAsset::getId, MaterialProviderAsset.CODEC);
        registerAssetStore(VectorProviderAsset.class, "HytaleGenerator/VectorProviders", VectorProviderAsset::getId, VectorProviderAsset.CODEC);

        if (PluginManager.get().hasPlugin(PluginIdentifier.fromString("Verday:Renode"), SemverRange.fromString("0.5.0"))) {
            try {
                RenodeIntegration.registerAllNodes();
            } catch (Exception e) {
                LOGGER.atWarning().withCause(e).log("Unable to setup Renode integration!");
            }
        }
    }

    private <T extends JsonAssetWithMap<String, M>, M extends AssetMap<String, T>> void registerAssetStore(Class<T> assetClass, String path, Function<T, String> keyFunction, AssetCodec<String, T> codec) {
        getAssetRegistry().register(
                HytaleAssetStore.builder(assetClass, (M) new DefaultAssetMap<String, T>())
                .setPath(path)
                .setKeyFunction(keyFunction)
                .setCodec(codec)
                .build()
        );

        getEventRegistry().register(LoadedAssetsEvent.class, assetClass, this::eventCallback);
    }

    private <T extends JsonAsset<String>> void eventCallback(@Nonnull LoadedAssetsEvent<String, T, DefaultAssetMap<String, T>> event) {
        triggerReload();
    }

    private void triggerReload() {
        if (hytaleGeneratorPlugin == null) return;

        try {
            hytaleGeneratorAssetManagerTriggerReloadListeners.invoke(hytaleGeneratorAssetManager);
        } catch (Exception e) {
            LOGGER.atWarning().withCause(e).log("Unable to hot reload!");
        }
    }
}