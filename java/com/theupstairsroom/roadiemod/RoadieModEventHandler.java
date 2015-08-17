package com.theupstairsroom.roadiemod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

/**
 * General event handler class for non-single action modifications.
 * @author mrubinsk
 */
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
		//Only need to synchronize when the world is NOT remote (i.e. we're on the server side)
		// and only for player entities, as that's what we need for the GuiManaBar
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			ExtendedPlayerP props = ExtendedPlayerP.get((EntityPlayer) event.entity);
			RoadieMod.network.sendTo(new PoopMessage(props.getCurrentPoop()), (EntityPlayerMP) event.entity);
		}
		
	}
}
