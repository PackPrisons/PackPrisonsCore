package net.packprisons.core.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;

/**
 * This class handles the Chat CoolDown
 *
 *  1.) if the player says the same message multiple times for over 3 times, they have a cooldown before they can talk again
 *
 *  - Store the player
 *  - Store the time the cooldown will last
 */
public class PlayerChat implements Listener {

    private HashMap<Player, Long> cooldown = new HashMap<>();
    private HashMap<String, String> similarMessage = new HashMap<>();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        while (event.callEvent()) {
            similarMessage.put(event.getMessage(), event.getMessage());
        }

        if (similarMessage.containsKey(event.getMessage()) && similarMessage.get(event.getMessage()) != null) {
            if (event.getMessage().equals(similarMessage.get(event.getMessage()))) { // Checking if the message is similar
                if (!(cooldown.containsKey(player) && cooldown.get(player) > System.currentTimeMillis())) {
                    cooldown.put(player, System.currentTimeMillis() + (15 * 1000));

                } else {
                    long longRemaining = cooldown.get(player) - System.currentTimeMillis();
                    int intRemaining = (int) longRemaining / 1000;

                    if (intRemaining == 0) {
                        player.sendColorMessage("&m&e--------------------");
                        player.sendColorMessage("&aYou may now speak again!");
                        player.sendColorMessage("&m&e--------------------");
                        event.setCancelled(false);
                    }

                    event.setCancelled(true);

                    player.sendColorMessage("&m&e--------------------");
                    player.sendColorMessage("&cYou cannot send the same message twice!");
                    player.sendColorMessage("&cYou may speak again in " + intRemaining + " seconds!");
                    player.sendColorMessage("&m&e--------------------");
                }
            }
        }
    }
}
