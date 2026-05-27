package io.github.itsverday.renode.vanilla;

import io.github.itsverday.renode.builder.NodeBuilder;
import io.github.itsverday.renode.builder.NodeCategory;
import io.github.itsverday.renode.builder.NodeVariantClass;
import io.github.itsverday.renode.builder.Renode;
import io.github.itsverday.renode.builder.root.AbstractNodeRoot;

import java.util.ArrayList;
import java.util.List;

public class ScriptableBrushNodes {
    private static final List<NodeBuilder> nodes = new ArrayList<>();
    private static final List<NodeVariantClass> variants = new ArrayList<>();
    private static final List<NodeCategory> categories = new ArrayList<>();
    private static final List<AbstractNodeRoot> roots = new ArrayList<>();

    public static final NodeCategory CATEGORY_GENERAL = addCategory(Renode.category("General", "grey"));
    public static final NodeCategory CATEGORY_BASIC_OPERATIONS = addCategory(Renode.category("Basic Operations", "blue"));
    public static final NodeCategory CATEGORY_MASKS = addCategory(Renode.category("Masks", "green"));
    public static final NodeCategory CATEGORY_FLOW_CONTROL = addCategory(Renode.category("Flow Control", "purple"));
    public static final NodeCategory CATEGORY_SAVE_LOAD = addCategory(Renode.category("Save/Load", "aqua"));
    public static final NodeCategory CATEGORY_OTHER = addCategory(Renode.category("Other", "red"));

    public static final NodeVariantClass VARIANT_OPERATIONS = addVariant(Renode.variant("OperationVariants", "blue"));

    public static final NodeBuilder NODE_APPEND_MASK = addNode(VARIANT_OPERATIONS.variantNode("appendmask", "AppendMask", "Append Mask"))
            .addContent(Renode.smallStringContent("AppendMask", "Append Mask").withWidth(200))
            .withColorOverride("green")
            .addCategory(CATEGORY_MASKS)
            .addSchemaString("Id", "appendmask");
    public static final NodeBuilder NODE_APPEND_MASK_FROM_TOOL_ARG = addNode(VARIANT_OPERATIONS.variantNode("appendmaskfromtoolarg", "AppendMaskFromToolArg", "Append Mask From Tool Arg"))
            .addContent(Renode.smallStringContent("ArgName", "Arg Name").withWidth(150))
            .addContent(Renode.enumContent("FilterType", "Filter Type").withValues("TargetBlock", "AboveBlock", "BelowBlock", "AdjacentBlock", "NeighborBlock", "NorthBlock", "EastBlock", "SouthBlock", "WestBlock", "DiagonalXy", "DiagonalXz", "DiagonalZy", "Selection").withDefaultValue("TargetBlock").withWidth(150))
            .addContent(Renode.checkboxContent("Invert", "Invert"))
            .addContent(Renode.smallStringContent("AdditionalBlocks", "Additional Blocks").withWidth(200))
            .withColorOverride("green")
            .addCategory(CATEGORY_MASKS)
            .addSchemaString("Id", "appendmaskfromtoolarg");
    public static final NodeBuilder NODE_BLOCK_PATTERN = addNode(VARIANT_OPERATIONS.variantNode("pattern", "BlockPattern", "Block Pattern"))
            .addContent(Renode.smallStringContent("BlockPattern", "Block Pattern").withWidth(300))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "pattern");
    public static final NodeBuilder NODE_BREAKPOINT = addNode(VARIANT_OPERATIONS.variantNode("breakpoint", "Breakpoint", "Breakpoint"))
            .addContent(Renode.smallStringContent("Label", "Label").withWidth(150))
            .addContent(Renode.checkboxContent("PrintMessage", "Print Message"))
            .addContent(Renode.checkboxContent("PrintState", "Print State"))
            .addContent(Renode.checkboxContent("EnterStepMode", "Enter Step Mode"))
            .addNodeOutput("Condition$Pin", "Condition", false, () -> ScriptableBrushNodes.NODE_BRUSH_CONFIG_INTEGER_COMPARISON)
            .withColorOverride("red")
            .addCategory(CATEGORY_OTHER)
            .addSchemaString("Id", "breakpoint");
    public static final NodeBuilder NODE_BRUSH_CONFIG_INTEGER_COMPARISON = addNode(Renode.node("BrushConfigIntegerComparison", "Integer Comparison"))
            .addContent(Renode.enumContent("DataGettingFlag", "Data Source").withValues("OffsetX", "OffsetY", "OffsetZ", "Height", "Width", "Density").withWidth(120))
            .addContent(Renode.enumContent("IntegerComparisonOperator", "Operator").withValues("GreaterThan", "GreaterThanEqualTo", "LessThan", "LessThanEqualTo", "ModEqualZero", "ModNotEqualZero", "EqualTo", "NotEqualTo").withWidth(180))
            .addContent(Renode.integerContent("ValueToCompareTo", "Compare Value").withDefaultValue(0))
            .withColorOverride("purple")
            .addCategory(CATEGORY_GENERAL);
    public static final NodeBuilder NODE_CLEAR_OPERATION_MASK = addNode(VARIANT_OPERATIONS.variantNode("clearoperationmask", "ClearOperationMask", "Clear Operation Mask"))
            .withColorOverride("green")
            .addCategory(CATEGORY_MASKS)
            .addSchemaString("Id", "clearoperationmask");
    public static final NodeBuilder NODE_CLEAR_ROTATION = addNode(VARIANT_OPERATIONS.variantNode("clearrotation", "ClearRotation", "Clear Rotation"))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "clearrotation");
    public static final NodeBuilder NODE_DEBUG_BRUSH = addNode(VARIANT_OPERATIONS.variantNode("debug", "DebugBrush", "Debug"))
            .addContent(Renode.checkboxContent("PrintOperations", "Print Operations"))
            .addContent(Renode.checkboxContent("StepThrough", "Step Through"))
            .addContent(Renode.checkboxContent("EnableBreakpoints", "Enable Breakpoints"))
            .addContent(Renode.enumContent("OutputTarget", "Output Target").withValues("Chat", "Console", "Both").withWidth(120))
            .addContent(Renode.checkboxContent("BreakOnError", "Break On Error"))
            .withColorOverride("red")
            .addCategory(CATEGORY_OTHER)
            .addSchemaString("Id", "debug");
    public static final NodeBuilder NODE_DELETE = addNode(VARIANT_OPERATIONS.variantNode("delete", "Delete", "Delete Blocks"))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "delete");
    public static final NodeBuilder NODE_DIMENSIONS = addNode(VARIANT_OPERATIONS.variantNode("dimensions", "Dimensions", "Modify Dimensions"))
            .addContent(Renode.objectContent("Width", "Width").withFields(Renode.integerContent("Value", "Value").withDefaultValue(20), Renode.checkboxContent("Relative", "Relative")))
            .addContent(Renode.objectContent("Height", "Height").withFields(Renode.integerContent("Value", "Value").withDefaultValue(20), Renode.checkboxContent("Relative", "Relative")))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "dimensions");
    public static final NodeBuilder NODE_DISABLE_HOLDER_INTERACTION = addNode(VARIANT_OPERATIONS.variantNode("disableonhold", "DisableHoldInteraction", "Disable Activate-On-Hold"))
            .withColorOverride("red")
            .addCategory(CATEGORY_OTHER)
            .addSchemaString("Id", "disableonhold");
    public static final NodeBuilder NODE_ECHO = addNode(VARIANT_OPERATIONS.variantNode("echo", "Echo", "Echo to Chat"))
            .addContent(Renode.stringContent("Message", "Message").withWidth(350).withHeight(100))
            .withColorOverride("orange")
            .addCategory(CATEGORY_OTHER)
            .addSchemaString("Id", "echo");
    public static final NodeBuilder NODE_ECHO_ONCE = addNode(VARIANT_OPERATIONS.variantNode("echoonce", "EchoOnce", "Echo Once to Chat"))
            .addContent(Renode.stringContent("Message", "Message").withWidth(350).withHeight(100))
            .withColorOverride("purple")
            .addCategory(CATEGORY_OTHER)
            .addSchemaString("Id", "echoonce");
    public static final NodeBuilder NODE_ERODE = addNode(VARIANT_OPERATIONS.variantNode("erode", "Erode", "Erode"))
            .addContent(Renode.enumContent("ErodePreset", "Erode Preset").withValues("Default", "Melt", "Fill", "Smooth", "Lift", "FloatClean").withWidth(120))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "erode");
    public static final NodeBuilder NODE_EXIT = addNode(VARIANT_OPERATIONS.variantNode("exit", "Exit", "Exit"))
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "exit");
    public static final NodeBuilder NODE_FLUID_ACTION = addNode(VARIANT_OPERATIONS.variantNode("fluidfix", "FluidAction", "Fluid"))
            .addContent(Renode.enumContent("FluidAction", "Action").withValues("Fill", "Clear").withWidth(120))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "fluidfix");
    public static final NodeBuilder NODE_HEIGHT_MAP_LAYER = addNode(VARIANT_OPERATIONS.variantNode("heightmaplayer", "HeightmapLayer", "Heightmap Layer"))
            .addNodeOutput("Layers$Pin", "Layers", true, () -> ScriptableBrushNodes.NODE_LAYER_ENTRY)
            .addCategory(CATEGORY_OTHER)
            .addSchemaString("Id", "heightmaplayer");
    public static final NodeBuilder NODE_HISTORY_MASK = addNode(VARIANT_OPERATIONS.variantNode("historymask", "HistoryMask", "History Mask"))
            .addContent(Renode.enumContent("HistoryMask", "History Mask").withValues("None", "Only", "Not").withWidth(100))
            .withColorOverride("green")
            .addCategory(CATEGORY_MASKS)
            .addSchemaString("Id", "historymask");
    public static final NodeBuilder NODE_IGNORE_EXISTING_BRUSH_DATA = addNode(VARIANT_OPERATIONS.variantNode("ignorebrushsettings", "IgnoreExistingBrushData", "Ignore Existing Brush Settings"))
            .withColorOverride("red")
            .addCategory(CATEGORY_OTHER)
            .addSchemaString("Id", "ignoreexistingbrushdata");
    public static final NodeBuilder NODE_INTEGER_STRING_PAIR = addNode(Renode.node("IntegerStringPair", "Weighted Index Entry"))
            .addContent(Renode.integerContent("Left", "Weight"))
            .addContent(Renode.smallStringContent("Right", "Index Name").withWidth(150))
            .addCategory(CATEGORY_GENERAL);
    public static final NodeBuilder NODE_JUMP_IF_BLOCK_TYPE = addNode(VARIANT_OPERATIONS.variantNode("jumpifblocktype", "JumpIfBlockType", "Jump If Block Type Comparison"))
            .addContent(Renode.smallStringContent("Mask", "Mask").withWidth(200))
            .addContent(Renode.smallStringContent("StoredIndexName", "Stored Index Name").withWidth(150))
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "jumpifblocktype");
    public static final NodeBuilder NODE_JUMP_IF_CLICK_TYPE = addNode(VARIANT_OPERATIONS.variantNode("jumpifclicktype", "JumpIfClickType", "Jump If Click Type"))
            .addContent(Renode.smallStringContent("StoredIndexName", "Stored Index Name").withWidth(150))
            .addContent(Renode.enumContent("ClickType", "Click Type").withValues("Left", "Right").withWidth(100))
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "jumpifclicktype");
    public static final NodeBuilder NODE_JUMP_IF_COMPARE = addNode(VARIANT_OPERATIONS.variantNode("jumpifcompare", "JumpIfCompare", "Jump If Int Comparison"))
            .addContent(Renode.smallStringContent("StoredIndexName", "Stored Index Name").withWidth(150))
            .addNodeOutput("Comparisons$Pin", "ComparisonPin", true, NODE_BRUSH_CONFIG_INTEGER_COMPARISON)
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "jumpifcompare");
    public static final NodeBuilder NODE_JUMP_IF_STRING_MATCH = addNode(VARIANT_OPERATIONS.variantNode("jumpifequal", "JumpIfStringMatch", "Jump If String Matches"))
            .addContent(Renode.smallStringContent("StoredIndexName", "Stored Index Name").withWidth(150))
            .addContent(Renode.smallStringContent("LeftSideOfStatement", "Left Side Of Statement").withWidth(150))
            .addContent(Renode.smallStringContent("RightSideOfStatement", "Right Side Of Statement").withWidth(150))
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "jumpifequal");
    public static final NodeBuilder NODE_JUMP_IF_TOOL_ARG = addNode(VARIANT_OPERATIONS.variantNode("jumpiftoolarg", "JumpIfToolArg", "Jump If Tool Arg"))
            .addContent(Renode.smallStringContent("ArgName", "Arg Name").withWidth(150))
            .addContent(Renode.enumContent("ComparisonType", "Comparison Type").withValues("Equals", "NotEquals", "Contains").withWidth(120))
            .addContent(Renode.smallStringContent("ComparisonValue", "Comparison Value").withWidth(150))
            .addContent(Renode.smallStringContent("StoredIndexName", "Stored Index Name").withWidth(150))
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "jumpiftoolarg");
    public static final NodeBuilder NODE_JUMP_TO_INDEX = addNode(VARIANT_OPERATIONS.variantNode("jump", "JumpToIndex", "Jump to Index"))
            .addContent(Renode.smallStringContent("StoredIndexName", "Stored Index Name").withWidth(150))
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "jump");
    public static final NodeBuilder NODE_JUMP_TO_RANDOM_INDEX = addNode(VARIANT_OPERATIONS.variantNode("jumprandom", "JumpToRandomIndex", "Jump to Random Stored Index"))
            .addNodeOutput("WeightedListOfIndexNames$Pin", "WeightedIndexPin", true, NODE_INTEGER_STRING_PAIR)
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "jumprandom");
    public static final NodeBuilder NODE_KERNEL_SMOOTH = addNode(VARIANT_OPERATIONS.variantNode("kernelsmooth", "KernelSmooth", "Kernel Smooth"))
            .addContent(Renode.enumContent("Kernel", "Kernel").withValues("Normal", "Uniform", "Gaussian", "Neighbor", "Square").withWidth(120))
            .addContent(Renode.enumContent("Mode", "Mode").withValues("Full", "Heightmap", "Flat").withWidth(120))
            .addContent(Renode.integerContent("ErosionStrength", "Erosion Strength"))
            .addContent(Renode.checkboxContent("SampleNearby", "Sample Nearby"))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "kernelsmooth");
    public static final NodeBuilder NODE_LAYER = addNode(VARIANT_OPERATIONS.variantNode("layer", "Layer", "Layer"))
            .addNodeOutput("Layers$Pin", "Layers", true, () -> ScriptableBrushNodes.NODE_LAYER_ENTRY)
            .addCategory(CATEGORY_OTHER)
            .addSchemaString("Id", "layer");
    public static final NodeBuilder NODE_LAYER_ENTRY = addNode(Renode.node("LayerEntry", "Layer Entry"))
            .addContent(Renode.integerContent("Left", "Depth").withDefaultValue(1))
            .addContent(Renode.smallStringContent("Right", "Block Type / Arg").withWidth(150))
            .addContent(Renode.checkboxContent("UseToolArg", "From Tool Arg"))
            .addContent(Renode.checkboxContent("Skip", "Skip"))
            .withColorOverride("aqua")
            .addCategory(CATEGORY_GENERAL);
    public static final NodeBuilder NODE_LIFT = addNode(VARIANT_OPERATIONS.variantNode("lift", "Lift", "Lift Blocks"))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "lift");
    public static final NodeBuilder NODE_LOAD_BRUSH_CONFIG = addNode(VARIANT_OPERATIONS.variantNode("loadbrushconfig", "LoadBrushConfig", "Load Brush Config Snapshot"))
            .addContent(Renode.smallStringContent("StoredName", "Stored Name").withWidth(150))
            .addContent(Renode.listContent("ParametersToLoad", "Parameters To Load", "DataSettingFlags"))
            .withColorOverride("aqua")
            .addCategory(CATEGORY_SAVE_LOAD)
            .addSchemaString("Id", "loadbrushconfig");
    public static final NodeBuilder NODE_LOAD_BRUSH_CONFIG_FROM_TOOL_ARGS = addNode(Renode.node("LoadBrushConfigFromToolArgs", "Load Brush Config From Tool Args"))
            .addContent(Renode.smallStringContent("ToolArgId", "Tool Arg ID").withWidth(150))
            .addContent(Renode.checkboxContent("LoadAsSnapshotName", "Load As Snapshot Name"))
            .addContent(Renode.listContent("ParametersToLoad", "Parameters To Load", "DataSettingFlags"))
            .withColorOverride("aqua")
            .addSchemaString("Id", "loadbrushconfigfromtoolargs");
    public static final NodeBuilder NODE_LOAD_INT_FROM_TOOL_ARG = addNode(VARIANT_OPERATIONS.variantNode("loadint", "LoadIntFromToolArg", "Load Int From Tool Arg"))
            .addContent(Renode.smallStringContent("ArgName", "Arg Name").withWidth(150))
            .addContent(Renode.enumContent("TargetField", "Target Field").withValues("Width", "Height", "Density", "Thickness", "OffsetX", "OffsetY", "OffsetZ").withWidth(120))
            .addContent(Renode.checkboxContent("Relative", "Relative"))
            .addContent(Renode.checkboxContent("Negate", "Negate"))
            .addCategory(CATEGORY_SAVE_LOAD)
            .addSchemaString("Id", "loadint");
    public static final NodeBuilder NODE_LOAD_LOOP_FROM_TOOL_ARG = addNode(VARIANT_OPERATIONS.variantNode("loadloop", "LoadLoopFromToolArg", "Load Loop From Tool Arg"))
            .addContent(Renode.smallStringContent("StoredIndexName", "Stored Index Name").withWidth(150))
            .addContent(Renode.smallStringContent("ArgName", "Arg Name").withWidth(150))
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "loadloop");
    public static final NodeBuilder NODE_LOAD_MATERIAL = addNode(VARIANT_OPERATIONS.variantNode("loadmaterial", "LoadMaterial", "Load Material from Arg"))
            .addContent(Renode.smallStringContent("ArgName", "ArgName").withWidth(200))
            .withColorOverride("purple")
            .addCategory(CATEGORY_SAVE_LOAD)
            .addSchemaString("Id", "loadmaterial");
    public static final NodeBuilder NODE_LOAD_OPERATIONS_FROM_ASSET = addNode(VARIANT_OPERATIONS.variantNode("loadoperationsfromasset", "LoadOperationsFromAsset", "Load Operations From Asset"))
            .addContent(Renode.smallStringContent("AssetId", "Asset Id").withWidth(200))
            .withColorOverride("purple")
            .addCategory(CATEGORY_SAVE_LOAD)
            .addSchemaString("Id", "loadoperationsfromasset");
    public static final NodeBuilder NODE_LOOP = addNode(VARIANT_OPERATIONS.variantNode("loop", "Loop", "Loop Operations"))
            .addContent(Renode.smallStringContent("StoredIndexName", "Stored Index Name").withWidth(150))
            .addContent(Renode.integerContent("AdditionalRepetitions", "Additional Repetitions"))
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "loop");
    public static final NodeBuilder NODE_LOOP_CIRCLE = addNode(VARIANT_OPERATIONS.variantNode("loopcircle", "LoopCircle", "Loop Previous And Set Offset In Circle"))
            .addContent(Renode.smallStringContent("StoredIndexName", "Stored Index Name").withWidth(150))
            .addContent(Renode.integerContent("NumberOfCirclePoints", "Number Of Circle Points"))
            .addContent(Renode.integerContent("CircleRadius", "Circle Radius"))
            .addContent(Renode.checkboxContent("FlipDirection", "Flip Direction"))
            .addContent(Renode.checkboxContent("RotateDirection", "Rotate Direction"))
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "loopcircle");
    public static final NodeBuilder NODE_LOOP_CIRCLE_FROM_ARG = addNode(VARIANT_OPERATIONS.variantNode("loopcirclefromarg", "LoopCircleFromArg", "Loop Previous And Set Offset In Circle From Arg"))
            .addContent(Renode.smallStringContent("StoredIndexName", "Stored Index Name").withWidth(150))
            .addContent(Renode.smallStringContent("NumberCirclePointsArg", "Number of Circle Points Arg").withWidth(150))
            .addContent(Renode.smallStringContent("CircleRadiusArg", "Circle Radius Arg").withWidth(150))
            .addContent(Renode.checkboxContent("FlipDirection", "Flip Direction"))
            .addContent(Renode.checkboxContent("RotateDirection", "Rotate Direction"))
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "loopcirclefromarg");
    public static final NodeBuilder NODE_LOOP_RANDOM = addNode(VARIANT_OPERATIONS.variantNode("looprandom", "LoopRandom", "Loop Operations Random Amount"))
            .addContent(Renode.smallStringContent("StoredIndexName", "Stored Index Name").withWidth(150))
            .addContent(Renode.objectContent("RangeOfAdditionalRepetitions", "Range Of Additional Repetitions").withFields(Renode.integerContent("Left", "Min").withDefaultValue(1), Renode.integerContent("Right", "Max").withDefaultValue(5)))
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "looprandom");
    public static final NodeBuilder NODE_MASK = addNode(VARIANT_OPERATIONS.variantNode("mask", "Mask", "Set Operation Mask"))
            .addContent(Renode.smallStringContent("Mask", "Mask").withWidth(300))
            .withColorOverride("green")
            .addCategory(CATEGORY_MASKS)
            .addSchemaString("Id", "mask");
    public static final NodeBuilder NODE_MATERIAL = addNode(VARIANT_OPERATIONS.variantNode("material", "Material", "Material"))
            .addContent(Renode.smallStringContent("BlockType", "Block Type").withWidth(150))
            .addCategory(CATEGORY_OTHER)
            .addSchemaString("Id", "material");
    public static final NodeBuilder NODE_MELT = addNode(VARIANT_OPERATIONS.variantNode("melt", "Melt", "Melt"))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "melt");
    public static final NodeBuilder NODE_OFFSET = addNode(VARIANT_OPERATIONS.variantNode("offset", "Offset", "Modify Offset"))
            .addContent(Renode.objectContent("Offset", "Offset").withFields(Renode.objectContent("X", "X").withFields(Renode.integerContent("Value", "Value").withDefaultValue(0), Renode.checkboxContent("Relative", "Relative")), Renode.objectContent("Y", "Y").withFields(Renode.integerContent("Value", "Value").withDefaultValue(0), Renode.checkboxContent("Relative", "Relative")), Renode.objectContent("Z", "Z").withFields(Renode.integerContent("Value", "Value").withDefaultValue(0), Renode.checkboxContent("Relative", "Relative"))))
            .addContent(Renode.enumContent("TargetField", "Relative To Field").withValues("None", "Width", "Height", "Density", "Thickness", "OffsetX", "OffsetY", "OffsetZ").withDefaultValue("None").withWidth(120))
            .addContent(Renode.checkboxContent("Negate", "Negate"))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "offset");
    public static final NodeBuilder NODE_PASTE_PREFAB = addNode(VARIANT_OPERATIONS.variantNode("pasteprefab", "PastePrefab", "Paste Prefab"))
            .addContent(Renode.smallStringContent("PrefabListAssetName", "Prefab List Asset Name").withWidth(250))
            .addCategory(CATEGORY_OTHER)
            .addSchemaString("Id", "pasteprefab");
    public static final NodeBuilder NODE_PERSISTENT_DATA = addNode(VARIANT_OPERATIONS.variantNode("persistentdata", "PersistentData", "Persistent Data"))
            .addContent(Renode.smallStringContent("StoredName", "Stored Name").withWidth(150))
            .addContent(Renode.enumContent("Operation", "Operation").withValues("ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "MODULUS", "SET").withWidth(120))
            .addContent(Renode.integerContent("Modifier", "Modifier"))
            .withColorOverride("aqua")
            .addCategory(CATEGORY_SAVE_LOAD)
            .addSchemaString("Id", "persistentdata");
    public static final NodeBuilder NODE_RANDOMIZE_DIMENSIONS = addNode(VARIANT_OPERATIONS.variantNode("randomdimensions", "RandomizeDimensions", "Randomize Dimensions"))
            .addContent(Renode.objectContent("WidthRange", "Width Range").withFields(Renode.objectContent("Min", "Min").withFields(Renode.integerContent("Value", "Value").withDefaultValue(1), Renode.checkboxContent("Relative", "Relative")), Renode.objectContent("Max", "Max").withFields(Renode.integerContent("Value", "Value").withDefaultValue(5), Renode.checkboxContent("Relative", "Relative"))))
            .addContent(Renode.objectContent("HeightRange", "Height Range").withFields(Renode.objectContent("Min", "Min").withFields(Renode.integerContent("Value", "Value").withDefaultValue(1), Renode.checkboxContent("Relative", "Relative")), Renode.objectContent("Max", "Max").withFields(Renode.integerContent("Value", "Value").withDefaultValue(5), Renode.checkboxContent("Relative", "Relative"))))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "randomdimensions");
    public static final NodeBuilder NODE_RANDOMIZE_OFFSET = addNode(VARIANT_OPERATIONS.variantNode("randomoffset", "RandomOffset", "Randomize Offset"))
            .addContent(Renode.objectContent("XOffsetRange", "X Offset Range").withFields(Renode.objectContent("Min", "Min").withFields(Renode.integerContent("Value", "Value").withDefaultValue(0), Renode.checkboxContent("Relative", "Relative")), Renode.objectContent("Max", "Max").withFields(Renode.integerContent("Value", "Value").withDefaultValue(0), Renode.checkboxContent("Relative", "Relative"))))
            .addContent(Renode.objectContent("YOffsetRange", "Y Offset Range").withFields(Renode.objectContent("Min", "Min").withFields(Renode.integerContent("Value", "Value").withDefaultValue(0), Renode.checkboxContent("Relative", "Relative")), Renode.objectContent("Max", "Max").withFields(Renode.integerContent("Value", "Value").withDefaultValue(0), Renode.checkboxContent("Relative", "Relative"))))
            .addContent(Renode.objectContent("ZOffsetRange", "Z Offset Range").withFields(Renode.objectContent("Min", "Min").withFields(Renode.integerContent("Value", "Value").withDefaultValue(0), Renode.checkboxContent("Relative", "Relative")), Renode.objectContent("Max", "Max").withFields(Renode.integerContent("Value", "Value").withDefaultValue(0), Renode.checkboxContent("Relative", "Relative"))))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "randomoffset");
    public static final NodeBuilder NODE_REPLACE = addNode(VARIANT_OPERATIONS.variantNode("replace", "Replace", "Replace Blocks"))
            .addContent(Renode.smallStringContent("FromBlockType", "From Block Type").withWidth(150))
            .addContent(Renode.smallStringContent("ToBlockPattern", "To Block Pattern").withWidth(150))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "replace");
    public static final NodeBuilder NODE_ROOT = addNode(Renode.node("Root", "Root"))
            .addVariantOutput("Operations$Pin", "Operations", true, VARIANT_OPERATIONS)
            .addCategory(CATEGORY_GENERAL);
    public static final NodeBuilder NODE_ROTATION = addNode(VARIANT_OPERATIONS.variantNode("rotation", "Rotation", "Rotation"))
            .addContent(Renode.enumContent("RotationAxis", "Rotation Axis").withValues("X", "Y", "Z").withDefaultValue("Y").withWidth(150))
            .addContent(Renode.enumContent("RotationAngle", "Rotation Angle").withValues("None", "Ninety", "OneEighty", "TwoSeventy").withDefaultValue("None").withWidth(150))
            .addContent(Renode.enumContent("RotationOrigin", "Origin of Rotation").withValues("OffsetCenter", "ClickCenter", "Player").withDefaultValue("ClickCenter").withWidth(150))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "rotation");
    public static final NodeBuilder NODE_RUN_COMMAND = addNode(VARIANT_OPERATIONS.variantNode("runcommand", "RunCommand", "Run Command"))
            .addContent(Renode.stringContent("CommandToRun", "Command To Run").withWidth(350).withHeight(60))
            .withColorOverride("orange")
            .addCategory(CATEGORY_OTHER)
            .addSchemaString("Id", "runcommand");
    public static final NodeBuilder NODE_SAVE_BRUSH_CONFIG = addNode(VARIANT_OPERATIONS.variantNode("savebrushconfig", "SaveBrushConfig", "Save Brush Config Snapshot"))
            .addContent(Renode.smallStringContent("StoredName", "Stored Name").withWidth(150))
            .withColorOverride("aqua")
            .addCategory(CATEGORY_SAVE_LOAD)
            .addSchemaString("Id", "savebrushconfig");
    public static final NodeBuilder NODE_SAVE_INDEX = addNode(VARIANT_OPERATIONS.variantNode("saveindex", "SaveIndex", "Store Current Operation Index"))
            .addContent(Renode.smallStringContent("StoredIndexName", "Stored Index Name").withWidth(150))
            .withColorOverride("purple")
            .addCategory(CATEGORY_FLOW_CONTROL)
            .addSchemaString("Id", "saveindex");
    public static final NodeBuilder NODE_SET = addNode(VARIANT_OPERATIONS.variantNode("set", "Set", "Set Blocks"))
            .withColorOverride("green")
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "set");
    public static final NodeBuilder NODE_SET_DENSITY = addNode(VARIANT_OPERATIONS.variantNode("density", "SetDensity", "Density"))
            .addContent(Renode.integerContent("Density", "Density"))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "density");
    public static final NodeBuilder NODE_SHAPE = addNode(VARIANT_OPERATIONS.variantNode("shape", "Shape", "Shape"))
            .addContent(Renode.enumContent("Shape", "Shape").withValues("Cube", "Sphere", "Cylinder", "Cone", "InvertedCone", "Pyramid", "InvertedPyramid").withWidth(150))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "shape");
    public static final NodeBuilder NODE_SMOOTH = addNode(VARIANT_OPERATIONS.variantNode("smooth", "Smooth", "Smooth Blocks"))
            .addContent(Renode.integerContent("SmoothStrength", "Smooth Strength"))
            .addCategory(CATEGORY_BASIC_OPERATIONS)
            .addSchemaString("Id", "smooth");
    public static final NodeBuilder NODE_USE_BRUSH_MASK = addNode(VARIANT_OPERATIONS.variantNode("usebrushmask", "UseBrushMask", "Use Brush Mask"))
            .addContent(Renode.checkboxContent("UseBrushMask", "Use Brush Mask"))
            .withColorOverride("green")
            .addCategory(CATEGORY_MASKS)
            .addSchemaString("Id", "usebrushmask");
    public static final NodeBuilder NODE_USE_OPERATION_MASK = addNode(VARIANT_OPERATIONS.variantNode("useoperationmask", "UseOperationMask", "Use Operation Mask"))
            .addContent(Renode.checkboxContent("UseOperationMask", "Use Operation Mask"))
            .withColorOverride("green")
            .addCategory(CATEGORY_MASKS)
            .addSchemaString("Id", "useoperationmask");

    public static final AbstractNodeRoot ROOT_SCRIPTABLE_BRUSH = addRoot(Renode.root(NODE_ROOT, "Scriptable Brush"));

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
