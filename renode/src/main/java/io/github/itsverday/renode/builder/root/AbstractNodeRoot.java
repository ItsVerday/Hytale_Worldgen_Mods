package io.github.itsverday.renode.builder.root;

import io.github.itsverday.renode.builder.NodeBuilder;

import java.util.List;

public abstract class AbstractNodeRoot {
    private final String name;

    public AbstractNodeRoot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getRootNodeType();
    public abstract List<NodeBuilder> getPossibleNodes();
}
