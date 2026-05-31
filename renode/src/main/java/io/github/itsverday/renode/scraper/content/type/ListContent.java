package io.github.itsverday.renode.scraper.content.type;

import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.content.Content;

import javax.annotation.Nullable;

public class ListContent extends Content {
    private final String listType;
    @Nullable
    private final Integer width;

    public ListContent(String id, String label, @Nullable String description, String listType, @Nullable Integer width) {
        super(id, label, description);
        this.listType = listType;
        this.width = width;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "Renode.listContent", getSchemaId(), getLabel(), listType);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withWidth", width);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withDescription", getDescription());
        return stringBuilder;
    }
}
