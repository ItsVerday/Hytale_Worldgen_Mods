package io.github.itsverday.renode.builder.input;

import io.github.itsverday.renode.builder.NodeVariantClass;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nullable;

public class VariantNodeInput extends AbstractNodeInput {
    private final NodeVariantClass variant;
    @Nullable
    private final Boolean multiple;

    public VariantNodeInput(NodeVariantClass variant, @Nullable Boolean multiple) {
        this.variant = variant;
        this.multiple = multiple;
    }

    @Override
    public String getType() {
        return "Connections.Variant." + variant.getName();
    }

    @NullableDecl
    @Override
    public String getColor() {
        return variant.getColor();
    }

    @Nullable
    @Override
    public Boolean getMultiple() {
        return multiple;
    }
}
