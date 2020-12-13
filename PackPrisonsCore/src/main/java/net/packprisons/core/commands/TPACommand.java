package net.packprisons.core.commands;

import net.packprisons.core.events.commandEvents.PlayerMove;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class TPACommand implements CommandExecutor {

    public HashMap<Player, Location> tpa = new HashMap<>();
    public HashMap<Player, Long> cooldown = new HashMap<>();
    private final PlayerMove move = new PlayerMove();

    /**
     * @TODO: Bug with accepting the TPA; fix the HashMaps/ArrayLists in order to store the player and the "time".
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("tpa")) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        if (args[0].equalsIgnoreCase(target.getName())) {
                            target.sendColorMessage("&a" + player.getName() + " " +
                                    "&ehas requested to teleport to you! Type" + "&a/tpa confirm" + " &eto accept it.");

                            tpa.put(player, target.getLocation());
                        } else if (args[0].equalsIgnoreCase("accept")) {
                            if (tpa.containsKey(player) &&
                                    tpa.get(player) != null) {
                                if (!(cooldown.containsKey(player) && cooldown.get(player) > System.currentTimeMillis())) {
                                        cooldown.put(player, System.currentTimeMillis() + (7 * 1000));
                                } else {
                                    if (move.still.contains(player)) {
                                        long longRemaining = cooldown.get(player) - System.currentTimeMillis();
                                        int intRemaining = (int) longRemaining / 1000;

                                        if (intRemaining == 0) {
                                            player.sendColorMessage("&eYou've successfully been teleported to &a" + target.getName());

                                            player.teleport(tpa.get(player));
                                            cooldown.remove(player);
                                            tpa.remove(player, target.getLocation());
                                        }

                                        for (int i = 0; i < intRemaining; i++) {
                                            player.sendColorMessage("&cYou are going to be Teleported in &e" + i + " seconds");
                                        }
                                    } else {
                                        player.sendColorMessage("&cTPA Has been canceled!");
                                        cooldown.remove(player);
                                        tpa.remove(player, target.getLocation());
                                    }
                                }
                            } else {
                                player.sendColorMessage("&cYou haven't been sent any TPA Requests!");
                                return true;
                            }
                        } else if (args[0].equalsIgnoreCase("deny")) {
                            if (tpa.containsKey(player) &&
                                    tpa.get(player) != null) {

                                player.sendColorMessage("&a" + target.getName() + " &ahas denied your TPA Request!");
                                tpa.remove(player, target.getLocation());
                                cooldown.remove(player);
                            } else {
                                player.sendColorMessage("&cYou haven't received any TPA Requests!");
                                return true;
                            }
                        } else {
                            player.sendColorMessage("&cInvalid Usage! /tpa (player) | /tpa accept | /tpa deny");
                            return true;
                        }
                    } else {
                        player.sendColorMessage("&cThis player is not online!");
                        return true;
                    }
                }

            } else {
                return true;
            }
        }
        return false;
    }
}
