package com.packprisons.core.commands;

import com.packprisons.core.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand extends CommandUtil implements CommandExecutor {

    protected HelpCommand() {
        super("help");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        checkConsole();

        Player player = (Player) sender;

        /* if (!player.hasPermission("")) {
        }*/

        if (args.length == 0) {
            //@TODO: Use textcomponents for the messages
        } else {
            ChatUtil.tell(player, "&eInvalid Usage! /help");
            return true;
        }

        return false;
    }
}
