package com.theupstairsroom.roadiemod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class PigSaysStop {

	@SubscribeEvent
	public void sendMessage(AttackEntityEvent event) {
		if (!(event.target instanceof EntityPig)) {
			return;
		}
		if (!event.entity.worldObj.isRemote) {
			event.entityPlayer.addChatComponentMessage(
					new ChatComponentText(
							EnumChatFormatting.GOLD + "Please stop hitting me - you will regret it!!!"
					)
			);		
		}
	}
}
