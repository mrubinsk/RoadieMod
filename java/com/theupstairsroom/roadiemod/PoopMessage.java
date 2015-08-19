/**
 * RoadieMod - Custom IMessage for sending currentPoop value from
 * server to client in a packet.
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
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class PoopMessage implements IMessage {
	private int currentPoop;
	
	public PoopMessage() { }
	
	public PoopMessage(int currentPoop)
	{
		this.currentPoop = currentPoop;
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		currentPoop = ByteBufUtils.readVarInt(buf, 2);
	}
	
	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeVarInt(buf, currentPoop, 2);
	}
	
	public static class Handler implements IMessageHandler<PoopMessage, IMessage>
	{
		@Override
		public IMessage onMessage(PoopMessage message, MessageContext ctx)
		{
			if (!ctx.side.isClient()) {
				return null;
			}
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			ExtendedPlayerP props = ExtendedPlayerP.get(player);
			props.setCurrentPoop(message.currentPoop);
			return null;
		}
	}
}
