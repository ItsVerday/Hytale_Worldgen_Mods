package io.github.itsverday.renode.definition.schema;

import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;

public class NodeSchemaPinValueDefinition extends NodeSchemaValueDefinition {
    private final String pin;
    private final String node;

    public NodeSchemaPinValueDefinition(String pin, String node) {
        this.pin = pin;
        this.node = node;
    }

    public String getPin() {
        return pin;
    }

    public String getNode() {
        return node;
    }

    @Override
    public BsonValue encode() {
        BsonDocument document = new BsonDocument();
        document.put("Pin", new BsonString(getPin()));
        document.put("Node", new BsonString(getNode()));
        return document;
    }
}
