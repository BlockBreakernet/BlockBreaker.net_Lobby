package net.blockbreaker.lobby.system.commands;

import net.blockbreaker.lobby.api.holo.NewbieSpawnHolo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Lukas on 13.04.2015.
 */
public class SetHolo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            System.out.println("1");
            if(cmd.getName().equalsIgnoreCase("holo")) {
                System.out.println("2");
                if (p.hasPermission("server.set.holo")) {
                    System.out.println("3");
                    NewbieSpawnHolo.setNewbieHolo1(p);
                    System.out.println("4");
                    return true;
                }
            }

            return true;
        }

        return true;
    }
}
