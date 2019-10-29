package me.mkafrin.PlayerHandler;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CmdstopExecutor implements org.bukkit.command.CommandExecutor
{
  private PlayerHandler plugin;
  
  public CmdstopExecutor(PlayerHandler plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
    if ((sender.isOp()) || (sender.hasPermission("playerhandler.admin")) || (sender.hasPermission("playerhandler.cmdstop"))) {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /cmdstop <player>");
      }
      if (args.length == 1) {
        this.plugin.targetPlayer = org.bukkit.Bukkit.getServer().getPlayer(args[0]);
        if (this.plugin.targetPlayer != null) {
          if (this.plugin.command.containsKey(this.plugin.targetPlayer)) {
            this.plugin.command.remove(this.plugin.targetPlayer);
            sender.sendMessage(ChatColor.GREEN + "Player can now use commands!");
            return true;
          }
          this.plugin.command.put(this.plugin.targetPlayer, null);
          sender.sendMessage(ChatColor.GREEN + "Player can now not use commands!");
        }
        else {
          sender.sendMessage(ChatColor.RED + "That player is not online!");
        }
      }
    }
    return false;
  }
}
