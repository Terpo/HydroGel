package com.digitalfeonix.hydrogel.block;

import com.digitalfeonix.hydrogel.item.ItemModelProvider;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static BlockHydroGel hydrogel;

	public static void init() {
		hydrogel = register(new BlockHydroGel("hydrogel"));
	}

	private static <T extends Block> T register(T block, ItemBlock itemBlock) {
		GameRegistry.register(block);
		if (itemBlock != null) {
			GameRegistry.register(itemBlock);

			if (block instanceof ItemModelProvider) {
				((ItemModelProvider) block).registerItemModel(itemBlock);
			}
		}

		return block;
	}

	private static <T extends Block> T register(T block) {
		final ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		return register(block, itemBlock);
	}

}