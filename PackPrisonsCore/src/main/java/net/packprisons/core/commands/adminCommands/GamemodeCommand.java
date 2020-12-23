package net.packprisons.core.commands.adminCommands;

import net.packprisons.core.utils.ChatUtil;
import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand extends PackCommand {

    public GamemodeCommand() {
        super("gamemode", 1, 2);
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            //@TODO: Use a Switch Statement here

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("c") ||
                        args[0].equalsIgnoreCase("creative") ||
                        args[0].equalsIgnoreCase("1")) {

                    player.setGameMode(GameMode.CREATIVE);
                    player.sendColorMessage("&aGamemode Updated!");
                } else if (args[0].equalsIgnoreCase("s") ||
                        args[0].equalsIgnoreCase("survival") ||
                        args[0].equalsIgnoreCase("0")) {

                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendColorMessage("&aGamemode Updated!");
                } else if (args[0].equalsIgnoreCase("sp") ||
                        args[0].equalsIgnoreCase("spectator") ||
                        args[0].equalsIgnoreCase("3")) {

                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendColorMessage("&aGamemode Update");
                } else {
                    player.sendColorMessage("&cInvalid Usage! /gamemode (gamemode)");
                }
            } else if (args.length == 2) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    if (args[1].equalsIgnoreCase("s") ||
                            args[1].equalsIgnoreCase("survival") ||
                            args[1].equalsIgnoreCase("0")) {

                        target.setGameMode(GameMode.SURVIVAL);
                        player.sendColorMessage("&aGamemode Updated for " + target.getName());
                        target.sendColorMessage("&aGamemode Updated!");
                    } else if (args[1].equalsIgnoreCase("c") ||
                            args[1].equalsIgnoreCase("creative") ||
                            args[1].equalsIgnoreCase("1")) {

                        target.setGameMode(GameMode.CREATIVE);
                        player.sendColorMessage("&aGamemode Updated for " + target.getName());
                        target.sendColorMessage("&aGamemode Updated!");
                    } else if (args[1].equalsIgnoreCase("sp") ||
                            args[1].equalsIgnoreCase("spectator") ||
                            args[1].equalsIgnoreCase("3")) {

                        target.setGameMode(GameMode.SPECTATOR);
                        player.sendColorMessage("&aGamemode Updated for " + target.getName());
                        target.sendColorMessage("&aGamemode Updated!");
                    }
                } else {
                    player.sendColorMessage("&cThis player is not online!");
                }
            }
        } else {
            sender.sendMessage(ChatUtil.translate("&cOnly a player can use this command!"));
        }
    }
}
