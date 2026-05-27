package io.github.itsverday.renode.definition.content.type;

import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import org.bson.BsonDocument;
import org.bson.BsonInt32;

import javax.annotation.Nullable;

public class NodeIntegerContentDefinition extends NodeContentDefinition {
    @Nullable
    private final Integer defaultValue;
    @Nullable
    private final Integer width;

    public NodeIntegerContentDefinition(String id, String label, @Nullable String description, @Nullable Integer defaultValue, @Nullable Integer width) {
        super(id, "Int", label, description);
        this.defaultValue = defaultValue;
        this.width = width;
    }

    @Nullable
    public Integer getDefaultValue() {
        return defaultValue;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    @Override
    public BsonDocument encodeOptions() {
        BsonDocument document = new BsonDocument();
        if (getDefaultValue() != null) document.put("Default", new BsonInt32(getDefaultValue()));
        if (getWidth() != null) document.put("Width", new BsonInt32(getWidth()));
        return document;
    }
}
