package net.blockbreaker.lobby.system.methods.items.shield;

import de.slikey.effectlib.util.ParticleEffect;
import net.blockbreaker.lobby.Lobby;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

/**
 * Created by Lukas on 11.04.2015.
 */
public class Shield implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            try {

                if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Schutzschild")) {

                    if (!Lobby.getInstance().saving.contains(p.getName())) {
                        Lobby.getInstance().saving.add(p.getName());

                        Lobby.getInstance().schild.put(p.getName(), new BukkitRunnable() {

                            @Override
                            public void run() {

                                p.getWorld().playEffect(p.getEyeLocation(), Effect.ENDER_SIGNAL, 1);
                                p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);

                                ParticleEffect.PORTAL.display(1, 1, 1, 1, 50, p.getLocation(), 1);
                                ParticleEffect.PORTAL.display(1, 1, 1, 1, 50, p.getEyeLocation(), 1);

                                for (Entity en : p.getNearbyEntities(4, 4, 4)) {
                                    if (en instanceof Player) {
                                        Player target = (Player) en;

                                        double ax = p.getLocation().getX();
                                        double ay = p.getLocation().getY();
                                        double az = p.getLocation().getZ();

                                        double bx = target.getLocation().getX();
                                        double by = target.getLocation().getY();
                                        double bz = target.getLocation().getZ();

                                        double x = bx - ax;
                                        double y = by - ay;
                                        double z = bz - az;

                                        Vector v = new Vector(x, y, z).normalize().multiply(2D).setY(1D);

                                        if (target.hasPermission("server.bypass.schild") | target.isOp()) {
                                            return;
                                        } else {
                                            target.setVelocity(v);
                                        }
                                    }
                                }

                            }
                        });
                        Lobby.getInstance().schild.get(p.getName()).runTaskTimer(Lobby.getInstance(), 0, (long) (20 * 0.1));

                        p.sendMessage(ChatColor.DARK_PURPLE + "Du hast dein Schutzschild aktiviert.");

                        p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 5, 0);
                        return;
                    }

                    if (Lobby.getInstance().saving.contains(p.getName())) {
                        Lobby.getInstance().saving.remove(p.getName());

                        Lobby.getInstance().schild.get(p.getName());
                        Lobby.getInstance().schild.get(p.getName()).cancel();
                        Lobby.getInstance().schild.remove(p.getName());

                        p.sendMessage(ChatColor.DARK_PURPLE + "Du hast dein Schutzschild deaktiviert.");
                        return;
                    }
                }

            } catch (Exception ex) {
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        if (Lobby.getInstance().saving.contains(p.getName())) {
            Lobby.getInstance().saving.remove(p.getName());

            Lobby.getInstance().schild.get(p.getName());
            Lobby.getInstance().schild.get(p.getName()).cancel();
            Lobby.getInstance().schild.remove(p.getName());
        }
    }
}
