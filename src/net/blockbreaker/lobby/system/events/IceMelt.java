package net.blockbreaker.lobby.system.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

/**
 * Created by Lukas on 12.04.2015.
 */
public class IceMelt implements Listener {

    @EventHandler
    public void onMelt(BlockFadeEvent e) {
        e.setCancelled(true);
    }
}
