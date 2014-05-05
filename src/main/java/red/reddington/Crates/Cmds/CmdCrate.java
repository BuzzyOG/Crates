package red.reddington.Crates.Cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import red.reddington.Crates.Crates;

import java.util.UUID;

/**
 * Created by Ryan on 5/3/2014.
 */
public class CmdCrate implements CommandExecutor {
    Crates instance = Crates.getInstance();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("crate")) { //Yeah /crate give {name} {key} {amount}
            if (sender instanceof Player) {                   //     args[0] 1   2     3
                Player player = (Player) sender;
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Error: Not enough arguments. Do /crate help for help!");
                }
                if(args.length > 0){
                    if (args[0].equalsIgnoreCase("give")) {
                        if (player.hasPermission("crates.give")) {
                            try {
                                System.out.println();
                                String giveTo = args[1];
                                String key = args[2];
                                int keyAmount = Integer.parseInt(args[3]);
                                Player playerTo = Bukkit.getPlayer(giveTo);
                                UUID uniqueID = player.getUniqueId();
                                String uniequeIDString = uniqueID.toString();
                                System.out.println(giveTo + key + playerTo);
                                instance.getKeyManager().addKeys(playerTo, key, keyAmount);
                            } catch (Exception ex) {
                                player.sendMessage(ChatColor.RED + "Error: Inorrect args. Do /crate help!");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
