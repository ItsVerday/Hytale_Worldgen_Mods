package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.positions;

import com.hypixel.hytale.builtin.hytalegenerator.assets.curves.CurveAsset;
import com.hypixel.hytale.builtin.hytalegenerator.assets.positionproviders.PositionProviderAsset;
import com.hypixel.hytale.builtin.hytalegenerator.positionproviders.PositionProvider;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.validation.Validators;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.positions.PositionsTwist2DBiomeProvider;
import it.unimi.dsi.fastutil.doubles.Double2DoubleFunction;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class PositionsTwistBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<PositionsTwistBiomeProviderAsset> CODEC = BuilderCodec.builder(
            PositionsTwistBiomeProviderAsset.class,
            PositionsTwistBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Positions", PositionProviderAsset.CODEC, false),
                    (asset, field) -> asset.positionsAsset = field,
                    asset -> asset.positionsAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("TwistCurve", CurveAsset.CODEC, false),
                    (asset, field) -> asset.twistCurveAsset = field,
                    asset -> asset.twistCurveAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("MaxDistance", Codec.DOUBLE, true),
                    (asset, field) -> asset.maxDistance = field,
                    asset -> asset.maxDistance
            )
            .addValidator(Validators.greaterThanOrEqual(0.0))
            .add()
            .append(
                    new KeyedCodec<>("NormalizeDistance", Codec.BOOLEAN, true),
                    (asset, field) -> asset.normalizeDistance = field,
                    asset -> asset.normalizeDistance
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
    private PositionProviderAsset positionsAsset = null;
    private CurveAsset twistCurveAsset = null;
    private double maxDistance;
    private boolean normalizeDistance;
    private boolean rounding;

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;
        if (positionsAsset == null) return null;
        if (twistCurveAsset == null) return null;

        PositionProvider positions = positionsAsset.build(new PositionProviderAsset.Argument(argument.parentSeed, argument.referenceBundle, argument.workerId));
        Double2DoubleFunction twistCurve = twistCurveAsset.build();
        BiomeProvider input = BiomeProviderAsset.buildStatic(inputAsset, argument, PreviousBiomeProvider::new, rounding);

        return new PositionsTwist2DBiomeProvider(input, positions, twistCurve, maxDistance, normalizeDistance, rounding);
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
        if (positionsAsset != null) positionsAsset.cleanUp();
        if (twistCurveAsset != null) twistCurveAsset.cleanUp();
    }
}
