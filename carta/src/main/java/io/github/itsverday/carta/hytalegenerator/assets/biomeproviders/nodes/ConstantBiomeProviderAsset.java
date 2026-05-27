package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes;

import com.hypixel.hytale.builtin.hytalegenerator.assets.material.MaterialAsset;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.ConstantBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ConstantBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<ConstantBiomeProviderAsset> CODEC = BuilderCodec.builder(
            ConstantBiomeProviderAsset.class,
            ConstantBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Biome", Codec.STRING, true),
                    (asset, field) -> asset.biome = field,
                    asset -> asset.biome
            )
            .add()
            .append(
                    new KeyedCodec<>("DebugMaterial", MaterialAsset.CODEC, true),
                    (asset, field) -> asset.debugMaterialAsset = field,
                    asset -> asset.debugMaterialAsset
            )
            .add()
            .build();

    private String biome;
    private MaterialAsset debugMaterialAsset = null;

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;

        return new ConstantBiomeProvider(argument.getBiomeId(biome, debugMaterialAsset != null ? debugMaterialAsset.build(argument.materialCache) : null));
    }
}
