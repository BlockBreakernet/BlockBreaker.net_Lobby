package net.blockbreaker.lobby.api.locations;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Lukas on 10.04.2015.
 */
public class LocationSetup {

    public static void sendSetupMessage(Player p) {
        p.sendMessage(" ");
        p.sendMessage(ChatColor.DARK_AQUA + "===========[" + ChatColor.GOLD + "System" + ChatColor.DARK_AQUA + "]===========");
        p.sendMessage(ChatColor.DARK_AQUA + "/set sg" + ChatColor.GRAY + " - " + ChatColor.GOLD + "Setzt SurvivalGames");
        p.sendMessage(ChatColor.DARK_AQUA + "/set sw" + ChatColor.GRAY + " - " + ChatColor.GOLD + "Setzt SkyWars");
        p.sendMessage(ChatColor.DARK_AQUA + "/set stc" + ChatColor.GRAY + " - " + ChatColor.GOLD + "Setzt SafeTheCake");
        p.sendMessage(ChatColor.DARK_AQUA + "/set pb" + ChatColor.GRAY + " - " + ChatColor.GOLD + "Setzt Paintball");
        p.sendMessage(ChatColor.DARK_AQUA + "/set rpg" + ChatColor.GRAY + " - " + ChatColor.GOLD + "Setzt den RPG-Modus");
        p.sendMessage(ChatColor.DARK_AQUA + "/set tf" + ChatColor.GRAY + " - " + ChatColor.GOLD + "Setzt TeamForce");
        p.sendMessage(ChatColor.DARK_AQUA + "/set spawn" + ChatColor.GRAY + " - " + ChatColor.GOLD + "Setzt den Spawn");
        p.sendMessage(ChatColor.DARK_AQUA + "/set newbie" + ChatColor.GRAY + " - " + ChatColor.GOLD + "Setzt den Newbie-Spawn");
        p.sendMessage(ChatColor.DARK_AQUA + "/set pre" + ChatColor.GRAY + " - " + ChatColor.GOLD + "Setzt Premium-Bereich");
        p.sendMessage(ChatColor.DARK_AQUA + "==============================");
        p.sendMessage(" ");
    }
}
