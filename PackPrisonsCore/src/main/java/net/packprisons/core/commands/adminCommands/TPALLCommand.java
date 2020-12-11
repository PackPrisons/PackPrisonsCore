package net.packprisons.core.commands.adminCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPALLCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("tpall")) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

               // if (!player.hasPermission("")) {

                //}

                if (args.length == 1) {
                    player.sendColorMessage("&aSuccessfully teleported all online servers to you!");

                    for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                        onlinePlayers.teleport(player.getLocation());
                    }
                } else {
                    player.sendColorMessage("&cInvalid Usage! /tpall (player)");
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
