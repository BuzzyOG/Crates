package red.reddington.Crates.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import red.reddington.Crates.Crates;

/**
 * Created by Ryan on 5/4/2014.
 */
public class PlayerJoinListener implements Listener {
    Crates instance = Crates.getInstance();
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        instance.getKeyManager().addDefaultKeys(event.getPlayer());
    }
}
