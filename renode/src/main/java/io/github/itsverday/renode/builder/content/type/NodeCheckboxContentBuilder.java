package io.github.itsverday.renode.builder.content.type;

import io.github.itsverday.renode.builder.content.NodeContentBuilder;
import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import io.github.itsverday.renode.definition.content.type.NodeCheckboxContentDefinition;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nullable;

public class NodeCheckboxContentBuilder extends NodeContentBuilder<NodeCheckboxContentBuilder> {
    @Nullable
    private Boolean defaultValue = null;

    @Nullable
    public Boolean getDefaultValue() {
        return defaultValue;
    }

    public NodeCheckboxContentBuilder withDefaultValue(@Nullable Boolean defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @NullableDecl
    @Override
    public NodeContentDefinition buildContent(String contentId) {
        return new NodeCheckboxContentDefinition(contentId, getLabel(), getDescription(), getDefaultValue());
    }
}
