package net.packprisons.core.manager;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class AFKManager {

    // Store the Player and the amount of time they've been moving/chatting in here,
    // create a runnable that checks if there still moving after 13 minutes

    public static HashMap<Player, Location> afk = new HashMap<>();

    public static HashMap<Player, Long> afkTime = new HashMap<>();

    public static HashMap<Player, Location> getAFK() {
        return afk;
    }

    public static HashMap<Player, Long> getAFKTime() {
        return afkTime;
    }

    public static void addAFK(Player player, Location location) {
        afk.put(player, location);
    }

    public static void addAFKTime(Player player, Long time) {
        afkTime.put(player, time);
    }
}
