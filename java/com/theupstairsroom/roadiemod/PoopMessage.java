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
