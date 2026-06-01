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
            .withDescription("Anchors the origin of the child BiomeProvider (Input) to the contextual Anchor if it exists. It essentially puts the {0, 0, 0} origin of the child BiomeProvider at the position of the Anchor.\n" +
                    "For a contextual Anchor to exist, a parent of this node must produce an Anchor. The PositionCells BiomeProvider node, for example, leaves the cell's center as a contextual Anchor in its BiomeProvider child's context.\n" +
                    "You can also reverse the effect later down the line to move the origin back to the world's origin.\n" +
                    "If not specified, Input falls back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.checkboxContent("Reversed", "Reversed").withDefaultValue(false).withDescription("If true, the node will reverse the origin of the child to the world's origin, or the origin before the previous Anchor node."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CACHED = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Cached", "Cached BiomeProvider"))
            .withDescription("Caches the outputs of the child BiomeProvider (Input) to avoid duplicate work, when possible.\n" +
                    "Essentially, this node remembers up to 4096 locations that were passed into the child BiomeProvider, and if any of those locations are re-queried, it will reuse the previous value computed for that location.\n" +
                    "This node is useful whenever a parent BiomeProvider node may query the same location in this BiomeProvider multiple times, such as with the Smoothed and Scaler BiomeProviders, among others.\n" +
                    "Cached BiomeProvider nodes are automatically inserted into appropriate places in the node tree by Carta, so they shouldn't need to be used manually very often.\n" +
                    "If not specified, Input falls back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITIONAL = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Conditional", "Conditional BiomeProvider"))
            .withDescription("Outputs one of two child BiomeProviders, IfTrue and IfFalse, depending on the value of a specified BiomeProviderCondition. Only the selected child is evaluated.\n" +
                    "This node enables things such as 'place X biome anywhere that is directly adjacent to Y biome', or 'place X biome anywhere that is within N blocks of Y biome', along with more complex behaviors." +
                    "If not specified, IfTrue and IfFalse fall back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addVariantOutput("Condition", "Condition", false, VARIANT_BIOME_PROVIDER_CONDITIONS)
            .addVariantOutput("IfTrue", "IfTrue", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider, which is used if the condition is true.")
            .addVariantOutput("IfFalse", "IfFalse", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider, which is used if the condition is false.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_ADJACENT = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Adjacent", "Adjacent BiomeProviderCondition"))
            .withDescription("Checks if any adjacent position (1 block in any of the 4 cardinal directions) matches the child condition (Input).\n" +
                    "If any of the 4 checked locations satisfy the child condition, then this condition is true. Otherwise, if all 4 checked locations do not satisfy the child condition, then this condition is false.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDER_CONDITIONS, "Input BiomeProviderCondition.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_AND = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("And", "And BiomeProviderCondition"))
            .withDescription("Checks if all child conditions (Inputs) are true. If all child conditions are true, then this condition is true. Otherwise, if at least 1 child condition fails, then this condition is false.\n" +
                    "The order of child conditions for this condition can matter. Because child conditions are only checked up until the first failing condition, less expensive conditions should be placed above more expensive conditions.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_BIOME_PROVIDER_CONDITIONS, "Input BiomeProviderConditions.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_DENSITY_DISTANCE = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("DensityDistance", "DensityDistance BiomeProviderCondition"))
            .withDescription("Checks if any location within a certain distance, derived from the child Density input, matches the child condition (Input).\n" +
                    "If at least 1 location within the distance matches the child condition, then this condition is true. Otherwise, if no nearby locations match the child condition, then this condition is false.\n" +
                    "To determine the checked distance, this node evaluates its Density child once at the location of the original check. Then, it maps that density output so that -1 maps to the MinDistance and 1 maps to the MaxDistance. This mapped value is used as the distance to check." +
                    "This condition may check its child condition on nearby locations hundreds of times (or more) depending on the given distance, so this node can be very expensive. To mitigate this, caching is used to reduce the amount of checks that need to be done.\n" +
                    "Still, this node should be used as little as possible, especially with large (>16 blocks) distances.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("MinDistance", "MinDistance").withDefaultValue(0.0).withWidth(50))
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(0.0).withWidth(50))
            .addVariantOutput("Density", "Density", false, HytaleGeneratorNodes.VARIANT_DENSITY, "Input Density, which determines the distance to check.")
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDER_CONDITIONS, "Input BiomeProviderCondition.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_DISTANCE = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Distance", "Distance BiomeProviderCondition"))
            .withDescription("Checks if any location within a specified Distance (in blocks) of the current location matches the child condition (Input).\n" +
                    "If at least 1 location within the distance matches the child condition, then this condition is true. Otherwise, if no nearby locations match the child condition, then this condition is false.\n" +
                    "This condition may check its child condition on nearby locations hundreds of times (or more) depending on the given distance, so this node can be very expensive. To mitigate this, caching is used to reduce the amount of checks that need to be done.\n" +
                    "Still, this node should be used as little as possible, especially with large (>16 blocks) distances.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Distance", "Distance").withDefaultValue(1.0).withWidth(50))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDER_CONDITIONS, "Input BiomeProviderCondition.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_FIELD_FUNCTION = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("FieldFunction", "FieldFunction BiomeProviderCondition"))
            .withDescription("Checks if a child Density field is within a specified range (Minimum -> Maximum) at the given location.\n" +
                    "If the Density field's value at the given location is between From and To, then this condition is true. Otherwise, if the Density field's value is outside of that range, then it is false.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Minimum", "Minimum").withDefaultValue(0.0).withWidth(200))
            .addContent(Renode.floatContent("Maximum", "Maximum").withDefaultValue(0.0).withWidth(200))
            .addVariantOutput("Density", "Density", false, HytaleGeneratorNodes.VARIANT_DENSITY, "Input Density.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_IMPORTED = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Imported", "Imported BiomeProviderCondition"))
            .withDescription("Imports an exported BiomeProviderCondition asset.")
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(250).withDescription("The exported BiomeProviderCondition asset."))
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_NOT = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Not", "Not BiomeProviderCondition"))
            .withDescription("Checks if a child condition (Input) is not true. If the child condition does not match, this condition is true. Otherwise, it is false.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDER_CONDITIONS, "Input BiomeProviderCondition.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_OFFSET = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Offset", "Offset BiomeProviderCondition"))
            .withDescription("Checks the child condition with a given location offset (OffsetX and OffsetZ), in blocks. This condition evaluates to whatever the child condition evaluates to at the offset location.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("OffsetX", "OffsetX").withDefaultValue(0.0).withWidth(200))
            .addContent(Renode.floatContent("OffsetZ", "OffsetZ").withDefaultValue(0.0).withWidth(200))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDER_CONDITIONS, "Input BiomeProviderCondition.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_OR = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Or", "Or BiomeProviderCondition"))
            .withDescription("Checks if any child conditions (Inputs) are true. If any child conditions are true, then this condition is true. Otherwise, if all child conditions fail, then this condition is false.\n" +
                    "The order of child conditions for this condition can matter. Because child conditions are only checked up until the first matching condition, less expensive conditions should be placed above more expensive conditions.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_BIOME_PROVIDER_CONDITIONS, "Input BiomeProviderConditions.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_SUM_RANGE = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("SumRange", "SumRange BiomeProviderCondition"))
            .withDescription("Adds up the number of matching child conditions (Inputs), and checks if that sum is within a given range (Minimum to Maximum).\n" +
                    "If the number of matching child conditions is between Minimum and Maximum, then this condition is true. Otherwise, if it is outside of that range, then this condition is false.\n" +
                    "The order of child conditions for this condition can matter. Because child conditions are only checked up until it is guaranteed that the sum will/won't be in the range, less expensive conditions should be placed above more expensive conditions.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addContent(Renode.integerContent("Minimum", "Minimum").withDefaultValue(0).withWidth(50))
            .addContent(Renode.integerContent("Maximum", "Maximum").withDefaultValue(0).withWidth(50))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_BIOME_PROVIDER_CONDITIONS)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_VALUE = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Value", "Value BiomeProviderCondition"))
            .withDescription("Checks if the input biome (Input) is the specified biome. If not specified, the Input BiomeProvider falls back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addContent(Renode.smallStringContent("Biome", "Biome").withDefaultValue("").withWidth(200).withDescription("The biome to check for."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONDITION_VALUES = addNode(VARIANT_BIOME_PROVIDER_CONDITIONS.variantNode("Values", "Values BiomeProviderCondition"))
            .withDescription("Checks if the input biome (Input) is on a list of specified biomes. If not specified, the Input BiomeProvider falls back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS)
            .addContent(Renode.listContent("Biomes", "Biomes", "String").withDescription("The biomes to check for."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_CONSTANT = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Constant", "Constant BiomeProvider"))
            .withDescription("Outputs a constant biome at all locations, with the specified name. This node will usually appear at the 'roots' of your BiomeProvider node trees.\n" +
                    "Intermediate values that don't actually exist are permitted for the Biome parameter, as long as they are later replaced with a biome that exists.\n" +
                    "In other words, you can create an intermediate Biome that doesn't actually exist, it is just there to help perform the logic of your BiomeProviders, and as long as it is later replaced with a real, your overall BiomeProvider will work as expected.\n" +
                    "If your Carta WorldStructure has the 'UseDebugMaterials' enabled, instead of the actual biome being placed into the world, a flat 'debug biome' with the specified DebugMaterial will be used instead.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Biome", "Biome").withDefaultValue("").withWidth(200).withDescription("The biome to output."))
            .addNodeOutput("DebugMaterial", "DebugMaterial", false, HytaleGeneratorNodes.NODE_MATERIAL, "The material to use if UseDebugMaterials is enabled.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_FIELD_FUNCTION = addNode(VARIANT_BIOME_PROVIDERS.variantNode("FieldFunction", "FieldFunction BiomeProvider"))
            .withDescription("Evaluates a Density function at the given location, selects a delimiter based on the density output, and uses that delimiter's BiomeProvider. Otherwise, if there are no matching Delimiters, the Fallback BiomeProvider is used.\n" +
                    "When selecting a Delimiter, if multiple delimiters have overlapping ranges, a higher delimiter in the Node Editor takes precedence over a lower delimiter.\n" +
                    "If not specified, the Fallback and Delimiter Inputs fall back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addVariantOutput("Density", "Density", false, HytaleGeneratorNodes.VARIANT_DENSITY, "The Density used to select a Delimiter.")
            .addNodeOutput("Delimiters", "Delimiters", true, () -> RenodeIntegration.NODE_BIOME_PROVIDER_FIELD_FUNCTION_DELIMITER, "The Delimiters to use.")
            .addVariantOutput("Fallback", "Fallback", false, VARIANT_BIOME_PROVIDERS, "The fallback BiomeProvider, if no Delimiters match.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_FIELD_FUNCTION_DELIMITER = addNode(Renode.node("BiomeProvider.FieldFunction.Delimiter", "FFBP Delimiter"))
            .addContent(Renode.floatContent("Minimum", "From").withDefaultValue(0.0).withWidth(200).withDescription("The minimum matching value for this Delimiter."))
            .addContent(Renode.floatContent("Maximum", "To").withDefaultValue(0.0).withWidth(200).withDescription("The maximum matching value for this Delimiter."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider, used if this delimiter is selected.")
            .withColorOverride("27,168,138")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_GRADIENT_WARP = addNode(VARIANT_BIOME_PROVIDERS.variantNode("GradientWarp", "GradientWarp BiomeProvider"))
            .withDescription("Domain warps a child BiomeProvider node (Input) based on the gradient (directional slope) of a WarpField Density field.\n" +
                    "The WarpField density function is evaluated 3 times to compute its gradient in the X and Z directions, then the input location is translated based on that gradient and the WarpFactor value.\n" +
                    "This node has built-in caching of the child BiomeProvider, but only if GridAlign is enabled. GridAlign rounds each coordinate of the location after warping, since caching only works for exactly identical positions.\n" +
                    "GridAlign is recommended to be used, as it usually is not noticeable at all.\n" +
                    "If not specified, the Input falls back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("SampleDistance", "SampleDistance").withDefaultValue(1.0).withWidth(50).withDescription("Distance between samples. Recommended value: 1."))
            .addContent(Renode.floatContent("WarpFactor", "WarpFactor").withDefaultValue(1.0).withWidth(50).withDescription("With greater values you get more warping."))
            .addContent(Renode.checkboxContent("Rounding", "GridAlign").withDefaultValue(false).withDescription("Whether to align the warped position to the grid."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addVariantOutput("Density", "WarpField", false, HytaleGeneratorNodes.VARIANT_DENSITY, "Warping source.")
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