package com.packprisons.core.commands.private_message;

import com.packprisons.core.PackPrisonsCore;
import com.packprisons.core.manager.MessageManager;
import com.packprisons.core.utils.ChatUtil;
import com.packprisons.core.utils.ConfigUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

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

            HashMap<Player, Player> recentlyMessaged = MessageManager.getRecentlyMessaged();

            if (args.length >= 2) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (args[0].equalsIgnoreCase(target.getName())) {

                        StringBuilder message = new StringBuilder();

                        for (int i = 1; i < args.length; i++) {
                            message.append(args[i]).append(" ");
                        }

                        //player.sendMessage(ChatColor.GREEN + "to " + target.getName() + ChatColor.GRAY + message.toString());
                        //target.sendMessage(ChatColor.GREEN + "from " + player.getName() + ChatColor.GRAY + message.toString());
                        ChatUtil.tell(player, "&ato " + target.getName() + " &7" + message.toString());
                        ChatUtil.tell(target, "&afrom " + player.getName() + " &7" + message.toString());

                        recentlyMessaged.put(player, target);
                        MessageManager.add(player, target);
                    }
                } else {
                    // player.sendMessage(ChatColor.RED + "Player cannot be found!");
                    ChatUtil.tell(player, ConfigUtil.getPMSInvalidPlayer());
                    return true;
                }
            } else {
                // player.sendMessage(ChatColor.RED + "Invalid Usage! /msg <player> <message>");
                ChatUtil.tell(player, ConfigUtil.getPMSInvalidUsage());
                return true;
            }
            //@TODO: Finish this Message Command, and allow the players rank to be seen in messages once the Rank plugin is created
        } else {
            return true;
        }
        return false;
    }
}
