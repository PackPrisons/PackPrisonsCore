package com.packprisons.core.utils;

import org.bukkit.ChatColor;

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
}
