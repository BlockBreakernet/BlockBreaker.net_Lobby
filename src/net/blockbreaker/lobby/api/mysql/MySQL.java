package net.blockbreaker.lobby.api.mysql;

import net.blockbreaker.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

import java.sql.*;

/**
 * Created by Lukas on 09.04.2015.
 */
public class MySQL {

    public static String host;
    public static String port;
    public static String database;
    public static String username;
    public static String password;
    public static Connection con;

    static ConsoleCommandSender console = Bukkit.getConsoleSender();

    //Connect to MySQL
    public static void connect() {
        if(!isConnected()) {
            try {
                console.sendMessage(" ");
                console.sendMessage(Lobby.cmdprefix + ChatColor.DARK_GREEN + "Initialisiere MySQL Backend...");
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                console.sendMessage(Lobby.cmdprefix + ChatColor.DARK_GREEN + "MySQL Verbindung aufgebaut!");
                console.sendMessage(" ");
            } catch (SQLException e) {
                console.sendMessage(Lobby.cmdprefix + ChatColor.DARK_RED + "Verbindung konnte nicht hergestellt werden!");
                console.sendMessage(Lobby.cmdprefix + ChatColor.DARK_RED + "SQLException: " + e.getMessage());
                console.sendMessage(Lobby.cmdprefix + ChatColor.DARK_RED + "SQLState: " + e.getSQLState());
                console.sendMessage(Lobby.cmdprefix + ChatColor.DARK_RED + "VendorError: " + e.getErrorCode());
            }
        }
    }

    //Disconnect MySQL
    public static void disconnect() {
        if(isConnected()) {
            try {
                con.close();
                console.sendMessage(" ");
                console.sendMessage(Lobby.cmdprefix + ChatColor.DARK_GREEN + "MySQL Verbindung geschlossen!");
                console.sendMessage(" ");
            } catch (SQLException e) {
                console.sendMessage(" ");
                console.sendMessage(Lobby.cmdprefix + ChatColor.DARK_RED + "Verbindung konnte nicht hergestellt werden!");
                console.sendMessage(Lobby.cmdprefix + ChatColor.DARK_RED + "SQLException: " + e.getMessage());
                console.sendMessage(Lobby.cmdprefix + ChatColor.DARK_RED + "SQLState: " + e.getSQLState());
                console.sendMessage(Lobby.cmdprefix + ChatColor.DARK_RED + "VendorError: " + e.getErrorCode());
                console.sendMessage(" ");
            }
        }
    }

    //Returns Connection
    public static boolean isConnected() {
        return (con == null ? false : true);
    }

    //Process a Statement
    public static void update(String qry) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(qry);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Returns a Result
    public static ResultSet getResult(String qry) {
        try {
            PreparedStatement ps = con.prepareStatement(qry);
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
