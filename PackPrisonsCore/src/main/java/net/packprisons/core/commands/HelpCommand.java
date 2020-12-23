package net.packprisons.core.commands;

import net.packprisons.core.utils.commandUtils.HelpCommandUtil;
import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand extends PackCommand {

    public HelpCommand() { super("help", 0, 0); }

    /**
     *
     * @TODO: Fix the bugs that display in the Help Message
     */
    @Override
    public void run(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            HelpCommandUtil.buildHelpMessage(player, "&9&lPackPrisons",
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
        }
    }
}
