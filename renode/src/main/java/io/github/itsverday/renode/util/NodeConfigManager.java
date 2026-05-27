package io.github.itsverday.renode.util;

import java.io.File;
import java.nio.file.Files;

public class NodeConfigManager {
    private final File directory;

    public NodeConfigManager(File directory) {
        this.directory = directory;
    }

    public File getDirectory() {
        return directory;
    }

    public boolean saveFile(String path, String contents) {
        try {
            File file = new File(getDirectory(), path);
            file.getParentFile().mkdirs();
            Files.writeString(file.toPath(), contents);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeFile(String path) {
        return removeFile(new File(getDirectory(), path));
    }

    private boolean removeFile(File file) {
        try {
            if (!file.exists()) return true;

            if (file.isDirectory()) {
                File[] paths = file.listFiles();
                if (paths == null) return false;

                for (File subFile: paths) {
                    if (Files.isSymbolicLink(subFile.toPath())) continue;
                    if (!removeFile(subFile)) return false;
                }
            }

            file.delete();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
