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
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_FIELD_FUNCTION = addNode(VARIANT_ASSIGNMENTS.variantNode("FieldFunction", "FieldFunction.Assignments", "FieldFunction Assignments"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("FieldFunction", "FieldFunction", false, VARIANT_DENSITY)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_ASSIGNMENTS_FIELD_FUNCTION_DELIMITER)
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_FIELD_FUNCTION_DELIMITER = addNode(Renode.node("Delimiter.FieldFunction.Assignments", "FieldFunction Delimiter"))
            .addContent(Renode.floatContent("Min", "Min").withDefaultValue(0.0).withWidth(70))
            .addContent(Renode.floatContent("Max", "Max").withDefaultValue(0.0).withWidth(70))
            .addVariantOutput("Assignments", "Assignments", false, VARIANT_ASSIGNMENTS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_IMPORTED = addNode(VARIANT_ASSIGNMENTS.variantNode("Imported", "Imported.Assignments", "Imported Assignments"))
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(250))
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_SANDWICH = addNode(VARIANT_ASSIGNMENTS.variantNode("Sandwich", "Sandwich.Assignments", "Sandwich Assignments"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_ASSIGNMENTS_SANDWICH_DELIMITER)
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_SANDWICH_DELIMITER = addNode(Renode.node("Delimiter.Sandwich.Assignments", "Sandwich Delimiter"))
            .addContent(Renode.floatContent("MinY", "MinY").withDefaultValue(0.0).withWidth(70))
            .addContent(Renode.floatContent("MaxY", "MaxY").withDefaultValue(100.0).withWidth(70))
            .addVariantOutput("Assignments", "Assignments", false, VARIANT_ASSIGNMENTS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_WEIGHTED = addNode(VARIANT_ASSIGNMENTS.variantNode("Weighted", "Weighted.Assignments", "Weighted Assignments"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SkipChance", "SkipChance").withDefaultValue(0.0).withWidth(70))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(150))
            .addNodeOutput("WeightedAssignments", "WeightedAssignments", true, () -> HytaleGeneratorNodes.NODE_ASSIGNMENTS_WEIGHTED_WEIGHT)
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_ASSIGNMENTS_WEIGHTED_WEIGHT = addNode(Renode.node("Weight.Weighted.Assignments", "Weight"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(70))
            .addVariantOutput("Assignments", "Assignments", false, VARIANT_ASSIGNMENTS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_ASSIGNMENTS);
    public static final NodeBuilder NODE_BIOME = addNode(Renode.node("Biome", "Biome"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(200))
            .addNodeOutput("Terrain", "Terrain", false, () -> HytaleGeneratorNodes.NODE_BIOME_TERRAIN)
            .addVariantOutput("MaterialProvider", "MaterialProvider", false, VARIANT_MATERIAL_PROVIDERS)
            .addNodeOutput("Props", "Props", true, () -> HytaleGeneratorNodes.NODE_RUNTIME)
            .addVariantOutput("EnvironmentProvider", "EnvironmentProvider", false, VARIANT_ENVIRONMENT_PROVIDERS)
            .addVariantOutput("TintProvider", "TintProvider", false, VARIANT_TINT_PROVIDERS)
            .addCategory(CATEGORY_BIOME);
    public static final NodeBuilder NODE_BIOME_TERRAIN = addNode(Renode.node("Terrain", "Terrain"))
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .withColorOverride("Grey")
            .addSchemaString("Type", "DAOTerrain")
            .addCategory(CATEGORY_BIOME);
    public static final NodeBuilder NODE_BLOCK_MASK = addNode(Renode.node("BlockMask", "BlockMask"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.smallStringContent("Import", "Import").withDefaultValue("").withWidth(250))
            .addNodeOutput("DontPlace", "DontPlace", false, () -> HytaleGeneratorNodes.NODE_BLOCK_MASK_BLOCK_SET)
            .addNodeOutput("DontReplace", "DontReplace", false, () -> HytaleGeneratorNodes.NODE_BLOCK_MASK_BLOCK_SET)
            .addNodeOutput("Advanced", "Advanced", true, () -> HytaleGeneratorNodes.NODE_BLOCK_MASK_RULE)
            .addCategory(CATEGORY_BLOCK_MASKS);
    public static final NodeBuilder NODE_BLOCK_MASK_BLOCK_SET = addNode(Renode.node("BlockSet.BlockMask", "BlockSet BlockMask"))
            .addContent(Renode.checkboxContent("Inclusive", "Inclusive").withDefaultValue(true))
            .addNodeOutput("Materials", "Materials", true, () -> HytaleGeneratorNodes.NODE_MATERIAL)
            .withColorOverride("Yellow")
            .addCategory(CATEGORY_BLOCK_MASKS);
    public static final NodeBuilder NODE_BLOCK_MASK_RULE = addNode(Renode.node("Rule.BlockMask", "Rule BlockMask"))
            .addNodeOutput("Source", "Source", false, NODE_BLOCK_MASK_BLOCK_SET)
            .addNodeOutput("CanReplace", "CanReplace", false, NODE_BLOCK_MASK_BLOCK_SET)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_BLOCK_MASKS);
    public static final NodeBuilder NODE_BOUNDS_DECIMAL_3D = addNode(Renode.node("DecimalBounds3d", "DecimalBounds3d"))
            .addNodeOutput("PointA", "PointA", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addNodeOutput("PointB", "PointB", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_BOUNDS);
    public static final NodeBuilder NODE_BOUNDS_INTEGER_3D = addNode(Renode.node("Bounds3i", "Integer 3D Bounds"))
            .addNodeOutput("PointA", "PointA", false, () -> HytaleGeneratorNodes.NODE_POINT_3D_INTEGER)
            .addNodeOutput("PointB", "PointB", false, () -> HytaleGeneratorNodes.NODE_POINT_3D_INTEGER)
            .addCategory(CATEGORY_BOUNDS);
    public static final NodeBuilder NODE_CURVE_CEILING = addNode(VARIANT_CURVES.variantNode("Ceiling", "Ceiling.Curve", "Ceiling Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Ceiling", "Ceiling").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_CLAMP = addNode(VARIANT_CURVES.variantNode("Clamp", "Clamp.Curve", "Clamp Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("WallA", "WallA").withDefaultValue(1.0).withWidth(100))
            .addContent(Renode.floatContent("WallB", "WallB").withDefaultValue(-1.0).withWidth(100))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_CONSTANT = addNode(VARIANT_CURVES.variantNode("Constant", "Constant.Curve", "Constant Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_DISTANCE_EXPONENTIAL = addNode(VARIANT_CURVES.variantNode("DistanceExponential", "DistanceExponentialCurve", "DistanceExponential Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Exponent", "Exponent").withDefaultValue(1.0).withWidth(100))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(10.0).withWidth(100))
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_DISTANCE_S = addNode(VARIANT_CURVES.variantNode("DistanceS", "DistanceSCurve", "DistanceS Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("ExponentA", "ExponentA").withDefaultValue(1.0).withWidth(100))
            .addContent(Renode.floatContent("ExponentB", "ExponentB").withDefaultValue(1.0).withWidth(100))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(10.0).withWidth(100))
            .addContent(Renode.floatContent("Transition", "Transition").withDefaultValue(1.0).withWidth(100))
            .addContent(Renode.floatContent("TransitionSmooth", "TransitionSmooth").withDefaultValue(1.0).withWidth(100))
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_FLOOR = addNode(VARIANT_CURVES.variantNode("Floor", "Floor.Curve", "Floor Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Floor", "Floor").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_IMPORTED = addNode(VARIANT_CURVES.variantNode("Imported", "ImportedCurve", "Imported Curve"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(100))
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_INVERTER = addNode(VARIANT_CURVES.variantNode("Inverter", "Inverter.Curve", "Inverter Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_MANUAL = addNode(VARIANT_CURVES.variantNode("Manual", "ManualCurve", "Manual Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addNodeOutput("Points", "Points", true, () -> HytaleGeneratorNodes.NODE_CURVE_MANUAL_POINT)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_MANUAL_POINT = addNode(Renode.node("CurvePoint", "Curve Point"))
            .addContent(Renode.floatContent("In", "In").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("Out", "Out").withDefaultValue(0.0).withWidth(100))
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_MAX = addNode(VARIANT_CURVES.variantNode("Max", "Max.Curve", "Max Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Curves", "Curves", true, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_MIN = addNode(VARIANT_CURVES.variantNode("Min", "Min.Curve", "Min Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Curves", "Curves", true, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_MULTIPLIER = addNode(VARIANT_CURVES.variantNode("Multiplier", "Multiplier.Curve", "Multiplier Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Curves", "Curves", true, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_NOT = addNode(VARIANT_CURVES.variantNode("Not", "Not.Curve", "Not Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_SMOOTH_CEILING = addNode(VARIANT_CURVES.variantNode("SmoothCeiling", "SmoothCeiling.Curve", "SmoothCeiling Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Ceiling", "Ceiling").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_SMOOTH_CLAMP = addNode(VARIANT_CURVES.variantNode("SmoothClamp", "SmoothClamp.Curve", "SmoothClamp Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("WallA", "WallA").withDefaultValue(1.0).withWidth(100))
            .addContent(Renode.floatContent("WallB", "WallB").withDefaultValue(-1.0).withWidth(100))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_SMOOTH_FLOOR = addNode(VARIANT_CURVES.variantNode("SmoothFloor", "SmoothFloor.Curve", "SmoothFloor Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Floor", "Floor").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_SMOOTH_MAX = addNode(VARIANT_CURVES.variantNode("SmoothMax", "SmoothMax.Curve", "SmoothMax Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("CurveA", "CurveA", false, VARIANT_CURVES)
            .addVariantOutput("CurveB", "CurveB", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_SMOOTH_MIN = addNode(VARIANT_CURVES.variantNode("SmoothMin", "SmoothMin.Curve", "SmoothMin Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("CurveA", "CurveA", false, VARIANT_CURVES)
            .addVariantOutput("CurveB", "CurveB", false, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_CURVE_SUM = addNode(VARIANT_CURVES.variantNode("Sum", "Sum.Curve", "Sum Curve"))
            .addContent(CONTENT_EXPORT_AS)
            .addVariantOutput("Curves", "Curves", true, VARIANT_CURVES)
            .addCategory(CATEGORY_CURVES);
    public static final NodeBuilder NODE_DENSITY_ABS = addNode(VARIANT_DENSITY.variantNode("Abs", "AbsDensityNode", "Abs Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_AMPLITUDE_CONSTANT = addNode(VARIANT_DENSITY.variantNode("AmplitudeConstant", "AmplitudeConstantDensityNode", "[DEPRECATED] AmplitudeConstant Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .withColorOverride("255,00,00")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_AMPLITUDE = addNode(VARIANT_DENSITY.variantNode("Amplitude", "AmplitudeDensityNode", "[DEPRECATED] Amplitude Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addNodeOutput("FunctionForY", "FunctionForY", false, () -> HytaleGeneratorNodes.NODE_FUNCTION_FOR_Y)
            .withColorOverride("255,00,00")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_ANCHOR = addNode(VARIANT_DENSITY.variantNode("Anchor", "Anchor.Density", "Anchor Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("Reversed", "Reversed").withDefaultValue(false))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_ANGLE = addNode(VARIANT_DENSITY.variantNode("Angle", "Angle.Density", "Angle Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("IsAxis", "IsAxis").withDefaultValue(false))
            .addNodeOutput("Vector", "Vector", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addVariantOutput("VectorProvider", "VectorProvider", false, VARIANT_VECTOR_PROVIDERS)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_AXIS = addNode(VARIANT_DENSITY.variantNode("Axis", "Axis.Density", "Axis Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("IsAnchored", "IsAnchored").withDefaultValue(false))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addNodeOutput("Axis", "Axis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_BASE_HEIGHT = addNode(VARIANT_DENSITY.variantNode("BaseHeight", "BaseHeight.Density", "BaseHeight Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("BaseHeightName", "BaseHeightName").withDefaultValue("Base").withWidth(250))
            .addContent(Renode.checkboxContent("Distance", "Distance").withDefaultValue(true))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CACHE = addNode(VARIANT_DENSITY.variantNode("Cache", "Cache.Density", "Cache Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("Capacity", "Capacity").withDefaultValue(3))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CEILING = addNode(VARIANT_DENSITY.variantNode("Ceiling", "CeilingDensityNode", "[DEPRECATED] Ceiling Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Limit", "Limit").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CELL_NOISE_2D = addNode(VARIANT_DENSITY.variantNode("CellNoise2D", "CellNoise2DDensityNode", "CellNoise2D Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Jitter", "Jitter").withDefaultValue(0.3).withWidth(100))
            .addContent(Renode.enumContent("CellType", "CellType").withValues("CellValue", "Distance", "Distance2", "Distance2Add", "Distance2Sub", "Distance2Mul", "Distance2Div").withDefaultValue("Distance2Div").withWidth(150))
            .addContent(Renode.floatContent("ScaleX", "ScaleX").withDefaultValue(20.0).withWidth(100))
            .addContent(Renode.floatContent("ScaleZ", "ScaleZ").withDefaultValue(20.0).withWidth(100))
            .addContent(Renode.integerSliderContent("Octaves", "Octaves", 0, 20, 1).withDefaultValue(1).withWidth(150))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(250))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CELL_NOISE_3D = addNode(VARIANT_DENSITY.variantNode("CellNoise3D", "CellNoise3DDensityNode", "CellNoise3D Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Jitter", "Jitter").withDefaultValue(0.3).withWidth(100))
            .addContent(Renode.enumContent("CellType", "CellType").withValues("CellValue", "Distance", "Distance2", "Distance2Add", "Distance2Sub", "Distance2Mul", "Distance2Div").withDefaultValue("Distance2Div").withWidth(150))
            .addContent(Renode.floatContent("ScaleX", "ScaleX").withDefaultValue(20.0).withWidth(100))
            .addContent(Renode.floatContent("ScaleY", "ScaleY").withDefaultValue(20.0).withWidth(100))
            .addContent(Renode.floatContent("ScaleZ", "ScaleZ").withDefaultValue(20.0).withWidth(100))
            .addContent(Renode.integerSliderContent("Octaves", "Octaves", 0, 20, 1).withDefaultValue(1).withWidth(150))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(250))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CELL_WALL_DISTANCE = addNode(VARIANT_DENSITY.variantNode("CellWallDistance", "CellWallDistance.Density", "[EXPERIMENTAL] CellWallDistance Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CLAMP = addNode(VARIANT_DENSITY.variantNode("Clamp", "ClampDensityNode", "Clamp Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("WallA", "WallA").withDefaultValue(-1.0).withWidth(100))
            .addContent(Renode.floatContent("WallB", "WallB").withDefaultValue(1.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CONSTANT = addNode(VARIANT_DENSITY.variantNode("Constant", "ConstantDensityNode", "Constant Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CUBE = addNode(VARIANT_DENSITY.variantNode("Cube", "Cube.Density", "Cube Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CUBOID = addNode(VARIANT_DENSITY.variantNode("Cuboid", "Cuboid.Density", "Cuboid Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Spin", "Spin").withDefaultValue(0.0))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addNodeOutput("Scale", "Scale", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addNodeOutput("NewYAxis", "NewYAxis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CURVE_MAPPER = addNode(VARIANT_DENSITY.variantNode("CurveMapper", "CurveMapper.Density", "CurveMapper Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_CYLINDER = addNode(VARIANT_DENSITY.variantNode("Cylinder", "Cylinder.Density", "Cylinder Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Spin", "Spin").withDefaultValue(0.0))
            .addVariantOutput("AxialCurve", "AxialCurve", false, VARIANT_CURVES)
            .addVariantOutput("RadialCurve", "RadialCurve", false, VARIANT_CURVES)
            .addNodeOutput("NewYAxis", "NewYAxis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_DISTANCE = addNode(VARIANT_DENSITY.variantNode("Distance", "Distance.Density", "Distance Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_DISTANCE_TO_BIOME_EDGE = addNode(VARIANT_DENSITY.variantNode("DistanceToBiomeEdge", "DistanceToBiomeEdge.Density", "DistanceToBiomeEdge Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_ELLIPSOID = addNode(VARIANT_DENSITY.variantNode("Ellipsoid", "Ellipsoid.Density", "Ellipsoid Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Spin", "Spin").withDefaultValue(0.0))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addNodeOutput("Scale", "Scale", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addNodeOutput("NewYAxis", "NewYAxis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_EXPORTED = addNode(VARIANT_DENSITY.variantNode("Exported", "Exported.Density", "[EXPERIMENTAL] Exported Density"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.checkboxContent("SingleInstance", "SingleInstance").withDefaultValue(false))
            .addContent(CONTENT_SKIP)
            .addVariantOutput("Inputs", "DensityInputs", true, VARIANT_DENSITY)
            .withColorOverride("184,71,222")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_FAST_GRADIENT_WARP = addNode(VARIANT_DENSITY.variantNode("FastGradientWarp", "FastGradientWarp.Density", "FastGradientWarp Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("WarpLacunarity", "WarpLacunarity").withDefaultValue(2.0).withWidth(70))
            .addContent(Renode.floatContent("WarpPersistence", "WarpPersistence").withDefaultValue(0.5).withWidth(70))
            .addContent(Renode.floatContent("WarpScale", "WarpScale").withDefaultValue(1.0).withWidth(70))
            .addContent(Renode.integerContent("WarpOctaves", "WarpOctaves").withDefaultValue(1).withWidth(70))
            .addContent(Renode.floatContent("WarpFactor", "WarpFactor").withDefaultValue(1.0).withWidth(70))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(250))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_FLOOR = addNode(VARIANT_DENSITY.variantNode("Floor", "FloorDensityNode", "[DEPRECATED] Floor Density"))
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
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SampleRange", "SampleRange").withDefaultValue(1.0).withWidth(70))
            .addContent(Renode.floatContent("WarpFactor", "WarpFactor").withDefaultValue(1.0).withWidth(70))
            .addContent(Renode.checkboxContent("2D", "2D Output").withDefaultValue(false))
            .addContent(Renode.floatContent("YFor2D", "Y for 2D").withDefaultValue(0.0))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_IMPORTED = addNode(VARIANT_DENSITY.variantNode("Imported", "ImportedDensityNode", "Imported Density"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(250))
            .addContent(CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_INVERTER = addNode(VARIANT_DENSITY.variantNode("Inverter", "InverterDensityNode", "Inverter Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_MAX = addNode(VARIANT_DENSITY.variantNode("Max", "MaxDensityNode", "Max Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_MIN = addNode(VARIANT_DENSITY.variantNode("Min", "MinDensityNode", "Min Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_MIX = addNode(VARIANT_DENSITY.variantNode("Mix", "Mix.Density", "Mix Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_MULTI_MIX = addNode(VARIANT_DENSITY.variantNode("MultiMix", "MultiMix.Density", "MultiMix Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addNodeOutput("Keys", "Keys", true, () -> HytaleGeneratorNodes.NODE_DENSITY_MULTI_MIX_KEY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_MULTI_MIX_KEY = addNode(Renode.node("Key.MultiMix.Density", "Key MultiMix Density"))
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.integerContent("DensityIndex", "DensityIndex").withDefaultValue(-1).withWidth(40))
            .withColorOverride("Orange")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_MULTIPLIER = addNode(VARIANT_DENSITY.variantNode("Multiplier", "MultiplierDensityNode", "Multiplier Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_NORMALIZER = addNode(VARIANT_DENSITY.variantNode("Normalizer", "NormalizerDensityNode", "Normalizer Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("FromMin", "FromMin").withDefaultValue(-1.0).withWidth(100))
            .addContent(Renode.floatContent("FromMax", "FromMax").withDefaultValue(1.0).withWidth(100))
            .addContent(Renode.floatContent("ToMin", "ToMin").withDefaultValue(-1.0).withWidth(100))
            .addContent(Renode.floatContent("ToMax", "ToMax").withDefaultValue(1.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_OFFSET_CONSTANT = addNode(VARIANT_DENSITY.variantNode("OffsetConstant", "OffsetConstantDensityNode", "[DEPRECATED] OffsetConstant Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .withColorOverride("255,00,00")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_OFFSET = addNode(VARIANT_DENSITY.variantNode("Offset", "OffsetDensityNode", "[DEPRECATED] Offset Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addNodeOutput("FunctionForY", "FunctionForY", false, () -> HytaleGeneratorNodes.NODE_FUNCTION_FOR_Y)
            .withColorOverride("255,00,00")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_PLANE  = addNode(VARIANT_DENSITY.variantNode("Plane", "Plane.Density", "Plane Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("IsAnchored", "IsAnchored").withDefaultValue(false))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addNodeOutput("PlaneNormal", "PlaneNormal", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_3D = addNode(VARIANT_DENSITY.variantNode("Positions3D", "Positions3DDensityNode", "[DEPRECATED] Positions3D Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(10.0).withWidth(100))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addVariantOutput("DistanceCurve", "DistanceCurve", false, VARIANT_CURVES)
            .withColorOverride("255,00,00");
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE = addNode(VARIANT_DENSITY.variantNode("PositionsCellNoise", "PositionsCellNoiseDensityNode", "PositionsCellNoise Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(10.0).withWidth(100))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addNodeOutput("DistanceFunction", "DistanceFunction", false, () -> HytaleGeneratorNodes.NODE_DENSITY_POSITIONS_CELL_NOISE_DISTANCE_FUNCTION)
            .addVariantOutput("ReturnType", "ReturnType", false, VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES)
            .addCategory(CATEGORY_DENSITY)
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_DISTANCE_FUNCTION = addNode(Renode.node("PCNDistanceFunction", "Distance Function"))
            .addContent(Renode.enumContent("Type", "Type").withValues("Euclidean", "Manhattan").withDefaultValue("Euclidean").withWidth(100))
            .withColorOverride("Olive")
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_CELL_VALUE = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("CellValue", "CellValuePCNReturnType", "CellValue ReturnType"))
            .addContent(Renode.floatContent("DefaultValue", "DefaultValue").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_CURVE = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Curve", "CurvePCNReturnType", "Curve ReturnType"))
            .addVariantOutput("Curve", "Curve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DENSITY = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Density", "DensityPCNReturnType", "Density ReturnType"))
            .addContent(Renode.floatContent("DefaultValue", "DefaultValue").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("ChoiceDensity", "ChoiceDensity", false, VARIANT_DENSITY)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DENSITY_DELIMITER)
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DENSITY_DELIMITER = addNode(Renode.node("Delimiter.DensityPCNReturnType", "Delimiter"))
            .addContent(Renode.floatContent("From", "From").withDefaultValue(-1.0).withWidth(70))
            .addContent(Renode.floatContent("To", "To").withDefaultValue(1.0).withWidth(70))
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .withColorOverride("Orange");
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DISTANCE = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Distance", "DistancePCNReturnType", "Distance ReturnType"))
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DISTANCE_2 = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Distance2", "Distance2PCNReturnType", "Distance2 ReturnType"))
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DISTANCE_2_ADD = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Distance2Add", "Distance2AddPCNReturnType", "Distance2Add ReturnType"))
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DISTANCE_2_DIV = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Distance2Div", "Distance2DivPCNReturnType", "Distance2Div ReturnType"))
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DISTANCE_2_MUL = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Distance2Mul", "Distance2MulPCNReturnType", "Distance2Mul ReturnType"))
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPE_DISTANCE_2_SUB = addNode(VARIANT_DENSITY_POSITIONS_CELL_NOISE_RETURN_TYPES.variantNode("Distance2Sub", "Distance2SubPCNReturnType", "Distance2Sub ReturnType"))
            .addCategory(CATEGORY_DENSITY_POSITIONS_CELL_NOISE);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_PINCH = addNode(VARIANT_DENSITY.variantNode("PositionsPinch", "PositionsPinch.Density", "PositionsPinch Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(10.0).withWidth(100))
            .addContent(Renode.checkboxContent("NormalizeDistance", "NormalizeDistance").withDefaultValue(true))
            .addContent(Renode.checkboxContent("HorizontalPinch", "HorizontalPinch").withDefaultValue(true))
            .addContent(Renode.floatContent("PositionsMaxY", "PositionsMaxY").withDefaultValue(1.0E-4).withWidth(100))
            .addContent(Renode.floatContent("PositionsMinY", "PositionsMinY").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addVariantOutput("PinchCurve", "PinchCurve", false, VARIANT_CURVES)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_POSITIONS_TWIST = addNode(VARIANT_DENSITY.variantNode("PositionsTwist", "PositionsTwist.Density", "PositionsTwist Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("MaxDistance", "MaxDistance").withDefaultValue(10.0).withWidth(100))
            .addContent(Renode.checkboxContent("NormalizeDistance", "NormalizeDistance").withDefaultValue(true))
            .addContent(Renode.checkboxContent("ZeroPositionsY", "ZeroPositionsY").withDefaultValue(false))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addVariantOutput("TwistCurve", "TwistCurve", false, VARIANT_CURVES)
            .addNodeOutput("TwistAxis", "TwistAxis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_POW = addNode(VARIANT_DENSITY.variantNode("Pow", "PowDensityNode", "Pow Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Exponent", "Exponent").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_ROTATOR = addNode(VARIANT_DENSITY.variantNode("Rotator", "Rotator.Density", "Rotator Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SpinAngle", "SpinAngle").withDefaultValue(0.0))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addNodeOutput("NewYAxis", "NewYAxis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SCALE = addNode(VARIANT_DENSITY.variantNode("Scale", "Scale.Density", "Scale Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("ScaleX", "ScaleX").withDefaultValue(1.0).withWidth(70))
            .addContent(Renode.floatContent("ScaleY", "ScaleY").withDefaultValue(1.0).withWidth(70))
            .addContent(Renode.floatContent("ScaleZ", "ScaleZ").withDefaultValue(1.0).withWidth(70))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SHELL = addNode(VARIANT_DENSITY.variantNode("Shell", "Shell.Density", "Shell Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("Mirror", "Mirror").withDefaultValue(false))
            .addVariantOutput("AngleCurve", "AngleCurve", false, VARIANT_CURVES)
            .addVariantOutput("DistanceCurve", "DistanceCurve", false, VARIANT_CURVES)
            .addNodeOutput("Axis", "Axis", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SIMPLEX_NOISE_2D = addNode(VARIANT_DENSITY.variantNode("SimplexNoise2D", "SimplexNoise2DDensityNode", "SimplexNoise2D Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Lacunarity", "Lacunarity").withDefaultValue(2.0).withWidth(100))
            .addContent(Renode.floatContent("Persistence", "Persistence").withDefaultValue(0.5).withWidth(100))
            .addContent(Renode.floatContent("Scale", "Scale").withDefaultValue(50.0).withWidth(100))
            .addContent(Renode.integerSliderContent("Octaves", "Octaves", 1, 10, 1).withDefaultValue(1).withWidth(150))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(250))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SIMPLEX_NOISE_3D = addNode(VARIANT_DENSITY.variantNode("SimplexNoise3D", "SimplexNoise3DDensityNode", "SimplexNoise3D Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Lacunarity", "Lacunarity").withDefaultValue(2.0).withWidth(100))
            .addContent(Renode.floatContent("Persistence", "Persistence").withDefaultValue(0.5).withWidth(100))
            .addContent(Renode.floatContent("ScaleXZ", "ScaleXZ").withDefaultValue(50.0).withWidth(100))
            .addContent(Renode.floatContent("ScaleY", "ScaleY").withDefaultValue(50.0).withWidth(100))
            .addContent(Renode.integerSliderContent("Octaves", "Octaves", 1, 10, 1).withDefaultValue(1).withWidth(150))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(250))
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SLIDER = addNode(VARIANT_DENSITY.variantNode("Slider", "Slider.Density", "Slider Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SlideX", "SlideX").withDefaultValue(0.0).withWidth(70))
            .addContent(Renode.floatContent("SlideY", "SlideY").withDefaultValue(0.0).withWidth(70))
            .addContent(Renode.floatContent("SlideZ", "SlideZ").withDefaultValue(0.0).withWidth(70))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SMOOTH_CEILING = addNode(VARIANT_DENSITY.variantNode("SmoothCeiling", "SmoothCeilingDensityNode", "[DEPRECATED] SmoothCeiling Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Range", "Value").withDefaultValue(0.2).withWidth(100))
            .addContent(Renode.floatContent("Limit", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SMOOTH_CLAMP = addNode(VARIANT_DENSITY.variantNode("SmoothClamp", "SmoothClampDensityNode", "SmoothClamp Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("WallA", "WallA").withDefaultValue(-1.0).withWidth(100))
            .addContent(Renode.floatContent("WallB", "WallB").withDefaultValue(1.0).withWidth(100))
            .addContent(Renode.floatContent("Range", "Range").withDefaultValue(0.2).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SMOOTH_FLOOR = addNode(VARIANT_DENSITY.variantNode("SmoothFloor", "SmoothFloorDensityNode", "[DEPRECATED] SmoothFloor Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Range", "Value").withDefaultValue(0.2).withWidth(100))
            .addContent(Renode.floatContent("Limit", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SMOOTH_MAX = addNode(VARIANT_DENSITY.variantNode("SmoothMax", "SmoothMaxDensityNode", "SmoothMax Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Range", "Value").withDefaultValue(0.2).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SMOOTH_MIN = addNode(VARIANT_DENSITY.variantNode("SmoothMin", "SmoothMinDensityNode", "SmoothMin Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Range", "Value").withDefaultValue(0.2).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SQRT = addNode(VARIANT_DENSITY.variantNode("Sqrt", "SqrtDensityNode", "Sqrt Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SUM = addNode(VARIANT_DENSITY.variantNode("Sum", "SumDensityNode", "Sum Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SWITCH = addNode(VARIANT_DENSITY.variantNode("Switch", "Switch.Density", "Switch Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("SwitchCases", "SwitchCases", true, () -> HytaleGeneratorNodes.NODE_DENSITY_SWITCH_CASE)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SWITCH_CASE = addNode(Renode.node("Case.Switch.Density", "Switch Case"))
            .addContent(Renode.smallStringContent("CaseState", "CaseState").withDefaultValue("Default").withWidth(250))
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_SWITCH_STATE = addNode(VARIANT_DENSITY.variantNode("SwitchState", "SwitchState.Density", "SwitchState Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("SwitchState", "SwitchState").withDefaultValue("").withWidth(250))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_TERRAIN = addNode(VARIANT_DENSITY.variantNode("Terrain", "Terrain.Density", "Terrain Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_VECTOR_WARP = addNode(VARIANT_DENSITY.variantNode("VectorWarp", "VectorWarp.Density", "VectorWarp Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("WarpFactor", "WarpFactor").withDefaultValue(1.0).withWidth(70))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addNodeOutput("WarpVector", "WarpVector", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_X_OVERRIDE = addNode(VARIANT_DENSITY.variantNode("XOverride", "XOverride.Density", "XOverride Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_X_VALUE = addNode(VARIANT_DENSITY.variantNode("XValue", "XValue.Density", "XValue Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_Y_OVERRIDE = addNode(VARIANT_DENSITY.variantNode("YOverride", "YOverride.Density", "YOverride Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "DensityInputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_Y_SAMPLED = addNode(VARIANT_DENSITY.variantNode("YSampled", "YSampled.Density", "YSampled Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SampleDistance", "SampleDistance").withDefaultValue(4.0))
            .addContent(Renode.floatContent("SampleOffset", "SampleOffset").withDefaultValue(0.0))
            .addContent(Renode.checkboxContent("Interpolate", "Interpolate").withDefaultValue(true))
            .addVariantOutput("Inputs", "Input", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_Y_VALUE = addNode(VARIANT_DENSITY.variantNode("YValue", "YValue.Density", "YValue Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_Z_OVERRIDE = addNode(VARIANT_DENSITY.variantNode("ZOverride", "ZOverride.Density", "ZOverride Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Value", "Value").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("Inputs", "Inputs", true, VARIANT_DENSITY)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DENSITY_Z_VALUE = addNode(VARIANT_DENSITY.variantNode("ZValue", "ZValue.Density", "ZValue Density"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_DENSITY);
    public static final NodeBuilder NODE_DIRECTIONALITY_IMPORTED = addNode(VARIANT_DIRECTIONALITY.variantNode("Imported", "Imported.Directionality", "Imported Directionality"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(250))
            .addCategory(CATEGORY_DIRECTIONALITY);
    public static final NodeBuilder NODE_DIRECTIONALITY_PATTERN = addNode(VARIANT_DIRECTIONALITY.variantNode("Pattern", "Pattern.Directionality", "Pattern Directionality"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.smallStringContent("InitialDirection", "InitialDirection").withDefaultValue("N").withWidth(40))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(250))
            .addVariantOutput("NorthPattern", "NorthPattern", false, VARIANT_PATTERNS)
            .addVariantOutput("SouthPattern", "SouthPattern", false, VARIANT_PATTERNS)
            .addVariantOutput("EastPattern", "EastPattern", false, VARIANT_PATTERNS)
            .addVariantOutput("WestPattern", "WestPattern", false, VARIANT_PATTERNS)
            .addCategory(CATEGORY_DIRECTIONALITY);
    public static final NodeBuilder NODE_DIRECTIONALITY_RANDOM = addNode(VARIANT_DIRECTIONALITY.variantNode("Random", "Random.Directionality", "Random Directionality"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(250))
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
    public static final NodeBuilder NODE_FUNCTION_FOR_Y_POINT = addNode(Renode.node("FunctionForYPoint", "FunctionForY Point"))
            .addContent(Renode.floatContent("Y", "Y").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("Out", "Out").withDefaultValue(0.0).withWidth(100))
            .withColorOverride("Orange");
    public static final NodeBuilder NODE_MATERIAL = addNode(Renode.node("Material", "Material"))
            .addContent(Renode.smallStringContent("Solid", "Solid").withDefaultValue("").withWidth(350))
            .addContent(Renode.smallStringContent("Fluid", "Fluid").withDefaultValue("").withWidth(350))
            .addContent(Renode.checkboxContent("SolidBottomUp", "SolidBottomUp").withDefaultValue(false))
            .addNodeOutput("SolidRotation", "SolidRotation", false, () -> HytaleGeneratorNodes.NODE_ORTHOGONAL_ROTATION)
            .addCategory(CATEGORY_MATERIAL);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_CONSTANT = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Constant", "ConstantMaterialProvider", "Constant MaterialProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Material", "Material", false, NODE_MATERIAL)
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_FIELD_FUNCTION = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("FieldFunction", "FieldFunctionMaterialProvider", "FieldFunction MaterialProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("FieldFunction", "FieldFunction", false, VARIANT_DENSITY)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_MATERIAL_PROVIDER_FIELD_FUNCTION_DELIMITER)
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_FIELD_FUNCTION_DELIMITER = addNode(Renode.node("DelimiterFieldFunctionMP", "Delimiter FFMP"))
            .addContent(Renode.floatContent("From", "From").withDefaultValue(0.0).withWidth(50))
            .addContent(Renode.floatContent("To", "To").withDefaultValue(1.0).withWidth(50))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_IMPORTED = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Imported", "ImportedMaterialProvider", "Imported MaterialProvider"))
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(250))
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_QUEUE = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Queue", "QueueMaterialProvider", "Queue MaterialProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Queue", "Queue", true, VARIANT_MATERIAL_PROVIDERS)
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SIMPLE_HORIZONTAL = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("SimpleHorizontal", "SimpleHorizontalMaterialProvider", "SimpleHorizontal MaterialProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("TopY", "TopY").withDefaultValue(64).withWidth(50))
            .addContent(Renode.smallStringContent("TopBaseHeight", "Top BaseHeight").withDefaultValue("").withWidth(250))
            .addContent(Renode.integerContent("BottomY", "BottomY").withDefaultValue(0).withWidth(50))
            .addContent(Renode.smallStringContent("BottomBaseHeight", "Bottom BaseHeight").withDefaultValue("").withWidth(250))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SOLIDITY = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Solidity", "SolidityMaterialProvider", "Solidity MaterialProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Solid", "Solid", false, VARIANT_MATERIAL_PROVIDERS)
            .addVariantOutput("Empty", "Empty", false, VARIANT_MATERIAL_PROVIDERS)
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("SpaceAndDepth", "SpaceAndDepthMaterialProvider", "SpaceAndDepth MaterialProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.enumContent("LayerContext", "LayerContext").withValues("DEPTH_INTO_FLOOR", "DEPTH_INTO_CEILING").withDefaultValue("DEPTH_INTO_FLOOR").withWidth(200))
            .addContent(Renode.integerContent("MaxExpectedDepth", "MaxExpectedDepth").withDefaultValue(3).withWidth(50))
            .addVariantOutput("Condition", "Condition", false, VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS)
            .addVariantOutput("Layers", "Layers", true, VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYERS)
            .addCategory(CATEGORY_MATERIAL_PROVIDERS)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_ALWAYS_TRUE = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("AlwaysTrueCondition", "AlwaysTrueConditionSADMP", "AlwaysTrue Condition SADMP"))
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_AND = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("AndCondition", "AndConditionSADMP", "And Condition SADMP"))
            .addVariantOutput("Conditions", "Conditions", true, VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_EQUALS = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("EqualsCondition", "EqualsConditionSADMP", "Equals Condition SADMP"))
            .addContent(Renode.smallStringContent("ContextToCheck", "ContextToCheck").withDefaultValue("SPACE_ABOVE_FLOOR").withWidth(200))
            .addContent(Renode.integerContent("Value", "Value").withDefaultValue(1).withWidth(50))
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_GREATER_THAN = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("GreaterThanCondition", "GreaterThanConditionSADMP", "GreaterThan Condition SADMP"))
            .addContent(Renode.smallStringContent("ContextToCheck", "ContextToCheck").withDefaultValue("SPACE_ABOVE_FLOOR").withWidth(200))
            .addContent(Renode.integerContent("Threshold", "Threshold").withDefaultValue(1).withWidth(50))
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_NOT = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("NotCondition", "NotConditionSADMP", "Not Condition SADMP"))
            .addVariantOutput("Conditions", "Conditions", false, VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_OR = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("OrCondition", "OrConditionSADMP", "Or Condition SADMP"))
            .addVariantOutput("Conditions", "Conditions", true, VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITION_SMALLER_THAN = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_CONDITIONS.variantNode("SmallerThanCondition", "SmallerThanConditionSADMP", "SmallerThan Condition SADMP"))
            .addContent(Renode.smallStringContent("ContextToCheck", "ContextToCheck").withDefaultValue("SPACE_ABOVE_FLOOR").withWidth(200))
            .addContent(Renode.integerContent("Threshold", "Threshold").withDefaultValue(1).withWidth(50))
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYER_CONSTANT_THICKNESS = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYERS.variantNode("ConstantThickness", "ConstantThicknessLayerSADMP", "ConstantThickness Layer SADMP"))
            .addContent(Renode.integerContent("Thickness", "Thickness").withDefaultValue(1).withWidth(50))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYER_NOISE_THICKNESS = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYERS.variantNode("NoiseThickness", "NoiseThicknessLayerSADMP", "NoiseThickness Layer SADMP"))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .addVariantOutput("ThicknessFunctionXZ", "Density", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYER_RANGE_THICKNESS = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYERS.variantNode("RangeThickness", "RangeThicknessLayerSADMP", "RangeThickness Layer SADMP"))
            .addContent(Renode.integerContent("RangeMax", "RangeMax").withDefaultValue(3).withWidth(50))
            .addContent(Renode.integerContent("RangeMin", "RangeMin").withDefaultValue(1).withWidth(50))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(150))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYER_WEIGHTED_THICKNESS = addNode(VARIANT_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYERS.variantNode("WeightedThickness", "WeightedThicknessLayerSADMP", "WeightedThickness Layer SADMP"))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(150))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .addNodeOutput("PossibleThicknesses", "Thicknesses", true, () -> HytaleGeneratorNodes.NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYER_WEIGHTED_THICKNESS_WEIGHT)
            .addCategory(CATEGORY_MATERIAL_PROVIDER_SPACE_AND_DEPTH);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_SPACE_AND_DEPTH_LAYER_WEIGHTED_THICKNESS_WEIGHT = addNode(Renode.node("WeightedThicknessLayerSADMP", "WeightedThickness SADMP"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50))
            .addContent(Renode.integerContent("Thickness", "Thickness").withDefaultValue(1).withWidth(50))
            .withColorOverride("Orange");
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_STRIPED = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Striped", "StripedMaterialProvider", "Striped MaterialProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .addNodeOutput("Stripes", "Stripes", true, () -> HytaleGeneratorNodes.NODE_MATERIAL_PROVIDER_STRIPED_STRIPE)
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_STRIPED_STRIPE = addNode(Renode.node("StripeStripedMP", "Stripe"))
            .addContent(Renode.integerContent("TopY", "TopY").withDefaultValue(1).withWidth(50))
            .addContent(Renode.integerContent("BottomY", "BottomY").withDefaultValue(0).withWidth(50))
            .withColorOverride("Orange")
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_WEIGHTED = addNode(VARIANT_MATERIAL_PROVIDERS.variantNode("Weighted", "WeightedMaterialProvider", "Weighted MaterialProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(150))
            .addContent(Renode.floatContent("SkipChance", "SkipChance").withDefaultValue(0.0).withWidth(100))
            .addNodeOutput("WeightedMaterials", "WeightedMaterials", true, () -> HytaleGeneratorNodes.NODE_MATERIAL_PROVIDER_WEIGHTED_MATERIAL)
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_MATERIAL_PROVIDER_WEIGHTED_MATERIAL = addNode(Renode.node("WeightedMaterial", "Weight"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0).withWidth(50))
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_MATERIAL_PROVIDERS);
    public static final NodeBuilder NODE_ORTHOGONAL_ROTATION = addNode(Renode.node("OrthogonalRotation", "Orthogonal Rotation"))
            .addContent(Renode.enumContent("Yaw", "Yaw").withValues("None", "Ninety", "OneEighty", "TwoSeventy").withDefaultValue("None").withWidth(200))
            .addContent(Renode.enumContent("Pitch", "Pitch").withValues("None", "Ninety", "OneEighty", "TwoSeventy").withDefaultValue("None").withWidth(200))
            .addContent(Renode.enumContent("Roll", "Roll").withValues("None", "Ninety", "OneEighty", "TwoSeventy").withDefaultValue("None").withWidth(200))
            .withColorOverride("Orange")
            .addCategory(CATEGORY_MATERIAL);
    public static final NodeBuilder NODE_PATTERN_AND = addNode(VARIANT_PATTERNS.variantNode("And", "And.Pattern", "And Pattern"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Patterns", "Patterns", true, VARIANT_PATTERNS)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_BLOCK_SET = addNode(VARIANT_PATTERNS.variantNode("BlockSet", "BlockSet.Pattern", "BlockSet Pattern"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("BlockSet", "BlockSet", false, NODE_BLOCK_MASK_BLOCK_SET)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_BLOCK_TYPE = addNode(VARIANT_PATTERNS.variantNode("BlockType", "BlockType.Pattern", "BlockType Pattern"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Material", "Material", false, NODE_MATERIAL)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_CEILING = addNode(VARIANT_PATTERNS.variantNode("Ceiling", "Ceiling.Pattern", "Ceiling Pattern"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Ceiling", "Ceiling", false, VARIANT_PATTERNS)
            .addVariantOutput("Origin", "Origin", false, VARIANT_PATTERNS)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_CUBOID = addNode(VARIANT_PATTERNS.variantNode("Cuboid", "Cuboid.Pattern", "Cuboid Pattern"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Max", "Max", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addNodeOutput("Min", "Min", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addVariantOutput("SubPattern", "SubPattern", false, VARIANT_PATTERNS)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_FIELD_FUNCTION = addNode(VARIANT_PATTERNS.variantNode("FieldFunction", "FieldFunction.Pattern", "FieldFunction Pattern"))
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
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Origin", "Origin", false, VARIANT_PATTERNS)
            .addVariantOutput("Floor", "Floor", false, VARIANT_PATTERNS)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_GAP = addNode(VARIANT_PATTERNS.variantNode("Gap", "Gap.Pattern", "[DEPRECATED] Gap Pattern"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("GapSize", "GapSize").withDefaultValue(3.0).withWidth(70))
            .addContent(Renode.floatContent("AnchorSize", "AnchorSize").withDefaultValue(1.0).withWidth(70))
            .addContent(Renode.floatContent("AnchorRoughness", "AnchorRoughness").withDefaultValue(1.0).withWidth(70))
            .addContent(Renode.integerContent("DepthDown", "DepthDown").withDefaultValue(0).withWidth(70))
            .addContent(Renode.integerContent("DepthUp", "DepthUp").withDefaultValue(0).withWidth(70))
            .addContent(Renode.listContent("Angles", "Angles", "Float").withWidth(70))
            .addVariantOutput("GapPattern", "GapPattern", false, VARIANT_PATTERNS)
            .addVariantOutput("AnchorPattern", "AnchorPattern", false, VARIANT_PATTERNS)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_IMPORTED = addNode(VARIANT_PATTERNS.variantNode("Imported", "Imported.Pattern", "Imported Pattern"))
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(250))
            .addContent(CONTENT_SKIP)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_NOT = addNode(VARIANT_PATTERNS.variantNode("Not", "Not.Pattern", "Not Pattern"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_OFFSET = addNode(VARIANT_PATTERNS.variantNode("Offset", "Offset.Pattern", "Offset Pattern"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addNodeOutput("Offset", "Offset", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_OR = addNode(VARIANT_PATTERNS.variantNode("Or", "Or.Pattern", "Or Pattern"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Patterns", "Patterns", true, VARIANT_PATTERNS)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_ROTATOR = addNode(VARIANT_PATTERNS.variantNode("Rotator", "Rotator.Pattern", "Rotator Pattern"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addNodeOutput("Rotation", "Rotation", false, NODE_ORTHOGONAL_ROTATION)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_SURFACE = addNode(VARIANT_PATTERNS.variantNode("Surface", "Surface.Pattern", "Surface Pattern"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SurfaceRadius", "SurfaceRadius").withDefaultValue(1.0))
            .addContent(Renode.floatContent("MediumRadius", "MediumRadius").withDefaultValue(1.0))
            .addContent(Renode.integerContent("SurfaceGap", "SurfaceGap").withDefaultValue(0))
            .addContent(Renode.integerContent("MediumGap", "MediumGap").withDefaultValue(0))
            .addContent(Renode.listContent("Facings", "Facings", "String").withWidth(40))
            .addContent(Renode.checkboxContent("RequireAllFacings", "RequireAllFacings").withDefaultValue(false))
            .addVariantOutput("Surface", "Surface", false, VARIANT_PATTERNS)
            .addVariantOutput("Medium", "Medium", false, VARIANT_PATTERNS)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_PATTERN_WALL = addNode(VARIANT_PATTERNS.variantNode("Wall", "Wall.Pattern", "Wall Pattern"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.listContent("Directions", "Directions", "String").withWidth(40))
            .addContent(Renode.checkboxContent("RequireAllDirections", "RequireAllDirections").withDefaultValue(false))
            .addVariantOutput("Wall", "Wall", false, VARIANT_PATTERNS)
            .addVariantOutput("Origin", "Origin", false, VARIANT_PATTERNS)
            .addCategory(CATEGORY_PATTERNS);
    public static final NodeBuilder NODE_POINT_GENERATOR_MESH = addNode(VARIANT_POINT_GENERATORS.variantNode("Mesh", "MeshPointGenerator", "[DEPRECATED] Mesh Point Generator"))
            .addContent(CONTENT_SKIP)
            .addContent(Renode.floatContent("Jitter", "Jitter").withDefaultValue(0.4).withWidth(100))
            .addContent(Renode.floatContent("ScaleX", "ScaleX").withDefaultValue(40.0).withWidth(100))
            .addContent(Renode.floatContent("ScaleY", "ScaleY").withDefaultValue(40.0).withWidth(100))
            .addContent(Renode.floatContent("ScaleZ", "ScaleZ").withDefaultValue(40.0).withWidth(100))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(100))
            .addCategory(CATEGORY_POINT_GENERATORS);
    public static final NodeBuilder NODE_POSITIONS_ANCHOR = addNode(VARIANT_POSITIONS.variantNode("Anchor", "Anchor.Positions", "Anchor Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("Reversed", "Reversed").withDefaultValue(false))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_BASE_HEIGHT = addNode(VARIANT_POSITIONS.variantNode("BaseHeight", "BaseHeight.Positions", "BaseHeight Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("BedName", "BaseHeightName").withDefaultValue("").withWidth(250))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_BOUND = addNode(VARIANT_POSITIONS.variantNode("Bound", "Bound.Positions", "Bound Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addNodeOutput("Bounds", "Bounds", false, NODE_BOUNDS_DECIMAL_3D)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_CACHE = addNode(VARIANT_POSITIONS.variantNode("Cache", "CachePositions", "Cache Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("SectionsSize", "SectionsSize").withDefaultValue(32).withWidth(50))
            .addContent(Renode.integerContent("CacheSize", "CacheSize").withDefaultValue(50).withWidth(50))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_CLUSTERS = addNode(VARIANT_POSITIONS.variantNode("Clusters", "Clusters.Positions", "Clusters Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Cluster", "Cluster", false, VARIANT_POSITIONS)
            .addVariantOutput("Distributor", "Distributor", false, VARIANT_POSITIONS)
            .addNodeOutput("ClusterBounds", "ClusterBounds", false, NODE_BOUNDS_DECIMAL_3D)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_FIELD_FUNCTION = addNode(VARIANT_POSITIONS.variantNode("FieldFunction", "FieldFunctionPositions", "FieldFunction Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addVariantOutput("FieldFunction", "Density", false, VARIANT_DENSITY)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_POSITIONS_FIELD_FUNCTION_DELIMITER)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_FIELD_FUNCTION_DELIMITER = addNode(Renode.node("Delimiter", "Delimiter"))
            .addContent(CONTENT_EXPORT_AS)
            .addContent(Renode.floatContent("Min", "Min").withDefaultValue(-1.0).withWidth(100))
            .addContent(Renode.floatContent("Max", "Max").withDefaultValue(1.0).withWidth(100))
            .withColorOverride("Orange");
    public static final NodeBuilder NODE_POSITIONS_FRAMEWORK = addNode(VARIANT_POSITIONS.variantNode("Framework", "Framework.Positions", "Framework Positions"))
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(150));
    public static final NodeBuilder NODE_POSITIONS_IMPORTED = addNode(VARIANT_POSITIONS.variantNode("Imported", "ImportedPositions", "Imported Positions"))
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(150))
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_JITTER_2D = addNode(VARIANT_POSITIONS.variantNode("Jitter2d", "Jitter2d.Positions", "Jitter2d Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Magnitude", "Magnitude").withDefaultValue(0.0).withWidth(50))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(150))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_JITTER_3D = addNode(VARIANT_POSITIONS.variantNode("Jitter3d", "Jitter3d.Positions", "Jitter3d Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("Magnitude", "Magnitude").withDefaultValue(0.0).withWidth(50))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(150))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_LIST = addNode(VARIANT_POSITIONS.variantNode("List", "ListPositions", "List Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Positions", "Positions", true, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_MESH_2D = addNode(VARIANT_POSITIONS.variantNode("Mesh2D", "Mesh2DPositions", "[DEPRECATED] Mesh2D Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("PointsY", "PointsY").withDefaultValue(0.0).withWidth(100))
            .addVariantOutput("PointGenerator", "PointGenerator", false, VARIANT_POINT_GENERATORS)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_MESH_3D = addNode(VARIANT_POSITIONS.variantNode("Mesh3D", "Mesh3DPositions", "[DEPRECATED] Mesh3D Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("PointGenerator", "PointGenerator", false, VARIANT_POINT_GENERATORS)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_OCCURRENCE = addNode(VARIANT_POSITIONS.variantNode("Occurrence", "OccurrencePositions", "Occurrence Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(100))
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addVariantOutput("FieldFunction", "FieldFunction", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_OFFSET = addNode(VARIANT_POSITIONS.variantNode("Offset", "OffsetPositions", "Offset Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("OffsetX", "[DEPRECATED] OffsetX").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("OffsetY", "[DEPRECATED] OffsetY").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("OffsetZ", "[DEPRECATED] OffsetZ").withDefaultValue(0.0).withWidth(100))
            .addNodeOutput("Offset", "Offset", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_SCALER = addNode(VARIANT_POSITIONS.variantNode("Scaler", "Scaler.Positions", "Scaler Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addNodeOutput("Scale", "Scale", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_SIMPLE_HORIZONTAL = addNode(VARIANT_POSITIONS.variantNode("SimpleHorizontal", "SimpleHorizontal.Positions", "SimpleHorizontal Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addNodeOutput("RangeY", "RangeY", false, () -> HytaleGeneratorNodes.NODE_RANGE_DECIMAL)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_SQUARE_GRID_2D = addNode(VARIANT_POSITIONS.variantNode("SquareGrid2d", "SquareGrid2d.Positions", "SquareGrid2d Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_SQUARE_GRID_3D = addNode(VARIANT_POSITIONS.variantNode("SquareGrid3d", "SquareGrid3d.Positions", "SquareGrid3d Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_TRIANGULAR_GRID_2D = addNode(VARIANT_POSITIONS.variantNode("TriangularGrid2d", "TriangularGrid2d.Positions", "TriangularGrid2d Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_POSITIONS_UNION = addNode(VARIANT_POSITIONS.variantNode("Union", "UnionPositions", "Union Positions"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", true, VARIANT_POSITIONS)
            .addCategory(CATEGORY_POSITIONS);
    public static final NodeBuilder NODE_PROP_BOX = addNode(VARIANT_PROPS.variantNode("Box", "BoxProp", "[DEPRECATED] Box Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS)
            .addNodeOutput("Range", "Range", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addNodeOutput("Material", "Material", false, NODE_MATERIAL)
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_CLUSTER = addNode(VARIANT_PROPS.variantNode("Cluster", "Cluster.Prop", "[DEPRECATED] Cluster Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("Range", "Range").withDefaultValue(10).withWidth(50))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(250))
            .addVariantOutput("DistanceCurve", "DistanceCurve", false, VARIANT_CURVES)
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
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Bounds", "Bounds", false, NODE_BOUNDS_INTEGER_3D)
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_DENSITY = addNode(VARIANT_PROPS.variantNode("Density", "Density.Prop", "Density Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Bounds", "Bounds", false, NODE_BOUNDS_INTEGER_3D)
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .addVariantOutput("Material", "Material", false, VARIANT_MATERIAL_PROVIDERS)
            .addVariantOutput("Pattern", "[DEPRECATED] Pattern", false, VARIANT_PATTERNS)
            .addVariantOutput("Scanner", "[DEPRECATED] Scanner", false, VARIANT_SCANNERS)
            .addNodeOutput("PlacementMask", "[DEPRECATED] PlacementMask", false, NODE_BLOCK_MASK)
            .addNodeOutput("Range", "[DEPRECATED] Range", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_DENSITY_SELECTOR = addNode(VARIANT_PROPS.variantNode("DensitySelector", "DensitySelector.Prop", "DensitySelector Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Delimiters", "Delimiters", true, () -> HytaleGeneratorNodes.NODE_PROP_DENSITY_SELECTOR_DELIMITER)
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_DENSITY_SELECTOR_DELIMITER = addNode(Renode.node("Delimiter.DensitySelector.Prop", "Delimiter - DensitySelector Prop"))
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addNodeOutput("Range", "Range", false, () -> HytaleGeneratorNodes.NODE_RANGE_DECIMAL)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_IMPORTED = addNode(VARIANT_PROPS.variantNode("Imported", "Imported.Prop", "Imported Prop"))
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(250))
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_LOCATOR = addNode(VARIANT_PROPS.variantNode("Locator", "Locator.Prop", "Locator Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("PlacementCap", "PlacementCap").withDefaultValue(1))
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_MANUAL = addNode(VARIANT_PROPS.variantNode("Manual", "Manual.Prop", "Manual Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Blocks", "Blocks", true, () -> HytaleGeneratorNodes.NODE_PROP_MANUAL_BLOCK)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_MANUAL_BLOCK = addNode(Renode.node("Block.Manual.Prop", "Block - Manual Prop"))
            .addNodeOutput("Material", "Material", false, NODE_MATERIAL)
            .addNodeOutput("Position", "Position", false, () -> HytaleGeneratorNodes.NODE_POINT_3D_INTEGER)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_MASK = addNode(VARIANT_PROPS.variantNode("Mask", "Mask.Prop", "Mask Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addNodeOutput("Mask", "Mask", false, NODE_BLOCK_MASK)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_OFFSET = addNode(VARIANT_PROPS.variantNode("Offset", "Offset.Prop", "Offset Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Offset", "Offset", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_ORIENTER = addNode(VARIANT_PROPS.variantNode("Orienter", "Orienter.Prop", "Orienter Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.enumContent("SelectionMode", "SelectionMode").withValues("FirstValid", "AllValid", "RandomValid").withDefaultValue("FirstValid").withWidth(200))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(250))
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addNodeOutput("Rotations", "Rotations", true, NODE_ORTHOGONAL_ROTATION)
            .addVariantOutput("Pattern", "Pattern", false, VARIANT_PATTERNS)
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_POND_FILLER = addNode(VARIANT_PROPS.variantNode("PondFiller", "PondFiller.Prop", "PondFiller Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Bounds", "Bounds", false, NODE_BOUNDS_INTEGER_3D)
            .addNodeOutput("BarrierBlockSet", "BarrierBlockSet", false, NODE_BLOCK_MASK_BLOCK_SET)
            .addVariantOutput("FillMaterial", "FillMaterial", false, VARIANT_MATERIAL_PROVIDERS)
            .addNodeOutput("BoundingMin", "[DEPRECATED] BoundingMin", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addNodeOutput("BoundingMax", "[DEPRECATED] BoundingMax", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addVariantOutput("Pattern", "[DEPRECATED] Pattern", false, VARIANT_PATTERNS)
            .addVariantOutput("Scanner", "[DEPRECATED] Scanner", false, VARIANT_SCANNERS)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_PREFAB = addNode(VARIANT_PROPS.variantNode("Prefab", "Prefab.Prop", "Prefab Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("LegacyPath", "[DEPRECATED] LegacyPath").withDefaultValue(false))
            .addContent(Renode.smallStringContent("MoldingDirection", "[DEPRECATED] MoldingDirection").withDefaultValue("NONE"))
            .addContent(Renode.checkboxContent("MoldingChildren", "[DEPRECATED] MoldingChildren").withDefaultValue(false))
            .addContent(Renode.checkboxContent("LoadEntities", "[DEPRECATED] LoadEntities").withDefaultValue(true))
            .addNodeOutput("WeightedPrefabPaths", "WeightedPrefabPaths", true, () -> HytaleGeneratorNodes.NODE_PROP_PREFAB_WEIGHTED_PATH)
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
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Props", "Props", true, VARIANT_PROPS)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_RANDOM_ROTATOR = addNode(VARIANT_PROPS.variantNode("RandomRotator", "RandomRotator.Prop", "RandomRotator Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("HorizontalRotations", "HorizontalRotations").withDefaultValue(false))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(250))
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addNodeOutput("Rotations", "Rotations", true, NODE_ORTHOGONAL_ROTATION)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_STATIC_ROTATOR = addNode(VARIANT_PROPS.variantNode("StaticRotator", "StaticRotator.Prop", "StaticRotator Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addNodeOutput("Rotation", "Rotation", false, NODE_ORTHOGONAL_ROTATION)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_UNION = addNode(VARIANT_PROPS.variantNode("Union", "Union.Prop", "Union Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Props", "Props", true, VARIANT_PROPS)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_WEIGHTED = addNode(VARIANT_PROPS.variantNode("Weighted", "Weighted.Prop", "Weighted Prop"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(250))
            .addNodeOutput("Entries", "Entries", true, () -> HytaleGeneratorNodes.NODE_PROP_WEIGHTED_ENTRY)
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_WEIGHTED_ENTRY = addNode(Renode.node("Entry.Weighted.Prop", "Entry - Weighted Prop"))
            .addContent(Renode.floatContent("Weight", "Weight").withDefaultValue(1.0))
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .withColorOverride("Orange")
            .addCategory(CATEGORY_PROPS);
    public static final NodeBuilder NODE_PROP_DISTRIBUTION_ASSIGNED = addNode(VARIANT_PROP_DISTRIBUTIONS.variantNode("Assigned", "Assigned.PropDistribution", "Assigned PropDistribution"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("OverrideAllProps", "OverrideAllProps").withDefaultValue(false))
            .addVariantOutput("PropDistribution", "PropDistribution", false, VARIANT_PROP_DISTRIBUTIONS)
            .addVariantOutput("Assignments", "Assignments", false, VARIANT_ASSIGNMENTS)
            .addCategory(CATEGORY_PROP_DISTRIBUTIONS);
    public static final NodeBuilder NODE_PROP_DISTRIBUTION_CONSTANT = addNode(VARIANT_PROP_DISTRIBUTIONS.variantNode("Constant", "Constant.PropDistribution", "Constant PropDistribution"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addVariantOutput("Prop", "Prop", false, VARIANT_PROPS)
            .addCategory(CATEGORY_PROP_DISTRIBUTIONS);
    public static final NodeBuilder NODE_PROP_DISTRIBUTION_IMPORTED = addNode(VARIANT_PROP_DISTRIBUTIONS.variantNode("Imported", "Imported.PropDistribution", "Imported PropDistribution"))
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(250))
            .addCategory(CATEGORY_PROP_DISTRIBUTIONS);
    public static final NodeBuilder NODE_PROP_DISTRIBUTION_POSITIONS = addNode(VARIANT_PROP_DISTRIBUTIONS.variantNode("Positions", "Positions.PropDistribution", "Positions PropDistribution"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Positions", "Positions", false, VARIANT_POSITIONS)
            .addCategory(CATEGORY_PROP_DISTRIBUTIONS);
    public static final NodeBuilder NODE_PROP_DISTRIBUTION_UNION = addNode(VARIANT_PROP_DISTRIBUTIONS.variantNode("Union", "Union.PropDistribution", "Union PropDistribution"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("PropDistributions", "PropDistributions", true, VARIANT_PROP_DISTRIBUTIONS)
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
            .addContent(Renode.smallStringContent("BaseHeightName", "BaseHeightName").withDefaultValue("Base").withWidth(250))
            .addContent(Renode.checkboxContent("TopDownOrder", "TopDownOrder").withDefaultValue(true))
            .addContent(Renode.integerContent("ResultCap", "ResultCap").withDefaultValue(1))
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_COLUMN_RANDOM = addNode(VARIANT_SCANNERS.variantNode("ColumnRandom", "ColumnRandom.Scanner", "[DEPRECATED] ColumnRandom Scanner"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.integerContent("MaxY", "MaxY").withDefaultValue(120))
            .addContent(Renode.integerContent("MinY", "MinY").withDefaultValue(60))
            .addContent(Renode.smallStringContent("Strategy", "Strategy").withDefaultValue("DART_THROW").withWidth(150))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("A").withWidth(250))
            .addContent(Renode.checkboxContent("RelativeToPosition", "RelativeToPosition").withDefaultValue(false))
            .addContent(Renode.smallStringContent("BaseHeightName", "BaseHeightName").withDefaultValue("Base").withWidth(250))
            .addContent(Renode.integerContent("ResultCap", "ResultCap").withDefaultValue(1))
            .withColorOverride("255,0,0")
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_IMPORTED = addNode(VARIANT_SCANNERS.variantNode("Imported", "Imported.Scanner", "Imported Scanner"))
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(250))
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_LINEAR = addNode(VARIANT_SCANNERS.variantNode("Linear", "Linear.Scanner", "Linear Scanner"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.enumContent("Axis", "Axis").withValues("X", "Y", "Z").withDefaultValue("Y"))
            .addContent(Renode.checkboxContent("AscendingOrder", "AscendingOrder").withDefaultValue(false))
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS)
            .addNodeOutput("Range", "Range", false, NODE_RANGE_INTEGER)
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_ORIGIN = addNode(VARIANT_SCANNERS.variantNode("Origin", "Origin.Scanner", "Origin Scanner"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_QUEUE = addNode(VARIANT_SCANNERS.variantNode("Queue", "Queue.Scanner", "Queue Scanner"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Scanners", "Scanners", true, VARIANT_SCANNERS)
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_RADIAL = addNode(VARIANT_SCANNERS.variantNode("Radial", "Radial.Scanner", "Radial Scanner"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS)
            .addNodeOutput("Bounds", "Bounds", false, NODE_BOUNDS_DECIMAL_3D)
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_SCANNER_RANDOM = addNode(VARIANT_SCANNERS.variantNode("Random", "Random.Scanner", "Random Scanner"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.enumContent("Axis", "Axis").withValues("X", "Y", "Z").withDefaultValue("Y"))
            .addContent(Renode.smallStringContent("Seed", "Seed").withDefaultValue("").withWidth(250))
            .addVariantOutput("Scanner", "Scanner", false, VARIANT_SCANNERS)
            .addNodeOutput("Range", "Range", false, NODE_RANGE_INTEGER)
            .addCategory(CATEGORY_SCANNERS);
    public static final NodeBuilder NODE_TINT_PROVIDER_CONSTANT = addNode(VARIANT_TINT_PROVIDERS.variantNode("Constant", "Constant.TintProvider", "Constant TintProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Color", "Color").withDefaultValue("#00FF00").withWidth(150))
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
    public static final NodeBuilder NODE_VECTOR_PROVIDER_CACHE = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Cache", "Cache.VectorProvider", "Cache VectorProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addVariantOutput("VectorProvider", "VectorProvider", false, VARIANT_VECTOR_PROVIDERS)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_CONSTANT = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Constant", "Constant.VectorProvider", "Constant VectorProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addNodeOutput("Value", "Value", false, () -> HytaleGeneratorNodes.NODE_POINT_3D)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_DENSITY_GRADIENT = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("DensityGradient", "DensityGradient.VectorProvider", "DensityGradient VectorProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.floatContent("SampleDistance", "SampleDistance").withDefaultValue(1.0).withWidth(50))
            .addVariantOutput("Density", "Density", false, VARIANT_DENSITY)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_EXPORTED = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Exported", "Exported.VectorProvider", "Exported VectorProvider"))
            .addContent(CONTENT_EXPORT_AS, CONTENT_SKIP)
            .addContent(Renode.checkboxContent("SingleInstance", "SingleInstance").withDefaultValue(false))
            .addVariantOutput("VectorProvider", "VectorProvider", false, VARIANT_VECTOR_PROVIDERS)
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_VECTOR_PROVIDER_IMPORTED = addNode(VARIANT_VECTOR_PROVIDERS.variantNode("Imported", "Imported.VectorProvider", "Imported VectorProvider"))
            .addContent(CONTENT_SKIP)
            .addContent(Renode.smallStringContent("Name", "Name").withDefaultValue("").withWidth(350))
            .addCategory(CATEGORY_VECTOR_PROVIDERS);
    public static final NodeBuilder NODE_POINT_3D = addNode(Renode.node("Point3D", "Decimal 3D Vector"))
            .addContent(Renode.floatContent("X", "X").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("Y", "Y").withDefaultValue(0.0).withWidth(100))
            .addContent(Renode.floatContent("Z", "Z").withDefaultValue(0.0).withWidth(100))
            .addCategory(CATEGORY_VECTORS);
    public static final NodeBuilder NODE_POINT_3D_INTEGER = addNode(Renode.node("Vector3i", "Integer 3D Vector"))
            .addContent(Renode.integerContent("X", "X").withDefaultValue(0).withWidth(100))
            .addContent(Renode.integerContent("Y", "Y").withDefaultValue(0).withWidth(100))
            .addContent(Renode.integerContent("Z", "Z").withDefaultValue(0).withWidth(100))
            .addCategory(CATEGORY_VECTORS);

    public static final AbstractNodeRoot ROOT_BIOME = addRoot(Renode.root(NODE_BIOME, "HytaleGenerator - Biome"));
    public static final AbstractNodeRoot ROOT_DENSITY = addRoot(Renode.root(VARIANT_DENSITY, "HytaleGenerator - Density"));
    public static final AbstractNodeRoot ROOT_BLOCK_MASK = addRoot(Renode.root(NODE_BLOCK_MASK, "HytaleGenerator - BlockMask"));
    public static final AbstractNodeRoot ROOT_ASSIGNMENTS = addRoot(Renode.root(VARIANT_ASSIGNMENTS, "HytaleGenerator - Assignments"));
    public static final AbstractNodeRoot ROOT_PROP = addRoot(Renode.root(VARIANT_PROPS, "HytaleGenerator - Prop"));
    public static final AbstractNodeRoot ROOT_PROP_DISTRIBUTION = addRoot(Renode.root(VARIANT_PROP_DISTRIBUTIONS, "HytaleGenerator - PropDistribution"));
    public static final AbstractNodeRoot ROOT_POSITIONS = addRoot(Renode.root(VARIANT_POSITIONS, "HytaleGenerator - Positions"));

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
