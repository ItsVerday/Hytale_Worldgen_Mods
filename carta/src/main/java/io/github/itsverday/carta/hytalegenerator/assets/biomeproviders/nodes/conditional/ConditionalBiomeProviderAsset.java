package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional;

import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.ConditionalBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ConditionalBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<ConditionalBiomeProviderAsset> CODEC = BuilderCodec.builder(
            ConditionalBiomeProviderAsset.class,
            ConditionalBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
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
            .append(
                    new KeyedCodec<>("IfFalse", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.ifFalseAsset = field,
                    asset -> asset.ifFalseAsset
            )
            .add()
            .build();

    private BiomeProviderConditionAsset conditionAsset = null;
    private BiomeProviderAsset ifTrueAsset = null;
    private BiomeProviderAsset ifFalseAsset = null;

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;
        if (conditionAsset == null) return null;

        BiomeProviderCondition condition = conditionAsset.build(argument);
        BiomeProvider ifTrue = BiomeProviderAsset.buildStatic(ifTrueAsset, argument, PreviousBiomeProvider::new, false);
        BiomeProvider ifFalse = BiomeProviderAsset.buildStatic(ifFalseAsset, argument, PreviousBiomeProvider::new, false);
        return new ConditionalBiomeProvider(condition, ifTrue, ifFalse);
    }

    @Override
    public void cleanUp() {
        if (conditionAsset != null) conditionAsset.cleanUp();
        if (ifTrueAsset != null) ifTrueAsset.cleanUp();
        if (ifFalseAsset != null) ifFalseAsset.cleanUp();
    }
}
