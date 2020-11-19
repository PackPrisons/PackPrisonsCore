package com.packprisons.core;

import com.packprisons.core.manager.MessageManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This is class initializes and registers all the classes/commands/events
 */
public final class PackPrisonsCore extends JavaPlugin {

    private MessageManager messageManager;

    @Override
    public void onEnable() {

    }

    public MessageManager getMessageManager() { return messageManager; }

    @Override
    public void onDisable() {

    }
}
