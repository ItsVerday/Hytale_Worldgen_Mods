package io.github.itsverday.renode.scraper.content.type;

import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.content.Content;

import javax.annotation.Nullable;

public class StringContent extends Content {
    @Nullable
    private final String defaultValue;
    @Nullable
    private final Integer width;
    @Nullable
    private final Integer height;

    public StringContent(String id, String label, @Nullable String defaultValue, @Nullable Integer width, @Nullable Integer height) {
        super(id, label);
        this.defaultValue = defaultValue;
        this.width = width;
        this.height = height;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "Renode.stringContent", getSchemaId(), getLabel());
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withDefaultValue", defaultValue);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withWidth", width);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withHeight", height);
        return stringBuilder;
    }
}
