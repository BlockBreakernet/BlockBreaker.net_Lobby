package net.blockbreaker.lobby.system.methods.items.navigator.events;

import net.blockbreaker.lobby.system.methods.items.navigator.NavigatorItem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Lukas on 11.04.2015.
 */
public class NavigatorInteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            try {
                if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Navigator")) {
                    NavigatorItem.loadNavigatorInv(p);
                }
            } catch(Exception ex) {
            }
        }
    }
}
