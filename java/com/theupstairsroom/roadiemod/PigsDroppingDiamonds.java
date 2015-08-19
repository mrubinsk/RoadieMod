/**
 * RoadieMod - Simple class to enable a Pig to drop diamonds when
 * killed. Mostly just to demonstrate how this is done, so I can refer
 * back to it in my own code.
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
import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class PigsDroppingDiamonds {
    
	@SubscribeEvent
	public void dropDiamonds(LivingDeathEvent event) {
		if (!(event.entity instanceof EntityPig)) {
			return;
		}
		
		Random random = new Random();
		
		if (!event.entity.worldObj.isRemote) {
			event.entity.dropItem(Items.diamond_sword, random.nextInt(3));
		}
	}
	
}
