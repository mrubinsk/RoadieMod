/**
 * RoadieMod - Custom item class. All custom items need to be registered
 * and assigned to a public static member of this class.
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
import net.minecraft.item.Item;

public class Items {
	public static Item roadiePoop;
	public static Item roadieFertilizer;
	
	public static final void init()
	{
		roadiePoop = new ItemPoop();
		GameRegistry.registerItem(roadiePoop, "itemPoop");
		
		roadieFertilizer = new ItemFertilizer();
		GameRegistry.registerItem(roadieFertilizer, "itemFertilizer");
	}
}
