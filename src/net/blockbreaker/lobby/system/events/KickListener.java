package net.blockbreaker.lobby.system.events;

import net.blockbreaker.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

/**
 * Created by Lukas on 13.04.2015.
 */
public class KickListener implements Listener {

    @EventHandler
    public void onKick(PlayerKickEvent e) {

        //Stop TimeSync
        if(Bukkit.getOnlinePlayers().size() == 0) {
            Bukkit.getScheduler().cancelTask(Lobby.getInstance().time);
        }
    }
}
