package com.packprisons.core.events.drug_system;

import com.packprisons.core.utils.ChatUtil;
import org.bukkit.Material;

public enum DrugTypes {

    COCAINE(Material.SUGAR),
    METH(Material.NETHER_WARTS),
    WEED(Material.WHEAT),
    HEROINE(Material.PRISMARINE_CRYSTALS),
    OPIUM(Material.MELON_SEEDS),
    ECSTASY(Material.GLOWSTONE_DUST),
    FLAKKA(Material.PUMPKIN_SEEDS);

    private final Material material;
    private final int id;

    DrugTypes(Material material) {
        this.material = material;
        this.id = material.getId();
    }

    public Material getMaterial() {
        return material;
    }

    public int getId() {
        return id;
    }
}
