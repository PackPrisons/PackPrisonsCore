package com.packprisons.core.commands;

import com.packprisons.core.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class VanishCommand implements CommandExecutor {

    private final ArrayList<UUID> vanishEnabled = new ArrayList<>();
    private final ArrayList<GameMode> pastGamemode = new ArrayList<>();

    /**
     *
     * @TODO: Finish this Vanish Command
     *
     * It might be beneficial to use a Switch Statement instead of if-else statements.
     */

    @Deprecated
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        // Add a permissions check here

        if (args.length == 0) {

            pastGamemode.add(player.getGameMode());

            if (vanishEnabled.contains(player.getUniqueId())) { // On Disable
                vanishEnabled.remove(player.getUniqueId());

                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.canSee(player);
                }

                ChatUtil.tell(player, "&e&lVanish Disabled!");
                player.setGameMode(GameMode.valueOf(String.valueOf(pastGamemode.get(0))));
            } else { // On Enable
                vanishEnabled.add(player.getUniqueId());

                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.hidePlayer(player);
                }

                player.setGameMode(GameMode.SPECTATOR);
                player.playEffect(player.getLocation(), Effect.SMOKE, 0);

                ChatUtil.tell(player, "&a&lVanish Enabled!");
            }
        } else if (args.length == 1) {

            Player target = Bukkit.getPlayerExact(args[0]);

            if (target != null) {
                if (args[0].equalsIgnoreCase(target.getName())) {
                    if (vanishEnabled.contains(target.getUniqueId())) { // On Disable
                        vanishEnabled.remove(target.getUniqueId());

                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.canSee(target);
                        }

                        ChatUtil.tell(player, "&e&lYou have Disabled Vanish for " + target.getName());
                        ChatUtil.tell(target, "&e&lVanish Disabled!");
                    } else { // On Enable
                        vanishEnabled.add(target.getUniqueId());

                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.hidePlayer(target);
                        }

                        target.setGameMode(GameMode.SPECTATOR);

                        ChatUtil.tell(target, "&a&lVanish Enabled!");
                        ChatUtil.tell(player, "&a&lVanish has been enabled for " + target.getName());
                    }
                }
            } else {
                ChatUtil.tell(player, "&eThis player is not online!");
                return true;
            }
        } else {
            ChatUtil.tell(player, "&eInvalid Usage! /vanish");
            return true;
        }
        return false;
    }
}
