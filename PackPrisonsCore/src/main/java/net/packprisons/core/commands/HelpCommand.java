package net.packprisons.core.commands;

import net.md_5.bungee.api.chat.TextComponent;
import net.packprisons.core.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        /* if (!player.hasPermission("")) {
        }*/

        if (args.length == 0) {
            TextComponent faq = new TextComponent(ChatUtil.translate("&a> &cYou any questions you need answered? "));
        } else {
            player.sendColorMessage( "&eInvalid Usage! /help");
            return true;
        }

        return false;
    }
}
