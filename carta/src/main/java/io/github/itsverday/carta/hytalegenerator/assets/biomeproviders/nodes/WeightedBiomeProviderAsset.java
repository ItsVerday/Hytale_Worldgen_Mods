package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes;

import com.hypixel.hytale.assetstore.AssetExtraInfo;
import com.hypixel.hytale.assetstore.codec.AssetBuilderCodec;
import com.hypixel.hytale.assetstore.map.DefaultAssetMap;
import com.hypixel.hytale.assetstore.map.JsonAssetWithMap;
import com.hypixel.hytale.builtin.hytalegenerator.assets.Cleanable;
import com.hypixel.hytale.builtin.hytalegenerator.rng.SeedBox;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.array.ArrayCodec;
import com.hypixel.hytale.codec.validation.Validators;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.WeightedBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.ArrayList;
import java.util.List;

public class WeightedBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<WeightedBiomeProviderAsset> CODEC = BuilderCodec.builder(
            WeightedBiomeProviderAsset.class,
            WeightedBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Seed", Codec.STRING, true),
                    (asset, field) -> asset.seed = field,
                    asset -> asset.seed
            )
            .add()
            .append(
                    new KeyedCodec<>("Rounding", Codec.DOUBLE, true),
                    (asset, field) -> asset.rounding = field,
                    asset -> asset.rounding
            )
            .add()
            .append(
                    new KeyedCodec<>("Entries", new ArrayCodec<>(WeightedEntryAsset.CODEC, WeightedEntryAsset[]::new), true),
                    (asset, field) -> asset.entryAssets = field,
                    asset -> asset.entryAssets
            )
            .add()

            .build();

    private String seed;
    private double rounding;
    private WeightedEntryAsset[] entryAssets = new WeightedEntryAsset[0];

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;
        if (entryAssets.length == 0) return null;

        List<WeightedBiomeProvider.WeightedEntry> entries = new ArrayList<>();
        for (WeightedEntryAsset entryAsset: entryAssets) {
            BiomeProvider value = BiomeProviderAsset.buildStatic(entryAsset.valueAsset, argument, PreviousBiomeProvider::new, false);
            entries.add(new WeightedBiomeProvider.WeightedEntry(value, entryAsset.weight));
        }

        if (entries.size() == 1) return entries.getFirst().value;

        SeedBox childSeed = argument.parentSeed.child(seed);
        return new WeightedBiomeProvider(entries, childSeed.createSupplier().get(), rounding);
    }

    @Override
    public void cleanUp() {
        for (WeightedEntryAsset entryAsset: entryAssets) {
            entryAsset.cleanUp();
        }
    }

    public static class WeightedEntryAsset implements Cleanable, JsonAssetWithMap<String, DefaultAssetMap<String, WeightedEntryAsset>> {
        public static final AssetBuilderCodec<String, WeightedEntryAsset> CODEC = AssetBuilderCodec.builder(
                WeightedEntryAsset.class,
                WeightedEntryAsset::new,
                Codec.STRING,
                (asset, field) -> asset.id = field,
                asset -> asset.id,
                (asset, field) -> asset.data = field,
                asset -> asset.data
        )
                .append(
                        new KeyedCodec<>("Value", BiomeProviderAsset.CODEC, false),
                        (asset, field) -> asset.valueAsset = field,
                        asset -> asset.valueAsset
                )
                .add()
                .append(
                        new KeyedCodec<>("Weight", Codec.DOUBLE, true),
                        (asset, field) -> asset.weight = field,
                        asset -> asset.weight
                )
                .addValidator(Validators.greaterThanOrEqual(0.0))
                .add()
                .build();

        private String id;
        private AssetExtraInfo.Data data;
        private BiomeProviderAsset valueAsset;
        private double weight;

        @Override
        public String getId() {
            return id;
        }

        @Override
        public void cleanUp() {
            if (valueAsset != null) valueAsset.cleanUp();
        }
    }
}
