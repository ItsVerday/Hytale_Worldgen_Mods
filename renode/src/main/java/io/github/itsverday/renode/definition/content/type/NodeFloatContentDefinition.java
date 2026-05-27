package io.github.itsverday.renode.definition.content.type;

import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import org.bson.BsonDocument;
import org.bson.BsonDouble;
import org.bson.BsonInt32;

import javax.annotation.Nullable;

public class NodeFloatContentDefinition extends NodeContentDefinition {
    @Nullable
    private final Double defaultValue;
    @Nullable
    private final Integer width;

    public NodeFloatContentDefinition(String id, String label, @Nullable String description, @Nullable Double defaultValue, @Nullable Integer width) {
        super(id, "Float", label, description);
        this.defaultValue = defaultValue;
        this.width = width;
    }

    @Nullable
    public Double getDefaultValue() {
        return defaultValue;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    @Override
    public BsonDocument encodeOptions() {
        BsonDocument document = new BsonDocument();
        if (getDefaultValue() != null) document.put("Default", new BsonDouble(getDefaultValue()));
        if (getWidth() != null) document.put("Width", new BsonInt32(getWidth()));
        return document;
    }
}
