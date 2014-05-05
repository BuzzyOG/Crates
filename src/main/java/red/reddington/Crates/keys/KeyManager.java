package red.reddington.Crates.keys;

import org.bukkit.entity.Player;
import red.reddington.Crates.Crates;
import red.reddington.Crates.Exceptions.NotValidKeyException;
import red.reddington.Crates.Exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ryan on 5/4/2014.
 */
public class KeyManager {
    private static Crates instance;
    public KeyManager(Crates instance){
        this.instance = instance;
    }

    /**
     * @return's a string array of all the loaded keys.
     *
     */
    public String[] getLoadedKeys(){
        String[] arr = instance.getConfig().getConfigurationSection("keys").getKeys(false).toArray(new String[instance.getConfig().getConfigurationSection("keys").getKeys(false).size()]);
        return arr;
    }
    /**
     *Adds keys on players join if they already not entered.
     */
    public void addDefaultKeys(Player p){
        for(String keyname: getLoadedKeys()){
            if(instance.getKeyConfig().getConfig().getString(p.getUniqueId()+"."+keyname) == null){
                instance.getKeyConfig().getConfig().addDefault(p.getUniqueId()+"."+keyname, "0");
                instance.getKeyConfig().saveKeyConfig();
            }
        }
    }
    /**
     * Add keys to a user
     */
    public void addKeys(Player p, String keytype, int amount){
        if(Arrays.asList(getLoadedKeys()).contains(keytype)){
            if(instance.getKeyConfig().getConfig().contains(p.getUniqueId().toString())){
                instance.getKeyConfig().getConfig().set(p.getUniqueId()+"."+keytype, instance.getKeyConfig().getConfig().getInt(p.getUniqueId()+"."+keytype)+amount);
                instance.getKeyConfig().saveKeyConfig();
            }else{
                throw new UserNotFoundException("User not found.");
            }
        }else{
            throw new NotValidKeyException("Not a valid key type!");
        }
    }
    public void takeKeys(Player p, String keytype, int amount){
        if(Arrays.asList(getLoadedKeys()).contains(keytype)){
            if(instance.getKeyConfig().getConfig().contains(p.getUniqueId().toString())){
                instance.getKeyConfig().getConfig().set(p.getUniqueId()+"."+keytype, instance.getKeyConfig().getConfig().getInt(p.getUniqueId()+"."+keytype)-amount);
                instance.getKeyConfig().saveKeyConfig();
            }else{
                throw new UserNotFoundException("User not found.");
            }
        }else{
            throw new NotValidKeyException("Not a valid key type!");
        }
    }
    public void setKeys(Player p, String keytype, int amount){
        if(Arrays.asList(getLoadedKeys()).contains(keytype)){
            if(instance.getKeyConfig().getConfig().contains(p.getUniqueId().toString())){
                instance.getKeyConfig().getConfig().set(p.getUniqueId()+"."+keytype, amount);
                instance.getKeyConfig().saveKeyConfig();
            }else{
                throw new UserNotFoundException("User not found.");
            }
        }else{
            throw new NotValidKeyException("Not a valid key type!");
        }
    }
}
