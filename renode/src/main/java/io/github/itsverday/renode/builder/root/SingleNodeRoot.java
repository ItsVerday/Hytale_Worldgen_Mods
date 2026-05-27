package io.github.itsverday.renode.builder.root;

import io.github.itsverday.renode.builder.NodeBuilder;

import java.util.List;

public class SingleNodeRoot extends AbstractNodeRoot {
    private final NodeBuilder node;

    public SingleNodeRoot(NodeBuilder node, String name) {
        super(name);
        this.node = node;
    }

    @Override
    public String getRootNodeType() {
        return node.getId();
    }

    @Override
    public List<NodeBuilder> getPossibleNodes() {
        return List.of(node);
    }
}
