package io.github.itsverday.renode;

import com.hypixel.hytale.common.util.java.ManifestUtil;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.asset.AssetModule;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.util.Config;
import io.github.itsverday.renode.builder.NodeRegistry;
import io.github.itsverday.renode.builder.Renode;
import io.github.itsverday.renode.builder.workspace.NodeWorkspace;
import io.github.itsverday.renode.export.FileSystemWorkspaceExporter;
import io.github.itsverday.renode.export.WorkspaceExporter;
import io.github.itsverday.renode.vanilla.HytaleGeneratorNodes;
import io.github.itsverday.renode.vanilla.ScriptableBrushNodes;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RenodePlugin extends JavaPlugin {
    private static RenodePlugin instance = null;

    private final Config<RenodeConfiguration> config;
    private final static HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();
    private final NodeRegistry registry = new NodeRegistry();
    private static List<NodeWorkspace> workspaces = null;
    private final List<WorkspaceExporter> exporters = new ArrayList<>();

    public RenodePlugin(@Nonnull JavaPluginInit init) {
        super(init);
        instance = this;
        config = withConfig(RenodeConfiguration.CODEC);
    }

    @Override
    protected void setup() {
        HytaleGeneratorNodes.registerAllNodes();
        ScriptableBrushNodes.registerAllNodes();
        config.save().thenRun(() -> LOGGER.atInfo().log("Config file saved."));

        registerDefaultExporters();
    }

    @Override
    protected void start() {
        workspaces = registry.buildWorkspaces();

        if (!exporters.isEmpty()) {
            for (WorkspaceExporter exporter: exporters) {
                for (NodeWorkspace workspace: workspaces) {
                    exporter.addWorkspace(workspace);
                }

                exporter.run();
            }
        } else {
            LOGGER.atInfo().log("Skipping config creation since no exporters could be created.");
        }
    }

    @Override
    protected void shutdown() {
        for (WorkspaceExporter exporter: exporters) {
            exporter.clear();
        }

        registry.clear();
        exporters.clear();
    }

    private void registerDefaultExporters() {
        if (config.get().isUseAssetsPath()) {
            Path assetsPath = AssetModule.get().getBaseAssetPack().getPackLocation();
            Path workspacesPath = assetsPath.getParent().resolve("Client").resolve("NodeEditor").resolve("Workspaces");
            if (Files.exists(workspacesPath)) {
                Renode.registerExporter(new FileSystemWorkspaceExporter("AssetsPath", workspacesPath));
            }
        }

        String patchline = ManifestUtil.getPatchline();
        String version = ManifestUtil.getVersion();

        if (patchline != null && version != null) {
            int index = 1;
            for (String hytaleHome: config.get().getHytaleHomes()) {
                Path hytaleHomePath = Path.of(hytaleHome);
                Path gamePath = hytaleHomePath.resolve("install").resolve(patchline).resolve("package").resolve("game");
                Path gameVersionPath = gamePath.resolve(version);
                if (!Files.exists(gameVersionPath)) {
                    gameVersionPath = gamePath.resolve("latest");
                }

                Path workspacesPath = gameVersionPath.resolve("Client").resolve("NodeEditor").resolve("Workspaces");
                if (Files.exists(workspacesPath)) {
                    Renode.registerExporter(new FileSystemWorkspaceExporter("HytaleHome(" + index + ")", workspacesPath));
                }

                index++;
            }
        }
    }

    public static RenodePlugin getInstance() {
        return instance;
    }

    public NodeRegistry getRegistry() {
        return registry;
    }

    public List<WorkspaceExporter> getExporters() {
        return exporters;
    }

    @NonNullDecl
    @Override
    public HytaleLogger getLogger() {
        return LOGGER;
    }
}