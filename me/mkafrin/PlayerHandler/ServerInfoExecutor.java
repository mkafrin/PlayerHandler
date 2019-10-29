package me.mkafrin.PlayerHandler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ServerInfoExecutor implements org.bukkit.command.CommandExecutor
{
  public ServerInfoExecutor(PlayerHandler plugin) {}
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (args.length >= 0) {
      String ServerName = Bukkit.getServer().getName();
      String MinecraftVersion = Bukkit.getVersion();
      String BukkitVersion = Bukkit.getServer().getBukkitVersion();
      int animalSpawnLimit = Bukkit.getServer().getAnimalSpawnLimit();
      int maxPlayers = Bukkit.getServer().getMaxPlayers();
      int monsterSpawnLimit = Bukkit.getServer().getMonsterSpawnLimit();
      
      String gameMode = Bukkit.getServer().getDefaultGameMode().toString();
      
      sender.sendMessage(ChatColor.GOLD + "----------" + ChatColor.AQUA + ServerName + ChatColor.GOLD + "----------");
      sender.sendMessage(ChatColor.GREEN + "Minecraft Version: " + MinecraftVersion);
      sender.sendMessage(ChatColor.GREEN + "Bukkit Version: " + BukkitVersion);
      sender.sendMessage(ChatColor.GREEN + "Max Players: " + maxPlayers);
      sender.sendMessage(ChatColor.GREEN + "Default Gamemode: " + gameMode);
      sender.sendMessage(ChatColor.GREEN + "Animal Spawn Limit: " + animalSpawnLimit);
      sender.sendMessage(ChatColor.GREEN + "Monster Spawn Limit: " + monsterSpawnLimit);
      sender.sendMessage(ChatColor.GREEN + "Worlds:");
      
      String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
      int count = 0;
      for (World w : Bukkit.getServer().getWorlds()) {
        worldNames[count] = w.getName();
        count++; }
      String[] arrayOfString1;
      int j = (arrayOfString1 = worldNames).length; for (int i = 0; i < j; i++) { String s = arrayOfString1[i];
        sender.sendMessage(ChatColor.GREEN + s);
      }
      
      sender.sendMessage(ChatColor.GOLD + "----------" + ChatColor.AQUA + ServerName + ChatColor.GOLD + "----------");
    }
    return false;
  }
}
