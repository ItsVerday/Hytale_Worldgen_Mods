package io.github.itsverday.renode.definition.content.type;

import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;

import javax.annotation.Nullable;

public class NodeListContentDefinition extends NodeContentDefinition {
    private final String listType;
    @Nullable
    private final Integer width;

    public NodeListContentDefinition(String id, String label, @Nullable String description, String listType, @Nullable Integer width) {
        super(id, "List", label, description);
        this.listType = listType;
        this.width = width;
    }

    public String getListType() {
        return listType;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    @Override
    public BsonDocument encodeOptions() {
        BsonDocument document = new BsonDocument();
        document.put("Type", new BsonString(getListType()));
        if (getWidth() != null) document.put("Width", new BsonInt32(getWidth()));
        return document;
    }
}
