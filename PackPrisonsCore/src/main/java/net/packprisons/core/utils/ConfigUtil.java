package net.packprisons.core.utils;

import net.packprisons.core.PackPrisonsCore;

public class ConfigUtil {

    /**
     * @return Private Message System Configuration Messages
     */
    public static String getPMSInvalidUsage() {
        return PackPrisonsCore.getInstance().getConfig().getString("private-message-system.invalid-usage");
    }

    public static String getPMSInvalidPlayer() {
        return PackPrisonsCore.getInstance().getConfig().getString("private-message-system.invalid-player");
    }

    public static String getSENDERMessage() {
        return PackPrisonsCore.getInstance().getConfig().getString("private-message-system.sent-message");
    }

    public static String getTARGETMessage() {
        return PackPrisonsCore.getInstance().getConfig().getString("private-message-system.incoming-message");
    }

    public static String getREPLYMessage() {
        return PackPrisonsCore.getInstance().getConfig().getString("private-message-system.reply-message");
    }

    public static String getREPLIEDMessage() {
        return PackPrisonsCore.getInstance().getConfig().getString("private-message-system.replied-message");
    }

    /**
     *
     * @return Player Join Configuration Messages
     */
    public static String getPLAYERJOINMessage() {
        return PackPrisonsCore.getInstance().getConfig().getString("player-join.join-message");
    }

    public static String getNEWPLAYERJOINMessage() {
        return PackPrisonsCore.getInstance().getConfig().getString("player-join.newJoin-message");
    }
}
