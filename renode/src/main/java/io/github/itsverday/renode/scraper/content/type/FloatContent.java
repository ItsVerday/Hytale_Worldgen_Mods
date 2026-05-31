package io.github.itsverday.renode.scraper.content.type;

import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.content.Content;

import javax.annotation.Nullable;

public class FloatContent extends Content {
    @Nullable
    private final Double defaultValue;
    @Nullable
    private final Integer width;

    public FloatContent(String id, String label, @Nullable String description, @Nullable Double defaultValue, @Nullable Integer width) {
        super(id, label, description);
        this.defaultValue = defaultValue;
        this.width = width;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "Renode.floatContent", getSchemaId(), getLabel());
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withDefaultValue", defaultValue);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withWidth", width);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withDescription", getDescription());
        return stringBuilder;
    }
}
