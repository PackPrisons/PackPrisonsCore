package com.packprisons.core.events.drug_system;

import com.packprisons.core.PackPrisonsCore;
import com.packprisons.core.utils.ChatUtil;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagString;
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
 */
public class DrugRecipe {

    public static ShapedRecipe cocaineRecipe() {

        // Cocaine
        ItemStack cocaine = new ItemStack(DrugTypes.COCAINE.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(cocaine);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        compound.setString("cocaine", "rare");

        nmsItem.setTag(compound);
        cocaine = CraftItemStack.asBukkitCopy(nmsItem);

        ItemMeta im = cocaine.getItemMeta();

        im.setDisplayName(ChatUtil.translate(Drugs.COCAINE.getName()));
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        cocaine.setItemMeta(im);

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_cocaine");

        // Recipe
        ShapedRecipe recipe = new ShapedRecipe(key, cocaine);

        recipe.shape("TTT", "EEE", "TTT");
        recipe.setIngredient('T', Material.BLAZE_POWDER);
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

    /*public static ShapedRecipe weedRecipe() {

    }

    public static ShapedRecipe heroinRecipe() {

    }

    public static ShapedRecipe opiumRecipe() {

    }

    public static ShapedRecipe ecstasyRecipe() {

    }

    public static ShapedRecipe flakkaRecipe() {

    }*/
}
