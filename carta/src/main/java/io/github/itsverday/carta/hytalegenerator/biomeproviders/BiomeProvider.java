package io.github.itsverday.carta.hytalegenerator.biomeproviders;

import com.hypixel.hytale.builtin.hytalegenerator.workerindexer.WorkerIndexer;
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

        public Context() {
            this(new Vector3d(), null, null);
        }

        public Context(Vector3d position, Vector3d anchor, WorkerIndexer.Id workerId) {
            this.position = position;
            this.anchor = anchor;
            this.workerId = workerId;
        }

        public void assign(Context context) {
            this.position = context.position;
            this.anchor = context.anchor;
            this.workerId = context.workerId;
        }

        public void assign(Vector3d position, Vector3d anchor, WorkerIndexer.Id workerId) {
            this.position = position;
            this.anchor = anchor;
            this.workerId = workerId;
        }
    }
}
