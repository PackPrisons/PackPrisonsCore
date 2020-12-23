package net.packprisons.core.commands.adminCommands;

import net.packprisons.core.PackPrisonsCore;
import net.packprisons.core.utils.ChatUtil;
import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InventorySeeCommand extends PackCommand {

    public InventorySeeCommand() {
        super("inventorysee", 1, 1);
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            //if (!player.hasPermission("")) {

            //}

            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    if (args[0].equalsIgnoreCase(target.getName())) {
                        player.sendColorMessage("&aSuccessfully opened the Inventory of " + target.getName());

                        Bukkit.getScheduler().scheduleSyncDelayedTask(PackPrisonsCore.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                player.getInventory().getHolder().openInventory(target.getInventory());
                            }
                        }, 20L);
                    }
                } else {
                    player.sendColorMessage("&cPlayer is not online!");
                }
            } else {
                player.sendColorMessage("&cInvalid Usage! /invsee (player)");
            }
        } else {
            sender.sendMessage(ChatUtil.translate("&cOnly a player can use this command!"));
        }
    }
}
