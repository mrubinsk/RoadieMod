package com.theupstairsroom.roadiemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockToilet extends Block
{
	public static String BLOCK_NAME = "blockToilet";
	public static Integer POOP_PER_FLUSH = 2;
	public BlockToilet() {
		super(Material.wood);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setBlockTextureName(RoadieMod.MODID + ":" + BLOCK_NAME);
		this.setBlockName(BLOCK_NAME);
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
			}
			props.removePoop(POOP_PER_FLUSH);
			if (!props.fullOfPoop()) {
				entityPlayer.capabilities.setPlayerWalkSpeed(0.1F);
			}
		}
		return true;
	}
	
}