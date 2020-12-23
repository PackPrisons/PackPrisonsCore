package net.packprisons.core.commands.adminCommands;

import net.packprisons.core.utils.ChatUtil;
import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPALLCommand extends PackCommand {

    public TPALLCommand() {
        super("tpall", 1, 1);
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            // if (!player.hasPermission("")) {

            //}

            if (args.length == 1) {
                player.sendColorMessage("&aSuccessfully teleported all online servers to you!");

                for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                    onlinePlayers.teleport(player.getLocation());
                }
            } else {
                player.sendColorMessage("&cInvalid Usage! /tpall (player)");
            }
        } else {
            sender.sendMessage(ChatUtil.translate("&cOnly a player can use this command!"));
        }
    }
}
