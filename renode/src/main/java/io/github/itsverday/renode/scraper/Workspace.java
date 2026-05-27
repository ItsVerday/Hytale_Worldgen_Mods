package io.github.itsverday.renode.scraper;

import io.github.itsverday.renode.scraper.codegen.CodeGenerator;
import io.github.itsverday.renode.scraper.codegen.CodeGeneratorUtils;
import io.github.itsverday.renode.scraper.node.Node;
import io.github.itsverday.renode.scraper.node.init.VariantNodeInit;
import io.github.itsverday.renode.scraper.output.Output;
import io.github.itsverday.renode.scraper.output.type.NodeOutputType;
import io.github.itsverday.renode.scraper.output.type.VariantOutputType;
import io.github.itsverday.renode.scraper.root.Root;
import io.github.itsverday.renode.scraper.root.SingleNodeRoot;
import io.github.itsverday.renode.scraper.root.VariantRoot;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonValue;

import javax.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;

public class Workspace implements CodeGenerator {
    private final BsonDocument workspaceDocument;
    private final ArrayList<Node> nodes = new ArrayList<>();
    private final ArrayList<Category> categories = new ArrayList<>();
    private final ArrayList<Variant> variants = new ArrayList<>();
    private final ArrayList<Root> roots = new ArrayList<>();

    public Workspace(File workspaceFile) throws Exception {
        try {
            workspaceDocument = Utils.readJsonFile(workspaceFile);
        } catch (Exception exception) {
            throw new Exception("Error initializing Workspace " + workspaceFile, exception);
        }

        Utils.walkFiles(workspaceFile.getParentFile(), nodeFile -> {
            if (workspaceFile.equals(nodeFile)) return;
            try {
                BsonDocument document = Utils.readJsonFile(nodeFile);
                Node node = new Node(document);
                nodes.add(node);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        processNodeCategories();
        processNodeVariants();
        processRoots();
        processNodeOutputs();
    }

    @Nullable
    private Node findNode(String id) {
        for (Node node: nodes) {
            if (node.getId().equals(id)) {
                return node;
            }
        }

        return null;
    }

    private void processNodeCategories() {
        if (workspaceDocument.containsKey("NodeCategories")) {
            BsonDocument document = workspaceDocument.getDocument("NodeCategories");
            for (String categoryName: document.keySet()) {
                Category category = new Category(categoryName);
                categories.add(category);
                BsonArray categoryNodes = document.getArray(categoryName);
                for (BsonValue value: categoryNodes) {
                    Node nodeInCategory = findNode(value.asString().getValue());
                    if (nodeInCategory != null) category.addNode(nodeInCategory);
                }
            }
        }
    }

    private void processNodeVariants() {
        if (workspaceDocument.containsKey("Variants")) {
            BsonDocument variantsDocument = workspaceDocument.getDocument("Variants");
            for (String variantId: variantsDocument.keySet()) {
                Variant variant = new Variant(variantId);
                variants.add(variant);
                BsonDocument variantDocument = variantsDocument.getDocument(variantId);
                BsonDocument variantNames = variantDocument.getDocument("Variants");
                for (String variantName: variantNames.keySet()) {
                    Node node = findNode(variantNames.get(variantName).asString().getValue());
                    if (node != null) {
                        variant.addNode(variantName, node);
                        node.setNodeInit(new VariantNodeInit(node, variant, variantName));
                    }
                }
            }
        }
    }

    private void processRoots() {
        if (workspaceDocument.containsKey("Roots")) {
            BsonDocument rootsDocument = workspaceDocument.getDocument("Roots");
            for (String rootId: rootsDocument.keySet()) {
                BsonDocument rootDocument = rootsDocument.getDocument(rootId);
                String menuName = rootDocument.getString("MenuName").getValue();
                String rootNodeType = rootDocument.getString("RootNodeType").getValue();
                Root root = null;
                for (Node node: nodes) {
                    if (rootNodeType.equals(node.getId())) {
                        root = new SingleNodeRoot(menuName, node);
                    }
                }

                for (Variant variant: variants) {
                    if (rootNodeType.equals(variant.getId())) {
                        root = new VariantRoot(menuName, variant);
                    }
                }

                if (root != null) roots.add(root);
            }
        }
    }

    private void processNodeOutputs() {
        for (Node node: nodes) {
            for (Output output: node.getOutputs()) {
                String outputType = output.getType();

                for (Node outputNode: nodes) {
                    for (String inputType: outputNode.getInputTypes()) {
                        if (outputType.equals(inputType)) {
                            output.setOutputType(new NodeOutputType(output, outputNode));
                        }
                    }
                }

                for (Variant outputVariant: variants) {
                    if (outputType.equals(outputVariant.getInputType())) {
                        output.setOutputType(new VariantOutputType(output, outputVariant));
                    }
                }
            }
        }
    }

    @Override
    public StringBuilder generateCode() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Category category: categories) {
            CodeGeneratorUtils.writeDeclaration(stringBuilder, "NodeCategory", category, category);
        }

        stringBuilder.append("\n");

        for (Variant variant: variants) {
            CodeGeneratorUtils.writeDeclaration(stringBuilder, "NodeVariantClass", variant, variant);
        }

        stringBuilder.append("\n");

        for (Node node: nodes) {
            CodeGeneratorUtils.writeDeclaration(stringBuilder, "NodeBuilder", node, node);
        }

        stringBuilder.append("\n");

        for (Root root: roots) {
            CodeGeneratorUtils.writeDeclaration(stringBuilder, "AbstractNodeRoot", root, root);
        }

        return stringBuilder;
    }
}
