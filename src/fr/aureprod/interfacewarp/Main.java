package fr.aureprod.interfacewarp;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin 
{
	@Override
	public void onEnable() 
	{
		//saveDefaultConfig();
		
		System.out.println("Le plugin Interface Warp est est demarre !!!");
		getCommand("hudwarp").setExecutor(new Commande(this));
		getServer().getPluginManager().registerEvents(new Listeners(), this);
	}
	
	@Override
	public void onDisable() 
	{
		System.out.println("Le plugin Interface Warp est arreter !!!");
	}
}
