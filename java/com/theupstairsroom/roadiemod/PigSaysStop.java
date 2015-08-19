/**
 * RoadieMod - Simple class to enable a Pig to request the player
 * stop attacking. Mostly just to demonstrate how this functionality
 * works.
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
							EnumChatFormatting.GOLD + "Please stop hitting me!"
					)
			);		
		}
	}
}
