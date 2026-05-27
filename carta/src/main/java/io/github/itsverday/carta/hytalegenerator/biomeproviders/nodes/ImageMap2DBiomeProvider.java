package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes;

import com.hypixel.hytale.server.core.asset.type.blocktype.config.Rotation;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ImageMap2DBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProvider fallback;
    @Nonnull
    private final List<BiomeProvider> biomeTable;
    private final byte[] biomeIndices;
    private final int width;
    private final int height;
    private final Vector3d center;
    private final double scale;
    private final Rotation rotation;
    private final boolean flip;
    private final EdgeType edgeType;

    public ImageMap2DBiomeProvider(@Nonnull BiomeProvider fallback, @Nonnull List<BiomeProvider> biomeTable, byte[] biomeIndices, int indicesWidth, Vector3d center, double scale, Rotation rotation, boolean flip, EdgeType edgeType) {
        this.fallback = fallback;
        this.biomeTable = biomeTable;
        this.biomeIndices = biomeIndices;
        this.width = indicesWidth;
        this.height = biomeIndices.length / indicesWidth;
        this.center = center;
        this.scale = scale;
        this.rotation = rotation;
        this.flip = flip;
        this.edgeType = edgeType;
    }

    @Override
    public int process(@NonNullDecl Context context) {
        double x = context.position.x;
        double y = context.position.z;

        x -= center.x;
        y -= center.z;

        switch (rotation) {
            case Ninety -> {
                double temp = x;
                x = y;
                y = -temp;
            }

            case OneEighty -> {
                x *= -1;
                y *= -1;
            }

            case TwoSeventy -> {
                double temp = x;
                x = -y;
                y = temp;
            }
        }

        x /= scale;
        y /= scale;
        if (flip) x *= -1;

        x += (double) width / 2;
        y += (double) height / 2;

        int xInt = (int) x;
        int yInt = (int) y;

        switch (edgeType) {
            case Repeat -> {
                xInt -= Math.floorDiv(xInt, width) * width;
                yInt -= Math.floorDiv(yInt, height) * height;
            }

            case Clamp -> {
                xInt = Math.clamp(xInt, 0, width - 1);
                yInt = Math.clamp(yInt, 0, height - 1);
            }

            case Exclude -> {
                if (xInt < 0 || xInt >= width) return fallback.process(context);
                if (yInt < 0 || yInt >= height) return fallback.process(context);
            }
        }

        int index = xInt + yInt * width;
        byte biomeIndex = biomeIndices[index];
        if (biomeIndex == -1) return fallback.process(context);
        return biomeTable.get(biomeIndex).process(context);
    }

    @Override
    public List<Integer> allPossibleValues() {
        ArrayList<Integer> values = new ArrayList<>();

        for (BiomeProvider biomeProvider: biomeTable) {
            for (Integer value: biomeProvider.allPossibleValues()) {
                if (!values.contains(value)) {
                    values.add(value);
                }
            }
        }

        return values;
    }

    @Override
    public boolean shouldCache() {
        return false;
    }

    public enum EdgeType {
        Exclude,
        Repeat,
        Clamp
    }
}
