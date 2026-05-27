package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions;

import com.hypixel.hytale.builtin.hytalegenerator.assets.density.DensityAsset;
import com.hypixel.hytale.builtin.hytalegenerator.assets.positionproviders.PositionProviderAsset;
import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import com.hypixel.hytale.builtin.hytalegenerator.positionproviders.PositionProvider;
import com.hypixel.hytale.builtin.hytalegenerator.rng.SeedBox;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.array.ArrayCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.PositionCellsBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.PositionCellsBiomeProviderCellType;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.ArrayList;
import java.util.List;

public class PositionCellsBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<PositionCellsBiomeProviderAsset> CODEC = BuilderCodec.builder(
            PositionCellsBiomeProviderAsset.class,
            PositionCellsBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Seed", Codec.STRING, true),
                    (asset, field) -> asset.seed = field,
                    asset -> asset.seed
            )
            .add()
            .append(
                    new KeyedCodec<>("Positions", PositionProviderAsset.CODEC, false),
                    (asset, field) -> asset.positionsAsset = field,
                    asset -> asset.positionsAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("CellTypes", new ArrayCodec<>(PositionCellsBiomeProviderCellTypeAsset.CODEC, PositionCellsBiomeProviderCellTypeAsset[]::new), true),
                    (asset, field) -> asset.cellTypeAssets = field,
                    asset -> asset.cellTypeAssets
            )
            .add()
            .append(
                    new KeyedCodec<>("DistanceWarpField", DensityAsset.CODEC, false),
                    (asset, field) -> asset.distanceWarpFieldAsset = field,
                    asset -> asset.distanceWarpFieldAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Fallback", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.fallbackAsset = field,
                    asset -> asset.fallbackAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("MaxDistance", Codec.DOUBLE, true),
                    (asset, field) -> asset.maxDistance = field,
                    asset -> asset.maxDistance
            )
            .add()
            .append(
                    new KeyedCodec<>("DistanceWarpMin", Codec.DOUBLE, true),
                    (asset, field) -> asset.distanceWarpMin = field,
                    asset -> asset.distanceWarpMin
            )
            .add()
            .append(
                    new KeyedCodec<>("DistanceWarpMax", Codec.DOUBLE, true),
                    (asset, field) -> asset.distanceWarpMax = field,
                    asset -> asset.distanceWarpMax
            )
            .add()
            .build();

    private String seed;
    private PositionProviderAsset positionsAsset = null;
    private PositionCellsBiomeProviderCellTypeAsset[] cellTypeAssets = new PositionCellsBiomeProviderCellTypeAsset[0];
    private DensityAsset distanceWarpFieldAsset = null;
    private BiomeProviderAsset fallbackAsset = null;
    private double maxDistance;
    private double distanceWarpMin;
    private double distanceWarpMax;

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;
        if (positionsAsset == null) return null;
        if (maxDistance - distanceWarpMin <= 0) return null;

        PositionProvider positions = positionsAsset.build(new PositionProviderAsset.Argument(argument.parentSeed, argument.referenceBundle, argument.workerId));
        BiomeProvider fallback = BiomeProviderAsset.buildStatic(fallbackAsset, argument, PreviousBiomeProvider::new, false);
        SeedBox childSeed = argument.parentSeed.child(seed);
        Density distanceWarpField = distanceWarpFieldAsset != null ? distanceWarpFieldAsset.build(new DensityAsset.Argument(argument.parentSeed, argument.referenceBundle, argument.workerId)) : null;
        List<PositionCellsBiomeProviderCellType> cellTypes = new ArrayList<>();
        for (PositionCellsBiomeProviderCellTypeAsset cellTypeAsset: cellTypeAssets) {
            cellTypes.add(cellTypeAsset.build(argument, fallback));
        }

        if (cellTypes.isEmpty()) return fallback;

        return new PositionCellsBiomeProvider(fallback, positions, cellTypes, childSeed.createSupplier().get(), maxDistance, distanceWarpField, distanceWarpMin, distanceWarpMax);
    }

    @Override
    public void cleanUp() {
        if (positionsAsset != null) positionsAsset.cleanUp();
        if (fallbackAsset != null) fallbackAsset.cleanUp();
        for (PositionCellsBiomeProviderCellTypeAsset cellTypeAsset: cellTypeAssets) {
            cellTypeAsset.cleanUp();
        }
    }
}
