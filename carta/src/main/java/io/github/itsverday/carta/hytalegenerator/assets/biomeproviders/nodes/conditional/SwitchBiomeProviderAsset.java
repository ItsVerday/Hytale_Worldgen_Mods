package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional;

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
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.ConditionalBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.List;

public class SwitchBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<SwitchBiomeProviderAsset> CODEC = BuilderCodec.builder(
            SwitchBiomeProviderAsset.class,
            SwitchBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Cases", new ArrayCodec<>(SwitchCaseAsset.CODEC, SwitchCaseAsset[]::new), true),
                    (asset, field) -> asset.caseAssets = field,
                    asset -> asset.caseAssets
            )
            .add()
            .append(
                    new KeyedCodec<>("Fallback", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.fallbackAsset = field,
                    asset -> asset.fallbackAsset
            )
            .add()
            .build();

    private SwitchCaseAsset[] caseAssets = new SwitchCaseAsset[0];
    private BiomeProviderAsset fallbackAsset = null;

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;

        BiomeProvider ifFalse = BiomeProviderAsset.buildStatic(fallbackAsset, argument, PreviousBiomeProvider::new, false);
        for (SwitchCaseAsset caseAsset: List.of(caseAssets).reversed()) {
            if (caseAsset.skip) continue;
            if (caseAsset.conditionAsset == null) continue;
            if (caseAsset.ifTrueAsset == null) continue;

            BiomeProvider ifTrue = caseAsset.ifTrueAsset.build(argument);
            if (ifTrue == null) continue;

            ifFalse = new ConditionalBiomeProvider(caseAsset.conditionAsset.build(argument), ifTrue, ifFalse);
        }

        return ifFalse;
    }

    @Override
    public void cleanUp() {
        for (SwitchCaseAsset caseAsset: caseAssets) {
            caseAsset.cleanUp();
        }
    }

    public static class SwitchCaseAsset implements Cleanable, JsonAssetWithMap<String, DefaultAssetMap<String, SwitchCaseAsset>> {
        public static final AssetBuilderCodec<String, SwitchCaseAsset> CODEC = AssetBuilderCodec.builder(
                SwitchCaseAsset.class,
                SwitchCaseAsset::new,
                Codec.STRING,
                (asset, field) -> asset.id = field,
                asset -> asset.id,
                (asset, field) -> asset.data = field,
                asset -> asset.data
        )
                .append(
                        new KeyedCodec<>("Skip", Codec.BOOLEAN, false),
                        (asset, field) -> asset.skip = field,
                        asset -> asset.skip
                )
                .add()
                .append(
                        new KeyedCodec<>("Condition", BiomeProviderConditionAsset.CODEC, false),
                        (asset, field) -> asset.conditionAsset = field,
                        asset -> asset.conditionAsset
                )
                .add()
                .append(
                        new KeyedCodec<>("IfTrue", BiomeProviderAsset.CODEC, false),
                        (asset, field) -> asset.ifTrueAsset = field,
                        asset -> asset.ifTrueAsset
                )
                .add()
                .build();

        private String id;
        private AssetExtraInfo.Data data;

        private boolean skip = false;
        private BiomeProviderConditionAsset conditionAsset = null;
        private BiomeProviderAsset ifTrueAsset = null;

        @Override
        public String getId() {
            return id;
        }

        @Override
        public void cleanUp() {
            if (conditionAsset != null) conditionAsset.cleanUp();
            if (ifTrueAsset != null) ifTrueAsset.cleanUp();
        }
    }
}
