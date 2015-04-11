package net.blockbreaker.lobby.system.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by Lukas on 11.04.2015.
 */
public class InventoryClick implements Listener {

    @EventHandler
    public void onInteract(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);

    }
}
