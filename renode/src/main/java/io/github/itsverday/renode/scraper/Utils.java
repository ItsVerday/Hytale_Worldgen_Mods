package io.github.itsverday.renode.scraper;

import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonValue;

import javax.annotation.Nullable;
import java.io.File;
import java.nio.file.Files;
import java.util.function.Consumer;
import java.util.function.Function;

public class Utils {
    public static void walkFiles(File file, Consumer<File> consumer) {
        try {
            if (file.isDirectory()) {
                File[] subFiles = file.listFiles();
                if (subFiles == null) return;

                for (File subFile: subFiles) {
                    walkFiles(subFile, consumer);
                }
            } else {
                consumer.accept(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String fixIdentifier(String identifier, String prefix) {
        return (prefix + identifier).replaceAll("[^A-Za-z0-9_]", "").toUpperCase();
    }

    public static BsonDocument readJsonFile(File file) throws Exception {
        try {
            String contents = Files.readString(file.toPath()).trim();
            // Trim JSON input to first "{" character. Fixes a weird parsing error from the Node Configs.
            contents = contents.substring(contents.indexOf("{"));
            return BsonDocument.parse(contents);
        } catch (Exception exception) {
            throw new Exception("Error reading file " + file, exception);
        }
    }

    @Nullable
    public static <R> R getOrNull(BsonDocument document, String key, Function<BsonValue, R> getValue) {
        if (!document.containsKey(key)) return null;
        return getValue.apply(document.get(key));
    }

    @Nullable
    public static Boolean getBooleanOrNull(BsonDocument document, String key) {
        return getOrNull(document, key, value -> switch (value.getBsonType()) {
            case BOOLEAN -> value.asBoolean().getValue();
            case STRING -> Boolean.parseBoolean(value.asString().getValue());
            default -> null;
        });
    }

    @Nullable
    public static String getStringOrNull(BsonDocument document, String key) {
        return getOrNull(document, key, value -> switch (value.getBsonType()) {
            case STRING -> value.asString().getValue();
            default -> null;
        });
    }

    @Nullable
    public static Integer getIntegerOrNull(BsonDocument document, String key) {
        return getOrNull(document, key, value -> switch (value.getBsonType()) {
            case INT32 -> value.asInt32().getValue();
            case INT64 -> (int) value.asInt64().getValue();
            case DOUBLE -> (int) value.asDouble().getValue();
            case STRING -> Integer.parseInt(value.asString().getValue());
            default -> null;
        });
    }

    @Nullable
    public static Double getDoubleOrNull(BsonDocument document, String key) {
        return getOrNull(document, key, value -> switch (value.getBsonType()) {
            case DOUBLE -> value.asDouble().getValue();
            case INT32 -> (double) value.asInt32().getValue();
            case INT64 -> (double) value.asInt64().getValue();
            case STRING -> Double.parseDouble(value.asString().getValue());
            default -> null;
        });
    }

    @Nullable
    public static BsonArray getArrayOrNull(BsonDocument document, String key) {
        return getOrNull(document, key, value -> switch (value.getBsonType()) {
            case ARRAY -> value.asArray();
            default -> null;
        });
    }
}
