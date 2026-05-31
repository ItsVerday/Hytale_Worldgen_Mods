package io.github.itsverday.renode.scraper.output.type;

import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.node.Node;
import io.github.itsverday.renode.scraper.output.Output;
import io.github.itsverday.renode.scraper.output.OutputType;

public class NodeOutputType extends OutputType {
    private final Node node;

    public NodeOutputType(Output output, Node node) {
        super(output);
        this.node = node;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        if (getOutput().getDescription() == null) {
            CodeGeneratorUtils.writeFunctionCall(stringBuilder, ".addNodeOutput", getOutput().getSchemaId(), getOutput().getLabel(), getOutput().isMultiple(), node);
        } else {
            CodeGeneratorUtils.writeFunctionCall(stringBuilder, ".addNodeOutput", getOutput().getSchemaId(), getOutput().getLabel(), getOutput().isMultiple(), node, getOutput().getDescription());
        }

        return stringBuilder;
    }
}
