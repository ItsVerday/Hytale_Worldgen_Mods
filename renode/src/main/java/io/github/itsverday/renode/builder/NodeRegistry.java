package io.github.itsverday.renode.builder;

import io.github.itsverday.renode.builder.root.AbstractNodeRoot;
import io.github.itsverday.renode.builder.workspace.NodeWorkspace;

import java.util.ArrayList;
import java.util.List;

public class NodeRegistry {
    private final List<NodeBuilder> nodes = new ArrayList<>();
    private final List<NodeVariantClass> variants = new ArrayList<>();
    private final List<NodeCategory> categories = new ArrayList<>();
    private final List<AbstractNodeRoot> roots = new ArrayList<>();

    public NodeRegistry registerNode(NodeBuilder node) {
        if (nodes.contains(node)) return this;
        nodes.add(node);
        return this;
    }

    public List<NodeBuilder> getNodes() {
        return nodes;
    }

    public NodeRegistry registerVariant(NodeVariantClass variant) {
        if (variants.contains(variant)) return this;
        variants.add(variant);
        return this;
    }

    public List<NodeVariantClass> getVariants() {
        return variants;
    }

    public NodeRegistry registerCategory(NodeCategory category) {
        if (categories.contains(category)) return this;
        categories.add(category);
        return this;
    }

    public List<NodeCategory> getCategories() {
        return categories;
    }

    public NodeRegistry registerRoot(AbstractNodeRoot root) {
        if (roots.contains(root)) return this;
        roots.add(root);
        return this;
    }

    public List<AbstractNodeRoot> getRoots() {
        return roots;
    }

    public void clear() {
        nodes.clear();
        variants.clear();
        categories.clear();
        roots.clear();
    }

    public List<NodeWorkspace> buildWorkspaces() {
        List<NodeWorkspace> workspaces = new ArrayList<>();
        for (AbstractNodeRoot root: roots) {
            NodeWorkspace workspace = new NodeWorkspace();
            workspace.addRoot(root, this);
            workspaces.add(workspace);
        }

        boolean merged;
        do {
            merged = false;
            for (int i = 0; i < workspaces.size() - 1; i++) {
                for (int j = i + 1; j < workspaces.size(); j++) {
                    if (workspaces.get(i).shouldMerge(workspaces.get(j))) {
                        workspaces.get(j).mergeInto(workspaces.get(i), this);
                        workspaces.remove(j);
                        merged = true;
                        break;
                    }
                }

                if (merged) break;
            }
        } while (merged);

        return workspaces;
    }
}
