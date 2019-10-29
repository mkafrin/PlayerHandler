package me.mkafrin.PlayerHandler;

import java.util.HashMap;
import org.bukkit.command.CommandSender;

public class BlockstopExecutor implements org.bukkit.command.CommandExecutor
{
  private PlayerHandler plugin;
  
  public BlockstopExecutor(PlayerHandler plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
    if ((sender.isOp()) || (sender.hasPermission("playerhandler.admin")) || (sender.hasPermission("playerhandler.blockstop"))) {
      if (args.length == 0) {
        sender.sendMessage(org.bukkit.ChatColor.RED + "Usage: /blockstop <player> [place/break]");
      }
      if (args.length == 1) {
        this.plugin.targetPlayer = org.bukkit.Bukkit.getServer().getPlayer(args[0]);
        if (this.plugin.targetPlayer != null) {
          if ((this.plugin.onblockplace.containsKey(this.plugin.targetPlayer)) && (this.plugin.onblockbreak.containsKey(this.plugin.targetPlayer))) {
            this.plugin.onblockplace.remove(this.plugin.targetPlayer);this.plugin.onblockbreak.remove(this.plugin.targetPlayer);
            sender.sendMessage(org.bukkit.ChatColor.GREEN + "Player can now break and place blocks!");
            return true;
          }
          this.plugin.onblockplace.put(this.plugin.targetPlayer, null);
          this.plugin.onblockbreak.put(this.plugin.targetPlayer, null);
          sender.sendMessage(org.bukkit.ChatColor.GREEN + "Player can now not break or place blocks!");
        }
        else {
          sender.sendMessage(org.bukkit.ChatColor.RED + "That player is not online!");
        }
      }
      if (args.length == 2) {
        if ((args[1].equalsIgnoreCase("place")) || (args[1].equalsIgnoreCase("break"))) {
          this.plugin.targetPlayer = org.bukkit.Bukkit.getServer().getPlayer(args[0]);
          if (args[1].equalsIgnoreCase("break")) {
            if (this.plugin.onblockbreak.containsKey(this.plugin.targetPlayer)) {
              this.plugin.onblockbreak.remove(this.plugin.targetPlayer);
              sender.sendMessage(org.bukkit.ChatColor.GREEN + "Player can now break blocks!");
              return true;
            }
            this.plugin.onblockbreak.put(this.plugin.targetPlayer, null);
            sender.sendMessage(org.bukkit.ChatColor.GREEN + "Player can now not break blocks!");
          }
          
          if (args[1].equalsIgnoreCase("place")) {
            if (this.plugin.onblockplace.containsKey(this.plugin.targetPlayer)) {
              this.plugin.onblockplace.remove(this.plugin.targetPlayer);
              sender.sendMessage(org.bukkit.ChatColor.GREEN + "Player can now place blocks!");
              return true;
            }
            this.plugin.onblockplace.put(this.plugin.targetPlayer, null);
            sender.sendMessage(org.bukkit.ChatColor.GREEN + "Player can now not place blocks!");
          }
        }
        else {
          sender.sendMessage(org.bukkit.ChatColor.RED + "Usage: /blockstop <player> [place/break]");
          return true;
        }
      }
    }
    return false;
  }
}
