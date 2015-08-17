package com.theupstairsroom.roadiemod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

public class FoodMakesPoop {
	
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
			props.addPoop(food.func_150905_g(event.item));
			if (props.fullOfPoop()) {
				player.capabilities.setPlayerWalkSpeed(0.05F);
			}
		}
	}
}
