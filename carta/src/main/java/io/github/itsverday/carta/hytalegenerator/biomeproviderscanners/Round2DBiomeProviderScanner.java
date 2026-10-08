package io.github.itsverday.carta.hytalegenerator.biomeproviderscanners;

import com.hypixel.hytale.builtin.hytalegenerator.pipe.Control;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector2i;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Round2DBiomeProviderScanner extends BiomeProviderScanner {
    @Nonnull
    private final byte[] sortedPositions;
    private final int positionsCount;

    @Nonnull
    private final Vector3d rOffset = new Vector3d();
    @Nonnull
    private final Control rControl = new Control();

    public Round2DBiomeProviderScanner(double radius) {
        int radiusInt = (int) Math.ceil(radius);
        List<Vector2i> sortedPositionVectors = new ArrayList<>();
        for (Vector2i position = new Vector2i(-radiusInt, -radiusInt); position.x <= radiusInt; position.x++) {
            for (position.y = -radiusInt; position.y <= radiusInt; position.y++) {
                if (position.length() > radius) continue;
                sortedPositionVectors.add(new Vector2i(position));
            }
        }

        sortedPositionVectors.sort(Comparator.comparingDouble(Vector2i::length));
        positionsCount = sortedPositionVectors.size();
        sortedPositions = new byte[positionsCount * 2];

        for (int i = 0; i < positionsCount; i++) {
            Vector2i position = sortedPositionVectors.get(i);
            sortedPositions[indexX(i)] = (byte) position.x;
            sortedPositions[indexZ(i)] = (byte) position.y;
        }
    }

    @Override
    public void generate(@NonNullDecl Context context) {
        rControl.reset();

        for (int i = 0; i < positionsCount; i++) {
            if (rControl.stop) return;

            int x = sortedPositions[indexX(i)];
            int z = sortedPositions[indexZ(i)];
            rOffset.set(x, 0, z);
            context.pipe.accept(rOffset, rControl);
        }
    }

    private static int indexX(int i) {
        return i * 2;
    }

    private static int indexZ(int i) {
        return i * 2 + 1;
    }
}
