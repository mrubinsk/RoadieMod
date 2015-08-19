/**
 * RoadieMod - ExtendedPlayerP class defines extended properties
 * for the player object to store the current poop level. Functionality
 * to add/remove/get current level of poop. Change MAX_POOP_LEVEL if you
 * wish to change the maximum amount of poop allowed before negative
 * effects start happening.
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

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayerP implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "ExtendedPlayerP";
    private final EntityPlayer player;
	private int currentPoopLevel;
	int MAX_POOP_LEVEL = 20;
	
	/**
	 * Constructor
	 * 
	 * @param player
	 */
	public ExtendedPlayerP(EntityPlayer player)
	{
		this.player = player;
		this.currentPoopLevel = 0;
	}
	
	/**
	 * Register this IExtendedEntityProperties instance with the EntityPlayer.
	 * 
	 * @param player
	 */
	public static void register(EntityPlayer player)
	{
		player.registerExtendedProperties(ExtendedPlayerP.EXT_PROP_NAME, new ExtendedPlayerP(player));
	}
	
	/**
	 * Get the extended properties for the player.
	 * @param player
	 * @return
	 */
	public static final ExtendedPlayerP get(EntityPlayer player)
	{
		return (ExtendedPlayerP)player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		// New tag compound to save our properties.
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("CurrentPoop",this.currentPoopLevel);
		
		// Save custom tag to player's tag.
		compound.setTag(EXT_PROP_NAME, properties);
		System.out.println("Saving Current Poop: " + this.currentPoopLevel);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.currentPoopLevel = properties.getInteger("CurrentPoop");

		// Debug.
		System.out.println("Loading Current Poop: " + this.currentPoopLevel);
	}

	@Override
	public void init(Entity entity, World world) {
	}
	
	/**
	 * Add specified amount of poop.
	 * 
	 * @param int amount  The amount of poop to add.
	 */
	public void addPoop(int amount)
	{
		if (this.currentPoopLevel < this.MAX_POOP_LEVEL) {
			this.currentPoopLevel += amount;
		}
		if (!player.worldObj.isRemote) {
			RoadieMod.network.sendTo(new PoopMessage(this.getCurrentPoop()), (EntityPlayerMP) player);
		}
	}
	
	public void setCurrentPoop(int amount)
	{
		this.currentPoopLevel = amount;
	}
	
	/**
	 * "Poop" a specified amount.
	 * 
	 * @param int amount  The amount to "poop"
	 */
	public void removePoop(int amount)
	{
		this.currentPoopLevel -= amount;
		if (!player.worldObj.isRemote) {
			RoadieMod.network.sendTo(new PoopMessage(this.getCurrentPoop()), (EntityPlayerMP) player);
		}
	}
	
	/**
	 * Return the current poop level.
	 * 
	 * @return int
	 */
	public int getCurrentPoop()
	{
		return this.currentPoopLevel;
	}
	
	/**
	 * Return if the player is full of poop.
	 * 
	 * @return boolean
	 */
	public boolean fullOfPoop()
	{
		return (this.currentPoopLevel >= this.MAX_POOP_LEVEL);
	}

}
