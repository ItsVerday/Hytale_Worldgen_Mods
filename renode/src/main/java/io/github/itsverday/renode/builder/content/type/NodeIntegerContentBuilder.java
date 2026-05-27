package io.github.itsverday.renode.builder.content.type;

import io.github.itsverday.renode.builder.content.NodeContentBuilder;
import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import io.github.itsverday.renode.definition.content.type.NodeIntegerContentDefinition;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nullable;

public class NodeIntegerContentBuilder extends NodeContentBuilder<NodeIntegerContentBuilder> {
    @Nullable
    private Integer defaultValue = null;
    @Nullable
    private Integer width = null;

    @Nullable
    public Integer getDefaultValue() {
        return defaultValue;
    }

    public NodeIntegerContentBuilder withDefaultValue(@Nullable Integer defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    public NodeIntegerContentBuilder withWidth(@Nullable Integer width) {
        this.width = width;
        return this;
    }

    @NullableDecl
    @Override
    public NodeContentDefinition buildContent(String contentId) {
        return new NodeIntegerContentDefinition(contentId, getLabel(), getDescription(), getDefaultValue(), getWidth());
    }
}
