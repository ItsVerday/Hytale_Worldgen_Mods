package io.github.itsverday.renode.definition.schema;

import org.bson.BsonString;
import org.bson.BsonValue;

public class NodeSchemaStringValueDefinition extends NodeSchemaValueDefinition {
    private final String value;

    public NodeSchemaStringValueDefinition(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public BsonValue encode() {
        return new BsonString(getValue());
    }
}
