package red.reddington.crates.util;

import org.bukkit.ChatColor;
import red.reddington.crates.Crates;

/**
 * Created by Ryan on 5/26/2014.
 */
public class MessageUtil {

    private static String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Mystery-Crates" + ChatColor.DARK_GRAY + "] ";
    private static String[] cratesMessage = {ChatColor.DARK_GRAY + "------------------", ChatColor.GREEN +""+ChatColor.BOLD+ "Mystery Crates", ChatColor.GRAY + "You are running version " + ChatColor.BOLD+Crates.getInstance().getDescription().getVersion(), ChatColor.AQUA+"Fast Support: https://twitter.com/RenegadeEagle", ChatColor.GRAY + "For help do /crates help", ChatColor.DARK_GRAY+"------------------"};


    public static String getPrefix() {
        return prefix;
    }

    public static String[] getCratesMessage() {
        return cratesMessage;
    }
}
