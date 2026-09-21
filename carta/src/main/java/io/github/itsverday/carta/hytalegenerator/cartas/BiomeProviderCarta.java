package io.github.itsverday.carta.hytalegenerator.cartas;

import com.hypixel.hytale.builtin.hytalegenerator.workerindexer.WorkerIndexer;
import com.hypixel.hytale.builtin.hytalegenerator.worldstructure.BiCarta;
import org.joml.Vector3d;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.BiomeProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.util.List;

public class BiomeProviderCarta extends BiCarta<Integer> {
    private final BiomeProvider biomeProvider;
    private final int[] biomeRemap;

    private final Vector3d rPosition = new Vector3d();
    private final BiomeProvider.Context rContext = new BiomeProvider.Context();

    public BiomeProviderCarta(BiomeProvider biomeProvider, int[] biomeRemap) {
        this.biomeProvider = biomeProvider;
        this.biomeRemap = biomeRemap;
    }

    @Override
    public Integer apply(int x, int z, @NonNullDecl WorkerIndexer.Id id) {
        rPosition.set(x, 0, z);
        rContext.assign(rPosition, null, id);
        return biomeRemap[biomeProvider.process(rContext)];
    }

    @Override
    public List<Integer> allPossibleValues() {
        return biomeProvider.allPossibleValues();
    }
}
