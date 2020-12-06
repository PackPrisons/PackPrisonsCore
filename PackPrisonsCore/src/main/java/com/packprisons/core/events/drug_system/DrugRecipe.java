package com.packprisons.core.events.drug_system;

import com.packprisons.core.PackPrisonsCore;
import com.packprisons.core.utils.ChatUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * This class handles the Recipes of all the Drugs
 */
public class DrugRecipe {

    public static ShapedRecipe cocaineRecipe() {

        // Cocaine
        ItemStack cocaine = new ItemStack(DrugTypes.COCAINE.getMaterial());
        ItemMeta im = cocaine.getItemMeta();
        im.setDisplayName(ChatUtil.translate(Drugs.COCAINE.getName()));
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        cocaine.setItemMeta(im);

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_cocaine");

        // Recipe
        ShapedRecipe recipe = new ShapedRecipe(key, cocaine);

        recipe.shape("TTT", "EEE", "TTT");
        recipe.setIngredient('T', Material.FIREBALL);
        recipe.setIngredient('E', Material.SUGAR_CANE);

        return recipe;
    }

    public static ShapedRecipe methRecipe() {

        // Meth
        ItemStack meth = new ItemStack(DrugTypes.METH.getMaterial());
        ItemMeta im = meth.getItemMeta();
        im.setDisplayName(ChatUtil.translate(Drugs.METH.getName()));
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        meth.setItemMeta(im);

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_meth");

        // Recipe
        ShapedRecipe recipe = new ShapedRecipe(key, meth);

        recipe.shape("TTT", "EEE", "TTT");
        recipe.setIngredient('T', Material.COAL);
        recipe.setIngredient('E', Material.NETHER_WARTS);

        return recipe;
    }
}
