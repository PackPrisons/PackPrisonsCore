package net.packprisons.core.commands.adminCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("clearchat")) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

                //if (!player.hasPermission("")) {

                //}

                switch (args.length) {
                    case 0:
                        for (int i = 0; i < 100; i++) {
                            Bukkit.broadcastMessage(" ");
                        }
                        player.sendColorMessage("&aChat has been successfully cleared!");
                        break;

                    case 1:
                        try {
                            int chat = Integer.parseInt(args[0]);

                            for (int i = 0; i < chat; i++) {
                                Bukkit.broadcastMessage(" ");
                            }
                            player.sendColorMessage("&aSuccessfully cleared " + chat + " messages!");
                        } catch (NumberFormatException e) {
                            player.sendColorMessage("&cInvalid Usage! /cc (number)");
                            return true;
                        }
                        break;
                }

            } else {
                return true;
            }
        }
        return false;
    }
}
