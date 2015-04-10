package net.blockbreaker.lobby.api.locations;

import net.blockbreaker.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

/**
 * Created by Lukas on 10.04.2015.
 */
public class PaintBall {
    static ConsoleCommandSender console = Bukkit.getConsoleSender();

    public static void set(Player p) {

        File file = new File(Lobby.getInstance().getDataFolder() + "/Locations", "pb.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        Location loc = p.getEyeLocation();

        String world = p.getWorld().getName();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        double yaw = loc.getYaw();
        double pitch = loc.getPitch();

        cfg.set("pb.world", world);
        cfg.set("pb.x", x);
        cfg.set("pb.y", y);
        cfg.set("pb.z", z);
        cfg.set("pb.yaw", yaw);
        cfg.set("pb.pitch", pitch);

        try {
            cfg.save(file);
        } catch (IOException e) {
            p.sendMessage(ChatColor.DARK_RED + "Die Location konnte nicht gespeichert werden.");
            console.sendMessage(ChatColor.DARK_RED + "Die Location konnte nicht gespeichert werden.");
        }

        p.sendMessage(ChatColor.DARK_AQUA + "Du hast erfolgreich " + ChatColor.GOLD + "PaintBall " + ChatColor.DARK_AQUA + "gesetzt!");
        p.playSound(loc, Sound.LEVEL_UP, 1.0F, 1.0F);
    }

    public static void teleport(Player p) {

        File file = new File(Lobby.getInstance().getDataFolder() + "/Locations", "pb.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        String world = cfg.getString("pb.world");
        double x = cfg.getDouble("pb.x");
        double y = cfg.getDouble("pb.y");
        double z = cfg.getDouble("pb.z");
        double yaw = cfg.getDouble("pb.yaw");
        double pitch = cfg.getDouble("pb.pitch");

        Location loc = new Location(Bukkit.getWorld(world), x, y, z);
        loc.setYaw((float) yaw);
        loc.setPitch((float) pitch);

        p.teleport(loc);
    }
}
