package net.packprisons.core.commands.adminCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("heal")) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

                // Add a permissions check here

                switch (args.length) {
                    case 0:
                        player.setHealth(20.0);
                        player.sendColorMessage("&aYou've been brought back to full Health!");
                        break;

                    case 1:
                        Player target = Bukkit.getPlayer(args[0]);

                        if (target != null) {
                            if (args[0].equalsIgnoreCase(target.getName())) {
                                target.setHealth(20.0);
                                target.sendColorMessage("&aYou've been brought back to full Health!");

                                player.sendColorMessage("&aSuccessfully healed " + target.getName() + "!");
                            }
                        } else {
                            player.sendColorMessage("&m&e--------------------");
                            player.sendColorMessage("&cThis player is not online!");
                            player.sendColorMessage("&m&e--------------------");
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
