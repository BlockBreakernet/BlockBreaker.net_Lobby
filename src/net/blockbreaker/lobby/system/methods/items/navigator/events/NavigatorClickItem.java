package net.blockbreaker.lobby.system.methods.items.navigator.events;

import net.blockbreaker.lobby.api.locations.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by Lukas on 11.04.2015.
 */
public class NavigatorClickItem implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);

        if (e.getInventory().getName().equalsIgnoreCase(ChatColor.YELLOW + "Wähle deinen Spielmodus")) {
            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "SurvivalGames")) {
                    SurvivalGames.teleport(p);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "Team-Force")) {
                    TeamForce.teleport(p);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "RPG")) {
                    RPG.teleport(p);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Paintball")) {
                    PaintBall.teleport(p);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "SafeTheCake")) {
                    SafeTheCake.teleport(p);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "SkyWars")) {
                    SkyWars.teleport(p);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "Spawn")) {
                    Spawn.teleport(p);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Newbie-Spawn")) {
                    NewbieSpawn.teleport(p);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Premium Bereich")) {
                    PremiumSector.teleport(p);
                }
            } catch(Exception ex) {
            }
        }
    }
}
