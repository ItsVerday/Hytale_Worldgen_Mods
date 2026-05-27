package io.github.itsverday.renode.builder.content;

import io.github.itsverday.renode.definition.content.NodeContentDefinition;

import javax.annotation.Nullable;

public abstract class NodeContentBuilder<Self extends NodeContentBuilder<Self>> {
    private String id;
    private String label;
    @Nullable
    private String description = null;

    public String getId() {
        return id;
    }

    public Self withId(String id) {
        this.id = id;
        return (Self) this;
    }

    public String getLabel() {
        return label;
    }

    public Self withLabel(String label) {
        this.label = label;
        return (Self) this;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public Self withDescription(@Nullable String description) {
        this.description = description;
        return (Self) this;
    }

    @Nullable
    public NodeContentDefinition buildContent(String contentId) {
        return null;
    }
}
