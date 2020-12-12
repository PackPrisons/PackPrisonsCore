package net.packprisons.core.commands.adminCommands;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * - bug with Vanish Command, still not able to see the Player even while there in Vanish
 */
public class VanishCommand implements CommandExecutor {

    private final ArrayList<UUID> vanishEnabled = new ArrayList<>();
    private final HashMap<Player, GameMode> pastGameMode = new HashMap<>();

    @Deprecated
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        // Add a permissions check here

        if (args.length == 0) {

            pastGameMode.put(player, player.getGameMode());

            if (vanishEnabled.contains(player.getUniqueId())) { // On Disable
                vanishEnabled.remove(player.getUniqueId());

                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.canSee(player);
                }

                player.sendColorMessage("&e&lVanish Disabled!");
                player.setGameMode(pastGameMode.get(player));
            } else { // On Enable
                vanishEnabled.add(player.getUniqueId());

                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.hidePlayer(player);
                }

                player.setGameMode(GameMode.SPECTATOR);
                player.playEffect(player.getLocation(), Effect.SMOKE, 0);

                player.sendColorMessage( "&a&lVanish Enabled!");
            }
        } else if (args.length == 1) {

            Player target = Bukkit.getPlayerExact(args[0]);

            if (target != null) {
                if (args[0].equalsIgnoreCase(target.getName())) {
                    pastGameMode.put(target, target.getGameMode());

                    if (vanishEnabled.contains(target.getUniqueId())) { // On Disable
                        vanishEnabled.remove(target.getUniqueId());

                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.canSee(target);
                        }

                        player.sendColorMessage( "&c&lYou have Disabled Vanish for " + target.getName());
                        target.sendColorMessage( "&c&lVanish Disabled!");
                        target.setGameMode(pastGameMode.get(target));
                    } else { // On Enable
                        vanishEnabled.add(target.getUniqueId());

                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.hidePlayer(target);
                        }

                        target.setGameMode(GameMode.SPECTATOR);

                        target.sendColorMessage( "&a&lVanish Enabled!");
                        player.sendColorMessage( "&a&lVanish has been enabled for " + target.getName());
                    }
                }
            } else {
                player.sendColorMessage("&eThis player is not online!");
                return true;
            }
        } else {
            player.sendColorMessage("&eInvalid Usage! /vanish");
            return true;
        }
        return false;
    }
}
