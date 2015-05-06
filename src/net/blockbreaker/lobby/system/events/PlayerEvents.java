package net.blockbreaker.lobby.system.events;

import net.blockbreaker.lobby.api.locations.Spawn;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

/**
 * Created by Lukas on 21.04.2015.
 */
public class PlayerEvents implements Listener {

    @EventHandler
    public void onAchievementGet(PlayerAchievementAwardedEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerBedEnterEvent(PlayerBedEnterEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerEditBookEvent(PlayerEditBookEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerExpChangeEvent(PlayerExpChangeEvent e) {
        e.setAmount(0);
    }

    @EventHandler
    public void onPlayerFishEvent(PlayerFishEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerItemConsumeEvent(PlayerItemConsumeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerItemDamageEvent(PlayerItemDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onMoveToLow(PlayerMoveEvent e) {
        if(e.getPlayer().getLocation().getY() < 10) {
            Spawn.teleport(e.getPlayer());
        }
    }
}
