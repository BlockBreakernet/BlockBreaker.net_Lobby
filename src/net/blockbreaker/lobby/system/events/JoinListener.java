package net.blockbreaker.lobby.system.events;

import net.blockbreaker.lobby.api.mysql.MySQLMethods;
import net.blockbreaker.lobby.api.player.InventoryClear;
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

        if(MySQLMethods.isNewbie(p)) {

        } else {

        }

        InventoryClear.joinPlayer(p);
    }
}
