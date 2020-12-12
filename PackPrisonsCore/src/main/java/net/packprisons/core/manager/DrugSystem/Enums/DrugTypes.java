package net.packprisons.core.manager.DrugSystem.Enums;

import org.bukkit.Material;

public enum DrugTypes {

    COCAINE(Material.SUGAR),
    METH(Material.COCOA),
    WEED(Material.WHEAT),
    HEROINE(Material.PRISMARINE_CRYSTALS),
    OPIUM(Material.GHAST_TEAR),
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
