package io.github.itsverday.renode.definition.content.type;

import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;

import javax.annotation.Nullable;

public class NodeSmallStringContentDefinition extends NodeContentDefinition {
    @Nullable
    private final String defaultValue;
    @Nullable
    private final Integer width;

    public NodeSmallStringContentDefinition(String id, String label, @Nullable String description, @Nullable String defaultValue, @Nullable Integer width) {
        super(id, "SmallString", label, description);
        this.defaultValue = defaultValue;
        this.width = width;
    }

    @Nullable
    public String getDefaultValue() {
        return defaultValue;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    @Override
    public BsonDocument encodeOptions() {
        BsonDocument document = new BsonDocument();
        if (getDefaultValue() != null) document.put("Default", new BsonString(getDefaultValue()));
        if (getWidth() != null) document.put("Width", new BsonInt32(getWidth()));
        return document;
    }
}
