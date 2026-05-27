package io.github.itsverday.renode.builder.output;

import io.github.itsverday.renode.builder.NodeBuilder;

import javax.annotation.Nullable;
import java.util.List;

public abstract class AbstractNodeOutput {
    public abstract String getId();
    public abstract String getType();
    public abstract String getColor();
    public abstract String getNode();
    public abstract String getLabel();

    @Nullable
    public abstract Boolean getMultiple();
    @Nullable
    public abstract Boolean getIsMap();

    public abstract List<NodeBuilder> getPossibleChildren();
    public abstract void ensureNodeInputs();
}
