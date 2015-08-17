package com.theupstairsroom.roadiemod;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
		//MinecraftForge.EVENT_BUS.register(new PigsDroppingDiamonds());
		//MinecraftForge.EVENT_BUS.register(new PigsSpawnEnderman());
    	MinecraftForge.EVENT_BUS.register(new RoadieModEventHandler());
    	MinecraftForge.EVENT_BUS.register(new FoodMakesPoop());
    	RoadieMod.network.registerMessage(PoopMessage.Handler.class, PoopMessage.class, 0, Side.CLIENT);
    }

    public void init(FMLInitializationEvent e) {
		Items.init();
		Blocks.init();
    }

    public void postInit(FMLPostInitializationEvent e) {
  
    }
}
