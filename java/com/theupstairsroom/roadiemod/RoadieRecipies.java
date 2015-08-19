/**
 * RoadieMod - Custom recipie class. Defines all custom recipies.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * @copyright 2015 Michael J Rubinsky <mike@theupstairsroom.com>
 * @author mrubinsk
 * @license http://www.gnu.org/licenses/gpl-3.0.html
 */
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
		
		GameRegistry.addSmelting(
				Items.roadiePoop,
				new ItemStack(Items.roadieFertilizer),
				.1F
		);
	}
}
	
