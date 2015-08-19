/**
 * RoadieMod - Custom item definition for the "Fertilizer" item.
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFertilizer extends Item {

	public ItemFertilizer() {
		super();
		this.setUnlocalizedName("itemFertilizer");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setTextureName(RoadieMod.MODID + ":itemFertilizer");
	}
	
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
   {
	  System.out.println("Applying Bonemeal??");
      ItemDye.applyBonemeal(par1ItemStack, par3World, par4, par5, par6, par2EntityPlayer);
      return true;
   }
}
