package com.theupstairsroom.roadiemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemPoop extends Item {

	public ItemPoop() {
		super();
		this.setUnlocalizedName("itemPoop");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setTextureName(RoadieMod.MODID + ":itemPoop");
	}
}
