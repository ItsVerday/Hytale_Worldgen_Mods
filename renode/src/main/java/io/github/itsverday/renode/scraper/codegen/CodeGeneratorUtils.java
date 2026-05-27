package io.github.itsverday.renode.scraper.codegen;

import io.github.itsverday.renode.scraper.Identified;

import javax.annotation.Nullable;

public class CodeGeneratorUtils {
    public static String escapeString(String s) {
        return s.replace("\\", "\\\\")
                .replace("\t", "\\t")
                .replace("\b", "\\b")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\f", "\\f")
                .replace("'", "\\'")
                .replace("\"", "\\\"");
    }

    public static String formatStringLiteral(String s) {
        return "\"" + escapeString(s) + "\"";
    }

    public static void writeStringLiteral(StringBuilder stringBuilder, String literal) {
        stringBuilder.append(formatStringLiteral(literal));
    }

    public static void writeIdentifier(StringBuilder stringBuilder, Identified identified) {
        stringBuilder.append(identified.getIdentifier());
    }

    public static void writeValue(StringBuilder stringBuilder, Object value) {
        if (value instanceof StringBuilder stringBuilder1) {
            stringBuilder.append(stringBuilder1);
            return;
        }

        if (value instanceof String string) {
            writeStringLiteral(stringBuilder, string);
            return;
        }

        if (value instanceof Identified identified) {
            writeIdentifier(stringBuilder, identified);
            return;
        }

        stringBuilder.append(value);
    }

    public static void writeFunctionCall(StringBuilder stringBuilder, String functionName, Object... parameters) {
        stringBuilder.append(functionName);
        stringBuilder.append("(");
        boolean first = true;
        for (Object parameter: parameters) {
            if (!first) stringBuilder.append(", ");
            first = false;

            writeValue(stringBuilder, parameter);
        }
        stringBuilder.append(")");
    }

    public static void writeFunctionCallArray(StringBuilder stringBuilder, String functionName, Object[] parameters) {
        writeFunctionCall(stringBuilder, functionName, parameters);
    }

    public static void writeOptionalFunctionCall(StringBuilder stringBuilder, String functionName, @Nullable Object parameter) {
        if (parameter == null) return;
        writeFunctionCall(stringBuilder, functionName, parameter);
    }

    public static void writeDeclaration(StringBuilder stringBuilder, String className, Identified identified, CodeGenerator codeGenerator) {
        stringBuilder.append("public static final ");
        stringBuilder.append(className);
        stringBuilder.append(" ");
        writeIdentifier(stringBuilder, identified);
        stringBuilder.append(" = ");
        stringBuilder.append(codeGenerator.generateCode());
        stringBuilder.append(";\n");
    }
}
