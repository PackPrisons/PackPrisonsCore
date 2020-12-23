package net.packprisons.core.commands.adminCommands;

import net.packprisons.core.utils.ChatUtil;
import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand extends PackCommand {

    public FeedCommand() {
        super("feed", 0, 1);
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            // Add a permissions check here

            switch (args.length) {
                case 0:
                    player.setFoodLevel(20);
                    player.sendColorMessage("&aYou've been brought back to full Hunger!");
                    break;

                case 1:
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        if (args[0].equalsIgnoreCase(target.getName())) {
                            target.setFoodLevel(20);
                            target.sendColorMessage("&aYou've been brought back to full Hunger!");

                            player.sendColorMessage("&aSuccessfully fed " + target.getName() + "!");
                        }
                    } else {
                        player.sendColorMessage("&m&e--------------------");
                        player.sendColorMessage("&cThis player is not online!");
                        player.sendColorMessage("&m&e--------------------");
                    }
                    break;
            }
        } else {
           sender.sendMessage(ChatUtil.translate("&cOnly a player can use this command!"));
        }
    }
}
