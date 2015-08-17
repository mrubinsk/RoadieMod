package com.theupstairsroom.roadiemod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RoadieRecipies
{
	public RoadieRecipies() {
		
	}
	
	public static void init()
    {
		System.out.println("Adding toilet recipie.");
		GameRegistry.addShapedRecipe(
    		new ItemStack(Blocks.roadieToilet),
    		"www",
    		"whw",
    		"www",
    		'w', new ItemStack(net.minecraft.init.Blocks.planks, 1, OreDictionary.WILDCARD_VALUE),
    		'h', new ItemStack(net.minecraft.init.Items.water_bucket)
	    );
	}
}
	
