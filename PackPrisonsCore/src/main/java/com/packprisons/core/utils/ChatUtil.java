package com.packprisons.core.utils;

import com.packprisons.core.PackPrisonsCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

/**
 * This class is responsible for translating color, bold, italic, etc.
 *
 * - Indeedious
 */
public class ChatUtil {

    public ChatUtil(String text) {
        translate(text);
    }

    public static String translate(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static void tell(Player player, String message) {
        if (message.contains("&")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        } else {
            player.sendMessage(message);
        }
    }

    public static void tellLater(Player player, String message, long delayedTicks) {
        if (message.contains("&")) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(PackPrisonsCore.getInstance(), new Runnable() {
                public void run() {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                }
            }, delayedTicks);
        } else {
            Bukkit.getScheduler().scheduleSyncDelayedTask(PackPrisonsCore.getInstance(), new Runnable() {
                public void run() {
                    player.sendMessage(message);
                }
            }, delayedTicks);
        }
    }

    public static void log(String message) { //@TODO: Translate messages for Console Logs
        Logger logger = Bukkit.getLogger();

        if (message.contains("&")) {
            logger.info(ChatColor.translateAlternateColorCodes('&', message));
        } else {
            logger.info(message);
        }
    }
}
