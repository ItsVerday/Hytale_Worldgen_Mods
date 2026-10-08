package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.array.ArrayCodec;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
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

        String previousLabelNullable = previousLabel;
        if (previousLabelNullable.isEmpty()) previousLabelNullable = null;

        BiomeProvider previousInput = null;

        List<BiomeProvider> inputs = new ArrayList<>();
        for (BiomeProviderAsset inputAsset: inputAssets) {
            if (previousInput != null) argument.pushStageLabel(previousLabelNullable, previousInput);

            BiomeProvider input = inputAsset.build(argument);
            if (previousInput != null) argument.popStageLabel();
            if (input == null) continue;

            previousInput = input.makeCached();
        }

        return previousInput;
    }

    @Override
    public void cleanUp() {
        for (BiomeProviderAsset input: inputAssets) {
            input.cleanUp();
        }
    }
}
