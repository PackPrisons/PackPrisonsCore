package net.packprisons.core.events.commandEvents;

import net.packprisons.core.PackPrisonsCore;
import net.packprisons.core.manager.AFKManager;
import net.packprisons.core.utils.ChatUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

/**
 * This class detects whether or not the Player is AFK
 */
public class PlayerAFK implements Listener {

    private HashMap<Player, Location> afkManager = AFKManager.getAFK();
    private HashMap<Player, Long> afkTimeManager = AFKManager.getAFKTime();

    private int count = 0;
    private int chat = 0;

    public boolean checkActivity(Player player, Location location) {
        new BukkitRunnable() {
            public void run() {
                if (afkManager.containsKey(player)) {
                    Location previousLocation = afkManager.get(player);

                    if (previousLocation != null) {
                        Location currentLocation = player.getLocation();

                        if (currentLocation == previousLocation) {
                            count *= 1000L;

                            if (!(afkTimeManager.containsKey(player) && afkTimeManager.get(player) > System.currentTimeMillis())) {
                                afkTimeManager.put(player, (long) count);
                            } else {
                                long longRemaining = afkTimeManager.get(player) - System.currentTimeMillis();
                                int intRemaining = (int) longRemaining / 1000;

                                if (intRemaining == 0) {
                                    player.kickPlayer(ChatUtil.translate("&cYou have been kicked for being &e&lAFK"));
                                }

                                if (intRemaining < 11 && intRemaining > 0) {
                                    for (int i = 0; i < intRemaining; i++) {
                                        player.sendColorMessage("&cYou're about to be kicked in " + intRemaining + " seconds!");
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }.runTaskTimerAsynchronously(PackPrisonsCore.getInstance(), 0, 20L);

        return count > System.currentTimeMillis(); // True = Kick Player, False = Add to HashMap
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) { // Check if the player has moved
        Player player = event.getPlayer();

        if (event.isCancelled()) {
            afkManager.put(player, player.getLocation());
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) { // Check if the player has spoken
        Player player = event.getPlayer();

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) { // Check if the player has interacted with something
        Player player = event.getPlayer();

    }
}
