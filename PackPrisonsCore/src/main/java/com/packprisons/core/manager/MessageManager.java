package com.packprisons.core.manager;

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

    public void sendMessage(Player sender, Player target, String message) {
        //@TODO: Make it so that this method can easily send the message of a player in the PMS
    }
}
