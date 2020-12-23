package net.packprisons.core.commands;

import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class TPACommand extends PackCommand {

    /**
     * 1.) Check for the Targets name
     * 2.) Have the player get 10 seconds to accept the TPA or else it'll be cancelled
     */

    public HashMap<Player, Long> cooldown = new HashMap<>();

    public TPACommand() {
        super("tpa", 1, 1);
    }

    /**
     * @TODO: Bug with accepting the TPA; fix the HashMaps/ArrayLists in order to store the player and the "time".
     */

    @Override
    public void run(CommandSender sender, String[] args) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

                if (args.length == 1) { // tpa (player)
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        if (args[0].equalsIgnoreCase(target.getName())) {
                            if (!(cooldown.containsKey(player) && cooldown.get(player) > System.currentTimeMillis())) {

                            } else {
                                long longRemaining = cooldown.get(player) - System.currentTimeMillis();
                                int intRemaining = (int) longRemaining / 1000;

                                if (intRemaining == 0) {
                                    target.sendColorMessage("&c" + player.getName() + " did not accept your TPA request!");
                                    return;
                                } else if (intRemaining == 1) {
                                    player.sendColorMessage("&cYou have " + intRemaining + " second to accept to accept " +
                                            target.getName() + "'s TPA request!");
                                }

                                player.sendColorMessage("&cYou have " + intRemaining + " seconds to accept to accept " +
                                        target.getName() + "'s TPA request!");
                            }
                        }
                    } else {
                        player.sendColorMessage("&cPlayer is not online!");
                    }
                } else {
                    player.sendColorMessage("&cInvalid Usage! /tpa (player)");
                }
            }
        }
    }

