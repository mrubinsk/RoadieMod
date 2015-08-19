/**
 * RoadieMod - Simple class to enable a Pig spawn an enderman when
 * killed. Mostly just to demonstrate how this is done so I can refer
 * back to it.
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
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.passive.EntityPig;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class PigsSpawnEnderman {
	@SubscribeEvent
	public void spawnEnderman(LivingDeathEvent event) {
		if (!(event.entity instanceof EntityPig)) {
			return;
		}
		
		if (!event.entity.worldObj.isRemote) {
			EntityEnderman creeper = new EntityEnderman(event.entity.worldObj);
			creeper.setLocationAndAngles(
					event.entity.posX,
					event.entity.posY,
					event.entity.posZ,
					0,
					0);
		    event.entity.worldObj.spawnEntityInWorld(creeper);
		}
	}
}
