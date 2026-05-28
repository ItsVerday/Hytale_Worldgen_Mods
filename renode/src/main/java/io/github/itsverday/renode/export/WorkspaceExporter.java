package io.github.itsverday.renode.export;

import io.github.itsverday.renode.RenodePlugin;
import io.github.itsverday.renode.builder.workspace.NodeWorkspace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class WorkspaceExporter {
    private final String name;
    private final List<NodeWorkspace> workspaces = new ArrayList<>();

    public WorkspaceExporter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<NodeWorkspace> getWorkspaces() {
        return workspaces;
    }

    public void addWorkspace(NodeWorkspace workspace) {
        workspaces.add(workspace);
        workspaceAdded(workspace);
    }

    public void workspaceAdded(NodeWorkspace workspace) {}

    public void run() {
        int workspaceCount = 0;
        int configCount = 0;

        for (NodeWorkspace workspace: getWorkspaces()) {
            HashMap<String, String> configs = workspace.getConfigs();

            boolean workspaceSaved = false;
            for (String configName: configs.keySet()) {
                if (exportConfig(workspace, configName, configs.get(configName))) {
                    configCount++;
                    workspaceSaved = true;
                }
            }

            if (workspaceSaved) workspaceCount++;
        }

        RenodePlugin.getInstance().getLogger().atInfo().log("Workspace Exporter %s: Created %s configs in %s workspaces!", getName(), configCount, workspaceCount);
    }

    public abstract boolean exportConfig(NodeWorkspace workspace, String configName, String configContents);
    public abstract void clear();
}
