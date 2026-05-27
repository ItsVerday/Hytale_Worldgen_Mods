package io.github.itsverday.renode.scraper.root;

import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.node.Node;

public class SingleNodeRoot extends Root {
    private final Node node;

    public SingleNodeRoot(String menuName, Node node) {
        super(menuName);
        this.node = node;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder initStringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(initStringBuilder, "Renode.root", node, getMenuName());

        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "addRoot", initStringBuilder);
        return stringBuilder;
    }
}
