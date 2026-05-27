package io.github.itsverday.renode.builder.output;

import io.github.itsverday.renode.builder.NodeBuilder;
import io.github.itsverday.renode.builder.NodeVariantClass;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class VariantNodeOutput extends AbstractNodeOutput {
    private final String id;
    private final String label;
    private final boolean multiple;
    private final Supplier<NodeVariantClass> variant;

    public VariantNodeOutput(String id, String label, boolean multiple, Supplier<NodeVariantClass> variant) {
        this.id = id;
        this.label = label;
        this.multiple = multiple;
        this.variant = variant;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return "Connections.Variant." + variant.get().getName();
    }

    @Override
    public String getColor() {
        return variant.get().getColor();
    }

    @Override
    public String getNode() {
        return "Variants." + variant.get().getName();
    }

    @Override
    public String getLabel() {
        return label;
    }

    @NullableDecl
    @Override
    public Boolean getMultiple() {
        return multiple;
    }

    @NullableDecl
    @Override
    public Boolean getIsMap() {
        return false;
    }

    @Override
    public List<NodeBuilder> getPossibleChildren() {
        return new ArrayList<>(variant.get().getVariantTypes().values());
    }

    @Override
    public void ensureNodeInputs() {}
}
