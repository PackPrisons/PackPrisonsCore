package com.packprisons.core.events.drug_system;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DrugEvents implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(Drugs.COCAINE.getName())) {
                player.sendColorMessage("&aLets get high!");
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 2), true);
            }
        }
    }
}
