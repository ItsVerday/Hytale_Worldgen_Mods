package io.github.itsverday.renode.scraper.node.init;

import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.node.Node;

public class DefaultNodeInit extends NodeInit {
    public DefaultNodeInit(Node node) {
        super(node);
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "Renode.node", getNode().getId(), getNode().getTitle());
        return stringBuilder;
    }
}
