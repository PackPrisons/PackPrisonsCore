package net.packprisons.core.commands.privateMessage;

import net.packprisons.core.manager.MessageManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessageCommand implements CommandExecutor {

    //@TODO: Finish this command, make it configurable, use the upcoming API when sending messages - Indeedious

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            HashMap<Player, Player> recentlyMessaged = MessageManager.getRecentlyMessaged();

            if (command.getName().equalsIgnoreCase("message")) {
                if (args.length <= 1) {
                    player.sendColorMessage("&4Please enter username and message!");
                }

                if(args.length >= 2) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        StringBuilder message = new StringBuilder();

                        for (int i = 1; i < args.length; i++) {
                            message.append(args[i]).append(" ");
                        }

                        MessageManager.sendMessage(player, target, message.toString());

                        recentlyMessaged.put(player, target);
                        MessageManager.add(player, target);
                    }
                }


            }

        }
        return false;
    }
}
