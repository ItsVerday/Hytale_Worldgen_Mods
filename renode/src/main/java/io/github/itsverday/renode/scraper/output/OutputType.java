package io.github.itsverday.renode.scraper.output;

import io.github.itsverday.renode.scraper.codegen.CodeGenerator;

public abstract class OutputType implements CodeGenerator {
    private final Output output;

    public OutputType(Output output) {
        this.output = output;
    }

    public Output getOutput() {
        return output;
    }
}
