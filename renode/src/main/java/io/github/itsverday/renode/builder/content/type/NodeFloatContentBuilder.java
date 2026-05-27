package io.github.itsverday.renode.builder.content.type;

import io.github.itsverday.renode.builder.content.NodeContentBuilder;
import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import io.github.itsverday.renode.definition.content.type.NodeFloatContentDefinition;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nullable;

public class NodeFloatContentBuilder extends NodeContentBuilder<NodeFloatContentBuilder> {
    @Nullable
    private Double defaultValue = null;
    @Nullable
    private Integer width = null;

    @Nullable
    public Double getDefaultValue() {
        return defaultValue;
    }

    public NodeFloatContentBuilder withDefaultValue(@Nullable Double defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    public NodeFloatContentBuilder withWidth(@Nullable Integer width) {
        this.width = width;
        return this;
    }

    @NullableDecl
    @Override
    public NodeContentDefinition buildContent(String contentId) {
        return new NodeFloatContentDefinition(contentId, getLabel(), getDescription(), getDefaultValue(), getWidth());
    }
}
