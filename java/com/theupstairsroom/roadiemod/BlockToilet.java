/**
 * RoadieMod - Toilet block. Defines custom behavior of the toilet
 * block. I.e., custom texture and custom action when activiated.
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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockToilet extends Block
{
	public static String BLOCK_NAME = "blockToilet";
	public static Integer POOP_PER_FLUSH = 2;
	public IIcon[] icons = new IIcon[6];
	
	public BlockToilet() {
		super(Material.wood);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setBlockTextureName(RoadieMod.MODID + ":" + BLOCK_NAME);
		this.setBlockName(BLOCK_NAME);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg)
	{
		for (int i = 0; i < 6; i++) {
			this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
		}
	}
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.icons[side];
	}
	
	@Override
	public boolean onBlockActivated(World world, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer entityPlayer, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		ExtendedPlayerP props = ExtendedPlayerP.get(entityPlayer);
		if (props.getCurrentPoop() > 1) {
			// Ok, so to spawn an Item into the world you need to use an Entity. To use an
			// Entity, you need to use a Stack...**BE SURE THE Item you create the stack with
			// is the SAME instance that was registered in the GameRegistry**. You cannot create
			// a new instance here and expect it to work.
			ItemStack poopStack = new ItemStack(Items.roadiePoop, POOP_PER_FLUSH).setStackDisplayName("Poop");
			EntityItem poopEntity = new EntityItem(
					entityPlayer.worldObj,
					entityPlayer.posX,
					entityPlayer.posY,
					entityPlayer.posZ,
					poopStack);
			if (!entityPlayer.worldObj.isRemote) {
    			entityPlayer.worldObj.spawnEntityInWorld(poopEntity);
    			world.playSoundAtEntity(entityPlayer, "random.splash", 1, 1);
    	
			}
			props.removePoop(POOP_PER_FLUSH);
			if (!props.fullOfPoop()) {
				entityPlayer.capabilities.setPlayerWalkSpeed(0.1F);
			}
		}
		return true;
	}
	
}