package net.packprisons.core.utils.commandUtils;

import net.packprisons.core.PackPrisonsCore;
import net.packprisons.core.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CMDExecutor implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(PackPrisonsCore.commands.containsKey(label)) {
            if(sender.hasPermission("pluginName." + label)) {

                PackCommand pack = PackPrisonsCore.commands.get(label);

                if(args.length >= pack.minArgs && args.length <= pack.maxArgs) {
                    pack.run(sender, args);
                } else {
                    sender.sendMessage(ChatUtil.translate("&cInvalid Usage!"));
                }
            } else {
                sender.sendMessage(ChatUtil.translate("&cYou do not have permission to use this command!"));
            }
        }
        return false;
    }
}
