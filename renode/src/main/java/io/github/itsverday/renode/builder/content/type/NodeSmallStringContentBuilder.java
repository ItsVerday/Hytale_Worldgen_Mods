package io.github.itsverday.renode.builder.content.type;

import io.github.itsverday.renode.builder.content.NodeContentBuilder;
import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import io.github.itsverday.renode.definition.content.type.NodeSmallStringContentDefinition;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nullable;

public class NodeSmallStringContentBuilder extends NodeContentBuilder<NodeSmallStringContentBuilder> {
    @Nullable
    private String defaultValue = null;
    @Nullable
    private Integer width = null;

    @Nullable
    public String getDefaultValue() {
        return defaultValue;
    }

    public NodeSmallStringContentBuilder withDefaultValue(@Nullable String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    public NodeSmallStringContentBuilder withWidth(@Nullable Integer width) {
        this.width = width;
        return this;
    }

    @NullableDecl
    @Override
    public NodeContentDefinition buildContent(String contentId) {
        return new NodeSmallStringContentDefinition(contentId, getLabel(), getDescription(), getDefaultValue(), getWidth());
    }
}
