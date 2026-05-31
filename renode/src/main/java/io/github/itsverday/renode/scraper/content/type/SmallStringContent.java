package io.github.itsverday.renode.scraper.content.type;

import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.content.Content;

import javax.annotation.Nullable;

public class SmallStringContent extends Content {
    @Nullable
    private final String defaultValue;
    @Nullable
    private final Integer width;

    public SmallStringContent(String id, String label, @Nullable String description, @Nullable String defaultValue, @Nullable Integer width) {
        super(id, label, description);
        this.defaultValue = defaultValue;
        this.width = width;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "Renode.smallStringContent", getSchemaId(), getLabel());
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withDefaultValue", defaultValue);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withWidth", width);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withDescription", getDescription());
        return stringBuilder;
    }
}
