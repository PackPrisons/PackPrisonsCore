package net.packprisons.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("ping")) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

                if (args.length == 0) {
                    int ping = ((CraftPlayer) player).getHandle().ping;
                    player.sendColorMessage("&aPing: &e" + ping + "ms");
                } else {
                    player.sendColorMessage("&cInvalid Usage! /ping");
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
