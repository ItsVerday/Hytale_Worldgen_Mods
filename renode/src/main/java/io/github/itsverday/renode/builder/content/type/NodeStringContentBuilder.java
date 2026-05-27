package io.github.itsverday.renode.builder.content.type;

import io.github.itsverday.renode.builder.content.NodeContentBuilder;
import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import io.github.itsverday.renode.definition.content.type.NodeStringContentDefinition;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nullable;

public class NodeStringContentBuilder extends NodeContentBuilder<NodeStringContentBuilder> {
    @Nullable
    private String defaultValue = null;
    @Nullable
    private Integer width = null;
    @Nullable
    private Integer height = null;

    @Nullable
    public String getDefaultValue() {
        return defaultValue;
    }

    public NodeStringContentBuilder withDefaultValue(@Nullable String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    public NodeStringContentBuilder withWidth(@Nullable Integer width) {
        this.width = width;
        return this;
    }

    @Nullable
    public Integer getHeight() {
        return height;
    }

    public NodeStringContentBuilder withHeight(@Nullable Integer height) {
        this.height = height;
        return this;
    }

    @NullableDecl
    @Override
    public NodeContentDefinition buildContent(String contentId) {
        return new NodeStringContentDefinition(contentId, getLabel(), getDescription(), getDefaultValue(), getWidth(), getHeight());
    }
}
