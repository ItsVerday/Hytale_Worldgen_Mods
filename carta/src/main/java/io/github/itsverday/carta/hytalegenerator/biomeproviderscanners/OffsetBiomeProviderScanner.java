package io.github.itsverday.carta.hytalegenerator.biomeproviderscanners;

import com.hypixel.hytale.builtin.hytalegenerator.pipe.Control;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;

public class OffsetBiomeProviderScanner extends BiomeProviderScanner {
    @Nonnull
    private final Vector3d offset;
    @Nonnull
    private final BiomeProviderScanner input;

    @Nonnull
    private final Vector3d rOffset = new Vector3d();
    private Context rContext;
    @Nonnull
    private final Context rChildContext = new Context();

    public OffsetBiomeProviderScanner(@Nonnull Vector3d offset, @Nonnull BiomeProviderScanner input) {
        this.offset = new Vector3d(offset);
        this.input = input;
    }

    @Override
    public void generate(@NonNullDecl Context context) {
        rContext = context;

        rChildContext.assign(context);
        rChildContext.pipe = this::accept;

        input.generate(rChildContext);
    }

    private void accept(@NonNullDecl Vector3d providedOffset, @NonNullDecl Control control) {
        rOffset.set(providedOffset);
        rOffset.add(offset);
        rContext.pipe.accept(rOffset, control);
    }
}
