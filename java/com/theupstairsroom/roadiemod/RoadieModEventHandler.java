/**
 * RoadieMod - Generic event handler class for events that dont' fit
 * into an explicit class elsewhere. Packet code adapted from:
 * https://github.com/coolAlias/Forge_Tutorials/blob/master/IExtendedEntityPropertiesTutorial.java
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
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
public class RoadieModEventHandler
{
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer) {
	    	ExtendedPlayerP.register((EntityPlayer) event.entity);
		}
		
	}
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			ExtendedPlayerP props = ExtendedPlayerP.get((EntityPlayer) event.entity);
			RoadieMod.network.sendTo(new PoopMessage(props.getCurrentPoop()), (EntityPlayerMP) event.entity);
		}
		
	}
}
