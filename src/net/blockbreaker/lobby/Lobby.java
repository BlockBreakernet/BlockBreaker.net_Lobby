package net.blockbreaker.lobby;

import net.blockbreaker.lobby.api.mysql.MySQL;
import net.blockbreaker.lobby.api.mysql.MySQLFile;
import net.blockbreaker.lobby.api.register.RegisterUtil;
import net.blockbreaker.lobby.system.events.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lukas on 09.04.2015.
 */
public class Lobby extends JavaPlugin {

    public static String cmdprefix = "[Lobby] ";

    @Override
    public void onEnable() {
        //Registriert Listener/Commands
        RegisterUtil<Lobby> register = new RegisterUtil<Lobby>(this);
        register.registerEvents(JoinListener.class);
        // SO muss man Commands registrieren: register.registerCommand("heilung", "Heilt dich!", new Heal(), "server.heal", "heilen", "heal");

        //Erstellt Default Config´s und liest Daten aus
        MySQLFile file = new MySQLFile();
        file.setStandard();
        file.readData();

        MySQL.connect();
    }

    @Override
    public void onDisable() {

    }
}
