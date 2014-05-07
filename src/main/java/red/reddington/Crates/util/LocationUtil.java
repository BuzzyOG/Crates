package red.reddington.Crates.util;

import org.bukkit.Location;
import red.reddington.Crates.Crates;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 5/6/2014.
 */
public class LocationUtil {
    private static List<Location> loadedChestsLocations = new ArrayList<Location>();
    private Crates instance;
    private LocationUtil(Crates instance){
        this.instance = instance;
    }
    public void loadCrates(){
        for(int i = 0; instance.getConfig().getConfigurationSection("crates").getKeys(false).size() >= i; i++){

        }
    }
    public String getCrateType(Location loc){
    /*    if(loadedChestsLocations.contains()){

        }*/
        return "";
    }
}
