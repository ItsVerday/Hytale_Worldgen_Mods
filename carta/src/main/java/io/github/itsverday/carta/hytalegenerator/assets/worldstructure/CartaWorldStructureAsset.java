package io.github.itsverday.carta.hytalegenerator.assets.worldstructure;

import com.hypixel.hytale.assetstore.codec.ContainedAssetCodec;
import com.hypixel.hytale.builtin.hytalegenerator.Registry;
import com.hypixel.hytale.builtin.hytalegenerator.assets.biomes.BiomeAsset;
import com.hypixel.hytale.builtin.hytalegenerator.assets.framework.FrameworkAsset;
import com.hypixel.hytale.builtin.hytalegenerator.assets.positionproviders.ListPositionProviderAsset;
import com.hypixel.hytale.builtin.hytalegenerator.assets.positionproviders.PositionProviderAsset;
import com.hypixel.hytale.builtin.hytalegenerator.assets.worldstructures.WorldStructureAsset;
import com.hypixel.hytale.builtin.hytalegenerator.biome.Biome;
import com.hypixel.hytale.builtin.hytalegenerator.positionproviders.PositionProvider;
import com.hypixel.hytale.builtin.hytalegenerator.referencebundle.ReferenceBundle;
import com.hypixel.hytale.builtin.hytalegenerator.worldstructure.WorldStructure;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.array.ArrayCodec;
import com.hypixel.hytale.codec.validation.Validators;
import io.github.itsverday.carta.CartaPlugin;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.ConstantBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.cartas.BiomeProviderCarta;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class CartaWorldStructureAsset extends WorldStructureAsset {
    public static final BuilderCodec<CartaWorldStructureAsset> CODEC = BuilderCodec.builder(
            CartaWorldStructureAsset.class,
            CartaWorldStructureAsset::new,
            WorldStructureAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("DefaultBiome", new ContainedAssetCodec<>(BiomeAsset.class, BiomeAsset.CODEC), true),
                    (asset, field) -> asset.defaultBiomeId = field,
                    asset -> asset.defaultBiomeId
            )
            .addValidatorLate(() -> BiomeAsset.VALIDATOR_CACHE.getValidator().late())
            .add()
            .append(
                    new KeyedCodec<>("BiomeProvider", BiomeProviderAsset.CHILD_ASSET_CODEC, false),
                    (asset, field) -> asset.biomeProviderId = field,
                    asset -> asset.biomeProviderId
            )
            .addValidatorLate(() -> BiomeProviderAsset.VALIDATOR_CACHE.getValidator().late())
            .add()
            .append(
                    new KeyedCodec<>("UseDebugMaterials", Codec.BOOLEAN, false),
                    (asset, field) -> asset.useDebugBiomes = field,
                    asset -> asset.useDebugBiomes
            )
            .add()
            .append(
                    new KeyedCodec<>("DefaultTransitionDistance", Codec.INTEGER, true),
                    (asset, field) -> asset.biomeTransitionDistance = field,
                    asset -> asset.biomeTransitionDistance
            )
            .addValidator(Validators.greaterThan(0))
            .add()
            .append(
                    new KeyedCodec<>("MaxBiomeEdgeDistance", Codec.INTEGER, true),
                    (asset, field) -> asset.maxBiomeEdgeDistance = field,
                    asset -> asset.maxBiomeEdgeDistance
            )
            .addValidator(Validators.greaterThanOrEqual(0))
            .add()
            .append(
                    new KeyedCodec<>("Framework", new ArrayCodec<>(FrameworkAsset.CODEC, FrameworkAsset[]::new), false),
                    (asset, field) -> asset.frameworkAssets = field,
                    asset -> asset.frameworkAssets
            )
            .add()
            .append(
                    new KeyedCodec<>("SpawnPositions", PositionProviderAsset.CODEC, false),
                    (asset, field) -> asset.spawnPositionsAsset = field,
                    asset -> asset.spawnPositionsAsset
            )
            .add()
            .build();

    private String defaultBiomeId = "";
    private String biomeProviderId = "";
    private int biomeTransitionDistance = 32;
    private int maxBiomeEdgeDistance = 0;
    private boolean useDebugBiomes = false;

    private FrameworkAsset[] frameworkAssets = new FrameworkAsset[0];
    private PositionProviderAsset spawnPositionsAsset = new ListPositionProviderAsset();

    @NullableDecl
    @Override
    public WorldStructure build(@NonNullDecl Argument argument) {
        ReferenceBundle referenceBundle = new ReferenceBundle();

        for (FrameworkAsset frameworkAsset: frameworkAssets) {
            frameworkAsset.build(argument, referenceBundle);
        }

        BiomeProviderAsset.Argument biomeProviderArgument = new BiomeProviderAsset.Argument(argument.materialCache, argument.parentSeed, referenceBundle, argument.workerId, defaultBiomeId, useDebugBiomes);
        BiomeProvider defaultBiomeProvider = new ConstantBiomeProvider(biomeProviderArgument.getBiomeId(defaultBiomeId, null));
        if (!biomeProviderArgument.biomesById.containsKey(defaultBiomeId)) {
            CartaPlugin.LOGGER.atSevere().log("Default Biome with id '%s' does not exist!", defaultBiomeId);
        }

        BiomeProviderAsset biomeProviderAsset = BiomeProviderAsset.getAssetStore().getAssetMap().getAsset(biomeProviderId);
        if (biomeProviderAsset == null) {
            CartaPlugin.LOGGER.atSevere().log("BiomeProvider asset with id '%s' does not exist!", biomeProviderId);
            return null;
        }

        BiomeProvider biomeProvider = biomeProviderAsset.build(biomeProviderArgument);
        Registry<Biome> biomeRegistry = biomeProviderArgument.buildBiomeRegistry();
        BiomeProviderCarta carta = new BiomeProviderCarta(biomeProvider, defaultBiomeProvider, biomeProviderArgument.buildBiomeRemap());
        int defaultRadius = Math.max(1, biomeTransitionDistance / 2);
        PositionProvider spawnPositions = spawnPositionsAsset.build(new PositionProviderAsset.Argument(argument.parentSeed, referenceBundle, argument.workerId));

        return new WorldStructure(carta, biomeRegistry, defaultRadius, maxBiomeEdgeDistance, spawnPositions);
    }

    @NonNullDecl
    @Override
    public PositionProviderAsset getSpawnPositionsAsset() {
        return spawnPositionsAsset;
    }

    @Override
    public void cleanUp() {
        for (FrameworkAsset frameworkAsset: frameworkAssets) {
            frameworkAsset.cleanUp();
        }

        spawnPositionsAsset.cleanUp();
    }
}
