package io.github.itsverday.renode;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class RenodeConfiguration {
    public static final BuilderCodec<RenodeConfiguration> CODEC = BuilderCodec.builder(
            RenodeConfiguration.class, RenodeConfiguration::new
    )
            .append(
                    new KeyedCodec<>("HytaleHome", Codec.STRING, false),
                    (asset, field) -> asset.hytaleHome = field,
                    asset -> asset.hytaleHome
            )
            .add()
            .build();

    private String hytaleHome = "";

    public String getHytaleHome() {
        return hytaleHome;
    }
}
