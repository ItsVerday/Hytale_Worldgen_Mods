package io.github.itsverday.renode.definition.content.type;

import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;

import javax.annotation.Nullable;

public class NodeCheckboxContentDefinition extends NodeContentDefinition {
    @Nullable
    private final Boolean defaultValue;

    public NodeCheckboxContentDefinition(String id, String label, @Nullable String description, @Nullable Boolean defaultValue) {
        super(id, "Checkbox", label, description);
        this.defaultValue = defaultValue;
    }

    @Nullable
    public Boolean getDefaultValue() {
        return defaultValue;
    }

    @Override
    public BsonDocument encodeOptions() {
        BsonDocument document = new BsonDocument();
        if (getDefaultValue() != null) document.put("Default", new BsonBoolean(getDefaultValue()));
        return document;
    }
}
