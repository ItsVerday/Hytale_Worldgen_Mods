package io.github.itsverday.renode.definition.content.type;

import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import org.bson.BsonDocument;
import org.bson.BsonInt32;

import javax.annotation.Nullable;

public class NodeIntegerSliderContentDefinition extends NodeContentDefinition {
    @Nullable
    private final Integer defaultValue;
    private final int min;
    private final int max;
    private final int tickFrequency;
    @Nullable
    private final Integer width;

    public NodeIntegerSliderContentDefinition(String id, String label, @Nullable String description, @Nullable Integer defaultValue, int min, int max, int tickFrequency, @Nullable Integer width) {
        super(id, "IntSlider", label, description);
        this.defaultValue = defaultValue;
        this.min = min;
        this.max = max;
        this.tickFrequency = tickFrequency;
        this.width = width;
    }

    @Nullable
    public Integer getDefaultValue() {
        return defaultValue;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getTickFrequency() {
        return tickFrequency;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    @Override
    public BsonDocument encodeOptions() {
        BsonDocument document = new BsonDocument();
        if (getDefaultValue() != null) document.put("Default", new BsonInt32(getDefaultValue()));
        document.put("Min", new BsonInt32(getMin()));
        document.put("Max", new BsonInt32(getMax()));
        document.put("TickFrequency", new BsonInt32(getTickFrequency()));
        if (getWidth() != null) document.put("Width", new BsonInt32(getWidth()));
        return document;
    }
}
