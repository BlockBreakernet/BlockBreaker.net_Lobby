package net.blockbreaker.lobby.system.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.painting.PaintingBreakByEntityEvent;
import org.bukkit.event.painting.PaintingBreakEvent;

/**
 * Created by Lukas on 12.04.2015.
 */
public class PaintingEvents implements Listener {

    @EventHandler
    public void onPaintingBreakEntity(PaintingBreakByEntityEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPaintingBreak(PaintingBreakEvent e) {
        e.setCancelled(true);
    }
}
