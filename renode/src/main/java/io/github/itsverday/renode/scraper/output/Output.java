package io.github.itsverday.renode.scraper.output;

import io.github.itsverday.renode.scraper.Main;
import io.github.itsverday.renode.scraper.codegen.CodeGenerator;
import io.github.itsverday.renode.scraper.content.Content;
import org.bson.BsonDocument;
import org.bson.BsonValue;

import java.util.ArrayList;

public class Output implements CodeGenerator {
    private final String id;
    private final String type;
    private final String label;
    private final boolean multiple;
    private final ArrayList<Content> fields = new ArrayList<>();

    private OutputType outputType = null;
    private String schemaId = null;

    public Output(BsonDocument document) {
        id = document.getString("Id").getValue();
        type = document.getString("Type").getValue();
        if (document.containsKey("Label")) {
            label = document.getString("Label").getValue();
        } else {
            label = id;
        }

        if (document.containsKey("Multiple")) {
            multiple = document.getBoolean("Multiple").getValue();
        } else {
            multiple = false;
        }

        if (document.containsKey("Fields")) {
            for (BsonValue value: document.getArray("Fields")) {
                fields.add(Content.fromDocument(value.asDocument()));
            }
        }
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public ArrayList<Content> getFields() {
        return fields;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setOutputType(OutputType outputType) {
        this.outputType = outputType;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    @Override
    public StringBuilder generateCode() {
        if (outputType == null) Main.getLogger().warning("Output " + id + " has no type");
        return outputType.generateCode();
    }
}
