package io.github.itsverday.renode.definition.content.type;

import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;

import javax.annotation.Nullable;

public class NodeStringContentDefinition extends NodeContentDefinition {
    @Nullable
    private final String defaultValue;
    @Nullable
    private final Integer width;
    @Nullable
    private final Integer height;

    public NodeStringContentDefinition(String id, String label, @Nullable String description, @Nullable String defaultValue, @Nullable Integer width, @Nullable Integer height) {
        super(id, "String", label, description);
        this.defaultValue = defaultValue;
        this.width = width;
        this.height = height;
    }

    @Nullable
    public String getDefaultValue() {
        return defaultValue;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    @Nullable
    public Integer getHeight() {
        return height;
    }

    @Override
    public BsonDocument encodeOptions() {
        BsonDocument document = new BsonDocument();
        if (getDefaultValue() != null) document.put("Default", new BsonString(getDefaultValue()));
        if (getWidth() != null) document.put("Width", new BsonInt32(getWidth()));
        if (getHeight() != null) document.put("Height", new BsonInt32(getHeight()));
        return document;
    }
}
