package me.mkafrin.PlayerHandler;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ExtraInfoExecutor implements org.bukkit.command.CommandExecutor
{
  private PlayerHandler plugin;
  
  public ExtraInfoExecutor(PlayerHandler plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
    if (args.length >= 0) {
      sender.sendMessage(ChatColor.GOLD + "----------" + ChatColor.AQUA + "Extra" + ChatColor.GOLD + "----------");
      sender.sendMessage(ChatColor.GREEN + "Website: " + this.plugin.getConfig().getString("Website"));
      sender.sendMessage(ChatColor.GREEN + "Forums: " + this.plugin.getConfig().getString("Forums"));
      sender.sendMessage(ChatColor.GREEN + "FAQ: " + this.plugin.getConfig().getString("FAQ"));
      sender.sendMessage(ChatColor.GREEN + "Donation Page: " + this.plugin.getConfig().getString("Donation page"));
      sender.sendMessage(ChatColor.GREEN + "Teamspeak: " + this.plugin.getConfig().getString("Teamspeak"));
      sender.sendMessage(ChatColor.GREEN + "Mumble: " + this.plugin.getConfig().getString("Mumble"));
      sender.sendMessage(ChatColor.GREEN + "Ventrilo: " + this.plugin.getConfig().getString("Ventrilo"));
      sender.sendMessage(ChatColor.GREEN + "Extra Info: " + this.plugin.getConfig().getString("Extra Info"));
      sender.sendMessage(ChatColor.GOLD + "----------" + ChatColor.AQUA + "Info" + ChatColor.GOLD + "----------");
    }
    return false;
  }
}
