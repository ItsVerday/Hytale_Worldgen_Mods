package io.github.itsverday.renode.scraper.content.type;

import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.content.Content;

import java.util.ArrayList;
import java.util.List;

public class ObjectContent extends Content {
    private final List<Content> fields = new ArrayList<>();

    public ObjectContent(String id, String label, List<Content> fields) {
        super(id, label);
        this.fields.addAll(fields);
    }

    @Override
    public boolean containsId(String id) {
        if (super.containsId(id)) return true;

        for (Content field: fields) {
            if (field.containsId(id)) return true;
        }

        return false;
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        CodeGeneratorUtils.writeFunctionCall(stringBuilder, "Renode.objectContent", getSchemaId(), getLabel());
        ArrayList<StringBuilder> fields = new ArrayList<>();
        for (Content content: this.fields) {
            fields.add(content.generateCode());
        }

        CodeGeneratorUtils.writeFunctionCallArray(stringBuilder, ".withFields", fields.toArray());
        return stringBuilder;
    }
}
