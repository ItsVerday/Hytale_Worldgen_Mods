package io.github.itsverday.renode.scraper.content.type;

import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.content.Content;

import javax.annotation.Nullable;

public class EnumContent extends Content {
    private final String[] values;
    @Nullable
    private final String defaultValue;
    @Nullable
    private final Integer width;

    public EnumContent(String id, String label, @Nullable String description, String[] values, @Nullable String defaultValue, @Nullable Integer width) {
        super(id, label, description);
        this.values = values;
        this.defaultValue = defaultValue;
        this.width = width;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "Renode.enumContent", getSchemaId(), getLabel());
        CodeGeneratorUtils.writeFunctionCallArray(stringBuilder, ".withValues", values);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withDefaultValue", defaultValue);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withWidth", width);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withDescription", getDescription());
        return stringBuilder;
    }
}
