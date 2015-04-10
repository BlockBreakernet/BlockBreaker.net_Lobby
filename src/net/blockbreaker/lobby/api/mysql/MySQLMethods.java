package net.blockbreaker.lobby.api.mysql;

import org.bukkit.OfflinePlayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Locale;

/**
 * Created by Lukas on 09.04.2015.
 */
public class MySQLMethods {

    public static boolean isInDataBase(OfflinePlayer target) {
        String uuid = target.getUniqueId().toString();

        boolean isInDatabase = false;

        ResultSet rs = MySQL.getResult("SELECT uuid FROM data WHERE uuid = '" + uuid + "'");

        try {
            if(!rs.next()) {
                isInDatabase = true;
            } else {
                isInDatabase = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Boolean.valueOf(!isInDatabase).booleanValue();
    }

    public static void createUserData(OfflinePlayer pp) {
        String UUID = pp.getUniqueId().toString();

        if(isInDataBase(pp)) {

            DateFormat dmy = DateFormat.getDateInstance(DateFormat.SHORT, Locale.GERMANY);
            String lastLoginAsString = dmy.format(System.currentTimeMillis());

            boolean nick = false;
            int logincounter = 0;

            ResultSet rs = MySQL.getResult("SELECT uuid FROM data WHERE uuid = '" + UUID + "'");
            try {
                if (!rs.next()) {
                    MySQL.update("INSERT INTO data VALUES('" + pp.getName() + "', '" + UUID + "', '" + lastLoginAsString + "', '" + logincounter + "' , " + nick + ")");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
