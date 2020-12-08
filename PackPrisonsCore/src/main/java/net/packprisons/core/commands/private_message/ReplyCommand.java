package net.packprisons.core.commands.private_message;

import net.packprisons.core.manager.MessageManager;
import net.packprisons.core.utils.ConfigUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ReplyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        // if (!player.hasPermission("")) {

        //}
        HashMap<Player, Player> recentlyMessaged = MessageManager.getRecentlyMessaged();

     if (command.getName().equalsIgnoreCase("reply")) {
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
                     player.sendColorMessage( "&eThis player is not online!");
                     return true;
                 }
             } else {
                 player.sendColorMessage( "&bNo one has messaged you!");
                 return true;
             }

         } else {
             player.sendColorMessage(ConfigUtil.getPMSInvalidUsage().replace("/msg (player) (message)",
                     "/r (message)"));
             return true;
         }
     }
        return false;
    }
}
