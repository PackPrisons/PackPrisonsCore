package net.packprisons.core.utils.commandUtils;

import net.packprisons.core.PackPrisonsCore;
import org.bukkit.command.CommandSender;

public abstract class PackCommand  {

    public String label;
    public int minArgs;
    public int maxArgs;

    /**
     * @param label - The label of the command.
     * @param minArgs - The minimum amount of arguments.
     * @param maxArgs - The maximum amount of arguments.
     */
    public PackCommand(String label, int minArgs, int maxArgs)
    {
        this.label = label;
        this.minArgs = minArgs;
        this.maxArgs = maxArgs;

        PackPrisonsCore.getInstance().getCommand(label).setExecutor(new CMDExecutor());
        PackPrisonsCore.commands.put(label, this);
    }

    //This method will process the command.
    public abstract void run(CommandSender sender, String[] args);
}
