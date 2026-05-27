package io.github.itsverday.renode.builder.content.type;

import io.github.itsverday.renode.builder.content.NodeContentBuilder;
import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import io.github.itsverday.renode.definition.content.type.NodeIntegerSliderContentDefinition;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nullable;

public class NodeIntegerSliderContentBuilder extends NodeContentBuilder<NodeIntegerSliderContentBuilder> {
    @Nullable
    private Integer defaultValue = null;
    private int min;
    private int max;
    private int tickFrequency;
    @Nullable
    private Integer width = null;

    @Nullable
    public Integer getDefaultValue() {
        return defaultValue;
    }

    public NodeIntegerSliderContentBuilder withDefaultValue(@Nullable Integer defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public int getMin() {
        return min;
    }

    public NodeIntegerSliderContentBuilder withMin(int min) {
        this.min = min;
        return this;
    }

    public int getMax() {
        return max;
    }

    public NodeIntegerSliderContentBuilder withMax(int max) {
        this.max = max;
        return this;
    }

    public int getTickFrequency() {
        return tickFrequency;
    }

    public NodeIntegerSliderContentBuilder withTickFrequency(int tickFrequency) {
        this.tickFrequency = tickFrequency;
        return this;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    public NodeIntegerSliderContentBuilder withWidth(@Nullable Integer width) {
        this.width = width;
        return this;
    }

    @NullableDecl
    @Override
    public NodeContentDefinition buildContent(String contentId) {
        return new NodeIntegerSliderContentDefinition(contentId, getLabel(), getDescription(), getDefaultValue(), getMin(), getMax(), getTickFrequency(), getWidth());
    }
}
