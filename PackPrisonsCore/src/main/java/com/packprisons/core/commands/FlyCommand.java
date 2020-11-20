package com.packprisons.core.commands;

import com.packprisons.core.PackPrisonsCore;
import com.packprisons.core.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    PackPrisonsCore plugin = PackPrisonsCore.getPlugin(PackPrisonsCore.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0 && sender != null) {
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.setFlying(false);
                player.sendMessage(ChatUtil.translate(plugin.getConfig().getString("messages.fly.fly-off")));
            } else {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage(ChatUtil.translate(plugin.getConfig().getString("messages.fly.fly-on")));
            }
            return true;
        } else {
            assert sender != null;
            sender.sendMessage(ChatUtil.translate("&cInvalid Usage: /fly <player>"));
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatUtil.translate("&cPlayer not found."));
            return true;
        }
        if (target.getAllowFlight()) {
            target.setAllowFlight(false);
            target.setFlying(false);
            target.sendMessage(ChatUtil.translate(plugin.getConfig().getString("messages.fly.fly-off")));
            sender.sendMessage(ChatUtil.translate(plugin.getConfig().getString("messages.fly.fly-off-other")).replace("%player%", target.getName()));
        } else {
            target.setAllowFlight(true);
            target.setFlying(true);
            target.sendMessage(ChatUtil.translate(plugin.getConfig().getString("messages.fly.fly-on")));
            sender.sendMessage(ChatUtil.translate(plugin.getConfig().getString("messages.fly.fly-on-other")).replace("%player%", target.getName()));
        }
        return true;
    }
}
