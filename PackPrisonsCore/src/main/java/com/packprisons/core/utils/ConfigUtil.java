package com.packprisons.core.utils;

import com.packprisons.core.PackPrisonsCore;

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
