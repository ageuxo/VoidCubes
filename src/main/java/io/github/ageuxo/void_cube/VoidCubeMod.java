package io.github.ageuxo.void_cube;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class VoidCubeMod implements ModInitializer {
    public static final String MOD_ID = "void_cube";
    public static final Block VOID_CUBE = new VoidCubeBlock(FabricBlockSettings.of(Material.BUILDABLE_GLASS).strength(0.6f).nonOpaque());
    public static final Block VOID_CUBE_ALT = new VoidCubeBlock(FabricBlockSettings.of(Material.BUILDABLE_GLASS).strength(0.6f).nonOpaque()){
        @Override
        public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
            return new VoidCubeAltBlockEntity(blockPos, blockState);
        }
    };
    public static final Block VOID_CUBE_TRANS = new VoidCubeBlockTransparent(FabricBlockSettings.of(Material.BUILDABLE_GLASS).strength(0.6f).nonOpaque());
    public static final Block VOID_CUBE_TRANS_ALT = new VoidCubeBlockTransparent(FabricBlockSettings.of(Material.BUILDABLE_GLASS).strength(0.6f).nonOpaque()){
        @Override
        public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
            return new VoidCubeAltBlockEntity(blockPos, blockState);
        }
    };

    public static BlockEntityType<VoidCubeBlockEntity> VOID_CUBE_BE;
    public static BlockEntityType<VoidCubeAltBlockEntity> VOID_CUBE_ALT_BE;

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new ResourceLocation(MOD_ID,"void_cube"), VOID_CUBE);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "void_cube"), new BlockItem(VOID_CUBE, new Item.Properties()));
        Registry.register(Registry.BLOCK, new ResourceLocation(MOD_ID,"void_cube_alt"), VOID_CUBE_ALT);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "void_cube_alt"), new BlockItem(VOID_CUBE_ALT, new Item.Properties()));

        Registry.register(Registry.BLOCK, new ResourceLocation(MOD_ID,"void_cube_trans"), VOID_CUBE_TRANS);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "void_cube_trans"), new BlockItem(VOID_CUBE_TRANS, new Item.Properties()));
        Registry.register(Registry.BLOCK, new ResourceLocation(MOD_ID,"void_cube_trans_alt"), VOID_CUBE_TRANS_ALT);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "void_cube_trans_alt"), new BlockItem(VOID_CUBE_TRANS_ALT, new Item.Properties()));

        VOID_CUBE_BE = Registry.register(
                Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(MOD_ID, "void_cube"),
                FabricBlockEntityTypeBuilder.create(VoidCubeBlockEntity::new, VOID_CUBE, VOID_CUBE_TRANS).build());

        VOID_CUBE_ALT_BE = Registry.register(
                Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(MOD_ID, "void_cube_alt"),
                FabricBlockEntityTypeBuilder.create(VoidCubeAltBlockEntity::new, VOID_CUBE_ALT, VOID_CUBE_TRANS_ALT).build());
    }
}
