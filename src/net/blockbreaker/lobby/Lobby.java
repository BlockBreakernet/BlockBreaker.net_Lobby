package net.blockbreaker.lobby;

import net.blockbreaker.lobby.api.mysql.MySQL;
import net.blockbreaker.lobby.api.mysql.MySQLFile;
import net.blockbreaker.lobby.api.register.RegisterUtil;
import net.blockbreaker.lobby.system.commands.SetCommand;
import net.blockbreaker.lobby.system.events.*;
import net.blockbreaker.lobby.system.features.DoubleJump;
import net.blockbreaker.lobby.system.methods.items.hider.HiderEvents;
import net.blockbreaker.lobby.system.methods.items.navigator.events.NavigatorClickItem;
import net.blockbreaker.lobby.system.methods.items.navigator.events.NavigatorInteract;
import net.blockbreaker.lobby.system.methods.items.shield.Shield;
import net.blockbreaker.lobby.system.methods.items.silent.SilentLobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Lukas on 09.04.2015.
 */
public class Lobby extends JavaPlugin {

    public static String cmdprefix = "[Lobby] ";
    public static String noperm = ChatColor.DARK_RED + "Sorry, but you don´t have permission to perform this command.";

    public static ArrayList<String> hidden1 = new ArrayList<String>();
    public static ArrayList<String> hidden2 = new ArrayList<String>();
    public static ArrayList<String> saving = new ArrayList<String>();

    public static HashMap<String, BukkitRunnable> schild = new HashMap<String, BukkitRunnable>();

    public static Lobby instance;

    @Override
    public void onEnable() {
        instance = this;

        //Registriert Listener/Commands
        RegisterUtil<Lobby> register = new RegisterUtil<Lobby>(this);
        register.registerEvents(JoinListener.class, InventoryClick.class, Hunger.class, NavigatorInteract.class, NavigatorClickItem.class, PlayerDamage.class, HiderEvents.class, ItemEvents.class, SilentLobby.class, Shield.class, QuitListener.class, DoubleJump.class, IceMelt.class, EntityEvents.class, BlockEvents.class, InventoryEvents.class, PaintingEvents.class);
        register.registerCommand("set", "Setzte alle Locations der Spielmodi", new SetCommand(), "server.set");

        //Erstellt Default MySQL Config´s und liest Daten aus
        MySQLFile file = new MySQLFile();
        file.setStandard();
        file.readData();

        MySQL.connect();

        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        MySQL.disconnect();
    }

    public static Lobby getInstance() {
        return instance;
    }
}
