package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.conditions;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.BiomeProviderConditionAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.ConstantBiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.ValueBiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.ValuesBiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.util.ArrayList;

public class ValuesBiomeProviderConditionAsset extends BiomeProviderConditionAsset {
    public static final BuilderCodec<ValuesBiomeProviderConditionAsset> CODEC = BuilderCodec.builder(
            ValuesBiomeProviderConditionAsset.class,
            ValuesBiomeProviderConditionAsset::new,
            BiomeProviderConditionAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Input", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.inputAsset = field,
                    asset -> asset.inputAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Biomes", Codec.STRING_ARRAY, true),
                    (asset, field) -> asset.biomes = field,
                    asset -> asset.biomes
            )
            .add()
            .build();

    private BiomeProviderAsset inputAsset = null;
    private String[] biomes = new String[0];

    @Override
    public BiomeProviderCondition build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        if (biomes.length == 0) return new ConstantBiomeProviderCondition(false);

        BiomeProvider input = BiomeProviderAsset.buildStatic(inputAsset, argument, PreviousBiomeProvider::new, false);
        ArrayList<Integer> values = new ArrayList<>();
        for (String biome: biomes) {
            if (biome.isEmpty()) continue;
            values.add(argument.getBiomeId(biome, null));
        }

        if (values.size() == 1) return new ValueBiomeProviderCondition(input, values.getFirst());

        int[] valuesArray = new int[values.size()];
        for (int i = 0; i < valuesArray.length; i++) {
            valuesArray[i] = values.get(i);
        }

        return new ValuesBiomeProviderCondition(input, valuesArray);
    }

    @Override
    public void cleanUp() {
        if (inputAsset != null) inputAsset.cleanUp();
    }
}
