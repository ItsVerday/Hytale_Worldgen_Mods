package io.github.itsverday.renode.scraper.content;

import io.github.itsverday.renode.scraper.Main;
import io.github.itsverday.renode.scraper.Utils;
import io.github.itsverday.renode.scraper.codegen.CodeGenerator;
import io.github.itsverday.renode.scraper.content.type.*;
import io.github.itsverday.renode.scraper.content.type.*;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonValue;

import javax.annotation.Nullable;
import java.util.ArrayList;

public abstract class Content implements CodeGenerator {
    private final String id;
    private final String label;
    @Nullable
    private final String description;

    private String schemaId;

    public Content(String id, String label, @Nullable String description) {
        this.id = id;
        this.label = label;
        this.description = description;
        schemaId = id;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    public boolean containsId(String id) {
        return getId().equals(id);
    }

    @Nullable
    public static Content fromDocument(BsonDocument document) {
        String id = document.getString("Id").getValue();
        String type = document.getString("Type").getValue();

        BsonDocument options = document.getDocument("Options");

        String description = null;
        if (options.containsKey("Description")) {
            description = options.getString("Description").getValue();
        }
        String label = options.getString("Label").getValue();

        return switch (type) {
            case "Bool", "Checkbox" -> new CheckboxContent(id, label, description, Utils.getBooleanOrNull(options, "Default"));
            case "Enum" -> {
                ArrayList<String> values = new ArrayList<>();
                BsonArray valuesArray = Utils.getArrayOrNull(options, "Values");
                if (valuesArray != null) {
                    for (BsonValue value: valuesArray) {
                        values.add(value.asString().getValue());
                    }
                }

                yield new EnumContent(id, label, description, values.toArray(new String[0]), Utils.getStringOrNull(options, "Default"), Utils.getIntegerOrNull(options, "Width"));
            }
            case "Float" -> new FloatContent(id, label, description, Utils.getDoubleOrNull(options, "Default"), Utils.getIntegerOrNull(options, "Width"));
            case "Integer", "Int" -> new IntegerContent(id, label, description, Utils.getIntegerOrNull(options, "Default"), Utils.getIntegerOrNull(options, "Width"));
            case "IntSlider" -> new IntegerSliderContent(id, label, description, options.getInt32("Min").getValue(), options.getInt32("Max").getValue(), options.getInt32("TickFrequency").getValue(), Utils.getIntegerOrNull(options, "Default"), Utils.getIntegerOrNull(options, "Width"));
            case "List" -> new ListContent(id, label, description, options.containsKey("Type") ? options.getString("Type").getValue() : options.getString("ArrayElementType").getValue(), Utils.getIntegerOrNull(options, "Width"));
            case "Object" -> {
                ArrayList<Content> fields = new ArrayList<>();
                for (BsonValue value: options.getArray("Fields")) {
                    fields.add(Content.fromDocument(value.asDocument()));
                }

                yield new ObjectContent(id, label, description, fields);
            }
            case "SmallString" -> new SmallStringContent(id, label, description, Utils.getStringOrNull(options, "Default"), Utils.getIntegerOrNull(options, "Width"));
            case "String" -> new StringContent(id, label, description, Utils.getStringOrNull(options, "Default"), Utils.getIntegerOrNull(options, "Width"), Utils.getIntegerOrNull(options, "Height"));
            default -> {
                Main.getLogger().warning("Unknown Content with type " + type + "!");
                yield null;
            }
        };
    }
}
