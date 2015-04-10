package net.blockbreaker.lobby.system.commands;

import net.blockbreaker.lobby.Lobby;
import net.blockbreaker.lobby.api.locations.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Lukas on 10.04.2015.
 */
public class SetCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if(cs instanceof Player) {
            Player p = ((Player) cs).getPlayer();

            if(p.hasPermission("server.set")) {
                if(args.length == 0) {
                    LocationSetup.sendSetupMessage(p);
                    return true;
                }

                if(args.length > 1) {
                    LocationSetup.sendSetupMessage(p);
                    return true;
                }

                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("sg")) {
                        SurvivalGames.set(p);
                        return true;
                    }

                    if(args[0].equalsIgnoreCase("sw")) {
                        SkyWars.set(p);
                        return true;
                    }

                    if(args[0].equalsIgnoreCase("stc")) {
                        SafeTheCake.set(p);
                        return true;
                    }

                    if(args[0].equalsIgnoreCase("pb")) {
                        PaintBall.set(p);
                        return true;
                    }

                    if(args[0].equalsIgnoreCase("rpg")) {
                        RPG.set(p);
                        return true;
                    }

                    if(args[0].equalsIgnoreCase("tf")) {
                        TeamForce.set(p);
                        return true;
                    }

                    if(args[0].equalsIgnoreCase("spawn")) {
                        Spawn.set(p);
                        return true;
                    }

                    if(args[0].equalsIgnoreCase("newbie")) {
                        NewbieSpawn.set(p);
                        return true;
                    }

                    if(args[0].equalsIgnoreCase("prem")) {
                        PremiumSector.set(p);
                        return true;
                    }
                }
            } else {
                p.sendMessage(Lobby.noperm);
                return true;
            }
        } else {
            cs.sendMessage(ChatColor.RED + "Dir ist es nicht möglich die Locations der Spielmodi zu setzten. Dies muss ein Spieler InGame machen.");
            return true;
        }

        return true;
    }
}
