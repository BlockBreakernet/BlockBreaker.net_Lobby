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
        Player p = (Player) sender;

        NewbieSpawnHolo.setNewbieHolo1(p);
        return true;
    }
}
