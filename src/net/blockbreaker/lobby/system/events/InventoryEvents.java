package net.blockbreaker.lobby.system.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;

/**
 * Created by Lukas on 12.04.2015.
 */
public class InventoryEvents implements Listener {

    @EventHandler
    public void onBrew(BrewEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onFurnaceBurn(FurnaceBurnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onFurnaceExtract(FurnaceExtractEvent e) {
        e.setExpToDrop(0);
    }

    @EventHandler
    public void onFurnaceSmelt(FurnaceSmeltEvent e) {
        e.setCancelled(true);
    }
}
