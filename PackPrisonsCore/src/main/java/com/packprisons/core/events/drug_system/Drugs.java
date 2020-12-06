package com.packprisons.core.events.drug_system;

import com.packprisons.core.utils.ChatUtil;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Drugs {

    COCAINE(ChatUtil.translate("&f&lCOCAINE"), Material.SUGAR, 1),
    METH(ChatUtil.translate("&e&lMETH"), Material.NETHER_WART, 1),
    WEED(ChatUtil.translate("&a&lWEED"), Material.WHEAT, 1),
    HEROINE(ChatUtil.translate("&c&lHEROINE"), Material.PRISMARINE_CRYSTALS, 1),
    OPIUM(ChatUtil.translate("&c&lOPIUM"), Material.MELON_SEEDS, 1),
    ECSTASY(ChatUtil.translate("&d&lECSTASY"), Material.GLOWSTONE_DUST, 1),
    FLAKKA(ChatUtil.translate("&b&lFLAKKA"), Material.PUMPKIN_SEEDS, 1);

    private final ItemStack item;
    private final Material material;
    private final int amount;
    private String name;

    Drugs (String name, Material material, int amount) {
        item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        if (meta != null)
        meta.setDisplayName(name);

        this.material = material;
        this.amount = amount;
        this.name = name;

    }

    public ItemStack getItem() { return new ItemStack(material, amount); }
    public String getName() { return name; }
}
