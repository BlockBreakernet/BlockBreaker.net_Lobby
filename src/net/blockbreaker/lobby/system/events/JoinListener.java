package net.blockbreaker.lobby.system.events;

import net.blockbreaker.lobby.api.locations.NewbieSpawn;
import net.blockbreaker.lobby.api.locations.Spawn;
import net.blockbreaker.lobby.api.mysql.MySQLMethods;
import net.blockbreaker.lobby.api.player.InventoryClear;
import net.blockbreaker.lobby.system.methods.items.InventoryItems;
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

        InventoryClear.joinPlayer(p);
        InventoryItems.getInGameItems(p);

        if(!MySQLMethods.isInDataBase(p)) {
            NewbieSpawn.teleport(p);
            MySQLMethods.createUserData(p);
        } else {
            Spawn.teleport(p);
        }
    }
}
