package io.github.itsverday.renode.scraper.node;

import io.github.itsverday.renode.scraper.Category;
import io.github.itsverday.renode.scraper.Identified;
import io.github.itsverday.renode.scraper.Utils;
import io.github.itsverday.renode.scraper.Variant;
import io.github.itsverday.renode.scraper.codegen.CodeGenerator;
import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.content.Content;
import io.github.itsverday.renode.scraper.node.init.DefaultNodeInit;
import io.github.itsverday.renode.scraper.node.init.NodeInit;
import io.github.itsverday.renode.scraper.output.Output;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonValue;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class Node implements Identified, CodeGenerator {
    private final BsonDocument document;
    private final String id;
    private final String title;
    private final String color;
    private final ArrayList<Content> contents = new ArrayList<>();
    private final ArrayList<Output> outputs = new ArrayList<>();
    private final ArrayList<String> inputTypes = new ArrayList<>();
    private final ArrayList<Category> categories = new ArrayList<>();

    private NodeInit nodeInit = null;
    private Variant variant = null;

    public Node(BsonDocument document) {
        this.document = document;
        id = document.getString("Id").getValue();
        title = document.getString("Title").getValue();
        color = document.getString("Color").getValue();

        if (document.containsKey("Content")) {
            for (BsonValue contentValue: document.getArray("Content")) {
                Content contentInstance = Content.fromDocument(contentValue.asDocument());
                if (contentInstance != null) contents.add(contentInstance);
            }
        }

        if (document.containsKey("Outputs")) {
            for (BsonValue outputValue: document.getArray("Outputs")) {
                Output output = new Output(outputValue.asDocument());
                outputs.add(output);
                contents.addAll(output.getFields());
            }
        }

        if (document.containsKey("Schema")) {
            BsonDocument schema = document.getDocument("Schema");
            for (String key: schema.keySet()) {
                BsonValue value = schema.get(key);

                if (value.isString()) {
                    for (Content content: contents) {
                        if (content.getId().equals(value.asString().getValue())) {
                            content.setSchemaId(key);
                        }
                    }
                } else {
                    String pinValue = value.asDocument().containsKey("Pin") ? value.asDocument().getString("Pin").getValue() : value.asDocument().getString("pin").getValue();
                    for (Output output: outputs) {
                        if (output.getId().equals(pinValue)) {
                            output.setSchemaId(key);
                        }
                    }
                }
            }
        }

        BsonArray inputs = new BsonArray();
        if (document.containsKey("Inputs")) {
            inputs = document.getArray("Inputs");
        }

        for (BsonValue input: inputs) {
            BsonDocument inputDocument = input.asDocument();
            inputTypes.add(inputDocument.getString("Type").getValue());
        }

        setNodeInit(new DefaultNodeInit(this));
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return color;
    }

    @Nullable
    public String getInheritedColor() {
        if (getVariant() != null && getVariant().getColor() != null) return getVariant().getColor();
        for (Category category: categories) {
            if (category.getColor() != null) return category.getColor();
        }

        return null;
    }

    public ArrayList<String> getInputTypes() {
        return inputTypes;
    }

    public ArrayList<Output> getOutputs() {
        return outputs;
    }

    public Variant getVariant() {
        return variant;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void setNodeInit(NodeInit nodeInit) {
        this.nodeInit = nodeInit;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    @Override
    public String getIdentifier() {
        return Utils.fixIdentifier(id, "NODE_");
    }

    public HashMap<String, String> getExtraSchemaKeys() {
        HashMap<String, String> extraSchemaKeys = new HashMap<>();
        if (!document.containsKey("Schema")) return extraSchemaKeys;

        BsonDocument schema = document.getDocument("Schema");

        for (String schemaKey: schema.keySet()) {
            if (schemaKey.equals("Type") && variant != null) continue;
            BsonValue value = schema.get(schemaKey);

            if (!value.isString()) continue;
            String valueString = value.asString().getValue();

            boolean match = false;
            for (Content content: contents) {
                if (content.containsId(valueString)) {
                    match = true;
                    break;
                }
            }

            if (match) continue;
            extraSchemaKeys.put(schemaKey, valueString);
        }

        return extraSchemaKeys;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder initStringBuilder = new StringBuilder();
        initStringBuilder.append(nodeInit.generateCode());

        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "addNode", initStringBuilder);
        for (Content content: contents) {
            CodeGeneratorUtils.writeFunctionCall(stringBuilder, ".addContent", content.generateCode());
        }

        for (Output output: outputs) {
            stringBuilder.append(output.generateCode());
        }

        String inheritedColor = getInheritedColor();
        if (inheritedColor == null || !inheritedColor.equals(getColor())) {
            CodeGeneratorUtils.writeFunctionCall(stringBuilder, ".withColorOverride", getColor());
        }

        for (Category category: categories) {
            CodeGeneratorUtils.writeFunctionCall(stringBuilder, ".addCategory", category);
        }

        HashMap<String, String> extraSchemaKeys = getExtraSchemaKeys();
        for (String key: extraSchemaKeys.keySet()) {
            CodeGeneratorUtils.writeFunctionCall(stringBuilder, ".addSchemaString", key, extraSchemaKeys.get(key));
        }

        return stringBuilder;
    }
}
