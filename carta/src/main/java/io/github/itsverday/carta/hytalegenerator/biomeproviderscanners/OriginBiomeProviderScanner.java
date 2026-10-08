package io.github.itsverday.carta.hytalegenerator.biomeproviderscanners;

import org.joml.Vector3d;

import java.util.List;

public class OriginBiomeProviderScanner extends SimpleBiomeProviderScanner {
    private static final List<Vector3d> OFFSETS = List.of(new Vector3d(0, 0, 0));

    public OriginBiomeProviderScanner() {
        super(OFFSETS);
    }
}
