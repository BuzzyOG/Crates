package red.reddington.Crates;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan on 5/5/2014.
 */
public class CrateManager {
    private Crates instance;
    public CrateManager(Crates instance){
        this.instance = instance;
    }
    private static Map<String, String> crateCreate = new HashMap<String, String>();

    /**
     * Remove a player from crate mode.
     * @param p
     */
    public void removeFromCrateCreateMode(Player p){
        crateCreate.remove(p.getName());
    }

    /**
     * Add a player to crateMode
     * @param p
     * @param keytype
     */
    public void addToCrateMode(Player p, String keytype){
        if(instance.getKeyManager().keyExists(keytype)){
            crateCreate.put(p.getName(), keytype);
        }
    }
    public String getTypeToCreate(Player p){
        return  crateCreate.get(p.getName());
    }
    /**
     *
     * @param p
     * @return Returns of a player is in crate create mode.
     */
    public boolean isInCrateCreateMode(Player p){
        if(crateCreate.get(p.getName()) != null){
            return true;
        }else{
            return false;
        }
    }
    public String[] getLoadedCrates(){
        instance.saveConfig();
        String[] arr = instance.getConfig().getConfigurationSection("crates").getKeys(false).toArray(new String[instance.getConfig().getConfigurationSection("crates").getKeys(false).size()]);
        System.out.println(arr.toString());
        return arr;
    }

    public void addNewCrate(Location loc, String keytype){
        int size = this.getLoadedCrates().length+1;
        instance.getConfig().addDefault("crates.crate"+size+".world", loc.getWorld().getName());
        instance.getConfig().addDefault("crates.crate"+size+".X", loc.getX());
        instance.getConfig().addDefault("crates.crate"+size+".Y", loc.getY());
        instance.getConfig().addDefault("crates.crate"+size+".Z", loc.getZ());
        instance.getConfig().addDefault("crates.crate"+size+".type", keytype);
        instance.saveConfig();
    }
    public static Map<String, String> getCrateCreate() {
        return crateCreate;
    }
}
