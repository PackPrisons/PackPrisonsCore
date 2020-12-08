package net.packprisons.core.manager.DrugSystem.Enums;

import net.packprisons.core.utils.ChatUtil;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Drugs {

    COCAINE(ChatUtil.translate("&f&lCOCAINE"), DrugTypes.COCAINE, 2468, 1),
    METH(ChatUtil.translate("&e&lMETH"), DrugTypes.METH, 2345, 1),
    WEED(ChatUtil.translate("&a&lWEED"), DrugTypes.WEED, 2246, 1),
    HEROINE(ChatUtil.translate("&c&lHEROINE"), DrugTypes.HEROINE, 2149, 1),
    OPIUM(ChatUtil.translate("&c&lOPIUM"), DrugTypes.OPIUM, 2054,1),
    ECSTASY(ChatUtil.translate("&d&lECSTASY"), DrugTypes.ECSTASY, 1986, 1),
    FLAKKA(ChatUtil.translate("&b&lFLAKKA"), DrugTypes.FLAKKA, 1689, 1);

    private final ItemStack item;
    private final String name;
    private final int id;

    Drugs (String name, DrugTypes material, int id,  int amount) {
        item = new ItemStack(material.getMaterial(), amount);
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
