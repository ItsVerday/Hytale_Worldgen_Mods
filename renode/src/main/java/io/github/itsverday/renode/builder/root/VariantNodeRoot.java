package io.github.itsverday.renode.builder.root;

import io.github.itsverday.renode.builder.NodeBuilder;
import io.github.itsverday.renode.builder.NodeVariantClass;

import java.util.ArrayList;
import java.util.List;

public class VariantNodeRoot extends AbstractNodeRoot {
    private final NodeVariantClass variant;

    public VariantNodeRoot(NodeVariantClass variant, String name) {
        super(name);
        this.variant = variant;
    }

    @Override
    public String getRootNodeType() {
        return "Variants." + variant.getName();
    }

    @Override
    public List<NodeBuilder> getPossibleNodes() {
        return new ArrayList<>(variant.getVariantTypes().values());
    }
}
