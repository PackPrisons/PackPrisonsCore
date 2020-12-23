package net.packprisons.core.commands;

import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCommand extends PackCommand {

    public PingCommand() { super("ping", 0, 0); }

    @Override
    public void run(CommandSender sender, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 0) {
                int ping = ((CraftPlayer) player).getHandle().ping;
                player.sendColorMessage("&cPing: &a" + ping + "ms");
            } else {
                player.sendColorMessage("&cInvalid Usage! /ping");
            }
        }
    }
}
