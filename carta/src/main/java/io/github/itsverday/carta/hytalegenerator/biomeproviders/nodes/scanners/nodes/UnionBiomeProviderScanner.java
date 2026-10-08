package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.nodes;

import com.hypixel.hytale.builtin.hytalegenerator.pipe.Control;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.BiomeProviderScanner;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class UnionBiomeProviderScanner extends BiomeProviderScanner {
    @Nonnull
    private final List<BiomeProviderScanner> inputs;

    @Nonnull
    private final Context rChildContext = new Context();
    private Context rContext;
    private boolean rIsStopped = false;

    public UnionBiomeProviderScanner(@Nonnull List<BiomeProviderScanner> inputs) {
        this.inputs = new ArrayList<>();
        this.inputs.addAll(inputs);
    }

    @Override
    public void generate(@NonNullDecl Context context) {
        rContext = context;
        rIsStopped = false;

        rChildContext.assign(context);
        rChildContext.pipe = this::accept;

        for (BiomeProviderScanner input: inputs) {
            input.generate(rChildContext);
            if (rIsStopped) break;
        }
    }

    private void accept(Vector3d providedOffset, Control control) {
        rContext.pipe.accept(providedOffset, control);
        rIsStopped |= control.stop;
    }
}
