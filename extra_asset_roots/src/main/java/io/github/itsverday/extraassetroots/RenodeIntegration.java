package io.github.itsverday.extraassetroots;

import io.github.itsverday.renode.builder.Renode;
import io.github.itsverday.renode.builder.root.AbstractNodeRoot;
import io.github.itsverday.renode.vanilla.HytaleGeneratorNodes;

import java.util.ArrayList;
import java.util.List;

public class RenodeIntegration {
    private static final List<AbstractNodeRoot> roots = new ArrayList<>();

    public static final AbstractNodeRoot ROOT_SCANNERS = addRoot(Renode.root(HytaleGeneratorNodes.VARIANT_SCANNERS, "HytaleGenerator - Scanner"));
    public static final AbstractNodeRoot ROOT_PATTERNS = addRoot(Renode.root(HytaleGeneratorNodes.VARIANT_PATTERNS, "HytaleGenerator - Pattern"));
    public static final AbstractNodeRoot ROOT_CURVES = addRoot(Renode.root(HytaleGeneratorNodes.VARIANT_CURVES, "HytaleGenerator - Curve"));
    public static final AbstractNodeRoot ROOT_MATERIAL_PROVIDERS = addRoot(Renode.root(HytaleGeneratorNodes.VARIANT_MATERIAL_PROVIDERS, "HytaleGenerator - MaterialProvider"));
    public static final AbstractNodeRoot ROOT_VECTOR_PROVIDERS = addRoot(Renode.root(HytaleGeneratorNodes.VARIANT_VECTOR_PROVIDERS, "HytaleGenerator - VectorProvider"));

    private static AbstractNodeRoot addRoot(AbstractNodeRoot root) {
        roots.add(root);
        return root;
    }

    public static void registerAllNodes() {
        for (AbstractNodeRoot root: roots) {
            Renode.registerRoot(root);
        }
    }
}
