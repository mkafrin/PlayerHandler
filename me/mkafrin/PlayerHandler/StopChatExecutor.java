package me.mkafrin.PlayerHandler;

import org.bukkit.command.CommandSender;

public class StopChatExecutor implements org.bukkit.command.CommandExecutor
{
  private PlayerHandler plugin;
  
  public StopChatExecutor(PlayerHandler plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
    if ((sender.isOp()) || (sender.hasPermission("playerhandler.admin")) || 
      (sender.hasPermission("playerhandler.stopchat"))) {
      if ((args.length == 0) && (this.plugin.chatmute)) {
        this.plugin.chatmute = false;
        org.bukkit.Bukkit.broadcastMessage(org.bukkit.ChatColor.AQUA + "Chat has been restored!");
      } else {
        this.plugin.chatmute = true;
        org.bukkit.Bukkit.broadcastMessage(org.bukkit.ChatColor.AQUA + "Chat has been momentarily stopped");
      }
    }
    if (args.length == 1) {
      this.plugin.targetPlayer = org.bukkit.Bukkit.getServer().getPlayer(args[0]);
      if (this.plugin.targetPlayer != null) {
        if (this.plugin.targetmute.containsKey(this.plugin.targetPlayer)) {
          this.plugin.targetmute.remove(this.plugin.targetPlayer);
          sender.sendMessage(org.bukkit.ChatColor.GREEN + "Player is now able to chat!");
          return true;
        }
        this.plugin.targetmute.put(this.plugin.targetPlayer, null);
        sender.sendMessage(org.bukkit.ChatColor.GREEN + "Player is now blocked from chating!");
      } else {
        sender.sendMessage(org.bukkit.ChatColor.RED + "That player is not online!");
      }
    }
    return false;
  }
}
