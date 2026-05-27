package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.conditions;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.CartaPlugin;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes.conditional.BiomeProviderConditionAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions.ConstantBiomeProviderCondition;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class ImportedBiomeProviderConditionAsset extends BiomeProviderConditionAsset {
    public static final BuilderCodec<ImportedBiomeProviderConditionAsset> CODEC = BuilderCodec.builder(
            ImportedBiomeProviderConditionAsset.class,
            ImportedBiomeProviderConditionAsset::new,
            BiomeProviderConditionAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Name", Codec.STRING, true),
                    (asset, field) -> asset.importName = field,
                    asset -> asset.importName
            )
            .add()
            .build();

    private String importName = "";

    @Override
    public BiomeProviderCondition build(@NonNullDecl BiomeProviderAsset.Argument argument) {
        BiomeProviderConditionAsset.Exported exported = getExportedAsset(importName);
        if (exported == null) {
            CartaPlugin.LOGGER.atWarning().log("Couldn't find BiomeProviderCondition asset exported with name: '%s'.", importName);
            return new ConstantBiomeProviderCondition(false);
        }

        return exported.asset.build(argument);
    }
}
