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
public class NewbieSpawn {
    static ConsoleCommandSender console = Bukkit.getConsoleSender();

    public static void set(Player p) {

        File file = new File(Lobby.getInstance().getDataFolder() + "/Locations", "newbie.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        Location loc = p.getEyeLocation();

        String world = p.getWorld().getName();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        double yaw = loc.getYaw();
        double pitch = loc.getPitch();

        cfg.set("newbie.world", world);
        cfg.set("newbie.x", x);
        cfg.set("newbie.y", y);
        cfg.set("newbie.z", z);
        cfg.set("newbie.yaw", yaw);
        cfg.set("newbie.pitch", pitch);

        try {
            cfg.save(file);
        } catch (IOException e) {
            p.sendMessage(ChatColor.DARK_RED + "Die Location konnte nicht gespeichert werden.");
            console.sendMessage(ChatColor.DARK_RED + "Die Location konnte nicht gespeichert werden.");
        }

        p.sendMessage(ChatColor.DARK_AQUA + "Du hast erfolgreich den " + ChatColor.GOLD + "Newbie Spawn " + ChatColor.DARK_AQUA + "gesetzt!");
        p.playSound(loc, Sound.LEVEL_UP, 1.0F, 1.0F);
    }

    public static void teleport(Player p) {

        File file = new File(Lobby.getInstance().getDataFolder() + "/Locations", "newbie.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        String world = cfg.getString("newbie.world");
        double x = cfg.getDouble("newbie.x");
        double y = cfg.getDouble("newbie.y");
        double z = cfg.getDouble("newbie.z");
        double yaw = cfg.getDouble("newbie.yaw");
        double pitch = cfg.getDouble("newbie.pitch");

        Location loc = new Location(Bukkit.getWorld(world), x, y, z);
        loc.setYaw((float) yaw);
        loc.setPitch((float) pitch);

        p.teleport(loc);
    }
}
