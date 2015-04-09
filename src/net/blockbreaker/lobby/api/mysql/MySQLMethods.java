package net.blockbreaker.lobby.api.mysql;

import org.bukkit.OfflinePlayer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lukas on 09.04.2015.
 */
public class MySQLMethods {

    public static boolean isNewbie(OfflinePlayer player) {
        String uuid = player.getUniqueId().toString();

        boolean isNewbie = false;

        ResultSet rs = MySQL.getResult("SELECT uuid FROM data WHERE uuid = '" + uuid + "'");

        try {
            if(!rs.next()) {
                isNewbie = true;
            } else {
                isNewbie = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Boolean.valueOf(isNewbie).booleanValue();
    }
}
