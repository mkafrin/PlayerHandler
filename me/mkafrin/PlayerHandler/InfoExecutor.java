package me.mkafrin.PlayerHandler;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class InfoExecutor implements org.bukkit.command.CommandExecutor
{
  private PlayerHandler plugin;
  
  public InfoExecutor(PlayerHandler plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
    if ((sender.isOp()) || (sender.hasPermission("playerhandler.admin")) || 
      (sender.hasPermission("playerhandler.pinfo"))) {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "Usage: /pinfo <player> [set/inv]");
      }
      if (args.length == 1) {
        this.plugin.targetPlayer = org.bukkit.Bukkit.getServer().getPlayer(args[0]);
        if (this.plugin.targetPlayer != null) {
          String playerIp = this.plugin.targetPlayer.getAddress().getAddress().getHostAddress();
          double playerHealth = this.plugin.targetPlayer.getHealth();
          double playerHunger = this.plugin.targetPlayer.getFoodLevel();
          int playerLevel = this.plugin.targetPlayer.getLevel();
          org.bukkit.inventory.ItemStack playerMainItem = this.plugin.targetPlayer.getInventory().getItemInMainHand();
          org.bukkit.inventory.ItemStack playerOffItem = this.plugin.targetPlayer.getInventory().getItemInOffHand();
          String playerWorld = this.plugin.targetPlayer.getWorld().getName();
          int playerPositionX = (int)this.plugin.targetPlayer.getLocation().getX();
          int playerPositionY = (int)this.plugin.targetPlayer.getLocation().getY();
          int playerPositionZ = (int)this.plugin.targetPlayer.getLocation().getZ();
          String playerGamemode = this.plugin.targetPlayer.getGameMode().name();
          
          boolean ifMuted = this.plugin.targetmute.containsKey(this.plugin.targetPlayer);
          String ifMutedString = null;
          if (ifMuted) {
            ifMutedString = "Yes";
          } else {
            ifMutedString = "No";
          }
          
          boolean playerFly = this.plugin.targetPlayer.getAllowFlight();
          String playerFlyString = null;
          if (playerFly) {
            playerFlyString = "Yes";
          } else {
            playerFlyString = "No";
          }
          
          boolean isFrozen = this.plugin.freezemap.containsKey(this.plugin.targetPlayer);
          String isFrozenString = null;
          if (isFrozen) {
            isFrozenString = "Yes";
          } else {
            isFrozenString = "No";
          }
          
          boolean cmdstop = this.plugin.command.containsKey(this.plugin.targetPlayer);
          String cmdstopstring = null;
          if (cmdstop) {
            cmdstopstring = "No";
          } else {
            cmdstopstring = "Yes";
          }
          
          boolean blockplace = this.plugin.onblockplace.containsKey(this.plugin.targetPlayer);
          String blockplacestring = null;
          if (blockplace) {
            blockplacestring = "No";
          } else {
            blockplacestring = "Yes";
          }
          
          boolean blockbreak = this.plugin.onblockbreak.containsKey(this.plugin.targetPlayer);
          String blockbreakstring = null;
          if (blockbreak) {
            blockbreakstring = "No";
          } else {
            blockbreakstring = "Yes";
          }
          
          sender.sendMessage(ChatColor.GOLD + "----------" + ChatColor.AQUA + 
            this.plugin.targetPlayer.getName() + ChatColor.GOLD + "----------");
          if ((sender.hasPermission("playerhandler.pinfo.ipsee")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Ip Address: " + playerIp);
          }
          if ((sender.hasPermission("playerhandler.pinfo.gamemode")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Gamemode: " + playerGamemode);
          }
          if ((sender.hasPermission("playerhandler.pinfo.health")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Health: " + playerHealth);
          }
          if ((sender.hasPermission("playerhandler.pinfo.hunger")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Food: " + playerHunger);
          }
          if ((sender.hasPermission("playerhandler.pinfo.level")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Level: " + playerLevel);
          }
          if ((sender.hasPermission("playerhandler.pinfo.location")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Location: " + playerWorld + ", " + playerPositionX + ", " + 
              playerPositionY + ", " + playerPositionZ);
          }
          if ((sender.hasPermission("playerhandler.pinfo.item")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Item in Main Hand: " + playerMainItem);
          }
          if ((sender.hasPermission("playerhandler.pinfo.item")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Item in Off Hand: " + playerOffItem);
          }
          if ((sender.hasPermission("playerhandler.pinfo.muted")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Muted: " + ifMutedString);
          }
          if ((sender.hasPermission("playerhandler.pinfo.frozen")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Frozen: " + isFrozenString);
          }
          if ((sender.hasPermission("playerhandler.pinfo.fly")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Can Fly: " + playerFlyString);
          }
          if ((sender.hasPermission("playerhandler.pinfo.cmdstop")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Can use commands: " + cmdstopstring);
          }
          if ((sender.hasPermission("playerhandler.pinfo.blockplace")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Can place blocks: " + blockplacestring);
          }
          if ((sender.hasPermission("playerhandler.pinfo.blockbreak")) || 
            (sender.hasPermission("playerhandler.pinfo"))) {
            sender.sendMessage(ChatColor.GREEN + "Can break blocks: " + blockbreakstring);
          }
          sender.sendMessage(ChatColor.GOLD + "----------" + ChatColor.AQUA + 
            this.plugin.targetPlayer.getName() + ChatColor.GOLD + "----------");
        }
        else {
          sender.sendMessage(ChatColor.RED + "That player is not online!");
        }
      }
      if ((args.length == 2) && (!args[1].equalsIgnoreCase("inv"))) {
        sender.sendMessage(ChatColor.RED + "Usage: /pinfo <player> [set/inv] <health/food/level> <0-20/0-20/0-50>");
      }
      if (args.length == 2) {
        this.plugin.targetPlayer = org.bukkit.Bukkit.getServer().getPlayer(args[0]);
        if (this.plugin.targetPlayer != null) {
          org.bukkit.inventory.Inventory playerInv = this.plugin.targetPlayer.getInventory();
          if ((args[1].equalsIgnoreCase("inv")) && (
            (sender.hasPermission("playerhandler.pinfo.inv")) || 
            (sender.hasPermission("playerhandler.pinfo")) || 
            (sender.hasPermission("playerhandler.admin")) || (sender.isOp()))) {
            org.bukkit.entity.Player senderP = (org.bukkit.entity.Player)sender;
            senderP.openInventory(playerInv);
          }
        } else {
          sender.sendMessage(ChatColor.RED + "That player is not online!");
        }
      }
      if (args.length == 3) {
        sender.sendMessage(ChatColor.RED + "Usage: /pinfo <player> [set/inv] <health/food/level> <0-20/0-20/0-50>");
      }
      
      if (args.length == 4) {
        this.plugin.targetPlayer = org.bukkit.Bukkit.getServer().getPlayer(args[0]);
        if (args[2].equalsIgnoreCase("health")) {
          int limit = 20;
          String number = args[3];
          try {
            int x = Integer.parseInt(number);
            if (x <= limit) {
              if (x > 0) {
                this.plugin.targetPlayer.setHealth(x);
              }
              if (x == 0) {
                this.plugin.targetPlayer.setHealth(x);
                sender.sendMessage(ChatColor.GREEN + "You just killed " + 
                  this.plugin.targetPlayer.getName() + "!");
              }
            } else {
              sender.sendMessage(ChatColor.RED + "You have to pick a number between 0 and 20!");
            }
          } catch (NumberFormatException nfe) {
            sender.sendMessage(ChatColor.RED + "That isn't a whole number silly!");
          }
        }
        
        if (args[2].equalsIgnoreCase("food")) {
          int limit = 20;
          String number = args[3];
          try {
            int x = Integer.parseInt(number);
            if (x <= limit) {
              if (x >= 0) {
                this.plugin.targetPlayer.setFoodLevel(x);
              }
            } else {
              sender.sendMessage(ChatColor.RED + "You have to pick a number between 0 and 20!");
            }
          } catch (NumberFormatException nfe) {
            sender.sendMessage(ChatColor.RED + "That isn't a whole number silly!");
          }
        }
        if (args[2].equalsIgnoreCase("level")) {
          int limit = 50;
          String number = args[3];
          try {
            int x = Integer.parseInt(number);
            if (x <= limit) {
              if (x >= 0) {
                this.plugin.targetPlayer.setLevel(x);
              }
            } else {
              sender.sendMessage(ChatColor.RED + "You have to pick a number between 0 and 50!");
            }
          } catch (NumberFormatException nfe) {
            sender.sendMessage("That isn't a number silly!");
          }
        }
      }
    }
    return false;
  }
}
