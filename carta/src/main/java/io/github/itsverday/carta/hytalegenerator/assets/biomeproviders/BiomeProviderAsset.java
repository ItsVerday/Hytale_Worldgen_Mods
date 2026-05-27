package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders;

import com.hypixel.hytale.assetstore.AssetExtraInfo;
import com.hypixel.hytale.assetstore.AssetKeyValidator;
import com.hypixel.hytale.assetstore.AssetRegistry;
import com.hypixel.hytale.assetstore.AssetStore;
import com.hypixel.hytale.assetstore.codec.AssetCodecMapCodec;
import com.hypixel.hytale.assetstore.codec.ContainedAssetCodec;
import com.hypixel.hytale.assetstore.map.DefaultAssetMap;
import com.hypixel.hytale.assetstore.map.JsonAssetWithMap;
import com.hypixel.hytale.builtin.hytalegenerator.Registry;
import com.hypixel.hytale.builtin.hytalegenerator.assets.Cleanable;
import com.hypixel.hytale.builtin.hytalegenerator.assets.biomes.BiomeAsset;
import com.hypixel.hytale.builtin.hytalegenerator.assets.material.MaterialAsset;
import com.hypixel.hytale.builtin.hytalegenerator.biome.Biome;
import com.hypixel.hytale.builtin.hytalegenerator.biome.SimpleBiome;
import com.hypixel.hytale.builtin.hytalegenerator.material.Material;
import com.hypixel.hytale.builtin.hytalegenerator.material.MaterialCache;
import com.hypixel.hytale.builtin.hytalegenerator.referencebundle.ReferenceBundle;
import com.hypixel.hytale.builtin.hytalegenerator.rng.SeedBox;
import com.hypixel.hytale.builtin.hytalegenerator.workerindexer.WorkerIndexer;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.validation.ValidatorCache;
import io.github.itsverday.carta.CartaPlugin;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomes.DebugBiome;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public abstract class BiomeProviderAsset implements Cleanable, JsonAssetWithMap<String, DefaultAssetMap<String, BiomeProviderAsset>> {
    public static final ConcurrentHashMap<String, Exported> exportedNodes = new ConcurrentHashMap<>();
    public static final ValidatorCache<String> VALIDATOR_CACHE = new ValidatorCache<>(new AssetKeyValidator<>(BiomeProviderAsset::getAssetStore));
    private static AssetStore<String, BiomeProviderAsset, DefaultAssetMap<String, BiomeProviderAsset>> STORE;
    public static final AssetCodecMapCodec<String, BiomeProviderAsset> CODEC = new AssetCodecMapCodec<>(
            Codec.STRING,
            (asset, field) -> asset.id = field,
            asset -> asset.id,
            (asset, field) -> asset.data = field,
            asset -> asset.data
    );
    public static final Codec<String> CHILD_ASSET_CODEC = new ContainedAssetCodec<>(BiomeProviderAsset.class, CODEC);
    public static final BuilderCodec<BiomeProviderAsset> ABSTRACT_CODEC = BuilderCodec.abstractBuilder(
            BiomeProviderAsset.class
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

                    Exported exported = new Exported(asset);
                    exportedNodes.put(asset.exportName, exported);
                    CartaPlugin.LOGGER.atFine().log("Registered imported node asset with name '%s' with asset id %s", asset.exportName, asset.id);
                }
            })
            .build();

    private String id;
    private AssetExtraInfo.Data data;
    private boolean skip = false;
    private String exportName = "";

    @Nullable
    public abstract BiomeProvider build(@Nonnull Argument argument);

    @Nonnull
    public BiomeProvider build(@Nonnull Argument argument, @Nonnull Supplier<BiomeProvider> fallback, boolean cache) {
        BiomeProvider built = build(argument);
        if (built == null) {
            BiomeProvider fallbackProvider = fallback.get();
            if (cache) fallbackProvider = fallbackProvider.makeCached();
            return fallbackProvider;
        }

        if (cache) built = built.makeCached();

        return built;
    }

    @Nonnull
    public static BiomeProvider buildStatic(@Nullable BiomeProviderAsset asset, @Nonnull Argument argument, @Nonnull Supplier<BiomeProvider> fallback, boolean cache) {
        if (asset == null) {
            BiomeProvider fallbackProvider = fallback.get();
            if (cache) fallbackProvider = fallbackProvider.makeCached();
            return fallbackProvider;
        }

        return asset.build(argument, fallback, cache);
    }

    @Nonnull
    public static AssetStore<String, BiomeProviderAsset, DefaultAssetMap<String, BiomeProviderAsset>> getAssetStore() {
        if (STORE == null) {
            STORE = AssetRegistry.getAssetStore(BiomeProviderAsset.class);
        }

        return STORE;
    }

    @Override
    public String getId() {
        return id;
    }

    public boolean isSkipped() {
        return skip;
    }

    public static Exported getExportedAsset(@Nonnull String name) {
        return exportedNodes.get(name);
    }

    @Override
    public void cleanUp() {}

    public static class Argument {
        public MaterialCache materialCache;
        public SeedBox parentSeed;
        public ReferenceBundle referenceBundle;
        public WorkerIndexer.Id workerId;
        public String defaultBiomeId;
        public boolean useDebugBiomes;
        public Material defaultDebugMaterial;
        public final Registry<String> previousLabelRegistry;
        public final Registry<String> biomeIdRegistry;
        public final HashMap<String, Biome> biomesById;
        public final List<Integer> biomeRemap;

        public Argument(@Nonnull MaterialCache materialCache, @Nonnull SeedBox parentSeed, @Nonnull ReferenceBundle referenceBundle, @Nonnull WorkerIndexer.Id workerId, @Nonnull String defaultBiomeId, boolean useDebugBiomes) {
            this.materialCache = materialCache;
            this.parentSeed = parentSeed;
            this.referenceBundle = referenceBundle;
            this.workerId = workerId;
            this.defaultBiomeId = defaultBiomeId;
            this.useDebugBiomes = useDebugBiomes;
            this.previousLabelRegistry = new Registry<>();
            this.biomeIdRegistry = new Registry<>();
            this.biomesById = new HashMap<>();
            this.biomeRemap = new ArrayList<>();
            this.defaultDebugMaterial = new MaterialAsset("Cloth_Block_Wool_White", "Empty", false).build(materialCache);
        }

        public Argument(@Nonnull Argument argument) {
            this.materialCache = argument.materialCache;
            this.parentSeed = argument.parentSeed;
            this.referenceBundle = argument.referenceBundle;
            this.workerId = argument.workerId;
            this.defaultBiomeId = argument.defaultBiomeId;
            this.useDebugBiomes = argument.useDebugBiomes;
            this.previousLabelRegistry = argument.previousLabelRegistry;
            this.biomeIdRegistry = argument.biomeIdRegistry;
            this.biomesById = argument.biomesById;
            this.biomeRemap = argument.biomeRemap;
            this.defaultDebugMaterial = argument.defaultDebugMaterial;
        }

        public int getPreviousId(String previousLabel) {
            if (previousLabel.isEmpty()) return -1;
            return previousLabelRegistry.getIdOrRegister(previousLabel);
        }

        public int getBiomeId(String biomeId, @Nullable Material material) {
            int key = biomeIdRegistry.getIdOrRegister(biomeId);
            if (useDebugBiomes) {
                if (material == null) material = defaultDebugMaterial;
                if ((!biomesById.containsKey(biomeId) || biomesById.get(biomeId) instanceof SimpleBiome)) {
                    biomesById.put(biomeId, new DebugBiome(material));
                }
            } else {
                if (!biomesById.containsKey(biomeId) || biomesById.get(biomeId) instanceof DebugBiome) {
                    BiomeAsset biomeAsset = BiomeAsset.getAssetStore().getAssetMap().getAsset(biomeId);
                    if (biomeAsset != null) {
                        biomesById.put(biomeId, biomeAsset.build(materialCache, parentSeed, referenceBundle, workerId));
                    }
                }
            }

            return key;
        }

        public Registry<Biome> buildBiomeRegistry() {
            Biome fallbackBiome = useDebugBiomes ? new DebugBiome(defaultDebugMaterial) : biomesById.get(defaultBiomeId);

            Registry<Biome> biomeRegistry = new Registry<>();
            for (int id = 0; id < biomeIdRegistry.size(); id++) {
                String biomeId = biomeIdRegistry.getObject(id);
                Biome biome = biomesById.getOrDefault(biomeId, fallbackBiome);
                int newId = biomeRegistry.getIdOrRegister(biome);
                biomeRemap.add(newId);
            }

            return biomeRegistry;
        }

        public int[] buildBiomeRemap() {
            int[] biomeRemapArray = new int[biomeRemap.size()];
            for (int i = 0; i < biomeRemap.size(); i++) {
                biomeRemapArray[i] = biomeRemap.get(i);
            }

            return biomeRemapArray;
        }
    }

    public static class Exported {
        @Nonnull
        public BiomeProviderAsset asset;

        public Exported(@Nonnull BiomeProviderAsset asset) {
            this.asset = asset;
        }
    }
}
