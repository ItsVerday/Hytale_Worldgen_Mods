package io.github.itsverday.renode.definition;

import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;

import javax.annotation.Nullable;

public class NodeOutputDefinition extends BsonEncodable {
    private final String id;
    private final String type;
    private final String color;
    @Nullable
    private final Boolean multiple;
    @Nullable
    private final String label;
    @Nullable
    private final Boolean isMap;

    public NodeOutputDefinition(String id, String type, String color, @Nullable Boolean multiple, @Nullable String label, @Nullable Boolean isMap) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.multiple = multiple;
        this.label = label;
        this.isMap = isMap;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    @Nullable
    public Boolean getMultiple() {
        return multiple;
    }

    @Nullable
    public String getLabel() {
        return label;
    }

    @Nullable
    public Boolean getIsMap() {
        return isMap;
    }

    @Override
    public BsonValue encode() {
        BsonDocument document = new BsonDocument();
        document.put("Id", new BsonString(getId()));
        document.put("Type", new BsonString(getType()));
        document.put("Color", new BsonString(getColor()));
        if (getMultiple() != null) document.put("Multiple", new BsonBoolean(getMultiple()));
        if (getLabel() != null) document.put("Label", new BsonString(getLabel()));
        if (getIsMap() != null) document.put("IsMap", new BsonBoolean(getIsMap()));
        return document;
    }
}
