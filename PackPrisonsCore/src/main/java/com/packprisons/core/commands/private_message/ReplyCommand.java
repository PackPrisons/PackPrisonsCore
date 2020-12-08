package com.packprisons.core.commands.private_message;

import com.packprisons.core.PackPrisonsCore;
import com.packprisons.core.manager.MessageManager;
import com.packprisons.core.utils.ChatUtil;
import com.packprisons.core.utils.ConfigUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ReplyCommand implements CommandExecutor {

    private final PackPrisonsCore plugin;

    public ReplyCommand(PackPrisonsCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        /*if (!player.hasPermission("")) {

        }*/
        HashMap<Player, Player> recentlyMessaged = MessageManager.getRecentlyMessaged();

        if (args.length > 0) {
            if (recentlyMessaged.containsKey(player)) {
                if (recentlyMessaged.get(player) != null) {

                    Player target = recentlyMessaged.get(player);

                    StringBuilder message = new StringBuilder();

                    for (int i = 0; i < args.length; i++) {
                        message.append(args[i]).append(" ");
                    }

                    ChatUtil.tell(player, "&ato " + target.getName() + " &7" + message.toString());
                    ChatUtil.tell(target, "&afrom " + player.getName() + " &7" + message.toString());
                } else {
                    ChatUtil.tell(player, "&eThis player is not online!");
                    return true;
                }
            } else {
                ChatUtil.tell(player, "&bNo one has messaged you!");
                return true;
            }

        } else {
            ChatUtil.tell(player, ConfigUtil.getPMSInvalidUsage().replace("/msg (player) (message)",
                    "/r (message)"));
            return true;
        }
        return false;
    }
}
