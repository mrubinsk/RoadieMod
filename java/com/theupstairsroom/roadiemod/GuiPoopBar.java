/**
 * RoadieMod - GUI functionality to display current level of poop
 * on a HUD. Mostly adapted/copied from:
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

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class GuiPoopBar extends Gui {
	
	private Minecraft mc;
	
	private static final ResourceLocation texturepath = new ResourceLocation(RoadieMod.MODID, "textures/gui/mana_bar.png");

	public GuiPoopBar(Minecraft mc)
	{
		super();
		this.mc = mc;
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE) {
			return;
		}
		
		// Get our extended player properties and assign it locally so we can easily access it
		ExtendedPlayerP props = ExtendedPlayerP.get(this.mc.thePlayer);
		if (props == null || props.MAX_POOP_LEVEL == 0) {
			return;
		}
		int xPos = 2;
		int yPos = 2;
		
		// setting all color values to 1.0F will render the texture as it appears in your texture file
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		// Somewhere in Minecraft vanilla code it says to do this because of a lighting bug
		GL11.glDisable(GL11.GL_LIGHTING);
		
		// Bind your texture to the render engine
		this.mc.getTextureManager().bindTexture(texturepath);
		
		// First draw the background layer. In my texture file, it starts at the upper-
		// left corner (x=0, y=0), is 50 pixels long and 4 pixels thick (y value)
		this.drawTexturedModalRect(xPos, yPos, 0, 0, 50, 4);
		// Then draw the foreground; it's located just below the background in my
		// texture file, so it starts at x=0, y=4, is only 2 pixels thick and 50 length
		// Why y=4 and not y=5? Y starts at 0, so 0,1,2,3 = 4 pixels for the background
		// However, we want the length to be based on current mana, so we need a new variable:
		int poopbarwidth = (int)(((float) props.getCurrentPoop() / props.MAX_POOP_LEVEL) * 50);
		// Now we can draw our mana bar at yPos+1 so it centers in the background:
		this.drawTexturedModalRect(xPos, yPos + 1, 0, 4, poopbarwidth, 2);
	}
}
