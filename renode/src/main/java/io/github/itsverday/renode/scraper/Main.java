package io.github.itsverday.renode.scraper;

import java.io.File;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger("Renode Scraper");

    static void main(String[] args) {
        if (args.length < 1) {
            return;
        }

        String inputDirectory = args[0];
        Utils.walkFiles(new File(inputDirectory), file -> {
            if (file.getName().equals("_Workspace.json")) {
                try {
                    Workspace workspace = new Workspace(file);
                    System.out.println(workspace.generateCode());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public static Logger getLogger() {
        return logger;
    }
}
