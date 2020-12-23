package net.packprisons.core.commands.adminCommands;

import net.packprisons.core.utils.ChatUtil;
import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPCommand extends PackCommand {

    public TPCommand() {
        super("tp", 1, 2);
    }

    @Override
    public void run(CommandSender sender, String[] args) {
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
            sender.sendMessage(ChatUtil.translate("&cOnly a player can use this command!"));
        }
    }
}
