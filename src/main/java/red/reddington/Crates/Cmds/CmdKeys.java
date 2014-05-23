package red.reddington.crates.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import red.reddington.crates.Crates;

import java.util.concurrent.ExecutionException;

/**
 * Created by Ryan on 5/9/2014.
 */
public class CmdKeys implements CommandExecutor {
    private Crates instance = Crates.getInstance();
    @EventHandler
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("keys")) {
            if(sender.hasPermission("crates.admin")) { // We do not check if the sender is a player due to the fact people run these commands via console for buycraft and voting and whatnot
                if (args.length > 3) {
                    try {
                        String addTo = args[1];
                        if (args[0].equalsIgnoreCase("give")) {
                            instance.getKeyManager().addKeys(addTo, args[2], Integer.parseInt(args[3]));
                            sender.sendMessage("Added keys successfully.");
                        }
                        if (args[0].equalsIgnoreCase("take")) {
                            instance.getKeyManager().takeKeys(addTo, args[2], Integer.parseInt(args[3]));
                            sender.sendMessage("Taken keys successfully.");
                        }
                        if (args[0].equalsIgnoreCase("set")) {
                            instance.getKeyManager().setKeys(addTo, args[2], Integer.parseInt(args[3]));
                            sender.sendMessage("Set keys successfully.");
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
}
