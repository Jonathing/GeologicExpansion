package com.blackgear.geologicexpansion.core;

import com.blackgear.geologicexpansion.client.ClientSetup;
import com.blackgear.geologicexpansion.client.registries.GEParticleTypes;
import com.blackgear.geologicexpansion.common.CommonSetup;
import com.blackgear.geologicexpansion.common.registries.GEBlockEntities;
import com.blackgear.geologicexpansion.common.registries.GEBlocks;
import com.blackgear.geologicexpansion.common.registries.GEEntities;
import com.blackgear.geologicexpansion.common.registries.GEItems;
import com.blackgear.geologicexpansion.common.registries.GEPointOfInterests;
import com.blackgear.geologicexpansion.common.registries.GESounds;
import com.blackgear.geologicexpansion.common.registries.entities.GEProfessions;
import com.blackgear.geologicexpansion.common.registries.worldgen.GEBiomes;
import com.blackgear.geologicexpansion.common.registries.worldgen.GEFeatures;
import com.blackgear.geologicexpansion.common.registries.worldgen.GEFoliagePlacer;
import com.blackgear.geologicexpansion.common.registries.worldgen.GENoises;
import com.blackgear.geologicexpansion.common.registries.worldgen.GETrunkPlacers;
import com.blackgear.geologicexpansion.common.worldgen.surface.rulesources.GERuleSources;
import com.blackgear.geologicexpansion.core.data.GEBiomeTags;
import com.blackgear.geologicexpansion.core.data.GEBlockTags;
import com.blackgear.geologicexpansion.core.platform.Environment;
import com.blackgear.geologicexpansion.core.platform.ModInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GeologicExpansion {
    public static final String MOD_ID = "geologicexpansion";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final ModInstance INSTANCE = ModInstance.create(MOD_ID)
        .common(CommonSetup::onInstance)
        .postCommon(CommonSetup::postInstance)
        .client(ClientSetup::onInstance)
        .postClient(ClientSetup::postInstance)
        .build();
    public static final CreativeModeTab CREATIVE_TAB = Environment.createTab(new ResourceLocation(GeologicExpansion.MOD_ID), () -> new ItemStack(Items.STONE));

    public static void bootstrap() {
        // ========== MOD INITIALIZATION ===============================================================================
        INSTANCE.bootstrap();

        // ========== MISCELLANEOUS REGISTRY ===========================================================================
        GEBlockEntities.BLOCK_ENTITIES.register();
        GEBlocks.BLOCKS.register();
        GEItems.ITEMS.register();
        GESounds.SOUNDS.register();
        GEPointOfInterests.POINTS.register();
        GEParticleTypes.PARTICLES.register();

        // ========== ENTITY REGISTRY ==================================================================================
        GEEntities.ENTITIES.register();
        GEProfessions.PROFESSIONS.register();

        // ========== WORLD GEN REGISTRY ===============================================================================
        GEFeatures.FEATURES.register();
        GENoises.NOISES.register();
        GEBiomes.BIOMES.register();
        GERuleSources.RULES.register();
        GETrunkPlacers.TRUNK_PLACERS.register();
        GEFoliagePlacer.FOLIAGE_PLACERS.register();

        // ========== TAG REGISTRY =====================================================================================
        GEBlockTags.TAGS.register();
        GEBiomeTags.TAGS.register();
    }
}