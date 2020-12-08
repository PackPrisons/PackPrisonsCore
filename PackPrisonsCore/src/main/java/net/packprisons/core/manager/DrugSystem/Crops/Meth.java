package net.packprisons.core.manager.DrugSystem.Crops;

import net.packprisons.core.PackPrisonsCore;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Meth  {

    private int timeStart = 10;
    private int timeharvest = 30;
    private int timeDecay = 60;
    private Block crop;

    public Meth(Block crop) {
        this.crop = crop;
    }

    public BukkitTask crops = new BukkitRunnable() {
        @Override
        public void run() {
            crop.getState().
        }
    }.runTaskTimerAsynchronously(PackPrisonsCore.getInstance(), 0, timeharvest);

}
