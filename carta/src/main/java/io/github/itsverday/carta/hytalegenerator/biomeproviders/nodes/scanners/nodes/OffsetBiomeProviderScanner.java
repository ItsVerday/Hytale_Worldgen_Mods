package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.nodes;

import com.hypixel.hytale.builtin.hytalegenerator.pipe.Control;
import com.hypixel.hytale.builtin.hytalegenerator.pipe.Pipe;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.BiomeProviderScanner;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;

public class OffsetBiomeProviderScanner extends BiomeProviderScanner {
    @Nonnull
    private final Vector3d offset;
    @Nonnull
    private final BiomeProviderScanner input;

    @Nonnull
    private final Context rChildContext = new Context();
    private Context rContext;

    @Nonnull
    private final Pipe.One<Vector3d> rChildPipe = new Pipe.One<Vector3d>() {
        @Override
        public void accept(@NonNullDecl Vector3d providedOffset, @NonNullDecl Control control) {
            providedOffset.add(offset);
            rContext.pipe.accept(providedOffset, control);
        }
    };

    public OffsetBiomeProviderScanner(@Nonnull Vector3d offset, @Nonnull BiomeProviderScanner input) {
        this.offset = new Vector3d(offset);
        this.input = input;
    }

    @Override
    public void generate(@NonNullDecl Context context) {
        rContext = context;

        rChildContext.assign(context);
        rChildContext.pipe = rChildPipe;

        input.generate(rChildContext);
    }
}
