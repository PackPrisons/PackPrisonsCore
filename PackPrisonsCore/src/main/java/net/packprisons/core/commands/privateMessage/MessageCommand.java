package net.packprisons.core.commands.privateMessage;

import net.packprisons.core.manager.MessageManager;
import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessageCommand extends PackCommand {

    public MessageCommand() {
        super("message", 2, 256);
    }

    // Maximum amount of chars a player can send = 256

    //@TODO: Finish this command, make it configurable, use the upcoming API when sending messages - Indeedious

    @Override
    public void run(CommandSender sender, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            HashMap<Player, Player> recentlyMessaged = MessageManager.getRecentlyMessaged();

            if (args.length <= 1) {
                player.sendColorMessage("&4Please enter username and message!");
            }

            if (args.length >= 2) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
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
}
