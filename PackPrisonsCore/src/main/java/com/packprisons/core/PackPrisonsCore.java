package com.packprisons.core;

import com.packprisons.core.commands.FlyCommand;
import com.packprisons.core.commands.VanishCommand;
import com.packprisons.core.commands.private_message.MessageCommand;
import com.packprisons.core.commands.private_message.ReplyCommand;
import com.packprisons.core.events.Player_Join;
import com.packprisons.core.events.drug_system.DrugEvents;
import com.packprisons.core.events.drug_system.DrugRecipes;
import com.packprisons.core.manager.MessageManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This is class initializes and registers all the classes/commands/events
 * <p>
 * This plugin will be responsible for Gangs, Cartels, Mafia's, Drugs, crafting store, money, custom items, etc, all of the key features of this server
 */
public final class PackPrisonsCore extends JavaPlugin {

    private MessageManager messageManager;
    private static PackPrisonsCore instance;

    @Override
    public void onEnable() {
        instance = this;

        loadConfig();
        registerCommands();
        registerRecipes();
        registerEvents();
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
    }

    public void registerCommands() {
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("message").setExecutor(new MessageCommand(this));
        getCommand("reply").setExecutor(new ReplyCommand(this));
        getCommand("vanish").setExecutor(new VanishCommand());
    }

    public void registerRecipes() {
        Bukkit.addRecipe(DrugRecipes.cocaineRecipe());
        Bukkit.addRecipe(DrugRecipes.methRecipe());
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new DrugEvents(), this);
        pm.registerEvents(new Player_Join(), this);
    }

    public static PackPrisonsCore getInstance() { return instance; }
}
