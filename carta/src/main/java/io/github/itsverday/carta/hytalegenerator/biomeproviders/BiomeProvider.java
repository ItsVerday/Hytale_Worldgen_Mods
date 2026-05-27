package io.github.itsverday.carta.hytalegenerator.biomeproviders;

import com.hypixel.hytale.builtin.hytalegenerator.workerindexer.WorkerIndexer;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.CachedBiomeProvider;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class BiomeProvider {
    public abstract int process(@Nonnull Context context);
    public abstract List<Integer> allPossibleValues();

    public boolean shouldCache() {
        return true;
    }

    public BiomeProvider makeCached() {
        if (!shouldCache()) return this;
        return new CachedBiomeProvider(this);
    }

    public int getPreviousLabel() {
        return -1;
    }

    public static class Context {
        public Vector3d position;
        public Vector3d anchor;
        public WorkerIndexer.Id workerId;
        public BiomeProvider previous;
        public Integer previousIndex;
        public Context fallback;

        public Context() {
            this(new Vector3d(), null, null, null, 0);
        }

        public Context(Vector3d position, Vector3d anchor, WorkerIndexer.Id workerId, BiomeProvider previous, int previousIndex) {
            this.position = position;
            this.anchor = anchor;
            this.workerId = workerId;
            this.previous = previous;
            this.previousIndex = previousIndex;
            this.fallback = null;
        }

        public void assign(Context context) {
            this.position = context.position;
            this.anchor = context.anchor;
            this.workerId = context.workerId;
            this.previous = context.previous;
            this.previousIndex = context.previousIndex;
            this.fallback = context.fallback;
        }

        public void assign(Vector3d position, Vector3d anchor, WorkerIndexer.Id workerId, BiomeProvider previous, int previousIndex, Context fallback) {
            this.position = position;
            this.anchor = anchor;
            this.workerId = workerId;
            this.previous = previous;
            this.previousIndex = previousIndex;
            this.fallback = fallback;
        }
    }
}
