package io.github.itsverday.renode.scraper;

import io.github.itsverday.renode.scraper.codegen.CodeGenerator;
import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.node.Node;

import java.util.HashMap;

public class Variant implements Identified, CodeGenerator {
    private final String id;
    private final HashMap<String, Node> variants = new HashMap<>();
    private final HashMap<String, Integer> inputTypeCounts = new HashMap<>();
    private final HashMap<String, Integer> colorCounts = new HashMap<>();
    private String inputType = null;
    private String color = null;

    public Variant(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void addNode(String variantName, Node node) {
        node.setVariant(this);
        variants.put(variantName, node);
        for (String inputType: node.getInputTypes()) {
            if (!inputTypeCounts.containsKey(inputType)) inputTypeCounts.put(inputType, 0);
            inputTypeCounts.put(inputType, inputTypeCounts.get(inputType) + 1);
            this.inputType = null;
        }

        if (!colorCounts.containsKey(node.getColor())) colorCounts.put(node.getColor(), 0);
        colorCounts.put(node.getColor(), colorCounts.get(node.getColor()) + 1);
        color = null;
    }

    public String getInputType() {
        if (inputType == null) {
            for (String inputTypeKey: inputTypeCounts.keySet()) {
                if (inputType == null || inputTypeCounts.get(inputTypeKey) > inputTypeCounts.get(inputType)) {
                    inputType = inputTypeKey;
                }
            }
        }

        return inputType;
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
        return Utils.fixIdentifier(id, "VARIANT_");
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder initStringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(initStringBuilder, "Renode.variant", getId(), getColor());

        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "addVariant", initStringBuilder);
        return stringBuilder;
    }
}
