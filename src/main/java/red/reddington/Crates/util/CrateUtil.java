package red.reddington.crates.util;

import org.bukkit.Location;
import red.reddington.crates.Crates;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan on 5/6/2014.
 */
public class CrateUtil {
    private static Map<Location, String> loadedCrates = new HashMap<Location, String>();
    private Crates instance;
    private CrateUtil(Crates instance){
        this.instance = instance;
    }

}
