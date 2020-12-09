package net.packprisons.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("teleport")) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

                //if (!player.hasPermission("")) {

                //}

                switch (args.length) {
                    case 1:
                        Player target = Bukkit.getPlayer(args[0]);

                        if (target != null) {
                            if (args[0].equalsIgnoreCase(target.getName())) {
                                player.teleport(target.getLocation());

                                player.sendColorMessage("&aTeleported to " + target.getName());
                                target.sendColorMessage("&a" + player.getName() + " has Teleported to you!");
                            }
                        } else {
                            player.sendColorMessage("&cThis player is not online!");
                            return true;
                        }
                        break;

                    case 2:
                        Player target2 = Bukkit.getPlayer(args[1]);
                        target = Bukkit.getPlayer(args[0]);

                        if (target2 != null) {
                            if (args[1].equalsIgnoreCase(target2.getName())) {
                                target.teleport(target2.getLocation());

                                target.sendColorMessage("&aTeleported to " + target2.getName());
                                target2.sendColorMessage("&a" + target.getName() + " has Teleported to you!");
                            }
                        } else {
                            player.sendColorMessage("&cThis player is not online!");
                        }
                        break;

                    default:
                        break;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
