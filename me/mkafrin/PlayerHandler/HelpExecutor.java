package me.mkafrin.PlayerHandler;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpExecutor implements org.bukkit.command.CommandExecutor
{
  private PlayerHandler plugin;
  
  public HelpExecutor(PlayerHandler plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
    if (args.length == 0) {
      sender.sendMessage(ChatColor.GOLD + "----------PlayerHandler----------");
      if ((sender.isOp()) || (sender.hasPermission("playerhandler.admin")) || (sender.hasPermission("playerhandler.freeze")) || (sender.hasPermission("playerhandler.stopchat")) || (sender.hasPermission("playerhandler.cmdstop")) || (sender.hasPermission("playerhandler.blockstop"))) {
        sender.sendMessage(ChatColor.GREEN + "<>=Mandatory|[]Optional");
      }
      if ((sender.isOp()) || (sender.hasPermission("playerhandler.admin"))) {
        sender.sendMessage(ChatColor.GREEN + "/playerhandler reload -" + ChatColor.WHITE + "Reloads plugin and displays help");
      } else {
        sender.sendMessage(ChatColor.GREEN + "/playerhandler -" + ChatColor.WHITE + "Displays help");
      }
      sender.sendMessage(ChatColor.GREEN + "/sinfo -" + ChatColor.WHITE + "Displays all of the important server information");
      if ((sender.isOp()) || (sender.hasPermission("playerhandler.admin")) || (sender.hasPermission("playerhandler.pinfo"))) {
        sender.sendMessage(ChatColor.GREEN + "/pinfo -" + ChatColor.WHITE + "Displays all of the important player information");
      }
      sender.sendMessage(ChatColor.GREEN + "/einfo -" + ChatColor.WHITE + "Displays all of the important extra information");
      if ((sender.isOp()) || (sender.hasPermission("playerhandler.admin")) || (sender.hasPermission("playerhandler.freeze"))) {
        sender.sendMessage(ChatColor.GREEN + "/freeze <player> -" + ChatColor.WHITE + "Freezes the player in place, although they can still look around");
      }
      if ((sender.isOp()) || (sender.hasPermission("playerhandler.admin")) || (sender.hasPermission("playerhandler.stopchat"))) {
        sender.sendMessage(ChatColor.GREEN + "/stopchat [player] -" + ChatColor.WHITE + "Mutes a specific player or the whole chat");
      }
      if ((sender.isOp()) || (sender.hasPermission("playerhandler.admin")) || (sender.hasPermission("playerhandler.blockstop"))) {
        sender.sendMessage(ChatColor.GREEN + "/blockstop <player> [break/place]-" + ChatColor.WHITE + "Stops player from either placing or breaking blocks, or both");
      }
      if ((sender.isOp()) || (sender.hasPermission("playerhandler.admin")) || (sender.hasPermission("playerhandler.cmdstop"))) {
        sender.sendMessage(ChatColor.GREEN + "/cmdstop <player> -" + ChatColor.WHITE + "Stops player from using commands");
      }
    }
    if ((args.length == 1) && 
      (args[0].equalsIgnoreCase("reload")) && (
      (sender.isOp()) || (sender.hasPermission("playerhandler.admin")))) {
      this.plugin.reloadConfig();
      sender.sendMessage(ChatColor.GREEN + "PlayerHandler Reloaded!");
    }
    

    return false;
  }
}
