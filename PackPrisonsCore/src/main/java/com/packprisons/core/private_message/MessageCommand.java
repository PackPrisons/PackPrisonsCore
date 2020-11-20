package com.packprisons.core.private_message;

import com.packprisons.core.PackPrisonsCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {

    private final PackPrisonsCore plugin;

    public MessageCommand(PackPrisonsCore plugin) {
        this.plugin = plugin;
    }

    //@TODO: Finish this command, make it configurable, use the upcoming API when sending messages - Indeedious

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;
            Player target = Bukkit.getPlayerExact(args[0]);

            if (args.length >= 2) {
                if (target != null) {
                    if (args[0].equalsIgnoreCase(target.getName())) {

                        StringBuilder message = new StringBuilder();

                        for (int i = 0; i < args.length; i++) {
                            message.append(args[i]).append(" ");
                        }

                        player.sendMessage(ChatColor.GREEN + "to " + target.getName() + ChatColor.GRAY + message.toString());
                        target.sendMessage(ChatColor.GREEN + "from " + player.getName() + ChatColor.GRAY + message.toString());

                        plugin.getMessageManager().recentlyMessaged.put(player, target);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Player cannot be found!");
                    return true;
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid Usage! /msg <player> <message>");
                return true;
            }
            //@TODO: Finish this Message Command, and allow the players rank to be seen in messages once the Rank plugin is created
        } else {
            return true;
        }
        return false;
    }
}
