package io.github.itsverday.renode.scraper.node.init;

import io.github.itsverday.renode.scraper.codegen.CodeGenerator;
import io.github.itsverday.renode.scraper.node.Node;

public abstract class NodeInit implements CodeGenerator {
    private final Node node;

    public NodeInit(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }
}
