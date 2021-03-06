/**
 * RoadieMod - event handling class that glues together the
 * functionality of adding poop when eating. Prevents player
 * from eating if full or adds poop when eating.
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

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

public class FoodMakesPoop {
	public static double FOOD_TO_POOP_MULTIPLIER = 0.25;
	
	@SubscribeEvent
	public void startUsingFood(PlayerUseItemEvent.Start event) {
		// If full of poop, don't allow player to eat.
		if (event.item.getItem() instanceof ItemFood && !event.entity.worldObj.isRemote) {
			ExtendedPlayerP props = ExtendedPlayerP.get(event.entityPlayer);
			if (props.fullOfPoop()) {
				event.setCanceled(true);
			}
		}
	}
	
	@SubscribeEvent
	public void finishUsingFood(PlayerUseItemEvent.Finish event) {
		if (event.item.getItem() instanceof ItemFood && !event.entity.worldObj.isRemote) {
			EntityPlayer player = event.entityPlayer;
			ExtendedPlayerP props = ExtendedPlayerP.get(event.entityPlayer);
			ItemFood food = (ItemFood) event.item.getItem();
			// For now, use healing value. In future, make custom mapping of food/poop amount.
			//props.addPoop((int)(food.func_150905_g(event.item) * FoodMakesPoop.FOOD_TO_POOP_MULTIPLIER));
			props.addPoop(food.func_150905_g(event.item));
			if (props.fullOfPoop()) {
				player.capabilities.setPlayerWalkSpeed(0.05F);
			}
		}
	}
}
