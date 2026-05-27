package io.github.itsverday.renode.scraper.root;

import io.github.itsverday.renode.scraper.Identified;
import io.github.itsverday.renode.scraper.Utils;
import io.github.itsverday.renode.scraper.codegen.CodeGenerator;

public abstract class Root implements Identified, CodeGenerator {
    private final String menuName;

    public Root(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    @Override
    public String getIdentifier() {
        return Utils.fixIdentifier(menuName, "ROOT_");
    }
}
