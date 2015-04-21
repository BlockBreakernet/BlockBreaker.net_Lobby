package net.blockbreaker.lobby.system.features;

import de.slikey.effectlib.util.ParticleEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

/**
 * Created by Lukas on 13.04.2015.
 */
public class JumpPlates implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if(p.getLocation().getBlock().getType() == Material.GOLD_PLATE) {
            if(p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.STONE) {

                Vector v = p.getLocation().getDirection().multiply(4.0D).setY(1.0D);
                p.setVelocity(v);

                ParticleEffect.PORTAL.display(p.getLocation(), 1, 1, 1, 1, 1, 50);

                p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0F, 1.0F);
            }

            if(p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.COBBLESTONE) {

                Vector v = p.getLocation().getDirection().multiply(5.0D).setY(1.0D);
                p.setVelocity(v);

                ParticleEffect.PORTAL.display(p.getLocation(), 1, 1, 1, 1, 1, 50);

                p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0F, 1.0F);
            }

            if(p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.GOLD_BLOCK) {

                Vector v = p.getLocation().getDirection().multiply(6.0D).setY(1.0D);
                p.setVelocity(v);

                ParticleEffect.PORTAL.display(p.getLocation(), 1, 1, 1, 1, 1, 50);

                p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0F, 1.0F);
            }
        }
    }
}
