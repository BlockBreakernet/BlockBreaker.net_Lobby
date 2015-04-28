package net.blockbreaker.lobby.system.methods.items.navigator.events;

import net.blockbreaker.lobby.api.locations.*;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
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
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "Team-Force")) {
                    TeamForce.teleport(p);
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "RPG")) {
                    RPG.teleport(p);
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Paintball")) {
                    PaintBall.teleport(p);
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "SafeTheCake")) {
                    SafeTheCake.teleport(p);
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "SkyWars")) {
                    SkyWars.teleport(p);
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "Spawn")) {
                    Spawn.teleport(p);
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Newbie-Spawn")) {
                    NewbieSpawn.teleport(p);
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Premium Bereich")) {
                    PremiumSector.teleport(p);
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            } catch(Exception ex) {
            }
        }
    }
}
