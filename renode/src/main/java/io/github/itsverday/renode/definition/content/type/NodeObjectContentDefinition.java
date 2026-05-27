package io.github.itsverday.renode.definition.content.type;

import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import org.bson.BsonArray;
import org.bson.BsonDocument;

import javax.annotation.Nullable;

public class NodeObjectContentDefinition extends NodeContentDefinition {
    private final NodeContentDefinition[] fields;

    public NodeObjectContentDefinition(String id, String label, @Nullable String description, NodeContentDefinition[] fields) {
        super(id, "Object", label, description);
        this.fields = fields;
    }

    public NodeContentDefinition[] getFields() {
        return fields;
    }

    @Override
    public BsonDocument encodeOptions() {
        BsonArray fieldsArray = new BsonArray();
        for (NodeContentDefinition field: getFields()) {
            fieldsArray.add(field.encode());
        }

        BsonDocument document = new BsonDocument();
        document.put("Fields", fieldsArray);
        return document;
    }
}
