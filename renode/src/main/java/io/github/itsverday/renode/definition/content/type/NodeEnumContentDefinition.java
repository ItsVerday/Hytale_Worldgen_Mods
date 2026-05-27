package io.github.itsverday.renode.definition.content.type;

import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import org.bson.*;

import javax.annotation.Nullable;

public class NodeEnumContentDefinition extends NodeContentDefinition {
    private final String[] values;
    @Nullable
    private final String defaultValue;
    @Nullable
    private final Integer width;

    public NodeEnumContentDefinition(String id, String label, @Nullable String description, String[] values, @Nullable String defaultValue, @Nullable Integer width) {
        super(id, "Enum", label, description);
        this.values = values;
        this.defaultValue = defaultValue;
        this.width = width;

        if (defaultValue != null) {
            boolean foundDefaultValue = false;
            for (String value: values) {
                if (value.equals(defaultValue)) {
                    foundDefaultValue = true;
                    break;
                }
            }

            if (!foundDefaultValue) throw new IllegalArgumentException("Invalid default value for NodeEnumContentDefinition!");
        }
    }

    public String[] getValues() {
        return values;
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
        BsonArray values = new BsonArray();
        for (String value: getValues()) {
            values.add(new BsonString(value));
        }

        BsonDocument document = new BsonDocument();
        document.put("Values", values);
        if (getDefaultValue() != null) document.put("Default", new BsonString(getDefaultValue()));
        if (getWidth() != null) document.put("Width", new BsonInt32(getWidth()));
        return document;
    }
}
