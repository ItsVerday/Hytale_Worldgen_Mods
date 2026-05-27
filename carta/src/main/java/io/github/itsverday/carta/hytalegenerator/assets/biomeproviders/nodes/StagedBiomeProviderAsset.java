package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.array.ArrayCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.StagedBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.ArrayList;
import java.util.List;

public class StagedBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<StagedBiomeProviderAsset> CODEC = BuilderCodec.builder(
            StagedBiomeProviderAsset.class,
            StagedBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Inputs", new ArrayCodec<>(BiomeProviderAsset.CODEC, BiomeProviderAsset[]::new), true),
                    (asset, field) -> asset.inputAssets = field,
                    asset -> asset.inputAssets
            )
            .add()
            .append(
                    new KeyedCodec<>("PreviousLabel", Codec.STRING, true),
                    (asset, field) -> asset.previousLabel = field,
                    asset -> asset.previousLabel
            )
            .add()
            .build();

    private BiomeProviderAsset[] inputAssets = new BiomeProviderAsset[0];
    private String previousLabel = "";

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;

        List<BiomeProvider> inputs = new ArrayList<>();
        for (BiomeProviderAsset inputAsset: inputAssets) {
            BiomeProvider input = inputAsset.build(argument);
            if (input == null) continue;

            inputs.add(input.makeCached());
        }

        return new StagedBiomeProvider(inputs, argument.getPreviousId(previousLabel));
    }

    @Override
    public void cleanUp() {
        for (BiomeProviderAsset input: inputAssets) {
            input.cleanUp();
        }
    }
}
