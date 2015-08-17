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
