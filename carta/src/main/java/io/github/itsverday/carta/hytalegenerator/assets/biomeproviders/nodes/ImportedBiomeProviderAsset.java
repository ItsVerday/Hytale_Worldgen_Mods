package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import io.github.itsverday.carta.CartaPlugin;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ImportedBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<ImportedBiomeProviderAsset> CODEC = BuilderCodec.builder(
            ImportedBiomeProviderAsset.class,
            ImportedBiomeProviderAsset::new,
            BiomeProviderAsset.ABSTRACT_CODEC
    )
            .append(
                    new KeyedCodec<>("Name", Codec.STRING, true),
                    (asset, field) -> asset.importName = field,
                    asset -> asset.importName
            )
            .add()
            .build();

    private String importName = "";

    @NullableDecl
    @Override
    public BiomeProvider build(@NonNullDecl Argument argument) {
        if (isSkipped()) return null;

        BiomeProviderAsset.Exported exported = getExportedAsset(importName);
        if (exported == null) {
            CartaPlugin.LOGGER.atWarning().log("Couldn't find BiomeProvider asset exported with name: '%s'.", importName);
            return null;
        }

        return exported.asset.build(argument);
    }
}
