package net.packprisons.core.manager;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessageManager {

    private static HashMap<Player, Player> recentlyMessaged = new HashMap<>();

    public static HashMap<Player, Player> getRecentlyMessaged() {
        return recentlyMessaged;
    }

    public static void add(Player player, Player target) {
        recentlyMessaged.put(player, target);
    }

    public static void sendMessage(Player sender, Player target, String message) {
        sender.sendColorMessage("&ato " + target.getName() + " &7" + message);
        target.sendColorMessage( "&afrom " + sender.getName() + " &7" + message);
    }
}
