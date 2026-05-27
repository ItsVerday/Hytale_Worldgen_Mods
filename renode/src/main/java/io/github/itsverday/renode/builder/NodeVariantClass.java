package io.github.itsverday.renode.builder;

import io.github.itsverday.renode.builder.workspace.NodeWorkspace;
import io.github.itsverday.renode.definition.schema.NodeSchemaStringValueDefinition;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class NodeVariantClass {
    private final String name;
    @Nullable
    private final String color;
    private final Map<String, NodeBuilder> variantTypes = new HashMap<>();
    private final String variantFieldName = "Type";

    public NodeVariantClass(String name, @Nullable String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public String getColor() {
        return color;
    }

    public NodeVariantClass addVariantNode(NodeBuilder node, String variantName) {
        variantTypes.put(variantName, node);
        node.withVariant(this);
        node.getSchema().addValue(variantFieldName, new NodeSchemaStringValueDefinition(variantName));
        return this;
    }

    public Map<String, NodeBuilder> getVariantTypes() {
        return variantTypes;
    }

    public NodeBuilder variantNode(String variantName, String id, String title) {
        NodeBuilder node = Renode.node(id, title).clearInputs().addVariantInput(this);
        addVariantNode(node, variantName);
        return node;
    }

    public NodeBuilder variantNode(String id, String title) {
        return variantNode(id, getName() + id, title);
    }

    public BsonValue encode(NodeWorkspace workspace) {
        BsonDocument variants = new BsonDocument();
        for (String variantName: getVariantTypes().keySet()) {
            if (!workspace.getNodes().contains(getVariantTypes().get(variantName))) continue;
            variants.put(variantName, new BsonString(getVariantTypes().get(variantName).getId()));
        }

        BsonDocument document = new BsonDocument();
        document.put("VariantFieldName", new BsonString(this.variantFieldName));
        document.put("Variants", variants);
        return document;
    }
}
