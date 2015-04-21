package net.blockbreaker.lobby.api.hologram;

import net.minecraft.server.v1_8_R2.EntityArmorStand;
import net.minecraft.server.v1_8_R2.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R2.PacketPlayOutSpawnEntity;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Created by Lukas on 21.04.2015.
 */
public class Hologram {

    private String text;
    private EntityArmorStand entity;
    private Location loc;
    public static final double DISTANCE = 0.23D;

    public Hologram(String text, Location loc) {
        this.text = text;
        this.loc = loc;
        this.entity = new EntityArmorStand(((CraftWorld) loc.getWorld()).getHandle(), loc.getX(), loc.getY(), loc.getZ());
        entity.setInvisible(true);
        entity.setCustomNameVisible(true);
        entity.setCustomName(text);
        entity.setGravity(false);
    }

    public void setText(String text) {
        this.text = text;
        entity.setCustomName(text);
    }

    public String getText() {
        return text;
    }

    public Location getLocation() {
        return loc;
    }

    public void setLocation(Location loc) {
        this.loc = loc;
        entity.teleportTo(loc, true);
    }

    public void show(Player p) {
        PacketPlayOutSpawnEntity packet = new PacketPlayOutSpawnEntity(entity, 0);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }

    public void destroy(Player p) {
        PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(new int[] { entity.getId() });
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }
}
