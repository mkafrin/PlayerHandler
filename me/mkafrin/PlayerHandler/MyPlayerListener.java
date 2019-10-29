package me.mkafrin.PlayerHandler;

import java.util.HashMap;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class MyPlayerListener implements org.bukkit.event.Listener
{
  public static PlayerHandler plugin;

  public MyPlayerListener(PlayerHandler instance)
  {
    plugin = instance;
  }

  @EventHandler
  public void onPlayerChat(AsyncPlayerChatEvent event) {
    Player player = event.getPlayer();
    if ((plugin.chatmute) &&
      (!player.hasPermission("playerhandler.admin")) &&
      (!player.isOp())) {
      event.setCancelled(true);
      player.sendMessage(org.bukkit.ChatColor.RED + "Chat is disabled at the moment!");
      return;
    }


    if (plugin.targetmute.containsKey(player)) {
      event.setCancelled(true);
      player.sendMessage(org.bukkit.ChatColor.RED + "Your chat is disabled at the moment!");
    }
  }

  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event) {
    Player player = event.getPlayer();
    if (plugin.freezemap.containsKey(player)) {
      Location locFrom = event.getFrom();
      Location locTo = event.getTo();
      if ((locFrom.getZ() != locTo.getZ()) || (locFrom.getX() != locTo.getX()) || (locFrom.getY() != locTo.getY()))
        event.setTo(new Location(player.getWorld(), locFrom.getX(), locFrom.getY(), locFrom.getZ()));
    }
  }

  @EventHandler
  public void onBlockPlace(org.bukkit.event.block.BlockPlaceEvent event) {
    Player player = event.getPlayer();
    if (plugin.freezemap.containsKey(player)) {
      event.setCancelled(true);
    }
    if (plugin.onblockplace.containsKey(player))
      event.setCancelled(true);
  }

  @EventHandler
  public void onBlockBreak(BlockBreakEvent event) {
    Player player = event.getPlayer();
    if (plugin.freezemap.containsKey(player)) {
      event.setCancelled(true);
    }
    if (plugin.onblockbreak.containsKey(player))
      event.setCancelled(true);
  }

  @EventHandler
  public void onPlayerCommand(org.bukkit.event.player.PlayerCommandPreprocessEvent event) {
    Player player = event.getPlayer();
    if ((plugin.freezemap.containsKey(player)) &&
      (!plugin.targetPlayer.hasPermission("playerhandler.admin")) &&
      (!plugin.targetPlayer.isOp())) {
      event.setCancelled(true);
    }


    if (plugin.command.containsKey(player)) {
      event.setCancelled(true);
      plugin.targetPlayer.sendMessage(org.bukkit.ChatColor.RED + "Your command usage is disabled at the moment!");
    }
  }
}
