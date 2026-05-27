package io.github.itsverday.carta;

import com.hypixel.hytale.assetstore.AssetPack;
import com.hypixel.hytale.assetstore.event.LoadedAssetsEvent;
import com.hypixel.hytale.assetstore.map.DefaultAssetMap;
import com.hypixel.hytale.builtin.hytalegenerator.assets.AssetManager;
import com.hypixel.hytale.builtin.hytalegenerator.assets.worldstructures.WorldStructureAsset;
import com.hypixel.hytale.builtin.hytalegenerator.plugin.HytaleGenerator;
import com.hypixel.hytale.common.plugin.PluginIdentifier;
import com.hypixel.hytale.common.semver.SemverRange;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.protocol.packets.interface_.NotificationStyle;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.asset.*;
import com.hypixel.hytale.server.core.asset.monitor.AssetMonitor;
import com.hypixel.hytale.server.core.asset.monitor.AssetMonitorHandler;
import com.hypixel.hytale.server.core.asset.monitor.EventKind;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.plugin.PluginManager;
import com.hypixel.hytale.server.core.util.NotificationUtil;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.*;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.BiomeProviderConditionAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.ConditionalBiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.SwitchBiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.conditions.*;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions.PositionCellsBiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions.PositionCellsBiomeProviderCellTypeAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions.PositionsPinchBiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions.PositionsTwistBiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions.celltypes.DistanceDelimitedPositionCellsBiomeProviderCellTypeAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions.celltypes.FillPositionCellsBiomeProviderCellTypeAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions.celltypes.OriginPositionCellsBiomeProviderCellTypeAsset;
import io.github.itsverday.carta.hytalegenerator.assets.worldstructure.CartaWorldStructureAsset;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;

public class CartaPlugin extends JavaPlugin {
    public static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    private HytaleGenerator hytaleGeneratorPlugin;
    private AssetManager hytaleGeneratorAssetManager;
    private Method hytaleGeneratorAssetManagerTriggerReloadListeners;

    public CartaPlugin(@Nonnull JavaPluginInit init) {
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

        getCodecRegistry(WorldStructureAsset.CODEC)
                .register("Carta", CartaWorldStructureAsset.class, CartaWorldStructureAsset.CODEC);

        getCodecRegistry(BiomeProviderAsset.CODEC)
                .register("Anchor", AnchorBiomeProviderAsset.class, AnchorBiomeProviderAsset.CODEC)
                .register("Cached", CachedBiomeProviderAsset.class, CachedBiomeProviderAsset.CODEC)
                .register("Conditional", ConditionalBiomeProviderAsset.class, ConditionalBiomeProviderAsset.CODEC)
                .register("Constant", ConstantBiomeProviderAsset.class, ConstantBiomeProviderAsset.CODEC)
                .register("FieldFunction", FieldFunctionBiomeProviderAsset.class, FieldFunctionBiomeProviderAsset.CODEC)
                .register("GradientWarp", GradientWarpBiomeProviderAsset.class, GradientWarpBiomeProviderAsset.CODEC)
                .register("ImageMap", ImageMapBiomeProviderAsset.class, ImageMapBiomeProviderAsset.CODEC)
                .register("Imported", ImportedBiomeProviderAsset.class, ImportedBiomeProviderAsset.CODEC)
                .register("Offset", OffsetBiomeProviderAsset.class, OffsetBiomeProviderAsset.CODEC)
                .register("PositionCells", PositionCellsBiomeProviderAsset.class, PositionCellsBiomeProviderAsset.CODEC)
                .register("PositionsPinch", PositionsPinchBiomeProviderAsset.class, PositionsPinchBiomeProviderAsset.CODEC)
                .register("PositionsTwist", PositionsTwistBiomeProviderAsset.class, PositionsTwistBiomeProviderAsset.CODEC)
                .register("Previous", PreviousBiomeProviderAsset.class, PreviousBiomeProviderAsset.CODEC)
                .register("Scaler", ScalerBiomeProviderAsset.class, ScalerBiomeProviderAsset.CODEC)
                .register("Smoothed", SmoothedBiomeProviderAsset.class, SmoothedBiomeProviderAsset.CODEC)
                .register("Staged", StagedBiomeProviderAsset.class, StagedBiomeProviderAsset.CODEC)
                .register("Switch", SwitchBiomeProviderAsset.class, SwitchBiomeProviderAsset.CODEC)
                .register("VectorWarp", VectorWarpBiomeProviderAsset.class, VectorWarpBiomeProviderAsset.CODEC)
                .register("Weighted", WeightedBiomeProviderAsset.class, WeightedBiomeProviderAsset.CODEC);

        getCodecRegistry(BiomeProviderConditionAsset.CODEC)
                .register("Adjacent", AdjacentBiomeProviderConditionAsset.class, AdjacentBiomeProviderConditionAsset.CODEC)
                .register("And", AndBiomeProviderConditionAsset.class, AndBiomeProviderConditionAsset.CODEC)
                .register("DensityDistance", DensityDistanceBiomeProviderConditionAsset.class, DensityDistanceBiomeProviderConditionAsset.CODEC)
                .register("Distance", DistanceBiomeProviderConditionAsset.class, DistanceBiomeProviderConditionAsset.CODEC)
                .register("FieldFunction", FieldFunctionBiomeProviderConditionAsset.class, FieldFunctionBiomeProviderConditionAsset.CODEC)
                .register("Imported", ImportedBiomeProviderConditionAsset.class, ImportedBiomeProviderConditionAsset.CODEC)
                .register("Not", NotBiomeProviderConditionAsset.class, NotBiomeProviderConditionAsset.CODEC)
                .register("Offset", OffsetBiomeProviderConditionAsset.class, OffsetBiomeProviderConditionAsset.CODEC)
                .register("Or", OrBiomeProviderConditionAsset.class, OrBiomeProviderConditionAsset.CODEC)
                .register("SumRange", SumRangeBiomeProviderConditionAsset.class, SumRangeBiomeProviderConditionAsset.CODEC)
                .register("Value", ValueBiomeProviderConditionAsset.class, ValueBiomeProviderConditionAsset.CODEC)
                .register("Values", ValuesBiomeProviderConditionAsset.class, ValuesBiomeProviderConditionAsset.CODEC);

        getCodecRegistry(PositionCellsBiomeProviderCellTypeAsset.CODEC)
                .register("DistanceDelimited", DistanceDelimitedPositionCellsBiomeProviderCellTypeAsset.class, DistanceDelimitedPositionCellsBiomeProviderCellTypeAsset.CODEC)
                .register("Fill", FillPositionCellsBiomeProviderCellTypeAsset.class, FillPositionCellsBiomeProviderCellTypeAsset.CODEC)
                .register("Origin", OriginPositionCellsBiomeProviderCellTypeAsset.class, OriginPositionCellsBiomeProviderCellTypeAsset.CODEC);

        getAssetRegistry().register(
                HytaleAssetStore.builder(BiomeProviderAsset.class, new DefaultAssetMap<>())
                .setPath("HytaleGenerator/BiomeProviders")
                .setKeyFunction(BiomeProviderAsset::getId)
                .setCodec(BiomeProviderAsset.CODEC)
                .build()
        );

        getAssetRegistry().register(
                HytaleAssetStore.builder(BiomeProviderConditionAsset.class, new DefaultAssetMap<>())
                .setPath("HytaleGenerator/BiomeProviderConditions")
                .setKeyFunction(BiomeProviderConditionAsset::getId)
                .setCodec(BiomeProviderConditionAsset.CODEC)
                .build()
        );

        getEventRegistry().register(LoadedAssetsEvent.class, BiomeProviderAsset.class, this::biomeProvidersReloaded);
        getEventRegistry().register(LoadedAssetsEvent.class, BiomeProviderConditionAsset.class, this::biomeProviderConditionsReloaded);
        getEventRegistry().register(LoadAssetEvent.class, event -> {
            for (AssetPack pack: AssetModule.get().getAssetPacks()) {
                onAssetPackLoaded(pack);
            }
        });
        getEventRegistry().register(AssetPackRegisterEvent.class, event -> {
            onAssetPackLoaded(event.getAssetPack());
        });

        if (PluginManager.get().hasPlugin(PluginIdentifier.fromString("Verday:Renode"), SemverRange.fromString("0.6.0"))) {
            try {
                RenodeIntegration.registerAllNodes();
            } catch (Exception e) {
                LOGGER.atWarning().withCause(e).log("Unable to setup Renode integration!");
            }
        }
    }

    private void biomeProvidersReloaded(@Nonnull LoadedAssetsEvent<String, BiomeProviderAsset, DefaultAssetMap<String, BiomeProviderAsset>> event) {
        triggerReload();
    }

    private void biomeProviderConditionsReloaded(@Nonnull LoadedAssetsEvent<String, BiomeProviderConditionAsset, DefaultAssetMap<String, BiomeProviderConditionAsset>> event) {
        triggerReload();
    }

    private void onAssetPackLoaded(AssetPack pack) {
        Path base = pack.getRoot();
        watchPathForReload(base.resolve("Server").resolve("HytaleGenerator").resolve("Images"), path -> new HytaleGeneratorImagesAssetMonitorHandler());
    }

    private void watchPathForReload(Path path, Function<Path, AssetMonitorHandler> assetMonitorHandlerProducer) {
        if (!Files.isDirectory(path)) return;

        AssetMonitor assetMonitor = AssetModule.get().getAssetMonitor();
        if (assetMonitor == null) return;

        assetMonitor.monitorDirectoryFiles(path, assetMonitorHandlerProducer.apply(path));
    }

    private void triggerReload() {
        if (hytaleGeneratorPlugin == null) return;

        try {
            hytaleGeneratorAssetManagerTriggerReloadListeners.invoke(hytaleGeneratorAssetManager);
        } catch (Exception e) {
            LOGGER.atWarning().withCause(e).log("Unable to hot reload!");
        }
    }

    private class HytaleGeneratorImagesAssetMonitorHandler implements AssetMonitorHandler {
        @Override
        public Object getKey() {
            return CartaPlugin.this;
        }

        @Override
        public boolean test(Path path, EventKind eventKind) {
            return !Files.isDirectory(path);
        }

        @Override
        public void accept(Map<Path, EventKind> map) {
            CartaPlugin.this.triggerReload();
            NotificationUtil.sendNotificationToUniverse(Message.translation("server.general.assetstore.reloadAssets").param("class", "HytaleGenerator/Images").color("#A7AfA7"), "Icons/AssetNotifications/AssetReloaded.png", NotificationStyle.Default);
        }
    }
}