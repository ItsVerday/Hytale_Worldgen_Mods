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
            .addContent(Renode.checkboxContent("Rounding", "GridAlign").withDefaultValue(true).withDescription("Whether to align the warped position to the grid. Should be left as true if you aren't sure whether to use or not."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addVariantOutput("Density", "WarpField", false, HytaleGeneratorNodes.VARIANT_DENSITY, "Warping source.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_IMAGE_MAP = addNode(VARIANT_BIOME_PROVIDERS.variantNode("ImageMap", "ImageMap BiomeProvider"))
            .withDescription("Samples a specified image in 'Server/HytaleGenerator/Images' and places child BiomeProviders (Biomes) based on the colors of that image.\n" +
                    "Each child BiomeProvider has an associated Color and Tolerance, defining which color to look for to place that biome, and how much tolerance the color comparison uses.\n" +
                    "If no child BiomeProvider has a matching Color for a given pixel, a Fallback BiomeProvider is used instead.\n" +
                    "If not specified, the Fallback falls back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Path", "Path").withDefaultValue("").withWidth(250).withDescription("Path of the Image to use as a Biome Map, in 'Server/HytaleGenerator/Images'."))
            .addContent(Renode.floatContent("CenterX", "CenterX").withDefaultValue(0.0).withWidth(250).withDescription("X-coordinate for the center of the Image."))
            .addContent(Renode.floatContent("CenterZ", "CenterZ").withDefaultValue(0.0).withWidth(250).withDescription("Z-coordinate for the center of the Image."))
            .addContent(Renode.floatContent("Scale", "Scale").withDefaultValue(1.0).withWidth(50).withDescription("How many blocks one pixel in the Image is equivalent to."))
            .addContent(Renode.checkboxContent("Flip", "Flip").withDefaultValue(false).withDescription("Whether to flip the Image."))
            .addContent(Renode.enumContent("Rotation", "Rotation").withEnumValues(Rotation.VALUES).withDefaultValue("None").withDescription("Specifies rotation of the Image."))
            .addContent(Renode.enumContent("EdgeType", "EdgeType").withEnumValues(ImageMap2DBiomeProvider.EdgeType.values()).withDefaultValue("Exclude").withDescription("Specifies how the edges/outside of the image is handled."))
            .addNodeOutput("Biomes", "Biomes", true, () -> RenodeIntegration.NODE_BIOME_PROVIDER_IMAGE_MAP_BIOME, "List of child BiomeProviders to use.")
            .addVariantOutput("Fallback", "Fallback", false, VARIANT_BIOME_PROVIDERS, "Fallback BiomeProvider to use.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_IMAGE_MAP_BIOME = addNode(Renode.node("BiomeProvider.ImageMap.Biome", "IMBP Biome"))
            .addContent(Renode.smallStringContent("Color", "Color").withDefaultValue("#000000").withWidth(200).withDescription("Color to check for."))
            .addContent(Renode.floatContent("Tolerance", "Tolerance").withDefaultValue(0.0).withWidth(50).withDescription("Tolerance for comparing this color to the image, in RGB units (each channel is 0-255)."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .withColorOverride("27,168,138")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_IMPORTED = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Imported", "Imported BiomeProvider"))
            .withDescription("Imports an exported BiomeProvider asset.")
            .addContent(HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(250))
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_OFFSET = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Offset", "Offset BiomeProvider"))
            .withDescription("Offsets a child BiomeProvider (Input) by a fixed amount on the X and Z axes.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("OffsetX", "OffsetX").withDefaultValue(0.0).withWidth(200).withDescription("X-coordinate offset."))
            .addContent(Renode.floatContent("OffsetZ", "OffsetZ").withDefaultValue(0.0).withWidth(200).withDescription("Z-coordinate offset."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITION_CELLS = addNode(VARIANT_BIOME_PROVIDERS.variantNode("PositionCells", "PositionCells BiomeProvider"))
            .withDescription("Places 'cells' of BiomeProviders at specified positions with a specified radius/distance. Around each position in the given Positions, a random CellType is selected based on the provided weights and seed.\n" +
                    "That CellType is used to fill the area around that position up to a certain radius, as long as that position is the closest position.\n" +
                    "This node also supports Distance warping, or warping the computed distance values to change the shape of the cells.\n" +
                    "If not specified, the Fallback falls back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(200).withDescription("Used to determine CellType for each position."))
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(32.0).withWidth(50).withDescription("Maximum distance from a position for a cell to reach, before Distance warping."))
            .addContent(Renode.floatContent("DistanceWarpMin", "DistanceWarpMin").withDefaultValue(0.0).withWidth(50).withDescription("Minimum Distance warping amount, for a DistanceWarpField value of -1."))
            .addContent(Renode.floatContent("DistanceWarpMax", "DistanceWarpMax").withDefaultValue(0.0).withWidth(50).withDescription("Maximum Distance warping amount, for a DistanceWarpField value of 1."))
            .addVariantOutput("Positions", "Positions", false, HytaleGeneratorNodes.VARIANT_POSITIONS, "The positions to place cells around.")
            .addVariantOutput("CellTypes", "CellTypes", true, VARIANT_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPES, "The different CellTypes that can be placed.")
            .addVariantOutput("Fallback", "Fallback", false, VARIANT_BIOME_PROVIDERS, "The fallback value to use if no cell is found.")
            .addVariantOutput("DistanceWarpField", "DistanceWarpField", false, HytaleGeneratorNodes.VARIANT_DENSITY, "The DistanceWarp field to use, can be left empty. Values of -1 for this Density correspond to DistanceWarpMin, and 1 corresponds to DistanceWarpMax.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPE_DISTANCE_DELIMITED = addNode(VARIANT_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPES.variantNode("DistanceDelimited", "DistanceDelimited PCBP CellType"))
            .withDescription("CellType that chooses a child CellType based on the distance from the cell center, ignoring those CellTypes' weights.")
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50).withDescription("The weight of this CellType."))
            .addNodeOutput("Delimiters", "Delimiters", true, () -> RenodeIntegration.NODE_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPE_DISTANCE_DELIMITED_DELIMITER, "Distance Delimiters for this CellType.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPE_DISTANCE_DELIMITED_DELIMITER = addNode(Renode.node("BiomeProvider.PositionCells.DistanceDelimitedCellType.Delimiter", "DD PCBP CT Delimiter"))
            .addContent(Renode.floatContent("Minimum", "From").withDefaultValue(0.0).withWidth(200).withDescription("Minimum distance for this Delimiter to be chosen."))
            .addContent(Renode.floatContent("Maximum", "To").withDefaultValue(0.0).withWidth(200).withDescription("Maximum distance for this Delimiter to be chosen."))
            .addVariantOutput("CellType", "CellType", false, VARIANT_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPES, "The child CellType to use for this Delimiter.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPE_FILL = addNode(VARIANT_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPES.variantNode("Fill", "Fill PCBP CellType"))
            .withDescription("CellType that fills the cell with a BiomeProvider.")
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50).withDescription("The weight of this CellType."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPE_ORIGIN = addNode(VARIANT_BIOME_PROVIDER_POSITION_CELLS_CELL_TYPES.variantNode("Origin", "Origin PCBP CellType"))
            .withDescription("CellType that only samples the center of the input BiomeProvider, and fills the cell with that biome.")
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50).withDescription("The weight of this CellType."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITIONS_PINCH = addNode(VARIANT_BIOME_PROVIDERS.variantNode("PositionsPinch", "PositionsPinch BiomeProvider"))
            .withDescription("Pinches or expands the child (Input) BiomeProvider field around the Positions.\n" +
                    "This node has built-in caching of the child BiomeProvider, but only if GridAlign is enabled. GridAlign rounds each coordinate of the location after pinching, since caching only works for exactly identical positions.\n" +
                    "GridAlign is recommended to be used, as it usually is not noticeable at all.\n" +
                    "If not specified, the Input falls back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(1.0).withWidth(50).withDescription("The value represents how big the area of effect is in block units."))
            .addContent(Renode.checkboxContent("NormalizeDistance", "NormalizeDistance").withDefaultValue(true).withDescription("Default is true. If true then the Curve's input and output unit is normalized to the MaxDistance value, otherwise if false the Curve's input and output unit is in blocks."))
            .addContent(Renode.checkboxContent("Rounding", "GridAlign").withDefaultValue(true).withDescription("Whether to align the pinched position to the grid. Should be left as true if you aren't sure whether to use or not."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addVariantOutput("Positions", "Positions", false, HytaleGeneratorNodes.VARIANT_POSITIONS, "The Positions are the anchors that pinch and expand the Density field around them.")
            .addVariantOutput("PinchCurve", "PinchCurve", false, HytaleGeneratorNodes.VARIANT_CURVES, "The curve determines how the Density field is pinched or expanded depending on how close it is to a position.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_POSITIONS_TWIST = addNode(VARIANT_BIOME_PROVIDERS.variantNode("PositionsTwist", "PositionsTwist BiomeProvider"))
            .withDescription("Twists the child (Input) BiomeProvider field around the Positions.\n" +
                    "This node has built-in caching of the child BiomeProvider, but only if GridAlign is enabled. GridAlign rounds each coordinate of the location after twisting, since caching only works for exactly identical positions.\n" +
                    "GridAlign is recommended to be used, as it usually is not noticeable at all.\n" +
                    "If not specified, the Input falls back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(1.0).withWidth(50).withDescription("The value represents how big the area of effect is in block units."))
            .addContent(Renode.checkboxContent("NormalizeDistance", "NormalizeDistance").withDefaultValue(true).withDescription("Default is true. If true then the Curve's input and output unit is normalized to the MaxDistance value, otherwise if false the Curve's input and output unit is in blocks."))
            .addContent(Renode.checkboxContent("Rounding", "GridAlign").withDefaultValue(true).withDescription("Whether to align the twisted position to the grid. Should be left as true if you aren't sure whether to use or not."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addVariantOutput("Positions", "Positions", false, HytaleGeneratorNodes.VARIANT_POSITIONS, "The Positions are the anchors that twist the Density field around them.")
            .addVariantOutput("TwistCurve", "TwistCurve", false, HytaleGeneratorNodes.VARIANT_CURVES, "The curve determines how the Density field is twisted depending on how close it is to a position.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_PREVIOUS = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Previous", "Previous BiomeProvider"))
            .withDescription("Outputs the previous stage in the closest Staged BiomeProvider's parent hierarchy, or the WorldStructure's DefaultBiome if none was found.\n" +
                    "For any BiomeProvider node with an unspecified child, a Previous BiomeProvider is used as a default (with no PreviousLabel).\n" +
                    "If a PreviousLabel is provided, and a Staged BiomeProvider with the same PreviousLabel is found in the parent hierarchy, that Staged BiomeProvider's previous stage will be used instead.\n" +
                    "If the Staged BiomeProvider is already on the first stage, then this node will use the next Staged BiomeProvider up's previous stage instead, and so on. If there are no remaining Staged BiomeProviders, then the WorldStructure's DefaultBiome is used.")
            .addContent(Renode.smallStringContent("PreviousLabel", "PreviousLabel").withDefaultValue("").withWidth(250).withDescription("Specifies which Staged BiomeProvider to use the previous stage of."))
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_SCALER = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Scaler", "Scaler BiomeProvider"))
            .withDescription("Scales the child (Input) BiomeProvider, so that the BiomeMap is larger when applied to a world. For example, a ScaleFactor of 2 means the input will be 2x as large.\n" +
                    "This node has built-in caching of the child BiomeProvider, but only if GridAlign is enabled. GridAlign rounds each coordinate of the location after scaling, since caching only works for exactly identical positions.\n" +
                    "GridAlign is recommended to be used, as it usually is not noticeable at all.\n" +
                    "If not specified, the Input falls back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("ScaleFactor", "Scale").withDefaultValue(2.0).withWidth(50).withDescription("The scale factor to use."))
            .addContent(Renode.checkboxContent("Rounding", "GridAlign").withDefaultValue(true).withDescription("Whether to align the scaled position to the grid. Should be left as true if you aren't sure whether to use or not."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_SMOOTHED = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Smoothed", "Smoothed BiomeProvider"))
            .withDescription("Applies a smoothing filter to the child (input) BiomeProvider, by sampling all biome values in a given radius and using the most common one, as long as its prevalence is above a certain threshold.\n" +
                    "This BiomeProvider can be very expensive, as it samples the input many times per sample of this node. To mitigate this, caching is used to reduce the amount of checks that need to be done.\n" +
                    "Still, you should use this node as little as possible, especially with large (>16) Radius values.\n" +
                    "If not specified, the Input and Fallback fall back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("Radius", "Radius").withDefaultValue(5.0).withWidth(50).withDescription("The radius to use for the smoothing pass."))
            .addContent(Renode.floatContent("Threshold", "Threshold").withDefaultValue(0.5).withWidth(50).withDescription("The threshold value to use for smoothing. The smoothing will only be applied if the most common Biome is at least this threshold times the total number of samples."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS, "Input BiomeProvider.")
            .addVariantOutput("Fallback", "Fallback", false, VARIANT_BIOME_PROVIDERS, "Fallback BiomeProvider, if the threshold check does not pass.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_STAGED = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Staged", "Staged BiomeProvider"))
            .withDescription("Applies the child BiomeProviders (Inputs) in a 'staged' manner, with each stage modifying the Biome Map from the previous stage. In other words, causes the Previous BiomeProvider to fall back to previous stages in this Staged BiomeProvider's inputs.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.smallStringContent("PreviousLabel", "PreviousLabel").withDefaultValue("").withWidth(250).withDescription("Allows Previous BiomeProviders to fallback to this Staged BiomeProvider specifically, if it has a matching PreviousLabel."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_BIOME_PROVIDERS, "The stages to apply, from top to bottom.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_SWITCH = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Switch", "Switch BiomeProvider"))
            .withDescription("Checks a queue of cases (conditions + child BiomeProviders), with the first passing case causing that BiomeProvider to be used. Equivalent to a chain of Conditional BiomeProviders, with each next case being a Conditional used as the IfFalse input of the previous. If no cases match, a fallback BiomeProvider is used.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addNodeOutput("Cases", "Cases", true, () -> RenodeIntegration.NODE_BIOME_PROVIDER_SWITCH_CASE, "The list of cases to check")
            .addVariantOutput("Fallback", "Fallback", false, VARIANT_BIOME_PROVIDERS, "Fallback BiomeProvider, if no matching case is found.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_SWITCH_CASE = addNode(Renode.node("BiomeProvider.Switch.Case", "SBP Case"))
            .withDescription("A case for the Switch BiomeProvider.")
            .addContent(HytaleGeneratorNodes.CONTENT_SKIP)
            .addVariantOutput("Condition", "Condition", false, VARIANT_BIOME_PROVIDER_CONDITIONS, "Condition to check for this case.")
            .addVariantOutput("IfTrue", "IfTrue", false, VARIANT_BIOME_PROVIDERS, "BiomeProvider to apply if the condition is true")
            .withColorOverride("27,168,138")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_VECTOR_WARP = addNode(VARIANT_BIOME_PROVIDERS.variantNode("VectorWarp", "VectorWarp BiomeProvider"))
            .withDescription("Warps the child (Input) BiomeProvider along the provided vector. The amount of warping is determined by the intensity of the second input Density field and the WarpVector's length." +
                    "This node has built-in caching of the child BiomeProvider, but only if GridAlign is enabled. GridAlign rounds each coordinate of the location after scaling, since caching only works for exactly identical positions.\n" +
                    "GridAlign is recommended to be used, as it usually is not noticeable at all.\n" +
                    "If not specified, the Input falls back to the Previous BiomeProvider (see Staged/Previous BiomeProviders).")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.floatContent("WarpVectorX", "WarpVectorX").withDefaultValue(0.0).withWidth(50).withDescription("X-coordinate of the Warp Vector."))
            .addContent(Renode.floatContent("WarpVectorZ", "WarpVectorZ").withDefaultValue(0.0).withWidth(50).withDescription("Z-coordinate of the Warp Vector."))
            .addContent(Renode.checkboxContent("Rounding", "GridAlign").withDefaultValue(false).withDescription("Whether to align the warped position to the grid. Should be left as true if you aren't sure whether to use or not."))
            .addVariantOutput("Input", "Input", false, VARIANT_BIOME_PROVIDERS)
            .addVariantOutput("Density", "WarpField", false, HytaleGeneratorNodes.VARIANT_DENSITY)
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_WEIGHTED = addNode(VARIANT_BIOME_PROVIDERS.variantNode("Weighted", "Weighted BiomeProvider"))
            .withDescription("Randomly selects a child entry based on their weights, and uses that BiomeProvider.")
            .addContent(HytaleGeneratorNodes.CONTENT_EXPORT_AS, HytaleGeneratorNodes.CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(200).withDescription("The seed to use when randomly selecting an entry."))
            .addContent(Renode.floatContent("Rounding", "Rounding").withDefaultValue(0.0).withWidth(50).withDescription("How much to round the input position. Values larger than 1 will cause grid artifacts."))
            .addNodeOutput("Entries", "Entries", true, () -> RenodeIntegration.NODE_BIOME_PROVIDER_WEIGHTED_WEIGHTED_ENTRY, "The entries to pick from.")
            .addCategory(CATEGORY_BIOME_PROVIDERS);
    public static final NodeBuilder NODE_BIOME_PROVIDER_WEIGHTED_WEIGHTED_ENTRY = addNode(Renode.node("BiomeProvider.Weighted.WeightedEntry", "WBP Entry"))
            .withDescription("Entry for Weighted BiomeProvider.")
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50).withDescription("The weight for this entry."))
            .addVariantOutput("Value", "Value", false, VARIANT_BIOME_PROVIDERS, "The BiomeProvider to use if this entry is selected.")
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