package io.github.itsverday.renode.builder.output;

import io.github.itsverday.renode.builder.NodeBuilder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class NodeNodeOutput extends AbstractNodeOutput {
    private final String id;
    private final String label;
    @Nullable
    private final String description;
    private final boolean multiple;
    private final Supplier<NodeBuilder> node;

    public NodeNodeOutput(String id, String label, @Nullable String description, boolean multiple, Supplier<NodeBuilder> node) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.multiple = multiple;
        this.node = node;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return "Connections.Node." + node.get().getId();
    }

    @Override
    public String getColor() {
        return node.get().getColor();
    }

    @Nullable
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getNode() {
        return node.get().getId();
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
        return List.of(node.get());
    }

    @Override
    public void ensureNodeInputs() {
        NodeBuilder nodeBuilder = node.get();

        if (!nodeBuilder.hasSelfInput()) {
            nodeBuilder.addSelfInput();
        }
    }
}
