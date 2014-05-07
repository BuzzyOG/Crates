package red.reddington.Crates.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import red.reddington.Crates.CrateManager;
import red.reddington.Crates.Crates;

/**
 * Created by Ryan on 5/5/2014.
 */
public class BlockPlaceListener implements Listener {
    private static Crates instance;
    public BlockPlaceListener(Crates instance){
        this.instance = instance;
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if(instance.getCrateManager().isInCrateCreateMode(player)){
            instance.getCrateManager().addNewCrate(event.getBlock().getLocation(), instance.getCrateManager().getTypeToCreate(player));
            player.sendMessage(ChatColor.RED+"You have created a " +instance.getCrateManager().getTypeToCreate(player)+" crate at this location. Breaking it will not remove it from the config as of this version.");
        }
    }
}

