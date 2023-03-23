package fr.aureprod.interfacewarp;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Commande implements CommandExecutor 
{
	@SuppressWarnings("unused")
	private Main main;
	
	public Commande(Main mainbis)
	{
		this.main = mainbis;
	}
	
	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) 
	{
		if (cmd.getName().equalsIgnoreCase("hudwarp"))
		{
			if (sender instanceof Player) 
			{
				if (args.length == 0)
				{
					Player player = (Player) sender;
					
					String playerName = player.getName();
				    String playerUuid = player.getUniqueId().toString();
				    
				    File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("Essentials").getDataFolder(), File.separator + "warps");
				    //File f = new File(userdata, File.separator + playerUuid + ".yml");
				    //FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
				    
				    for (File f : userdata.listFiles()) 
				    {
				    	FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
				    	
				    	String nomWorld = playerData.getString("name");
				    	Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "" + nomWorld);
					}
				}
				else
				{
					sender.sendMessage(ChatColor.RED + "Il ne faut pas mettre d'arguments dans cette commande !!");
				}
			}
			else
			{
				System.out.println("Cette commande n'est pas accessible via la console !!");
			}
		}

		return false;
	}
}
