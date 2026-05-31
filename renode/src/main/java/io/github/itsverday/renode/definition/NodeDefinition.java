package io.github.itsverday.renode.definition;

import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import io.github.itsverday.renode.definition.schema.NodeSchemaDefinition;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;

import javax.annotation.Nullable;

public class NodeDefinition extends BsonEncodable {
    private final String id;
    private final String title;
    private final String color;
    @Nullable
    private final String description;
    @Nullable
    private final NodeContentDefinition[] content;
    @Nullable
    private final NodeInputDefinition[] inputs;
    @Nullable
    private final NodeOutputDefinition[] outputs;
    private final NodeSchemaDefinition schema;

    public NodeDefinition(String id, String title, String color, @Nullable String description, @Nullable NodeContentDefinition[] content, @Nullable NodeInputDefinition[] inputs, @Nullable NodeOutputDefinition[] outputs, NodeSchemaDefinition schema) {
        this.id = id;
        this.title = title;
        this.color = color;
        this.description = description;
        this.content = content;
        this.inputs = inputs;
        this.outputs = outputs;
        this.schema = schema;
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
    public String getDescription() {
        return description;
    }

    @Nullable
    public NodeContentDefinition[] getContent() {
        return content;
    }

    @Nullable
    public NodeInputDefinition[] getInputs() {
        return inputs;
    }

    @Nullable
    public NodeOutputDefinition[] getOutputs() {
        return outputs;
    }

    public NodeSchemaDefinition getSchema() {
        return schema;
    }

    @Override
    public BsonValue encode() {
        BsonDocument document = new BsonDocument();
        document.put("Id", new BsonString(getId()));
        document.put("Title", new BsonString(getTitle()));
        document.put("Color", new BsonString(getColor()));
        if (getDescription() != null) document.put("Description", new BsonString(getDescription()));
        if (getContent() != null) {
            BsonArray contentArray = new BsonArray();
            for (NodeContentDefinition contentDefinition: getContent()) {
                contentArray.add(contentDefinition.encode());
            }

            document.put("Content", contentArray);
        }

        if (getInputs() != null) {
            BsonArray inputsArray = new BsonArray();
            for (NodeInputDefinition input: getInputs()) {
                inputsArray.add(input.encode());
            }

            document.put("Inputs", inputsArray);
        }

        if (getOutputs() != null) {
            BsonArray outputsArray = new BsonArray();
            for (NodeOutputDefinition output: getOutputs()) {
                outputsArray.add(output.encode());
            }

            document.put("Outputs", outputsArray);
        }

        document.put("Schema", getSchema().encode());
        return document;
    }
}
