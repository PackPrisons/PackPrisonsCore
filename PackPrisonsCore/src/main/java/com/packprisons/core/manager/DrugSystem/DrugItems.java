package com.packprisons.core.manager.DrugSystem;

import com.packprisons.core.manager.DrugSystem.Enums.DrugTypes;
import com.packprisons.core.manager.DrugSystem.Enums.Drugs;
import com.packprisons.core.utils.ChatUtil;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DrugItems {


    public ItemStack Cocaine() {

        ItemStack cocaine = new ItemStack(DrugTypes.COCAINE.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(cocaine);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if(compound != null) {
            compound.setString("class", "A");
            compound.setInt("id", 2468);

            nmsItem.setTag(compound);
            cocaine = CraftItemStack.asBukkitCopy(nmsItem);

            ItemMeta im = cocaine.getItemMeta();

            im.setDisplayName(ChatUtil.translate(Drugs.COCAINE.getName()));
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            im.addEnchant(Enchantment.SILK_TOUCH, 1, true);
            cocaine.setItemMeta(im);
        }

        return cocaine;
    }

    public ItemStack Meth() {

        ItemStack meth = new ItemStack(DrugTypes.METH.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack  nmsItem = CraftItemStack.asNMSCopy(meth);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null) {
            compound.setString("class", "A");
            compound.setInt("id", 2345);

            nmsItem.setTag(compound);
            meth = CraftItemStack.asBukkitCopy(nmsItem);

            ItemMeta im = meth.getItemMeta();

            im.setDisplayName(Drugs.METH.getName());
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            im.addEnchant(Enchantment.SILK_TOUCH, 200, true);
            meth.setItemMeta(im);
        }

        return meth;
    }

    public ItemStack Weed() {

        ItemStack weed = new ItemStack(DrugTypes.WEED.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack  nmsItem = CraftItemStack.asNMSCopy(weed);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null) {
            compound.setString("class", "C");
            compound.setInt("id", 2246);

            nmsItem.setTag(compound);
            weed = CraftItemStack.asBukkitCopy(nmsItem);

            ItemMeta im = weed.getItemMeta();

            im.setDisplayName(Drugs.WEED.getName());
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            im.addEnchant(Enchantment.SILK_TOUCH, 200, true);
            weed.setItemMeta(im);
        }

        return weed;
    }

    public ItemStack Heroine() {

        ItemStack heroine = new ItemStack(DrugTypes.HEROINE.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack  nmsItem = CraftItemStack.asNMSCopy(heroine);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null) {
            compound.setString("class", "A");
            compound.setInt("id", 2149);

            nmsItem.setTag(compound);
            heroine = CraftItemStack.asBukkitCopy(nmsItem);

            ItemMeta im = heroine.getItemMeta();

            im.setDisplayName(Drugs.HEROINE.getName());
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            im.addEnchant(Enchantment.SILK_TOUCH, 200, true);
            heroine.setItemMeta(im);
        }

        return heroine;
    }

    public ItemStack Opium() {

        ItemStack opium = new ItemStack(DrugTypes.OPIUM.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack  nmsItem = CraftItemStack.asNMSCopy(opium);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null) {
            compound.setString("class", "B");
            compound.setInt("id", 2054);

            nmsItem.setTag(compound);
            opium = CraftItemStack.asBukkitCopy(nmsItem);

            ItemMeta im = opium.getItemMeta();

            im.setDisplayName(Drugs.OPIUM.getName());
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            im.addEnchant(Enchantment.SILK_TOUCH, 200, true);
            opium.setItemMeta(im);
        }

        return opium;
    }

    public ItemStack Ecstasy() {

        ItemStack ecstasy = new ItemStack(DrugTypes.METH.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack  nmsItem = CraftItemStack.asNMSCopy(ecstasy);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null) {
            compound.setString("class", "B");
            compound.setInt("id", 1986);

            nmsItem.setTag(compound);
            ecstasy = CraftItemStack.asBukkitCopy(nmsItem);

            ItemMeta im = ecstasy.getItemMeta();

            im.setDisplayName(Drugs.ECSTASY.getName());
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            im.addEnchant(Enchantment.SILK_TOUCH, 200, true);
            ecstasy.setItemMeta(im);
        }

        return ecstasy;
    }

    public ItemStack Flakka() {

        ItemStack flakka = new ItemStack(DrugTypes.METH.getMaterial());
        net.minecraft.server.v1_12_R1.ItemStack  nmsItem = CraftItemStack.asNMSCopy(flakka);

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (compound != null) {
            compound.setString("class", "C");
            compound.setInt("id", 1689);

            nmsItem.setTag(compound);
            flakka = CraftItemStack.asBukkitCopy(nmsItem);

            ItemMeta im = flakka.getItemMeta();

            im.setDisplayName(Drugs.FLAKKA.getName());
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            im.addEnchant(Enchantment.SILK_TOUCH, 200, true);
            flakka.setItemMeta(im);
        }

        return flakka;
    }
}
