package com.blackgear.geologicexpansion.data.resources;

import com.blackgear.geologicexpansion.common.registries.GEBlocks;
import com.google.common.collect.Maps;
import net.minecraft.core.Registry;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.stream.Stream;

public class GEBlockFamilies {
    private static final Map<Block, BlockFamily> FAMILIES = Maps.newHashMap();
    private static final Map<Block, BlockFamily> STONE = Maps.newHashMap();

    public static final BlockFamily LIMESTONE = stone(GEBlocks.LIMESTONE.get())
            .slab(GEBlocks.LIMESTONE_SLAB.get())
            .wall(GEBlocks.LIMESTONE_WALL.get())
            .stairs(GEBlocks.LIMESTONE_STAIRS.get())
            .polished(GEBlocks.POLISHED_LIMESTONE.get())
            .getFamily();

    public static final BlockFamily POLISHED_LIMESTONE = stone(GEBlocks.POLISHED_LIMESTONE.get())
            .slab(GEBlocks.POLISHED_LIMESTONE_SLAB.get())
            .wall(GEBlocks.POLISHED_LIMESTONE_WALL.get())
            .stairs(GEBlocks.POLISHED_LIMESTONE_STAIRS.get())
            .getFamily();

    public static BlockFamily.Builder stone(Block baseBlock) {
        BlockFamily.Builder builder = create(baseBlock);
        BlockFamily family = STONE.put(baseBlock, builder.getFamily());
        if (family != null) {
            throw new IllegalStateException("Duplicate stone type definition for " + Registry.BLOCK.getKey(baseBlock));
        } else {
            return builder;
        }
    }

    public static BlockFamily.Builder create(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily family = FAMILIES.put(baseBlock, builder.getFamily());
        if (family != null) {
            throw new IllegalStateException("Duplicate family definition for " + Registry.BLOCK.getKey(baseBlock));
        } else {
            return builder;
        }
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return FAMILIES.values().stream();
    }

    public static Stream<BlockFamily> getStoneFamilies() {
        return STONE.values().stream();
    }
}