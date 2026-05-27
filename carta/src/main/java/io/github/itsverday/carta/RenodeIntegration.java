package io.github.itsverday.carta;

import com.hypixel.hytale.server.core.asset.type.blocktype.config.Rotation;
import io.github.itsverday.carta.hytalegenerator.biomeproviders.nodes.ImageMap2DBiomeProvider;
import io.github.itsverday.renode.builder.NodeBuilder;
import io.github.itsverday.renode.builder.NodeCategory;
import io.github.itsverday.renode.builder.NodeVariantClass;
import io.github.itsverday.renode.builder.Renode;
import io.github.itsverday.renode.builder.root.AbstractNodeRoot;
import io.github.itsverday.renode.vanilla.HytaleGeneratorNodes;

import java.util.ArrayList;
import java.util.List;

public class RenodeIntegration {
    private static final List<NodeBuilder> nodes = new ArrayList<>();
    private static final List<NodeVariantClass> variants = new ArrayList<>();
    private static final List<NodeCategory> categories = new ArrayList<>();
    private static final List<AbstractNodeRoot> roots = new ArrayList<>();

    public static final NodeCategory CATEGORY_BIOME_PROVIDERS = addCategory(Renode.category("Biome Providers", "27,150,62"));
    public static final NodeVariantClass VARIANT_BIOME_PROVIDERS = addVariant(Renode.variant("BiomeProvider", "27,150,62"));
    public static final NodeVariantClass VARIANT_BIOME_PROVIDER_CONDITIONS = addVariant(Renode.variant("BiomeProviderConditions", "230,199,28"));
    public static final NodeVariantClass VARIANT_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPES = addVariant(Renode.variant("PositionCellsBiomeProviderCellType", "27,168,138"));

    public static final NodeBuilder NODE_BIOME_PROVIDER_ANCHOR = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Anchor", "Anchor BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.checkboxContent("Reversed", "Reversed").withDefaultValue(false))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CACHED = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Cached", "Cached BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITIONAL = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Conditional", "Conditional BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addVariantOutput("Condition", "Condition", false, VARIANT_BIOME_PROVIDER_CONDITIONS)
            .addVariantOutput("IfTrue", "IfTrue", false, VARIANT_BIOME_PROVIDERS)
            .addVariantOutput("IfFalse", "IfFalse", false, VARIANT_BIOME_PROVIDERS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_ADJACENT = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Adjacent", "Adjacent BiomeProviderCondition"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDER_CONDITIONS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_AND = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("And", "And BiomeProviderCondition"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_BIOME_PROVIDER_CONDITIONS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_DENSITY_DISTANCE = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("DensityDistance", "DensityDistance BiomeProviderCondition"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("MinDistance", "MinDistance").withDefaultValue(0.0).withWidth(50))
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(0.0).withWidth(50))
            .addVariantOutput("Density", "Density", false, HytaleGeneratorNodes.VARIANT_DENSITY)
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDER_CONDITIONS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_DISTANCE = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Distance", "Distance BiomeProviderCondition"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Distance", "Distance").withDefaultValue(1.0).withWidth(50))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDER_CONDITIONS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_FIELD_FUNCTION = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("FieldFunction", "FieldFunction BiomeProviderCondition"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Minimum", "From").withDefaultValue(0.0).withWidth(200))
            .addContent(Renode.floatContent("Maximum", "To").withDefaultValue(0.0).withWidth(200))
            .addVariantOutput("Density", "Density", false, HytaleGeneratorNodes.VARIANT_DENSITY)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_IMPORTED = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Imported", "Imported BiomeProviderCondition"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(250))
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_NOT = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Not", "Not BiomeProviderCondition"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDER_CONDITIONS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_OFFSET = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Offset", "Offset BiomeProviderCondition"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("OffsetX", "OffsetX").withDefaultValue(0.0).withWidth(200))
            .addContent(Renode.floatContent("OffsetZ", "OffsetZ").withDefaultValue(0.0).withWidth(200))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDER_CONDITIONS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_OR = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Or", "Or BiomeProviderCondition"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_BIOME_PROVIDER_CONDITIONS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_SUM_RANGE = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("SumRange", "SumRange BiomeProviderCondition"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addContent(Renode.integerContent("Minimum", "Minimum").withDefaultValue(0).withWidth(50))
            .addContent(Renode.integerContent("Maximum", "Maximum").withDefaultValue(0).withWidth(50))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_BIOME_PROVIDER_CONDITIONS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_VALUE = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Value", "Value BiomeProviderCondition"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addContent(Renode.smallStringContent("Biome", "Biome").withDefaultValue("").withWidth(200))
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_VALUES = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Values", "Values BiomeProviderCondition"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addContent(Renode.listContent("Biomes", "Biomes", "String"))
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONSTANT = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Constant", "Constant BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Biome", "Biome").withDefaultValue("").withWidth(200))
            .addNodeOutput("DebugMaterial", "DebugMaterial", false, HytaleGeneratorNodes.NODE_MATERIAL)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_FIELD_FUNCTION = addNode(VARIANT_BIOME_PROVIDERS.variantNode("FieldFunction", "FieldFunction BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addVariantOutput("Density", "Density", false, HytaleGeneratorNodes.VARIANT_DENSITY)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> RenodeIntegration.NODE_BIOME_PROVIDER_FIELD_FUNCTION_DELIMITER)
            .addVariantOutput("Fallback", "Fallback", false, VARIANT_BIOME_PROVIDERS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_FIELD_FUNCTION_DELIMITER = addNode(Renode.node("BiomeProvider.FieldFunction.Delimiter", "FFBP Delimiter"))
            .addContent(Renode.floatContent("Minimum", "From").withDefaultValue(0.0).withWidth(200))
            .addContent(Renode.floatContent("Maximum", "To").withDefaultValue(0.0).withWidth(200))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .withColorOverride("27,168,138")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_GRADIENT_WARP = addNode(VARIANT_BIOME_PROVIDERS.variantNode("GradientWarp", "GradientWarp BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("SampleDistance", "SampleDistance").withDefaultValue(1.0).withWidth(50))
            .addContent(Renode.floatContent("WarpFactor", "WarpFactor").withDefaultValue(1.0).withWidth(50))
            .addContent(Renode.checkboxContent("Rounding", "GridAlign").withDefaultValue(false))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addVariantOutput("Density", "WarpField", false, HytaleGeneratorNodes.VARIANT_DENSITY)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_IMAGE_MAP = addNode(VARIANT_BIOME_PROVIDERS.variantNode("ImageMap", "ImageMap BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Path", "Path").withDefaultValue("").withWidth(250))
            .addContent(Renode.floatContent("CenterX", "CenterX").withDefaultValue(0.0).withWidth(250))
            .addContent(Renode.floatContent("CenterZ", "CenterZ").withDefaultValue(0.0).withWidth(250))
            .addContent(Renode.floatContent("Scale", "Scale").withDefaultValue(0.0).withWidth(50))
            .addContent(Renode.checkboxContent("Flip", "Flip").withDefaultValue(false))
            .addContent(Renode.enumContent("Rotation", "Rotation").withEnumValues(Rotation.VALUES).withDefaultValue("None"))
            .addContent(Renode.enumContent("EdgeType", "EdgeType").withEnumValues(ImageMap2DBiomeProvider.EdgeType.values()).withDefaultValue("Exclude"))
            .addNodeOutput("Biomes", "Biomes", true, () -> RenodeIntegration.NODE_BIOME_PROVIDER_IMAGE_MAP_BIOME)
            .addVariantOutput("Fallback", "Fallback", false, VARIANT_BIOME_PROVIDERS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_IMAGE_MAP_BIOME = addNode(Renode.node("BiomeProvider.ImageMap.Biome", "IMBP Biome"))
            .addContent(Renode.smallStringContent("Color", "Color").withDefaultValue("#000000").withWidth(200))
            .addContent(Renode.floatContent("Tolerance", "Tolerance").withDefaultValue(0.0).withWidth(50))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS).withColorOverride("27,168,138")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_IMPORTED = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Imported", "Imported BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(250))
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_OFFSET = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Offset", "Offset BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("OffsetX", "OffsetX").withDefaultValue(0.0).withWidth(200))
            .addContent(Renode.floatContent("OffsetZ", "OffsetZ").withDefaultValue(0.0).withWidth(200))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITION_CELLS = addNode(VARIANT_BIOME_PROVIDERS.variantNode("PositionCells", "PositionCells BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(200))
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(32.0).withWidth(50))
            .addContent(Renode.floatContent("DistanceWarpMin", "DistanceWarpMin").withDefaultValue(0.0).withWidth(50))
            .addContent(Renode.floatContent("DistanceWarpMax", "DistanceWarpMax").withDefaultValue(0.0).withWidth(50))
            .addVariantOutput("Positions", "Positions", false, HytaleGeneratorNodes.VARIANT_POSITIONS)
            .addVariantOutput("CellTypes", "CellTypes", true, VARIANT_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPES)
            .addVariantOutput("Fallback", "Fallback", false, VARIANT_BIOME_PROVIDERS)
            .addVariantOutput("DistanceWarpField", "DistanceWarpField", false, HytaleGeneratorNodes.VARIANT_DENSITY)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPE_DISTANCE_DELIMITED = addNode(VARIANT_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPES.variantNode("DistanceDelimited", "DistanceDelimited PCBP CellType"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50))
            .addNodeOutput("Delimiters", "Delimiters", true, () -> RenodeIntegration.NODE_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPE_DISTANCE_DELIMITED_DELIMITER)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPE_DISTANCE_DELIMITED_DELIMITER = addNode(Renode.node("BiomeProvider.PositionCells.DistanceDelimitedCellType.Delimiter", "DD PCBP CT Delimiter"))
            .addContent(Renode.floatContent("Minimum", "From").withDefaultValue(0.0).withWidth(200))
            .addContent(Renode.floatContent("Maximum", "To").withDefaultValue(0.0).withWidth(200))
            .addVariantOutput("CellType", "CellType", false, VARIANT_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPES)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPE_FILL = addNode(VARIANT_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPES.variantNode("Fill", "Fill PCBP CellType"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPE_ORIGIN = addNode(VARIANT_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPES.variantNode("Origin", "Origin PCBP CellType"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITIONS_PINCH = addNode(VARIANT_BIOME_PROVIDERS.variantNode("PositionsPinch", "PositionsPinch BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(1.0).withWidth(50))
            .addContent(Renode.checkboxContent("NormalizeDistance", "NormalizeDistance").withDefaultValue(false))
            .addContent(Renode.checkboxContent("Rounding", "GridAlign").withDefaultValue(false))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addVariantOutput("Positions", "Positions", false, HytaleGeneratorNodes.VARIANT_POSITIONS)
            .addVariantOutput("PinchCurve", "PinchCurve", false, HytaleGeneratorNodes.VARIANT_CURVES)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITIONS_TWIST = addNode(VARIANT_BIOME_PROVIDERS.variantNode("PositionsTwist", "PositionsTwist BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(1.0).withWidth(50))
            .addContent(Renode.checkboxContent("NormalizeDistance", "NormalizeDistance").withDefaultValue(false))
            .addContent(Renode.checkboxContent("Rounding", "GridAlign").withDefaultValue(false))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addVariantOutput("Positions", "Positions", false, HytaleGeneratorNodes.VARIANT_POSITIONS)
            .addVariantOutput("TwistCurve", "TwistCurve", false, HytaleGeneratorNodes.VARIANT_CURVES)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_PREVIOUS = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Previous", "Previous BiomeProvider"))
            .addContent(Renode.smallStringContent("PreviousLabel", "PreviousLabel").withDefaultValue("").withWidth(250))
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_SCALER = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Scaler", "Scaler BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("ScaleFactor", "Scale").withDefaultValue(2.0).withWidth(50))
            .addContent(Renode.checkboxContent("Rounding", "GridAlign").withDefaultValue(false))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_SMOOTHED = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Smoothed", "Smoothed BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("Radius", "Radius").withDefaultValue(5.0).withWidth(50))
            .addContent(Renode.floatContent("Threshold", "Threshold").withDefaultValue(0.5).withWidth(50))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addVariantOutput("Fallback", "Fallback", false, VARIANT_BIOME_PROVIDERS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_STAGED = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Staged", "Staged BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.smallStringContent("PreviousLabel", "PreviousLabel").withDefaultValue("").withWidth(250))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_BIOME_PROVIDERS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_SWITCH = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Switch", "Switch BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addNodeOutput("Cases", "Cases", true, () -> RenodeIntegration.NODE_BIOME_PROVIDER_SWITCH_CASE)
            .addVariantOutput("Fallback", "Fallback", false, VARIANT_BIOME_PROVIDERS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_SWITCH_CASE = addNode(Renode.node("BiomeProvider.Switch.Case", "SBP Case"))
            .addContent(HytaleGeneratorNodes.CONTENT_SKIP)
            .addVariantOutput("Condition", "Condition", false, VARIANT_BIOME_PROVIDER_CONDITIONS)
            .addVariantOutput("IfTrue", "IfTrue", false, VARIANT_BIOME_PROVIDERS)
            .withColorOverride("27,168,138")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_VECTOR_WARP = addNode(VARIANT_BIOME_PROVIDERS.variantNode("VectorWarp", "VectorWarp BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("WarpVectorX", "WarpVectorX").withDefaultValue(0.0).withWidth(50))
            .addContent(Renode.floatContent("WarpVectorZ", "WarpVectorZ").withDefaultValue(0.0).withWidth(50))
            .addContent(Renode.checkboxContent("Rounding", "GridAlign").withDefaultValue(false))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addVariantOutput("Density", "WarpField", false, HytaleGeneratorNodes.VARIANT_DENSITY)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_WEIGHTED = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Weighted", "Weighted BiomeProvider"))
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(200))
            .addContent(Renode.floatContent("Rounding", "Rounding").withDefaultValue(0.0).withWidth(50))
            .addNodeOutput("Entries", "Entries", true, () -> RenodeIntegration.NODE_BIOME_PROVIDER_WEIGHTED_WEIGHTED_ENTRY)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_WEIGHTED_WEIGHTED_ENTRY = addNode(Renode.node("BiomeProvider.Weighted.WeightedEntry", "WBP Entry"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50))
            .addVariantOutput("Value", "Value", false, VARIANT_BIOME_PROVIDERS)
            .withColorOverride("27,168,138")
            .addCategory(CATEGORY_BIOME_PROVIDERS);

    public static final AbstractNodeRoot ROOT_BIOME_PROVIDERS = addRoot(Renode.root(VARIANT_BIOME_PROVIDERS, "HytaleGenerator (Carta) - BiomeProvider"));
    public static final AbstractNodeRoot ROOT_BIOME_PROVIDER_CONDITIONS = addRoot(Renode.root(VARIANT_BIOME_PROVIDER_CONDITIONS, "HytaleGenerator (Carta) - BiomeProviderCondition"));

    private static NodeBuilder addNode(NodeBuilder node) {
        nodes.add(node);
        return node;
    }

    private static NodeVariantClass addVariant(NodeVariantClass variant) {
        variants.add(variant);
        return variant;
    }

    private static NodeCategory addCategory(NodeCategory category) {
        categories.add(category);
        return category;
    }

    private static AbstractNodeRoot addRoot(AbstractNodeRoot root) {
        roots.add(root);
        return root;
    }

    public static void registerAllNodes() {
        for (NodeBuilder node: nodes) {
            Renode.registerNode(node);
        }

        for (NodeVariantClass variant: variants) {
            Renode.registerVariant(variant);
        }

        for (NodeCategory category: categories) {
            Renode.registerCategory(category);
        }

        for (AbstractNodeRoot root: roots) {
            Renode.registerRoot(root);
        }
    }
}