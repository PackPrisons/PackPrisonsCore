package net.packprisons.core.commands;

import net.packprisons.core.utils.commandUtils.HelpCommandUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand extends HelpCommandUtil implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        /* if (!player.hasPermission("")) {
        }*/

        if (args.length == 0) {
            super.buildHelpMessage(player, "&9&lPackPrisons",
                    "&b&lCheck out our FAQ!",
                    "&b&lCheck out our Support Page!",
                    "&b&lReport Rule Breakers Here!",
                    "&b&lCheck out our Rules Here!",
                    "&b&lCheck out our Forums Here!",
                    "&a> &bHave any questions?",
                    "&a> &bHave an issue with a purchase?",
                    "&a> &bSee someone breaking the rules?",
                    "&a> &bWant to avoid getting in trouble?",
                    "&a> &bStill have questions or need more support?",
                    "&eClick Here!",
                    "&eClick Here!",
                    "&eClick Here!",
                    "&eClick Here!",
                    "&eClick Here!",
                    "https://www.packprisons.net",
                    "https://www.packprisons.net",
                    "https://www.packprisons.net",
                    "https://www.packprisons.net",
                    "https://www.packprisons.net",
                    "&a> &eMake sure to follow us on Twitter! &b@PackPrisons");
        } else {
            player.sendColorMessage("&eInvalid Usage! /help");
            return true;
        }

        return false;
    }
}
