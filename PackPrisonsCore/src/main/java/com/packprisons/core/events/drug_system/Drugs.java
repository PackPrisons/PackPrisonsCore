package com.packprisons.core.events.drug_system;

import com.packprisons.core.utils.ChatUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Drugs {

    COCAINE(ChatUtil.translate("&f&lCOCAINE"), Material.SUGAR, 2468, 1),
    METH(ChatUtil.translate("&e&lMETH"), Material.NETHER_WARTS, 2345, 1),
    WEED(ChatUtil.translate("&a&lWEED"), Material.WHEAT, 2246, 1),
    HEROINE(ChatUtil.translate("&c&lHEROINE"), Material.PRISMARINE_CRYSTALS, 2149, 1),
    OPIUM(ChatUtil.translate("&c&lOPIUM"), Material.MELON_SEEDS, 2054,1),
    ECSTASY(ChatUtil.translate("&d&lECSTASY"), Material.GLOWSTONE_DUST, 1986, 1),
    FLAKKA(ChatUtil.translate("&b&lFLAKKA"), Material.PUMPKIN_SEEDS, 1689, 1);

    private final ItemStack item;
    private final String name;
    private final int id;

    Drugs (String name, Material material, int id,  int amount) {
        item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        if (meta != null)
        meta.setDisplayName(name);

        this.name = name;
        this.id = id;
    }

    public ItemStack getItem() { return item; }
    public String getName() { return name; }
    public int getID() { return id; }
}
