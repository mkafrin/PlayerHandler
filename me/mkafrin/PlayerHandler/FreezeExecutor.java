package me.mkafrin.PlayerHandler;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class FreezeExecutor implements org.bukkit.command.CommandExecutor
{
  private PlayerHandler plugin;
  
  public FreezeExecutor(PlayerHandler plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
    if ((sender.isOp()) || (sender.hasPermission("playerhandler.admin")) || (sender.hasPermission("playerhandler.freeze"))) {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /freeze <player>");
      }
      if (args.length == 1) {
        this.plugin.targetPlayer = org.bukkit.Bukkit.getServer().getPlayer(args[0]);
        if (this.plugin.targetPlayer != null) {
          if (this.plugin.freezemap.containsKey(this.plugin.targetPlayer)) {
            this.plugin.freezemap.remove(this.plugin.targetPlayer);
            sender.sendMessage(ChatColor.GREEN + "Player is now unfrozen!");
            return true;
          }
          this.plugin.freezemap.put(this.plugin.targetPlayer, null);
          sender.sendMessage(ChatColor.GREEN + "Player is now frozen!");
        }
        else {
          sender.sendMessage(ChatColor.RED + "That player is not online!");
        }
      }
    }
    return false;
  }
}
