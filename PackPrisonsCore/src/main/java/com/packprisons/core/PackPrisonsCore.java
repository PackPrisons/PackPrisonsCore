package com.packprisons.core;

import com.packprisons.core.commands.FlyCommand;
import com.packprisons.core.events.drug_system.DrugEvents;
import com.packprisons.core.events.drug_system.DrugRecipe;
import com.packprisons.core.events.drug_system.DrugTypes;
import com.packprisons.core.events.drug_system.Drugs;
import com.packprisons.core.manager.MessageManager;
import com.packprisons.core.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
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
//        registerCommands();
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
    }

    public void registerRecipes() {
        Bukkit.addRecipe(DrugRecipe.cocaineRecipe());
        Bukkit.addRecipe(DrugRecipe.methRecipe());
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new DrugEvents(), this);
    }

    public static PackPrisonsCore getInstance() { return instance; }
}
