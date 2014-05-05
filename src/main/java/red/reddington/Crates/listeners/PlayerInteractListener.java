package red.reddington.Crates.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 5/3/2014.
 */
public class PlayerInteractListener implements Listener {
    private static List<String> inChestMode = new ArrayList<String>();
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

    }
}
