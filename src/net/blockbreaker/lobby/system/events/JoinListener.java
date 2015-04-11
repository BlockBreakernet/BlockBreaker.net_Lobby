package net.blockbreaker.lobby.system.events;

import com.connorlinfoot.titleapi.TitleAPI;
import net.blockbreaker.lobby.api.locations.NewbieSpawn;
import net.blockbreaker.lobby.api.locations.Spawn;
import net.blockbreaker.lobby.api.mysql.MySQLMethods;
import net.blockbreaker.lobby.api.player.InventoryClear;
import net.blockbreaker.lobby.system.methods.items.InventoryItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Lukas on 09.04.2015.
 */
public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        e.setJoinMessage(null);

        Bukkit.getOnlinePlayers().forEach(player -> {
            if (player.hasPermission("server.join.message")) {
                e.setJoinMessage(ChatColor.GOLD + "Der Spieler " + ChatColor.RESET + p.getDisplayName() + ChatColor.GOLD + " hat das Netzwerk betreten.");
            }
        });

        InventoryClear.joinPlayer(p);
        InventoryItems.getInGameItems(p);

        if(!MySQLMethods.isInDataBase(p)) {
            NewbieSpawn.teleport(p);
            MySQLMethods.createUserData(p);
        } else {
            Spawn.teleport(p);
        }

        TitleAPI.sendTitle(p, 1*20, 2*20, 1*20, ChatColor.YELLOW + "Herzlich Willkommen" + ChatColor.GRAY + ", " + ChatColor.RESET + p.getDisplayName() + ChatColor.YELLOW + " auf dem", ChatColor.YELLOW + "BlockBreaker.net Netzwerk.");
    }
}
