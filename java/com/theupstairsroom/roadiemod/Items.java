package com.theupstairsroom.roadiemod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class Items {
	public static Item roadiePoop;
	
	public static final void init()
	{
		roadiePoop = new ItemPoop();
		GameRegistry.registerItem(roadiePoop, "itemPoop");
	}
}
