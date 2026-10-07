package io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.scanners;

import com.hypixel.hytale.builtin.hytalegenerator.pipe.Pipe;
import org.joml.Vector3d;

import javax.annotation.Nonnull;

public abstract class BiomeProviderScanner {
    public abstract void generate(@Nonnull Context context);

    public static class Context {
        @Nonnull
        public Vector3d origin;
        @Nonnull
        public Pipe.One<Vector3d> pipe;

        public Context() {
            this.origin = new Vector3d();
            this.pipe = Pipe.getEmptyOne();
        }

        public Context(@Nonnull Vector3d origin, @Nonnull Pipe.One<Vector3d> pipe) {
            this.origin = origin;
            this.pipe = pipe;
        }

        public Context(@Nonnull Context other) {
            this.origin = other.origin;
            this.pipe = other.pipe;
        }

        public void assign(@Nonnull Context other) {
            this.origin = other.origin;
            this.pipe = other.pipe;
        }
    }
}
