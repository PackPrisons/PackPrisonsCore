package com.packprisons.core.events;

import com.packprisons.core.utils.ChatUtil;
import com.packprisons.core.utils.ConfigUtil;
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

        if (player.hasPlayedBefore()) { // Old Player
            event.setJoinMessage(ChatUtil.translate(ConfigUtil.getPLAYERJOINMessage()).replace("%player%",
                                player.getName()));
        } else { // New Player
            event.setJoinMessage(ChatUtil.translate(ConfigUtil.getNEWPLAYERJOINMessage()).replace("%player%",
                                                    player.getName()));
        }
    }
}
