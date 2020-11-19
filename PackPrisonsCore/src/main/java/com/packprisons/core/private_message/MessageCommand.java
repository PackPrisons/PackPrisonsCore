package com.packprisons.core.private_message;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            //@TODO: Finish this Message Command, and allow the players rank to be seen in messages once the Rank plugin is created
        } else {
            return true;
        }
        return false;
    }
}
