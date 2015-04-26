package net.blockbreaker.lobby.system.commands;

import net.blockbreaker.lobby.api.hologram.Hologram;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lukas on 21.04.2015.
 */
public class HoloCommand implements CommandExecutor {

    public Map<String, Hologram> holograms = new HashMap<String, Hologram>();
    public Map<String, List<Location>> showingPlayers = new HashMap<String, List<Location>>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length < 2) {
            sender.sendMessage(ChatColor.GOLD + "/holo create <name> <text>");
            sender.sendMessage(ChatColor.GOLD + "/holo remove <name>");
            sender.sendMessage(ChatColor.GOLD + "/holo show <name> <player>");
            sender.sendMessage(ChatColor.GOLD + "/holo hide <name> <player>");
            return true;
        }

        if(args.length == 2) {
            if(args[0].equalsIgnoreCase("remove")) {
                if(holograms.containsKey(args[1])) {
                    holograms.remove(args[1]);
                    sender.sendMessage(ChatColor.GOLD + "Du hast das Hologramm " + ChatColor.DARK_AQUA + args[1] + " entfernt!");
                } else {
                    sender.sendMessage(ChatColor.GOLD + "Dieses Hologramm existiert nicht!");
                }
            }
            return true;
        }

        if(args.length == 3) {
            // Show //
            if(args[0].equalsIgnoreCase("show")) {
                if(holograms.containsKey(args[1])) {
                    if(Bukkit.getPlayer(args[2]) != null) {
                        holograms.get(args[1]).show(Bukkit.getPlayer(args[2]));
                        sender.sendMessage(ChatColor.GOLD + "Du hast das Hologramm " + ChatColor.DARK_AQUA + args[1] + ChatColor.GOLD + " für den Spieler " + ChatColor.DARK_AQUA + args[2] + ChatColor.GOLD + " sichtbar gemacht.");
                    } else {
                        sender.sendMessage(ChatColor.GOLD + "Dieser Spieler ist zur Zeit nicht Online!");
                    }
                } else {
                    sender.sendMessage(ChatColor.GOLD + "Dieses Hologramm existiert nicht!");
                }
            }

            // Hide //
            if(args[0].equalsIgnoreCase("hide")) {
                if(holograms.containsKey(args[1])) {
                    if(Bukkit.getPlayer(args[2]) != null) {
                        holograms.get(args[1]).destroy(Bukkit.getPlayer(args[2]));
                        sender.sendMessage(ChatColor.GOLD + "Du hast das Hologramm " + ChatColor.DARK_AQUA + args[1] + ChatColor.GOLD + " für den Spieler " + ChatColor.DARK_AQUA + args[2] + ChatColor.GOLD + " unsichtbar gemacht.");
                    } else {
                        sender.sendMessage(ChatColor.GOLD + "Dieser Spieler ist zur Zeit nicht Online!");
                    }
                } else {
                    sender.sendMessage(ChatColor.GOLD + "Dieses Hologramm existiert nicht!");
                }
            }

            return true;
        }

        if(args.length >= 3) {
            // Create //
            if(args[0].equalsIgnoreCase("create")) {
                if(sender instanceof Player) {
                    Player p = (Player) sender;

                    if(!holograms.containsKey(args[1])) {
                        StringBuilder sb = new StringBuilder();

                        for(int i = 3; i < args.length; i++) {
                            sb.append(args[i] + " ");
                        }

                        holograms.put(args[1], new Hologram(sb.toString().replace("&", "§"), p.getLocation()));
                        p.sendMessage(ChatColor.GOLD + "Du hast das Hologramm " + ChatColor.DARK_AQUA + args[1] + ChatColor.GOLD + " erfolgreich erstellt.");
                    } else {
                        sender.sendMessage(ChatColor.GOLD + "Dieses Hologramm existiert bereits!");
                    }
                } else {
                    sender.sendMessage(ChatColor.DARK_RED + "Du musst ein Spieler sein!");
                }
            }
            return true;
        }

        return false;
    }
}
