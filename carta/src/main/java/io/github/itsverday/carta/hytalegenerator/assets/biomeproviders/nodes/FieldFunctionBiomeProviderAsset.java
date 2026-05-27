package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes;

import com.hypixel.hytale.assetstore.AssetExtraInfo;
import com.hypixel.hytale.assetstore.codec.AssetBuilderCodec;
import com.hypixel.hytale.assetstore.map.DefaultAssetMap;
import com.hypixel.hytale.assetstore.map.JsonAssetWithMap;
import com.hypixel.hytale.builtin.hytalegenerator.assets.Cleanable;
import com.hypixel.hytale.builtin.hytalegenerator.assets.density.DensityAsset;
import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import com.hypixel.hytale.builtin.hytalegenerator.density.nodes.ConstantValueDensity;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.array.ArrayCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.FieldFunctionBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.ArrayList;

public class FieldFunctionBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<FieldFunctionBiomeProviderAsset> CODEC = BuilderCodec.builder(
            FieldFunctionBiomeProviderAsset.class,
            FieldFunctionBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Density", DensityAsset.CODEC, false),
                    (asset, field) -> asset.densityAsset = field,
                    asset -> asset.densityAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Delimiters", new ArrayCodec<>(FieldDelimiterAsset.CODEC, FieldDelimiterAsset[]::new), true),
                    (asset, field) -> asset.delimiterAssets = field,
                    asset -> asset.delimiterAssets
            )
            .add()
            .append(
                    new KeyedCodec<>("Fallback", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.fallbackAsset = field,
                    asset -> asset.fallbackAsset
            )
            .add()
            .build();

    private DensityAsset densityAsset = null;
    private FieldDelimiterAsset[] delimiterAssets = new FieldDelimiterAsset[0];
    private BiomeProviderAsset fallbackAsset = null;

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;

        Density density = densityAsset != null ? densityAsset.build(new DensityAsset.Argument(new DensityAsset.Argument(argument.parentSeed, argument.referenceBundle, argument.workerId))) : new ConstantValueDensity(0.0);
        ArrayList<FieldFunctionBiomeProvider.FieldDelimiter> delimiters = new ArrayList<>();

        BiomeProvider fallback = BiomeProviderAsset.buildStatic(fallbackAsset, argument, PreviousBiomeProvider::new, false);

        for (FieldDelimiterAsset delimiterAsset: delimiterAssets) {
            if (delimiterAsset.inputAsset == null) continue;

            BiomeProvider input = delimiterAsset.inputAsset.build(argument);
            if (input == null) continue;

            FieldFunctionBiomeProvider.FieldDelimiter delimiter = new FieldFunctionBiomeProvider.FieldDelimiter(input, delimiterAsset.minimum, delimiterAsset.maximum);
            delimiters.add(delimiter);
        }

        return new FieldFunctionBiomeProvider(fallback, density, delimiters);
    }

    @Override
    public void cleanUp() {
        if (densityAsset != null) densityAsset.cleanUp();
        for (FieldDelimiterAsset delimiter: delimiterAssets) {
            delimiter.cleanUp();
        }

        if (fallbackAsset != null) fallbackAsset.cleanUp();
    }

    public static class FieldDelimiterAsset implements Cleanable, JsonAssetWithMap<String, DefaultAssetMap<String, FieldDelimiterAsset>> {
        public static final AssetBuilderCodec<String, FieldDelimiterAsset> CODEC = AssetBuilderCodec.builder(
                FieldDelimiterAsset.class,
                FieldDelimiterAsset::new,
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
                        new KeyedCodec<>("Input", BiomeProviderAsset.CODEC, false),
                        (asset, field) -> asset.inputAsset = field,
                        asset -> asset.inputAsset
                )
                .add()
                .build();

        private String id;
        private AssetExtraInfo.Data data;
        private double minimum = 0.0;
        private double maximum = 0.0;
        private BiomeProviderAsset inputAsset;

        @Override
        public String getId() {
            return id;
        }

        @Override
        public void cleanUp() {
            if (inputAsset != null) inputAsset.cleanUp();
        }
    }
}
