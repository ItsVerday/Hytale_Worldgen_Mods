package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes;

import com.hypixel.hytale.builtin.hytalegenerator.assets.density.DensityAsset;
import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.VectorWarpBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.joml.Vector3d;

public class VectorWarpBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<VectorWarpBiomeProviderAsset> CODEC = BuilderCodec.builder(
            VectorWarpBiomeProviderAsset.class,
            VectorWarpBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Density", DensityAsset.CODEC, false),
                    (asset, field) -> asset.densityAsset = field,
                    asset -> asset.densityAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("WarpVectorX", Codec.DOUBLE, true),
                    (asset, field) -> asset.warpVectorX = field,
                    asset -> asset.warpVectorX
            )
            .add()
            .append(
                    new KeyedCodec<>("WarpVectorZ", Codec.DOUBLE, true),
                    (asset, field) -> asset.warpVectorZ = field,
                    asset -> asset.warpVectorZ
            )
            .add()
            .append(
                    new KeyedCodec<>("Rounding", Codec.BOOLEAN, true),
                    (asset, field) -> asset.rounding = field,
                    asset -> asset.rounding
            )
            .add()
            .build();

    private BiomeProviderAsset inputAsset = null;
    private DensityAsset densityAsset = null;
    private double warpVectorX = 0;
    private double warpVectorZ = 0;
    private boolean rounding = false;

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;
        if (densityAsset == null) return null;
        if (warpVectorX == 0 && warpVectorZ == 0) return null;

        Density density = densityAsset.build(new DensityAsset.Argument(new DensityAsset.Argument(argument.parentSeed, argument.referenceBundle, argument.workerId)));
        BiomeProvider input = BiomeProviderAsset.buildStatic(inputAsset, argument, PreviousBiomeProvider::new, rounding);
        Vector3d warpVector = new Vector3d(warpVectorX, 0, warpVectorZ);

        return new VectorWarpBiomeProvider(input, density, warpVector, rounding);
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
        if (densityAsset != null) densityAsset.cleanUp();
    }
}
