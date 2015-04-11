package net.blockbreaker.lobby.api.bungeecord;

import net.blockbreaker.lobby.Lobby;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

/**
 * Created by Lukas on 11.04.2015.
 */
public class Server {

    public static void join(Player p, String servername) {

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);

        try {
            out.writeUTF("Connect");
            out.writeUTF(servername);
        } catch(Exception ex) {
        }

        p.sendPluginMessage(Lobby.getInstance(), "BungeeCord", b.toByteArray());
    }
}
