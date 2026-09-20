package io.github.itsverday.renode.vanilla;

import io.github.itsverday.renode.builder.NodeBuilder;
import io.github.itsverday.renode.builder.NodeCategory;
import io.github.itsverday.renode.builder.NodeVariantClass;
import io.github.itsverday.renode.builder.Renode;
import io.github.itsverday.renode.builder.content.type.NodeCheckboxContentBuilder;
import io.github.itsverday.renode.builder.content.type.NodeSmallStringContentBuilder;
import io.github.itsverday.renode.builder.root.AbstractNodeRoot;

import java.util.ArrayList;
import java.util.List;

public class HytaleGeneratorNodes {
    private static final List<NodeBuilder> nodes = new ArrayList<>();
    private static final List<NodeVariantClass> variants = new ArrayList<>();
    private static final List<NodeCategory> categories = new ArrayList<>();
    private static final List<AbstractNodeRoot> roots = new ArrayList<>();

    public static final NodeSmallStringContentBuilder CONTENT_EXPORT_AS = Renode.smallStringContent("ExportAs", "ExportAs").withDefaultValue("").withWidth(250);
    public static final NodeCheckboxContentBuilder CONTENT_SKIP = Renode.checkboxContent("Skip", "Skip").withDefaultValue(false);

    public static final NodeCategory CATEGORY_ASSIGNMENTS = addCategory(Renode.category("Assignments", "Aqua"));
    public static final NodeCategory CATEGORY_BIOME = addCategory(Renode.category("Biome", "Grey"));
    public static final NodeCategory CATEGORY_BLOCK_MASKS = addCategory(Renode.category("BlockMask", "Olive"));
    public static final NodeCategory CATEGORY_BOUNDS = addCategory(Renode.category("Bounds", "Orange"));
    public static final NodeCategory CATEGORY_CURVES = addCategory(Renode.category("Curve", "Orange"));
    public static final NodeCategory CATEGORY_DENSITY = addCategory(Renode.category("Density", "Purple"));
    public static final NodeCategory CATEGORY_DENSITY_POSITIONS_CELL_NOISE = addCategory(Renode.category("PositionsCellNoise", "DarkPink"));
    public static final NodeCategory CATEGORY_DIRECTIONALITY = addCategory(Renode.category("Directionality", "Magenta"));
    public static final NodeCategory CATEGORY_ENVIRONMENT_PROVIDERS = addCategory(Renode.category("EnvironmentProvider", "110,63,16"));
    public static final NodeCategory CATEGORY_GRAPH = addCategory(Renode.category("Graph", "Pink"));
    public static final NodeCategory CATEGORY_GRAPH_CONTENT_PREDICATE = addCategory(Renode.category("ContentPredicate", "Pink"));
    public static final NodeCategory CATEGORY_GRAPH_CONTENT_SUPPLIER = addCategory(Renode.category("ContentSupplier", "Pink"));
    public static final NodeCategory CATEGORY_MATERIAL = addCategory(Renode.category("Material", "Yellow"));
    public static final NodeCategory CATEGORY_MATERIAL_PROVIDERS = addCategory(Renode.category("MaterialProvider", "110,63,16"));
    public static final NodeCategory CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH = addCategory(Renode.category("SpaceAndDepth MaterialProvider", "Orange"));
    public static final NodeCategory CATEGORY_PATTERNS = addCategory(Renode.category("Pattern", "Pink"));
    public static final NodeCategory CATEGORY_POINT_GENERATORS = addCategory(Renode.category("PointGenerator", "255,0,0"));
    public static final NodeCategory CATEGORY_POSITIONS = addCategory(Renode.category("Positions", "Blue"));
    public static final NodeCategory CATEGORY_PROPS = addCategory(Renode.category("Prop", "Green"));
    public static final NodeCategory CATEGORY_PROP_DISTRIBUTIONS = addCategory(Renode.category("Prop Distribution", "Aqua"));
    public static final NodeCategory CATEGORY_RANGE = addCategory(Renode.category("Range", "Orange"));
    public static final NodeCategory CATEGORY_SCANNERS = addCategory(Renode.category("Scanner", "LightPurple"));
    public static final NodeCategory CATEGORY_TINT_PROVIDERS = addCategory(Renode.category("TintProvider", "110,63,16"));
    public static final NodeCategory CATEGORY_VECTORS = addCategory(Renode.category("Vectors", "Orange"));
    public static final NodeCategory CATEGORY_VECTOR_PROVIDERS = addCategory(Renode.category("VectorProviders", "Green"));

    public static final NodeVariantClass VARIANT_ASSIGNMENTS = addVariant(Renode.variant("Assignments", "Aqua"));
    public static final NodeVariantClass VARIANT_CURVES = addVariant(Renode.variant("Curves", "Orange"));
    public static final NodeVariantClass VARIANT_DENSITY = addVariant(Renode.variant("Density", "Purple"));
    public static final NodeVariantClass VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES = addVariant(Renode.variant("PositionsCellNoiseReturnTypes", "DarkPink"));
    public static final NodeVariantClass VARIANT_DIRECTIONALITY = addVariant(Renode.variant("Directionality", "Magenta"));
    public static final NodeVariantClass VARIANT_ENVIRONMENT_PROVIDERS = addVariant(Renode.variant("EnvironmentProviders", "110,63,16"));
    public static final NodeVariantClass VARIANT_GRAPH_CONTENT_PREDICATES = addVariant(Renode.variant("GraphContentPredicate", "Pink"));
    public static final NodeVariantClass VARIANT_GRAPH_CONTENT_SUPPLIERS = addVariant(Renode.variant("GraphContentSuppliers", "Pink"));
    public static final NodeVariantClass VARIANT_GRAPH_EDGE_ACTIONS = addVariant(Renode.variant("GraphEdgeActions", "Pink"));
    public static final NodeVariantClass VARIANT_GRAPH_EDGE_SELECTORS = addVariant(Renode.variant("GraphEdgeSelectors", "Pink"));
    public static final NodeVariantClass VARIANT_GRAPH_NODE_ACTIONS = addVariant(Renode.variant("GraphNodeActions", "Pink"));
    public static final NodeVariantClass VARIANT_GRAPH_NODE_SELECTORS = addVariant(Renode.variant("GraphNodeSelectors", "Pink"));
    public static final NodeVariantClass VARIANT_GRAPH_PASSES = addVariant(Renode.variant("GraphPasses", "Pink"));
    public static final NodeVariantClass VARIANT_MATERIAL_PROVIDERS = addVariant(Renode.variant("MaterialProviders", "110,63,16"));
    public static final NodeVariantClass VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS = addVariant(Renode.variant("SpaceAndDepthConditions", "Orange"));
    public static final NodeVariantClass VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYERS = addVariant(Renode.variant("SpaceAndDepthLayers", "Orange"));
    public static final NodeVariantClass VARIANT_PATTERNS = addVariant(Renode.variant("Patterns", "Pink"));
    public static final NodeVariantClass VARIANT_POINT_GENERATORS = addVariant(Renode.variant("PointGenerators", "255,0,0"));
    public static final NodeVariantClass VARIANT_POSITIONS = addVariant(Renode.variant("Positions", "Blue"));
    public static final NodeVariantClass VARIANT_PROPS = addVariant(Renode.variant("Props", "Green"));
    public static final NodeVariantClass VARIANT_PROP_DISTRIBUTIONS = addVariant(Renode.variant("PropDistributions", "Aqua"));
    public static final NodeVariantClass VARIANT_SCANNERS = addVariant(Renode.variant("Scanners", "LightPurple"));
    public static final NodeVariantClass VARIANT_TINT_PROVIDERS = addVariant(Renode.variant("TintProviders", "110,63,16"));
    public static final NodeVariantClass VARIANT_VECTOR_PROVIDERS = addVariant(Renode.variant("VectorProviders", "Green"));

    public static final NodeBuilder NODE_ASSIGNMENTS_CONSTANT = addNode(VARIANT_ASSIGNMENTS.variantNode("Constant", "Constant.Assignments", "Constant Assignments"))
            .withDescription("Assigns a Prop to all positions.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS, "The Prop to assign.")
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_FIELD_FUNCTION = addNode(VARIANT_ASSIGNMENTS.variantNode("FieldFunction", "FieldFunction.Assignments", "FieldFunction Assignments"))
            .withDescription("Allows you to select which Props to assign based on a Density field and your configured delimiters. The Density's value at each position determines which delimiter's Prop to assign.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("FieldFunction", "FieldFunction", false, VARIANT_DENSITY, "The Density field.")
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_ASSIGNMENTS_FIELD_FUNCTION_DELIMITER, "Attaches Props to value ranges of the Density field.")
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_FIELD_FUNCTION_DELIMITER = addNode(Renode.node("Delimiter.FieldFunction.Assignments", "FieldFunction Delimiter"))
            .addContent(Renode.floatContent("Min", "Min").withDefaultValue(0.0).withWidth(70))
            .addContent(Renode.floatContent("Max", "Max").withDefaultValue(0.0).withWidth(70))
            .addVariantOutput("Assignments", "Assignments", false, VARIANT_ASSIGNMENTS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_IMPORTED = addNode(VARIANT_ASSIGNMENTS.variantNode("Imported", "Imported.Assignments", "Imported Assignments"))
            .withDescription("Imports exported Assignments.")
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350).withDescription("The exported Assignments name."))
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_SANDWICH = addNode(VARIANT_ASSIGNMENTS.variantNode("Sandwich", "Sandwich.Assignments", "Sandwich Assignments"))
            .withDescription("Allows you to select which Props to assign based on their vertical (world Y) position and your configured delimiters. Depending on each position's world height, the matching delimiter's Prop is assigned.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_ASSIGNMENTS_SANDWICH_DELIMITER, "Each delimiter defines a world height range and its Assignments.")
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_SANDWICH_DELIMITER = addNode(Renode.node("Delimiter.Sandwich.Assignments", "Sandwich Delimiter"))
            .addContent(Renode.floatContent("MinY", "MinY").withDefaultValue(0.0).withWidth(70))
            .addContent(Renode.floatContent("MaxY", "MaxY").withDefaultValue(100.0).withWidth(70))
            .addVariantOutput("Assignments", "Assignments", false, VARIANT_ASSIGNMENTS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_WEIGHTED = addNode(VARIANT_ASSIGNMENTS.variantNode("Weighted", "Weighted.Assignments", "Weighted Assignments"))
            .withDescription("Picks which Prop to assign randomly based on weights and a seed.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SkipChance", "SkipChance").withDefaultValue(0.0).withWidth(70).withDescription("Chance to skip a position without assigning a Prop."))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addNodeOutput("WeightedAssignments", "WeightedAssignments", true, () -> HytaleGeneratorNodes.NODE_ASSIGNMENTS_WEIGHTED_WEIGHT)
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_WEIGHTED_WEIGHT = addNode(Renode.node("Weight.Weighted.Assignments", "Weight"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(70))
            .addVariantOutput("Assignments", "Assignments", false, VARIANT_ASSIGNMENTS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_BIOME = addNode(Renode.node("Biome", "Biome"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350))
            .addNodeOutput("Terrain", "Terrain", false, () -> HytaleGeneratorNodes.NODE_BIOME_TERRAIN)
            .addVariantOutput("MaterialProvider", "MaterialProvider", false, VARIANT_MATERIAL_PROVIDERS)
            .addNodeOutput("Props", "Props", true, () -> HytaleGeneratorNodes.NODE_RUNTIME)
            .addVariantOutput("EnvironmentProvider", "EnvironmentProvider", false, VARIANT_ENVIRONMENT_PROVIDERS)
            .addVariantOutput("TintProvider", "TintProvider", false, VARIANT_TINT_PROVIDERS)
            .addCategory(CATEGORY_BIOME);
    public static final NodeBuilder NODE_BIOME_TERRAIN = addNode(Renode.node("Terrain.Biome", "Terrain"))
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_BIOME)
            .addSchemaString("Type", "DAOTerrain");
    public static final NodeBuilder NODE_BLOCK_MASK = addNode(Renode.node("BlockMask", "BlockMask"))
            .withDescription("Determines which Materials get to replace which other Materials when placing content in the world.\nIf you're trying to place bricks in water, then bricks are the Source Material, and water is the Destination Material.\n- Source Material: the Material we're trying to place.\n- Destination Material: the Material that exists where we want to place the Source Material.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.smallStringContent("Import", "Import").withDefaultValue("").withWidth(250))
            .addNodeOutput("DontPlace", "DontPlace", false, () -> HytaleGeneratorNodes.NODE_BLOCK_MASK_BLOCK_SET, "Source Materials in this set will not be placed.")
            .addNodeOutput("DontReplace", "DontReplace", false, () -> HytaleGeneratorNodes.NODE_BLOCK_MASK_BLOCK_SET, "By default, Source Materials cannot replace Destination Materials in this BlockSet. This rule is overridden by the Advanced rules below.")
            .addNodeOutput("Advanced", "Advanced", true, () -> HytaleGeneratorNodes.NODE_BLOCK_MASK_RULE, "Per-BlockSet overrides. Each rule contains a Source BlockSet and a CanReplace BlockSet.")
            .addCategory(CATEGORY_BLOCK_MASKS);
    public static final NodeBuilder NODE_BLOCK_MASK_BLOCK_SET = addNode(Renode.node("BlockSet.BlockMask", "BlockSet BlockMask"))
            .addContent(Renode.checkboxContent("Inclusive", "Inclusive").withDefaultValue(true).withDescription("Whether the set includes the Materials listed or excludes them."))
            .addNodeOutput("Materials", "Materials", true, () -> HytaleGeneratorNodes.NODE_MATERIAL)
            .withColorOverride("Yellow")
            .addCategory(CATEGORY_BLOCK_MASKS);
    public static final NodeBuilder NODE_BLOCK_MASK_RULE = addNode(Renode.node("Rule.BlockMask", "Rule BlockMask"))
            .addNodeOutput("Source", "Source", false, NODE_BLOCK_MASK_BLOCK_SET, "The Source Materials the rule applies to.")
            .addNodeOutput("CanReplace", "CanReplace", false, NODE_BLOCK_MASK_BLOCK_SET, "The Destination Materials those sources can replace.")
            .withColorOverride("Orange")
            .addCategory(CATEGORY_BLOCK_MASKS);
    public static final NodeBuilder NODE_BOUNDS_DECIMAL_3D = addNode(Renode.node("Decimal.Bounds3d", "Decimal Bounds 3D"))
            .addNodeOutput("PointA", "PointA", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addNodeOutput("PointB", "PointB", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_BOUNDS);
    public static final NodeBuilder NODE_BOUNDS_INTEGER_3D = addNode(Renode.node("Integer.Bounds3d", "Integer Bounds 3D"))
            .addNodeOutput("PointA", "PointA", false, () -> HytaleGeneratorNodes.NODE_POINT_3D_INTEGER)
            .addNodeOutput("PointB", "PointB", false, () -> HytaleGeneratorNodes.NODE_POINT_3D_INTEGER)
            .addCategory(CATEGORY_BOUNDS);
    public static final NodeBuilder NODE_CURVE_CEILING = addNode(VARIANT_CURVES.variantNode("Ceiling", "Ceiling.Curve", "Ceiling Curve"))
            .withDescription("This curve puts a ceiling on the output of the child curve asset.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Ceiling", "Ceiling").withDefaultValue(0.0).withWidth(100).withDescription("The maximum value this curve will output."))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_CLAMP = addNode(VARIANT_CURVES.variantNode("Clamp", "Clamp.Curve", "Clamp Curve"))
            .withDescription("This clamps the curve between the two wall values provided. The output of this curve will never reach outside the walls.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("WallA", "WallA").withDefaultValue(1.0).withWidth(100))
            .addContent(Renode.floatContent("WallB", "WallB").withDefaultValue(-1.0).withWidth(100))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_CONSTANT = addNode(VARIANT_CURVES.variantNode("Constant", "Constant.Curve", "Constant Curve"))
            .withDescription("Outputs a constant value.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_DISTANCE_EXPONENTIAL = addNode(VARIANT_CURVES.variantNode("DistanceExponential", "DistanceExponential.Curve", "DistanceExponential Curve"))
            .withDescription("The DistanceExponential Curve has the following shape depending on the Exponent value. As this curve's input approaches the Range value, it outputs 0.0. At an input of 0.0, this curve outputs 1.0.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Exponent", "Exponent").withDefaultValue(1.0).withWidth(100).withDescription("Affects the curve's shape like in the diagram above."))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(1.0).withWidth(100).withDescription("The value after which the curve outputs a constant 0.0."))
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_DISTANCE_S = addNode(VARIANT_CURVES.variantNode("DistanceS", "DistanceS.Curve", "DistanceS Curve"))
            .withDescription("The DistanceS Curve combines two DistanceExponential curves to produce a shape similar to the diagram below. As this curve's input approaches the Range value, it outputs 0.0. At an input of 0.0, this curve outputs 1.0. The asset's parameters allow you to tweak the shape of the curve.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("ExponentA", "ExponentA").withDefaultValue(1.0).withWidth(100).withDescription("Affects the curve's shape in the first half of the range."))
            .addContent(Renode.floatContent("ExponentB", "ExponentB").withDefaultValue(1.0).withWidth(100).withDescription("Affects the curve's shape in the second half of the range."))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(1.0).withWidth(100).withDescription("The value after which the curve outputs a constant 0.0."))
            .addContent(Renode.floatContent("Transition", "Transition").withDefaultValue(1.0).withWidth(100).withDescription("Values close to 0.0 create a curve with a faster, more sudden transition between ExponentA and ExponentB. Values of 1.0 transition from ExponentA to ExponentB over the entire curve."))
            .addContent(Renode.floatContent("TransitionSmooth", "TransitionSmooth").withDefaultValue(1.0).withWidth(100).withDescription("Affects the shape of the transition. Lower values can result in a sharper curve in some situations. Try different values while you design to get a feel for it."))
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_FLOOR = addNode(VARIANT_CURVES.variantNode("Floor", "Floor.Curve", "Floor Curve"))
            .withDescription("This curve puts a floor on the output of the child curve asset.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Floor", "Floor").withDefaultValue(0.0).withWidth(100).withDescription("The minimum value this curve will output."))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_IMPORTED = addNode(VARIANT_CURVES.variantNode("Imported", "Imported.Curve", "Imported Curve"))
            .withDescription("Imports an exported Curve.")
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350).withDescription("The exported Curve asset."))
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_INVERTER = addNode(VARIANT_CURVES.variantNode("Inverter", "Inverter.Curve", "Inverter Curve"))
            .withDescription("This inverts the child curve such that positive values become negative and negative values become positive.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_MANUAL = addNode(VARIANT_CURVES.variantNode("Manual", "Manual.Curve", "Manual Curve"))
            .withDescription("You can plot points that connect with lines to create the curve. The points are connected with straight lines. The function is constant before the first point and after the last point.")
            .addContent(CONTENT_EXPORT_AS)
            .addNodeOutput("Points", "Points", true, () -> HytaleGeneratorNodes.NODE_CURVE_MANUAL_POINT, "Curve points.")
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_MANUAL_POINT = addNode(Renode.node("CurvePoint.Curve", "Curve Point"))
            .addContent(Renode.floatContent("In", "In").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("Out", "Out").withDefaultValue(0.0).withWidth(100))
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_MAX = addNode(VARIANT_CURVES.variantNode("Max", "Max.Curve", "Max Curve"))
            .withDescription("This outputs the maximum value of all the child curves.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Curves", "Curves", true, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_MIN = addNode(VARIANT_CURVES.variantNode("Min", "Min.Curve", "Min Curve"))
            .withDescription("This outputs the minimum value of all the child curves.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Curves", "Curves", true, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_MULTIPLIER = addNode(VARIANT_CURVES.variantNode("Multiplier", "Multiplier.Curve", "Multiplier Curve"))
            .withDescription("This multiplies all the child curves' outputs.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Curves", "Curves", true, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_NOT = addNode(VARIANT_CURVES.variantNode("Not", "Not.Curve", "Not Curve"))
            .withDescription("This applies a logical NOT operation on the child curve. When the child's output is 1, this will output 0, and when the child's output is 0, this will output 1. All numbers in between are scaled accordingly.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_SMOOTH_CEILING = addNode(VARIANT_CURVES.variantNode("SmoothCeiling", "SmoothCeiling.Curve", "SmoothCeiling Curve"))
            .withDescription("This curve puts a ceiling on the output of the child curve asset. As the curve approaches the ceiling within the provided range, it gets smoothed.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Ceiling", "Ceiling").withDefaultValue(0.0).withWidth(100).withDescription("The maximum value this curve will output."))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0).withWidth(100).withDescription("The range determines how much smoothing is applied. A good starting value would be ¼ of the known range of your child curve."))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_SMOOTH_CLAMP = addNode(VARIANT_CURVES.variantNode("SmoothClamp", "SmoothClamp.Curve", "SmoothClamp Curve"))
            .withDescription("This curve limits the range of the child curve asset within the provided walls. As the curve approaches the limits within the provided range, it gets smoothed.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("WallA", "WallA").withDefaultValue(1.0).withWidth(100))
            .addContent(Renode.floatContent("WallB", "WallB").withDefaultValue(-1.0).withWidth(100))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0).withWidth(100).withDescription("The range determines how much smoothing is applied. A good starting value would be ¼ of the known range of your child curve."))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_SMOOTH_FLOOR = addNode(VARIANT_CURVES.variantNode("SmoothFloor", "SmoothFloor.Curve", "SmoothFloor Curve"))
            .withDescription("This curve puts a floor on the output of the child curve asset. As the curve approaches the floor within the provided range, it gets smoothed.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Floor", "Floor").withDefaultValue(0.0).withWidth(100).withDescription("The minimum value this curve will output."))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0).withWidth(100).withDescription("The range determines how much smoothing is applied. A good starting value would be ¼ of the known range of your child curve."))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_SMOOTH_MAX = addNode(VARIANT_CURVES.variantNode("SmoothMax", "SmoothMax.Curve", "SmoothMax Curve"))
            .withDescription("This curve retrieves the maximum between the two curves provided. The intersection between the curves is smoothed as their values approach within the provided range.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0).withWidth(100).withDescription("The range determines how much smoothing is applied. A good starting value would be ¼ of the known range of your child curves."))
            .addVariantOutput("CurveA", "CurveA", false, VARIANT_CURVES)
            .addVariantOutput("CurveB", "CurveB", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_SMOOTH_MIN = addNode(VARIANT_CURVES.variantNode("SmoothMin", "SmoothMin.Curve", "SmoothMin Curve"))
            .withDescription("This curve retrieves the minimum between the two curves provided. The intersection between the curves is smoothed as their values approach within the provided range.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0).withWidth(100).withDescription("The range determines how much smoothing is applied. A good starting value would be ¼ of the known range of your child curves."))
            .addVariantOutput("CurveA", "CurveA", false, VARIANT_CURVES)
            .addVariantOutput("CurveB", "CurveB", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_SUM = addNode(VARIANT_CURVES.variantNode("Sum", "Sum.Curve", "Sum Curve"))
            .withDescription("This adds the values of all the provided curves.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Curves", "Curves", true, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_DENSITY_ABS = addNode(VARIANT_DENSITY.variantNode("Abs", "Abs.Density", "Abs Density"))
            .withDescription("The output is the absolute value of the input.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_AMPLITUDE = addNode(VARIANT_DENSITY.variantNode("Amplitude", "Amplitude.Density", "[DEPRECATED] Amplitude Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addNodeOutput("FunctionForY", "FunctionForY", false, () -> HytaleGeneratorNodes.NODE_FUNCTION_FOR_Y)
            .withColorOverride("255,00,00")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_AMPLITUDE_CONSTANT = addNode(VARIANT_DENSITY.variantNode("AmplitudeConstant", "AmplitudeConstant.Density", "[DEPRECATED] AmplitudeConstant Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .withColorOverride("255,00,00")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_ANCHOR = addNode(VARIANT_DENSITY.variantNode("Anchor", "Anchor.Density", "Anchor Density"))
            .withDescription("Anchors the origin of the child field (input) to the contextual Anchor if it exists. It basically puts the {0, 0, 0} origin of the child Density at the position of the Anchor.\nFor a contextual Anchor to exist, a parent of this node must produce an Anchor. The Density ReturnType node, for example, leaves the cell's center as a contextual Anchor in its Density child's context.\nYou can also reverse the effect later down the line to move the origin back to the world's origin like in the screenshot below. The field is unanchored when it reaches the bottom branch of the Sum, but the top branch is still anchored.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("Reversed", "Reversed").withDefaultValue(false).withDescription("If true, the node will reverse the origin of the child to the world's origin, or the origin before the previous Anchor node."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_AND = addNode(VARIANT_DENSITY.variantNode("And", "And.Density", "And Density"))
            .withDescription("Returns 1.0 if all inputs are non-zero, otherwise 0.0.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "[0, infinite): Inputs.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_ANGLE = addNode(VARIANT_DENSITY.variantNode("Angle", "Angle.Density", "Angle Density"))
            .withDescription("The angle in degrees between two vectors, one of which is procedurally generated by a VectorProvider.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("IsAxis", "IsAxis").withDefaultValue(false))
            .addNodeOutput("Vector", "Vector", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Reference vector to compare against.")
            .addVariantOutput("VectorProvider", "VectorProvider", false, VARIANT_VECTOR_PROVIDERS, "Vector to compare.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_AXIS = addNode(VARIANT_DENSITY.variantNode("Axis", "Axis.Density", "Axis Density"))
            .withDescription("The Axis outputs a Density value in function of the distance from a provided Axis line that passes through the origin {0, 0, 0} of the field or through the anchor point if the IsAnchored flag is true. The provided Curve asset maps the distance to the output Density value.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("IsAnchored", "IsAnchored").withDefaultValue(false).withDescription("If true, the Axis node will anchor itself to the closest anchor. Although you could use an Anchor node to anchor an Axis Density node, this internal method doesn't produce some artifacts."))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES, "Determines the Density value at any distance from the axis.")
            .addNodeOutput("Axis", "Axis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Determines the axis from which the distance is used.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_BASE_HEIGHT = addNode(VARIANT_DENSITY.variantNode("BaseHeight", "BaseHeight.Density", "BaseHeight Density"))
            .withDescription("This node lets you reference a DecimalConstant from the WorldStructure.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("BaseHeightName", "BaseHeightName").withDefaultValue("").withWidth(250).withDescription("Name of the DecimalConstant to reference."))
            .addContent(Renode.checkboxContent("Distance", "Distance").withDefaultValue(true).withDescription("Toggles whether to output the raw Y coordinate of the BaseHeight or the distance from the BaseHeight from the query position."))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CACHE = addNode(VARIANT_DENSITY.variantNode("Cache", "Cache.Density", "Cache Density"))
            .withDescription("Caches the input for the current coordinates. The capacity determines how many coordinates' can be cached before having to drop the oldest one.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("Capacity", "Capacity").withDefaultValue(3).withDescription("Determines how many coordinates this cache can hold at once. A safe value is 3."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CEILING = addNode(VARIANT_DENSITY.variantNode("Ceiling", "Ceiling.Density", "[DEPRECATED] Ceiling Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Limit", "Limit").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CELL_NOISE_2D = addNode(VARIANT_DENSITY.variantNode("CellNoise2D", "CellNoise2D.Density", "CellNoise2D Density"))
            .withDescription("2D Voronoi noise.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Jitter", "Jitter").withDefaultValue(0.3).withWidth(100))
            .addContent(Renode.enumContent("CellType", "CellType").withValues("CellValue", "Distance", "Distance2", "Distance2Add", "Distance2Sub", "Distance2Mul", "Distance2Div").withDefaultValue("CellValue").withWidth(150))
            .addContent(Renode.floatContent("ScaleX", "ScaleX").withDefaultValue(50.0).withWidth(100))
            .addContent(Renode.floatContent("ScaleZ", "ScaleZ").withDefaultValue(50.0).withWidth(100))
            .addContent(Renode.integerSliderContent("Octaves", "Octaves", 0, 20, 1).withDefaultValue(1).withWidth(150))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CELL_NOISE_3D = addNode(VARIANT_DENSITY.variantNode("CellNoise3D", "CellNoise3D.Density", "CellNoise3D Density"))
            .withDescription("3D Voronoi noise.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Jitter", "Jitter").withDefaultValue(0.3).withWidth(100))
            .addContent(Renode.enumContent("CellType", "CellType").withValues("CellValue", "Distance", "Distance2", "Distance2Add", "Distance2Sub", "Distance2Mul", "Distance2Div").withDefaultValue("CellValue").withWidth(150))
            .addContent(Renode.floatContent("ScaleX", "ScaleX").withDefaultValue(50.0).withWidth(100))
            .addContent(Renode.floatContent("ScaleY", "ScaleY").withDefaultValue(50.0).withWidth(100))
            .addContent(Renode.floatContent("ScaleZ", "ScaleZ").withDefaultValue(50.0).withWidth(100))
            .addContent(Renode.integerSliderContent("Octaves", "Octaves", 0, 20, 1).withDefaultValue(1).withWidth(150))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CELL_WALL_DISTANCE = addNode(VARIANT_DENSITY.variantNode("CellWallDistance", "CellWallDistance.Density", "[EXPERIMENTAL] CellWallDistance Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CLAMP = addNode(VARIANT_DENSITY.variantNode("Clamp", "Clamp.Density", "Clamp Density"))
            .withDescription("This node ensures that the output is within the provided range which is defined by the two wall parameters. Input values that are inside the range don't change and inputs values outside the range are brought back to the range's extreme.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("WallA", "WallA").withDefaultValue(-1.0).withWidth(100).withDescription("Output values limit A."))
            .addContent(Renode.floatContent("WallB", "WallB").withDefaultValue(1.0).withWidth(100).withDescription("Output values limit B."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Density to be clamped.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_COMPARATOR = addNode(VARIANT_DENSITY.variantNode("Comparator", "Comparator.Density", "Comparator Density"))
            .withDescription("Compares two input values and returns -1 if the first input is smaller, 0 if they are equal, or 1 if the first input is greater.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input A.\n1: Input B.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CONSTANT = addNode(VARIANT_DENSITY.variantNode("Constant", "Constant.Density", "Constant Density"))
            .withDescription("Outputs a constant value.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CUBE = addNode(VARIANT_DENSITY.variantNode("Cube", "Cube.Density", "Cube Density"))
            .withDescription("The Cube outputs a Density value in function of the distance from the origin axis of the field. The provided Curve asset maps the distance to the output Density value.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES, "Maps the Distance from the origin to a Density value.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CUBOID = addNode(VARIANT_DENSITY.variantNode("Cuboid", "Cuboid.Density", "Cuboid Density"))
            .withDescription("The Cuboid is a deformed Cube. You can use a Scale vector to stretch and compress the Cube in different directions. You can spin it by giving it a new Y axis and a spin angle (in degrees).")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Spin", "Spin").withDefaultValue(0.0).withDescription("Determines the angle in degrees by which to spin the Ellipsoid around its Y axis."))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES, "Maps the Distance from the origin to a Density value.")
            .addNodeOutput("Scale", "Scale", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Determines how much to stretch the Cube in each direction.")
            .addNodeOutput("NewYAxis", "NewYAxis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Let's you rotate the field around its origin.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CURVE_MAPPER = addNode(VARIANT_DENSITY.variantNode("CurveMapper", "CurveMapper.Density", "CurveMapper Density"))
            .withDescription("This node maps the input to a Curve.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Density to remap.")
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES, "Maps the input Density value.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CYLINDER = addNode(VARIANT_DENSITY.variantNode("Cylinder", "Cylinder.Density", "Cylinder Density"))
            .withDescription("The Cylinder generates a cylindrical shape, crazy I know. You can spin it by giving it a new Y axis and a spin angle (in degrees).")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Spin", "Spin").withDefaultValue(0.0).withDescription("Determines the angle in degrees by which to spin the Ellipsoid around its original Y axis."))
            .addVariantOutput("AxialCurve", "AxialCurve", false, VARIANT_CURVES, "Maps the Distance from the Cylinder's XZ-plane to a Density value.")
            .addVariantOutput("RadialCurve", "RadialCurve", false, VARIANT_CURVES, "Maps the Distance from the Cylinder's Y axis to a Density value.")
            .addNodeOutput("NewYAxis", "NewYAxis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "In combination with the spin, this lets you rotate the Cylinder around its origin by aligning its original Y-axis with the provided one.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_DISTANCE = addNode(VARIANT_DENSITY.variantNode("Distance", "Distance.Density", "Distance Density"))
            .withDescription("The Distance outputs a value in function of the distance from the origin {0, 0, 0} of the field. The provided Curve asset maps the distance to the output Density value.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES, "Maps the Distance from the origin to a Density value.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_DISTANCE_TO_BIOME_EDGE = addNode(VARIANT_DENSITY.variantNode("DistanceToBiomeEdge", "DistanceToBiomeEdge.Density", "DistanceToBiomeEdge Density"))
            .withDescription("Outputs the distance to the nearest biome edge in blocks.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_DISTANCE_TO_GRAPH_EDGE = addNode(VARIANT_DENSITY.variantNode("DistanceToGraphEdge", "DistanceToGraphEdge.Density", "[DEV] DistanceToGraphEdge Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_ELLIPSOID = addNode(VARIANT_DENSITY.variantNode("Ellipsoid", "Ellipsoid.Density", "Ellipsoid Density"))
            .withDescription("The Ellipsoid is a deformed Sphere. You can use a Scale vector to stretch and compress the Sphere in different directions. You can spin it by giving it a new Y axis and a spin angle (in degrees).")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Spin", "Spin").withDefaultValue(0.0).withDescription("Determines the angle in degrees by which to spin the Ellipsoid around its Y axis."))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES, "Maps the Distance from the origin to a Density value.")
            .addNodeOutput("Scale", "Scale", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Determines how much to stretch the Sphere in each direction.")
            .addNodeOutput("NewYAxis", "NewYAxis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Let's you rotate the field around its origin.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_EQUAL = addNode(VARIANT_DENSITY.variantNode("Equal", "Equal.Density", "Equal Density"))
            .withDescription("Returns 1.0 if the two inputs are equal within Epsilon, otherwise 0.0. Set Epsilon to 0 for an exact comparison.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Epsilon", "Epsilon").withDefaultValue(0.0).withWidth(100).withDescription("Maximum allowed difference between the two inputs."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input A.\n1: Input B.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_EXPORTED = addNode(VARIANT_DENSITY.variantNode("Exported", "Exported.Density", "[EXPERIMENTAL] Exported Density"))
            .withDescription("Allows exporting a Density field as a single instance. Enabling the SingleInstance on this node ensures all importers share the same logic.\nBy default a completely different instance is create for every Imported node. When there are multiple Imported nodes that import the same exported key, a new instance of that exported Density tree will be created for each one of the Imported nodes. SingleInstance ensures all importers share the same underlying instance of the node tree.\nThis node can be used to optimize caching when an exported Density is imported multiple times in the same context and contains caches. The caches would be shared between the different imported instances.\nImportant: This is still an experimental feature and could cause unexpected behaviors if misused.")
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.checkboxContent("SingleInstance", "[EXPERIMENTAL] SingleInstance").withDefaultValue(false).withDescription("Enable to share the exported for all Imported nodes referencing this key."))
            .addContent(CONTENT_SKIP)
            .addVariantOutput("Inputs", "DensityInputs", true, VARIANT_DENSITY, "Density to export.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_FAST_GRADIENT_WARP = addNode(VARIANT_DENSITY.variantNode("FastGradientWarp", "FastGradientWarp.Density", "FastGradientWarp Density"))
            .withDescription("This is a faster implementation of the GradientWarp node. It warps the input Density field using an internal simplex noise generator.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("WarpLacunarity", "WarpLacunarity").withDefaultValue(2.0).withWidth(70).withDescription("The lacunarity of the internal simplex field."))
            .addContent(Renode.floatContent("WarpPersistence", "WarpPersistence").withDefaultValue(0.5).withWidth(70).withDescription("The persistence of the internal simplex field."))
            .addContent(Renode.floatContent("WarpScale", "WarpScale").withDefaultValue(1.0).withWidth(70).withDescription("This determines the scale of the internal warper noise field."))
            .addContent(Renode.integerContent("WarpOctaves", "WarpOctaves").withDefaultValue(1).withWidth(70).withDescription("The internal field's octaves."))
            .addContent(Renode.floatContent("WarpFactor", "WarpFactor").withDefaultValue(1.0).withWidth(70).withDescription("The maximum distance coordinates can be warped."))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(350))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_FLOOR = addNode(VARIANT_DENSITY.variantNode("Floor", "Floor.Density", "[DEPRECATED] Floor Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Limit", "Limit").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_GRADIENT = addNode(VARIANT_DENSITY.variantNode("Gradient", "Gradient.Density", "[DEPRECATED] Gradient Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SampleRange", "SampleRange").withDefaultValue(1.0).withWidth(70))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addNodeOutput("Axis", "Axis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_GRADIENT_WARP = addNode(VARIANT_DENSITY.variantNode("GradientWarp", "GradientWarp.Density", "GradientWarp Density"))
            .withDescription("Warps the first input based on the gradient of the second input Density field. This works similar to the legacy warping functionality, except it also works in 3D and you can plug any Density field into it.\nThis implementation is relatively expensive because it calculates the gradient of the input Density field. I recommend optimizing the use of this node by isolating and minimizing its use space. A fast version of this node can be implemented which would let you only use Simplex noise to warp. This will depend on the feedback and priorities.\nThis node incorporates a Cache2D so you don't need to use a Cache2D node on its output.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SampleRange", "SampleRange").withDefaultValue(1.0).withWidth(70).withDescription("Distance between samples. Recommended value: 1."))
            .addContent(Renode.floatContent("WarpFactor", "WarpFactor").withDefaultValue(1.0).withWidth(70).withDescription("With greater values you get more warping."))
            .addContent(Renode.checkboxContent("2D", "2D Output").withDefaultValue(false).withDescription("If true the output of this node is 2D. An internal Cache2D is used."))
            .addContent(Renode.floatContent("YFor2D", "Y for 2D").withDefaultValue(0.0).withDescription("Default is 0. The Y coordinate used from the input to calculate the gradient from."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Density that is warped.\n1: Warping source.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_GRAPH = addNode(VARIANT_DENSITY.variantNode("Graph", "Graph.Density", "[DEV] Graph Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("ContentLayer", "ContentLayer").withDefaultValue("").withWidth(350))
            .addContent(Renode.floatContent("BackgroundValue", "BackgroundValue").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("TransitionSlope", "TransitionSlope").withDefaultValue(2.5).withWidth(100))
            .addContent(Renode.floatContent("TransitionOffset", "TransitionOffset").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("TransitionSmooth", "TransitionSmooth").withDefaultValue(0.2).withWidth(100).withDescription("Smoothing width for the distance-based transition. Must be >= 0."))
            .addContent(Renode.integerContent("QueryBufferCapacity", "QueryBufferCapacity").withDefaultValue(3).withWidth(100).withDescription("Maximum number of cached query columns. Must be >= 1."))
            .addNodeOutput("GraphGenerator", "GraphGenerator", false, () -> HytaleGeneratorNodes.NODE_GRAPH_GENERATOR)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_GREATER_OR_EQUAL = addNode(VARIANT_DENSITY.variantNode("GreaterOrEqual", "GreaterOrEqual.Density", "GreaterOrEqual Density"))
            .withDescription("Returns 1.0 if the first input is greater than or equal to the second input, otherwise 0.0.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input A.\n1: Input B.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_GREATER_THAN = addNode(VARIANT_DENSITY.variantNode("GreaterThan", "GreaterThan.Density", "GreaterThan Density"))
            .withDescription("Returns 1.0 if the first input is greater than the second input, otherwise 0.0.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input A.\n1: Input B.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_IMPORTED = addNode(VARIANT_DENSITY.variantNode("Imported", "Imported.Density", "Imported Density"))
            .withDescription("Imports an exported Density asset.")
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350).withDescription("The exported Density."))
            .addContent(CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_INVERTER = addNode(VARIANT_DENSITY.variantNode("Inverter", "Inverter.Density", "Inverter Density"))
            .withDescription("The output is the input multiplied by -1.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_LESS_OR_EQUAL = addNode(VARIANT_DENSITY.variantNode("LessOrEqual", "LessOrEqual.Density", "LessOrEqual Density"))
            .withDescription("Returns 1.0 if the first input is less than or equal to the second input, otherwise 0.0.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input A.\n1: Input B.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_LESS_THAN = addNode(VARIANT_DENSITY.variantNode("LessThan", "LessThan.Density", "LessThan Density"))
            .withDescription("Returns 1.0 if the first input is less than the second input, otherwise 0.0.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input A.\n1: Input B.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_MAX = addNode(VARIANT_DENSITY.variantNode("Max", "Max.Density", "Max Density"))
            .withDescription("The output is the greatest value of all the inputs. If no inputs are provided it is 0.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "[0, infinite): Inputs.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_MIN = addNode(VARIANT_DENSITY.variantNode("Min", "Min.Density", "Min Density"))
            .withDescription("The output is the smallest value of all the inputs. If no inputs are provided it is 0.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "[0, infinite): Inputs.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_MIX = addNode(VARIANT_DENSITY.variantNode("Mix", "Mix.Density", "Mix Density"))
            .withDescription("Mixes two inputs. How much of each input to use in the mix is gauged by a third input called the gauge:\nWhere the Gauge is less or equal to 0.0: only Density A is used.\nWhere the Gauge is more or equal to 1.0: only Density B is used.\nWhere the Gauge is between 0.0 and 1.0: Density A and B are mixed proportional to the Gauge.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Density A.\n1: Density B.\n2: Gauge.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_MULTI_MIX = addNode(VARIANT_DENSITY.variantNode("MultiMix", "MultiMix.Density", "MultiMix Density"))
            .withDescription("Mixes multiple inputs. How much of each input to use in the mix is gauged by the last input called the Gauge.\nThe inputs are ordered top-down (in the node editor) and each input is assigned an index: starting with 0 for the top one and incrementing downwards.\nThe keys let you pin the different inputs to Gauge values. Where the Gauge input's value approaches a Key's value, the input referenced by that Key is stronger in the final result.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "Unlimited inputs, their order is the index starting at 0. The last input is the Gauge.")
            .addNodeOutput("Keys", "Keys", true, () -> HytaleGeneratorNodes.NODE_DENSITY_MULTI_MIX_KEY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_MULTI_MIX_KEY = addNode(Renode.node("Key.MultiMix.Density", "Key MultiMix Density"))
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100).withDescription("Pins the Density input to this value of the Gauge Density field. When the Gauge approaches this value, the output of the MultiMix appraoches the value of the Density field referenced by the index."))
            .addContent(Renode.integerContent("DensityIndex", "DensityIndex").withDefaultValue(-1).withWidth(40).withDescription("The number is the index of an input Density field."))
            .withColorOverride("Orange")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_MULTIPLIER = addNode(VARIANT_DENSITY.variantNode("Multiplier", "Multiplier.Density", "Multiplier Density"))
            .withDescription("The output is the multiplication of all the inputs.\nThe Multiplier node skips the remaining inputs after an input provides a Density value of 0. This can help you optimize your Density performance by ordering the Multiplier inputs with the cheapest mask first.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "[0, infinite): Inputs.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_NOR = addNode(VARIANT_DENSITY.variantNode("Nor", "Nor.Density", "Nor Density"))
            .withDescription("Returns 1.0 if no input is non-zero, otherwise 0.0.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "[0, infinite): Inputs.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_NORMALIZER = addNode(VARIANT_DENSITY.variantNode("Normalizer", "Normalizer.Density", "Normalizer Density"))
            .withDescription("It linearly remaps the input's range. The scale is defined by the FromMin, FromMax, ToMin and ToMax parameters.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("FromMin", "FromMin").withDefaultValue(-1.0).withWidth(100))
            .addContent(Renode.floatContent("FromMax", "FromMax").withDefaultValue(1.0).withWidth(100))
            .addContent(Renode.floatContent("ToMin", "ToMin").withDefaultValue(-1.0).withWidth(100))
            .addContent(Renode.floatContent("ToMax", "ToMax").withDefaultValue(1.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_NOT = addNode(VARIANT_DENSITY.variantNode("Not", "Not.Density", "Not Density"))
            .withDescription("Returns 1.0 if the input is zero, otherwise 0.0.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_OFFSET = addNode(VARIANT_DENSITY.variantNode("Offset", "Offset.Density", "[DEPRECATED] Offset Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addNodeOutput("FunctionForY", "FunctionForY", false, () -> HytaleGeneratorNodes.NODE_FUNCTION_FOR_Y)
            .withColorOverride("255,00,00")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_OFFSET_CONSTANT = addNode(VARIANT_DENSITY.variantNode("OffsetConstant", "OffsetConstant.Density", "[DEPRECATED] OffsetConstant Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .withColorOverride("255,00,00")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_OR = addNode(VARIANT_DENSITY.variantNode("Or", "Or.Density", "Or Density"))
            .withDescription("Returns 1.0 if any input is non-zero, otherwise 0.0.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "[0, infinite): Inputs.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_PLANE = addNode(VARIANT_DENSITY.variantNode("Plane", "Plane.Density", "Plane Density"))
            .withDescription("The Plane Density node allows you to define a Density field in function of the distance from a user-defined plane that passes through the field's origin {0, 0, 0} or through the anchor if the flag IsAnchored is enabled. You can granularly define the Density value using a Curve asset. The PlaneNormal vector determines the direction the plane is facing.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("IsAnchored", "IsAnchored").withDefaultValue(false))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES, "Determines the Density value at any distance from the plane.")
            .addNodeOutput("PlaneNormal", "PlaneNormal", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Determines the direction the plane is facing.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE = addNode(VARIANT_DENSITY.variantNode("PositionsCellNoise", "PositionsCellNoise.Density", "PositionsCellNoise Density"))
            .withDescription("Produces a 2D/3D density field in which the value is determined by each coordinate's distance from a field of Positions. You can use this asset to generate advanced Cell noise with control over the exact placement of the Cell's through the Positions asset. You can also configure how the distance is interpreted to produce the output. You can use the traditional Cell noise ReturnTypes or create your own curves. You can also sample the Cell value from another Density field asset.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(0.0).withWidth(100).withDescription("The maximum distance around each Position that it has an effect on the Density field. A good starting value is putting it a bit over half the distance between two of your Position points. Greater values have a greater impact on performance."))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "This provides the Positions of each cell's core.")
            .addNodeOutput("DistanceFunction", "DistanceFunction", false, () -> HytaleGeneratorNodes.NODE_DENSITY_POSITIONS_CELL_NOISE_DISTANCE_FUNCTION, "This determines how the distance is calculated.")
            .addVariantOutput("ReturnType", "ReturnType", false, VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES, "This determines how the distance from each Position point is interpreted to produce the density field.")
            .addCategory(CATEGORY_DENSITY)
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_DISTANCE_FUNCTION = addNode(Renode.node("DistanceFunction.PositionsCellNoise.Density", "Distance Function"))
            .withDescription("Determines the way in which the distance to the closest Position is calculated.")
            .addContent(Renode.enumContent("Type", "Type").withValues("Euclidean", "Manhattan").withDefaultValue("Euclidean").withWidth(100))
            .withColorOverride("Olive")
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_CELL_VALUE = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("CellValue", "CellValue.ReturnType.PositionsCellNoise.Density", "CellValue ReturnType"))
            .withDescription("The Density value is constant inside each cell and is sampled from the provided Densty field.")
            .addContent(Renode.floatContent("DefaultValue", "DefaultValue").withDefaultValue(0.0).withWidth(100).withDescription("This value is used outside of cells. This can happen when the field's MaxDistance value is smaller than the distance between some Positions."))
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY, "The Density value of each cell is sampled from this field at the cell's core Position point.")
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_CURVE = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Curve", "Curve.ReturnType.PositionsCellNoise.Density", "Curve ReturnType"))
            .withDescription("The Curve ReturnType allows you to use a Curve asset to define the value of the Density field in terms of its distance from the Positions.")
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES, "The Density value of each cell is defined by the curve. The curve's input is the distance in blocks between the closest Position, and the Curve's output becomes the field's value.")
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DENSITY = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Density", "Density.ReturnType.PositionsCellNoise.Density", "Density ReturnType"))
            .withDescription("The cell is populated with a Density field. The Density field is picked from a list of Delimiters. The Delimiters are picked if the ChoiceDensity field is within their range. The ChoiceDensity field's value is sampled at the origin position of the cell.")
            .addContent(Renode.floatContent("DefaultValue", "DefaultValue").withDefaultValue(0.0).withWidth(100).withDescription("This value is used outside of cells. This can happen when the field's MaxDistance value is smaller than the distance between some Positions."))
            .addVariantOutput("ChoiceDensity", "ChoiceDensity", false, VARIANT_DENSITY, "Benefits from a Cache Density. Picks the delimiter to use for a Cell. This field is sampled at each Cell's origin.")
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DENSITY_DELIMITER, "Assign Density fields to cells based on the ChoiceDensity value at the Cell's origin.")
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DENSITY_DELIMITER = addNode(Renode.node("Delimiter.Density.ReturnType.PositionsCellNoise.Density", "Delimiter"))
            .addContent(Renode.floatContent("From", "From").withDefaultValue(-1.0).withWidth(70))
            .addContent(Renode.floatContent("To", "To").withDefaultValue(1.0).withWidth(70))
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .withColorOverride("Orange");
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DISTANCE = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Distance", "Distance.ReturnType.PositionsCellNoise.Density", "Distance ReturnType"))
            .withDescription("The Distance ReturnType works like the traditional CellNoise's “Distance” return type.")
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DISTANCE_2 = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Distance2", "Distance2.ReturnType.PositionsCellNoise.Density", "Distance2 ReturnType"))
            .withDescription("The Distance2 ReturnType works like the traditional CellNoise's “Distance2” return type.")
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DISTANCE_2_ADD = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Distance2Add", "Distance2Add.ReturnType.PositionsCellNoise.Density", "Distance2Add ReturnType"))
            .withDescription("The Distance2Add ReturnType works like the traditional CellNoise's 'Distance2Add' return type.")
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DISTANCE_2_DIV = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Distance2Div", "Distance2Div.ReturnType.PositionsCellNoise.Density", "Distance2Div ReturnType"))
            .withDescription("The Distance2Div ReturnType works like the traditional CellNoise's 'Distance2Div' return type.")
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DISTANCE_2_MUL = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Distance2Mul", "Distance2Mul.ReturnType.PositionsCellNoise.Density", "Distance2Mul ReturnType"))
            .withDescription("The Distance2Mul ReturnType works like the traditional CellNoise's 'Distance2Mul' return type.")
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DISTANCE_2_SUB = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Distance2Sub", "Distance2Sub.ReturnType.PositionsCellNoise.Density", "Distance2Sub ReturnType"))
            .withDescription("The Distance2Sub ReturnType works like the traditional CellNoise's 'Distance2Sub' return type.")
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_PINCH = addNode(VARIANT_DENSITY.variantNode("PositionsPinch", "PositionsPinch.Density", "PositionsPinch Density"))
            .withDescription("Pinches or expands the first input's Density field around the Positions.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(0.0).withWidth(100).withDescription("The value represents how big the area of effect is in block units."))
            .addContent(Renode.checkboxContent("NormalizeDistance", "NormalizeDistance").withDefaultValue(true).withDescription("Default is true. If true then the Curve's input and output unit is normalized to the MaxDistance value, otherwise if false the Curve's input and output unit is in blocks."))
            .addContent(Renode.checkboxContent("HorizontalPinch", "HorizontalPinch").withDefaultValue(true).withDescription("Default is false. If true, the input is pinched horizontally only."))
            .addContent(Renode.floatContent("PositionsMaxY", "PositionsMaxY").withDefaultValue(1.0E-6).withWidth(100).withDescription("Determines the upper Y level bound of the region queried from the Positions field. Any Positions that are at or above this value are ignored."))
            .addContent(Renode.floatContent("PositionsMinY", "PositionsMinY").withDefaultValue(0.0).withWidth(100).withDescription("Determines the lower Y level bound of the region queried from the Positions field. Any Positions that are below this value are ignored."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "The Positions are the anchors that pinch and expand the Density field around them.")
            .addVariantOutput("PinchCurve", "PinchCurve", false, VARIANT_CURVES, "The curve determines how the Density field is pinched or expanded depending on how close it is to a position.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_TWIST = addNode(VARIANT_DENSITY.variantNode("PositionsTwist", "PositionsTwist.Density", "PositionsTwist Density"))
            .withDescription("Twists the first input's Density field around the Positions.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(0.0).withWidth(100).withDescription("The value represents how big the area of effect is in block units."))
            .addContent(Renode.checkboxContent("NormalizeDistance", "NormalizeDistance").withDefaultValue(true).withDescription("Default is true. If true then the Curve's input unit is normalized to the MaxDistance value, otherwise if false the Curve's input unit is in blocks."))
            .addContent(Renode.checkboxContent("ZeroPositionsY", "ZeroPositionsY").withDefaultValue(false).withDescription("Flattens the positions input to y=0."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "The Positions are the anchors that pinch and expand the Density field around them.")
            .addVariantOutput("TwistCurve", "TwistCurve", false, VARIANT_CURVES, "The curve determines how the Density field is twisted depending on how close it is to a position.")
            .addNodeOutput("TwistAxis", "TwistAxis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "The axis around which the twisting happens.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_POW = addNode(VARIANT_DENSITY.variantNode("Pow", "Pow.Density", "Pow Density"))
            .withDescription("The output is the input taken to the power of the given exponent.\nFor negative inputs, this node uses a modified function to always return values that make sense and are useful.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Exponent", "Exponent").withDefaultValue(2.0).withWidth(100).withDescription("A good starting value would be 2."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_ROTATOR = addNode(VARIANT_DENSITY.variantNode("Rotator", "Rotator.Density", "Rotator Density"))
            .withDescription("Aligns the input Density field so that its Y axis is aligned with the provided axis, and spins it around the new axis by the provided angle.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SpinAngle", "SpinAngle").withDefaultValue(0.0).withDescription("The angle in degrees to spin the field around the new axis."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addNodeOutput("NewYAxis", "NewYAxis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Y-axis of the rotated field rlative to the parent's y-axis.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SCALE = addNode(VARIANT_DENSITY.variantNode("Scale", "Scale.Density", "Scale Density"))
            .withDescription("Stretches or contracts the input Density field. The input's Density field is scaled by the factor's provided for each axis. Values above 1 stretches the field and values below 1 contract it. Values under 0 flip the field.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("ScaleX", "ScaleX").withDefaultValue(1.0).withWidth(70))
            .addContent(Renode.floatContent("ScaleY", "ScaleY").withDefaultValue(1.0).withWidth(70))
            .addContent(Renode.floatContent("ScaleZ", "ScaleZ").withDefaultValue(1.0).withWidth(70))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SELECTOR = addNode(VARIANT_DENSITY.variantNode("Selector", "Selector.Density", "Selector Density"))
            .withDescription("Selects between two density fields based on a condition. If the condition is non-zero, the Then input is returned. Otherwise the Else input is returned.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Then.\n1: Else.\n2: Condition.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SHELL = addNode(VARIANT_DENSITY.variantNode("Shell", "Shell.Density", "Shell Density"))
            .withDescription("The Shell Density node allows you to define regions of the shell around the origin {0, 0, 0} of the field based on the direction and the distance from origin. The angles, thickness and Density values of the shell are fully configurable through Curve assets.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("Mirror", "Mirror").withDefaultValue(false).withDescription("If true then the angle is mirrored in both directions of the axis."))
            .addVariantOutput("AngleCurve", "AngleCurve", false, VARIANT_CURVES, "Determines the Density value at any given angle from the axis.")
            .addVariantOutput("DistanceCurve", "DistanceCurve", false, VARIANT_CURVES, "Determines the Density value at any distance from the origin.")
            .addNodeOutput("Axis", "Axis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Determines the axis against which the angle is calculated.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SIMPLEX_NOISE_2D = addNode(VARIANT_DENSITY.variantNode("SimplexNoise2D", "SimplexNoise2D.Density", "SimplexNoise2D Density"))
            .withDescription("Outputs a value in the range [-1, 1] from a 2D Simplex noise field that varies on the x/z plane. This node automatically caches the value per x/z column.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Lacunarity", "Lacunarity").withDefaultValue(2.0).withWidth(100).withDescription("Impacts the scale of each consecutive octave. A good starting value would be 2.0, which results in each consecutive octave having details that are 2x smaller than the previous. Higher values result in grainier noise."))
            .addContent(Renode.floatContent("Persistence", "Persistence").withDefaultValue(0.5).withWidth(100))
            .addContent(Renode.floatContent("Scale", "Scale").withDefaultValue(50.0).withWidth(100).withDescription("Represents the field's period distance in blocks. Greater values stretch the noise field outward. A good starting value would be 50."))
            .addContent(Renode.integerSliderContent("Octaves", "Octaves", 1, 10, 1).withDefaultValue(1).withWidth(150).withDescription("Greater values result in more detail. A good starting value would be 4. Requiring values over 10 are uncommon."))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SIMPLEX_NOISE_3D = addNode(VARIANT_DENSITY.variantNode("SimplexNoise3D", "SimplexNoise3D.Density", "SimplexNoise3D Density"))
            .withDescription("Outputs a value in the range [-1, 1] from a 3D Simplex noise field that varies on the x/y/z space.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Lacunarity", "Lacunarity").withDefaultValue(2.0).withWidth(100).withDescription("Impacts the scale of each consecutive octave. A good starting value would be 2.0, which results in each consecutive octave having details that are 2x smaller than the previous. Higher values result in grainier noise."))
            .addContent(Renode.floatContent("Persistence", "Persistence").withDefaultValue(0.5).withWidth(100).withDescription("Multiplies the intensity of each consecutive octave. A good starting value would be 0.5, which results in each consecutive octave being half as strong as the previous."))
            .addContent(Renode.floatContent("ScaleXZ", "ScaleXZ").withDefaultValue(50.0).withWidth(100).withDescription("Represents the field's period distance in blocks on the horizontal XZ plane. Greater values stretch the noise field outward. A good starting value would be 50."))
            .addContent(Renode.floatContent("ScaleY", "ScaleY").withDefaultValue(50.0).withWidth(100).withDescription("Represents the field's period distance in blocks on the vertical Y axis. Greater values stretch the noise field outward. A good starting value would be 50."))
            .addContent(Renode.integerSliderContent("Octaves", "Octaves", 1, 10, 1).withDefaultValue(1).withWidth(150).withDescription("Greater values result in more detail. A good starting value would be 4. Requiring values over 10 are uncommon."))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SLIDER = addNode(VARIANT_DENSITY.variantNode("Slider", "Slider.Density", "Slider Density"))
            .withDescription("Slides the input Density field in the direction of the provided vector.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SlideX", "SlideX").withDefaultValue(0.0).withWidth(70))
            .addContent(Renode.floatContent("SlideY", "SlideY").withDefaultValue(0.0).withWidth(70))
            .addContent(Renode.floatContent("SlideZ", "SlideZ").withDefaultValue(0.0).withWidth(70))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SMOOTH_CEILING = addNode(VARIANT_DENSITY.variantNode("SmoothCeiling", "SmoothCeiling.Density", "[DEPRECATED] SmoothCeiling Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Range", "Value").withDefaultValue(0.2).withWidth(100))
            .addContent(Renode.floatContent("Limit", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SMOOTH_CLAMP = addNode(VARIANT_DENSITY.variantNode("SmoothClamp", "SmoothClamp.Density", "SmoothClamp Density"))
            .withDescription("This node ensures that the output is within the provided range which is defined by the two wall parameters. The concept is similar to the Clamp node documented above, but the output is smoothed to the limits by the provided range value.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("WallA", "WallA").withDefaultValue(-1.0).withWidth(100).withDescription("Limit."))
            .addContent(Renode.floatContent("WallB", "WallB").withDefaultValue(1.0).withWidth(100).withDescription("Limit."))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.2).withWidth(100).withDescription("Larger values result in smoother transition when the input approaches or exceeds the walls."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SMOOTH_FLOOR = addNode(VARIANT_DENSITY.variantNode("SmoothFloor", "SmoothFloor.Density", "[DEPRECATED] SmoothFloor Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Range", "Value").withDefaultValue(0.2).withWidth(100))
            .addContent(Renode.floatContent("Limit", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SMOOTH_MAX = addNode(VARIANT_DENSITY.variantNode("SmoothMax", "SmoothMax.Density", "SmoothMax Density"))
            .withDescription("The output is a smoothed maximum between the two inputs.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Range", "Value").withDefaultValue(0.2).withWidth(100).withDescription("Greater values result in more smoothing. A good starter value could be 0.2."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input A.\n1: Input B.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SMOOTH_MIN = addNode(VARIANT_DENSITY.variantNode("SmoothMin", "SmoothMin.Density", "SmoothMin Density"))
            .withDescription("The output is a smoothed minimum between the two inputs. This node works the same as SmoothMax, please read that node's description.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Range", "Value").withDefaultValue(0.2).withWidth(100).withDescription("Greater values result in more smoothing. A good starter value could be 0.2."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input A.\n1: Input B.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SQRT = addNode(VARIANT_DENSITY.variantNode("Sqrt", "Sqrt.Density", "Sqrt Density"))
            .withDescription("The output is the square root value of the input.\nFor negative inputs, this node uses a modified function to always return values that make sense and are useful.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SUM = addNode(VARIANT_DENSITY.variantNode("Sum", "Sum.Density", "Sum Density"))
            .withDescription("The output is the sum of all the inputs.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SWITCH = addNode(VARIANT_DENSITY.variantNode("Switch", "Switch.Density", "Switch Density"))
            .withDescription("Lets you switch between multiple Density branches based on the contextual SwitchState. The SwitchState is a string that can be placed in the context of a Density tree using a SwitchState Density node. The default SwitchState of a Density tree is 'Default'.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("SwitchCases", "SwitchCases", true, () -> HytaleGeneratorNodes.NODE_DENSITY_SWITCH_CASE, "The possible paths to switch into based on the parent's SwitchState.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SWITCH_CASE = addNode(Renode.node("Case.Switch.Density", "Switch Case"))
            .addContent(Renode.smallStringContent("CaseState", "CaseState").withDefaultValue("Default").withWidth(250))
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SWITCH_STATE = addNode(VARIANT_DENSITY.variantNode("SwitchState", "SwitchState.Density", "SwitchState Density"))
            .withDescription("Sets the contextual SwitchState for the downstream Density branch.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("SwitchState", "SwitchState").withDefaultValue("").withWidth(250).withDescription("Name of the SwitchState to set for the children of this node."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_TERRAIN = addNode(VARIANT_DENSITY.variantNode("Terrain", "Terrain.Density", "Terrain Density"))
            .withDescription("Outputs the world's interpolated terrain Density.\nThis should only be used as part of a biome's MaterialProvider nodes. This won't work if used in the Terrain's Density nodes.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_TRIG = addNode(VARIANT_DENSITY.variantNode("Trig", "Trig.Density", "Trig Density"))
            .withDescription("The output is a trigonometric function of the input.\nThe input is read in radians, after multiplication by InputScale. Density values usually stay near [-1, 1], which is less than a fifth of a radian cycle. Set InputScale to about 6.28 to sweep one full cycle over that range.\nThe output is always finite. Asin and Acos clamp the input to [-1, 1], and Tan clamps its output.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.enumContent("Function", "Function").withValues("Sin", "Cos", "Tan", "Asin", "Acos", "Atan").withDefaultValue("Sin").withWidth(150))
            .addContent(Renode.floatContent("InputScale", "InputScale").withDefaultValue(1.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_VECTOR_WARP = addNode(VARIANT_DENSITY.variantNode("VectorWarp", "VectorWarp.Density", "VectorWarp Density"))
            .withDescription("Warps the input along the provided vector. The amount of warping is determined by the intensity of the second input Density field and the WarpFactor.\nFor example, if your warp field (second input) has a value of 0.5 and the WarpFactor is 15, then the number of blocks the first input will be warped by in the direction of the vector is 7.5 units (blocks),15 x 0.5 = 7.5.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("WarpFactor", "WarpFactor").withDefaultValue(1.0).withWidth(70).withDescription("With greater values you get more warping."))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Density to warp.\n1: Warp source.")
            .addNodeOutput("WarpVector", "WarpVector", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Can be any vector. This determines the direction in which the warping happens. Negative values of the factor or the warping density field will result in flipped warping direction.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_WHITE_NOISE = addNode(VARIANT_DENSITY.variantNode("WhiteNoise", "WhiteNoise.Density", "WhiteNoise Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_XOR = addNode(VARIANT_DENSITY.variantNode("Xor", "Xor.Density", "Xor Density"))
            .withDescription("Returns 1.0 if an odd number of inputs are non-zero, otherwise 0.0.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "[0, infinite): Inputs.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_X_OVERRIDE = addNode(VARIANT_DENSITY.variantNode("XOverride", "XOverride.Density", "XOverride Density"))
            .withDescription("Overrides the X coordinate the input sees.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_X_VALUE = addNode(VARIANT_DENSITY.variantNode("XValue", "XValue.Density", "XValue Density"))
            .withDescription("The local X coordinate.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_Y_OVERRIDE = addNode(VARIANT_DENSITY.variantNode("YOverride", "YOverride.Density", "YOverride Density"))
            .withDescription("Overrides the Y coordinate the input sees.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_Y_SAMPLED = addNode(VARIANT_DENSITY.variantNode("YSampled", "YSampled.Density", "YSampled Density"))
            .withDescription("Reduces the performance cost of its child Density by interpolating between spread-out samples along the Y-axis.\nInstead of generating the child's Density value for every single coordinate, it generates the child's value in intervals determined by the SampleDistance and SampleOffset and interpolates the value between the samples.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SampleDistance", "SampleDistance").withDefaultValue(4.0).withDescription("Safe starting value: 4.0. Determines how far apart the samples are taken. Larger numbers result in more performance savings but less precise terrain vertically."))
            .addContent(Renode.floatContent("SampleOffset", "SampleOffset").withDefaultValue(0.0).withDescription("Safe starting value: 0.0. Allows for non-zero-aligned sample distribution."))
            .addContent(Renode.checkboxContent("Interpolate", "Interpolate").withDefaultValue(true).withDescription("Enables the smooth interpolation between the samples."))
            .addVariantOutput("Inputs", "Input", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_Y_VALUE = addNode(VARIANT_DENSITY.variantNode("YValue", "YValue.Density", "YValue Density"))
            .withDescription("The local Y coordinate.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_Z_OVERRIDE = addNode(VARIANT_DENSITY.variantNode("ZOverride", "ZOverride.Density", "ZOverride Density"))
            .withDescription("Overrides the Z coordinate the input sees.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY, "0: Input.")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_Z_VALUE = addNode(VARIANT_DENSITY.variantNode("ZValue", "ZValue.Density", "ZValue Density"))
            .withDescription("The local Z coordinate.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DIRECTIONALITY_IMPORTED = addNode(VARIANT_DIRECTIONALITY.variantNode("Imported", "Imported.Directionality", "Imported Directionality"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_DIRECTIONALITY);
    public static final NodeBuilder NODE_DIRECTIONALITY_PATTERN = addNode(VARIANT_DIRECTIONALITY.variantNode("Pattern", "Pattern.Directionality", "Pattern Directionality"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.smallStringContent("InitialDirection", "InitialDirection").withDefaultValue("N").withWidth(40))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(350))
            .addVariantOutput("NorthPattern", "NorthPattern", false, VARIANT_PATTERNS)
            .addVariantOutput("SouthPattern", "SouthPattern", false, VARIANT_PATTERNS)
            .addVariantOutput("EastPattern", "EastPattern", false, VARIANT_PATTERNS)
            .addVariantOutput("WestPattern", "WestPattern", false, VARIANT_PATTERNS)
            .addCategory(CATEGORY_DIRECTIONALITY);
    public static final NodeBuilder NODE_DIRECTIONALITY_RANDOM = addNode(VARIANT_DIRECTIONALITY.variantNode("Random", "Random.Directionality", "Random Directionality"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(350))
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addCategory(CATEGORY_DIRECTIONALITY);
    public static final NodeBuilder NODE_DIRECTIONALITY_STATIC = addNode(VARIANT_DIRECTIONALITY.variantNode("Static", "Static.Directionality", "Static Directionality"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.integerContent("Rotation", "Rotation").withDefaultValue(0).withWidth(50))
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addCategory(CATEGORY_DIRECTIONALITY);
    public static final NodeBuilder NODE_ENVIRONMENT_PROVIDER_CONSTANT = addNode(VARIANT_ENVIRONMENT_PROVIDERS.variantNode("Constant", "Constant.EnvironmentProvider", "Constant EnvironmentProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Environment", "Environment").withDefaultValue("Unknown").withWidth(150))
            .addCategory(CATEGORY_ENVIRONMENT_PROVIDERS);
    public static final NodeBuilder NODE_ENVIRONMENT_PROVIDER_DENSITY_DELIMITED = addNode(VARIANT_ENVIRONMENT_PROVIDERS.variantNode("DensityDelimited", "DensityDelimited.EnvironmentProvider", "DensityDelimited EnvironmentProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_ENVIRONMENT_PROVIDER_DENSITY_DELIMITED_DELIMITER)
            .addCategory(CATEGORY_ENVIRONMENT_PROVIDERS);
    public static final NodeBuilder NODE_ENVIRONMENT_PROVIDER_DENSITY_DELIMITED_DELIMITER = addNode(Renode.node("Delimiter.DensityDelimited.EnvironmentProvider", "Delimiter DDEP"))
            .addVariantOutput("Environment", "Environment", false, VARIANT_ENVIRONMENT_PROVIDERS)
            .addNodeOutput("Range", "Range", false, () -> HytaleGeneratorNodes.NODE_RANGE_DECIMAL)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_ENVIRONMENT_PROVIDERS);
    public static final NodeBuilder NODE_FUNCTION_FOR_Y = addNode(Renode.node("FunctionForY", "FunctionForY"))
            .addNodeOutput("Points", "Points", true, () -> HytaleGeneratorNodes.NODE_FUNCTION_FOR_Y_POINT)
            .withColorOverride("Orange");
    public static final NodeBuilder NODE_FUNCTION_FOR_Y_POINT = addNode(Renode.node("Point.FunctionForY", "FunctionForY Point"))
            .addContent(Renode.floatContent("Y", "Y").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("Out", "Out").withDefaultValue(0.0).withWidth(100))
            .withColorOverride("Orange");
    public static final NodeBuilder NODE_GRAPH_CONTENT_PREDICATE_AND = addNode(VARIANT_GRAPH_CONTENT_PREDICATES.variantNode("And", "And.ContentPredicate", "[DEV] And ContentPredicate"))
            .withDescription("Returns true only if all child predicates pass for the node's content set.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("ContentPredicates", "ContentPredicates", true, VARIANT_GRAPH_CONTENT_PREDICATES)
            .addCategory(CATEGORY_GRAPH_CONTENT_PREDICATE);
    public static final NodeBuilder NODE_GRAPH_CONTENT_PREDICATE_CONSTANT = addNode(VARIANT_GRAPH_CONTENT_PREDICATES.variantNode("Constant", "Constant.ContentPredicate", "[DEV] Constant ContentPredicate"))
            .withDescription("Always returns the configured boolean value for any content set.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("Value", "Value").withDefaultValue(true))
            .addCategory(CATEGORY_GRAPH_CONTENT_PREDICATE);
    public static final NodeBuilder NODE_GRAPH_CONTENT_PREDICATE_IMPORTED = addNode(VARIANT_GRAPH_CONTENT_PREDICATES.variantNode("Imported", "Imported.ContentPredicate", "[DEV] Imported ContentPredicate"))
            .withDescription("Imports an exported ContentPredicate.")
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350).withDescription("The exported ContentPredicate name."))
            .addContent(CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH_CONTENT_PREDICATE);
    public static final NodeBuilder NODE_GRAPH_CONTENT_PREDICATE_NOT = addNode(VARIANT_GRAPH_CONTENT_PREDICATES.variantNode("Not", "Not.ContentPredicate", "[DEV] Not ContentPredicate"))
            .withDescription("Inverts the result of the child predicate for the node's content set.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("ContentPredicate", "ContentPredicate", false, VARIANT_GRAPH_CONTENT_PREDICATES)
            .addCategory(CATEGORY_GRAPH_CONTENT_PREDICATE);
    public static final NodeBuilder NODE_GRAPH_CONTENT_PREDICATE_OR = addNode(VARIANT_GRAPH_CONTENT_PREDICATES.variantNode("Or", "Or.ContentPredicate", "[DEV] Or ContentPredicate"))
            .withDescription("Returns true if any child predicate passes for the node's content set.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("ContentPredicates", "ContentPredicates", true, VARIANT_GRAPH_CONTENT_PREDICATES)
            .addCategory(CATEGORY_GRAPH_CONTENT_PREDICATE);
    public static final NodeBuilder NODE_GRAPH_CONTENT_PREDICATE_SET = addNode(VARIANT_GRAPH_CONTENT_PREDICATES.variantNode("Set", "Set.ContentPredicate", "[DEV] Set ContentPredicate"))
            .withDescription("Returns true when any configured tag is present in the node's content set.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.listContent("ContentTags", "ContentTags", "String").withWidth(350))
            .addCategory(CATEGORY_GRAPH_CONTENT_PREDICATE);
    public static final NodeBuilder NODE_GRAPH_CONTENT_SUPPLIER_CONSTANT = addNode(VARIANT_GRAPH_CONTENT_SUPPLIERS.variantNode("Constant", "Constant.ContentSupplier", "[DEV] Constant ContentSupplier"))
            .withDescription("Always assigns the configured node content.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Content", "Content", false, () -> HytaleGeneratorNodes.NODE_GRAPH_NODE_CONTENT)
            .addCategory(CATEGORY_GRAPH_CONTENT_SUPPLIER);
    public static final NodeBuilder NODE_GRAPH_CONTENT_SUPPLIER_IMPORTED = addNode(VARIANT_GRAPH_CONTENT_SUPPLIERS.variantNode("Imported", "Imported.ContentSupplier", "[DEV] Imported ContentSupplier"))
            .withDescription("Imports an exported ContentSupplier.")
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350).withDescription("The exported ContentSupplier name."))
            .addContent(CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH_CONTENT_SUPPLIER);
    public static final NodeBuilder NODE_GRAPH_CONTENT_SUPPLIER_WEIGHTED = addNode(VARIANT_GRAPH_CONTENT_SUPPLIERS.variantNode("Weighted", "Weighted.ContentSupplier", "[DEV] Weighted ContentSupplier"))
            .withDescription("Randomly assigns content from a weighted list of suppliers.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addNodeOutput("Entries", "Entries", true, () -> HytaleGeneratorNodes.NODE_GRAPH_CONTENT_SUPPLIER_WEIGHTED_WEIGHT)
            .addCategory(CATEGORY_GRAPH_CONTENT_SUPPLIER);
    public static final NodeBuilder NODE_GRAPH_CONTENT_SUPPLIER_WEIGHTED_WEIGHT = addNode(Renode.node("Entry.Weighted.ContentSupplier", "[DEV] Entry | Weighted ContentSupplier"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(150))
            .addVariantOutput("ContentSupplier", "ContentSupplier", false, VARIANT_GRAPH_CONTENT_SUPPLIERS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_ACTION_DELETE = addNode(VARIANT_GRAPH_EDGE_ACTIONS.variantNode("Delete", "Delete.EdgeAction", "[DEV] Delete EdgeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_ACTION_EMPTY = addNode(VARIANT_GRAPH_EDGE_ACTIONS.variantNode("Empty", "Empty.EdgeAction", "[DEV] Empty EdgeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_ACTION_IMPORTED = addNode(VARIANT_GRAPH_EDGE_ACTIONS.variantNode("Imported", "Imported.EdgeAction", "[DEV] Imported EdgeAction"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350))
            .addContent(CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_ACTION_NODES = addNode(VARIANT_GRAPH_EDGE_ACTIONS.variantNode("Nodes", "Nodes.EdgeAction", "[DEV] Nodes EdgeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("NodeAction", "NodeAction", false, VARIANT_GRAPH_NODE_ACTIONS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_ACTION_PROXY = addNode(VARIANT_GRAPH_EDGE_ACTIONS.variantNode("Proxy", "Proxy.EdgeAction", "[DEV] Proxy EdgeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxProxyDistance", "MaxProxyDistance").withDefaultValue(0.0))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addVariantOutput("HostNodeSelector", "HostNodeSelector", false, VARIANT_GRAPH_NODE_SELECTORS)
            .addVariantOutput("Normal", "Normal", false, VARIANT_VECTOR_PROVIDERS)
            .addVariantOutput("AngleToNormal", "AngleToNormal", false, VARIANT_DENSITY)
            .addVariantOutput("SpinAngle", "SpinAngle", false, VARIANT_DENSITY)
            .addVariantOutput("ProxyDistance", "ProxyDistance", false, VARIANT_DENSITY)
            .addVariantOutput("ProxyContent", "ProxyContent", false, VARIANT_GRAPH_CONTENT_SUPPLIERS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_ACTION_SELECTOR = addNode(VARIANT_GRAPH_EDGE_ACTIONS.variantNode("Selector", "Selector.EdgeAction", "[DEV] Selector EdgeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("EdgeSelector", "EdgeSelector", false, VARIANT_GRAPH_EDGE_SELECTORS)
            .addVariantOutput("EdgeAction", "EdgeAction", false, VARIANT_GRAPH_EDGE_ACTIONS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_ACTION_SPLITTER = addNode(VARIANT_GRAPH_EDGE_ACTIONS.variantNode("Splitter", "Splitter.EdgeAction", "[DEV] Splitter EdgeAction"))
            .withDescription("Replaces an edge with evenly spaced nodes along it, then deletes the original edge.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("NodeCount", "NodeCount").withDefaultValue(0))
            .addVariantOutput("Content", "Content", false, VARIANT_GRAPH_CONTENT_SUPPLIERS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_SELECTOR_ALL = addNode(VARIANT_GRAPH_EDGE_SELECTORS.variantNode("All", "All.EdgeSelector", "[DEV] All EdgeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_SELECTOR_AND = addNode(VARIANT_GRAPH_EDGE_SELECTORS.variantNode("And", "And.EdgeSelector", "[DEV] And EdgeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("EdgeSelectors", "EdgeSelectors", true, VARIANT_GRAPH_EDGE_SELECTORS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_SELECTOR_ANGLE = addNode(VARIANT_GRAPH_EDGE_SELECTORS.variantNode("Angle", "Angle.EdgeSelector", "[DEV] Angle EdgeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Reference", "Reference", false, VARIANT_VECTOR_PROVIDERS)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_RANGE_DECIMAL)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_SELECTOR_IMPORTED = addNode(VARIANT_GRAPH_EDGE_SELECTORS.variantNode("Imported", "Imported.EdgeSelector", "[DEV] Imported EdgeSelector"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350))
            .addContent(CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_SELECTOR_LENGTH = addNode(VARIANT_GRAPH_EDGE_SELECTORS.variantNode("Length", "Length.EdgeSelector", "[DEV] Length EdgeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_RANGE_DECIMAL)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_SELECTOR_NODES = addNode(VARIANT_GRAPH_EDGE_SELECTORS.variantNode("Nodes", "Nodes.EdgeSelector", "[DEV] Nodes EdgeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.enumContent("Operator", "Operator").withValues("And", "Or").withDefaultValue("And"))
            .addVariantOutput("NodeSelector", "NodeSelector", false, VARIANT_GRAPH_NODE_SELECTORS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_SELECTOR_NOT = addNode(VARIANT_GRAPH_EDGE_SELECTORS.variantNode("Not", "Not.EdgeSelector", "[DEV] Not EdgeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("EdgeSelector", "EdgeSelector", false, VARIANT_GRAPH_EDGE_SELECTORS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_SELECTOR_OR = addNode(VARIANT_GRAPH_EDGE_SELECTORS.variantNode("Or", "Or.EdgeSelector", "[DEV] Or EdgeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("EdgeSelectors", "EdgeSelectors", true, VARIANT_GRAPH_EDGE_SELECTORS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_EDGE_SELECTOR_RANDOM = addNode(VARIANT_GRAPH_EDGE_SELECTORS.variantNode("Random", "Random.EdgeSelector", "[DEV] Random EdgeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Chance", "Chance").withDefaultValue(0.0).withWidth(150))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_GENERATOR = addNode(Renode.node("GraphGenerator", "[DEV] GraphGenerator"))
            .addContent(Renode.smallStringContent("ImportName", "ImportName").withDefaultValue("").withWidth(350))
            .addContent(Renode.smallStringContent("ExportName", "ExportName").withDefaultValue("").withWidth(350))
            .addContent(Renode.checkboxContent("IsSingleInstance", "IsSingleInstance").withDefaultValue(true).withDescription("When enabled, all importers share the same underlying GraphGenerator instance."))
            .addContent(Renode.integerContent("CacheCapacity", "CacheCapacity").withDefaultValue(50).withWidth(100).withDescription("Maximum number of cached graph cells. Must be >= 1."))
            .addContent(Renode.checkboxContent("PrintStats", "PrintStats").withDefaultValue(false).withDescription("Log per-pass graph generation timing stats."))
            .addContent(Renode.integerContent("StatsPrintInterval", "StatsPrintInterval").withDefaultValue(50).withWidth(100).withDescription("Number of graph generations between stats printouts."))
            .addContent(Renode.smallStringContent("StatsLabel", "StatsLabel").withDefaultValue("UNNAMED").withWidth(250).withDescription("Label included in printed stats output."))
            .addVariantOutput("Passes", "GraphPasses", true, VARIANT_GRAPH_PASSES)
            .addNodeOutput("CacheCellSize", "CacheCellSize", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Size of each cache cell in blocks. All components must be greater than 0.")
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_CONNECTED_EDGES = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("ConnectedEdges", "ConnectedEdges.NodeAction", "[DEV] ConnectedEdges NodeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addContent(Renode.floatContent("Ratio", "Ratio").withDefaultValue(1.0).withWidth(150))
            .addVariantOutput("EdgeAction", "EdgeAction", false, VARIANT_GRAPH_EDGE_ACTIONS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_CONNECTED_NODES = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("ConnectedNodes", "ConnectedNodes.NodeAction", "[DEV] ConnectedNodes NodeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addContent(Renode.floatContent("Ratio", "Ratio").withDefaultValue(1.0).withWidth(150))
            .addVariantOutput("NodeAction", "NodeAction", false, VARIANT_GRAPH_NODE_ACTIONS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_CONTENT = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("Content", "Content.NodeAction", "[DEV] Content NodeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Content", "Content", false, VARIANT_GRAPH_CONTENT_SUPPLIERS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_CONTENT_COPY = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("ContentCopy", "ContentCopy.NodeAction", "[DEV] ContentCopy NodeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addVariantOutput("ContentPredicate", "ContentPredicate", false, VARIANT_GRAPH_CONTENT_PREDICATES)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_DELETE = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("Delete", "Delete.NodeAction", "[DEV] Delete NodeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_EMPTY = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("Empty", "Empty.NodeAction", "[DEV] Empty NodeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_IMPORTED = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("Imported", "Imported.NodeAction", "[DEV] Imported NodeAction"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350))
            .addContent(CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_JITTER_2D = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("Jitter2d", "Jitter2d.NodeAction", "[DEV] Jitter2d NodeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Magnitude", "Magnitude").withDefaultValue(0.0))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_JITTER_3D = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("Jitter3d", "Jitter3d.NodeAction", "[DEV] Jitter3d NodeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Magnitude", "Magnitude").withDefaultValue(0.0))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_MOVE = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("Move", "Move.NodeAction", "[DEV] Move NodeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(0.0))
            .addVariantOutput("Vector", "Vector", false, VARIANT_VECTOR_PROVIDERS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_PROXIMITY_CONNECTOR = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("ProximityConnector", "ProximityConnector.NodeAction", "[DEV] ProximityConnector NodeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0))
            .addContent(Renode.integerContent("Cap", "Cap").withDefaultValue(-1))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addVariantOutput("NodeSelector", "NodeSelector", false, VARIANT_GRAPH_NODE_SELECTORS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_SELECTOR = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("Selector", "Selector.NodeAction", "[DEV] Selector NodeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("NodeSelector", "NodeSelector", false, VARIANT_GRAPH_NODE_SELECTORS)
            .addVariantOutput("NodeAction", "NodeAction", false, VARIANT_GRAPH_NODE_ACTIONS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_SPAWNER = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("Spawner", "Spawner.NodeAction", "[DEV] Spawner NodeAction"))
            .withDescription("Spawns child graph nodes at positions generated relative to the current node. The offset vector is applied from the node position; if its length is greater than or equal to MaxOffsetExclusive, spawning is skipped.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxOffsetExclusive", "MaxOffsetExclusive").withDefaultValue(0.0))
            .addContent(Renode.checkboxContent("CreateEdges", "CreateEdges").withDefaultValue(false))
            .addVariantOutput("Offset", "Offset", false, VARIANT_VECTOR_PROVIDERS)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addVariantOutput("Content", "Content", false, VARIANT_GRAPH_CONTENT_SUPPLIERS)
            .addNodeOutput("ClusterBounds", "ClusterBounds", false, NODE_BOUNDS_DECIMAL_3D, "The bounds used to constrain spawned positions relative to the cluster anchor.")
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_WEIGHTED = addNode(VARIANT_GRAPH_NODE_ACTIONS.variantNode("Weighted", "Weighted.NodeAction", "[DEV] Weighted NodeAction"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addNodeOutput("Entries", "Entries", true, () -> HytaleGeneratorNodes.NODE_GRAPH_NODE_ACTION_WEIGHTED_WEIGHT)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_ACTION_WEIGHTED_WEIGHT = addNode(Renode.node("Entry.Weighted.NodeAction", "[DEV] Entry | Weighted NodeAction"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(150))
            .addVariantOutput("NodeAction", "NodeAction", false, VARIANT_GRAPH_NODE_ACTIONS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_CONTENT = addNode(Renode.node("NodeContent.Graph", "[DEV] NodeContent"))
            .addContent(Renode.smallStringContent("ExportName", "ExportName").withDefaultValue("").withWidth(350))
            .addContent(Renode.smallStringContent("ImportName", "ImportName").withDefaultValue("").withWidth(350))
            .addContent(Renode.listContent("ContentTags", "ContentTags", "String").withWidth(350))
            .addNodeOutput("DensityContent", "DensityContent", true, () -> HytaleGeneratorNodes.NODE_GRAPH_NODE_CONTENT_DENSITY)
            .addNodeOutput("MaterialContent", "MaterialContent", true, () -> HytaleGeneratorNodes.NODE_GRAPH_NODE_CONTENT_MATERIAL)
            .addNodeOutput("PropDistributionContent", "PropDistributionContent", true, () -> HytaleGeneratorNodes.NODE_GRAPH_NODE_CONTENT_PROP_DISTRIBUTION)
            .addNodeOutput("PositionsContent", "PositionsContent", true, () -> HytaleGeneratorNodes.NODE_GRAPH_NODE_CONTENT_POSITIONS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_CONTENT_DENSITY = addNode(Renode.node("Density.NodeContent", "[DEV] Density NodeContent"))
            .addContent(Renode.smallStringContent("ContentLayer", "ContentLayer").withDefaultValue("").withWidth(350))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0))
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_CONTENT_MATERIAL = addNode(Renode.node("Material.NodeContent", "[DEV] Material NodeContent"))
            .addContent(Renode.smallStringContent("ContentLayer", "ContentLayer").withDefaultValue("").withWidth(350))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0))
            .addVariantOutput("MaterialProvider", "MaterialProvider", false, VARIANT_MATERIAL_PROVIDERS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_CONTENT_POSITIONS = addNode(Renode.node("Positions.NodeContent", "[DEV] Positions NodeContent"))
            .addContent(Renode.smallStringContent("ContentLayer", "ContentLayer").withDefaultValue("").withWidth(350))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_CONTENT_PROP_DISTRIBUTION = addNode(Renode.node("PropDistribution.NodeContent", "[DEV] PropDistribution NodeContent"))
            .addContent(Renode.smallStringContent("ContentLayer", "ContentLayer").withDefaultValue("").withWidth(350))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0))
            .addVariantOutput("PropDistribution", "PropDistribution", false, VARIANT_PROP_DISTRIBUTIONS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_SELECTOR_ALL = addNode(VARIANT_GRAPH_NODE_SELECTORS.variantNode("All", "All.NodeSelector", "[DEV] All NodeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_SELECTOR_AND = addNode(VARIANT_GRAPH_NODE_SELECTORS.variantNode("And", "And.NodeSelector", "[DEV] And NodeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("NodeSelectors", "NodeSelectors", true, VARIANT_GRAPH_NODE_SELECTORS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_SELECTOR_CONNECTION_COUNT = addNode(VARIANT_GRAPH_NODE_SELECTORS.variantNode("ConnectionCount", "ConnectionCount.NodeSelector", "[DEV] ConnectionCount NodeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.listContent("Counts", "Connections", "Int").withWidth(100))
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_SELECTOR_CONTENT = addNode(VARIANT_GRAPH_NODE_SELECTORS.variantNode("Content", "Content.NodeSelector", "[DEV] Content NodeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("ContentPredicate", "ContentPredicate", false, VARIANT_GRAPH_CONTENT_PREDICATES)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_SELECTOR_DENSITY_DELIMITED = addNode(VARIANT_GRAPH_NODE_SELECTORS.variantNode("DensityDelimited", "DensityDelimited.NodeSelector", "[DEV] DensityDelimited NodeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_RANGE_DECIMAL)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_SELECTOR_IMPORTED = addNode(VARIANT_GRAPH_NODE_SELECTORS.variantNode("Imported", "Imported.NodeSelector", "[DEV] Imported NodeSelector"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350))
            .addContent(CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_SELECTOR_NEIGHBOR_EDGES = addNode(VARIANT_GRAPH_NODE_SELECTORS.variantNode("NeighborEdges", "NeighborEdges.NodeSelector", "[DEV] NeighborEdges NodeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("SelectedNeighborsThreshold", "SelectedNeighborsThreshold").withDefaultValue(-1))
            .addVariantOutput("EdgeSelector", "EdgeSelector", false, VARIANT_GRAPH_EDGE_SELECTORS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_SELECTOR_NEIGHBOR_NODES = addNode(VARIANT_GRAPH_NODE_SELECTORS.variantNode("NeighborNodes", "NeighborNodes.NodeSelector", "[DEV] NeighborNodes NodeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("SelectedNeighborsThreshold", "SelectedNeighborsThreshold").withDefaultValue(-1))
            .addVariantOutput("NodeSelector", "NodeSelector", false, VARIANT_GRAPH_NODE_SELECTORS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_SELECTOR_NOT = addNode(VARIANT_GRAPH_NODE_SELECTORS.variantNode("Not", "Not.NodeSelector", "[DEV] Not NodeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("NodeSelector", "NodeSelector", false, VARIANT_GRAPH_NODE_SELECTORS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_SELECTOR_OR = addNode(VARIANT_GRAPH_NODE_SELECTORS.variantNode("Or", "Or.NodeSelector", "[DEV] Or NodeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("NodeSelectors", "NodeSelectors", true, VARIANT_GRAPH_NODE_SELECTORS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_NODE_SELECTOR_RANDOM = addNode(VARIANT_GRAPH_NODE_SELECTORS.variantNode("Random", "Random.NodeSelector", "[DEV] Random NodeSelector"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Chance", "Chance").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_PASS_EDGE_ACTION = addNode(VARIANT_GRAPH_PASSES.variantNode("EdgeAction", "EdgeAction.GraphPass", "[DEV] EdgeAction GraphPass"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("StatsLabel", "StatsLabel").withDefaultValue("").withWidth(250).withDescription("Label used in graph generation timing stats."))
            .addVariantOutput("EdgeAction", "EdgeAction", false, VARIANT_GRAPH_EDGE_ACTIONS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_PASS_IMPORTED = addNode(VARIANT_GRAPH_PASSES.variantNode("Imported", "Imported.GraphPass", "[DEV] Imported GraphPass"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350))
            .addContent(CONTENT_SKIP)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_PASS_MANUAL = addNode(VARIANT_GRAPH_PASSES.variantNode("Manual", "Manual.GraphPass", "[DEV] Manual GraphPass"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("StatsLabel", "StatsLabel").withDefaultValue("").withWidth(250).withDescription("Label used in graph generation timing stats."))
            .addNodeOutput("Nodes", "Nodes", true, () -> HytaleGeneratorNodes.NODE_GRAPH_PASS_MANUAL_NODE)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_PASS_MANUAL_NODE = addNode(Renode.node("Node.Manual.GraphPass", "[DEV] Node | Manual GraphPass"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350))
            .addContent(Renode.listContent("Connections", "Connections", "String").withWidth(350))
            .addNodeOutput("Position", "Position", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addNodeOutput("Content", "Content", false, NODE_GRAPH_NODE_CONTENT)
            .withColorOverride("Yellow")
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_PASS_NODE_ACTION = addNode(VARIANT_GRAPH_PASSES.variantNode("NodeAction", "NodeAction.GraphPass", "[DEV] NodeAction GraphPass"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("StatsLabel", "StatsLabel").withDefaultValue("").withWidth(250).withDescription("Label used in graph generation timing stats."))
            .addVariantOutput("NodeAction", "NodeAction", false, VARIANT_GRAPH_NODE_ACTIONS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_GRAPH_PASS_POSITIONS = addNode(VARIANT_GRAPH_PASSES.variantNode("Positions", "Positions.GraphPass", "[DEV] Positions GraphPass"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("StatsLabel", "StatsLabel").withDefaultValue("").withWidth(250).withDescription("Label used in graph generation timing stats."))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addCategory(CATEGORY_GRAPH);
    public static final NodeBuilder NODE_MATERIAL = addNode(Renode.node("Material", "Material"))
            .withDescription("Defines a block's solid and fluid Material content.")
            .addContent(Renode.smallStringContent("Solid", "Solid").withDefaultValue("").withWidth(350).withDescription("Defines the Solid Material's rotation."))
            .addContent(Renode.smallStringContent("Fluid", "Fluid").withDefaultValue("").withWidth(350))
            .addContent(Renode.checkboxContent("SolidBottomUp", "SolidBottomUp").withDefaultValue(false).withDescription("Rotates the Material upside down. The pin overrides this."))
            .addNodeOutput("SolidRotation", "SolidRotation", false, () -> HytaleGeneratorNodes.NODE_ORTHOGONAL_ROTATION)
            .addCategory(CATEGORY_MATERIAL);
    public static final NodeBuilder NODE_CONSTANT_MATERIAL_PROVIDER = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Constant", "Constant.MaterialProvider", "Constant MaterialProvider"))
            .withDescription("Provides a constant Material.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Material", "Material", false, NODE_MATERIAL)
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_FIELD_FUNCTION = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("FieldFunction", "FieldFunction.MaterialProvider", "FieldFunction MaterialProvider"))
            .withDescription("Selects a 3D region using a noise function and value delimiters. The delimiters link a Material Provider slot to a specific range of values in the noise function.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("FieldFunction", "FieldFunction", false, VARIANT_DENSITY, "Defines the Density value for each block. Same asset type used by DAOTerrain density.")
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_MATERIAL_PROVIDER_FIELD_FUNCTION_DELIMITER, "Higher entries have higher priority.")
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_FIELD_FUNCTION_DELIMITER = addNode(Renode.node("Delimiter.FieldFunction.MaterialProvider", "Delimiter FFMP"))
            .addContent(Renode.floatContent("From", "From").withDefaultValue(0.0).withWidth(50))
            .addContent(Renode.floatContent("To", "To").withDefaultValue(1.0).withWidth(50))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_GRAPH = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Graph", "Graph.MaterialProvider", "[DEV] Graph MaterialProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("ContentLayer", "ContentLayer").withDefaultValue("").withWidth(350))
            .addContent(Renode.integerContent("QueryBufferCapacity", "QueryBufferCapacity").withDefaultValue(3).withWidth(100).withDescription("Maximum number of cached query columns. Must be >= 1."))
            .addNodeOutput("GraphGenerator", "GraphGenerator", false, NODE_GRAPH_GENERATOR)
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_IMPORTED = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Imported", "Imported.MaterialProvider", "Imported MaterialProvider"))
            .withDescription("Imports an exported Material Provider.")
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350).withDescription("The exported Material Provider."))
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_QUEUE = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Queue", "Queue.MaterialProvider", "Queue MaterialProvider"))
            .withDescription("Goes through a queue of Material Provider slots from highest to lowest priority. If a Material Provider in the queue doesn't provide a block type, then the next one in the queue is queried. If no slot provides a block, then the Queue Material Provider will not provide a block. The query stops at the first slot that provides a block.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Queue", "Queue", true, VARIANT_MATERIAL_PROVIDERS, "Slots are queried from top to bottom.")
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SIMPLE_HORIZONTAL = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("SimpleHorizontal", "SimpleHorizontal.MaterialProvider", "SimpleHorizontal MaterialProvider"))
            .withDescription("Applies the child Material Provider to a vertical range.\nIf a BaseHeight is provided, the TopY and BottomY values are relative to the referenced DecimalConstant. Otherwise, they're relative to the world's Y coordinate.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("TopY", "TopY").withDefaultValue(0).withWidth(50).withDescription("Y coordinate. Defines the vertical top exclusive limit of the region."))
            .addContent(Renode.smallStringContent("TopBaseHeight", "Top BaseHeight").withDefaultValue("").withWidth(250).withDescription("DecimalConstant name."))
            .addContent(Renode.integerContent("BottomY", "BottomY").withDefaultValue(0).withWidth(50).withDescription("Y coordinate. Defines the vertical bottom inclusive limit of the region."))
            .addContent(Renode.smallStringContent("BottomBaseHeight", "Bottom BaseHeight").withDefaultValue("").withWidth(250).withDescription("DecimalConstant name."))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS, "Slot to query for the selected region.")
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SOLIDITY = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Solidity", "Solidity.MaterialProvider", "Solidity MaterialProvider"))
            .withDescription("Separates terrain into Solid and Empty blocks. Provides a Material Provider slot for each selection.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Solid", "Solid", false, VARIANT_MATERIAL_PROVIDERS, "Where the terrain's Density value is greater than 0.")
            .addVariantOutput("Empty", "Empty", false, VARIANT_MATERIAL_PROVIDERS, "Where the terrain's Density value is smaller or equal to 0.")
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("SpaceAndDepth", "SpaceAndDepth.MaterialProvider", "SpaceAndDepth MaterialProvider"))
            .withDescription("Allows placing layers of blocks on a terrain's floor or ceiling surfaces. Layers of Material are piled on top of each other inside the surface (floor or ceiling), like a cake. There are multiple Layer types, each providing a unique way to define thickness. Below is an example with two layers in the floor of our terrain.\nConditions let you skip this Material Provider when they're not met. An example could be a Condition that only places grass if there are at least 5 empty blocks above the surface.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.enumContent("LayerContext", "LayerContext").withValues("DEPTH_INTO_FLOOR", "DEPTH_INTO_CEILING").withDefaultValue("DEPTH_INTO_FLOOR").withWidth(200))
            .addContent(Renode.integerContent("MaxExpectedDepth", "MaxExpectedDepth").withDefaultValue(3).withWidth(50).withDescription("Optimization hint. Set to max expected combined layer depth. Too small can cut off layers. Too large can hurt performance."))
            .addVariantOutput("Condition", "Condition", false, VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS, "Provider returns no block if the Condition fails.")
            .addVariantOutput("Layers", "Layers", true, VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYERS, "Stacked top-to-bottom as depth increases into the context.")
            .addCategory(CATEGORY_MATERIAL_PROVIDERS)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_ALWAYS_TRUE = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("AlwaysTrueCondition", "AlwaysTrue.Condition.SpaceAndDepth.MaterialProvider", "AlwaysTrue Condition SADMP"))
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_AND = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("AndCondition", "And.Condition.SpaceAndDepth.MaterialProvider", "And Condition SADMP"))
            .addVariantOutput("Conditions", "Conditions", true, VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_EQUALS = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("EqualsCondition", "Equals.Condition.SpaceAndDepth.MaterialProvider", "Equals Condition SADMP"))
            .addContent(Renode.smallStringContent("ContextToCheck", "ContextToCheck").withDefaultValue("SPACE_ABOVE_FLOOR").withWidth(200))
            .addContent(Renode.integerContent("Value", "Value").withDefaultValue(0).withWidth(50))
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_GREATER_THAN = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("GreaterThanCondition", "GreaterThan.Condition.SpaceAndDepth.MaterialProvider", "GreaterThan Condition SADMP"))
            .addContent(Renode.smallStringContent("ContextToCheck", "ContextToCheck").withDefaultValue("SPACE_ABOVE_FLOOR").withWidth(200))
            .addContent(Renode.integerContent("Threshold", "Threshold").withDefaultValue(0).withWidth(50))
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_NOT = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("NotCondition", "Not.Condition.SpaceAndDepth.MaterialProvider", "Not Condition SADMP"))
            .addVariantOutput("Conditions", "Conditions", false, VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_OR = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("OrCondition", "Or.Condition.SpaceAndDepth.MaterialProvider", "Or Condition SADMP"))
            .addVariantOutput("Conditions", "Conditions", true, VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_SMALLER_THAN = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("SmallerThanCondition", "SmallerThan.Condition.SpaceAndDepth.MaterialProvider", "SmallerThan Condition SADMP"))
            .addContent(Renode.smallStringContent("ContextToCheck", "ContextToCheck").withDefaultValue("SPACE_ABOVE_FLOOR").withWidth(200))
            .addContent(Renode.integerContent("Threshold", "Threshold").withDefaultValue(0).withWidth(50))
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYER_CONSTANT_THICKNESS = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYERS.variantNode("ConstantThickness", "ConstantThickness.Layer.SpaceAndDepth.MaterialProvider", "ConstantThickness Layer SADMP"))
            .addContent(Renode.integerContent("Thickness", "Thickness").withDefaultValue(0).withWidth(50))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYER_NOISE_THICKNESS = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYERS.variantNode("NoiseThickness", "NoiseThickness.Layer.SpaceAndDepth.MaterialProvider", "NoiseThickness Layer SADMP"))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .addVariantOutput("ThicknessFunctionXZ", "Density", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYER_RANGE_THICKNESS = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYERS.variantNode("RangeThickness", "RangeThickness.Layer.SpaceAndDepth.MaterialProvider", "RangeThickness Layer SADMP"))
            .addContent(Renode.integerContent("RangeMax", "RangeMax").withDefaultValue(0).withWidth(50))
            .addContent(Renode.integerContent("RangeMin", "RangeMin").withDefaultValue(0).withWidth(50))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYER_WEIGHTED_THICKNESS = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYERS.variantNode("WeightedThickness", "WeightedThickness.Layer.SpaceAndDepth.MaterialProvider", "WeightedThickness Layer SADMP"))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .addNodeOutput("PossibleThicknesses", "Thicknesses", true, () -> HytaleGeneratorNodes.NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYER_WEIGHTED_THICKNESS_WEIGHT)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYER_WEIGHTED_THICKNESS_WEIGHT = addNode(Renode.node("Entry.WeightedThickness.Layer.SpaceAndDepth.MaterialProvider", "WeightedThickness SADMP"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50))
            .addContent(Renode.integerContent("Thickness", "Thickness").withDefaultValue(0).withWidth(50))
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_STRIPED_STRIPE = addNode(Renode.node("Stripe.Striped.MaterialProvider", "Stripe"))
            .addContent(Renode.integerContent("TopY", "TopY").withDefaultValue(1).withWidth(50))
            .addContent(Renode.integerContent("BottomY", "BottomY").withDefaultValue(0).withWidth(50))
            .withColorOverride("Orange")
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_STRIPED = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Striped", "Striped.MaterialProvider", "Striped MaterialProvider"))
            .withDescription("Applies a Material Provider slot to a set of horizontal stripes of blocks of varying thickness and position. Below is an example of basalt stripes in a stone cliff.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS, "Slot to query for the selected region.")
            .addNodeOutput("Stripes", "Stripes", true, NODE_MATERIAL_PROVIDER_STRIPED_STRIPE, "Each stripe contains TopY and BottomY.")
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_TRANSPARENT = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Transparent", "Transparent.MaterialProvider", "Transparent MaterialProvider"))
            .addContent(CONTENT_EXPORT_AS)
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_WEIGHTED = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Weighted", "Weighted.MaterialProvider", "Weighted MaterialProvider"))
            .withDescription("Picks the Material Provider slot to query from a list. Each slot has a weight that determines the likelihood of being picked.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addContent(Renode.floatContent("SkipChance", "SkipChance").withDefaultValue(0.0).withWidth(100).withDescription("Percentage of blocks to skip. When skipped, this provider returns no block and does not pick a slot."))
            .addNodeOutput("WeightedMaterials", "WeightedMaterials", true, () -> HytaleGeneratorNodes.NODE_MATERIAL_PROVIDER_WEIGHTED_MATERIAL)
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_WEIGHTED_MATERIAL = addNode(Renode.node("Entry.Weighted.MaterialProvider", "Weight"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_ORTHOGONAL_ROTATION = addNode(Renode.node("OrthogonalRotation.Rotation", "Orthogonal Rotation"))
            .addContent(Renode.enumContent("Yaw", "Yaw").withValues("None", "Ninety", "OneEighty", "TwoSeventy").withDefaultValue("None").withWidth(200))
            .addContent(Renode.enumContent("Pitch", "Pitch").withValues("None", "Ninety", "OneEighty", "TwoSeventy").withDefaultValue("None").withWidth(200))
            .addContent(Renode.enumContent("Roll", "Roll").withValues("None", "Ninety", "OneEighty", "TwoSeventy").withDefaultValue("None").withWidth(200))
            .withColorOverride("Orange")
            .addCategory(CATEGORY_MATERIAL);
    public static final NodeBuilder NODE_PATTERN_AND = addNode(VARIANT_PATTERNS.variantNode("And", "And.Pattern", "And Pattern"))
            .withDescription("Logical operation that validates only if all the Patterns in its list also validate.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Patterns", "Patterns", true, VARIANT_PATTERNS)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_BLOCK_SET = addNode(VARIANT_PATTERNS.variantNode("BlockSet", "BlockSet.Pattern", "BlockSet Pattern"))
            .withDescription("Checks if the block's Material belongs to the BlockSet.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("BlockSet", "BlockSet", false, NODE_BLOCK_MASK_BLOCK_SET)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_BLOCK_TYPE = addNode(VARIANT_PATTERNS.variantNode("BlockType", "BlockType.Pattern", "BlockType Pattern"))
            .withDescription("Checks against the block's Material.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Material", "Material", false, NODE_MATERIAL)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_CEILING = addNode(VARIANT_PATTERNS.variantNode("Ceiling", "Ceiling.Pattern", "Ceiling Pattern"))
            .withDescription("Checks if there is a ceiling above the world position. The Origin validates the position and the Ceiling validates right above the position. For a simple Ceiling configuration, use BlockType or BlockSet Patterns in those slots.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Ceiling", "Ceiling", false, VARIANT_PATTERNS, "Checks if there is a ceiling above the world position. The Origin validates the position and the Ceiling validates right above the position. For a simple Ceiling configuration, use BlockType or BlockSet Patterns in those slots.")
            .addVariantOutput("Origin", "Origin", false, VARIANT_PATTERNS, "Validates the coordinate at the Origin position.")
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_CONSTANT = addNode(VARIANT_PATTERNS.variantNode("Constant", "Constant.Pattern", "Constant Pattern"))
            .withDescription("Always validates (Value true) or never validates (Value false) at every position.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("Value", "Value").withDefaultValue(false).withDescription("When true, the pattern always validates. When false, it never validates."))
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_CUBOID = addNode(VARIANT_PATTERNS.variantNode("Cuboid", "Cuboid.Pattern", "Cuboid Pattern"))
            .withDescription("Defines a cuboid region relative to the Pattern's origin. The region is anchored by Min and Max inclusive points. This is similar to the shape of a creative Selection Tool. The SubPattern is tested against every position inside the cuboid. The Cuboid Pattern validates only if all the inner positions are validated by the SubPattern.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Max", "Max", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Inclusive maximum point of the cuboid relative to the Pattern's origin.")
            .addNodeOutput("Min", "Min", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Inclusive minimum point of the cuboid relative to the Pattern's origin.")
            .addVariantOutput("SubPattern", "SubPattern", false, VARIANT_PATTERNS, "The Cuboid uses this Pattern to validate the positions inside itself.")
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_FIELD_FUNCTION = addNode(VARIANT_PATTERNS.variantNode("FieldFunction", "FieldFunction.Pattern", "FieldFunction Pattern"))
            .withDescription("This Pattern validates only if the provided Density field at the position is within the specified delimiters. In combination with an And and Or pattern, this Pattern provides more control over the valid positions.\nImportant: because this Pattern queries a noise field, it can be expensive if placed high in the hierarchy. I recommend setting your Pattern structure such that this Pattern is the last to be tested. The diagram below shows examples of that.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("FieldFunction", "FieldFunction", false, VARIANT_DENSITY)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_PATTERN_FIELD_FUNCTION_DELIMITER)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_FIELD_FUNCTION_DELIMITER = addNode(Renode.node("Delimiter.FieldFunction.Pattern", "FieldFunction Delimiter"))
            .addContent(Renode.floatContent("Min", "Min").withDefaultValue(0.0).withWidth(70))
            .addContent(Renode.floatContent("Max", "Max").withDefaultValue(1.0).withWidth(70))
            .withColorOverride("Orange")
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_FLOOR = addNode(VARIANT_PATTERNS.variantNode("Floor", "Floor.Pattern", "Floor Pattern"))
            .withDescription("Checks if there is a floor below the position. The Origin validates the position and the Floor validates right under the position. For a simple Floor configuration, use BlockType or BlockSet Patterns in those slots.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Origin", "Origin", false, VARIANT_PATTERNS, "Validates the block at the Origin position.")
            .addVariantOutput("Floor", "Floor", false, VARIANT_PATTERNS, "Validates the block under the Origin position.")
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_IMPORTED = addNode(VARIANT_PATTERNS.variantNode("Imported", "Imported.Pattern", "Imported Pattern"))
            .withDescription("Imports an exported Pattern.")
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350).withDescription("The exported Pattern."))
            .addContent(CONTENT_SKIP)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_NOT = addNode(VARIANT_PATTERNS.variantNode("Not", "Not.Pattern", "Not Pattern"))
            .withDescription("Logical operation that validates only where the nested Pattern does not validate.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_OFFSET = addNode(VARIANT_PATTERNS.variantNode("Offset", "Offset.Pattern", "Offset Pattern"))
            .withDescription("Offsets the child Pattern by the given vector.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addNodeOutput("Offset", "Offset", false, () -> HytaleGeneratorNodes.NODE_POINT_3D_INTEGER, "The direction to offset the child Pattern in.")
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_OR = addNode(VARIANT_PATTERNS.variantNode("Or", "Or.Pattern", "Or Pattern"))
            .withDescription("Logical operation that validates if at least one of the Patterns in its list validates.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Patterns", "Patterns", true, VARIANT_PATTERNS)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_ROTATOR = addNode(VARIANT_PATTERNS.variantNode("Rotator", "Rotator.Pattern", "Rotator Pattern"))
            .withDescription("Rotates the child Pattern.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addNodeOutput("Rotation", "Rotation", false, NODE_ORTHOGONAL_ROTATION, "The child's rotation.")
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_SURFACE = addNode(VARIANT_PATTERNS.variantNode("Surface", "Surface.Pattern", "Surface Pattern"))
            .withDescription("Validates if presented with a surface.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SurfaceRadius", "SurfaceRadius").withDefaultValue(0.0).withDescription("Determines the size of the surface area."))
            .addContent(Renode.floatContent("MediumRadius", "MediumRadius").withDefaultValue(0.0).withDescription("Determines the size of the medium area."))
            .addContent(Renode.integerContent("SurfaceGap", "SurfaceGap").withDefaultValue(0))
            .addContent(Renode.integerContent("MediumGap", "MediumGap").withDefaultValue(0))
            .addContent(Renode.listContent("Facings", "Facings", "String").withWidth(40).withDescription("N | S | E | W | U | D\nDirections the surface is facing."))
            .addContent(Renode.checkboxContent("RequireAllFacings", "RequireAllFacings").withDefaultValue(false).withDescription("If true then the Pattern will only validate if all Facings validate."))
            .addVariantOutput("Surface", "Surface", false, VARIANT_PATTERNS, "Validates every block of the surface.")
            .addVariantOutput("Medium", "Medium", false, VARIANT_PATTERNS, "Validates every block of the medium.")
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_WALL = addNode(VARIANT_PATTERNS.variantNode("Wall", "Wall.Pattern", "Wall Pattern"))
            .withDescription("Checks if there is a wall next to the world position. For a simple Wall configuration, use BlockType or BlockSet Patterns in those slots. You can specify which directions are valid for the wall using the N, S, E, W string values.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.listContent("Directions", "Directions", "String").withWidth(40).withDescription("N | S | E | W\nDirections in which the wall can be facing."))
            .addContent(Renode.checkboxContent("RequireAllDirections", "RequireAllDirections").withDefaultValue(false).withDescription("If true then all the directions you put in the list need to validate for the Pattern to validate a position. Otherwise only one of the list directions needs to validate."))
            .addVariantOutput("Wall", "Wall", false, VARIANT_PATTERNS, "Validates the coordinate next to the Origin position.")
            .addVariantOutput("Origin", "Origin", false, VARIANT_PATTERNS, "Validates the coordinate at the Origin position.")
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_POINT_GENERATOR_MESH = addNode(VARIANT_POINT_GENERATORS.variantNode("Mesh", "Mesh.PointGenerator", "[DEPRECATED] Mesh Point Generator"))
            .addContent(CONTENT_SKIP)
            .addContent(Renode.floatContent("Jitter", "Jitter").withDefaultValue(0.4).withWidth(100))
            .addContent(Renode.floatContent("ScaleX", "ScaleX").withDefaultValue(40.0).withWidth(100))
            .addContent(Renode.floatContent("ScaleY", "ScaleY").withDefaultValue(40.0).withWidth(100))
            .addContent(Renode.floatContent("ScaleZ", "ScaleZ").withDefaultValue(40.0).withWidth(100))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(350))
            .addCategory(CATEGORY_POINT_GENERATORS);
    public static final NodeBuilder NODE_POSITIONS_ANCHOR = addNode(VARIANT_POSITIONS.variantNode("Anchor", "Anchor.Positions", "Anchor Positions"))
            .withDescription("Anchors the origin of the child Positions field to the contextual Anchor, if one exists. For a contextual Anchor to exist, a parent of this node must produce an Anchor.\nYou can also reverse the effect later in the chain to move the origin back to the world's origin, as in the screenshot below.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("Reversed", "Reversed").withDefaultValue(false).withDescription("If true, reverses the origin of the child back to the world's origin (or to the origin before the previous Anchor node)."))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_BASE_HEIGHT = addNode(VARIANT_POSITIONS.variantNode("BaseHeight", "BaseHeight.Positions", "BaseHeight Positions"))
            .withDescription("Vertically offsets the Positions inside the configured vertical region by the number of blocks determined by the referenced DecimalConstant.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("BedName", "BaseHeightName").withDefaultValue("").withWidth(250).withDescription("Name of the DecimalConstant to reference."))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_BOUND = addNode(VARIANT_POSITIONS.variantNode("Bound", "Bound.Positions", "Bound Positions"))
            .withDescription("Limits the positions to a bounded region.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addNodeOutput("Bounds", "Bounds", false, NODE_BOUNDS_DECIMAL_3D)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_CACHE = addNode(VARIANT_POSITIONS.variantNode("Cache", "Cache.Positions", "Cache Positions"))
            .withDescription("Caches the output provided by the Positions slot to improve performance in certain situations. This asset can be useful to improve performance when a Positions asset is expensive and queried numerous times.\nHow effective this Cache is depends heavily on the use case, the provided child Positions asset, and the order in which it is queried. You can get the best performance out of this Cache asset by trial and error. An example of a good use case for this asset is at the root of an expensive Positions tree used by a Positions2D/Positions3D Density node.\nI recommend that you don't use this cache everywhere in your Positions trees, but instead place it at (or close to) the root of your Positions asset tree. That said, feel free to experiment.\nThis cache functions by saving 3D sections of space containing the Positions (points) generated by the child slot. The sections are cubes, and their size is determined by the asset's SectionSize parameter. The number of sections allowed to be saved in the cache is determined by the CacheSize asset parameter. A safe starting value for the SectionSize parameter would be 32, and a safe starting value for the CacheSize would be 50.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("SectionsSize", "SectionsSize").withDefaultValue(32).withWidth(50).withDescription("Determines the side length of each section cube, in blocks. A safe starting value is 32."))
            .addContent(Renode.integerContent("CacheSize", "CacheSize").withDefaultValue(100).withWidth(50).withDescription("Determines how many sections can be saved in memory. A safe starting value is 50. If set to 0, the cache is ignored and positions are sourced directly from the child slot."))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "The output of this Positions asset is cached.")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_CLUSTERS = addNode(VARIANT_POSITIONS.variantNode("Clusters", "Clusters.Positions", "Clusters Positions"))
            .withDescription("Generates clusters of positions anchored by a Distributor PositionProvider. The cluster size is determined by the ClusterBounds, and the cluster contents are determined by the Cluster PositionProvider.\nThe Cluster PositionProvider receives the cluster's position as an anchor.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Cluster", "Cluster", false, VARIANT_POSITIONS, "Positions making up the cluster.")
            .addVariantOutput("Distributor", "Distributor", false, VARIANT_POSITIONS, "Each cluster is anchored to one of these positions.")
            .addNodeOutput("ClusterBounds", "ClusterBounds", false, NODE_BOUNDS_DECIMAL_3D, "The maximum size of a cluster around its anchor.")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_FIELD_FUNCTION = addNode(VARIANT_POSITIONS.variantNode("FieldFunction", "FieldFunction.Positions", "FieldFunction Positions"))
            .withDescription("Enables masking out positions using a Density field. The delimiters determine the regions of the Density field where positions are kept.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "The positions on which the mask is applied.")
            .addVariantOutput("FieldFunction", "Density", false, VARIANT_DENSITY)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_POSITIONS_FIELD_FUNCTION_DELIMITER, "Density value ranges that keep input positions.")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_FIELD_FUNCTION_DELIMITER = addNode(Renode.node("Delimiter.Positions", "Delimiter"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Min", "Min").withDefaultValue(-1.0).withWidth(100))
            .addContent(Renode.floatContent("Max", "Max").withDefaultValue(1.0).withWidth(100))
            .withColorOverride("Orange")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_DIRECTIONAL_JITTER = addNode(VARIANT_POSITIONS.variantNode("DirectionalJitter", "DirectionalJitter.Positions", "DirectionalJitter Positions"))
            .withDescription("Adds jitter in a direction.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Magnitude", "Magnitude").withDefaultValue(0.0).withWidth(50).withDescription("The maximum distance each position is allowed to travel from its original place when jittered. The actual movement distance is random for each position between 0 and the Magnitude."))
            .addContent(Renode.checkboxContent("IsBidirectional", "IsBidirectional").withDefaultValue(true))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addNodeOutput("Direction", "Direction", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Jitter direction.")
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "Positions to jitter.")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_FRAMEWORK = addNode(VARIANT_POSITIONS.variantNode("Framework", "Framework.Positions", "Framework Positions"))
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_GRAPH = addNode(VARIANT_POSITIONS.variantNode("Graph", "Graph.Positions", "[DEV] Graph Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("ContentLayer", "ContentLayer").withDefaultValue("").withWidth(350))
            .addNodeOutput("GraphGenerator", "GraphGenerator", false, NODE_GRAPH_GENERATOR)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_IMPORTED = addNode(VARIANT_POSITIONS.variantNode("Imported", "Imported.Positions", "Imported Positions"))
            .withDescription("Imports an exported PositionsProvider.")
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350).withDescription("The exported PositionsProvider's name."))
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_JITTER_2D = addNode(VARIANT_POSITIONS.variantNode("Jitter2d", "Jitter2d.Positions", "Jitter2d Positions"))
            .withDescription("Adds jitter along the x/z plane.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Magnitude", "Magnitude").withDefaultValue(0.0).withWidth(50).withDescription("The maximum distance each position is allowed to travel from its original place when jittered. The actual movement distance is random for each position between 0 and the Magnitude."))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "Positions to jitter.")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_JITTER_3D = addNode(VARIANT_POSITIONS.variantNode("Jitter3d", "Jitter3d.Positions", "Jitter3d Positions"))
            .withDescription("Adds jitter in all directions.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Magnitude", "Magnitude").withDefaultValue(0.0).withWidth(50).withDescription("The maximum distance each position is allowed to travel from its original place when jittered. The actual movement distance is random for each position between 0 and the Magnitude."))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "Positions to jitter.")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_LIST = addNode(VARIANT_POSITIONS.variantNode("List", "List.Positions", "List Positions"))
            .withDescription("Allows you to manually define a static list of positions in world coordinates.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Positions", "Positions", true, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_MESH_2D = addNode(VARIANT_POSITIONS.variantNode("Mesh2D", "Mesh2D.Positions", "[DEPRECATED] Mesh2D Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("PointsY", "PointsY").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("PointGenerator", "PointGenerator", false, VARIANT_POINT_GENERATORS)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_MESH_3D = addNode(VARIANT_POSITIONS.variantNode("Mesh3D", "Mesh3D.Positions", "[DEPRECATED] Mesh3D Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("PointGenerator", "PointGenerator", false, VARIANT_POINT_GENERATORS)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_OCCURRENCE = addNode(VARIANT_POSITIONS.variantNode("Occurrence", "Occurrence.Positions", "Occurrence Positions"))
            .withDescription("Discards a percentage of input positions based on a Density field. The value of the Density field at each position determines the chance that the position is kept.\n- Positions where the Density value is less than or equal to 0.0 have a 0% chance of being kept.\n- Positions where the Density value is greater than or equal to 1.0 have a 100% chance of being kept.\n- Positions where the Density value is between 0.0 and 1.0 have a proportional percentage chance of being kept. Example: 0.4 → 40%.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "Input.")
            .addVariantOutput("FieldFunction", "FieldFunction", false, VARIANT_DENSITY, "Determines the chance of keeping the positions.")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_OFFSET = addNode(VARIANT_POSITIONS.variantNode("Offset", "Offset.Positions", "Offset Positions"))
            .withDescription("Offsets the positions by the provided vector.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("OffsetX", "[DEPRECATED] OffsetX").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("OffsetY", "[DEPRECATED] OffsetY").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("OffsetZ", "[DEPRECATED] OffsetZ").withDefaultValue(0.0).withWidth(100))
            .addNodeOutput("Offset", "Offset", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Offset vector.")
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "Input.")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_SCALER = addNode(VARIANT_POSITIONS.variantNode("Scaler", "Scaler.Positions", "Scaler Positions"))
            .withDescription("Scales the child Positions.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "Positions to scale.")
            .addNodeOutput("Scale", "Scale", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "Determines the scale.")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_SIMPLE_HORIZONTAL = addNode(VARIANT_POSITIONS.variantNode("SimpleHorizontal", "SimpleHorizontal.Positions", "SimpleHorizontal Positions"))
            .withDescription("Keeps only positions within the provided Y range.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "Input.")
            .addNodeOutput("RangeY", "RangeY", false, () -> HytaleGeneratorNodes.NODE_RANGE_DECIMAL, "The y-axis range within which input positions are kept.")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_SQUARE_GRID_2D = addNode(VARIANT_POSITIONS.variantNode("SquareGrid2d", "SquareGrid2d.Positions", "SquareGrid2d Positions"))
            .withDescription("Generates a 2D infinite square mesh of positions with a distance of 1 block between them.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_SQUARE_GRID_3D = addNode(VARIANT_POSITIONS.variantNode("SquareGrid3d", "SquareGrid3d.Positions", "SquareGrid3d Positions"))
            .withDescription("Generates a 3D infinite square mesh of positions with a distance of 1 block between them.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_TRIANGULAR_GRID_2D = addNode(VARIANT_POSITIONS.variantNode("TriangularGrid2d", "TriangularGrid2d.Positions", "TriangularGrid2d Positions"))
            .withDescription("Generates a 2D infinite triangular mesh of positions with a distance of 1 block between them.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_UNION = addNode(VARIANT_POSITIONS.variantNode("Union", "Union.Positions", "Union Positions"))
            .withDescription("Combines all positions into a single Positions field.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", true, VARIANT_POSITIONS, "Inputs.")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_VECTOR_OFFSET = addNode(VARIANT_POSITIONS.variantNode("VectorOffset", "VectorOffset.Positions", "VectorOffset Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addVariantOutput("VectorProvider", "VectorProvider", false, VARIANT_VECTOR_PROVIDERS)
            .addNodeOutput("MovementBounds", "MovementBounds", false, NODE_BOUNDS_DECIMAL_3D)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_PROP_BOX = addNode(VARIANT_PROPS.variantNode("Box", "Box.Prop", "[DEPRECATED] Box Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS)
            .addNodeOutput("Range", "Range", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addNodeOutput("Material", "Material", false, NODE_MATERIAL)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_CLUSTER = addNode(VARIANT_PROPS.variantNode("Cluster", "Cluster.Prop", "[DEPRECATED] Cluster Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("Range", "Range").withDefaultValue(0).withWidth(50))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(350))
            .addNodeOutput("DistanceCurve", "DistanceCurve", false, NODE_CURVE_MANUAL)
            .addNodeOutput("WeightedProps", "WeightedProps", true, () -> HytaleGeneratorNodes.NODE_PROP_CLUSTER_WEIGHT)
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_CLUSTER_WEIGHT = addNode(Renode.node("Weighted.Cluster.Prop", "Weight"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50))
            .addNodeOutput("ColumnProp", "ColumnProp", false, () -> HytaleGeneratorNodes.NODE_PROP_COLUMN)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_COLUMN = addNode(VARIANT_PROPS.variantNode("Column", "Column.Prop", "[DEPRECATED] Column Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("ColumnBlocks", "ColumnBlocks", true, () -> HytaleGeneratorNodes.NODE_PROP_COLUMN_BLOCK)
            .addVariantOutput("Directionality", "Directionality", false, VARIANT_DIRECTIONALITY)
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS)
            .addNodeOutput("BlockMask", "BlockMask", false, NODE_BLOCK_MASK)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_COLUMN_BLOCK = addNode(Renode.node("Block.Column.Prop", "Column Block"))
            .addContent(Renode.integerContent("Y", "Y").withDefaultValue(0).withWidth(50))
            .addNodeOutput("Material", "Material", false, NODE_MATERIAL)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_CUBOID = addNode(VARIANT_PROPS.variantNode("Cuboid", "Cuboid.Prop", "Cuboid Prop"))
            .withDescription("Places a cuboid made from the provided materials.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Bounds", "Bounds", false, NODE_BOUNDS_INTEGER_3D, "Size of the cuboid.")
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS, "The materials the cuboid is made of.")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_DENSITY = addNode(VARIANT_PROPS.variantNode("Density", "Density.Prop", "Density Prop"))
            .withDescription("Generates a Prop from a Density field and a MaterialProvider asset.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Bounds", "Bounds", false, NODE_BOUNDS_INTEGER_3D, "The maximum reach.")
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY, "Gives shape to the Prop.")
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS, "Determines the block types to use.")
            .addVariantOutput("Pattern", "[DEPRECATED] Pattern", false, VARIANT_PATTERNS)
            .addVariantOutput("Scanner", "[DEPRECATED] Scanner", false, VARIANT_SCANNERS)
            .addNodeOutput("PlacementMask", "[DEPRECATED] PlacementMask", false, NODE_BLOCK_MASK)
            .addNodeOutput("Range", "[DEPRECATED] Range", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_DENSITY_SELECTOR = addNode(VARIANT_PROPS.variantNode("DensitySelector", "DensitySelector.Prop", "DensitySelector Prop"))
            .withDescription("Selects a child Prop based on a Density field.\nThe first delimiter whose range contains the Density value at the Prop's position determines the child Prop to use.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_PROP_DENSITY_SELECTOR_DELIMITER, "Determines which Prop is selected for which regions of the Density field.")
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_DENSITY_SELECTOR_DELIMITER = addNode(Renode.node("Delimiter.DensitySelector.Prop", "Delimiter - DensitySelector Prop"))
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addNodeOutput("Range", "Range", false, () -> HytaleGeneratorNodes.NODE_RANGE_DECIMAL)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_IMPORTED = addNode(VARIANT_PROPS.variantNode("Imported", "Imported.Prop", "Imported Prop"))
            .withDescription("Imports an exported Prop.")
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350).withDescription("The exported Prop name."))
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_LOCATOR = addNode(VARIANT_PROPS.variantNode("Locator", "Locator.Prop", "Locator Prop"))
            .withDescription("Locates a valid position using a Pattern and a Scanner.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("PlacementCap", "PlacementCap").withDefaultValue(1).withDescription("Limits the number of valid locations in which the child Prop is generated."))
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS, "Prop to place at valid positions.")
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS, "Defines what valid locations look like.")
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS, "Scans relative to the anchor for valid locations.")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_MANUAL = addNode(VARIANT_PROPS.variantNode("Manual", "Manual.Prop", "Manual Prop"))
            .withDescription("Places manually configured blocks.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Blocks", "Blocks", true, () -> HytaleGeneratorNodes.NODE_PROP_MANUAL_BLOCK, "Blocks positioned relative to the Prop's anchor.")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_MANUAL_BLOCK = addNode(Renode.node("Block.Manual.Prop", "Block - Manual Prop"))
            .addNodeOutput("Material", "Material", false, NODE_MATERIAL)
            .addNodeOutput("Position", "Position", false, () -> HytaleGeneratorNodes.NODE_POINT_3D_INTEGER)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_MASK = addNode(VARIANT_PROPS.variantNode("Mask", "Mask.Prop", "Mask Prop"))
            .withDescription("Masks the blocks placed by the child.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addNodeOutput("Mask", "Mask", false, NODE_BLOCK_MASK, "Determines which materials are allowed to be placed.")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_OFFSET = addNode(VARIANT_PROPS.variantNode("Offset", "Offset.Prop", "Offset Prop"))
            .withDescription("Offsets the position of the child Prop.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Offset", "Offset", false, () -> HytaleGeneratorNodes.NODE_POINT_3D, "The direction in which to offset the child Prop's position.")
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_ORIENTER = addNode(VARIANT_PROPS.variantNode("Orienter", "Orienter.Prop", "Orienter Prop"))
            .withDescription("Locates valid positions and orients the child Prop accordingly.\nAutomatically checks the Pattern in different rotations and rotates the child Prop accordingly.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.enumContent("SelectionMode", "SelectionMode").withValues("FirstValid", "AllValid", "RandomValid").withDefaultValue("FirstValid").withWidth(200).withDescription("Determines which valid rotation is generated:\n- FirstValid: The first valid rotation in the Rotations list.\n- AllValid: All valid rotations in the Rotations list.\n- RandomValid: Picks one of the valid Rotations at random."))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350).withDescription("Determines which position is picked if RandomValid."))
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS, "Prop to place at valid positions.")
            .addNodeOutput("Rotations", "Rotations", true, NODE_ORTHOGONAL_ROTATION, "Possible rotations.")
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS, "Defines what valid locations look like.")
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS, "Scans relative to the anchor for valid locations.")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_POND_FILLER = addNode(VARIANT_PROPS.variantNode("PondFiller", "PondFiller.Prop", "PondFiller Prop"))
            .withDescription("Fills depressions in the terrain with the provided MaterialProvider.\nImportant: The performance impact of this Prop can be relatively high depending on the size of its bounding box. Because of that, I recommend optimizing the size of its bounding box for each use case.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Bounds", "Bounds", false, NODE_BOUNDS_INTEGER_3D, "The Prop's reach.")
            .addNodeOutput("BarrierBlockSet", "BarrierBlockSet", false, NODE_BLOCK_MASK_BLOCK_SET, "Defines the types of blocks that can make up the solid terrain, through which the pond material cannot seep.")
            .addVariantOutput("FillMaterial", "FillMaterial", false, VARIANT_MATERIAL_PROVIDERS, "Determines the types of blocks used when filling up the ponds (for example, water).")
            .addNodeOutput("BoundingMin", "[DEPRECATED] BoundingMin", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addNodeOutput("BoundingMax", "[DEPRECATED] BoundingMax", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addVariantOutput("Pattern", "[DEPRECATED] Pattern", false, VARIANT_PATTERNS)
            .addVariantOutput("Scanner", "[DEPRECATED] Scanner", false, VARIANT_SCANNERS)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_PREFAB = addNode(VARIANT_PROPS.variantNode("Prefab", "Prefab.Prop", "Prefab Prop"))
            .withDescription("Places a Prefab from the weighted paths.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("LegacyPath", "[DEPRECATED] LegacyPath").withDefaultValue(false))
            .addContent(Renode.smallStringContent("MoldingDirection", "[DEPRECATED] MoldingDirection").withDefaultValue("NONE"))
            .addContent(Renode.checkboxContent("MoldingChildren", "[DEPRECATED] MoldingChildren").withDefaultValue(false))
            .addContent(Renode.checkboxContent("LoadEntities", "[DEPRECATED] LoadEntities").withDefaultValue(true))
            .addNodeOutput("WeightedPrefabPaths", "WeightedPrefabPaths", true, () -> HytaleGeneratorNodes.NODE_PROP_PREFAB_WEIGHTED_PATH, "Each path entry contains the keys below.")
            .addVariantOutput("Directionality", "[DEPRECATED] Directionality", false, VARIANT_DIRECTIONALITY)
            .addVariantOutput("Scanner", "[DEPRECATED] Scanner", false, VARIANT_SCANNERS)
            .addNodeOutput("BlockMask", "[DEPRECATED] BlockMask", false, NODE_BLOCK_MASK)
            .addVariantOutput("MoldingScanner", "[DEPRECATED] MoldingScanner", false, VARIANT_SCANNERS)
            .addVariantOutput("MoldingPattern", "[DEPRECATED] MoldingPattern", false, VARIANT_PATTERNS)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_PREFAB_WEIGHTED_PATH = addNode(Renode.node("WeightedPath.Prefab.Prop", "Weighted Path"))
            .addContent(Renode.smallStringContent("Path", "Path").withDefaultValue("").withWidth(700))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0))
            .withColorOverride("Orange")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_QUEUE = addNode(VARIANT_PROPS.variantNode("Queue", "Queue.Prop", "Queue Prop"))
            .withDescription("Places the first Prop in the list that generates, and skips the rest.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Props", "Props", true, VARIANT_PROPS)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_RANDOM_ROTATOR = addNode(VARIANT_PROPS.variantNode("RandomRotator", "RandomRotator.Prop", "RandomRotator Prop"))
            .withDescription("Rotates the child Prop by a random Rotation.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("HorizontalRotations", "HorizontalRotations").withDefaultValue(false).withDescription("Reduces the need to define four extra nodes for all X/Z rotations by adding them all automatically. Don't use the Rotations pin if you enable this."))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addNodeOutput("Rotations", "Rotations", true, NODE_ORTHOGONAL_ROTATION, "The rotations to pick from.")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_STATIC_ROTATOR = addNode(VARIANT_PROPS.variantNode("StaticRotator", "StaticRotator.Prop", "StaticRotator Prop"))
            .withDescription("Rotates the child Prop by a static Rotation.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addNodeOutput("Rotation", "Rotation", false, NODE_ORTHOGONAL_ROTATION, "Child Prop's rotation relative to this Prop's direction.")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_UNION = addNode(VARIANT_PROPS.variantNode("Union", "Union.Prop", "Union Prop"))
            .withDescription("Places all the Props in the provided list at the same position, one after another.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Props", "Props", true, VARIANT_PROPS, "Props to place together.")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_WEIGHTED = addNode(VARIANT_PROPS.variantNode("Weighted", "Weighted.Prop", "Weighted Prop"))
            .withDescription("Picks a Prop to place based on a seed and weights.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350).withDescription("The seed determining which Prop is picked. This seed also mutates the seed passed to the children."))
            .addNodeOutput("Entries", "Entries", true, () -> HytaleGeneratorNodes.NODE_PROP_WEIGHTED_ENTRY, "Weighted entries.")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_WEIGHTED_ENTRY = addNode(Renode.node("Entry.Weighted.Prop", "Entry - Weighted Prop"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0))
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_DISTRIBUTION_ANCHOR = addNode(VARIANT_PROP_DISTRIBUTIONS.variantNode("Anchor", "Anchor.PropDistribution", "Anchor PropDistribution"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.checkboxContent("Reversed", "Reversed").withDefaultValue(false).withDescription("If true, reverses the origin of the child back to the world's origin (or to the origin before the previous Anchor node)."))
            .addVariantOutput("PropDistribution", "PropDistribution", false, VARIANT_PROP_DISTRIBUTIONS, "The child PropDistribution to assign the empty positions from.")
            .addCategory(CATEGORY_PROP_DISTRIBUTIONS);
    public static final NodeBuilder NODE_PROP_DISTRIBUTION_ASSIGNED = addNode(VARIANT_PROP_DISTRIBUTIONS.variantNode("Assigned", "Assigned.PropDistribution", "Assigned PropDistribution"))
            .withDescription("Assigns positions from the child PropDistribution using Assignments.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("OverrideAllProps", "OverrideAllProps").withDefaultValue(false).withDescription("When enabled, Assignments replace all positions from the child PropDistribution. When disabled, only empty positions are assigned."))
            .addVariantOutput("PropDistribution", "PropDistribution", false, VARIANT_PROP_DISTRIBUTIONS, "The child PropDistribution whose positions are passed to Assignments.")
            .addVariantOutput("Assignments", "Assignments", false, VARIANT_ASSIGNMENTS, "Assigns Props to positions from the child PropDistribution.")
            .addCategory(CATEGORY_PROP_DISTRIBUTIONS);
    public static final NodeBuilder NODE_PROP_DISTRIBUTION_CONSTANT = addNode(VARIANT_PROP_DISTRIBUTIONS.variantNode("Constant", "Constant.PropDistribution", "Constant PropDistribution"))
            .withDescription("Pairs the Prop with every position.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS, "Positions to pair with the Prop.")
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addCategory(CATEGORY_PROP_DISTRIBUTIONS);
    public static final NodeBuilder NODE_PROP_DISTRIBUTION_GRAPH = addNode(VARIANT_PROP_DISTRIBUTIONS.variantNode("Graph", "Graph.PropDistribution", "[DEV] Graph PropDistribution"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("ContentLayer", "ContentLayer").withDefaultValue("").withWidth(350))
            .addNodeOutput("GraphGenerator", "GraphGenerator", false, NODE_GRAPH_GENERATOR)
            .addCategory(CATEGORY_PROP_DISTRIBUTIONS);
    public static final NodeBuilder NODE_PROP_DISTRIBUTION_IMPORTED = addNode(VARIANT_PROP_DISTRIBUTIONS.variantNode("Imported", "Imported.PropDistribution", "Imported PropDistribution"))
            .withDescription("Imports an exported PropDistribution.")
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350).withDescription("The exported PropDistribution name."))
            .addCategory(CATEGORY_PROP_DISTRIBUTIONS);
    public static final NodeBuilder NODE_PROP_DISTRIBUTION_POSITIONS = addNode(VARIANT_PROP_DISTRIBUTIONS.variantNode("Positions", "Positions.PropDistribution", "Positions PropDistribution"))
            .withDescription("Creates empty positions.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addCategory(CATEGORY_PROP_DISTRIBUTIONS);
    public static final NodeBuilder NODE_PROP_DISTRIBUTION_UNION = addNode(VARIANT_PROP_DISTRIBUTIONS.variantNode("Union", "Union.PropDistribution", "Union PropDistribution"))
            .withDescription("Combines all children, keeping all their positioned Props.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("PropDistributions", "PropDistributions", true, VARIANT_PROP_DISTRIBUTIONS, "The children to combine.")
            .addCategory(CATEGORY_PROP_DISTRIBUTIONS);
    public static final NodeBuilder NODE_RANGE_DECIMAL = addNode(Renode.node("Decimal.Range", "Decimal Range"))
            .addContent(Renode.floatContent("MinInclusive", "MinInclusive").withDefaultValue(0.0).withWidth(50))
            .addContent(Renode.floatContent("MaxExclusive", "MaxExclusive").withDefaultValue(1.0).withWidth(50))
            .addCategory(CATEGORY_RANGE);
    public static final NodeBuilder NODE_RANGE_INTEGER = addNode(Renode.node("Integer.Range", "Integer Range"))
            .addContent(Renode.integerContent("MinInclusive", "MinInclusive").withDefaultValue(0).withWidth(50))
            .addContent(Renode.integerContent("MaxExclusive", "MaxExclusive").withDefaultValue(1).withWidth(50))
            .addCategory(CATEGORY_RANGE);
    public static final NodeBuilder NODE_ROOT = addNode(Renode.node("RootNode", "Output"))
            .addVariantOutput("RootNode", "RootNode", false, VARIANT_DENSITY)
            .withColorOverride("Grey")
            .addSchemaString("Type", "RootNode");
    public static final NodeBuilder NODE_RUNTIME = addNode(Renode.node("Runtime", "Runtime"))
            .addContent(Renode.integerContent("Runtime", "Runtime").withDefaultValue(0).withWidth(40))
            .addContent(CONTENT_SKIP)
            .addVariantOutput("Positions", "[DEPRECATED] Positions", false, VARIANT_POSITIONS)
            .addVariantOutput("Assignments", "[DEPRECATED] Assignments", false, VARIANT_ASSIGNMENTS)
            .addVariantOutput("PropDistribution", "PropDistribution", false, VARIANT_PROP_DISTRIBUTIONS)
            .withColorOverride("Grey")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_SCANNER_AREA = addNode(VARIANT_SCANNERS.variantNode("Area", "Area.Scanner", "[DEPRECATED] Area Scanner"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("ScanRange", "ScanRange").withDefaultValue(3))
            .addContent(Renode.smallStringContent("ScanShape", "ScanShape").withDefaultValue("CIRCLE").withWidth(150))
            .addContent(Renode.integerContent("ResultCap", "ResultCap").withDefaultValue(1))
            .addVariantOutput("ChildScanner", "ChildScanner", false, VARIANT_SCANNERS)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_COLUMN_LINEAR = addNode(VARIANT_SCANNERS.variantNode("ColumnLinear", "ColumnLinear.Scanner", "[DEPRECATED] ColumnLinear Scanner"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("MaxY", "MaxY").withDefaultValue(120))
            .addContent(Renode.integerContent("MinY", "MinY").withDefaultValue(60))
            .addContent(Renode.checkboxContent("RelativeToPosition", "RelativeToPosition").withDefaultValue(false))
            .addContent(Renode.smallStringContent("BaseHeightName", "BaseHeightName").withDefaultValue("").withWidth(250))
            .addContent(Renode.checkboxContent("TopDownOrder", "TopDownOrder").withDefaultValue(true))
            .addContent(Renode.integerContent("ResultCap", "ResultCap").withDefaultValue(1))
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_COLUMN_RANDOM = addNode(VARIANT_SCANNERS.variantNode("ColumnRandom", "ColumnRandom.Scanner", "[DEPRECATED] ColumnRandom Scanner"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("MaxY", "MaxY").withDefaultValue(120))
            .addContent(Renode.integerContent("MinY", "MinY").withDefaultValue(60))
            .addContent(Renode.smallStringContent("Strategy", "Strategy").withDefaultValue("DART_THROW").withWidth(150))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(350))
            .addContent(Renode.checkboxContent("RelativeToPosition", "RelativeToPosition").withDefaultValue(false))
            .addContent(Renode.smallStringContent("BaseHeightName", "BaseHeightName").withDefaultValue("").withWidth(250))
            .addContent(Renode.integerContent("ResultCap", "ResultCap").withDefaultValue(1))
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_IMPORTED = addNode(VARIANT_SCANNERS.variantNode("Imported", "Imported.Scanner", "Imported Scanner"))
            .withDescription("Imports an exported Scanner.")
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350).withDescription("The exported Scanner."))
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_LINEAR = addNode(VARIANT_SCANNERS.variantNode("Linear", "Linear.Scanner", "Linear Scanner"))
            .withDescription("Scans linearly block by block.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.enumContent("Axis", "Axis").withValues("X", "Y", "Z").withDefaultValue("Y").withDescription("Axis to scan along."))
            .addContent(Renode.checkboxContent("AscendingOrder", "AscendingOrder").withDefaultValue(false))
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS, "The child Scanner to run for every block scanned by this Scanner. Not used if left empty.")
            .addNodeOutput("Range", "Range", false, NODE_RANGE_INTEGER, "The range of blocks around the anchor to scan.")
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_ORIGIN = addNode(VARIANT_SCANNERS.variantNode("Origin", "Origin.Scanner", "Origin Scanner"))
            .withDescription("Scans only in the origin position.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_QUEUE = addNode(VARIANT_SCANNERS.variantNode("Queue", "Queue.Scanner", "Queue Scanner"))
            .withDescription("Runs all the Scanners in the Queue, one after another.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Scanners", "Scanners", true, VARIANT_SCANNERS, "Scanners to run, in order.")
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_RADIAL = addNode(VARIANT_SCANNERS.variantNode("Radial", "Radial.Scanner", "Radial Scanner"))
            .withDescription("Starts at the anchor block, then moves outward from closest to farthest.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS, "The child Scanner to run for every block scanned by this Scanner. Not used if left empty.")
            .addNodeOutput("Bounds", "Bounds", false, NODE_BOUNDS_DECIMAL_3D, "The reach of this Scanner around the anchor.")
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_RANDOM = addNode(VARIANT_SCANNERS.variantNode("Random", "Random.Scanner", "Random Scanner"))
            .withDescription("Scans a line of blocks in a random order determined by the seed.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.enumContent("Axis", "Axis").withValues("X", "Y", "Z").withDefaultValue("Y").withDescription("Axis to scan along."))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS, "The child Scanner to run for every block scanned by this Scanner. Not used if left empty.")
            .addNodeOutput("Range", "Range", false, NODE_RANGE_INTEGER, "The range of blocks around the anchor to scan.")
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_TINT_PROVIDER_CONSTANT = addNode(VARIANT_TINT_PROVIDERS.variantNode("Constant", "Constant.TintProvider", "Constant TintProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Color", "Color").withDefaultValue("#FF0000").withWidth(150))
            .addCategory(CATEGORY_TINT_PROVIDERS);
    public static final NodeBuilder NODE_TINT_PROVIDER_DENSITY_DELIMITED = addNode(VARIANT_TINT_PROVIDERS.variantNode("DensityDelimited", "DensityDelimited.TintProvider", "DensityDelimited TintProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_TINT_PROVIDER_DENSITY_DELIMITED_DELIMITER)
            .addCategory(CATEGORY_TINT_PROVIDERS);
    public static final NodeBuilder NODE_TINT_PROVIDER_DENSITY_DELIMITED_DELIMITER = addNode(Renode.node("Delimiter.DensityDelimited.TintProvider", "Delimiter DDTP"))
            .addVariantOutput("Tint", "Tint", false, VARIANT_TINT_PROVIDERS)
            .addNodeOutput("Range", "Range", false, NODE_RANGE_DECIMAL)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_TINT_PROVIDERS);
    public static final NodeBuilder NODE_TINT_PROVIDER_MIX = addNode(VARIANT_TINT_PROVIDERS.variantNode("Mix", "Mix.TintProvider", "Mix TintProvider"))
            .withDescription("Blends TintA and TintB using a density field as the mix weight. At 0.0 only TintA is used, at 1.0 only TintB is used, and values in between are blended proportionally.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .addVariantOutput("TintA", "TintA", false, VARIANT_TINT_PROVIDERS)
            .addVariantOutput("TintB", "TintB", false, VARIANT_TINT_PROVIDERS)
            .addCategory(CATEGORY_TINT_PROVIDERS);
    
    public static final NodeBuilder NODE_VECTOR_PROVIDER_ADDER = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Adder", "Adder.VectorProvider", "Adder VectorProvider"))
            .withDescription("Adds the vectors from all connected VectorProviders.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Vectors", "Vectors", true, VARIANT_VECTOR_PROVIDERS, "VectorProviders to add together.")
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_CACHE = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Cache", "Cache.VectorProvider", "Cache VectorProvider"))
            .withDescription("Caches the input vector for each position.\nUse this only if the downstream (child) VectorProvider is expensive and the same coordinate is queried more than once.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Vector", "Vector", false, VARIANT_VECTOR_PROVIDERS)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_CONSTANT = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Constant", "Constant.VectorProvider", "Constant VectorProvider"))
            .withDescription("Generates the provided vector.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Vector", "Vector", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_CROSS = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Cross", "Cross.VectorProvider", "Cross VectorProvider"))
            .withDescription("Creates the cross product of two VectorProviders.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("VectorA", "VectorA", false, VARIANT_VECTOR_PROVIDERS)
            .addVariantOutput("VectorB", "VectorB", false, VARIANT_VECTOR_PROVIDERS)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_DENSITY_GRADIENT = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("DensityGradient", "DensityGradient.VectorProvider", "DensityGradient VectorProvider"))
            .withDescription("Generates the gradient of the provided Density field. The resulting gradient vector shows which direction the Density field increases and how quickly it changes.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SampleDistance", "SampleDistance").withDefaultValue(1.0).withWidth(50).withDescription("How far apart the Density field value samples are taken. The optimal value for performance is 1.0. Greater values could be useful for smoothing out results for specific applications."))
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_EXPORTED = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Exported", "Exported.VectorProvider", "Exported VectorProvider"))
            .withDescription("Allows exporting a VectorProvider as a single instance. Enabling SingleInstance on this node ensures all importers share the same logic.\nBy default, a completely different instance is created for every Imported node. When multiple Imported nodes import the same exported key, a new instance of that exported VectorProvider tree is created for each Imported node. SingleInstance ensures all importers share the same underlying instance of the node tree.\nThis node can be used to optimize caching when an exported VectorProvider is imported multiple times in the same context and contains caches. The caches would be shared between the different imported instances.\nImportant: This is still an experimental feature and could cause unexpected behaviors if misused.")
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("SingleInstance", "SingleInstance").withDefaultValue(false).withDescription("Enable this to share the export across all Imported nodes that reference this key."))
            .addVariantOutput("VectorProvider", "VectorProvider", false, VARIANT_VECTOR_PROVIDERS)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_IMPORTED = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Imported", "Imported.VectorProvider", "Imported VectorProvider"))
            .withDescription("Imports an exported VectorProvider.")
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350).withDescription("The exported VectorProvider."))
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_MULTIPLIER = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Multiplier", "Multiplier.VectorProvider", "Multiplier VectorProvider"))
            .withDescription("Multiplies the vectors from all connected VectorProviders.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Vectors", "Vectors", true, VARIANT_VECTOR_PROVIDERS, "VectorProviders to multiply together.")
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_NORMALIZER = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Normalizer", "Normalizer.VectorProvider", "Normalizer VectorProvider"))
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Vector", "Vector", false, VARIANT_VECTOR_PROVIDERS)
            .addVariantOutput("Magnitude", "Magnitude", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_OPPOSED_TO_GRAPH_EDGES = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("OpposedToGraphEdges", "OpposedToGraphEdges.VectorProvider", "[DEV] OpposedToGraphEdges VectorProvider"))
            .withDescription("Returns a unit vector that points away from connected graph neighbours. Uses the graph node from context, collects unit directions along each edge, and returns the eigenvector with the smallest eigenvalue of their outer-product sum.")
            .addContent(CONTENT_EXPORT_AS)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_PLANE_PROJECTOR = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("PlaneProjector", "PlaneProjector.VectorProvider", "PlaneProjector VectorProvider"))
            .withDescription("Projects the child VectorProvider onto a plane defined by two other VectorProviders.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Vector", "Vector", false, VARIANT_VECTOR_PROVIDERS)
            .addVariantOutput("PlaneA", "PlaneA", false, VARIANT_VECTOR_PROVIDERS)
            .addVariantOutput("PlaneB", "PlaneB", false, VARIANT_VECTOR_PROVIDERS)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_RANDOM = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Random", "Random.VectorProvider", "Random VectorProvider"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_SCALAR_MULTIPLIER = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("ScalarMultiplier", "ScalarMultiplier.VectorProvider", "ScalarMultiplier VectorProvider"))
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Vector", "Vector", false, VARIANT_VECTOR_PROVIDERS)
            .addVariantOutput("Scalar", "Scalar", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_SET_X = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("SetX", "SetX.VectorProvider", "SetX VectorProvider"))
            .withDescription("Sets the X value of the child vector to a value provided by a Density pin.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Vector", "Vector", false, VARIANT_VECTOR_PROVIDERS)
            .addVariantOutput("Value", "Value", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_SET_Y = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("SetY", "SetY.VectorProvider", "SetY VectorProvider"))
            .withDescription("Sets the Y value of the child vector to a value provided by a Density pin.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Vector", "Vector", false, VARIANT_VECTOR_PROVIDERS)
            .addVariantOutput("Value", "Value", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_SET_Z = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("SetZ", "SetZ.VectorProvider", "SetZ VectorProvider"))
            .withDescription("Sets the Z value of the child vector to a value provided by a Density pin.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Vector", "Vector", false, VARIANT_VECTOR_PROVIDERS)
            .addVariantOutput("Value", "Value", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_SUBTRACTER = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Subtracter", "Subtracter.VectorProvider", "Subtracter VectorProvider"))
            .withDescription("Subtracts the subtrahend from the minuend (minuend - subtrahend).")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Minuend", "Minuend", false, VARIANT_VECTOR_PROVIDERS)
            .addVariantOutput("Subtrahend", "Subtrahend", false, VARIANT_VECTOR_PROVIDERS)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_VECTOR_PROJECTOR = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("VectorProjector", "VectorProjector.VectorProvider", "VectorProjector VectorProvider"))
            .withDescription("Projects the child VectorProvider onto another vector.")
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Source", "Source", false, VARIANT_VECTOR_PROVIDERS)
            .addVariantOutput("Target", "Target", false, VARIANT_VECTOR_PROVIDERS)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_POINT_3D = addNode(Renode.node("Decimal.Vector3d", "Decimal 3D Vector"))
            .addContent(Renode.floatContent("X", "X").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("Y", "Y").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("Z", "Z").withDefaultValue(0.0).withWidth(100))
            .addCategory(CATEGORY_VECTORS);
    public static final NodeBuilder NODE_POINT_3D_INTEGER = addNode(Renode.node("Integer.Vector3d", "Integer 3D Vector"))
            .addContent(Renode.integerContent("X", "X").withDefaultValue(0).withWidth(100))
            .addContent(Renode.integerContent("Y", "Y").withDefaultValue(0).withWidth(100))
            .addContent(Renode.integerContent("Z", "Z").withDefaultValue(0).withWidth(100))
            .addCategory(CATEGORY_VECTORS);

    public static final AbstractNodeRoot ROOT_ASSIGNMENTS = addRoot(Renode.root(VARIANT_ASSIGNMENTS, "HytaleGenerator - Assignments"));
    public static final AbstractNodeRoot ROOT_BIOME = addRoot(Renode.root(NODE_BIOME, "HytaleGenerator - Biome"));
    public static final AbstractNodeRoot ROOT_BLOCK_MASK = addRoot(Renode.root(NODE_BLOCK_MASK, "HytaleGenerator - BlockMask"));
    public static final AbstractNodeRoot ROOT_DENSITY = addRoot(Renode.root(VARIANT_DENSITY, "HytaleGenerator - Density"));
    public static final AbstractNodeRoot ROOT_GRAPH_CONTENT_PREDICATE = addRoot(Renode.root(VARIANT_GRAPH_CONTENT_PREDICATES, "HytaleGenerator - ContentPredicate"));
    public static final AbstractNodeRoot ROOT_GRAPH_CONTENT_SUPPLIER = addRoot(Renode.root(VARIANT_GRAPH_CONTENT_SUPPLIERS, "HytaleGenerator - ContentSupplier"));
    public static final AbstractNodeRoot ROOT_GRAPH_GENERATOR = addRoot(Renode.root(NODE_GRAPH_GENERATOR, "HytaleGenerator - GraphGenerator"));
    public static final AbstractNodeRoot ROOT_GRAPH_PASS = addRoot(Renode.root(VARIANT_GRAPH_PASSES, "HytaleGenerator - GraphPass"));
    public static final AbstractNodeRoot ROOT_POSITIONS = addRoot(Renode.root(VARIANT_POSITIONS, "HytaleGenerator - Positions"));
    public static final AbstractNodeRoot ROOT_PROP = addRoot(Renode.root(VARIANT_PROPS, "HytaleGenerator - Prop"));
    public static final AbstractNodeRoot ROOT_PROP_DISTRIBUTION = addRoot(Renode.root(VARIANT_PROP_DISTRIBUTIONS, "HytaleGenerator - PropDistribution"));

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
