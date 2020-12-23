package net.packprisons.core.commands;

import net.packprisons.core.PackPrisonsCore;
import net.packprisons.core.utils.ChatUtil;
import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand extends PackCommand {

    PackPrisonsCore plugin = PackPrisonsCore.getPlugin(PackPrisonsCore.class);

    public FlyCommand() {
        super("fly", 0, 1);
    }

    /**
     *
     * @TODO: Re-do this Fly Command
     */
    @Override
    public void run(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0 && sender != null) {
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.setFlying(false);

                player.sendColorMessage(plugin.getConfig().getString("messages.fly.fly-off"));
            } else {
                player.setAllowFlight(true);
                player.setFlying(true);

                player.sendColorMessage(plugin.getConfig().getString("messages.fly.fly-on"));
            }
        } else {
            assert sender != null;
            sender.sendMessage(ChatUtil.translate("&cInvalid Usage: /fly <player>"));
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatUtil.translate("&cPlayer not found."));
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
    }
}
