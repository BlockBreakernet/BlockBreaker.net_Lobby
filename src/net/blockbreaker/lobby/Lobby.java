package net.blockbreaker.lobby;

import net.blockbreaker.lobby.api.mysql.MySQL;
import net.blockbreaker.lobby.api.mysql.MySQLFile;
import net.blockbreaker.lobby.api.register.RegisterUtil;
import net.blockbreaker.lobby.system.commands.SetCommand;
import net.blockbreaker.lobby.system.events.JoinListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lukas on 09.04.2015.
 */
public class Lobby extends JavaPlugin {

    public static String cmdprefix = "[Lobby] ";
    public static String noperm = ChatColor.DARK_RED + "Sorry, but you don´t have permission to perform this command.";

    public static Lobby instance;

    @Override
    public void onEnable() {
        instance = this;

        //Registriert Listener/Commands
        RegisterUtil<Lobby> register = new RegisterUtil<Lobby>(this);
        register.registerEvents(JoinListener.class);
        register.registerCommand("set", "Setzte alle Locations der Spielmodi", new SetCommand(), "server.set");

        //Erstellt Default MySQL Config´s und liest Daten aus
        MySQLFile file = new MySQLFile();
        file.setStandard();
        file.readData();

        MySQL.connect();
    }

    @Override
    public void onDisable() {

    }

    public static Lobby getInstance() {
        return instance;
    }
}
