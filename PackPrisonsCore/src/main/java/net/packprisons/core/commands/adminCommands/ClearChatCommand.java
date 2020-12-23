package net.packprisons.core.commands.adminCommands;

import net.packprisons.core.utils.ChatUtil;
import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand extends PackCommand {

    public ClearChatCommand() {
        super("clearchat", 0, 1);
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            switch (args.length) {
                case 0:
                    for (int i = 0; i < 100; i++) {
                        Bukkit.broadcastMessage(" ");
                    }
                    player.sendColorMessage("&aChat has been successfully cleared!");
                    break;

                case 1:
                    try {
                        int chat = Integer.parseInt(args[0]);

                        for (int i = 0; i < chat; i++) {
                            Bukkit.broadcastMessage(" ");
                        }
                        player.sendColorMessage("&aSuccessfully cleared " + chat + " messages!");
                    } catch (NumberFormatException e) {
                        player.sendColorMessage("&m&e--------------------");
                        player.sendColorMessage("&cInvalid Usage! /cc (number)");
                        player.sendColorMessage("&m&e--------------------");
                    }
                    break;
            }

        } else {
           sender.sendMessage(ChatUtil.translate("&cOnly a player can use this command!"));
        }
    }
}
