package net.packprisons.core.commands.privateMessage;

import net.packprisons.core.manager.MessageManager;
import net.packprisons.core.utils.ConfigUtil;
import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ReplyCommand extends PackCommand {

    public ReplyCommand() {
        super("reply", 1, 256);
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        if (sender instanceof Player) {


            Player player = (Player) sender;

            HashMap<Player, Player> recentlyMessaged = MessageManager.getRecentlyMessaged();

            if (args.length > 0) {
                if (recentlyMessaged.containsKey(player)) {
                    if (recentlyMessaged.get(player) != null) {

                        Player target = recentlyMessaged.get(player);

                        StringBuilder message = new StringBuilder();

                        for (int i = 0; i < args.length; i++) {
                            message.append(args[i]).append(" ");
                        }

                        MessageManager.sendMessage(player, target, message.toString());

                    } else {
                        player.sendColorMessage("&eThis player is not online!");
                    }
                } else {
                    player.sendColorMessage("&bNo one has messaged you!");
                }

            } else {
                player.sendColorMessage(ConfigUtil.getPMSInvalidUsage().replace("/msg (player) (message)",
                        "/r (message)"));
            }
        }
    }
}
