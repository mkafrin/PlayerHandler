package me.mkafrin.PlayerHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.block.Block;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class PlayerHandler extends org.bukkit.plugin.java.JavaPlugin
{
  public final Logger logger = Logger.getLogger("Minecraft");
  public static PlayerHandler plugin;
  public final MyPlayerListener bl = new MyPlayerListener(this);
  public final HashMap<Player, ArrayList<Block>> targetmute = new HashMap();
  public final HashMap<Player, ArrayList<Block>> freezemap = new HashMap();
  public final HashMap<Player, ArrayList<Block>> onblockplace = new HashMap();
  public final HashMap<Player, ArrayList<Block>> onblockbreak = new HashMap();
  public final HashMap<Player, ArrayList<Block>> command = new HashMap();
  public Player targetPlayer;
  public boolean chatmute = false;
  
  public void onDisable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Disabled!");
  }
  
  public void onEnable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
    org.bukkit.plugin.PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(this.bl, this);
    getCommand("stopchat").setExecutor(new StopChatExecutor(this));
    getCommand("freeze").setExecutor(new FreezeExecutor(this));
    getCommand("pinfo").setExecutor(new InfoExecutor(this));
    getCommand("sinfo").setExecutor(new ServerInfoExecutor(this));
    getCommand("einfo").setExecutor(new ExtraInfoExecutor(this));
    getCommand("playerhandler").setExecutor(new HelpExecutor(this));
    getCommand("cmdstop").setExecutor(new CmdstopExecutor(this));
    getCommand("blockstop").setExecutor(new BlockstopExecutor(this));
    getConfig().options().copyDefaults(true);
    saveConfig();
  }
}
