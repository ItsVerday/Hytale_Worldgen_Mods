package io.github.itsverday.renode.definition.content;

import io.github.itsverday.renode.definition.BsonEncodable;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;

import javax.annotation.Nullable;

public abstract class NodeContentDefinition extends BsonEncodable {
    private final String id;
    private final String type;
    private final String label;
    @Nullable
    private final String description;

    public NodeContentDefinition(String id, String type, String label, @Nullable String description) {
        this.id = id;
        this.type = type;
        this.label = label;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Override
    public BsonValue encode() {
        BsonDocument options = encodeOptions();
        options.put("Label", new BsonString(getLabel()));
        if (getDescription() != null) options.put("Description", new BsonString(getDescription()));

        BsonDocument document = new BsonDocument();
        document.put("Id", new BsonString(getId()));
        document.put("Type", new BsonString(getType()));
        document.put("Options", options);
        return document;
    }

    public abstract BsonDocument encodeOptions();
}
