package net.blockbreaker.lobby.system.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Lukas on 21.04.2015.
 */
public class HoloCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length < 2 || args.length > 3) {
            sender.sendMessage(ChatColor.GOLD + "/holo create <name> <text>");
            sender.sendMessage(ChatColor.GOLD + "/holo remove <name>");
            sender.sendMessage(ChatColor.GOLD + "/holo show <name> <player>");
            sender.sendMessage(ChatColor.GOLD + "/holo hide <name> <player>");
            return true;
        }

        if(args.length == 2) {

            return true;
        }
        return false;
    }
}
