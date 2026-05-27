package io.github.itsverday.renode;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.asset.AssetModule;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.util.Config;
import io.github.itsverday.renode.builder.NodeRegistry;
import io.github.itsverday.renode.builder.workspace.NodeWorkspace;
import io.github.itsverday.renode.vanilla.HytaleGeneratorNodes;
import io.github.itsverday.renode.util.NodeConfigManager;
import io.github.itsverday.renode.vanilla.ScriptableBrushNodes;

import javax.annotation.Nonnull;
import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class RenodePlugin extends JavaPlugin {
    private static RenodePlugin instance = null;

    private final Config<RenodeConfiguration> config;
    private final static HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();
    private final NodeRegistry registry = new NodeRegistry();
    private static NodeConfigManager nodeConfigManager;
    private static List<NodeWorkspace> workspaces = null;

    public RenodePlugin(@Nonnull JavaPluginInit init) {
        super(init);
        instance = this;
        config = withConfig(RenodeConfiguration.CODEC);
    }

    @Override
    protected void setup() {
        HytaleGeneratorNodes.registerAllNodes();
        ScriptableBrushNodes.registerAllNodes();
        config.save();
    }

    @Override
    protected void start() {
        if (setupNodeConfigManager()) {
            workspaces = registry.buildWorkspaces();
            int configCount = 0;
            for (NodeWorkspace workspace: workspaces) {
                configCount += workspace.getConfigs((path, contents) -> {
                    if (!nodeConfigManager.saveFile(path, contents)) {
                        LOGGER.atWarning().log( "Failed to write node config %s!", path);
                        return false;
                    }

                    return true;
                });
            }

            LOGGER.atInfo().log("Created %s configs in %s workspaces.", configCount, workspaces.size());
        } else {
            LOGGER.atInfo().log("Could not setup config manager, skipping config creation");
        }
    }

    @Override
    protected void shutdown() {
        if (workspaces != null) {
            LOGGER.atInfo().log("Deleting workspaces...");
            for (NodeWorkspace workspace: workspaces) {
                if (!nodeConfigManager.removeFile(workspace.getWorkspaceId() + "/")) {
                    LOGGER.atWarning().log("Failed to delete workspace %s!", workspace.getWorkspaceId());
                }
            }

            workspaces = null;
        }

        registry.clear();
    }

    private boolean setupNodeConfigManager() {
        String hytaleHome = config.get().getHytaleHome();
        File workspacesDirectory = hytaleHome.isEmpty() ? getWorkspacesDirFromAssets() : getWorkspacesDirFromHome(hytaleHome);

        if (workspacesDirectory == null) return false;
        if (!workspacesDirectory.exists()) return false;

        nodeConfigManager = new NodeConfigManager(workspacesDirectory);
        return true;
    }

    private File getWorkspacesDirFromAssets() {
        Path assetsPath = AssetModule.get().getBaseAssetPack().getPackLocation();
        return new File(assetsPath.getParent().toFile(), "/Client/NodeEditor/Workspaces");
    }

    private File getWorkspacesDirFromHome(String homePath) {
        File home = new File(homePath);
        return null;
    }

    public static RenodePlugin getInstance() {
        return instance;
    }

    public NodeRegistry getRegistry() {
        return registry;
    }
}