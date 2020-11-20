package com.packprisons.core;

import com.packprisons.core.commands.FlyCommand;
import com.packprisons.core.manager.MessageManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This is class initializes and registers all the classes/commands/events
 * <p>
 * This plugin will be responsible for Gangs, Cartels, Mafia's, Drugs, crafting store, money, custom items, etc, all of the key features of this server
 */
public final class PackPrisonsCore extends JavaPlugin {

    private MessageManager messageManager;

    @Override
    public void onEnable() {
        loadConfig();
        registerCommands();
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }

    @Override
    public void onDisable() {

    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        ;
    }

    public void registerCommands() {
        getCommand("fly").setExecutor(new FlyCommand());
    }

}
