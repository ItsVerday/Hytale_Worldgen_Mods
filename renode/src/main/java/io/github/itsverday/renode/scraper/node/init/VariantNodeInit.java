package io.github.itsverday.renode.scraper.node.init;

import io.github.itsverday.renode.scraper.Variant;
import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.node.Node;

public class VariantNodeInit extends NodeInit {
    private final Variant variant;
    private final String variantName;

    public VariantNodeInit(Node node, Variant variant, String variantName) {
        super(node);
        this.variant = variant;
        this.variantName = variantName;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeIdentifier(stringBuilder, variant);
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, ".variantNode", variantName, getNode().getId(), getNode().getTitle());
        return stringBuilder;
    }
}
