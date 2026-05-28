package io.github.itsverday.renode;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class RenodeConfiguration {
    public static final BuilderCodec<RenodeConfiguration> CODEC = BuilderCodec.builder(
            RenodeConfiguration.class, RenodeConfiguration::new
    )
            .append(
                    new KeyedCodec<>("UseAssetsPath", Codec.BOOLEAN, false),
                    (config, field) -> config.useAssetsPath = field,
                    config -> config.useAssetsPath
            )
            .add()
            .append(
                    new KeyedCodec<>("HytaleHomes", Codec.STRING_ARRAY, false),
                    (config, field) -> config.hytaleHomes = field,
                    config -> config.hytaleHomes
            )
            .add()
            .build();

    private boolean useAssetsPath = true;
    private String[] hytaleHomes = new String[0];

    public boolean isUseAssetsPath() {
        return useAssetsPath;
    }

    public String[] getHytaleHomes() {
        return hytaleHomes;
    }
}
