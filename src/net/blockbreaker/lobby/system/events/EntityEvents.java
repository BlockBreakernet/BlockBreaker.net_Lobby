package net.blockbreaker.lobby.system.events;

import net.blockbreaker.lobby.api.locations.Spawn;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.world.PortalCreateEvent;

/**
 * Created by Lukas on 12.04.2015.
 */
public class EntityEvents implements Listener {

    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {
        if(!(e.getEntity() instanceof Villager)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPortalEnter(EntityPortalEnterEvent e) {
        Player p = (Player) e.getEntity();

        Spawn.teleport(p);
    }

    @EventHandler
    public void onChangeBlock(EntityChangeBlockEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onSpawnerSpawn(SpawnerSpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onSheepDyeWool(SheepDyeWoolEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onTame(EntityTameEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onCombustByBlock(EntityCombustByBlockEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onCombustByEntity(EntityCombustByEntityEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDoorBreak(EntityBreakDoorEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPortalCreate(PortalCreateEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onShootBow(EntityShootBowEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onExp(ExpBottleEvent e) {
        e.setExperience(0);
    }

    @EventHandler
    public void onLeash(PlayerLeashEntityEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPotionSplash(PotionSplashEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onSlimeSplit(SlimeSplitEvent e) {
        e.setCancelled(true);
    }
}
