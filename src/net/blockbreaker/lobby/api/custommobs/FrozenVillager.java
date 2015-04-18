package net.blockbreaker.lobby.api.custommobs;

import net.minecraft.server.v1_8_R2.EntityVillager;
import net.minecraft.server.v1_8_R2.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftVillager;
import org.bukkit.entity.Villager;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.util.Vector;

/**
 * Created by Lukas on 18.04.2015.
 */
public class FrozenVillager extends EntityVillager {

    public FrozenVillager(World world) {
        super(world);
    }

    public String t(){
        return "";
    }

    public void e() {
        return;
    }

    @Override
    public void move(double d0, double d1, double d2) {
        return;
    }

    @Override
    public void die(){
        return;
    }

    @Override
    public void g(double x, double y, double z) {
        Vector vector = this.getBukkitEntity().getVelocity();
        super.g(vector.getX(), vector.getY(), vector.getZ());
    }


    public static Villager spawn(Location location) {
        World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();
        final FrozenVillager customEntity = new FrozenVillager(mcWorld);
        customEntity.setLocation(location.getX(), location.getY(),location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
        mcWorld.addEntity(customEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (CraftVillager) customEntity.getBukkitEntity();
    }
}
