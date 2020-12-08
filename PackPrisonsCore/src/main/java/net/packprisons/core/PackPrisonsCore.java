package net.packprisons.core;

import net.packprisons.core.commands.FlyCommand;
import net.packprisons.core.commands.GamemodeCommand;
import net.packprisons.core.commands.VanishCommand;
import net.packprisons.core.commands.private_message.MessageCommand;
import net.packprisons.core.commands.private_message.ReplyCommand;
import net.packprisons.core.events.PlayerJoin;
import net.packprisons.core.manager.DrugSystem.Events.DrugEvents;
import net.packprisons.core.manager.DrugSystem.DrugRecipes;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This is class initializes and registers all the classes/commands/events
 * <p>
 * This plugin will be responsible for Gangs, Cartels, Mafia's, Drugs, crafting store, money, custom items, etc, all of the key features of this server
 */
public final class PackPrisonsCore extends JavaPlugin {

    private static PackPrisonsCore instance;

    @Override
    public void onEnable() {
        instance = this;

        loadConfig();
        registerCommands();
        registerRecipes();
        registerEvents();
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
        getCommand("message").setExecutor(new MessageCommand());
        getCommand("reply").setExecutor(new ReplyCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
    }

    public void registerRecipes() {
        Bukkit.addRecipe(DrugRecipes.cocaineRecipe());
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new DrugEvents(), this);
        pm.registerEvents(new PlayerJoin(), this);
    }

    public static PackPrisonsCore getInstance() { return instance; }
}
