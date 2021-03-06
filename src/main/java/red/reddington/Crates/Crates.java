package red.reddington.crates;

import org.bukkit.plugin.java.JavaPlugin;
import red.reddington.crates.cmds.CmdCMessage;
import red.reddington.crates.cmds.CmdCrate;
import red.reddington.crates.cmds.CmdKeys;
import red.reddington.crates.config.KeyStatsConfig;
import red.reddington.crates.keys.KeyManager;
import red.reddington.crates.listeners.BlockPlaceListener;
import red.reddington.crates.listeners.PlayerInteractListener;
import red.reddington.crates.listeners.PlayerJoinListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 5/3/2014.
 */
public class Crates extends JavaPlugin{

    private static Crates instance;
    private static List<String> loadedKeyNames = new ArrayList<String>();
    KeyStatsConfig ksc = new KeyStatsConfig(this);
    private KeyManager keymanager = new KeyManager(this);
    private CrateManager crateManager = new CrateManager(this);
    public void onEnable(){
        instance = this;
        this.saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);
        getCommand("crates").setExecutor(new CmdCrate());
        getCommand("cmessage").setExecutor(new CmdCMessage());
        getCommand("keys").setExecutor(new CmdKeys());
        ksc.saveDefaultKeyConfig();
        ksc.getConfig().options().copyDefaults(true);
        this.getCrateManager().loadCrates();
        this.registerEvents();
    }

    public void onDisable(){
        instance = null;
    }
    public static Crates getInstance() {
        return instance;
    }
    public void registerEvents(){
        this.getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new BlockPlaceListener(this), this);
    }

    public static List<String> getLoadedKeyNames() {
        return loadedKeyNames;
    }

    public KeyStatsConfig getKeyConfig() {
        return ksc;
    }

    public KeyManager getKeyManager() {
        return keymanager;
    }

    public CrateManager getCrateManager() {
        return crateManager;
    }
}