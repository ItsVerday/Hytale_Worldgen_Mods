package io.github.itsverday.renode.builder.content.type;

import io.github.itsverday.renode.builder.content.NodeContentBuilder;
import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import io.github.itsverday.renode.definition.content.type.NodeEnumContentDefinition;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;

public class NodeEnumContentBuilder extends NodeContentBuilder<NodeEnumContentBuilder> {
    private ArrayList<String> values = new ArrayList<>();
    @Nullable
    private String defaultValue = null;
    @Nullable
    private Integer width = null;

    public ArrayList<String> getValues() {
        return values;
    }

    public NodeEnumContentBuilder withValues(String... values) {
        this.values = new ArrayList<>(Arrays.asList(values));
        return this;
    }

    public NodeEnumContentBuilder withEnumValues(Enum<?>[] enumValues) {
        return withValues(Arrays.stream(enumValues).map(Object::toString).toArray(String[]::new));
    }

    public NodeEnumContentBuilder addValues(String... values) {
        this.values.addAll(Arrays.asList(values));
        return this;
    }

    @Nullable
    public String getDefaultValue() {
        return defaultValue;
    }

    public NodeEnumContentBuilder withDefaultValue(@Nullable String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    public NodeEnumContentBuilder withWidth(@Nullable Integer width) {
        this.width = width;
        return this;
    }

    @NullableDecl
    @Override
    public NodeContentDefinition buildContent(String contentId) {
        return new NodeEnumContentDefinition(contentId, getLabel(), getLabel(), getValues().toArray(new String[0]), getDefaultValue(), getWidth());
    }
}
