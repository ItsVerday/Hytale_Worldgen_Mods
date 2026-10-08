package io.github.itsverday.carta.hytalegenerator.assets.biomeproviderconditions;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviderconditions.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviderconditions.ConstantBiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviderconditions.OffsetBiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

public class OffsetBiomeProviderConditionAsset extends BiomeProviderConditionAsset {
    public static final BuilderCodec<OffsetBiomeProviderConditionAsset> CODEC = BuilderCodec.builder(
            OffsetBiomeProviderConditionAsset.class,
            OffsetBiomeProviderConditionAsset::new,
            BiomeProviderConditionAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderConditionAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("OffsetX", Codec.DOUBLE, true),
                    (asset, field) -> asset.offsetX = field,
                    asset -> asset.offsetX
            )
            .add()
            .append(
                    new KeyedCodec<>("OffsetZ", Codec.DOUBLE, true),
                    (asset, field) -> asset.offsetZ = field,
                    asset -> asset.offsetZ
            )
            .add()
            .build();

    private BiomeProviderConditionAsset inputAsset = null;
    private double offsetX = 0;
    private double offsetZ = 0;

    @Override
    public BiomeProviderCondition build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (inputAsset == null) return new ConstantBiomeProviderCondition(false);

        return new OffsetBiomeProviderCondition(inputAsset.build(argument), new Vector3d(offsetX, 0, offsetZ));
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
    }
}
