package net.packprisons.core;

import net.packprisons.core.commands.FlyCommand;
import net.packprisons.core.commands.PingCommand;
import net.packprisons.core.commands.TPACommand;
import net.packprisons.core.commands.adminCommands.*;
import net.packprisons.core.commands.HelpCommand;
import net.packprisons.core.commands.privateMessage.MessageCommand;
import net.packprisons.core.commands.privateMessage.ReplyCommand;
import net.packprisons.core.events.PlayerChat;
import net.packprisons.core.events.PlayerJoin;
import net.packprisons.core.events.PlayerQuit;
import net.packprisons.core.events.commandEvents.PlayerAFK;
import net.packprisons.core.manager.DrugSystem.Events.DrugEvents;
import net.packprisons.core.manager.DrugSystem.DrugRecipes;
import net.packprisons.core.utils.commandUtils.PackCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * This is class initializes and registers all the classes/commands/events
 * <p>
 * This plugin will be responsible for Gangs, Cartels, Mafia's, Drugs, crafting store, money, custom items, etc, all of the key features of this server
 */
public final class PackPrisonsCore extends JavaPlugin {

    private static PackPrisonsCore instance;

    public static HashMap<String, PackCommand> commands;

    @Override
    public void onEnable() {
        instance = this;
        commands = new HashMap<String, PackCommand>();

        loadConfig();
        registerCommands();
        registerRecipes();
        registerEvents();
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void registerCommands() {
        new FlyCommand();
        new MessageCommand();
        new ReplyCommand();
        new VanishCommand();
        new GamemodeCommand();
        new HelpCommand();
        new TPACommand();
        new ClearChatCommand();
        new TPALLCommand();
        new TPCommand();
        new InventorySeeCommand();
        new PingCommand();
        new HealCommand();
        new FeedCommand();
    }

    public void registerRecipes() {
        Bukkit.addRecipe(DrugRecipes.cocaineRecipe());
        Bukkit.addRecipe(DrugRecipes.methRecipe());
        Bukkit.addRecipe(DrugRecipes.weedRecipe());
        Bukkit.addRecipe(DrugRecipes.ecstasyRecipe());
        Bukkit.addRecipe(DrugRecipes.heroinRecipe());
        Bukkit.addRecipe(DrugRecipes.opiumRecipe());
        Bukkit.addRecipe(DrugRecipes.flakkaRecipe());
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new DrugEvents(), this);
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerAFK(), this);
        pm.registerEvents(new PlayerChat(), this );
    }

    public static PackPrisonsCore getInstance() { return instance; }

    @Override
    public void onDisable() {
        instance = null;
        commands.clear();
    }
}
