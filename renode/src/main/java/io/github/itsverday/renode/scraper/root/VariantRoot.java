package io.github.itsverday.renode.scraper.root;

import io.github.itsverday.renode.scraper.Variant;
import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;

public class VariantRoot extends Root {
    private final Variant variant;

    public VariantRoot(String menuName, Variant variant) {
        super(menuName);
        this.variant = variant;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder initStringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(initStringBuilder, "Renode.root", variant, getMenuName());

        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "addRoot", initStringBuilder);
        return stringBuilder;
    }
}
