package io.github.itsverday.renode.scraper.content.type;

import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.content.Content;

import javax.annotation.Nullable;

public class IntegerContent extends Content {
    @Nullable
    private final Integer defaultValue;
    @Nullable
    private final Integer width;

    public IntegerContent(String id, String label, @Nullable String description, @Nullable Integer defaultValue, @Nullable Integer width) {
        super(id, label, description);
        this.defaultValue = defaultValue;
        this.width = width;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "Renode.integerContent", getSchemaId(), getLabel());
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withDefaultValue", defaultValue);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withWidth", width);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withDescription", getDescription());
        return stringBuilder;
    }
}
