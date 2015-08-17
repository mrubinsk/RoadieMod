package com.theupstairsroom.roadiemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = RoadieMod.MODID, name = "RoadieMod", version = RoadieMod.VERSION)
public class RoadieMod {
	public static final String MODID = "rm";
	public static final String VERSION = "1.0";
	public static SimpleNetworkWrapper network;
	
	@SidedProxy(clientSide="com.theupstairsroom.roadiemod.ClientProxy", serverSide="com.theupstairsroom.roadiemod.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		network = NetworkRegistry.INSTANCE.newSimpleChannel("RoadieChannel");
		proxy.preInit(event);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}	
