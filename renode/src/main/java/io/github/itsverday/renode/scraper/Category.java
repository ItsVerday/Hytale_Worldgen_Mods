package io.github.itsverday.renode.scraper;

import io.github.itsverday.renode.scraper.codegen.CodeGenerator;
import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.node.Node;

import java.util.HashMap;

public class Category implements Identified, CodeGenerator {
    private final String name;
    private final HashMap<String, Integer> colorCounts = new HashMap<>();
    private String color;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNode(Node node) {
        node.addCategory(this);

        if (!colorCounts.containsKey(node.getColor())) colorCounts.put(node.getColor(), 0);
        colorCounts.put(node.getColor(), colorCounts.get(node.getColor()) + 1);
        color = null;
    }

    public String getColor() {
        if (color == null) {
            for (String colorKey: colorCounts.keySet()) {
                if (color == null || colorCounts.get(colorKey) > colorCounts.get(color)) {
                    color = colorKey;
                }
            }
        }

        return color;
    }

    @Override
    public String getIdentifier() {
        return Utils.fixIdentifier(name, "CATEGORY_");
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder initStringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(initStringBuilder, "Renode.category", getName(), getColor());

        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "addCategory", initStringBuilder);
        return stringBuilder;
    }
}
