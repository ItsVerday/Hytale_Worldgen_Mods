package io.github.itsverday.carta.hytalegenerator.biomeproviders;

import com.hypixel.hytale.builtin.hytalegenerator.pipe.Control;
import io.github.itsverday.carta.hytalegenerator.biomeproviderscanners.BiomeProviderScanner;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class SmoothedBiomeProvider extends BiomeProvider {
    @Nonnull
    private final BiomeProvider input;
    @Nonnull
    private final BiomeProvider fallback;
    @Nonnull
    private final BiomeProviderScanner scanner;
    private final double threshold;

    private final Int2IntOpenHashMap rCounts = new Int2IntOpenHashMap();
    private final Vector3d rPosition = new Vector3d();
    private final Context rChildContext = new Context();
    private final BiomeProviderScanner.Context rBiomeScannerContext = new BiomeProviderScanner.Context();

    private int rHighestCount = 0;
    private int rTotalCount = 0;
    private Context rContext;

    public SmoothedBiomeProvider(@Nonnull BiomeProvider input, @Nonnull BiomeProvider fallback, @Nonnull BiomeProviderScanner scanner, double threshold) {
        this.input = input;
        this.fallback = fallback;
        this.scanner = scanner;
        this.threshold = threshold;

        rCounts.defaultReturnValue(0);
    }

    @Override
    public int process(@NonNullDecl Context context) {
        rHighestCount = 0;
        rTotalCount = 0;
        rCounts.clear();
        rContext = context;
        rChildContext.assign(context);
        rChildContext.position = rPosition;

        rBiomeScannerContext.origin.set(context.position);
        rBiomeScannerContext.pipe = this::processOffset;
        scanner.generate(rBiomeScannerContext);

        double totalThreshold = rTotalCount * threshold;
        for (int value: rCounts.keySet()) {
            int count = rCounts.get(value);
            if (count == rHighestCount) {
                if (count >= totalThreshold) return value;
                break;
            }
        }

        return fallback.process(context);
    }

    private void processOffset(@NonNullDecl Vector3d offset, @NonNullDecl Control control) {
        rPosition.set(rContext.position.x + offset.x, rContext.position.y + offset.y, rContext.position.z + offset.z);
        int value = input.process(rChildContext);
        int currentCount = rCounts.get(value) + 1;

        rCounts.put(value, currentCount);
        rHighestCount = Math.max(rHighestCount, currentCount);
        rTotalCount++;
    }

    @Override
    public List<Integer> allPossibleValues() {
        ArrayList<Integer> values = new ArrayList<>();

        for (Integer value: input.allPossibleValues()) {
            if (!values.contains(value)) {
                values.add(value);
            }
        }

        for (Integer value: fallback.allPossibleValues()) {
            if (!values.contains(value)) {
                values.add(value);
            }
        }

        return values;
    }
}
