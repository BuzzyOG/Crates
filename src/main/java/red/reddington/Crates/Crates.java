package red.reddington.Crates;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import red.reddington.Crates.Cmds.CmdCrate;
import red.reddington.Crates.config.KeyStatsConfig;
import red.reddington.Crates.keys.KeyManager;
import red.reddington.Crates.listeners.PlayerInteractListener;
import red.reddington.Crates.listeners.PlayerJoinListener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Ryan on 5/3/2014.
 */
public class Crates extends JavaPlugin{

    private static Crates instance;
    private static List<String> loadedKeyNames = new ArrayList<String>();
    KeyStatsConfig ksc = new KeyStatsConfig(this);
    private KeyManager keymanager = new KeyManager(this);
    public void onEnable(){
        instance = this;
        this.saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);
        getCommand("crate").setExecutor(new CmdCrate());
        ksc.saveDefaultKeyConfig();
        ksc.getConfig().options().copyDefaults(true);
        this.registerEvents();
        Bukkit.getLogger().log(Level.INFO, keymanager.getLoadedKeys().length +" key's loaded!");

    }
    public void onDisable(){
        instance = null;
        keymanager = null;
    }

    public static Crates getInstance() {
        return instance;
    }

    public void registerEvents(){
        this.getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
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
}