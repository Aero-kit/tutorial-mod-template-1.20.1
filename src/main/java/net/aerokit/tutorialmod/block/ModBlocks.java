package net.aerokit.tutorialmod.block;

import net.aerokit.tutorialmod.TutorialMod;
import net.aerokit.tutorialmod.block.custom.SoundBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final  Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_CLUSTER)));


    public static final Block CITRINE_BLOCK = registerBlock("citrine_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final  Block RAW_CITRINE_BLOCK = registerBlock("raw_citrine_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_CLUSTER)));


    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2, 5)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f), UniformIntProvider.create(2, 5)));
    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
        new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(1.5f), UniformIntProvider.create(2, 5)));
    public static final Block END_STONE_RUBY_ORE = registerBlock("end_stone_ruby_ore",
        new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).strength(3f), UniformIntProvider.create(2, 5)));

    public static final Block CITRINE_ORE = registerBlock("citrine_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2, 5)));
    public static final Block DEEPSLATE_CITRINE_ORE = registerBlock("deepslate_citrine_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f), UniformIntProvider.create(2, 5)));
    public static final Block NETHER_CITRINE_ORE = registerBlock("nether_citrine_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(1.5f), UniformIntProvider.create(2, 5)));
    public static final Block END_STONE_CITRINE_ORE = registerBlock("end_stone_citrine_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).strength(3f), UniformIntProvider.create(2, 5)));

    public static final  Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));

    public static final  Block RUBY_STAIRS = registerBlock("ruby_stairs",
            new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final  Block RUBY_SLAB = registerBlock("ruby_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));

    public static final  Block RUBY_BUTTON = registerBlock("ruby_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK), BlockSetType.IRON, 10, true));
    public static final  Block RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK),
                    BlockSetType.IRON));

    public static final  Block RUBY_FENCE = registerBlock("ruby_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));
    public static final  Block RUBY_FENCE_GATE = registerBlock("ruby_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK), WoodType.ACACIA));
    public static final  Block RUBY_WALL = registerBlock("ruby_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));

    public static final  Block RUBY_DOOR = registerBlock("ruby_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR), BlockSetType.IRON));
    public static final  Block RUBY_TRAPDOOR = registerBlock("ruby_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).nonOpaque(), BlockSetType.IRON));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);

    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering ModBlocks for " + TutorialMod.MOD_ID);

    }
}