package io.github.itsverday.renode.builder;

import io.github.itsverday.renode.builder.content.NodeContentBuilder;
import io.github.itsverday.renode.builder.input.AbstractNodeInput;
import io.github.itsverday.renode.builder.input.SelfNodeInput;
import io.github.itsverday.renode.builder.input.VariantNodeInput;
import io.github.itsverday.renode.builder.output.AbstractNodeOutput;
import io.github.itsverday.renode.builder.output.NodeNodeOutput;
import io.github.itsverday.renode.builder.output.VariantNodeOutput;
import io.github.itsverday.renode.definition.NodeDefinition;
import io.github.itsverday.renode.definition.NodeInputDefinition;
import io.github.itsverday.renode.definition.NodeOutputDefinition;
import io.github.itsverday.renode.definition.content.NodeContentDefinition;
import io.github.itsverday.renode.definition.schema.NodeSchemaDefinition;
import io.github.itsverday.renode.definition.schema.NodeSchemaPinValueDefinition;
import io.github.itsverday.renode.definition.schema.NodeSchemaStringValueDefinition;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class NodeBuilder {
    private String id;
    private String title;
    private String colorOverride;
    @Nullable
    private NodeVariantClass variant = null;
    private final List<NodeCategory> categories = new ArrayList<>();
    private final List<NodeContentBuilder<?>> content = new ArrayList<>();
    private final List<AbstractNodeInput> inputs = new ArrayList<>();
    private final List<AbstractNodeOutput> outputs = new ArrayList<>();
    private final NodeSchemaDefinition schema = new NodeSchemaDefinition();

    public String getId() {
        return id;
    }

    public NodeBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NodeBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getColorOverride() {
        return colorOverride;
    }

    public NodeBuilder withColorOverride(String colorOverride) {
        this.colorOverride = colorOverride;
        return this;
    }

    public String getColor() {
        if (getColorOverride() != null) return getColorOverride();
        if (getVariant() != null && getVariant().getColor() != null) return getVariant().getColor();
        for (NodeCategory category: categories) {
            if (category.getColor() != null) return category.getColor();
        }

        return "Grey";
    }

    public List<NodeCategory> getCategories() {
        return categories;
    }

    public NodeBuilder addCategory(@Nullable NodeCategory category) {
        categories.add(category);
        return this;
    }

    public NodeBuilder clearCategories() {
        categories.clear();
        return this;
    }

    @Nullable
    public NodeVariantClass getVariant() {
        return variant;
    }

    public NodeBuilder withVariant(@Nullable NodeVariantClass variant) {
        this.variant = variant;
        return this;
    }

    public List<NodeContentBuilder<?>> getContent() {
        return content;
    }

    public NodeBuilder addContent(NodeContentBuilder<?>... content) {
        this.content.addAll(Arrays.asList(content));
        return this;
    }

    public NodeBuilder clearContent() {
        content.clear();
        return this;
    }

    public List<AbstractNodeInput> getInputs() {
        return inputs;
    }

    public boolean hasSelfInput() {
        for (AbstractNodeInput input: getInputs()) {
            if (input instanceof SelfNodeInput selfInput) {
                if (selfInput.getSelf().getId().equals(getId())) return true;
            }
        }

        return false;
    }

    public NodeBuilder addInput(@Nullable AbstractNodeInput input) {
        inputs.add(input);
        return this;
    }

    public NodeBuilder addSelfInput() {
        return addInput(new SelfNodeInput(this, false));
    }

    public NodeBuilder addVariantInput(NodeVariantClass variant) {
        return addInput(new VariantNodeInput(variant, false));
    }

    public NodeBuilder clearInputs() {
        inputs.clear();
        return this;
    }

    public List<AbstractNodeOutput> getOutputs() {
        return outputs;
    }

    private NodeBuilder addOutput(AbstractNodeOutput output) {
        outputs.add(output);
        return this;
    }

    public NodeBuilder addNodeOutput(String id, String label, boolean multiple, Supplier<NodeBuilder> node) {
        return addOutput(new NodeNodeOutput(id, label, multiple, node));
    }

    public NodeBuilder addNodeOutput(String id, String label, boolean multiple, NodeBuilder node) {
        return addNodeOutput(id, label, multiple, () -> node);
    }

    public NodeBuilder addVariantOutput(String id, String label, boolean multiple, Supplier<NodeVariantClass> variant) {
        return addOutput(new VariantNodeOutput(id, label, multiple, variant));
    }

    public NodeBuilder addVariantOutput(String id, String label, boolean multiple, NodeVariantClass variant) {
        return addVariantOutput(id, label, multiple, () -> variant);
    }

    public NodeBuilder clearOutputs() {
        outputs.clear();
        return this;
    }

    public NodeSchemaDefinition getSchema() {
        return schema;
    }

    public NodeBuilder addSchemaString(String key, String value) {
        getSchema().addValue(key, new NodeSchemaStringValueDefinition(value));
        return this;
    }

    public List<NodeBuilder> getPossibleChildren() {
        List<NodeBuilder> possibleChildren = new ArrayList<>();
        for (AbstractNodeOutput nodeOutput: getOutputs()) {
            possibleChildren.addAll(nodeOutput.getPossibleChildren());
        }

        return possibleChildren;
    }

    public void preBuild() {
        for (AbstractNodeOutput output: getOutputs()) {
            output.ensureNodeInputs();
        }
    }

    public NodeDefinition build() {
        NodeSchemaDefinition schema = new NodeSchemaDefinition();
        for (String key: this.schema.getMap().keySet()) {
            schema.addValue(key, this.schema.getMap().get(key));
        }

        List<NodeContentDefinition> content = new ArrayList<>();
        int contentIndex = 1;
        for (NodeContentBuilder<?> contentBuilder: getContent()) {
            String contentId = "Content" + contentIndex++;
            content.add(contentBuilder.buildContent(contentId));
            schema.addValue(contentBuilder.getId(), new NodeSchemaStringValueDefinition(contentId));
        }

        List<NodeOutputDefinition> outputs = new ArrayList<>();
        int outputIndex = 1;
        for (AbstractNodeOutput output: getOutputs()) {
            String contentId = "Output" + outputIndex++;
            outputs.add(new NodeOutputDefinition(contentId, output.getType(), output.getColor(), output.getMultiple(), output.getLabel(), output.getIsMap()));
            schema.addValue(output.getId(), new NodeSchemaPinValueDefinition(contentId, output.getNode()));
        }

        List<NodeInputDefinition> inputs = new ArrayList<>();
        int inputIndex = 1;
        for (AbstractNodeInput input: getInputs()) {
            String inputId = "Input" + inputIndex++;
            inputs.add(new NodeInputDefinition(inputId, input.getType(), input.getColor() != null ? input.getColor() : getColor(), input.getMultiple()));
        }

        return new NodeDefinition(getId(), getTitle(), getColor(), content.toArray(new NodeContentDefinition[0]), inputs.toArray(new NodeInputDefinition[0]), outputs.toArray(new NodeOutputDefinition[0]), schema);
    }
}
