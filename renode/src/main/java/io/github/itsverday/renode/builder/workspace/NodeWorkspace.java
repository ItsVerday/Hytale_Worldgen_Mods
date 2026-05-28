package io.github.itsverday.renode.builder.workspace;

import io.github.itsverday.renode.builder.NodeBuilder;
import io.github.itsverday.renode.builder.NodeCategory;
import io.github.itsverday.renode.builder.NodeRegistry;
import io.github.itsverday.renode.builder.output.AbstractNodeOutput;
import io.github.itsverday.renode.builder.root.AbstractNodeRoot;
import io.github.itsverday.renode.builder.NodeVariantClass;
import io.github.itsverday.renode.definition.BsonEncodable;
import org.bson.*;
import org.bson.json.JsonWriterSettings;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.BiFunction;

public class NodeWorkspace extends BsonEncodable {
    private final List<NodeBuilder> nodes = new ArrayList<>();
    private final List<NodeVariantClass> variants = new ArrayList<>();
    private final List<NodeCategory> categories = new ArrayList<>();
    private final List<AbstractNodeRoot> roots = new ArrayList<>();
    private String workspaceId;

    public List<NodeBuilder> getNodes() {
        return nodes;
    }

    public void addNode(NodeBuilder node, NodeRegistry registry) {
        if (!registry.getNodes().contains(node)) return;
        if (nodes.contains(node)) return;

        nodes.add(node);
        if (node.getVariant() != null) addVariant(node.getVariant(), registry);
        for (NodeCategory category: node.getCategories()) {
            addCategory(category, registry);
        }

        for (AbstractNodeOutput output: node.getOutputs()) {
            for (NodeBuilder child: output.getPossibleChildren()) {
                addNode(child, registry);
            }
        }
    }

    public List<NodeVariantClass> getVariants() {
        return variants;
    }

    public void addVariant(NodeVariantClass variant, NodeRegistry registry) {
        if (!registry.getVariants().contains(variant)) return;
        if (variants.contains(variant)) return;

        variants.add(variant);
        for (NodeBuilder variantNode: variant.getVariantTypes().values()) {
            addNode(variantNode, registry);
        }
    }

    public List<NodeCategory> getCategories() {
        return categories;
    }

    public void addCategory(NodeCategory category, NodeRegistry registry) {
        if (!registry.getCategories().contains(category)) return;
        if (categories.contains(category)) return;

        categories.add(category);
    }

    public List<AbstractNodeRoot> getRoots() {
        return roots;
    }

    public void addRoot(AbstractNodeRoot root, NodeRegistry registry) {
        if (!registry.getRoots().contains(root)) return;
        if (roots.contains(root)) return;

        roots.add(root);
        for (NodeBuilder node: root.getPossibleNodes()) {
            addNode(node, registry);
        }
    }

    public String getWorkspaceId() {
        if (workspaceId == null) {
            String chars = "abcdef1234567890";
            StringBuilder id = new StringBuilder();
            Random rnd = new Random();
            while (id.length() < 8) { // length of the random string.
                int index = (int) (rnd.nextFloat() * chars.length());
                id.append(chars.charAt(index));
            }

            workspaceId = id.toString();
        }

        return "Renode-" + workspaceId;
    }

    public boolean shouldMerge(NodeWorkspace other) {
        for (NodeBuilder node: getNodes()) {
            if (other.getNodes().contains(node)) return true;
        }

        return false;
    }

    public void mergeInto(NodeWorkspace into, NodeRegistry registry) {
        for (AbstractNodeRoot root: getRoots()) into.addRoot(root, registry);
        for (NodeVariantClass variant: getVariants()) into.addVariant(variant, registry);
        for (NodeBuilder node: getNodes()) into.addNode(node, registry);
        for (NodeCategory category: getCategories()) into.addCategory(category, registry);
    }

    private BsonDocument encodeRoots() {
        BsonDocument document = new BsonDocument();
        for (AbstractNodeRoot root: getRoots()) {
            BsonDocument rootEntry = new BsonDocument();
            rootEntry.put("RootNodeType", new BsonString(root.getRootNodeType()));
            rootEntry.put("MenuName", new BsonString(String.format("%s (Renode)", root.getName())));
            document.put(root.getName(), rootEntry);
        }

        return document;
    }

    private BsonDocument encodeNodeCategories() {
        BsonDocument document = new BsonDocument();
        for (NodeCategory category: getCategories()) {
            BsonArray categoryList = new BsonArray();
            for (NodeBuilder node: getNodes()) {
                boolean hasCategory = false;
                for (NodeCategory nodeCategory: node.getCategories()) {
                    if (category.equals(nodeCategory)) {
                        hasCategory = true;
                        break;
                    }
                }

                if (!hasCategory) continue;
                if (!getNodes().contains(node)) continue;
                categoryList.add(new BsonString(node.getId()));
            }

            document.put(category.getTitle(), categoryList);
        }

        return document;
    }

    private BsonDocument encodeVariants() {
        BsonDocument variants = new BsonDocument();
        for (NodeVariantClass variant: getVariants()) {
            variants.put("Variants." + variant.getName(), variant.encode(this));
        }

        return variants;
    }

    @Override
    public BsonValue encode() {
        BsonDocument document = new BsonDocument();
        document.put("WorkspaceName", new BsonString(String.format("Renode (%s)", getWorkspaceId())));
        document.put("ExportDefaults", new BsonBoolean(true));
        document.put("Roots", encodeRoots());
        document.put("NodeCategories", encodeNodeCategories());
        document.put("Variants", encodeVariants());
        return document;
    }

    public HashMap<String, String> getConfigs() {
        return getConfigs(JsonWriterSettings.builder().indent(true).build());
    }

    public HashMap<String, String> getConfigs(JsonWriterSettings settings) {
        for (NodeBuilder node: getNodes()) {
            node.preBuild();
        }

        HashMap<String, String> configs = new HashMap<>();
        configs.put("_Workspace.json", encodeAsDocument().toJson(settings));
        for (NodeBuilder node: getNodes()) {
            configs.put(String.format("%s.json", node.getId()), node.build().encodeAsDocument().toJson(settings));
        }

        return configs;
    }
}
