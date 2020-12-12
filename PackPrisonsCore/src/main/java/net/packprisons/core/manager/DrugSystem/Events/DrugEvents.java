package net.packprisons.core.manager.DrugSystem.Events;

import net.packprisons.core.manager.DrugSystem.DrugItems;
import net.packprisons.core.manager.DrugSystem.Enums.Drugs;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

public class DrugEvents implements Listener {

    //private ArrayList<UUID> cooldown = new ArrayList<>();
    private HashMap<Player, Long> cooldown = new HashMap<>();

    @Deprecated
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(event.getItem());

        NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (compound != null)
                if (compound.hasKey("id")) {
                    cocaine(10, player, compound, event);
                    weed(10, player, compound, event);
                    meth(10, player, compound, event);
                }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) { // This method handles the growing and harvesting of Weed and Meth
        Player player = event.getPlayer();
        //if break nether_wart on soul sand then drop met

        if(event.getBlock().getType() == Material.WHEAT) { // WEED
            net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(Drugs.WEED.getItem());

            NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

            if (compound != null) {
                if (compound.hasKey("id")) {
                    double locY = event.getBlock().getY();
                    Location location = new Location(event.getBlock().getWorld(), event.getBlock().getX(), locY - 1, event.getBlock().getZ());
                    player.sendColorMessage(location.getBlock().getType().name());

                    DrugItems drugItems = new DrugItems();

                    event.getBlock().getDrops().add(new ItemStack(drugItems.Weed()));
                } else {
                    event.setCancelled(true);
                }
            }
        } else if (event.getBlock().getType() == Material.COCOA) { // OPIUM
            net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(Drugs.OPIUM.getItem());

            NBTTagCompound compound = (nmsItem.hasTag() ? nmsItem.getTag() : new NBTTagCompound());

            if (compound != null) {
                if (compound.hasKey("id")) {
                    double locY = event.getBlock().getY();
                    Location location = new Location(event.getBlock().getWorld(), event.getBlock().getX(), locY - 1, event.getBlock().getZ());
                    player.sendColorMessage(location.getBlock().getType().name());

                    DrugItems drugItems = new DrugItems();

                    event.getBlock().getDrops().add(new ItemStack(drugItems.Opium()));
                } else {
                    event.setCancelled(true);
                }
            }
        }


    }

    @Deprecated
    private void cocaine(int time, Player player, NBTTagCompound compound, PlayerInteractEvent event) {
        if (compound.getInt("id") == Drugs.COCAINE.getID()) {
            if (!(cooldown.containsKey(player) && cooldown.get(player) > System.currentTimeMillis())) {
                cooldown.put(player, System.currentTimeMillis() + (time * 1000));

                player.sendColorMessage("&aLets get high!");
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 2), true);
                player.playEffect(player.getLocation(), Effect.SMOKE, 1);
                player.spawnParticle(Particle.CRIT_MAGIC, player.getLocation(), 10);
                event.getItem().setAmount(event.getItem().getAmount() - 1);
            } else {
                long longRemaining = cooldown.get(player) - System.currentTimeMillis();
                int intRemaining = (int) longRemaining / 1000;

                if (intRemaining == 0) {
                    cooldown.remove(player);
                }

                player.sendColorMessage("&cYou have " + intRemaining + " remaining!");
            }
        }
    }

    @Deprecated
    private void weed(int time, Player player, NBTTagCompound compound, PlayerInteractEvent event) {
        if (compound.getInt("id") == Drugs.WEED.getID()) {
            if (!(cooldown.containsKey(player) && cooldown.get(player) > System.currentTimeMillis())) {
                cooldown.put(player, System.currentTimeMillis() + (time * 1000));

                player.sendColorMessage("&aLets get Baked!");
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 200, 2), true);
                player.playEffect(player.getLocation(), Effect.PORTAL_TRAVEL, 1);
                player.spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 10);
                event.getItem().setAmount(event.getItem().getAmount() - 1);
            } else {
                long longRemaining = cooldown.get(player) - System.currentTimeMillis();
                int intRemaining = (int) longRemaining / 1000;

                if (intRemaining == 0) {
                    cooldown.remove(player);
                }

                player.sendColorMessage("&cYou have " + intRemaining + " remaining!");
            }
        }
    }

    @Deprecated
    private void meth(int time, Player player, NBTTagCompound compound, PlayerInteractEvent event) {
        if (compound.getInt("id") == Drugs.METH.getID()) {
            if (!(cooldown.containsKey(player) && cooldown.get(player) > System.currentTimeMillis())) {
                cooldown.put(player, System.currentTimeMillis() + (time * 1000));

                player.sendColorMessage("&aLets go crazy!");
                player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 200, 2), true);
                player.playEffect(player.getLocation(), Effect.PORTAL_TRAVEL, 1);
                player.spawnParticle(Particle.SMOKE_LARGE, player.getLocation(), 10);
                event.getItem().setAmount(event.getItem().getAmount() - 1);
            } else {
                long longRemaining = cooldown.get(player) - System.currentTimeMillis();
                int intRemaining = (int) longRemaining / 1000;

                if (intRemaining == 0) {
                    cooldown.remove(player);
                }

                player.sendColorMessage("&cYou have " + intRemaining + " remaining!");
            }
        }
    }
}
