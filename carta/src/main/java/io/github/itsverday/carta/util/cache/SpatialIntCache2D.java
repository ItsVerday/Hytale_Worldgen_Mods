package io.github.itsverday.carta.util.cache;

import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class SpatialIntCache2D {
    private final int[] values;
    private final double[] realPositions;

    private final int bitsXZ;
    private final int maskXZ;

    public SpatialIntCache2D(int bitsXZ) {
        this.bitsXZ = bitsXZ;
        int sizeXZ = 1 << bitsXZ;
        int size = sizeXZ * sizeXZ;

        maskXZ = ((1 << bitsXZ) - 1);

        values = new int[size];
        realPositions = new double[size * 2];

        // Make cell at (0, 0, 0) need recomputing since realX, realY, realZ for that cell are all initialized to 0.
        int badKey = computeKey(0, 0);
        realPositions[indexX(badKey)] = 1;
    }

    private int computeKey(double x, double z) {
        int xInt = (int) x;
        int zInt = (int) z;
        return (xInt & maskXZ) | ((zInt & maskXZ) << bitsXZ);
    }

    public void put(double x, double z, int value) {
        int key = computeKey(x, z);
        values[key] = value;
        realPositions[indexX(key)] = x;
        realPositions[indexZ(key)] = z;
    }

    public boolean getAndConsume(double x, double z, IntConsumer consumer) {
        int key = computeKey(x, z);
        if (realPositions[indexX(key)] != x) return false;
        if (realPositions[indexZ(key)] != z) return false;
        consumer.accept(values[key]);
        return true;
    }

    public int getOrCompute(double x, double z, IntSupplier supplier) {
        int key = computeKey(x, z);
        if (realPositions[indexX(key)] != x) return computeAndPut(x, z, key, supplier);
        if (realPositions[indexZ(key)] != z) return computeAndPut(x, z, key, supplier);
        return values[key];
    }

    private int computeAndPut(double x, double z, int key, IntSupplier supplier) {
        int value = supplier.getAsInt();
        values[key] = value;
        realPositions[indexX(key)] = x;
        realPositions[indexZ(key)] = z;
        return value;
    }

    private static int indexX(int i) {
        return i * 2;
    }

    private static int indexZ(int i) {
        return i * 2 + 1;
    }
}