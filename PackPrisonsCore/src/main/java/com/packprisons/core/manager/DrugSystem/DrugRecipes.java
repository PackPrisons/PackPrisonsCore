package com.packprisons.core.manager.DrugSystem;

import com.packprisons.core.PackPrisonsCore;
import com.packprisons.core.manager.DrugSystem.Enums.DrugTypes;
import com.packprisons.core.manager.DrugSystem.Enums.Drugs;
import com.packprisons.core.utils.ChatUtil;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * This class handles the Recipes of all the Drugs
 *
 * These are not the Official Recipes!
 */
public class DrugRecipes {

    private static DrugItems drugItems = new DrugItems();

    public static ShapedRecipe cocaineRecipe() {

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_cocaine");

        // Recipe
        ShapedRecipe recipe = new ShapedRecipe(key, drugItems.Cocaine());

        recipe.shape(" T ", "TET", " T ");
        recipe.setIngredient('T', Material.BLAZE_POWDER);
        recipe.setIngredient('E', Material.SUGAR_CANE);

        return recipe;
    }

    public static ShapedRecipe methRecipe() {

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_meth");

        // Recipe
        ShapedRecipe recipe = new ShapedRecipe(key, drugItems.Meth());

        recipe.shape("TTT", "EEE", "TTT");
        recipe.setIngredient('T', Material.COAL);
        recipe.setIngredient('E', Material.NETHER_WARTS);

        return recipe;
    }

    public static ShapedRecipe weedRecipe() {

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_weed");

        // Recipe
        ShapedRecipe recipe = new ShapedRecipe(key, drugItems.Weed());

        recipe.shape("TTT", "EEE", "TTT");
        recipe.setIngredient('T', Material.MILK_BUCKET);
        recipe.setIngredient('E', Material.WHEAT);

        return recipe;
    }

    public static ShapedRecipe heroinRecipe() {

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_heroin");

        // Recipe
        ShapedRecipe recipe = new ShapedRecipe(key, drugItems.Heroine());

        recipe.shape("TTT", "EEE", "TTT");
        recipe.setIngredient('T', Material.COCOA);
        recipe.setIngredient('E', Material.PRISMARINE_CRYSTALS);

        return recipe;
    }

    public static ShapedRecipe opiumRecipe() {

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_opium");

        ShapedRecipe recipe = new ShapedRecipe(key, drugItems.Opium());

        recipe.shape("TTT", "EEE", "TTT");

        recipe.setIngredient('T', Material.PRISMARINE_SHARD);
        recipe.setIngredient('E', Material.BROWN_MUSHROOM);

        return recipe;
    }

    public static ShapedRecipe ecstasyRecipe() {

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_ecstasy");

        ShapedRecipe recipe = new ShapedRecipe(key, drugItems.Ecstasy());

        recipe.shape("TTT", "EEE", "TTT");
        recipe.setIngredient('T', Material.GLOWSTONE);
        recipe.setIngredient('E', Material.RED_MUSHROOM);

        return recipe;
    }

    public static ShapedRecipe flakkaRecipe() {

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_flakka");

        ShapedRecipe recipe = new ShapedRecipe(key, drugItems.Flakka());

        recipe.shape("", "", "");
        recipe.setIngredient('T', Material.GOLD_INGOT);
        recipe.setIngredient('E', Material.PUMPKIN);

        return recipe;
    }
}
