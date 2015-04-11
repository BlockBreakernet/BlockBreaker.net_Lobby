package net.blockbreaker.lobby.system.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Lukas on 11.04.2015.
 */
public class PlayerDamage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        e.setCancelled(true);
    }
}
