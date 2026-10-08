package io.github.itsverday.carta.hytalegenerator.biomeproviderscanners;

import com.hypixel.hytale.builtin.hytalegenerator.pipe.Control;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class SimpleBiomeProviderScanner extends BiomeProviderScanner {
    @Nonnull
    private final List<Vector3d> offsets;

    @Nonnull
    private final Control rControl = new Control();

    public SimpleBiomeProviderScanner(@Nonnull List<Vector3d> offsets) {
        this.offsets = offsets;
    }

    @Override
    public void generate(@NonNullDecl Context context) {
        rControl.reset();

        for (Vector3d offset: offsets) {
            if (rControl.stop) return;

            context.pipe.accept(offset, rControl);
        }
    }
}
