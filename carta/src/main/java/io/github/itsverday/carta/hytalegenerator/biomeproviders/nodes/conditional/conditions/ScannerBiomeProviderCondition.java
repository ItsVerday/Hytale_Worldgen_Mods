package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.conditions;

import com.hypixel.hytale.builtin.hytalegenerator.pipe.Control;
import com.hypixel.hytale.builtin.hytalegenerator.pipe.Pipe;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.conditional.BiomeProviderCondition;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners.BiomeProviderScanner;
import io.github.itsverday.carta.util.cache.SpatialBooleanCache2D;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;

public class ScannerBiomeProviderCondition extends BiomeProviderCondition {
    @Nonnull
    private final BiomeProviderCondition input;
    @Nonnull
    private final BiomeProviderScanner scanner;

    private final SpatialBooleanCache2D scanCache = new SpatialBooleanCache2D(6);
    private final SpatialBooleanCache2D resultCache = new SpatialBooleanCache2D(6);

    private final Vector3d rPosition = new Vector3d();
    private final BiomeProvider.Context rBiomeProviderContext = new BiomeProvider.Context();
    private final BiomeProviderScanner.Context rBiomeScannerContext = new BiomeProviderScanner.Context();
    private final boolean[] rReturn = new boolean[1];

    private BiomeProvider.Context rContext;
    private final Pipe.One<Vector3d> rChildPipe = new Pipe.One<>() {
        @Override
        public void accept(@NonNullDecl Vector3d offset, @NonNullDecl Control control) {
            rPosition.set(rContext.position.x + offset.x, rContext.position.y + offset.y, rContext.position.z + offset.z);
            boolean scanResult = scanCache.getOrCompute(rPosition.x, rPosition.z, () -> {
                rBiomeProviderContext.assign(rContext);
                rBiomeProviderContext.position = rPosition;
                return input.process(rBiomeProviderContext);
            });

            if (scanResult) {
                rReturn[0] = true;
                control.stop = true;
            }
        }
    };

    public ScannerBiomeProviderCondition(@Nonnull BiomeProviderCondition input, @Nonnull BiomeProviderScanner scanner) {
        this.input = input;
        this.scanner = scanner;
    }

    @Override
    public boolean process(@NonNullDecl BiomeProvider.Context context) {
        rContext = context;

        double x = context.position.x;
        double z = context.position.z;

        return resultCache.getOrCompute(x, z, () -> {
            rBiomeScannerContext.origin.set(rContext.position);
            rBiomeScannerContext.pipe = rChildPipe;

            rReturn[0] = false;
            scanner.generate(rBiomeScannerContext);
            return rReturn[0];
        });
    }
}
