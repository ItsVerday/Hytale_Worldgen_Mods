package io.github.itsverday.renode.builder.input;

import javax.annotation.Nullable;

public abstract class AbstractNodeInput {
    public abstract String getType();

    @Nullable
    public abstract String getColor();

    @Nullable
    public abstract Boolean getMultiple();
}
