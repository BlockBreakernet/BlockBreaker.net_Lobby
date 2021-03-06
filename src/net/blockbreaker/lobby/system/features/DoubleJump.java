package net.blockbreaker.lobby.system.features;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Lukas on 11.04.2015.
 */
public class DoubleJump implements Listener {

    HashMap<Player, Boolean> cooldown = new HashMap<Player, Boolean>();
    ArrayList<Player> fixed = new ArrayList<Player>();

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            if (e.getEntity().getType() == EntityType.PLAYER) {
                Player p = (Player) e.getEntity();

                if (p.hasPermission("server.doublejump")) {
                    e.setCancelled(true);
                }

                if (!p.hasPermission("server.doublejump")) return;
            }
        }
    }


    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (!p.hasPermission("server.doublejump") && p.getAllowFlight() == true && !fixed.contains(p)) {
            p.setFlying(false);
            p.setAllowFlight(false);
            fixed.add(p);
        }

        if (p.getGameMode() == GameMode.CREATIVE) return;
        if (!p.hasPermission("server.doublejump")) return;

        if (cooldown.get(p) != null && cooldown.get(p) == true) {
            p.setAllowFlight(true);
        } else {
            p.setAllowFlight(false);
        }

        if (p.isOnGround()) {
            cooldown.put(p, true);
        }

        if (cooldown.get(p) != null && cooldown.get(p) == false) {
            for (Player pl : Bukkit.getOnlinePlayers()) {
                pl.playEffect(p.getLocation(), Effect.SMOKE, 2004);
            }
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onFly(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();

        if (p.getGameMode() == GameMode.CREATIVE) return;
        if (p.hasPermission("server.doublejump")) {
            if (cooldown.get(p) == true) {
                e.setCancelled(true);
                cooldown.put(p, false);
                p.setVelocity(p.getLocation().getDirection().multiply(1.6D).setY(1.0D));

                for (Player pl : Bukkit.getOnlinePlayers()) {
                    pl.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 2004);
                }

                p.playSound(p.getLocation(), Sound.CREEPER_HISS, 10, 1);

                p.setAllowFlight(false);
            }
        }
    }


    @SuppressWarnings("deprecation")
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();

        if (p.getGameMode() == GameMode.CREATIVE) return;

        if (p.isOnGround() == false && cooldown.get(p) != null && cooldown.get(p) == false) {
            p.setVelocity(new Vector(0, -5, 0));
        }
    }
}
