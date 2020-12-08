package net.packprisons.core.utils.register;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * This class is responsible for creating and registering our Commands.
 */
public class PackCommand extends Command {

    protected PackCommand(String name) {
        super(name);
    }

    /**
     *
     * @param sender The player sending the command
     * @param commandLabel
     * @param args The extra arguments of the command
     * @return
     */

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        return false;
    }
}
