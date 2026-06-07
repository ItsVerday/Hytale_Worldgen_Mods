package io.github.itsverday.renode.export;

import io.github.itsverday.renode.RenodePlugin;
import io.github.itsverday.renode.builder.workspace.NodeWorkspace;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileSystemWorkspaceExporter extends WorkspaceExporter {
    private final Path rootFolder;

    public FileSystemWorkspaceExporter(String name, Path rootFolder) {
        super(name);
        this.rootFolder = rootFolder;
    }

    public Path getRootFolder() {
        return rootFolder;
    }

    @Override
    public boolean exportConfig(NodeWorkspace workspace, String configName, String configContents) {
        try {
            Path targetFolder = rootFolder.resolve(workspace.getWorkspaceId());
            Path targetFile = targetFolder.resolve(configName);
            Files.createDirectories(targetFolder);
            Files.writeString(targetFile, configContents);
        } catch (Exception e) {
            RenodePlugin.getInstance().getLogger().atWarning().withCause(e).log( "Failed to write node config '%s/%s'!", workspace.getWorkspaceId(), configName);
            return false;
        }

        return true;
    }

    @Override
    public void clear() {
        for (NodeWorkspace workspace: getWorkspaces()) {
            Path targetFolder = rootFolder.resolve(workspace.getWorkspaceId());
            if (!delete(targetFolder)) {
                RenodePlugin.getInstance().getLogger().atWarning().log("Failed to delete workspace %s!", workspace.getWorkspaceId());
            }
        }
    }

    private boolean delete(Path path) {
        try {
            if (!Files.exists(path)) return true;

            boolean success = true;
            if (Files.isDirectory(path)) {
                try (Stream<Path> childrenPaths = Files.list(path)) {
                    for (Path childPath: childrenPaths.toList()) {
                        if (Files.isSymbolicLink(childPath)) continue;
                        if (!delete(childPath)) {
                            success = false;
                        }
                    }
                }
            }

            Files.delete(path);
            return success;
        } catch (Exception e) {
            RenodePlugin.getInstance().getLogger().atWarning().withCause(e).log("Failed to delete file at path '%s'!", path);
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FileSystemWorkspaceExporter other) {
            return getRootFolder().equals(other.getRootFolder());
        }

        return false;
    }
}
