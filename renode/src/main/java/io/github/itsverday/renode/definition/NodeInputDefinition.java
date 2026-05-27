package io.github.itsverday.renode.definition;

import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;

import javax.annotation.Nullable;

public class NodeInputDefinition extends BsonEncodable {
    private final String id;
    private final String type;
    private final String color;
    @Nullable
    private final Boolean multiple;

    public NodeInputDefinition(String id, String type, String color, @Nullable Boolean multiple) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.multiple = multiple;
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

    @Override
    public BsonValue encode() {
        BsonDocument document = new BsonDocument();
        document.put("Id", new BsonString(getId()));
        document.put("Type", new BsonString(getType()));
        document.put("Color", new BsonString(getColor()));
        if (getMultiple() != null) document.put("Multiple", new BsonBoolean(getMultiple()));
        return document;
    }
}
