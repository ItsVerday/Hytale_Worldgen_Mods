package io.github.itsverday.carta.util.cache;

import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class SpatialIntCache3D {
    private final int[] values;
    private final double[] realPositions;

    private final int bitsXZ;
    private final int maskXZ;
    private final int maskY;

    public SpatialIntCache3D(int bitsXZ, int bitsY) {
        this.bitsXZ = bitsXZ;
        int sizeXZ = 1 << bitsXZ;
        int sizeY = 1 << bitsY;
        int size = sizeXZ * sizeXZ * sizeY;

        maskXZ = ((1 << bitsXZ) - 1);
        maskY = ((1 << bitsY) - 1);

        values = new int[size];
        realPositions = new double[size * 3];

        // Make cell at (0, 0, 0) need recomputing since realX, realY, realZ for that cell are all initialized to 0.
        int badKey = computeKey(0, 0, 0);
        realPositions[indexX(badKey)] = 1;
    }

    private int computeKey(double x, double y, double z) {
        int xInt = (int) x;
        int zInt = (int) z;
        if (maskY == 0) return (xInt & maskXZ) | ((zInt & maskXZ) << bitsXZ);

        int yInt = (int) y;
        return (xInt & maskXZ) | ((yInt & maskY) << (bitsXZ * 2)) | ((zInt & maskXZ) << bitsXZ);
    }

    public void put(double x, double y, double z, int value) {
        int key = computeKey(x, y, z);
        values[key] = value;
        realPositions[indexX(key)] = x;
        realPositions[indexY(key)] = y;
        realPositions[indexZ(key)] = z;
    }

    public boolean getAndConsume(double x, double y, double z, IntConsumer consumer) {
        int key = computeKey(x, y, z);
        if (realPositions[indexX(key)] != x) return false;
        if (realPositions[indexZ(key)] != z) return false;
        if (realPositions[indexY(key)] != y) return false;
        consumer.accept(values[key]);
        return true;
    }

    public int getOrCompute(double x, double y, double z, IntSupplier supplier) {
        int key = computeKey(x, y, z);
        if (realPositions[indexX(key)] != x) return computeAndPut(x, y, z, key, supplier);
        if (realPositions[indexZ(key)] != z) return computeAndPut(x, y, z, key, supplier);
        if (realPositions[indexY(key)] != y) return computeAndPut(x, y, z, key, supplier);
        return values[key];
    }

    private int computeAndPut(double x, double y, double z, int key, IntSupplier supplier) {
        int value = supplier.getAsInt();
        values[key] = value;
        realPositions[indexX(key)] = x;
        realPositions[indexY(key)] = y;
        realPositions[indexZ(key)] = z;
        return value;
    }

    private static int indexX(int i) {
        return i * 3;
    }

    private static int indexY(int i) {
        return i * 3 + 1;
    }

    private static int indexZ(int i) {
        return i * 3 + 2;
    }
}