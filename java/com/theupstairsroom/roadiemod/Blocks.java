package com.theupstairsroom.roadiemod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class Blocks {

	public static Block roadieToilet;
	
	public static final void init()
	{
		roadieToilet = new BlockToilet();
		GameRegistry.registerBlock(roadieToilet, BlockToilet.BLOCK_NAME);
	}
}
