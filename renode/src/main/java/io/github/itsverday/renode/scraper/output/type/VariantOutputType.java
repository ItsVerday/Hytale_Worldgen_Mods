package io.github.itsverday.renode.scraper.output.type;

import io.github.itsverday.renode.scraper.Variant;
import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.output.Output;
import io.github.itsverday.renode.scraper.output.OutputType;

public class VariantOutputType extends OutputType {
    private final Variant variant;

    public VariantOutputType(Output output, Variant variant) {
        super(output);
        this.variant = variant;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, ".addVariantOutput", getOutput().getSchemaId(), getOutput().getLabel(), getOutput().isMultiple(), variant);
        return stringBuilder;
    }
}
