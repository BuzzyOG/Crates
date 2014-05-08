package red.reddington.Crates.listeners;

import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import red.reddington.Crates.Crates;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 5/3/2014.
 */
public class PlayerInteractListener implements Listener {

    private Crates instance;
    public PlayerInteractListener(Crates instance){
        this.instance = instance;
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getClickedBlock().getType() == Material.CHEST){
            if(event.getClickedBlock().getState() instanceof Chest){
                if(instance.getCrateManager().getLoadedCrates().containsKey(event.getClickedBlock().getLocation())){
                    Chest chest = (Chest) event.getClickedBlock().getState();
                    event.setCancelled(true);
                    instance.getCrateManager().runRandomCrateTask(instance.getCrateManager().getCratesKey(event.getClickedBlock().getLocation()), event.getPlayer());
                    event.getPlayer().sendMessage("Debugg");
                }
            }
        }
    }
}