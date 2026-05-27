package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes;

import com.hypixel.hytale.builtin.hytalegenerator.assets.density.DensityAsset;
import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import com.hypixel.hytale.builtin.hytalegenerator.density.nodes.MultiCacheDensity;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.validation.Validators;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.GradientWarp2DBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class GradientWarpBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<GradientWarpBiomeProviderAsset> CODEC = BuilderCodec.builder(
            GradientWarpBiomeProviderAsset.class,
            GradientWarpBiomeProviderAsset::new,
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
                    new KeyedCodec<>("SampleDistance", Codec.DOUBLE, true),
                    (asset, field) -> asset.sampleDistance = field,
                    asset -> asset.sampleDistance
            )
            .addValidator(Validators.greaterThanOrEqual(0.0))
            .add()
            .append(
                    new KeyedCodec<>("WarpFactor", Codec.DOUBLE, true),
                    (asset, field) -> asset.warpFactor = field,
                    asset -> asset.warpFactor
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
    private double sampleDistance = 1.0;
    private double warpFactor = 1.0;
    private boolean rounding = false;

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;
        if (densityAsset == null) return null;
        if (sampleDistance == 0) return null;
        if (warpFactor == 0) return null;

        Density density = new MultiCacheDensity(densityAsset.build(new DensityAsset.Argument(new DensityAsset.Argument(argument.parentSeed, argument.referenceBundle, argument.workerId))), 3);
        BiomeProvider input = BiomeProviderAsset.buildStatic(inputAsset, argument, PreviousBiomeProvider::new, rounding);

        return new GradientWarp2DBiomeProvider(input, density, sampleDistance, warpFactor, rounding);
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
        if (densityAsset != null) densityAsset.cleanUp();
    }
}
