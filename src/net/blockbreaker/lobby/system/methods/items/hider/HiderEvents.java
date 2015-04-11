package net.blockbreaker.lobby.system.methods.items.hider;

import net.blockbreaker.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Lukas on 11.04.2015.
 */
public class HiderEvents implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            try {
                if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Spieler verstecken")) {
                    HiderItem.openHideInv(p);
                }
            } catch(Exception ex) {
            }
        }
    }

    @EventHandler
    public void onInvInteract(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if(e.getInventory().getName().equalsIgnoreCase(ChatColor.GOLD + "Spieler verstecken")) {
            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Alle Spieler anzeigen")) {
                    e.setCancelled(true);

                    if(Lobby.getInstance().hidden1.contains(p.getName())) {
                        Lobby.getInstance().hidden1.remove(p.getName());
                    }

                    if(Lobby.getInstance().hidden2.contains(p.getName())) {
                        Lobby.getInstance().hidden2.remove(p.getName());
                    }

                    Bukkit.getOnlinePlayers().forEach(player -> {
                        p.showPlayer(player);
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                    });
                }

                p.closeInventory();
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Nur Team-Mitglieder und Premium anzeigen")) {
                    e.setCancelled(true);

                    if(Lobby.getInstance().hidden1.contains(p.getName())) {
                        Lobby.getInstance().hidden1.remove(p.getName());
                    }

                    if(!Lobby.getInstance().hidden2.contains(p.getName())) {
                        Lobby.getInstance().hidden2.add(p.getName());
                    }

                    Bukkit.getOnlinePlayers().forEach(player -> {
                        if(player.hasPermission("server.visible")) {
                            p.showPlayer(player);
                        } else {
                            p.hidePlayer(player);
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                        }
                    });
                }

                p.closeInventory();
            } catch(Exception ex) {
            }

            try {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Alle Spieler ausblenden")) {
                    e.setCancelled(true);

                    if(Lobby.getInstance().hidden1.contains(p.getName())) {
                        Lobby.getInstance().hidden1.add(p.getName());
                    }

                    if(!Lobby.getInstance().hidden2.contains(p.getName())) {
                        Lobby.getInstance().hidden2.remove(p.getName());
                    }

                    Bukkit.getOnlinePlayers().forEach(player -> {
                        p.hidePlayer(player);
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
                    });
                }

                p.closeInventory();
            } catch(Exception ex) {
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        Bukkit.getOnlinePlayers().forEach(player -> {
            if(Lobby.getInstance().hidden1.contains(player.getName())) {
                player.hidePlayer(p);
                return;
            }

            if(Lobby.getInstance().hidden2.contains(player.getName())) {
                if(p.hasPermission("server.visible")) {
                    player.showPlayer(p);
                } else {
                    player.hidePlayer(p);
                }
                return;
            }

            if(!Lobby.getInstance().hidden1.contains(player.getName()) && Lobby.getInstance().hidden2.contains(player.getName())) {
                player.showPlayer(p);
            }
        });
    }
}
