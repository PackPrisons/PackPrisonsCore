package com.packprisons.core.events.drug_system;

import com.packprisons.core.PackPrisonsCore;
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

    public static ShapedRecipe cocaineRecipe() {

        // Cocaine
        ItemStack cocaine = new ItemStack(DrugTypes.COCAINE.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(cocaine);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null)
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
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(meth);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null)
            compound.setString("drug", "rare");

        nmsItem.setTag(compound);
        meth = CraftItemStack.asBukkitCopy(nmsItem);

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

    public static ShapedRecipe weedRecipe() {

        // weed
        ItemStack weed = new ItemStack(DrugTypes.METH.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(weed);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null)
            compound.setString("drug", "rare");

        nmsItem.setTag(compound);
        weed = CraftItemStack.asBukkitCopy(nmsItem);

        ItemMeta im = weed.getItemMeta();
        im.setDisplayName(ChatUtil.translate(Drugs.WEED.getName()));
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        weed.setItemMeta(im);

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_weed");

        // Recipe
        ShapedRecipe recipe = new ShapedRecipe(key, weed);

        recipe.shape("TTT", "EEE", "TTT");
        recipe.setIngredient('T', Material.MILK_BUCKET);
        recipe.setIngredient('E', Material.WHEAT);

        return recipe;
    }

    public static ShapedRecipe heroinRecipe() {

        // Meth
        ItemStack heroin = new ItemStack(DrugTypes.METH.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(heroin);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null)
            compound.setString("drug", "rare");

        nmsItem.setTag(compound);
        heroin = CraftItemStack.asBukkitCopy(nmsItem);

        ItemMeta im = heroin.getItemMeta();
        im.setDisplayName(ChatUtil.translate(Drugs.HEROINE.getName()));
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        heroin.setItemMeta(im);

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_heroin");

        // Recipe
        ShapedRecipe recipe = new ShapedRecipe(key, heroin);

        recipe.shape("TTT", "EEE", "TTT");
        recipe.setIngredient('T', Material.COCOA);
        recipe.setIngredient('E', Material.PRISMARINE_CRYSTALS);

        return recipe;
    }

    public static ShapedRecipe opiumRecipe() {

        ItemStack opium = new ItemStack(DrugTypes.OPIUM.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(opium);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null)
            compound.setString("opium", "rare");

        nmsItem.setTag(compound);

        opium = CraftItemStack.asBukkitCopy(nmsItem);

        ItemMeta im = opium.getItemMeta();
        im.setDisplayName(Drugs.OPIUM.getName());
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addEnchant(Enchantment.SILK_TOUCH, 200, true);
        opium.setItemMeta(im);

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_opium");

        ShapedRecipe recipe = new ShapedRecipe(key, opium);

        recipe.shape("TTT", "EEE", "TTT");

        recipe.setIngredient('T', Material.PRISMARINE_SHARD);
        recipe.setIngredient('E', Material.BROWN_MUSHROOM);

        return recipe;
    }

    public static ShapedRecipe ecstasyRecipe() {

        ItemStack ecstasy = new ItemStack(DrugTypes.ECSTASY.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(ecstasy);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null)
            compound.setString("ecstasy", "rare");

        nmsItem.setTag(compound);

        ecstasy = CraftItemStack.asBukkitCopy(nmsItem);

        ItemMeta im = ecstasy.getItemMeta();
        im.setDisplayName(Drugs.ECSTASY.getName());
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addEnchant(Enchantment.SILK_TOUCH, 200, true);
        ecstasy.setItemMeta(im);

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_ecstasy");

        ShapedRecipe recipe = new ShapedRecipe(key, ecstasy);

        recipe.shape("TTT", "EEE", "TTT");
        recipe.setIngredient('T', Material.GLOWSTONE);
        recipe.setIngredient('E', Material.RED_MUSHROOM);

        return recipe;
    }

    public static ShapedRecipe flakkaRecipe() {

        ItemStack flakka = new ItemStack(DrugTypes.FLAKKA.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(flakka);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null)
            compound.setString("flakka", "legendary");

        nmsItem.setTag(compound);

        flakka = CraftItemStack.asBukkitCopy(nmsItem);

        ItemMeta im = flakka.getItemMeta();
        im.setDisplayName(Drugs.FLAKKA.getName());
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        im.addEnchant(Enchantment.SILK_TOUCH, 200, true);
        flakka.setItemMeta(im);

        NamespacedKey key = new NamespacedKey(PackPrisonsCore.getInstance(), "drug_flakka");

        ShapedRecipe recipe = new ShapedRecipe(key, flakka);

        recipe.shape("", "", "");
        recipe.setIngredient('T', Material.GOLD_INGOT);
        recipe.setIngredient('E', Material.PUMPKIN);

        return recipe;
    }
}
