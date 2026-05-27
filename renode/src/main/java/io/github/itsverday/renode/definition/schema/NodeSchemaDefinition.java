package io.github.itsverday.renode.definition.schema;

import io.github.itsverday.renode.definition.BsonEncodable;
import org.bson.BsonDocument;
import org.bson.BsonValue;

import java.util.HashMap;
import java.util.Map;

public class NodeSchemaDefinition extends BsonEncodable {
    private final Map<String, NodeSchemaValueDefinition> schema = new HashMap<>();

    public NodeSchemaDefinition() {}

    public Map<String, NodeSchemaValueDefinition> getMap() {
        return schema;
    }

    public NodeSchemaDefinition addValue(String key, NodeSchemaValueDefinition value) {
        schema.put(key, value);
        return this;
    }

    @Override
    public BsonValue encode() {
        BsonDocument document = new BsonDocument();
        for (String key: schema.keySet()) {
            document.put(key, schema.get(key).encode());
        }

        return document;
    }
}
