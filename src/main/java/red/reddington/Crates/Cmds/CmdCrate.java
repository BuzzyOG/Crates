package red.reddington.crates.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import red.reddington.crates.Crates;

import java.util.UUID;

/**
 * Created by Ryan on 5/3/2014.
 */
public class CmdCrate implements CommandExecutor {
    Crates instance = Crates.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("crates")) { //Yeah /crate give {name} {key} {amount}
            if (sender instanceof Player) {                   //     args[0] 1   2     3
                Player player = (Player) sender;
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Error: Not enough arguments. Do /crate help for help!");
                }
                if(args.length > 0){
                    if (args[0].equalsIgnoreCase("give")) {
                        if (player.hasPermission("crates.give")) {
                            try {
                                String giveTo = args[1];
                                String key = args[2];
                                int keyAmount = Integer.parseInt(args[3]);
                                Player playerTo = Bukkit.getPlayer(giveTo);
                                UUID uniqueID = player.getUniqueId();
                                String uniequeIDString = uniqueID.toString();
                                instance.getKeyManager().addKeys(playerTo, key, keyAmount);
                            } catch (Exception ex) {
                                player.sendMessage(ChatColor.RED + "Error: Inorrect args. Do /crate help!");
                            }
                        }
                    }
                    if(args[0].equalsIgnoreCase("create")){
                        if(player.hasPermission("crates.create")){  //Crate create {keyname}
                            if(instance.getKeyManager().keyExists(args[1]) && !instance.getCrateManager().isInCrateCreateMode(player)){
                                player.sendMessage(ChatColor.RED+"You have received a chest in your inventory. Every chest you place will be treated and saved as a crate. Do /crates exit to get out of this mode!");
                                instance.getCrateManager().addToCrateMode(player, args[1]);
                                player.getInventory().addItem(new ItemStack(Material.CHEST));
                            }else{
                                player.sendMessage(ChatColor.RED+"Error: You cannot create a a crate at this time.");
                            }
                        }
                    }
                    if(args[0].equalsIgnoreCase("exit")){
                        if(instance.getCrateManager().isInCrateCreateMode(player)){
                            instance.getCrateManager().removeFromCrateCreateMode(player);
                            player.sendMessage(ChatColor.RED+"You have been removed from crate mode.");
                        }
                    }
                }
            }
        }
        return false;
    }
}
