package com.packprisons.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equals("gamemode")) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("c") ||
                            args[0].equalsIgnoreCase("creative") ||
                            args[0].equalsIgnoreCase("1")) {

                        player.setGameMode(GameMode.CREATIVE);
                        player.sendColorMessage("&aGamemode Updated!");
                    }
                    else if (args[0].equalsIgnoreCase("s") ||
                            args[0].equalsIgnoreCase("survival") ||
                            args[0].equalsIgnoreCase("0")) {

                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendColorMessage("&aGamemode Updated!");
                    }
                    else if (args[0].equalsIgnoreCase("sp") ||
                            args[0].equalsIgnoreCase("spectator") ||
                            args[0].equalsIgnoreCase("3")) {

                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendColorMessage("&aGamemode Update");
                } else {
                    player.sendColorMessage("&cInvalid Usage! /gamemode (gamemode)");
                    return true;
                }
            } else if (args.length == 2) {
                    Player target = Bukkit.getPrr(r(rrrrrrrrrrrrrrPlaue{
                            reti
                    }))
                    if (args[0].equalsIgnoreCase(Bukkit.getPlayer(args[0]))) {

                    }
                }
            }
        }

        return false;
    }
}
