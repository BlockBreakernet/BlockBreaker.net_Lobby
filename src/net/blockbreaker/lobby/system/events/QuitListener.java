package net.blockbreaker.lobby.system.events;

import net.blockbreaker.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Lukas on 11.04.2015.
 */
public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        Bukkit.getOnlinePlayers().forEach(player -> {
            if(player.hasPermission("server.join.message")) {
                e.setQuitMessage(ChatColor.GOLD + "Der Spieler " + ChatColor.RESET + p.getDisplayName() + ChatColor.GOLD + " hat das Netzwerk verlassen.");
            }
        });

        //Stop TimeSync
        if(Bukkit.getOnlinePlayers().size() == 0) {
            Bukkit.getScheduler().cancelTask(Lobby.getInstance().time);
        }
    }
}
