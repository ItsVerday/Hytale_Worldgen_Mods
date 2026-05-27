package io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.nodes;

import com.hypixel.hytale.assetstore.AssetExtraInfo;
import com.hypixel.hytale.assetstore.AssetPack;
import com.hypixel.hytale.assetstore.codec.AssetBuilderCodec;
import com.hypixel.hytale.assetstore.map.DefaultAssetMap;
import com.hypixel.hytale.assetstore.map.JsonAssetWithMap;
import com.hypixel.hytale.builtin.hytalegenerator.assets.Cleanable;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.EnumCodec;
import com.hypixel.hytale.codec.codecs.array.ArrayCodec;
import com.hypixel.hytale.common.util.PathUtil;
import com.hypixel.hytale.protocol.Color;
import com.hypixel.hytale.server.core.asset.AssetModule;
import com.hypixel.hytale.server.core.asset.type.blocktype.config.Rotation;
import com.hypixel.hytale.server.core.asset.util.ColorParseUtil;
import com.hypixel.hytale.server.core.codec.ProtocolCodecs;
import io.github.itsverday.carta.CartaPlugin;
import io.github.itsverday.carta.hytalegenerator.assets.biomeproviders.BiomeProviderAsset;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.ImageMap2DBiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.PreviousBiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.joml.Vector3d;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ImageMapBiomeProviderAsset extends BiomeProviderAsset {
    public static final BuilderCodec<ImageMapBiomeProviderAsset> CODEC = BuilderCodec.builder(
                    ImageMapBiomeProviderAsset.class,
                    ImageMapBiomeProviderAsset::new,
                    BiomeProviderAsset.ABSTRACT_CODEC
            )
            .append(
                    new KeyedCodec<>("Path", Codec.STRING, true),
                    (asset, field) -> asset.path = field,
                    asset -> asset.path
            )
            .add()
            .append(
                    new KeyedCodec<>("Fallback", BiomeProviderAsset.CODEC, false),
                    (asset, field) -> asset.fallbackAsset = field,
                    asset -> asset.fallbackAsset
            )
            .add()
            .append(
                    new KeyedCodec<>("Biomes", new ArrayCodec<>(ImageMapBiomeAsset.CODEC, ImageMapBiomeAsset[]::new), true),
                    (asset, field) -> asset.biomeAssets = field,
                    asset -> asset.biomeAssets
            )
            .add()
            .append(
                    new KeyedCodec<>("CenterX", Codec.DOUBLE, true),
                    (asset, field) -> asset.centerX = field,
                    asset -> asset.centerX
            )
            .add()
            .append(
                    new KeyedCodec<>("CenterZ", Codec.DOUBLE, true),
                    (asset, field) -> asset.centerZ = field,
                    asset -> asset.centerZ
            )
            .add()
            .append(
                    new KeyedCodec<>("Scale", Codec.DOUBLE, true),
                    (asset, field) -> asset.scale = field,
                    asset -> asset.scale
            )
            .add()
            .append(
                    new KeyedCodec<>("Rotation", Rotation.CODEC, true),
                    (asset, field) -> asset.rotation = field,
                    asset -> asset.rotation
            )
            .add()
            .append(
                    new KeyedCodec<>("Flip", Codec.BOOLEAN, true),
                    (asset, field) -> asset.flip = field,
                    asset -> asset.flip
            )
            .add()
            .append(
                    new KeyedCodec<>("EdgeType", new EnumCodec<>(ImageMap2DBiomeProvider.EdgeType.class), true),
                    (asset, field) -> asset.edgeType = field,
                    asset -> asset.edgeType
            )
            .add()
            .build();

    private String path;
    private BiomeProviderAsset fallbackAsset = null;
    private ImageMapBiomeAsset[] biomeAssets = new ImageMapBiomeAsset[0];
    private double centerX = 0.0;
    private double centerZ = 0.0;
    private double scale = 1.0;
    private Rotation rotation = Rotation.None;
    private boolean flip = false;
    private ImageMap2DBiomeProvider.EdgeType edgeType = ImageMap2DBiomeProvider.EdgeType.Exclude;

    @NullableDecl
    @Override

    public BiomeProvider build(@NonNullDecl Argument argument) {
        try {
            if (path == null) return new PreviousBiomeProvider();

            Path filePath = resolvePath(path);
            if (filePath == null) {
                CartaPlugin.LOGGER.atWarning().log("BiomeMap Image with path '%s' does not exist!", path);
                return new PreviousBiomeProvider();
            }

            BufferedImage image = ImageIO.read(Files.newInputStream(filePath));
            byte[] biomeIndices = new byte[image.getWidth() * image.getHeight()];

            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int biomeIndex = x + y * image.getWidth();
                    int pixelARGB = image.getRGB(x, y);
                    boolean found = false;
                    for (int i = 0; i < biomeAssets.length; i++) {
                        ImageMapBiomeAsset biomeAsset = biomeAssets[i];
                        int biomeARGB = biomeAsset.color;
                        if (colorDistanceSquared(pixelARGB, biomeARGB) <= biomeAsset.tolerance * biomeAsset.tolerance) {
                            biomeIndices[biomeIndex] = (byte) i;
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        biomeIndices[biomeIndex] = -1;
                    }
                }
            }

            List<BiomeProvider> biomeTable = new ArrayList<>();
            for (ImageMapBiomeAsset biomeAsset : biomeAssets) {
                biomeTable.add(BiomeProviderAsset.buildStatic(biomeAsset.input, argument, PreviousBiomeProvider::new, false));
            }

            BiomeProvider fallback = BiomeProviderAsset.buildStatic(fallbackAsset, argument, PreviousBiomeProvider::new, false);
            return new ImageMap2DBiomeProvider(fallback, biomeTable, biomeIndices, image.getWidth(), new Vector3d(centerX, 0, centerZ), scale, rotation, flip, edgeType);
        } catch (Exception e) {
            CartaPlugin.LOGGER.atWarning().withCause(e).log("Could not load image for ImageMapBiomeProviderAsset!");
            return new PreviousBiomeProvider();
        }
    }

    private Path resolvePath(String path) {
        for (AssetPack assetPack : AssetModule.get().getAssetPacks()) {
            Path packRootPath = assetPack.getRoot();
            Path imagesDir = packRootPath.resolve("Server").resolve("HytaleGenerator").resolve("Images");
            Path fullPath = PathUtil.resolvePathWithinDir(imagesDir, path);
            if (fullPath != null && Files.exists(fullPath)) {
                return fullPath;
            }
        }

        return null;
    }

    private int colorDistanceSquared(int color1, int color2) {
        int r1 = (color1 >> 16) & 0xFF;
        int g1 = (color1 >> 8) & 0xFF;
        int b1 = (color1) & 0xFF;
        int r2 = (color2 >> 16) & 0xFF;
        int g2 = (color2 >> 8) & 0xFF;
        int b2 = (color2) & 0xFF;

        int rd = r1 - r2;
        int gd = g1 - g2;
        int bd = b1 - b2;
        return rd * rd + gd * gd + bd * bd;
    }

    @Override
    public void cleanUp() {
        for (ImageMapBiomeAsset biomeAsset : biomeAssets) {
            biomeAsset.cleanUp();
        }
    }

    public static class ImageMapBiomeAsset implements Cleanable, JsonAssetWithMap<String, DefaultAssetMap<String, ImageMapBiomeAsset>> {
        public static final AssetBuilderCodec<String, ImageMapBiomeAsset> CODEC = AssetBuilderCodec.builder(
                        ImageMapBiomeAsset.class,
                        ImageMapBiomeAsset::new,
                        Codec.STRING,
                        (asset, field) -> asset.id = field,
                        asset -> asset.id,
                        (asset, field) -> asset.data = field,
                        asset -> asset.data
                )
                .append(
                        new KeyedCodec<>("Color", ProtocolCodecs.COLOR, true),
                        (asset, field) -> asset.color = ColorParseUtil.colorToARGBInt(field),
                        asset -> new Color()
                )
                .add()
                .append(
                        new KeyedCodec<>("Tolerance", Codec.DOUBLE, true),
                        (asset, field) -> asset.tolerance = field,
                        asset -> asset.tolerance
                )
                .add()
                .append(
                        new KeyedCodec<>("Input", BiomeProviderAsset.CODEC, false),
                        (asset, field) -> asset.input = field,
                        asset -> asset.input
                )
                .add()
                .build();

        private String id;
        private AssetExtraInfo.Data data;
        private int color = ColorParseUtil.colorToARGBInt(ColorParseUtil.hexStringToColor("#000000"));
        private double tolerance = 0.0;
        private BiomeProviderAsset input = null;

        @Override
        public String getId() {
            return id;
        }

        @Override
        public void cleanUp() {
            if (input != null) input.cleanUp();
        }
    }
}
