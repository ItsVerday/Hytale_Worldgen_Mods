package io.github.itsverday.renode.builder.content.type;

import io.github.itsverday.renode.builder.content.NodeContentBuilder;
import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import io.github.itsverday.renode.definition.content.type.NodeObjectContentDefinition;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodeObjectContentBuilder extends NodeContentBuilder<NodeObjectContentBuilder> {
    private List<NodeContentBuilder<?>> fields = new ArrayList<>();

    public List<NodeContentBuilder<?>> getFields() {
        return fields;
    }

    public NodeObjectContentBuilder withFields(NodeContentBuilder<?>... fields) {
        this.fields = new ArrayList<>(Arrays.asList(fields));
        return this;
    }

    public NodeObjectContentBuilder addFields(NodeContentBuilder<?>... fields) {
        this.fields.addAll(Arrays.asList(fields));
        return this;
    }

    @NullableDecl
    @Override
    public NodeContentDefinition buildContent(String contentId) {
        List<NodeContentDefinition> fields = new ArrayList<>();
        for (NodeContentBuilder<?> field: getFields()) {
            fields.add(field.buildContent(field.getId()));
        }

        return new NodeObjectContentDefinition(contentId, getLabel(), getDescription(), fields.toArray(new NodeContentDefinition[0]));
    }
}
