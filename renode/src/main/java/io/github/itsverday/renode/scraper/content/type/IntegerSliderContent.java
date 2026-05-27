package io.github.itsverday.renode.scraper.content.type;

import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.content.Content;

import javax.annotation.Nullable;

public class IntegerSliderContent extends Content {
    private final int min;
    private final int max;
    private final int tickFrequency;
    @Nullable
    private final Integer defaultValue;
    @Nullable
    private final Integer width;

    public IntegerSliderContent(String id, String label, int min, int max, int tickFrequency, @Nullable Integer defaultValue, @Nullable Integer width) {
        super(id, label);
        this.min = min;
        this.max = max;
        this.tickFrequency = tickFrequency;
        this.defaultValue = defaultValue;
        this.width = width;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "Renode.integerSliderContent", getSchemaId(), getLabel(), min, max, tickFrequency);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withDefaultValue", defaultValue);
        CodeGeneratorUtils.writeOptionalFunctionCall(stringBuilder, ".withWidth", width);
        return stringBuilder;
    }
}
