package net.packprisons.core;

import net.packprisons.core.commands.FlyCommand;
import net.packprisons.core.commands.PingCommand;
import net.packprisons.core.commands.TPACommand;
import net.packprisons.core.commands.adminCommands.*;
import net.packprisons.core.commands.HelpCommand;
import net.packprisons.core.commands.private_message.MessageCommand;
import net.packprisons.core.commands.private_message.ReplyCommand;
import net.packprisons.core.events.PlayerJoin;
import net.packprisons.core.events.PlayerQuit;
import net.packprisons.core.events.commandEvents.PlayerMove;
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
        getCommand("help").setExecutor(new HelpCommand());
        getCommand("tpa").setExecutor(new TPACommand());
        getCommand("clearchat").setExecutor(new ClearChatCommand());
        getCommand("tpall").setExecutor(new TPALLCommand());
        getCommand("invsee").setExecutor(new InventorySeeCommand());
        getCommand("ping").setExecutor(new PingCommand());
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
        pm.registerEvents(new PlayerMove(), this);
    }

    public static PackPrisonsCore getInstance() { return instance; }
}
