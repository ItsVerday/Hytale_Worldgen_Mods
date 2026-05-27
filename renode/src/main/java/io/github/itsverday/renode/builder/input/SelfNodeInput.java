package io.github.itsverday.renode.builder.input;

import io.github.itsverday.renode.builder.NodeBuilder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import javax.annotation.Nullable;

public class SelfNodeInput extends AbstractNodeInput {
    private final NodeBuilder self;
    @Nullable
    private final Boolean multiple;

    public SelfNodeInput(NodeBuilder self, @Nullable Boolean multiple) {
        this.self = self;
        this.multiple = multiple;
    }

    public NodeBuilder getSelf() {
        return self;
    }

    @NullableDecl
    @Override
    public String getColor() {
        return self.getColor();
    }

    @NullableDecl
    @Override
    public Boolean getMultiple() {
        return multiple;
    }

    @Override
    public String getType() {
        return "Connections.Node." + self.getId();
    }
}
