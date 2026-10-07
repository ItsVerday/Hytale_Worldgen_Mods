package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.nodes;

import org.joml.Vector3d;

import java.util.List;

public class Adjacent2DBiomeProviderScanner extends SimpleBiomeProviderScanner {
    private static final List<Vector3d> OFFSETS = List.of(
            new Vector3d(-1, 0, 0),
            new Vector3d(1, 0, 0),
            new Vector3d(0, 0, -1),
            new Vector3d(0, 0, 1)
    );

    public Adjacent2DBiomeProviderScanner() {
        super(OFFSETS);
    }
}
