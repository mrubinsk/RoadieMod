/**
 * RoadieMod - Custom item definition for the "Poop" item.
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
