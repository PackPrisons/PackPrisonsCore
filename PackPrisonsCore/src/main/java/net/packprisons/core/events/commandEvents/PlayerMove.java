package net.packprisons.core.events.commandEvents;

import net.packprisons.core.commands.TPACommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

/**
 * This class detects whether or not a player has moved in order to work side by side with the "TPACommand" Class
 */
public class PlayerMove implements Listener {

    public ArrayList<Player> still = new ArrayList<>();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        TPACommand command = new TPACommand();
        Player player = event.getPlayer();

        still.remove(player);

        if (command.tpa.containsKey(player) && command.tpa.get(player) != null) {
            if (event.isCancelled()) {
                still.add(player);
            }
        }
    }
}
