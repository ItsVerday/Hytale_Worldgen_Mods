package io.github.itsverday.renode.builder.content.type;

import io.github.itsverday.renode.builder.content.NodeContentBuilder;
import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import io.github.itsverday.renode.definition.content.type.NodeListContentDefinition;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nullable;

public class NodeListContentBuilder extends NodeContentBuilder<NodeListContentBuilder> {
    private String listType;
    @Nullable
    private Integer width;

    public String getListType() {
        return listType;
    }

    public NodeListContentBuilder withListType(String listType) {
        this.listType = listType;
        return this;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    public NodeListContentBuilder withWidth(@Nullable Integer width) {
        this.width = width;
        return this;
    }

    @NullableDecl
    @Override
    public NodeContentDefinition buildContent(String contentId) {
        return new NodeListContentDefinition(contentId, getLabel(), getDescription(), getListType(), getWidth());
    }
}
