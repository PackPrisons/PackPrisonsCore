package net.packprisons.core.events;

import net.packprisons.core.utils.ConfigUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * This class handles all of the events that happen when a player joins the Server
 */
public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage(null);

        if(!player.hasPlayedBefore()) {
            player.sendColorMessage(ConfigUtil.getNEWPLAYERJOINMessage().replace("%player%", player.getName()));
        } else {
            player.sendColorMessage(ConfigUtil.getPLAYERJOINMessage().replace("%player%", player.getName()));
        }
    }
}
