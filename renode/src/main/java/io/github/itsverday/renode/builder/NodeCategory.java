package io.github.itsverday.renode.builder;

import javax.annotation.Nullable;

public class NodeCategory {
    private final String title;
    private final String color;

    public NodeCategory(String title, @Nullable String color) {
        this.title = title;
        if (color != null && !color.isEmpty()) {
            this.color = color;
        } else {
            this.color = null;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return color;
    }
}
