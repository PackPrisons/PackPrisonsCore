package net.packprisons.core.commands.adminCommands;

import net.packprisons.core.PackPrisonsCore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class InventorySeeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("inventorysee")) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

                //if (!player.hasPermission("")) {

                //}

                if (args.length == 0) {
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
                        return true;
                    }
                } else {
                    player.sendColorMessage("&cInvalid Usage! /invsee (player)");
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
