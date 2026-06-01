package io.github.itsverday.renode.scraper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger("Renode Scraper");

    static void main(String[] args) {
        if (args.length < 2) {
            logger.log(Level.INFO, "Exiting due to not enough arguments!");
            return;
        }

        String inputDirectory = args[0];
        String outputPath = args[1];
        StringBuilder output = new StringBuilder();

        Utils.walkPaths(Path.of(inputDirectory), path -> {
            if (path.getFileName().toString().equals("_Workspace.json")) {
                try {
                    Workspace workspace = new Workspace(path);
                    output.append(workspace.generateCode());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        try {
            Files.writeString(Path.of(outputPath), output.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
