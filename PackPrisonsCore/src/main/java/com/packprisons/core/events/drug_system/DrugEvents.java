package com.packprisons.core.events.drug_system;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
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
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(event.getItem());

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (compound != null)
                if (compound.hasKey("cocaine")) {
                    player.sendColorMessage("&aLets get high!");
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 2), true);

                    event.getItem().setAmount(event.getItem().getAmount() - 1);
                }
        }
    }
}
