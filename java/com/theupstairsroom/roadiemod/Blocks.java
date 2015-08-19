/**
 * RoadieMod - Custom blocks class. All cutom blocks must be registered
 * and stored in public static members of this class.
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

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class Blocks {

	public static Block roadieToilet;
	
	public static final void init()
	{
		roadieToilet = new BlockToilet();
		GameRegistry.registerBlock(roadieToilet, BlockToilet.BLOCK_NAME);
	}
}
